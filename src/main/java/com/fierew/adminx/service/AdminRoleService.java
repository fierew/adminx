package com.fierew.adminx.service;

import com.fierew.adminx.domain.AdminRoleDO;
import com.fierew.adminx.dto.AdminRoleDTO;
import com.fierew.adminx.dto.AdminUserDTO;
import com.fierew.adminx.dto.TableDTO;
import com.fierew.adminx.vo.AdminRoleVO;
import com.fierew.adminx.vo.PageVO;

import java.util.List;

/**
 * @author xuyang
 */
public interface AdminRoleService {
    /**
     * 获取角色列表
     *
     * @param tableDTO     列表参数
     * @param adminRoleDTO 条件
     * @return 分页列表
     */
    PageVO<AdminRoleVO> getList(TableDTO tableDTO, AdminRoleDTO adminRoleDTO);

    /**
     * 新增角色
     *
     * @param adminRoleDTO 角色信息
     * @return 结果
     */
    Integer add(AdminRoleDTO adminRoleDTO);

    /**
     * 修改角色
     *
     * @param id           角色ID
     * @param adminRoleDTO 角色信息
     * @return 结果
     */
    Integer modify(Integer id, AdminRoleDTO adminRoleDTO);

    /**
     * 删除角色
     *
     * @param id 角色ID
     * @return 结果
     */
    Integer del(Integer id);

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
