# lemon1234_pim

## 使用技术

	- redis
	- elasticsearch
	- security
	- mybatis plus
	- JWT
	- swagger2
	- logback
	
## 项目编码

	项目编码：UTF-8
	
## 数据库

### 删除数据库
	DROP TABLE IF EXISTS `t_pim_admin`;
	DROP TABLE IF EXISTS `t_pim_admin_role`;
	DROP TABLE IF EXISTS `t_pim_role`;
	DROP TABLE IF EXISTS `t_pim_accountlog`;
	DROP TABLE IF EXISTS `t_pim_user`;
	
### 创建表

	-- admin 管理员表
	CREATE TABLE `t_pim_admin`  (
		`id` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
		`username` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
		`password` varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
		`createDt` datetime(0) NULL DEFAULT NULL,
		`email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
		`phoneNum` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
		`gender` int(0) NULL DEFAULT NULL,
		`name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
		`img` varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
		`ban` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
		PRIMARY KEY (`id`) USING BTREE
	) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;
	

	-- admin & role 管理员权限表
	CREATE TABLE `t_pim_admin_role`  (
		`id` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
		`adminId` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
		`roleId` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
		PRIMARY KEY (`id`) USING BTREE
	) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;


	-- role 权限表
	CREATE TABLE `t_pim_role`  (
		`id` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
		`name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
		`engName` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
		PRIMARY KEY (`id`) USING BTREE	
	) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;
	
	-- accountlog 账号日志表
	CREATE TABLE `t_pim_accountlog`  (
		`id` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
		`accountId` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
		`account` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
		`password` varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
		`updateDt` datetime NULL DEFAULT NULL,
		`fileId` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
		PRIMARY KEY (`id`) USING BTREE
	) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;
	
	-- user 用户表
	CREATE TABLE `t_pim_user`  (
		`id` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
		`name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
		`email` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
		`phoneNum` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
		`openId` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
		`gender` int NULL DEFAULT NULL,
		`photo` varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
		`createDt` datetime NULL DEFAULT NULL,
		`sercet` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
		`salt` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
		`spaceSize` decimal(12, 4) NULL DEFAULT NULL,
		`isMembers` int NULL DEFAULT NULL,
		PRIMARY KEY (`id`) USING BTREE
	) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;
	
	
### 默认数据
	INSERT INTO `t_pim_admin` VALUES ('a', 'admin', '$2a$10$EQhVS5pj.Z3GEizhzK4rjOlPV3Z4mbWEczzB5iSbsNf6E.ZVRTwxW', '2021-01-23 15:41:08', NULL, NULL, NULL, NULL, NULL, 'ON');
	INSERT INTO `t_pim_admin_role` VALUES ('a', 'a', 'a');
	INSERT INTO `t_pim_role` VALUES ('a', '管理员', 'ADMIN');
	
	
README.md 编写规范：https://www.cnblogs.com/wj-1314/p/8547763.html