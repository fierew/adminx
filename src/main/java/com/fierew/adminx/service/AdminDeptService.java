package com.fierew.adminx.service;

import com.fierew.adminx.domain.AdminDeptDO;

import java.util.List;

/**
 * @author xuyang
 */
public interface AdminDeptService {
    /**
     * 根据id获取部门信息
     *
     * @param id id
     * @return 部门信息
     */
    AdminDeptDO getDeptById(Integer id);

    /**
     * 根据多个id获取部门信息
     *
     * @param ids ids
     * @return 部门信息列表
     */
    List<AdminDeptDO> getDeptListByIds(List<Integer> ids);
}
