package com.fierew.adminx.dao;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fierew.adminx.domain.AdminRoleDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author xuyang
 */
@Mapper
public interface AdminRoleDAO extends BaseMapper<AdminRoleDO> {
}
