package com.fierew.adminx.domain;


import lombok.Data;

/**
 * 用户实体类
 * @author xuyang
 */
@Data
public class AdminUserDO {
    /**
     * 用户ID
     */
    private Integer id;

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
     * 密码
     */
    private String password;

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

    /**
     * 是否删除 1：删除，0：未删除
     */
    private Byte isDelete;

    /**
     * 写入数据库的时间（10位时间戳）
     */
    private Integer createTime;

    /**
     * 更新数据库的时间（10位时间戳）
     */
    private Integer updateTime;
}
