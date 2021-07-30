package com.fierew.adminx.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@Schema(name = "AdminRoleResource", description = "请求数据，角色与资源关联实体类")
public class AdminRoleResourceDTO {
    @Schema(description = "角色id")
    @NotNull
    @JsonProperty(value = "roleId")
    private Integer roleId;

    @Schema(description = "多个资源id")
    @NotNull
    @JsonProperty(value = "resourceIds")
    private String resourceIds;
}
