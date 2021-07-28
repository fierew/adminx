package com.fierew.adminx.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fierew.adminx.dao.AdminResourceDAO;
import com.fierew.adminx.domain.AdminResourceDO;
import com.fierew.adminx.dto.AdminResourceDTO;
import com.fierew.adminx.service.AdminResourceService;
import com.fierew.adminx.utils.TreeUtil;
import com.fierew.adminx.vo.AdminResourceVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdminResourceServiceImpl implements AdminResourceService {
    private AdminResourceDAO adminResourceDAO;

    @Autowired
    public void setDAO(AdminResourceDAO adminResourceDAO) {
        this.adminResourceDAO = adminResourceDAO;
    }

    @Override
    public List<AdminResourceVO> getTreeResource(AdminResourceDTO adminResourceDTO) {
        // 条件构造器
        QueryWrapper<AdminResourceDO> resourceQueryWrapper = new QueryWrapper<>();

        if (adminResourceDTO.getName() != null) {
            resourceQueryWrapper.like("name", adminResourceDTO.getName());
        }

        if (adminResourceDTO.getStartTime() != null && adminResourceDTO.getEndTime() != null) {
            resourceQueryWrapper.ge("create_time", adminResourceDTO.getStartTime());
            resourceQueryWrapper.le("create_time", adminResourceDTO.getEndTime());
        }
        List<AdminResourceDO> adminResourceDOList = adminResourceDAO.selectList(resourceQueryWrapper);

        List<AdminResourceVO> treeList = adminResourceDOList.stream()
                .filter(resource -> !resource.getId().equals(resource.getParentId()))
                .map(resource -> {
                    AdminResourceVO node = new AdminResourceVO();
                    BeanUtils.copyProperties(resource, node);
                    return node;
                }).collect(Collectors.toList());

        return TreeUtil.bulid(treeList, 0);
    }
}
