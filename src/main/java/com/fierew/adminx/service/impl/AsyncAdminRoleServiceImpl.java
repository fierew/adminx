package com.fierew.adminx.service.impl;

import com.fierew.adminx.domain.AdminRoleDO;
import com.fierew.adminx.service.AsyncAdminRoleService;
import com.fierew.adminx.service.AdminRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * @author xuyang
 */
@Service
public class AsyncAdminRoleServiceImpl implements AsyncAdminRoleService {
    private AdminRoleService adminRoleService;

    @Autowired
    public void setAdminRoleService(AdminRoleService adminRoleService) {
        this.adminRoleService = adminRoleService;
    }

    @Override
    @Async
    public CompletableFuture<AdminRoleDO> getRoleById(Integer id) {
        return CompletableFuture.completedFuture(adminRoleService.getRoleById(id));
    }

    @Override
    @Async
    public CompletableFuture<List<AdminRoleDO>> getRoleListByIds(List<Integer> ids) {
        return CompletableFuture.completedFuture(adminRoleService.getRoleListByIds(ids));
    }
}
