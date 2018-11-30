/*
Navicat MySQL Data Transfer

Source Server         : jaty
Source Server Version : 50724
Source Host           : localhost:3306
Source Database       : jaty

Target Server Type    : MYSQL
Target Server Version : 50724
File Encoding         : 65001

Date: 2018-11-30 10:15:55
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `userId` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `phone` varchar(255) NOT NULL,
  `sex` int(11) DEFAULT NULL,
  `headUrl` varchar(255) DEFAULT NULL,
  `mail` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`userId`),
  UNIQUE KEY `phone` (`phone`),
  UNIQUE KEY `userName` (`userName`),
  UNIQUE KEY `mail` (`mail`),
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;
