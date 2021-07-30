package com.fierew.adminx.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Schema(name = "AdminRole", description = "请求数据，角色实体类")
public class AdminRoleDTO {
    @Schema(description = "角色名称")
    @JsonProperty(value = "name")
    private String name;

    @Schema(description = "备注")
    @JsonProperty(value = "remarks")
    private String remarks;

    @Schema(description = "排序")
    @JsonProperty(value = "sort")
    private Integer sort;

    @Schema(description = "开始时间")
    @JsonProperty(value = "startTime")
    private LocalDateTime startTime;

    @Schema(description = "结束时间")
    @JsonProperty(value = "endTime")
    private LocalDateTime endTime;
}
