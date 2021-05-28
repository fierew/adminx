package com.fierew.adminx.service;

import com.fierew.adminx.domain.DeptDO;

import java.util.List;

/**
 * @author xuyang
 */
public interface DeptService {
    /**
     * 根据id获取部门信息
     *
     * @param id id
     * @return 部门信息
     */
    DeptDO getDeptById(Integer id);

    /**
     * 根据多个id获取部门信息
     *
     * @param ids ids
     * @return 部门信息列表
     */
    List<DeptDO> getDeptListByIds(List<Integer> ids);
}
