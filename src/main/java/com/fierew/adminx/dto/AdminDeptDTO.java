package com.fierew.adminx.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Schema(name = "AdminDept", description = "请求数据，部门实体类")
public class AdminDeptDTO {
    @Schema(description = "部门父级id")
    @JsonProperty(value = "parentId")
    private Integer parentId;

    @Schema(description = "部门名称")
    @JsonProperty(value = "name")
    private String name;

    @Schema(description = "每个层级的关系")
    @JsonProperty(value = "nodePath")
    private String nodePath;

    @Schema(description = "备注")
    @JsonProperty(value = "remarks")
    private String remarks;

    @Schema(description = "开始时间")
    @JsonProperty(value = "startTime")
    private LocalDateTime startTime;

    @Schema(description = "结束时间")
    @JsonProperty(value = "endTime")
    private LocalDateTime endTime;
}
