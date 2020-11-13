CREATE TABLE `auth-jwt`.`user`  (
  `id` int(0) UNSIGNED NOT NULL AUTO_INCREMENT,
  `acount` varchar(32) NOT NULL,
  `user_name` varchar(16) NOT NULL COMMENT '姓名',
  `password` varchar(64) NOT NULL,
  `salt` varchar(16) NOT NULL,
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0),
  `del_flag` tinyint(2) NOT NULL DEFAULT 0,
  `del_time` datetime(0) NULL,
  PRIMARY KEY (`id`)
);