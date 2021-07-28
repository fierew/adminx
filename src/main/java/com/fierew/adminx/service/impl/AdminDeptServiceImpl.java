package com.fierew.adminx.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fierew.adminx.dao.AdminDeptDAO;
import com.fierew.adminx.domain.AdminDeptDO;
import com.fierew.adminx.domain.AdminUserDO;
import com.fierew.adminx.dto.AdminDeptDTO;
import com.fierew.adminx.service.AdminDeptService;
import com.fierew.adminx.utils.TreeUtil;
import com.fierew.adminx.vo.AdminDeptVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author xuyang
 */
@Service
public class AdminDeptServiceImpl implements AdminDeptService {
    private AdminDeptDAO adminDeptDAO;

    @Autowired
    public void setDAO(AdminDeptDAO adminDeptDAO) {
        this.adminDeptDAO = adminDeptDAO;
    }

    @Override
    public List<AdminDeptVO> getTreeDept(AdminDeptDTO adminDeptDTO) {
        // 条件构造器
        QueryWrapper<AdminDeptDO> deptQueryWrapper = new QueryWrapper<>();

        if (adminDeptDTO.getName() != null) {
            deptQueryWrapper.like("name", adminDeptDTO.getName());
        }

        if (adminDeptDTO.getStartTime() != null && adminDeptDTO.getEndTime() != null) {
            deptQueryWrapper.ge("create_time", adminDeptDTO.getStartTime());
            deptQueryWrapper.le("create_time", adminDeptDTO.getEndTime());
        }

        List<AdminDeptDO> adminDeptDOList = adminDeptDAO.selectList(deptQueryWrapper);

        List<AdminDeptVO> treeList = adminDeptDOList.stream()
                .filter(dept -> !dept.getId().equals(dept.getParentId()))
                .map(dept -> {
                    AdminDeptVO node = new AdminDeptVO();
                    BeanUtils.copyProperties(dept, node);
                    return node;
                }).collect(Collectors.toList());

        return TreeUtil.bulid(treeList, 0);
    }
}
