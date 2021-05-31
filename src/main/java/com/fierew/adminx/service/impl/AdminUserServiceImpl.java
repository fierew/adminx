package com.fierew.adminx.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fierew.adminx.dao.AdminUserDAO;
import com.fierew.adminx.domain.AdminDeptDO;
import com.fierew.adminx.domain.AdminRoleDO;
import com.fierew.adminx.domain.AdminUserDO;
import com.fierew.adminx.vo.AdminUserVO;
import com.fierew.adminx.service.AsyncAdminDeptService;
import com.fierew.adminx.service.AsyncAdminRoleService;
import com.fierew.adminx.service.AdminUserService;
import com.fierew.adminx.dto.AdminUserDTO;
import com.fierew.adminx.dto.TableDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

/**
 * @author xuyang
 */
@Service
public class AdminUserServiceImpl implements AdminUserService {
    private AdminUserDAO adminUserDAO;
    private AsyncAdminRoleService asyncAdminRoleService;
    private AsyncAdminDeptService asyncAdminDeptService;

    @Autowired
    public void setAdminUserDAO(AdminUserDAO adminUserDAO) {
        this.adminUserDAO = adminUserDAO;
    }

    @Autowired
    public void setAsyncAdminRoleService(AsyncAdminRoleService asyncAdminRoleService) {
        this.asyncAdminRoleService = asyncAdminRoleService;
    }

    @Autowired
    public void setAsyncAdminDeptService(AsyncAdminDeptService asyncAdminDeptService) {
        this.asyncAdminDeptService = asyncAdminDeptService;
    }

    @Override
    public List<AdminUserVO> getList(TableDTO tableDTO, AdminUserDTO adminUserDTO) throws ExecutionException, InterruptedException {
        // 条件构造器
        QueryWrapper<AdminUserDO> userQueryWrapper = new QueryWrapper<>();
        // 模糊查询Like
        userQueryWrapper.like("real_name", adminUserDTO.getRealName());

        // 分页插件
        IPage<AdminUserDO> userPage = new Page<>(tableDTO.getPage(), tableDTO.getPageSize());
        userPage = adminUserDAO.selectPage(userPage, userQueryWrapper);
        List<AdminUserDO> list = userPage.getRecords();

        List<Integer> roleIdList = list.stream().map(AdminUserDO::getRoleId).collect(Collectors.toList());
        List<Integer> deptIdList = list.stream().map(AdminUserDO::getRoleId).collect(Collectors.toList());

        // 异步获取角色信息
        CompletableFuture<List<AdminRoleDO>> asyncRoleList = asyncAdminRoleService.getRoleListByIds(roleIdList);
        // 异步获取部门信息
        CompletableFuture<List<AdminDeptDO>> asyncDeptList = asyncAdminDeptService.getDeptListByIds(deptIdList);
        // 等待所有任务都执行完
        CompletableFuture.allOf(asyncRoleList, asyncDeptList).join();
        // 获取每个任务的返回结果
        List<AdminRoleDO> roleList = asyncRoleList.get();
        List<AdminDeptDO> deptList = asyncDeptList.get();

        List<AdminUserVO> userDTOList = new ArrayList<>();
        for (AdminUserDO userDO : list) {
            Integer roleId = userDO.getRoleId();
            Integer deptId = userDO.getDeptId();

            AdminUserVO userDTO = new AdminUserVO();
            BeanUtils.copyProperties(userDO, userDTO);
            for (AdminRoleDO role: roleList) {
                if(roleId.equals(role.getId())){
                    userDTO.setRoleName(role.getName());
                }
            }

            for (AdminDeptDO dept: deptList) {
                if(deptId.equals(dept.getId())){
                    userDTO.setDeptName(dept.getName());
                }
            }

            userDTOList.add(userDTO);
        }

        return userDTOList;
    }
}
