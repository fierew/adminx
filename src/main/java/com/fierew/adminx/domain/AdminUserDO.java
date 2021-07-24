package com.fierew.adminx.domain;


import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.time.LocalDateTime;

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
     * 邮箱
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
    private Byte isDeleted;

    /**
     * 写入数据库的时间
     */
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    /**
     * 更新数据库的时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;
}
