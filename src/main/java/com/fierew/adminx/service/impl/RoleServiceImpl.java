package com.fierew.adminx.service.impl;

import com.fierew.adminx.dao.RoleDAO;
import com.fierew.adminx.domain.RoleDO;
import com.fierew.adminx.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xuyang
 */
@Service
public class RoleServiceImpl implements RoleService {
    private RoleDAO roleDAO;

    @Autowired
    public void setUserDAO (RoleDAO roleDAO){
        this.roleDAO = roleDAO;
    }

    @Override
    public RoleDO getRoleById(Integer id) {
        return roleDAO.selectById(id);
    }

    @Override
    public List<RoleDO> getRoleListByIds(List<Integer> ids) {
        return roleDAO.selectBatchIds(ids);
    }
}
