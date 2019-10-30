DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `name` varchar(50) NOT NULL COMMENT '用户名',
  `password` varchar(100) COMMENT '密码',
  `salt` varchar(40) COMMENT '盐',
  `email` varchar(100) COMMENT '邮箱',
  `mobile` varchar(100) COMMENT '手机号',
  `org_id` int(11) COMMENT '机构ID',
  `user_status` int(2) NOT NULL DEFAULT '1' COMMENT '状态 0:禁用; 1:正常',
  `status` int(2) NOT NULL DEFAULT '1' COMMENT '状态 0:删除; 1:正常',
  `create_by` varchar(50) NOT NULL DEFAULT '' COMMENT '创建人',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_by` varchar(50) NOT NULL DEFAULT '' COMMENT '更新人',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_name`(`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户表';

DROP TABLE IF EXISTS `organization`;
CREATE TABLE `organization` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `name` varchar(50) NOT NULL DEFAULT '' COMMENT '组织名称',
  `parent_id` int(11) NOT NULL DEFAULT '0' COMMENT '上级组织ID，一级组织为0',
  `sort` int(8) NOT NULL DEFAULT '0' COMMENT '排序字段',
  `status` int(2) NOT NULL DEFAULT '1' COMMENT '状态 0:删除; 1:正常',
  `create_by` varchar(50) NOT NULL DEFAULT '' COMMENT '创建人',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_by` varchar(50) NOT NULL DEFAULT '' COMMENT '更新人',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='组织表';

DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `name` varchar(100) NOT NULL COMMENT '角色名称',
  `remark` varchar(100) NOT NULL DEFAULT '' COMMENT '备注',
  `status` int(2) NOT NULL DEFAULT '1' COMMENT '状态 0:删除; 1:正常',
  `create_by` varchar(50) NOT NULL DEFAULT '' COMMENT '创建人',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_by` varchar(50) NOT NULL DEFAULT '' COMMENT '更新人',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_name`(`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='角色表';

DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `name` varchar(50) NOT NULL COMMENT '菜单名称',
  `parent_id` int(11) NOT NULL DEFAULT '0' COMMENT '父菜单ID，一级菜单为0',
  `url` varchar(200) NOT NULL DEFAULT '' COMMENT '菜单URL',
  `perms` varchar(500) NOT NULL DEFAULT '' COMMENT '授权(多个用逗号分隔，如：user:view,user:create)',
  `type` int(2) NOT NULL COMMENT '类型 0:目录; 1:菜单; 2:按钮',
  `icon` varchar(50) NOT NULL DEFAULT '' COMMENT '菜单图标',
  `sort` int(8) NOT NULL DEFAULT '0' COMMENT '排序字段',
  `status` int(2) NOT NULL DEFAULT '1' COMMENT '状态 0:删除; 1:正常',
  `create_by` varchar(50) NOT NULL DEFAULT '' COMMENT '创建人',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_by` varchar(50) NOT NULL DEFAULT '' COMMENT '更新人',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='菜单表';

DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `user_id` int(11) NOT NULL COMMENT '用户ID',
  `role_id` int(11) NOT NULL COMMENT '角色ID',
  `create_by` varchar(50) NOT NULL DEFAULT '' COMMENT '创建人',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_by` varchar(50) NOT NULL DEFAULT '' COMMENT '更新人',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户角色表';

DROP TABLE IF EXISTS `role_org`;
CREATE TABLE `role_org` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `role_id` int(11) NOT NULL COMMENT '角色ID',
  `org_id` int(11) NOT NULL COMMENT '机构ID',
  `create_by` varchar(50) NOT NULL DEFAULT '' COMMENT '创建人',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_by` varchar(50) NOT NULL DEFAULT '' COMMENT '更新人',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='角色组织表';

DROP TABLE IF EXISTS `role_menu`;
CREATE TABLE `role_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `role_id` int(11) NOT NULL COMMENT '角色ID',
  `menu_id` int(11) NOT NULL COMMENT '菜单ID',
  `create_by` varchar(50) NOT NULL DEFAULT '' COMMENT '创建人',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_by` varchar(50) NOT NULL DEFAULT '' COMMENT '更新人',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='角色菜单表';

DROP TABLE IF EXISTS `user_token`;
CREATE TABLE `user_token` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `user_id` int(11) NOT NULL COMMENT '用户ID',
  `token` varchar(100) NOT NULL COMMENT 'token',
  `expire_time` datetime DEFAULT NULL COMMENT '过期时间',
  `create_by` varchar(50) NOT NULL DEFAULT '' COMMENT '创建人',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_by` varchar(50) NOT NULL DEFAULT '' COMMENT '更新人',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_token` (`token`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户Token表';

DROP TABLE IF EXISTS `sys_log`;
CREATE TABLE `sys_log` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `user_name` varchar(50) NOT NULL DEFAULT '' COMMENT '用户名',
  `operation` varchar(50) NOT NULL DEFAULT '' COMMENT '用户操作',
  `method` varchar(200) NOT NULL DEFAULT '' COMMENT '请求方法',
  `params` varchar(5000) NOT NULL DEFAULT '' COMMENT '请求参数',
  `time` int(11) NOT NULL COMMENT '执行时长(毫秒)',
  `ip` varchar(64) NOT NULL DEFAULT '' COMMENT 'IP地址',
  `create_by` varchar(50) NOT NULL DEFAULT '' COMMENT '创建人',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_by` varchar(50) NOT NULL DEFAULT '' COMMENT '更新人',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='系统日志表';

DROP TABLE IF EXISTS `dict`;
CREATE TABLE `dict` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `value` varchar(100) NOT NULL COMMENT '数据值',
  `label` varchar(100) NOT NULL COMMENT '标签名',
  `type` varchar(100) NOT NULL COMMENT '类型',
  `description` varchar(100) NOT NULL COMMENT '描述',
  `remarks` varchar(255) NOT NULL DEFAULT '' COMMENT '备注信息',
  `sort` int(8) NOT NULL DEFAULT '0' COMMENT '排序字段',
  `status` int(2) NOT NULL DEFAULT '1' COMMENT '状态 0:删除; 1:正常',
  `create_by` varchar(50) NOT NULL DEFAULT '' COMMENT '创建人',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_by` varchar(50) NOT NULL DEFAULT '' COMMENT '更新人',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='字典表';


-- 初始数据
INSERT INTO `user` (`id`, `name`, `password`, `salt`, `org_id`, `email`, `mobile`) VALUES ('1', 'admin', '9ec9750e709431dad22365cabc5c625482e574c74adaebba7dd02f1129e4ce1d', 'YzcmCZNvbXocrsz9dm8e', '4', 'admin@qq.com', '13612345678');
INSERT INTO `user` (`id`, `name`, `password`, `salt`, `org_id`, `email`, `mobile`) VALUES ('2', 'Louis', '9ec9750e709431dad22365cabc5c625482e574c74adaebba7dd02f1129e4ce1d', 'YzcmCZNvbXocrsz9dm8e', '6', 'louis@qq.com', '18200932238');
INSERT INTO `user` (`id`, `name`, `password`, `salt`, `org_id`, `email`, `mobile`) VALUES ('3', 'Kobe', '9ec9750e709431dad22365cabc5c625482e574c74adaebba7dd02f1129e4ce1d', 'YzcmCZNvbXocrsz9dm8e', '7', 'kobe@qq.com', '18200932238');
INSERT INTO `user` (`id`, `name`, `password`, `salt`, `org_id`, `email`, `mobile`) VALUES ('4', 'Iverson', '9ec9750e709431dad22365cabc5c625482e574c74adaebba7dd02f1129e4ce1d', 'YzcmCZNvbXocrsz9dm8e', '8', 'iverson@qq.com', '18200932238');
INSERT INTO `user` (`id`, `name`, `password`, `salt`, `org_id`, `email`, `mobile`) VALUES ('5', 'Iverson5', '9ec9750e709431dad22365cabc5c625482e574c74adaebba7dd02f1129e4ce1d', 'YzcmCZNvbXocrsz9dm8e', '12', 'iverson@qq.com', '18200932238');
INSERT INTO `user` (`id`, `name`, `password`, `salt`, `org_id`, `email`, `mobile`) VALUES ('6', 'Iverson6', '9ec9750e709431dad22365cabc5c625482e574c74adaebba7dd02f1129e4ce1d', 'YzcmCZNvbXocrsz9dm8e', '12', 'iverson@qq.com', '18200932238');
INSERT INTO `user` (`id`, `name`, `password`, `salt`, `org_id`, `email`, `mobile`) VALUES ('7', 'Iverson7', '9ec9750e709431dad22365cabc5c625482e574c74adaebba7dd02f1129e4ce1d', 'YzcmCZNvbXocrsz9dm8e', '13', 'iverson@qq.com', '18200932238');
INSERT INTO `user` (`id`, `name`, `password`, `salt`, `org_id`, `email`, `mobile`) VALUES ('8', 'Iverson8', '9ec9750e709431dad22365cabc5c625482e574c74adaebba7dd02f1129e4ce1d', 'YzcmCZNvbXocrsz9dm8e', '14', 'iverson@qq.com', '18200932238');
INSERT INTO `user` (`id`, `name`, `password`, `salt`, `org_id`, `email`, `mobile`) VALUES ('9', 'Iverson9', '9ec9750e709431dad22365cabc5c625482e574c74adaebba7dd02f1129e4ce1d', 'YzcmCZNvbXocrsz9dm8e', '15', 'iverson@qq.com', '18200932238');
INSERT INTO `user` (`id`, `name`, `password`, `salt`, `org_id`, `email`, `mobile`) VALUES ('10', 'Iverson10', '9ec9750e709431dad22365cabc5c625482e574c74adaebba7dd02f1129e4ce1d', 'YzcmCZNvbXocrsz9dm8e', '4', 'iverson@qq.com', '18200932238');
INSERT INTO `user` (`id`, `name`, `password`, `salt`, `org_id`, `email`, `mobile`) VALUES ('11', 'Iverson11', '9ec9750e709431dad22365cabc5c625482e574c74adaebba7dd02f1129e4ce1d', 'YzcmCZNvbXocrsz9dm8e', '6', 'iverson@qq.com', '18200932238');
INSERT INTO `user` (`id`, `name`, `password`, `salt`, `org_id`, `email`, `mobile`) VALUES ('12', 'Iverson12', '9ec9750e709431dad22365cabc5c625482e574c74adaebba7dd02f1129e4ce1d', 'YzcmCZNvbXocrsz9dm8e', '15', 'iverson@qq.com', '18200932238');

INSERT INTO `role` (`id`, `name`, `remark`) VALUES ('1', 'admin', '超级管理员');
INSERT INTO `role` (`id`, `name`, `remark`) VALUES ('2', 'dev', '开发人员');
INSERT INTO `role` (`id`, `name`, `remark`) VALUES ('3', 'test', '测试人员');

INSERT INTO `user_role` (`id`, `user_id`, `role_id`) VALUES ('1', '1', '1');
INSERT INTO `user_role` (`id`, `user_id`, `role_id`) VALUES ('2', '2', '1');
INSERT INTO `user_role` (`id`, `user_id`, `role_id`) VALUES ('3', '3', '2');
INSERT INTO `user_role` (`id`, `user_id`, `role_id`) VALUES ('4', '4', '3');

INSERT INTO `organization` (`id`, `parent_id`, `name`, `sort`) VALUES ('1', '0', 'S集团', '0');
INSERT INTO `organization` (`id`, `parent_id`, `name`, `sort`) VALUES ('2', '1', '北京分公司', '1');
INSERT INTO `organization` (`id`, `parent_id`, `name`, `sort`) VALUES ('3', '1', '上海分公司', '2');
INSERT INTO `organization` (`id`, `parent_id`, `name`, `sort`) VALUES ('4', '3', '技术部', '0');
INSERT INTO `organization` (`id`, `parent_id`, `name`, `sort`) VALUES ('6', '3', '宣传部', '1');
INSERT INTO `organization` (`id`, `parent_id`, `name`, `sort`) VALUES ('7', '3', '销售部', '2');
INSERT INTO `organization` (`id`, `parent_id`, `name`, `sort`) VALUES ('8', '3', '市场部', '3');
INSERT INTO `organization` (`id`, `parent_id`, `name`, `sort`) VALUES ('9', '0', 'T集团', '1');
INSERT INTO `organization` (`id`, `parent_id`, `name`, `sort`) VALUES ('10', '9', '北京分公司', '1');
INSERT INTO `organization` (`id`, `parent_id`, `name`, `sort`) VALUES ('11', '9', '上海分公司', '2');
INSERT INTO `organization` (`id`, `parent_id`, `name`, `sort`) VALUES ('12', '10', '技术部', '1');
INSERT INTO `organization` (`id`, `parent_id`, `name`, `sort`) VALUES ('13', '10', '宣传部', '2');
INSERT INTO `organization` (`id`, `parent_id`, `name`, `sort`) VALUES ('14', '11', '销售部', '1');
INSERT INTO `organization` (`id`, `parent_id`, `name`, `sort`) VALUES ('15', '11', '市场部', '2');

INSERT INTO `menu` (`id`, `parent_id`, `name`, `url`, `perms`, `type`, `icon`, `sort`) VALUES ('1', '0', '系统管理', '', '', '0', 'fa el-icon-setting', '0');
INSERT INTO `menu` (`id`, `parent_id`, `name`, `url`, `perms`, `type`, `icon`, `sort`) VALUES ('2', '1', '用户管理', '/sys/user', '', '1', 'el-icon-service', '1');
INSERT INTO `menu` (`id`, `parent_id`, `name`, `url`, `perms`, `type`, `icon`, `sort`) VALUES ('3', '1', '机构管理', '/sys/dept', '', '1', 'el-icon-news', '2');
INSERT INTO `menu` (`id`, `parent_id`, `name`, `url`, `perms`, `type`, `icon`, `sort`) VALUES ('4', '1', '角色管理', '/sys/role', '', '1', 'el-icon-view', '4');
INSERT INTO `menu` (`id`, `parent_id`, `name`, `url`, `perms`, `type`, `icon`, `sort`) VALUES ('5', '1', '菜单管理', '/sys/menu', '', '1', 'el-icon-menu', '5');
INSERT INTO `menu` (`id`, `parent_id`, `name`, `url`, `perms`, `type`, `icon`, `sort`) VALUES ('6', '1', 'SQL监控', '/druid/sql', '', '1', 'el-icon-info', '6');
INSERT INTO `menu` (`id`, `parent_id`, `name`, `url`, `perms`, `type`, `icon`, `sort`) VALUES ('8', '1', '系统日志', '/sys/log', 'sys:log:view', '1', 'el-icon-info', '7');
INSERT INTO `menu` (`id`, `parent_id`, `name`, `url`, `perms`, `type`, `icon`, `sort`) VALUES ('9', '2', '查看', '', 'sys:user:view', '2', '', '0');
INSERT INTO `menu` (`id`, `parent_id`, `name`, `url`, `perms`, `type`, `icon`, `sort`) VALUES ('10', '2', '新增', '', 'sys:user:add', '2', '', '0');
INSERT INTO `menu` (`id`, `parent_id`, `name`, `url`, `perms`, `type`, `icon`, `sort`) VALUES ('11', '2', '修改', '', 'sys:user:edit', '2', '', '0');
INSERT INTO `menu` (`id`, `parent_id`, `name`, `url`, `perms`, `type`, `icon`, `sort`) VALUES ('12', '2', '删除', '', 'sys:user:delete', '2', '', '0');
INSERT INTO `menu` (`id`, `parent_id`, `name`, `url`, `perms`, `type`, `icon`, `sort`) VALUES ('13', '3', '查看', '', 'sys:dept:view', '2', '', '0');
INSERT INTO `menu` (`id`, `parent_id`, `name`, `url`, `perms`, `type`, `icon`, `sort`) VALUES ('14', '3', '新增', '', 'sys:dept:add', '2', '', '0');
INSERT INTO `menu` (`id`, `parent_id`, `name`, `url`, `perms`, `type`, `icon`, `sort`) VALUES ('15', '3', '修改', '', 'sys:dept:edit', '2', '', '0');
INSERT INTO `menu` (`id`, `parent_id`, `name`, `url`, `perms`, `type`, `icon`, `sort`) VALUES ('16', '3', '删除', '', 'sys:dept:delete', '2', '', '0');
INSERT INTO `menu` (`id`, `parent_id`, `name`, `url`, `perms`, `type`, `icon`, `sort`) VALUES ('17', '4', '查看', '', 'sys:role:view', '2', '', '0');
INSERT INTO `menu` (`id`, `parent_id`, `name`, `url`, `perms`, `type`, `icon`, `sort`) VALUES ('18', '4', '新增', '', 'sys:role:add', '2', '', '0');
INSERT INTO `menu` (`id`, `parent_id`, `name`, `url`, `perms`, `type`, `icon`, `sort`) VALUES ('19', '4', '修改', '', 'sys:role:edit', '2', '', '0');
INSERT INTO `menu` (`id`, `parent_id`, `name`, `url`, `perms`, `type`, `icon`, `sort`) VALUES ('20', '4', '删除', '', 'sys:role:delete', '2', '', '0');
INSERT INTO `menu` (`id`, `parent_id`, `name`, `url`, `perms`, `type`, `icon`, `sort`) VALUES ('21', '5', '查看', '', 'sys:menu:view', '2', '', '0');
INSERT INTO `menu` (`id`, `parent_id`, `name`, `url`, `perms`, `type`, `icon`, `sort`) VALUES ('22', '5', '新增', '', 'sys:menu:add', '2', '', '0');
INSERT INTO `menu` (`id`, `parent_id`, `name`, `url`, `perms`, `type`, `icon`, `sort`) VALUES ('23', '5', '修改', '', 'sys:menu:edit', '2', '', '0');
INSERT INTO `menu` (`id`, `parent_id`, `name`, `url`, `perms`, `type`, `icon`, `sort`) VALUES ('24', '5', '删除', '', 'sys:menu:delete', '2', '', '0');
INSERT INTO `menu` (`id`, `parent_id`, `name`, `url`, `perms`, `type`, `icon`, `sort`) VALUES ('25', '0', '内容管理', '', '', '0', 'el-icon-document','0');
INSERT INTO `menu` (`id`, `parent_id`, `name`, `url`, `perms`, `type`, `icon`, `sort`) VALUES ('26', '25', '栏目管理', '/content/category', '', '1', 'el-icon-tickets', '1');
INSERT INTO `menu` (`id`, `parent_id`, `name`, `url`, `perms`, `type`, `icon`, `sort`) VALUES ('27', '25', '文章管理', '/content/artical', '', '1', 'el-icon-tickets', '2');
INSERT INTO `menu` (`id`, `parent_id`, `name`, `url`, `perms`, `type`, `icon`, `sort`) VALUES ('28', '0', '使用案例', '', '', '0', 'el-icon-picture-outline', '0');
INSERT INTO `menu` (`id`, `parent_id`, `name`, `url`, `perms`, `type`, `icon`, `sort`) VALUES ('29', '28', '国际化', '/demo/i18n', '', '1', 'el-icon-edit', '1');
INSERT INTO `menu` (`id`, `parent_id`, `name`, `url`, `perms`, `type`, `icon`, `sort`) VALUES ('30', '28', '换皮肤', '/demo/theme', '', '1', 'el-icon-picture', '2');

INSERT INTO `role_menu` (`id`, `role_id`, `menu_id`) VALUES ('1', '2', '25');
INSERT INTO `role_menu` (`id`, `role_id`, `menu_id`) VALUES ('2', '2', '26');
INSERT INTO `role_menu` (`id`, `role_id`, `menu_id`) VALUES ('3', '2', '27');
INSERT INTO `role_menu` (`id`, `role_id`, `menu_id`) VALUES ('4', '2', '28');
INSERT INTO `role_menu` (`id`, `role_id`, `menu_id`) VALUES ('5', '2', '29');
INSERT INTO `role_menu` (`id`, `role_id`, `menu_id`) VALUES ('6', '2', '30');
INSERT INTO `role_menu` (`id`, `role_id`, `menu_id`) VALUES ('7', '3', '25');
INSERT INTO `role_menu` (`id`, `role_id`, `menu_id`) VALUES ('8', '3', '26');
INSERT INTO `role_menu` (`id`, `role_id`, `menu_id`) VALUES ('9', '3', '27');
INSERT INTO `role_menu` (`id`, `role_id`, `menu_id`) VALUES ('10', '3', '28');
INSERT INTO `role_menu` (`id`, `role_id`, `menu_id`) VALUES ('11', '3', '29');
INSERT INTO `role_menu` (`id`, `role_id`, `menu_id`) VALUES ('12', '3', '30');

INSERT INTO `dict` (`id`, `value`, `label`, `type`, `description`, `sort`) VALUES ('1', 'male', '男', 'sex', '男性', '0');
INSERT INTO `dict` (`id`, `value`, `label`, `type`, `description`, `sort`) VALUES ('2', 'female', '女', 'sex', '女性', '1');