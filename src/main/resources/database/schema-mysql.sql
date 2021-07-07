CREATE TABLE IF NOT EXISTS `ax_admin_user` (
    `id` int NOT NULL AUTO_INCREMENT COMMENT '用户ID',
    `role_id` int NOT NULL DEFAULT '0' COMMENT '角色ID',
    `dept_id` int NOT NULL DEFAULT '0' COMMENT '部门ID',
    `username` varchar(100) NOT NULL DEFAULT '' COMMENT '用户名',
    `password` varchar(256) NOT NULL DEFAULT '' COMMENT '密码',
    `realName` varchar(10) NOT NULL DEFAULT '' COMMENT '真实姓名',
    `mail` varchar(255) NOT NULL DEFAULT '' COMMENT '邮箱',
    `mobile` varchar(16) NOT NULL DEFAULT '' COMMENT '手机号',
    `sex` tinyint(1) NOT NULL DEFAULT '0' COMMENT '性别：0.未知，1.男，2.女',
    `age` int NOT NULL DEFAULT '0' COMMENT '年龄',
    `loginNum` int NOT NULL DEFAULT '0' COMMENT '登陆次数',
    `state` tinyint(1) NOT NULL DEFAULT '0' COMMENT '状态：0.启用，1.禁用',
    `is_deleted` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否删除：0.未删除，1.已删除',
    `create_time` datetime NOT NULL COMMENT '创建时间戳',
    `update_time` datetime NOT NULL COMMENT '更新时间戳',
    PRIMARY KEY (`id`),
    KEY `username_index` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='管理用户表';