package com.fierew.adminx.domain;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.time.LocalDateTime;

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
