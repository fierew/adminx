package com.fierew.adminx.vo;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

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
     * 所有角色
     */
    private List<AdminRoleVO> roles;

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
     * 写入数据库的时间
     */
    private LocalDateTime createTime;

    /**
     * 更新数据库的时间
     */
    private LocalDateTime updateTime;
}
