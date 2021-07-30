package com.fierew.adminx.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.Email;
import java.time.LocalDateTime;

/**
 * @author xuyang
 */
@Data
@Schema(name = "AdminUser", description = "请求数据，用户实体类")
public class AdminUserDTO {
    @Schema(description = "部门id")
    @JsonProperty(value = "deptId")
    private Integer deptId;

    @Schema(description = "多个角色ID")
    @JsonProperty(value = "roleIds")
    private String roleIds;

    @Schema(description = "用户名")
    @JsonProperty(value = "username")
    private String username;

    @Schema(description = "真实姓名")
    @JsonProperty(value = "realName")
    private String realName;

    @Schema(description = "邮箱")
    @Email
    @JsonProperty(value = "email")
    private String email;

    @Schema(description = "手机号")
    @JsonProperty(value = "mobile")
    private String mobile;

    @Schema(description = "性别")
    @JsonProperty(value = "sex")
    private Byte sex;

    @Schema(description = "年龄")
    @JsonProperty(value = "age")
    private Integer age;

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
