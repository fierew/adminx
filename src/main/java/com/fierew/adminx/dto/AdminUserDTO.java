package com.fierew.adminx.dto;

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
    private Integer deptId;

    /**
     * 角色id
     */
    private Integer roleId;

    /**
     * 用户名
     */
    private String username;

    /**
     * 真实姓名
     */
    private String realName;

    /**
     * 邮箱
     */
    @Email
    private String email;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 性别
     */
    private Byte sex;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 登陆次数
     */
    private Integer loginNum;

    /**
     * 状态
     */
    private Byte state;
}
