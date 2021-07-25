-- ==================== test_shiro ====================
-- 1、测试用户表
DROP TABLE IF EXISTS `springboot_study`.`test_shiro_user`;
CREATE TABLE `springboot_study`.`test_shiro_user` (
  `user_id` 	int(11) 	 NOT NULL AUTO_INCREMENT COMMENT ''ID'',
  `user_name` 	varchar(32)  DEFAULT ''''				 COMMENT ''用户名'',
  `password`    varchar(128) DEFAULT ''''              COMMENT ''密码'',
  `salt`    	varchar(32)  DEFAULT ''''              COMMENT ''盐'',
  `status`      int(2)       DEFAULT 0               COMMENT ''状态 0-删除 1-正常'',
  `create_time` datetime(0)  DEFAULT NULL            COMMENT ''创建时间'',
  `login_time`  datetime(0)  DEFAULT NULL            COMMENT ''登录时间'',
  `remark`      varchar(128) DEFAULT ''''              COMMENT ''备注'',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=100 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT=''测试用户表'';

-- 2、测试角色表
DROP TABLE IF EXISTS `springboot_study`.`test_shiro_role`;
CREATE TABLE `springboot_study`.`test_shiro_role` (
  `role_id` 	int(11) 	 NOT NULL AUTO_INCREMENT COMMENT ''角色ID'',
  `role_name` 	varchar(32)  DEFAULT ''''				 COMMENT ''角色名称'',
  `status`      int(2)       DEFAULT 0               COMMENT ''状态 0-删除 1-正常'',
  `create_time` datetime(0)  DEFAULT NULL            COMMENT ''创建时间'',
  `remark`      varchar(128) DEFAULT ''''              COMMENT ''备注'',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=100 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT=''测试角色表'';

-- 3、测试权限表
DROP TABLE IF EXISTS `springboot_study`.`test_shiro_permission`;
CREATE TABLE `springboot_study`.`test_shiro_permission` (
  `permission_id`	int(11) 	 NOT NULL AUTO_INCREMENT COMMENT ''权限ID'',
  `permission_name` varchar(32)  DEFAULT ''''				 COMMENT ''权限名称'',
  `status`      	int(2)       DEFAULT 0               COMMENT ''状态 0-删除 1-正常'',
  `create_time` 	datetime(0)  DEFAULT NULL            COMMENT ''创建时间'',
  `remark`      	varchar(128) DEFAULT ''''              COMMENT ''备注'',
  PRIMARY KEY (`permission_id`)
) ENGINE=InnoDB AUTO_INCREMENT=100 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT=''测试权限表'';

-- 4、测试用户角色关联表
DROP TABLE IF EXISTS `springboot_study`.`test_shiro_user_role`;
CREATE TABLE `springboot_study`.`test_shiro_user_role` (
  `id` 			int(11) 	 NOT NULL AUTO_INCREMENT COMMENT ''ID'',
  `user_id`     int(11)      DEFAULT 0               COMMENT ''用户ID'',
  `role_id`     int(11)      DEFAULT 0               COMMENT ''角色ID'',
  `status`      int(2)       DEFAULT 0               COMMENT ''状态 0-删除 1-正常'',
  `create_time` datetime(0)  DEFAULT NULL            COMMENT ''创建时间'',
  `remark`      varchar(128) DEFAULT ''''              COMMENT ''备注'',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=100 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT=''测试用户角色关联表'';

-- 5、测试角色权限关联表
DROP TABLE IF EXISTS `springboot_study`.`test_shiro_role_permission`;
CREATE TABLE `springboot_study`.`test_shiro_role_permission` (
  `id` 				int(11) 	 NOT NULL AUTO_INCREMENT COMMENT ''ID'',
  `role_id`     	int(11)      DEFAULT 0               COMMENT ''角色ID'',
  `permission_id`	int(11)      DEFAULT 0               COMMENT ''权限ID'',
  `status`      	int(2)       DEFAULT 0               COMMENT ''状态 0-删除 1-正常'',
  `create_time` 	datetime(0)  DEFAULT NULL            COMMENT ''创建时间'',
  `remark`      	varchar(128) DEFAULT ''''              COMMENT ''备注'',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=100 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT=''测试角色权限关联表'';

-- 插入测试用户表数据
INSERT INTO `springboot_study`.`test_shiro_user` VALUES(1, ''张三'', ''bed4fa42795bd072805200bf871f04f13d37287f1f0230fae193ccb10001278a'', ''salt'', 1, sysdate(), sysdate(), ''666666'');
INSERT INTO `springboot_study`.`test_shiro_user` VALUES(2, ''李四'', ''bed4fa42795bd072805200bf871f04f13d37287f1f0230fae193ccb10001278a'', ''salt'', 1, sysdate(), sysdate(), ''666666'');
INSERT INTO `springboot_study`.`test_shiro_user` VALUES(3, ''王五'', ''bed4fa42795bd072805200bf871f04f13d37287f1f0230fae193ccb10001278a'', ''salt'', 1, sysdate(), sysdate(), ''666666'');
INSERT INTO `springboot_study`.`test_shiro_user` VALUES(4, ''赵六'', ''bed4fa42795bd072805200bf871f04f13d37287f1f0230fae193ccb10001278a'', ''salt'', 1, sysdate(), sysdate(), ''666666'');
INSERT INTO `springboot_study`.`test_shiro_user` VALUES(5, ''田七'', ''bed4fa42795bd072805200bf871f04f13d37287f1f0230fae193ccb10001278a'', ''salt'', 1, sysdate(), sysdate(), ''666666'');

-- 插入测试角色表数据
INSERT INTO `springboot_study`.`test_shiro_role` VALUES(1, ''sys'', 	1, sysdate(), ''超级管理员角色'');
INSERT INTO `springboot_study`.`test_shiro_role` VALUES(2, ''admin'', 1, sysdate(), ''普通管理员角色'');
INSERT INTO `springboot_study`.`test_shiro_role` VALUES(3, ''user'', 	1, sysdate(), ''管理员角色'');

-- 插入测试权限表数据
INSERT INTO `springboot_study`.`test_shiro_permission` VALUES(1, ''sys:*:*'',			1, sysdate(), ''系统管理权限'');
INSERT INTO `springboot_study`.`test_shiro_permission` VALUES(2, ''order:*:*'',		1, sysdate(), ''订单管理权限'');
INSERT INTO `springboot_study`.`test_shiro_permission` VALUES(3, ''order:add:*'', 	1, sysdate(), ''订单创建权限'');
INSERT INTO `springboot_study`.`test_shiro_permission` VALUES(4, ''order:find:*'', 	1, sysdate(), ''订单查询权限'');

-- 插入测试用户角色关联表数据
INSERT INTO `springboot_study`.`test_shiro_user_role` VALUES(1, 1, 1, 1, sysdate(), ''张三 拥有 超级管理员角色'');
INSERT INTO `springboot_study`.`test_shiro_user_role` VALUES(2, 2, 2, 1, sysdate(), ''李四 拥有 普通管理员角色'');
INSERT INTO `springboot_study`.`test_shiro_user_role` VALUES(3, 3, 3, 1, sysdate(), ''王五 拥有 管理员角色'');

-- 插入测试角色权限关联表数据
INSERT INTO `springboot_study`.`test_shiro_role_permission` VALUES(1, 1, 1, 1, sysdate(), ''超级管理员 拥有 系统管理权限'');
INSERT INTO `springboot_study`.`test_shiro_role_permission` VALUES(2, 1, 2, 1, sysdate(), ''超级管理员 拥有 订单管理权限'');
INSERT INTO `springboot_study`.`test_shiro_role_permission` VALUES(3, 2, 2, 1, sysdate(), ''普通管理员 拥有 订单管理权限'');
INSERT INTO `springboot_study`.`test_shiro_role_permission` VALUES(4, 3, 3, 1, sysdate(), ''管理员     拥有 订单创建权限'');
INSERT INTO `springboot_study`.`test_shiro_role_permission` VALUES(5, 3, 4, 1, sysdate(), ''管理员     拥有 订单查询权限'');

-- 查询测试数据
SELECT * FROM `springboot_study`.`test_shiro_user`;
SELECT * FROM `springboot_study`.`test_shiro_role`;
SELECT * FROM `springboot_study`.`test_shiro_permission`;

SELECT * FROM `springboot_study`.`test_shiro_user_role`;
SELECT * FROM `springboot_study`.`test_shiro_role_permission`;
