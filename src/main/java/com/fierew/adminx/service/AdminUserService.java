package com.fierew.adminx.service;

import com.fierew.adminx.vo.AdminUserVO;
import com.fierew.adminx.dto.AdminUserDTO;
import com.fierew.adminx.dto.TableDTO;

import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * @author xuyang
 */
public interface AdminUserService {
    /**
     * 获取分页数据
     *
     * @param tableDTO          列表参数
     * @param adminUserDTO 条件
     * @return 分页列表
     * @throws InterruptedException
     * @throws ExecutionException
     */
    List<AdminUserVO> getList(TableDTO tableDTO, AdminUserDTO adminUserDTO) throws InterruptedException, ExecutionException;
}
