package com.fierew.adminx.service.impl;

import com.fierew.adminx.dao.AdminDeptDAO;
import com.fierew.adminx.domain.AdminDeptDO;
import com.fierew.adminx.service.AdminDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xuyang
 */
@Service
public class AdminDeptServiceImpl implements AdminDeptService {
    private AdminDeptDAO adminDeptDAO;

    @Autowired
    public void setAdminDeptDAO (AdminDeptDAO adminDeptDAO){
        this.adminDeptDAO = adminDeptDAO;
    }

    @Override
    public AdminDeptDO getDeptById(Integer id) {
        return adminDeptDAO.selectById(id);
    }

    @Override
    public List<AdminDeptDO> getDeptListByIds(List<Integer> ids) {
        return adminDeptDAO.selectBatchIds(ids);
    }
}
