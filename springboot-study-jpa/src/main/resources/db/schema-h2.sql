-- 创建一个表
DROP TABLE IF EXISTS `test_jpa`;
CREATE TABLE `test_jpa` (
  `user_id` 	int(11) 	 NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `user_name` 	varchar(32)  DEFAULT ''				 COMMENT '用户名',
  `password`    varchar(32)  DEFAULT ''              COMMENT '密码',
  `status`      int(2)       DEFAULT 0               COMMENT '状态 0-删除 1-正常',
  `create_time` datetime(0)  DEFAULT NULL            COMMENT '创建时间',
  `login_time`  datetime(0)  DEFAULT NULL            COMMENT '登录时间',
  `remark`      varchar(128) DEFAULT ''              COMMENT '备注',
  PRIMARY KEY (`user_id`)
);
