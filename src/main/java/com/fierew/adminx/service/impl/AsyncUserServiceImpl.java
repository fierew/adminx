package com.fierew.adminx.service.impl;

import com.fierew.adminx.domain.UserDO;
import com.fierew.adminx.service.AsyncUserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * @author xuyang
 */
@Service
public class AsyncUserServiceImpl implements AsyncUserService {

    @Override
    public CompletableFuture<List<UserDO>> getList(Integer page, Integer pageSize, UserDO userDO) {
        return null;
    }
}
