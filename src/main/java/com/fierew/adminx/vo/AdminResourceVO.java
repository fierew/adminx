package com.fierew.adminx.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(callSuper = true)
public class AdminResourceVO extends TreeNode {
    /**
     * 资源名称
     */
    private String name;

    /**
     * 每个层级的关系
     */
    private String nodePath;

    /**
     * 图标
     */
    private String icon;

    /**
     * 类型 1：菜单，2：按钮, 3:api
     */
    private Integer type;

    /**
     * 权限标识
     */
    private String key;

    /**
     * 菜单或按钮是否隐藏 1：隐藏，0：显示
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
     * 写入数据库的时间
     */
    private LocalDateTime createTime;
}
