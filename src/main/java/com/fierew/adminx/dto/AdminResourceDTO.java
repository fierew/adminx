package com.fierew.adminx.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AdminResourceDTO {
    /**
     * 资源父级id
     */
    @JsonProperty(value = "parentId")
    private Integer parentId;

    /**
     * 资源名称
     */
    @JsonProperty(value = "name")
    private String name;

    /**
     * 每个层级的关系
     */
    @JsonProperty(value = "nodePath")
    private String nodePath;

    /**
     * 图标
     */
    @JsonProperty(value = "icon")
    private String icon;

    /**
     * 类型 1：菜单，2：按钮, 3:api
     */
    @JsonProperty(value = "type")
    private Integer type;

    /**
     * 权限标识
     */
    @JsonProperty(value = "key")
    private String key;

    /**
     * 菜单或按钮是否隐藏 1：隐藏，0：显示
     */
    @JsonProperty(value = "isHide")
    private Byte isHide;

    /**
     * 备注
     */
    @JsonProperty(value = "remarks")
    private String remarks;

    /**
     * 状态
     */
    @JsonProperty(value = "state")
    private Byte state;

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
