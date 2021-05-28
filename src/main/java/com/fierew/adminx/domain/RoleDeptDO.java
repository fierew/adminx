package com.fierew.adminx.domain;

import lombok.Data;

/**
 * 角色与部门关联关系实体类
 * @author xuyang
 */
@Data
public class RoleDeptDO {
    /**
     * 角色id
     */
    private Integer roleId;

    /**
     * 部门id
     */
    private Integer deptId;

    /**
     * 是否删除 1：删除，0：未删除
     */
    private Byte isDelete;

    /**
     * 写入数据库的时间（10位时间戳）
     */
    private Integer createTime;

    /**
     * 更新数据库的时间（10位时间戳）
     */
    private Integer updateTime;
}
