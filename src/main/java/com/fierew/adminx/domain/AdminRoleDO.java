package com.fierew.adminx.domain;

import lombok.Data;

/**
 * 角色实体类
 * @author xuyang
 */
@Data
public class AdminRoleDO {
    /**
     * 角色id
     */
    private Integer id;

    /**
     * 角色名称
     */
    private String name;

    /**
     * 备注
     */
    private String remarks;

    /**
     * 排序
     */
    private Integer sort;

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
