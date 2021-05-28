package com.fierew.adminx.service.impl;

import com.fierew.adminx.domain.RoleDO;
import com.fierew.adminx.service.AsyncRoleService;
import com.fierew.adminx.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * @author xuyang
 */
@Service
public class AsyncRoleServiceImpl implements AsyncRoleService {
    private RoleService roleService;

    @Autowired
    public void setRoleService(RoleService roleService) {
        this.roleService = roleService;
    }

    @Override
    @Async
    public CompletableFuture<RoleDO> getRoleById(Integer id) {
        return CompletableFuture.completedFuture(roleService.getRoleById(id));
    }

    @Override
    @Async
    public CompletableFuture<List<RoleDO>> getRoleListByIds(List<Integer> ids) {
        return CompletableFuture.completedFuture(roleService.getRoleListByIds(ids));
    }
}
