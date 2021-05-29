package com.fierew.adminx.domain;

import lombok.Data;

/**
 * 资源实体类
 * @author xuyang
 */
@Data
public class AdminResourceDO {
    /**
     * 资源id
     */
    private Integer id;

    /**
     * 资源父级id
     */
    private Integer parentId;

    /**
     * 资源名称
     */
    private String name;

    /**
     * 图标
     */
    private String icon;

    /**
     * 类型 1：菜单，2：按钮
     */
    private Integer type;

    /**
     * 权限标识
     */
    private String key;

    /**
     * 路径
     */
    private String path;

    /**
     * 是否隐藏 1：隐藏，0：显示
     */
    private Byte isHide;

    /**
     * 备注
     */
    private String remarks;

    /**
     * 状态
     */
    private Byte state;

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