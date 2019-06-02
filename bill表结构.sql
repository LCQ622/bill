/*
Navicat MySQL Data Transfer

Source Server         : mcandroid.cn
Source Server Version : 50721
Source Host           : localhost:3306
Source Database       : lcq

Target Server Type    : MYSQL
Target Server Version : 50721
File Encoding         : 65001

Date: 2019-06-02 10:39:11
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for bill
-- ----------------------------
DROP TABLE IF EXISTS `bill`;
CREATE TABLE `bill` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `date` date DEFAULT NULL COMMENT '日期',
  `money` decimal(10,2) NOT NULL COMMENT '金额',
  `pay_mode` enum('支付宝','微信','京东','现金') DEFAULT NULL COMMENT '支付方式',
  `type` enum('餐饮','零花','交通','医疗','生活','消费','通讯','娱乐','购物','教育','还款','其他') DEFAULT NULL COMMENT '消费类型',
  `msg` varchar(50) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=614 DEFAULT CHARSET=utf8;
