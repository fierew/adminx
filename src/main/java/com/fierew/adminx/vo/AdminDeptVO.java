package com.fierew.adminx.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(callSuper = true)
public class AdminDeptVO extends TreeNode {
    /**
     * 部门名称
     */
    private String name;

    /**
     * 每个层级的关系
     */
    private String nodePath;

    /**
     * 备注
     */
    private String remarks;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 写入数据库的时间
     */
    private LocalDateTime createTime;
}
