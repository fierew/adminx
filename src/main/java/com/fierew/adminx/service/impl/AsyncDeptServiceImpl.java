package com.fierew.adminx.service.impl;

import com.fierew.adminx.domain.DeptDO;
import com.fierew.adminx.service.AsyncDeptService;
import com.fierew.adminx.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * @author xuyang
 */
@Service
public class AsyncDeptServiceImpl implements AsyncDeptService {
    private DeptService deptService;

    @Autowired
    public void setDeptService(DeptService deptService){
        this.deptService = deptService;
    }

    @Override
    @Async
    public CompletableFuture<DeptDO> getDeptById(Integer id){
         return CompletableFuture.completedFuture(deptService.getDeptById(id));
    }

    @Override
    @Async
    public CompletableFuture<List<DeptDO>> getDeptListByIds(List<Integer> ids){
        return CompletableFuture.completedFuture(deptService.getDeptListByIds(ids));
    }
}
