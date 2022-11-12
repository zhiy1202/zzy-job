/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50735
 Source Host           : localhost:3306
 Source Schema         : hxy

 Target Server Type    : MySQL
 Target Server Version : 50735
 File Encoding         : 65001

 Date: 19/09/2022 11:57:32
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_company
-- ----------------------------
DROP TABLE IF EXISTS `t_company`;
CREATE TABLE `t_company`  (
  `company_id` int(11) NOT NULL AUTO_INCREMENT,
  `com_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `com_intro` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `com_address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `com_telephone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_id` int(11) NULL DEFAULT NULL COMMENT '那个用户的公司',
  PRIMARY KEY (`company_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_company
-- ----------------------------
INSERT INTO `t_company` VALUES (1, 'zzy 信息科技', '科技公司', '上海', '15173999068', 1);
INSERT INTO `t_company` VALUES (2, 'admin科技公司', 'good', '纽约', '12312', 2);
INSERT INTO `t_company` VALUES (4, 'hxy科技公司', 'good', '株洲', '123456', 6);

-- ----------------------------
-- Table structure for t_position
-- ----------------------------
DROP TABLE IF EXISTS `t_position`;
CREATE TABLE `t_position`  (
  `position_id` int(255) NOT NULL AUTO_INCREMENT,
  `company_id` int(11) NULL DEFAULT NULL,
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `money` double(255, 0) NULL DEFAULT NULL,
  `intro` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `create_time` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`position_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_position
-- ----------------------------
INSERT INTO `t_position` VALUES (1, 1, 'java 开发工程师', 8000, '理解 spring框架基础知识 熟悉mysql数据库', '2022-09-17 23:05:49');
INSERT INTO `t_position` VALUES (4, 1, 'python 数据分析师', 13000, '熟练掌握python\r\njdango\r\nmysql数据库', '2022-09-18 17:12:38');
INSERT INTO `t_position` VALUES (5, 4, 'golang 开发', 3000, 'web 基础框架', '2022-09-18 17:38:58');

-- ----------------------------
-- Table structure for t_receive
-- ----------------------------
DROP TABLE IF EXISTS `t_receive`;
CREATE TABLE `t_receive`  (
  `receive_id` int(11) NOT NULL AUTO_INCREMENT,
  `company_id` int(11) NULL DEFAULT NULL,
  `position_id` int(11) NULL DEFAULT NULL,
  `user_id` int(11) NULL DEFAULT NULL,
  `resume_id` int(11) NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`receive_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_receive
-- ----------------------------
INSERT INTO `t_receive` VALUES (6, 1, 1, 1, 1, '2022-09-18 17:02:17');

-- ----------------------------
-- Table structure for t_success
-- ----------------------------
DROP TABLE IF EXISTS `t_success`;
CREATE TABLE `t_success`  (
  `success_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NULL DEFAULT NULL,
  `company_id` int(11) NULL DEFAULT NULL,
  `position_id` int(11) NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`success_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  `is_user` tinyint(1) NULL DEFAULT NULL COMMENT '判断是否是用户还是公司',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES (1, 'zzy', '333', '2022-09-18 16:43:03', 0);
INSERT INTO `t_user` VALUES (2, 'admin', 'admin', '2022-09-18 16:43:01', 0);
INSERT INTO `t_user` VALUES (3, 'zjw', '333', '2022-09-18 17:28:58', 1);
INSERT INTO `t_user` VALUES (6, 'hxy', '333', '2022-09-18 17:36:35', 0);

-- ----------------------------
-- Table structure for user_resume
-- ----------------------------
DROP TABLE IF EXISTS `user_resume`;
CREATE TABLE `user_resume`  (
  `resume_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NULL DEFAULT NULL,
  `telephone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `wage` double(255, 0) NULL DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `intro` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `content` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `create_time` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`resume_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_resume
-- ----------------------------
INSERT INTO `user_resume` VALUES (1, 1, '15173999068', '长沙', 15000, 'zhiy1202@qq.com', '本人毕业于湖南化工职业技术学院 获取国家奖学金', 'Java framwork mysql', '2022-09-18 14:06:53');

-- ----------------------------
-- View structure for company_position
-- ----------------------------
DROP VIEW IF EXISTS `company_position`;
CREATE ALGORITHM = UNDEFINED DEFINER = `root`@`localhost` SQL SECURITY DEFINER VIEW `company_position` AS select `c`.`company_id` AS `company_id`,`c`.`com_name` AS `com_name`,`c`.`com_intro` AS `com_intro`,`c`.`com_address` AS `com_address`,`c`.`com_telephone` AS `com_telephone`,`u`.`user_id` AS `user_id`,`u`.`username` AS `username`,`p`.`position_id` AS `position_id`,`p`.`title` AS `title`,`p`.`money` AS `money`,`p`.`intro` AS `intro`,`p`.`create_time` AS `create_time` from ((`t_company` `c` join `t_position` `p` on((`c`.`company_id` = `p`.`company_id`))) join `t_user` `u` on((`u`.`user_id` = `c`.`user_id`)));

SET FOREIGN_KEY_CHECKS = 1;
