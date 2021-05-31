package com.fierew.adminx.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @author xuyang
 */
@Data
public class TableDTO {
    @NotNull
    @JsonIgnore
    @Min(value = 1, message = "page必须大于1")
    private Integer page;

    @NotNull
    @Min(value = 1, message = "pageSize必须大于1")
    private Integer pageSize;

    private String field;
    private String order;
}
