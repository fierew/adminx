package com.fierew.adminx.service;

import com.fierew.adminx.domain.RoleDO;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * @author xuyang
 */
public interface AsyncRoleService {
    /**
     * 根据id获取角色信息
     *
     * @param id id
     * @return 角色信息
     */
    CompletableFuture<RoleDO> getRoleById(Integer id);

    /**
     * 根据多个id获取角色信息
     *
     * @param ids ids
     * @return 角色信息列表
     */
    CompletableFuture<List<RoleDO>> getRoleListByIds(List<Integer> ids);
}
