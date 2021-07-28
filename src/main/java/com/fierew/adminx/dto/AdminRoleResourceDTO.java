package com.fierew.adminx.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class AdminRoleResourceDTO {
    /**
     * 角色id
     */
    @NotNull
    @JsonProperty(value = "roleId")
    private Integer roleId;

    /**
     * 多个资源id
     */
    @NotNull
    @JsonProperty(value = "resourceIds")
    private String resourceIds;
}
