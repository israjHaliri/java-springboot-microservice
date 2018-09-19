/*
 Navicat Premium Data Transfer

 Source Server         : locahost
 Source Server Type    : MariaDB
 Source Server Version : 100212
 Source Host           : localhost:3306
 Source Schema         : micro-order

 Target Server Type    : MariaDB
 Target Server Version : 100212
 File Encoding         : 65001

 Date: 19/09/2018 15:01:37
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for request
-- ----------------------------
DROP TABLE IF EXISTS `request`;
CREATE TABLE `request` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `item_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`id`,`item_id`,`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of request
-- ----------------------------
BEGIN;
INSERT INTO `request` VALUES (38, 1, 1);
INSERT INTO `request` VALUES (39, 1, 1);
INSERT INTO `request` VALUES (40, 1, 1);
INSERT INTO `request` VALUES (41, 1, 1);
INSERT INTO `request` VALUES (42, 1, 1);
INSERT INTO `request` VALUES (43, 1, 1);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
