/*
 Navicat Premium Data Transfer

 Source Server         : 127.0.0.1
 Source Server Type    : MySQL
 Source Server Version : 50714
 Source Host           : localhost:3306
 Source Schema         : test

 Target Server Type    : MySQL
 Target Server Version : 50714
 File Encoding         : 65001

 Date: 12/11/2019 15:18:36
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for account
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `deposit` decimal(10, 2) NOT NULL DEFAULT 0.00,
  `version` int(11) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of account
-- ----------------------------
INSERT INTO `account` VALUES (1, 1000.00, 0);
INSERT INTO `account` VALUES (2, 1000.00, 0);
INSERT INTO `account` VALUES (3, 1000.00, 0);
INSERT INTO `account` VALUES (4, 1000.00, 0);
INSERT INTO `account` VALUES (5, 1000.00, 0);
INSERT INTO `account` VALUES (6, 1000.00, 0);
INSERT INTO `account` VALUES (7, 1000.00, 0);
INSERT INTO `account` VALUES (8, 1000.00, 0);
INSERT INTO `account` VALUES (9, 1000.00, 0);
INSERT INTO `account` VALUES (10, 1000.00, 0);
INSERT INTO `account` VALUES (11, 123456.00, 6);
INSERT INTO `account` VALUES (12, 8888.00, 2);
INSERT INTO `account` VALUES (13, 8888.00, 2);

SET FOREIGN_KEY_CHECKS = 1;
