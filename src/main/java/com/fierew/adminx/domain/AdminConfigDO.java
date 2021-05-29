package com.fierew.adminx.domain;

import lombok.Data;

/**
 * 配置实体类
 * @author xuyang
 */
@Data
public class AdminConfigDO {
    /**
     * 名称
     */
    private String name;

    /**
     * [input]单行文本
     * [textarea]多行文本
     * [array]数组
     * [switch]开关
     * [radio]单选按钮
     * [checkbox]多选框
     * [tags]标签
     * [select]下拉框
     * [image]图片
     * [file]文件
     * [date]日期
     * [datetime]日期+时间
     * [time]时间
     */
    private String type;

    /**
     * 配置标识
     */
    private String key;

    /**
     * 配置值
     */
    private String value;

    /**
     * 配置选项
     */
    private String option;

    /**
     * 备注
     */
    private String remarks;

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
