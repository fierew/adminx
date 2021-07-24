package com.fierew.adminx.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.Email;

/**
 * @author xuyang
 */
@Data
public class AdminUserDTO {
    /**
     * 部门id
     */
    @JsonProperty(value = "deptId")
    private Integer deptId;

    /**
     * 多个角色ID
     */
    @JsonProperty(value = "roleIds")
    private String roleIds;

    /**
     * 用户名
     */
    @JsonProperty(value = "username")
    private String username;

    /**
     * 真实姓名
     */
    @JsonProperty(value = "realName")
    private String realName;

    /**
     * 邮箱
     */
    @Email
    @JsonProperty(value = "email")
    private String email;

    /**
     * 手机号
     */
    @JsonProperty(value = "mobile")
    private String mobile;

    /**
     * 性别
     */
    @JsonProperty(value = "sex")
    private Byte sex;

    /**
     * 年龄
     */
    @JsonProperty(value = "age")
    private Integer age;

    /**
     * 状态
     */
    @JsonProperty(value = "state")
    private Byte state;
}
