package com.fierew.adminx.service.impl;

import com.fierew.adminx.domain.AdminDeptDO;
import com.fierew.adminx.service.AsyncAdminDeptService;
import com.fierew.adminx.service.AdminDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * @author xuyang
 */
@Service
public class AsyncAdminDeptServiceImpl implements AsyncAdminDeptService {
    private AdminDeptService adminDeptService;

    @Autowired
    public void setAdminDeptService(AdminDeptService adminDeptService){
        this.adminDeptService = adminDeptService;
    }

    @Override
    @Async
    public CompletableFuture<AdminDeptDO> getDeptById(Integer id){
         return CompletableFuture.completedFuture(adminDeptService.getDeptById(id));
    }

    @Override
    @Async
    public CompletableFuture<List<AdminDeptDO>> getDeptListByIds(List<Integer> ids){
        return CompletableFuture.completedFuture(adminDeptService.getDeptListByIds(ids));
    }
}
