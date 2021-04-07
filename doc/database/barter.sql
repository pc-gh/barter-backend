/*
Navicat MySQL Data Transfer

Source Server         : 1
Source Server Version : 50635
Source Host           : localhost:3306
Source Database       : barter

Target Server Type    : MYSQL
Target Server Version : 50635
File Encoding         : 65001

Date: 2021-04-06 21:17:37
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `post_id` int(11) NOT NULL,
  `easy_comment` varchar(255) DEFAULT NULL,
  `detail_comment` varchar(255) DEFAULT NULL,
  `create_time` varchar(255) DEFAULT NULL,
  `status` int(255) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES ('5', '5', '4', 'string', 'string', 'string', '0');
INSERT INTO `comment` VALUES ('6', '5', '4', 'string', 'string', 'string', '0');
INSERT INTO `comment` VALUES ('7', '5', '4', 'string', 'string', 'string', '0');
INSERT INTO `comment` VALUES ('8', '0', '0', 'string', '好好', 'string', '1');

-- ----------------------------
-- Table structure for post
-- ----------------------------
DROP TABLE IF EXISTS `post`;
CREATE TABLE `post` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `title` varchar(255) NOT NULL,
  `easy_context` varchar(255) DEFAULT NULL,
  `detail_context` varchar(255) NOT NULL,
  `create_time` varchar(255) NOT NULL,
  `modify_time` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `status` int(255) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of post
-- ----------------------------
INSERT INTO `post` VALUES ('4', '5', 'string', 'string', 'string', 'string', 'string', 'string', '0');
INSERT INTO `post` VALUES ('5', '5', 'ze', 'string', 'string', 'string', 'string', 'string', '0');
INSERT INTO `post` VALUES ('6', '5', 'strizeng', 'string', 'string', 'string', 'string', 'string', '0');
INSERT INTO `post` VALUES ('7', '0', 'string', 'string', '哈哈哈', 'string', 'string', 'string', '1');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) NOT NULL DEFAULT '',
  `password` varchar(255) NOT NULL DEFAULT '',
  `real_name` varchar(255) DEFAULT NULL,
  `sex` varchar(255) NOT NULL,
  `tel` varchar(255) DEFAULT NULL,
  `status` int(255) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'zs', '123', '张三', '男', '18756985630', '1');
INSERT INTO `user` VALUES ('2', 'string', 'ooo', 'string', 'string', 'string', '0');
INSERT INTO `user` VALUES ('5', '0', '0', null, '0', null, '0');
INSERT INTO `user` VALUES ('6', '0', '0', null, '0', null, '0');
