package com.fierew.adminx.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AdminDeptDTO {
    /**
     * 部门父级id
     */
    @JsonProperty(value = "parentId")
    private Integer parentId;

    /**
     * 部门名称
     */
    @JsonProperty(value = "name")
    private String name;

    /**
     * 每个层级的关系
     */
    @JsonProperty(value = "nodePath")
    private String nodePath;

    /**
     * 备注
     */
    @JsonProperty(value = "remarks")
    private String remarks;

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
