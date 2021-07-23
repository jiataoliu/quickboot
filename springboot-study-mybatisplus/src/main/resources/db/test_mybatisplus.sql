-- 查询当前用户下所有数据库
SHOW DATABASES;

-- 创建一个数据库
DROP DATABASE IF EXISTS `springboot_study`;
CREATE DATABASE `springboot_study` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;

-- 查看创建数据库的信息
SHOW CREATE DATABASE `springboot_study`;

-- 查询当前操作所在的数据库名称
SELECT DATABASE();

-- 选择数据库
USE `springboot_study`;

-- 创建一个表
DROP TABLE IF EXISTS `test_mybatis_plus`;
CREATE TABLE `test_mybatis_plus` (
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
INSERT INTO `test_mybatis_plus` VALUES(1, '张三', '666666', 1, sysdate(), sysdate(), '');
INSERT INTO `test_mybatis_plus` VALUES(2, '李四', '666666', 1, sysdate(), sysdate(), '');
INSERT INTO `test_mybatis_plus` VALUES(3, '王五', '666666', 1, sysdate(), sysdate(), '');
INSERT INTO `test_mybatis_plus` VALUES(4, '赵六', '666666', 1, sysdate(), sysdate(), '');
INSERT INTO `test_mybatis_plus` VALUES(5, '田七', '666666', 1, sysdate(), sysdate(), '');

-- 查询测试数据
SELECT * FROM `test_mybatis_plus`;
