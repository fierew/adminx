CREATE TABLE IF NOT EXISTS `ax_admin_user` (
    `id` int NOT NULL AUTO_INCREMENT COMMENT '用户ID',
    `dept_id` int NOT NULL DEFAULT '0' COMMENT '部门ID',
    `username` varchar(100) NOT NULL DEFAULT '' COMMENT '用户名',
    `password` varchar(256) NOT NULL DEFAULT '' COMMENT '密码',
    `realName` varchar(10) NOT NULL DEFAULT '' COMMENT '真实姓名',
    `mail` varchar(255) NOT NULL DEFAULT '' COMMENT '邮箱',
    `mobile` varchar(16) NOT NULL DEFAULT '' COMMENT '手机号',
    `sex` tinyint NOT NULL DEFAULT '0' COMMENT '性别：0.未知，1.男，2.女',
    `age` int NOT NULL DEFAULT '0' COMMENT '年龄',
    `loginNum` int NOT NULL DEFAULT '0' COMMENT '登陆次数',
    `state` tinyint NOT NULL DEFAULT '0' COMMENT '状态：0.启用，1.禁用',
    `is_deleted` tinyint NOT NULL DEFAULT '0' COMMENT '是否删除：0.未删除，1.已删除',
    `create_time` datetime NOT NULL COMMENT '创建时间戳',
    `update_time` datetime NOT NULL COMMENT '更新时间戳',
    PRIMARY KEY (`id`),
    KEY `username_index` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=10000 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='管理系统用户表';


CREATE TABLE IF NOT EXISTS `ax_admin_dept` (
    `id` int NOT NULL AUTO_INCREMENT COMMENT '部门ID',
    `parentId` int NOT NULL DEFAULT '0' COMMENT '父级ID',
    `name` varchar(50) NOT NULL DEFAULT '' COMMENT '部门名称',
    `nodePath` varchar(100) NOT NULL DEFAULT '' COMMENT '层级关系',
    `remarks` varchar(100) NOT NULL DEFAULT '' COMMENT '备注',
    `sort` int NOT NULL DEFAULT '0' COMMENT '排序',
    `is_deleted` tinyint NOT NULL DEFAULT '0' COMMENT '是否删除：0.未删除，1.已删除',
    `create_time` datetime NOT NULL COMMENT '创建时间戳',
    `update_time` datetime NOT NULL COMMENT '更新时间戳',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='管理系统部门表';


CREATE TABLE IF NOT EXISTS `ax_admin_user_role` (
    `id` int NOT NULL AUTO_INCREMENT COMMENT '主键ID',
    `user_id` int NOT NULL DEFAULT '0' COMMENT '用户ID',
    `role_id` int NOT NULL DEFAULT '0' COMMENT '角色ID',
    `is_deleted` tinyint NOT NULL DEFAULT '0' COMMENT '是否删除：0.未删除，1.已删除',
    `create_time` datetime NOT NULL COMMENT '创建时间戳',
    `update_time` datetime NOT NULL COMMENT '更新时间戳',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='管理系统用户角色关联关系表';


CREATE TABLE IF NOT EXISTS `ax_admin_role` (
    `id` int NOT NULL AUTO_INCREMENT COMMENT '角色ID',
    `name` varchar(50) NOT NULL DEFAULT '' COMMENT '角色名称',
    `remarks` varchar(100) NOT NULL DEFAULT '' COMMENT '备注',
    `sort` int NOT NULL DEFAULT '0' COMMENT '排序',
    `is_deleted` tinyint NOT NULL DEFAULT '0' COMMENT '是否删除：0.未删除，1.已删除',
    `create_time` datetime NOT NULL COMMENT '创建时间戳',
    `update_time` datetime NOT NULL COMMENT '更新时间戳',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='管理系统角色表';


CREATE TABLE IF NOT EXISTS `ax_admin_role_resource` (
    `id` int NOT NULL AUTO_INCREMENT COMMENT '主键ID',
    `role_id` int NOT NULL DEFAULT '0' COMMENT '角色ID',
    `resource_id` int NOT NULL DEFAULT '0' COMMENT '资源ID',
    `is_deleted` tinyint NOT NULL DEFAULT '0' COMMENT '是否删除：0.未删除，1.已删除',
    `create_time` datetime NOT NULL COMMENT '创建时间戳',
    `update_time` datetime NOT NULL COMMENT '更新时间戳',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='管理系统角色资源关联关系表';


CREATE TABLE IF NOT EXISTS `ax_admin_resource` (
    `id` int NOT NULL AUTO_INCREMENT COMMENT '资源ID',
    `parentId` int NOT NULL DEFAULT '0' COMMENT '父级ID',
    `name` varchar(50) NOT NULL DEFAULT '' COMMENT '资源名称',
    `nodePath` varchar(100) NOT NULL DEFAULT '' COMMENT '层级关系',
    `icon` varchar(100) NOT NULL DEFAULT '' COMMENT '图标',
    `type` tinyint NOT NULL DEFAULT '0' COMMENT '类型 1：菜单，2：按钮, 3:api',
    `key` varchar(50) NOT NULL DEFAULT '' COMMENT '权限标识',
    `isHide` tinyint NOT NULL DEFAULT '0' COMMENT '菜单或按钮是否隐藏 1：隐藏，0：显示',
    `remarks` varchar(100) NOT NULL DEFAULT '' COMMENT '备注',
    `state` tinyint NOT NULL DEFAULT '0' COMMENT '状态：0.启用，1.禁用',
    `sort` int NOT NULL DEFAULT '0' COMMENT '排序',
    `is_deleted` tinyint NOT NULL DEFAULT '0' COMMENT '是否删除：0.未删除，1.已删除',
    `create_time` datetime NOT NULL COMMENT '创建时间戳',
    `update_time` datetime NOT NULL COMMENT '更新时间戳',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='管理系统资源表';


CREATE TABLE IF NOT EXISTS `ax_admin_log` (
    `id` int NOT NULL AUTO_INCREMENT COMMENT '日志ID',
    `user_id` int NOT NULL DEFAULT '0' COMMENT '用户ID',
    `method` varchar(10) NOT NULL DEFAULT '' COMMENT '请求类型',
    `function` varchar(100) NOT NULL DEFAULT '' COMMENT '请求方法',
    `url` varchar(255) NOT NULL DEFAULT '' COMMENT '请求网址',
    `param` varchar(1000) NOT NULL DEFAULT '' COMMENT '请求参数',
    `ip` varchar(15) NOT NULL DEFAULT '' COMMENT 'IP',
    `location` varchar(255) NOT NULL DEFAULT '' COMMENT '位置地址',
    `browser` varchar(50) NOT NULL DEFAULT '' COMMENT '浏览器',
    `browser_info` varchar(150) NOT NULL DEFAULT '' COMMENT '浏览器信息',
    `takeTime` int NOT NULL DEFAULT '0' COMMENT '耗时时间（毫秒）',
    `is_deleted` tinyint NOT NULL DEFAULT '0' COMMENT '是否删除：0.未删除，1.已删除',
    `create_time` datetime NOT NULL COMMENT '创建时间戳',
    `update_time` datetime NOT NULL COMMENT '更新时间戳',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='管理系统日志表';


CREATE TABLE IF NOT EXISTS `ax_admin_config` (
    `id` int NOT NULL AUTO_INCREMENT COMMENT 'ID',
    `name` varchar(50) NOT NULL DEFAULT '' COMMENT '配置名称',
    `type` tinyint NOT NULL DEFAULT '0' COMMENT '配置类型：[input]单行文本,[textarea]多行文本,[array]数组,[switch]开关,[radio]单选按钮,[checkbox]多选框,[tags]标签,[select]下拉框,[image]图片,[file]文件,[date]日期,[datetime]日期+时间,[time]时间',
    `key` varchar(20) NOT NULL DEFAULT '' COMMENT '配置标识',
    `value` varchar(1000) NOT NULL DEFAULT '' COMMENT '配置值',
    `option` varchar(1000) NOT NULL DEFAULT '' COMMENT '配置选项，存储JSON数据',
    `remarks` varchar(100) NOT NULL DEFAULT '' COMMENT '备注',
    `is_deleted` tinyint NOT NULL DEFAULT '0' COMMENT '是否删除：0.未删除，1.已删除',
    `create_time` datetime NOT NULL COMMENT '创建时间戳',
    `update_time` datetime NOT NULL COMMENT '更新时间戳',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='管理系统配置表';