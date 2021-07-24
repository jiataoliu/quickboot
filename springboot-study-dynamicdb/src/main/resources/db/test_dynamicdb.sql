-- 创建三个数据库
DROP DATABASE IF EXISTS `springboot_study_master`;
CREATE DATABASE `springboot_study_master` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;

DROP DATABASE IF EXISTS `springboot_study_slave1`;
CREATE DATABASE `springboot_study_slave1` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;

DROP DATABASE IF EXISTS `springboot_study_slave2`;
CREATE DATABASE `springboot_study_slave2` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;

-- 创建三个数据表
DROP TABLE IF EXISTS `springboot_study_master`.`test_dynamicdb`;
CREATE TABLE `springboot_study_master`.`test_dynamicdb` (
  `user_id` 	int(11) 	 NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `user_name` 	varchar(32)  DEFAULT ''				 COMMENT '用户名',
  `password`    varchar(32)  DEFAULT ''              COMMENT '密码',
  `status`      int(2)       DEFAULT 0               COMMENT '状态 0-删除 1-正常',
  `create_time` datetime(0)  DEFAULT NULL            COMMENT '创建时间',
  `login_time`  datetime(0)  DEFAULT NULL            COMMENT '登录时间',
  `remark`      varchar(128) DEFAULT ''              COMMENT '备注',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=100 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='测试表';

DROP TABLE IF EXISTS `springboot_study_slave1`.`test_dynamicdb`;
CREATE TABLE `springboot_study_slave1`.`test_dynamicdb` (
  `user_id` 	int(11) 	 NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `user_name` 	varchar(32)  DEFAULT ''				 COMMENT '用户名',
  `password`    varchar(32)  DEFAULT ''              COMMENT '密码',
  `status`      int(2)       DEFAULT 0               COMMENT '状态 0-删除 1-正常',
  `create_time` datetime(0)  DEFAULT NULL            COMMENT '创建时间',
  `login_time`  datetime(0)  DEFAULT NULL            COMMENT '登录时间',
  `remark`      varchar(128) DEFAULT ''              COMMENT '备注',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=100 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='测试表';

DROP TABLE IF EXISTS `springboot_study_slave2`.`test_dynamicdb`;
CREATE TABLE `springboot_study_slave2`.`test_dynamicdb` (
  `user_id` 	int(11) 	 NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `user_name` 	varchar(32)  DEFAULT ''				 COMMENT '用户名',
  `password`    varchar(32)  DEFAULT ''              COMMENT '密码',
  `status`      int(2)       DEFAULT 0               COMMENT '状态 0-删除 1-正常',
  `create_time` datetime(0)  DEFAULT NULL            COMMENT '创建时间',
  `login_time`  datetime(0)  DEFAULT NULL            COMMENT '登录时间',
  `remark`      varchar(128) DEFAULT ''              COMMENT '备注',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=100 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='测试表';

-- 插入测试数据
INSERT INTO `springboot_study_master`.`test_dynamicdb` VALUES(1, '张三', '666666', 1, sysdate(), sysdate(), '');
INSERT INTO `springboot_study_master`.`test_dynamicdb` VALUES(2, '李四', '666666', 1, sysdate(), sysdate(), '');
INSERT INTO `springboot_study_slave1`.`test_dynamicdb` VALUES(3, '王五', '666666', 1, sysdate(), sysdate(), '');
INSERT INTO `springboot_study_slave1`.`test_dynamicdb` VALUES(4, '赵六', '666666', 1, sysdate(), sysdate(), '');
INSERT INTO `springboot_study_slave2`.`test_dynamicdb` VALUES(5, '田七', '666666', 1, sysdate(), sysdate(), '');

-- 查询测试数据
SELECT * FROM `springboot_study_master`.`test_dynamicdb`;
SELECT * FROM `springboot_study_slave1`.`test_dynamicdb`;
SELECT * FROM `springboot_study_slave2`.`test_dynamicdb`;
