package com.fierew.adminx.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @author xuyang
 */
@Data
@Schema(name = "Table", description = "请求数据，表格实体类")
public class TableDTO {
    @Schema(description = "页数")
    @NotNull
    @Min(value = 1, message = "page必须大于1")
    @JsonProperty(value = "page")
    private Integer page;

    @Schema(description = "每页多少数据")
    @NotNull
    @Min(value = 1, message = "pageSize必须大于1")
    @JsonProperty(value = "pageSize")
    private Integer pageSize;

    @Schema(description = "字段")
    private String field;

    @Schema(description = "倒序或正序")
    private String order;
}
