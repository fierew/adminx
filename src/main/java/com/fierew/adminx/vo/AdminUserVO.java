package com.fierew.adminx.vo;

import lombok.Data;

/**
 * @author xuyang
 */
@Data
public class AdminUserVO {
    /**
     * 用户ID
     */
    private Integer id;

    /**
     * 部门id
     */
    private Integer deptId;

    /**
     * 部门名称
     */
    private String deptName;

    /**
     * 角色id
     */
    private Integer roleId;

    /**
     * 角色名称
     */
    private String roleName;

    /**
     * 真实姓名
     */
    private String realName;

    /**
     * 油箱
     */
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
