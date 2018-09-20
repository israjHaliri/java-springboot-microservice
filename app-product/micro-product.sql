/*
 Navicat Premium Data Transfer

 Source Server         : locahost
 Source Server Type    : MariaDB
 Source Server Version : 100212
 Source Host           : localhost:3306
 Source Schema         : micro-product

 Target Server Type    : MariaDB
 Target Server Version : 100212
 File Encoding         : 65001

 Date: 20/09/2018 22:28:16
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for item
-- ----------------------------
DROP TABLE IF EXISTS `item`;
CREATE TABLE `item` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(150) DEFAULT NULL,
  `description` varchar(150) DEFAULT NULL,
  `amount` int(10) DEFAULT NULL,
  `price` decimal(20,0) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of item
-- ----------------------------
BEGIN;
INSERT INTO `item` VALUES (1, 'Emas', 'Testing product', 125, 1000000);
INSERT INTO `item` VALUES (8, 'Perak', 'Testing product', 5, 90000);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
