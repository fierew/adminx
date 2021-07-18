package com.fierew.adminx.domain;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.time.LocalDateTime;

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
     * 是否删除 1：删除，0：未删除
     */
    private Byte isDeleted;

    /**
     * 写入数据库的时间
     */
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    /**
     * 更新数据库的时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;
}
