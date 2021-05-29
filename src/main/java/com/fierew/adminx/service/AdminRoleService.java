package com.fierew.adminx.service;

import com.fierew.adminx.domain.AdminRoleDO;

import java.util.List;

/**
 * @author xuyang
 */
public interface AdminRoleService {
    /**
     * 根据id获取角色信息
     *
     * @param id id
     * @return 角色信息
     */
    AdminRoleDO getRoleById(Integer id);

    /**
     * 根据多个id获取角色信息
     *
     * @param ids ids
     * @return 角色信息列表
     */
    List<AdminRoleDO> getRoleListByIds(List<Integer> ids);
}
