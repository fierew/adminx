package com.fierew.adminx.dao;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fierew.adminx.domain.AdminUserDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author xuyang
 */
@Mapper
@TableName(value = "admin_user")
public interface AdminUserDAO extends BaseMapper<AdminUserDO> {

}
