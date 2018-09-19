/*
 Navicat Premium Data Transfer

 Source Server         : locahost
 Source Server Type    : MariaDB
 Source Server Version : 100212
 Source Host           : localhost:3306
 Source Schema         : micro-config

 Target Server Type    : MariaDB
 Target Server Version : 100212
 File Encoding         : 65001

 Date: 19/09/2018 15:01:20
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for properties
-- ----------------------------
DROP TABLE IF EXISTS `properties`;
CREATE TABLE `properties` (
  `application` varchar(200) DEFAULT NULL,
  `profile` varchar(200) DEFAULT NULL,
  `label` varchar(200) DEFAULT NULL,
  `key` varchar(200) DEFAULT NULL,
  `value` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of properties
-- ----------------------------
BEGIN;
INSERT INTO `properties` VALUES ('config', 'default', 'dev', 'kafka.server', 'localhost:9092');
INSERT INTO `properties` VALUES ('config', 'default', 'dev', 'kafka.topic', 'micro-order');
INSERT INTO `properties` VALUES ('config', 'default', 'dev', 'kafka.group', 'micro-group-order');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
