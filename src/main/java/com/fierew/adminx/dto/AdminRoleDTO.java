package com.fierew.adminx.dto;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AdminRoleDTO {
    /**
     * 角色名称
     */
    @JsonProperty(value = "name")
    private String name;

    /**
     * 备注
     */
    @JsonProperty(value = "remarks")
    private String remarks;

    /**
     * 排序
     */
    @JsonProperty(value = "sort")
    private Integer sort;

    /**
     * 开始时间
     */
    @JsonProperty(value = "startTime")
    private LocalDateTime startTime;

    /**
     * 开始时间
     */
    @JsonProperty(value = "endTime")
    private LocalDateTime endTime;
}
