package com.fierew.adminx.service.impl;

import com.fierew.adminx.dao.DeptDAO;
import com.fierew.adminx.domain.DeptDO;
import com.fierew.adminx.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xuyang
 */
@Service
public class DeptServiceImpl implements DeptService {
    private DeptDAO deptDAO;

    @Autowired
    public void setUserDAO (DeptDAO deptDAO){
        this.deptDAO = deptDAO;
    }

    @Override
    public DeptDO getDeptById(Integer id) {
        return deptDAO.selectById(id);
    }

    @Override
    public List<DeptDO> getDeptListByIds(List<Integer> ids) {
        return deptDAO.selectBatchIds(ids);
    }
}
