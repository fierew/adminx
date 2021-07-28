package com.fierew.adminx.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fierew.adminx.dao.AdminRoleDAO;
import com.fierew.adminx.dao.AdminRoleResourceDAO;
import com.fierew.adminx.domain.AdminRoleDO;
import com.fierew.adminx.domain.AdminRoleResourceDO;
import com.fierew.adminx.dto.AdminRoleDTO;
import com.fierew.adminx.dto.AdminRoleResourceDTO;
import com.fierew.adminx.dto.TableDTO;
import com.fierew.adminx.service.AdminRoleService;
import com.fierew.adminx.vo.AdminRoleVO;
import com.fierew.adminx.vo.PageVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xuyang
 */
@Service
public class AdminRoleServiceImpl implements AdminRoleService {
    private AdminRoleDAO adminRoleDAO;
    private AdminRoleResourceDAO adminRoleResourceDAO;

    @Autowired
    public void setDAO(AdminRoleDAO adminRoleDAO, AdminRoleResourceDAO adminRoleResourceDAO) {
        this.adminRoleDAO = adminRoleDAO;
        this.adminRoleResourceDAO = adminRoleResourceDAO;
    }

    @Override
    public PageVO<AdminRoleVO> getList(TableDTO tableDTO, AdminRoleDTO adminRoleDTO) {
        // 条件构造器
        QueryWrapper<AdminRoleDO> roleQueryWrapper = new QueryWrapper<>();

        if (adminRoleDTO.getName() != null) {
            roleQueryWrapper.like("name", adminRoleDTO.getName());
        }

        if (adminRoleDTO.getStartTime() != null && adminRoleDTO.getEndTime() != null) {
            roleQueryWrapper.ge("create_time", adminRoleDTO.getStartTime());
            roleQueryWrapper.le("create_time", adminRoleDTO.getEndTime());
        }

        // 分页插件
        IPage<AdminRoleDO> rolePage = new Page<>(tableDTO.getPage(), tableDTO.getPageSize());
        rolePage = adminRoleDAO.selectPage(rolePage, roleQueryWrapper);
        List<AdminRoleDO> roleList = rolePage.getRecords();
        Long total = rolePage.getTotal();

        List<AdminRoleVO> adminRoleVOList = new ArrayList<>();

        for (AdminRoleDO role : roleList) {
            AdminRoleVO adminRoleVO = new AdminRoleVO();
            BeanUtils.copyProperties(role, adminRoleVO);

            adminRoleVOList.add(adminRoleVO);
        }

        PageVO<AdminRoleVO> pageVO = new PageVO<>();
        pageVO.setLists(adminRoleVOList);
        pageVO.setTotal(total);

        return pageVO;
    }

    @Override
    public Integer add(AdminRoleDTO adminRoleDTO) {
        AdminRoleDO adminRoleDO = new AdminRoleDO();
        BeanUtils.copyProperties(adminRoleDTO, adminRoleDO);

        return adminRoleDAO.insert(adminRoleDO);
    }

    @Override
    public Integer modify(Integer id, AdminRoleDTO adminRoleDTO) {
        AdminRoleDO adminRoleDO = new AdminRoleDO();
        BeanUtils.copyProperties(adminRoleDTO, adminRoleDO);
        adminRoleDO.setId(id);
        return adminRoleDAO.updateById(adminRoleDO);
    }

    @Override
    @Transactional
    public Integer del(Integer id) {
        // 删除角色与菜单的关联信息
        delRoleResource(id);

        AdminRoleDO adminRoleDO = new AdminRoleDO();
        adminRoleDO.setId(id);
        adminRoleDO.setIsDeleted((byte) 1);
        return adminRoleDAO.updateById(adminRoleDO);
    }

    @Override
    @Transactional
    public Integer addRoleResource(AdminRoleResourceDTO adminRoleResourceDTO) {
        // 删除角色与菜单的关联信息
        delRoleResource(adminRoleResourceDTO.getRoleId());

        String[] resources = adminRoleResourceDTO.getResourceIds().split(",");

        List<AdminRoleResourceDO> adminRoleResourceDOList = new ArrayList<>();
        for (String resource : resources) {
            AdminRoleResourceDO adminRoleResourceDO = new AdminRoleResourceDO();
            adminRoleResourceDO.setRoleId(adminRoleResourceDTO.getRoleId());
            adminRoleResourceDO.setResourceId(Integer.parseInt(resource));

            adminRoleResourceDOList.add(adminRoleResourceDO);
        }

        return adminRoleResourceDAO.insertBatchSomeColumn(adminRoleResourceDOList);
    }

    protected void delRoleResource(Integer roleId) {
        AdminRoleResourceDO adminRoleResourceDO = new AdminRoleResourceDO();
        adminRoleResourceDO.setIsDeleted((byte) 1);
        UpdateWrapper<AdminRoleResourceDO> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("role_id", roleId);
        adminRoleResourceDAO.update(adminRoleResourceDO, updateWrapper);
    }
}
