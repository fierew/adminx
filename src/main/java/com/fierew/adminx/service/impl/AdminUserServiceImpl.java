package com.fierew.adminx.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fierew.adminx.dao.AdminRoleDAO;
import com.fierew.adminx.dao.AdminUserDAO;
import com.fierew.adminx.dao.AdminUserRoleDAO;
import com.fierew.adminx.domain.AdminRoleDO;
import com.fierew.adminx.domain.AdminUserDO;
import com.fierew.adminx.domain.AdminUserRoleDO;
import com.fierew.adminx.vo.AdminRoleVO;
import com.fierew.adminx.vo.AdminUserVO;
import com.fierew.adminx.service.AdminUserService;
import com.fierew.adminx.dto.AdminUserDTO;
import com.fierew.adminx.dto.TableDTO;
import com.fierew.adminx.vo.PageVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author xuyang
 */
@Service
public class AdminUserServiceImpl implements AdminUserService {
    private AdminUserDAO adminUserDAO;
    private AdminUserRoleDAO adminUserRoleDAO;
    private AdminRoleDAO adminRoleDAO;

    @Autowired
    public void setDAO(
            AdminUserDAO adminUserDAO,
            AdminUserRoleDAO adminUserRoleDAO,
            AdminRoleDAO adminRoleDAO
    ) {
        this.adminUserDAO = adminUserDAO;
        this.adminUserRoleDAO = adminUserRoleDAO;
        this.adminRoleDAO = adminRoleDAO;
    }


    @Override
    public PageVO<AdminUserVO> getList(TableDTO tableDTO, AdminUserDTO adminUserDTO) {
        // 条件构造器
        QueryWrapper<AdminUserDO> userQueryWrapper = new QueryWrapper<>();

        if (adminUserDTO.getDeptId() != null) {
            userQueryWrapper.like("dept_id", adminUserDTO.getDeptId());
        }
        // 模糊查询Like
        if (adminUserDTO.getRealName() != null) {
            userQueryWrapper.like("real_name", adminUserDTO.getRealName());
        }

        // 分页插件
        IPage<AdminUserDO> userPage = new Page<>(tableDTO.getPage(), tableDTO.getPageSize());
        userPage = adminUserDAO.selectPage(userPage, userQueryWrapper);
        List<AdminUserDO> userList = userPage.getRecords();
        Long total = userPage.getTotal();

        List<Integer> userIdList = userList.stream().map(AdminUserDO::getId).collect(Collectors.toList());
        // 获取用户角色id
        // 条件构造器
        QueryWrapper<AdminUserRoleDO> adminUserRoleQueryWrapper = new QueryWrapper<>();
        adminUserRoleQueryWrapper.in("user_id", userIdList);
        List<AdminUserRoleDO> adminUserRoleDOList = adminUserRoleDAO.selectList(adminUserRoleQueryWrapper);

        List<Integer> roleIdList = adminUserRoleDOList.stream().map(AdminUserRoleDO::getRoleId).collect(Collectors.toList());

        // 获取角色信息
        List<AdminRoleDO> adminRoleDOList = adminRoleDAO.selectBatchIds(roleIdList);

        // 组合用户id和角色信息
        List<AdminRoleVO> adminRoleVOList = new ArrayList<>();
        for (AdminUserRoleDO adminUserRole : adminUserRoleDOList) {

            for (AdminRoleDO adminRoleDO : adminRoleDOList) {
                if (adminUserRole.getRoleId().equals(adminRoleDO.getId())) {
                    AdminRoleVO adminRoleVO = new AdminRoleVO();
                    BeanUtils.copyProperties(adminRoleDO, adminRoleVO);
                    adminRoleVO.setUserId(adminUserRole.getUserId());

                    adminRoleVOList.add(adminRoleVO);
                    break;
                }
            }
        }

        List<AdminUserVO> adminUserList = new ArrayList<>();
        for (AdminUserDO user : userList) {
            AdminUserVO adminUserVO = new AdminUserVO();
            BeanUtils.copyProperties(user, adminUserVO);

            List<AdminRoleVO> adminRoleVOS = new ArrayList<>();
            for (AdminRoleVO adminRoleVO : adminRoleVOList) {
                if (adminRoleVO.getUserId().equals(user.getId())) {
                    adminRoleVOS.add(adminRoleVO);
                }
            }

            adminUserVO.setRoles(adminRoleVOS);
            adminUserList.add(adminUserVO);
        }

        PageVO<AdminUserVO> pageVO = new PageVO<>();
        pageVO.setLists(adminUserList);
        pageVO.setTotal(total);

        return pageVO;
    }

    @Override
    @Transactional
    public Integer add(AdminUserDTO adminUserDTO) {
        AdminUserDO adminUserDO = new AdminUserDO();
        BeanUtils.copyProperties(adminUserDTO, adminUserDO);

        Integer result = adminUserDAO.insert(adminUserDO);
        Integer userId = adminUserDO.getId();

        // 新增角色关联数据
        addUserRole(userId, adminUserDTO.getRoleIds());

        return result;
    }

    @Override
    @Transactional
    public Integer del(Integer id) {
        // 删除用户与角色关联关系
        delUserRole(id);

        // 删除用户
        AdminUserDO adminUserDO = new AdminUserDO();
        adminUserDO.setId(id);
        adminUserDO.setIsDeleted((byte) 1);
        return adminUserDAO.updateById(adminUserDO);
    }

    @Override
    @Transactional
    public Integer modify(Integer id, AdminUserDTO adminUserDTO) {
        // 删除角色关联数据
        delUserRole(id);

        // 新增角色关联数据
        addUserRole(id, adminUserDTO.getRoleIds());

        AdminUserDO adminUserDO = new AdminUserDO();
        BeanUtils.copyProperties(adminUserDTO, adminUserDO);
        adminUserDO.setId(id);
        return adminUserDAO.updateById(adminUserDO);
    }

    private void delUserRole(Integer userId) {
        AdminUserRoleDO adminUserRoleDO = new AdminUserRoleDO();
        adminUserRoleDO.setIsDeleted((byte) 1);

        UpdateWrapper<AdminUserRoleDO> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("user_id", userId);
        adminUserRoleDAO.update(adminUserRoleDO, updateWrapper);
    }

    private void addUserRole(Integer userId, String roleIds){
        String[] roleArray = roleIds.split(",");
        Arrays.stream(roleArray).map(Integer::parseInt).forEach(item -> {
            AdminUserRoleDO adminUserRoleDO = new AdminUserRoleDO();
            adminUserRoleDO.setUserId(userId);
            adminUserRoleDO.setRoleId(item);
            adminUserRoleDAO.insert(adminUserRoleDO);
        });
    }
}
