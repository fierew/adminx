package com.fierew.adminx.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @author xuyang
 */
@Data
public class TableDTO {
    @NotNull
    @Min(value = 1, message = "page必须大于1")
    @JsonProperty(value = "page")
    private Integer page;

    @NotNull
    @Min(value = 1, message = "pageSize必须大于1")
    @JsonProperty(value = "pageSize")
    private Integer pageSize;

    private String field;
    private String order;
}
