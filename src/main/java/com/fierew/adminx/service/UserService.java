package com.fierew.adminx.service;

import com.fierew.adminx.dto.UserDTO;

import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * @author xuyang
 */
public interface UserService {
    /**
     * 获取分页数据
     *
     * @param page     页数
     * @param pageSize 每页多少条数据
     * @return 分页列表
     * @throws InterruptedException
     * @throws ExecutionException
     */
    List<UserDTO> getList(Integer page, Integer pageSize) throws InterruptedException, ExecutionException;
}
