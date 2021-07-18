package com.fierew.adminx.domain;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 日志实体类
 * @author xuyang
 */
@Data
public class AdminLogDO {
    /**
     * 主键ID
     */
    private Integer id;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 请求类型
     */
    private String method;

    /**
     * 请求方法
     */
    private String function;

    /**
     * 请求网址
     */
    private String url;

    /**
     * 请求参数
     */
    private String param;

    /**
     * IP
     */
    private String ip;

    /**
     * 位置地址
     */
    private String location;

    /**
     * 浏览器
     */
    private String browser;

    /**
     * 耗时
     */
    private Integer takeTime;

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
