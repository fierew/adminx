package com.fierew.adminx.service;

import com.fierew.adminx.domain.UserDO;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * @author xuyang
 */
public interface AsyncUserService {
    /**
     * 获取分页数据
     *
     * @param page          页数
     * @param pageSize      每页多少条数据
     * @param userDO        条件
     * @return 分页列表
     */
    CompletableFuture<List<UserDO>> getList(Integer page, Integer pageSize, UserDO userDO);
}
