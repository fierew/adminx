package com.fierew.adminx.domain;

import lombok.Data;

/**
 * 部门实体类
 * @author xuyang
 */
@Data
public class DeptDO {
    /**
     * 部门id
     */
    private Integer id;

    /**
     * 部门父级id
     */
    private Integer parentId;

    /**
     * 部门名称
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
