package com.fierew.adminx.service.impl;

import com.fierew.adminx.dao.AdminRoleDAO;
import com.fierew.adminx.domain.AdminRoleDO;
import com.fierew.adminx.service.AdminRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xuyang
 */
@Service
public class AdminRoleServiceImpl implements AdminRoleService {
    private AdminRoleDAO adminRoleDAO;

    @Autowired
    public void setAdminRoleDAO (AdminRoleDAO adminRoleDAO){
        this.adminRoleDAO = adminRoleDAO;
    }

    @Override
    public AdminRoleDO getRoleById(Integer id) {
        return adminRoleDAO.selectById(id);
    }

    @Override
    public List<AdminRoleDO> getRoleListByIds(List<Integer> ids) {
        return adminRoleDAO.selectBatchIds(ids);
    }
}
