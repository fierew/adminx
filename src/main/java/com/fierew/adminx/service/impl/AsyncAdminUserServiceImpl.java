package com.fierew.adminx.service.impl;

import com.fierew.adminx.domain.AdminUserDO;
import com.fierew.adminx.service.AsyncAdminUserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * @author xuyang
 */
@Service
public class AsyncAdminUserServiceImpl implements AsyncAdminUserService {

    @Override
    public CompletableFuture<List<AdminUserDO>> getList(Integer page, Integer pageSize, AdminUserDO userDO) {
        return null;
    }
}
