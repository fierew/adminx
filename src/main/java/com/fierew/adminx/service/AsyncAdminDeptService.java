package com.fierew.adminx.service;

import com.fierew.adminx.domain.AdminDeptDO;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * @author xuyang
 */
public interface AsyncAdminDeptService {
    /**
     * 根据id获取部门信息
     *
     * @param id id
     * @return 部门信息
     */
    CompletableFuture<AdminDeptDO> getDeptById(Integer id);

    /**
     * 根据多个id获取部门信息
     *
     * @param ids ids
     * @return 部门信息列表
     */
    CompletableFuture<List<AdminDeptDO>> getDeptListByIds(List<Integer> ids);
}
