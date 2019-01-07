/*
Navicat MySQL Data Transfer

Source Server         : laf
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : lost_and_found

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2019-01-07 19:04:19
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for laf_item
-- ----------------------------
DROP TABLE IF EXISTS `laf_item`;
CREATE TABLE `laf_item` (
  `item_id` int(11) NOT NULL AUTO_INCREMENT,
  `item_name` varchar(25) DEFAULT NULL,
  `item_desc` varchar(500) DEFAULT NULL,
  `item_pick_up_time` datetime DEFAULT NULL,
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `edit_time` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`item_id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8 COMMENT='lost and found item table';

-- ----------------------------
-- Table structure for laf_message
-- ----------------------------
DROP TABLE IF EXISTS `laf_message`;
CREATE TABLE `laf_message` (
  `message_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL COMMENT 'user primary key',
  `item_id` int(11) DEFAULT NULL,
  `message_desc` varchar(500) DEFAULT NULL,
  `msg_title` varchar(500) DEFAULT NULL COMMENT 'a url list with scroll img url or single',
  `message_type` tinyint(4) DEFAULT NULL,
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `edit_time` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`message_id`),
  KEY `FK_associate_item` (`item_id`),
  KEY `FK_publisher` (`user_id`),
  CONSTRAINT `FK_associate_item` FOREIGN KEY (`item_id`) REFERENCES `laf_item` (`item_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_publisher` FOREIGN KEY (`user_id`) REFERENCES `sys_user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8 COMMENT='lost and found message table';

-- ----------------------------
-- Table structure for laf_return_log
-- ----------------------------
DROP TABLE IF EXISTS `laf_return_log`;
CREATE TABLE `laf_return_log` (
  `return_id` int(11) NOT NULL AUTO_INCREMENT,
  `piker_user_id` int(11) DEFAULT NULL COMMENT 'user primary key',
  `owner_user_id` int(11) DEFAULT NULL COMMENT 'user primary key',
  `item_id` int(11) DEFAULT NULL,
  `return_img_url` varchar(50) DEFAULT NULL COMMENT 'evidence img',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `edit_time` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`return_id`),
  KEY `FK_owner` (`owner_user_id`),
  KEY `FK_picker` (`piker_user_id`),
  KEY `FK_return_item` (`item_id`),
  CONSTRAINT `FK_owner` FOREIGN KEY (`owner_user_id`) REFERENCES `sys_user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_picker` FOREIGN KEY (`piker_user_id`) REFERENCES `sys_user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_return_item` FOREIGN KEY (`item_id`) REFERENCES `laf_item` (`item_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='lost and found return log table';

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'user primary key',
  `user_username` varchar(50) DEFAULT NULL COMMENT 'unique',
  `user_password` varchar(128) DEFAULT NULL,
  `user_realname` varchar(50) DEFAULT NULL,
  `user_nickname` varchar(50) DEFAULT NULL,
  `user_avatar_url` varchar(128) DEFAULT NULL,
  `user_email_address` varchar(50) DEFAULT NULL COMMENT 'For registration',
  `user_contact_way` varchar(50) DEFAULT NULL COMMENT 'Some other contact methods, such as phone, QQ',
  `user_sex` varchar(4) DEFAULT NULL,
  `user_birthday` date DEFAULT NULL,
  `user_role` tinyint(4) DEFAULT NULL COMMENT 'Decision authority, Related to permissions',
  `user_token` varchar(255) DEFAULT NULL,
  `user_sign_in_ip` varchar(20) DEFAULT NULL,
  `user_sign_in_time` datetime DEFAULT NULL,
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `edit_time` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='user table';
DROP TRIGGER IF EXISTS `after_insert`;
DELIMITER ;;
CREATE TRIGGER `after_insert` AFTER INSERT ON `laf_message` FOR EACH ROW begin
	  insert into op_log(op_name)
		values( 'insert');
end
;;
DELIMITER ;
