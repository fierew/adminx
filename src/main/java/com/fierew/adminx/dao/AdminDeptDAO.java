package com.fierew.adminx.dao;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fierew.adminx.domain.AdminDeptDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author xuyang
 */
@Mapper
@TableName(value = "admin_dept")
public interface AdminDeptDAO extends BaseMapper<AdminDeptDO> {
}
