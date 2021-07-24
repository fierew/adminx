package com.fierew.adminx.service;

import com.fierew.adminx.domain.AdminUserDO;
import com.fierew.adminx.vo.AdminUserVO;
import com.fierew.adminx.dto.AdminUserDTO;
import com.fierew.adminx.dto.TableDTO;
import com.fierew.adminx.vo.PageVO;

import java.util.concurrent.ExecutionException;

/**
 * @author xuyang
 */
public interface AdminUserService {
    /**
     * 获取分页数据
     *
     * @param tableDTO     列表参数
     * @param adminUserDTO 条件
     * @return 分页列表
     */
    PageVO<AdminUserVO> getList(TableDTO tableDTO, AdminUserDTO adminUserDTO) throws InterruptedException, ExecutionException;

    /**
     * 新增用户
     *
     * @param adminUserDTO 用户数据
     * @return 结果
     */
    Integer add(AdminUserDTO adminUserDTO);

    /**
     * 删除用户
     *
     * @param id 用户id
     * @return 结果
     */
    Integer del(Integer id);

    /**
     * 修改用户
     *
     * @param id 用户id
     * @param adminUserDTO 用户数据
     * @return 结果
     */
    Integer modify(Integer id, AdminUserDTO adminUserDTO);
}
