package com.fierew.adminx.vo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AdminRoleVO {
    /**
     * 角色ID
     */
    private Integer id;

    /**
     * 用户ID
     */
    private Integer userId;

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
     * 写入数据库的时间
     */
    private LocalDateTime createTime;

    /**
     * 更新数据库的时间
     */
    private LocalDateTime updateTime;
}
