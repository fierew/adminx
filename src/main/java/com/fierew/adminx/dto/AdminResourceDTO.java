package com.fierew.adminx.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Schema(name = "AdminResource", description = "请求数据，资源实体类")
public class AdminResourceDTO {
    @Schema(description = "资源父级id")
    @JsonProperty(value = "parentId")
    private Integer parentId;

    @Schema(description = "资源名称")
    @JsonProperty(value = "name")
    private String name;

    @Schema(description = "每个层级的关系")
    @JsonProperty(value = "nodePath")
    private String nodePath;

    @Schema(description = "图标")
    @JsonProperty(value = "icon")
    private String icon;

    @Schema(description = "类型 1：菜单，2：按钮, 3:api")
    @JsonProperty(value = "type")
    private Integer type;

    @Schema(description = "权限标识")
    @JsonProperty(value = "key")
    private String key;

    @Schema(description = "菜单或按钮是否隐藏 1：隐藏，0：显示")
    @JsonProperty(value = "isHide")
    private Byte isHide;

    @Schema(description = "备注")
    @JsonProperty(value = "remarks")
    private String remarks;

    @Schema(description = "状态")
    @JsonProperty(value = "state")
    private Byte state;

    @Schema(description = "开始时间")
    @JsonProperty(value = "startTime")
    private LocalDateTime startTime;

    @Schema(description = "结束时间")
    @JsonProperty(value = "endTime")
    private LocalDateTime endTime;
}
