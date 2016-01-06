/*
 Navicat Premium Data Transfer

 Source Server         : local
 Source Server Type    : MySQL
 Source Server Version : 50627
 Source Host           : localhost
 Source Database       : catalog

 Target Server Type    : MySQL
 Target Server Version : 50627
 File Encoding         : utf-8

 Date: 12/29/2015 18:11:40 PM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `sys_area`
-- ----------------------------
DROP TABLE IF EXISTS `sys_area`;
CREATE TABLE `sys_area` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `parent_id` int(11) NOT NULL COMMENT '父级编号',
  `parent_ids` varchar(2000) NOT NULL COMMENT '所有父级编号',
  `name` varchar(100) NOT NULL COMMENT '名称',
  `sort` decimal(10,0) NOT NULL COMMENT '排序',
  `code` varchar(100) DEFAULT NULL COMMENT '区域编码',
  `type` char(1) DEFAULT NULL COMMENT '区域类型',
  `create_by` int(11) NOT NULL COMMENT '创建者',
  `create_date` datetime NOT NULL COMMENT '创建时间',
  `update_by` int(11) NOT NULL COMMENT '更新者',
  `update_date` datetime NOT NULL COMMENT '更新时间',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注信息',
  `del_flag` char(1) NOT NULL DEFAULT '0' COMMENT '删除标记',
  PRIMARY KEY (`id`),
  KEY `sys_area_parent_id` (`parent_id`),
  KEY `sys_area_del_flag` (`del_flag`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='区域表';

-- ----------------------------
--  Records of `sys_area`
-- ----------------------------
BEGIN;
INSERT INTO `sys_area` VALUES ('1', '0', '0,', '中国', '10', '100000', '1', '1', '2015-12-22 21:15:00', '1', '2015-12-22 21:15:00', '', '0'), ('2', '1', '0,1,', '山东省', '20', '110000', '2', '1', '2015-12-22 21:15:00', '1', '2015-12-22 21:15:00', '', '0'), ('3', '2', '0,1,2,', '济南市', '30', '110101', '3', '1', '2015-12-22 21:15:00', '1', '2015-12-22 21:15:00', '', '0'), ('4', '3', '0,1,2,3,', '历城区', '40', '110102', '4', '1', '2015-12-22 21:15:00', '1', '2015-12-22 21:15:00', '', '0'), ('5', '3', '0,1,2,3,', '历下区', '50', '110104', '4', '1', '2015-12-22 21:15:00', '1', '2015-12-22 21:15:00', '', '0'), ('6', '3', '0,1,2,3,', '高新区', '60', '110105', '4', '1', '2015-12-22 21:15:00', '1', '2015-12-22 21:15:00', '', '0');
COMMIT;

-- ----------------------------
--  Table structure for `sys_dict`
-- ----------------------------
DROP TABLE IF EXISTS `sys_dict`;
CREATE TABLE `sys_dict` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `value` varchar(100) NOT NULL COMMENT '数据值',
  `label` varchar(100) NOT NULL COMMENT '标签名',
  `type` varchar(100) NOT NULL COMMENT '类型',
  `description` varchar(100) NOT NULL COMMENT '描述',
  `sort` decimal(10,0) NOT NULL COMMENT '排序（升序）',
  `parent_id` int(11) DEFAULT '0' COMMENT '父级编号',
  `create_by` int(11) NOT NULL COMMENT '创建者',
  `create_date` datetime NOT NULL COMMENT '创建时间',
  `update_by` int(11) NOT NULL COMMENT '更新者',
  `update_date` datetime NOT NULL COMMENT '更新时间',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注信息',
  `del_flag` char(1) NOT NULL DEFAULT '0' COMMENT '删除标记',
  PRIMARY KEY (`id`),
  KEY `sys_dict_value` (`value`),
  KEY `sys_dict_label` (`label`),
  KEY `sys_dict_del_flag` (`del_flag`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='字典表';

-- ----------------------------
--  Table structure for `sys_log`
-- ----------------------------
DROP TABLE IF EXISTS `sys_log`;
CREATE TABLE `sys_log` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `type` char(1) DEFAULT '1' COMMENT '日志类型',
  `title` varchar(255) DEFAULT '' COMMENT '日志标题',
  `create_by` int(11) DEFAULT NULL COMMENT '创建者',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `remote_addr` varchar(255) DEFAULT NULL COMMENT '操作IP地址',
  `user_agent` varchar(255) DEFAULT NULL COMMENT '用户代理',
  `request_uri` varchar(255) DEFAULT NULL COMMENT '请求URI',
  `method` varchar(5) DEFAULT NULL COMMENT '操作方式',
  `params` text COMMENT '操作提交的数据',
  `exception` text COMMENT '异常信息',
  PRIMARY KEY (`id`),
  KEY `sys_log_create_by` (`create_by`),
  KEY `sys_log_request_uri` (`request_uri`),
  KEY `sys_log_type` (`type`),
  KEY `sys_log_create_date` (`create_date`)
) ENGINE=InnoDB AUTO_INCREMENT=109 DEFAULT CHARSET=utf8 COMMENT='日志表';

-- ----------------------------
--  Records of `sys_log`
-- ----------------------------
BEGIN;
INSERT INTO `sys_log` VALUES ('1', '1', '系统登录', '1', '2015-12-22 22:47:06', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/47.0.2526.80 Safari/537.36', '/admin', 'GET', '', ''), ('2', '1', '系统登录', '1', '2015-12-22 22:53:24', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/47.0.2526.80 Safari/537.36', '/admin', 'GET', '', ''), ('3', '1', '系统登录', '1', '2015-12-23 10:44:54', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/47.0.2526.80 Safari/537.36', '/admin', 'GET', 'login=', ''), ('4', '1', '系统登录', '1', '2015-12-23 11:18:33', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/47.0.2526.80 Safari/537.36', '/admin', 'GET', 'login=', ''), ('5', '1', '系统登录', '1', '2015-12-23 14:37:16', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/47.0.2526.80 Safari/537.36', '/admin', 'GET', 'login=', ''), ('6', '1', '系统登录', '1', '2015-12-23 14:47:45', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/47.0.2526.80 Safari/537.36', '/admin', 'GET', 'login=', ''), ('7', '1', '系统登录', '1', '2015-12-23 14:53:52', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/47.0.2526.80 Safari/537.36', '/admin', 'GET', 'login=', ''), ('8', '1', '系统登录', '1', '2015-12-23 15:14:32', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/47.0.2526.80 Safari/537.36', '/admin', 'GET', '', ''), ('9', '1', '系统登录', '1', '2015-12-23 15:14:32', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/47.0.2526.80 Safari/537.36', '/admin', 'GET', '', ''), ('10', '1', '系统登录', '1', '2015-12-23 15:41:17', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/47.0.2526.80 Safari/537.36', '/admin', 'GET', '', ''), ('11', '1', '系统登录', '1', '2015-12-23 15:45:17', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/47.0.2526.80 Safari/537.36', '/admin', 'GET', 'login=', ''), ('12', '1', '系统登录', '1', '2015-12-23 15:47:22', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/47.0.2526.80 Safari/537.36', '/admin', 'GET', '', ''), ('13', '1', '系统登录', '1', '2015-12-23 16:42:46', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/47.0.2526.80 Safari/537.36', '/admin', 'GET', 'login=', ''), ('14', '1', '系统登录', '1', '2015-12-23 17:23:06', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/47.0.2526.80 Safari/537.36', '/admin', 'GET', 'login=', ''), ('15', '1', '系统登录', '1', '2015-12-23 17:34:30', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/47.0.2526.80 Safari/537.36', '/admin', 'GET', 'login=', ''), ('16', '1', '系统登录', '1', '2015-12-23 17:47:47', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/47.0.2526.80 Safari/537.36', '/admin', 'GET', '', ''), ('17', '1', '系统登录', '1', '2015-12-23 17:53:43', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/47.0.2526.80 Safari/537.36', '/admin', 'GET', '', ''), ('18', '1', '系统登录', '1', '2015-12-23 18:05:05', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/47.0.2526.80 Safari/537.36', '/admin', 'GET', '', ''), ('19', '1', '系统登录', '1', '2015-12-23 18:05:15', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/47.0.2526.80 Safari/537.36', '/admin', 'GET', '', ''), ('20', '1', '系统登录', '1', '2015-12-23 18:07:08', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/47.0.2526.80 Safari/537.36', '/admin', 'GET', 'login=', ''), ('21', '1', '系统登录', '1', '2015-12-23 19:28:21', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/47.0.2526.80 Safari/537.36', '/admin', 'GET', 'login=', ''), ('22', '1', '系统登录', '1', '2015-12-23 20:09:30', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/47.0.2526.80 Safari/537.36', '/admin', 'GET', 'login=', ''), ('23', '1', '系统登录', '1', '2015-12-23 20:20:37', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/47.0.2526.80 Safari/537.36', '/admin', 'GET', 'login=', ''), ('24', '1', '系统登录', '1', '2015-12-23 20:25:32', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/47.0.2526.80 Safari/537.36', '/admin', 'GET', '', ''), ('25', '1', '系统登录', '1', '2015-12-23 21:28:36', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/47.0.2526.80 Safari/537.36', '/admin', 'GET', 'login=', ''), ('26', '1', '系统登录', '1', '2015-12-23 21:31:12', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/47.0.2526.80 Safari/537.36', '/admin', 'GET', 'login=', ''), ('27', '1', '系统登录', '1', '2015-12-23 21:33:20', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/47.0.2526.80 Safari/537.36', '/admin', 'GET', 'login=', ''), ('28', '1', '系统登录', '1', '2015-12-23 21:35:01', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/47.0.2526.80 Safari/537.36', '/admin', 'GET', 'login=', ''), ('29', '1', '系统登录', '1', '2015-12-23 21:37:46', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/47.0.2526.80 Safari/537.36', '/admin', 'GET', 'login=', ''), ('30', '1', '系统登录', '1', '2015-12-23 21:40:56', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/47.0.2526.80 Safari/537.36', '/admin', 'GET', 'login=', ''), ('31', '1', '系统登录', '1', '2015-12-23 21:41:24', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/47.0.2526.80 Safari/537.36', '/admin', 'GET', 'login=', ''), ('32', '1', '系统登录', '1', '2015-12-23 21:41:50', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/47.0.2526.80 Safari/537.36', '/admin', 'GET', 'login=', ''), ('33', '1', '系统登录', '1', '2015-12-23 21:42:11', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/47.0.2526.80 Safari/537.36', '/admin', 'GET', 'login=', ''), ('34', '1', '系统登录', '1', '2015-12-23 21:43:56', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/47.0.2526.80 Safari/537.36', '/admin', 'GET', 'login=', ''), ('35', '1', '系统登录', '1', '2015-12-23 21:44:21', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/47.0.2526.80 Safari/537.36', '/admin', 'GET', 'login=', ''), ('36', '1', '系统登录', '1', '2015-12-23 21:45:22', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/47.0.2526.80 Safari/537.36', '/admin', 'GET', '', ''), ('37', '1', '系统登录', '1', '2015-12-23 21:45:52', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/47.0.2526.80 Safari/537.36', '/admin', 'GET', 'login=', ''), ('38', '1', '系统登录', '1', '2015-12-23 21:46:10', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/47.0.2526.80 Safari/537.36', '/admin', 'GET', 'login=', ''), ('39', '1', '系统登录', '1', '2015-12-23 21:50:25', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/47.0.2526.80 Safari/537.36', '/admin', 'GET', 'login=', ''), ('40', '1', '系统登录', '1', '2015-12-24 10:07:51', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/47.0.2526.80 Safari/537.36', '/admin', 'GET', 'login=', ''), ('41', '1', '系统登录', '1', '2015-12-24 10:16:07', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/47.0.2526.80 Safari/537.36', '/admin', 'GET', 'login=', ''), ('42', '1', '系统登录', '1', '2015-12-24 10:16:36', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/47.0.2526.80 Safari/537.36', '/admin', 'GET', 'login=', ''), ('43', '1', '系统登录', '1', '2015-12-24 10:25:14', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/47.0.2526.80 Safari/537.36', '/admin', 'GET', 'login=', ''), ('44', '1', '系统登录', '1', '2015-12-24 10:26:08', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/47.0.2526.80 Safari/537.36', '/admin', 'GET', 'login=', ''), ('45', '1', '系统登录', '1', '2015-12-24 11:30:01', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/47.0.2526.80 Safari/537.36', '/admin', 'GET', 'login=', ''), ('46', '1', '系统登录', '1', '2015-12-24 11:56:26', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/47.0.2526.80 Safari/537.36', '/admin', 'GET', 'login=', ''), ('47', '1', '系统登录', '1', '2015-12-24 12:12:57', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/47.0.2526.80 Safari/537.36', '/admin', 'GET', 'login=', ''), ('48', '1', '系统登录', '1', '2015-12-24 12:17:10', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/47.0.2526.80 Safari/537.36', '/admin', 'GET', 'login=', ''), ('49', '1', '系统登录', '1', '2015-12-24 12:27:21', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/47.0.2526.80 Safari/537.36', '/admin', 'GET', 'login=', ''), ('50', '1', '系统登录', '1', '2015-12-24 12:37:43', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/47.0.2526.80 Safari/537.36', '/admin', 'GET', 'login=', ''), ('51', '1', '系统登录', '1', '2015-12-24 13:25:11', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/47.0.2526.80 Safari/537.36', '/admin', 'GET', 'login=', ''), ('52', '1', '系统登录', '1', '2015-12-24 14:21:28', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/47.0.2526.80 Safari/537.36', '/admin', 'GET', 'login=', ''), ('53', '1', '系统登录', '1', '2015-12-24 14:28:09', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/47.0.2526.80 Safari/537.36', '/admin', 'GET', 'login=', ''), ('54', '1', '系统登录', '1', '2015-12-24 14:28:29', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/47.0.2526.80 Safari/537.36', '/admin', 'GET', 'login=', ''), ('55', '1', '系统登录', '1', '2015-12-24 14:34:14', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/47.0.2526.80 Safari/537.36', '/admin', 'GET', '', ''), ('56', '1', '系统登录', '1', '2015-12-24 14:55:42', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/47.0.2526.80 Safari/537.36', '/admin', 'GET', 'login=', ''), ('57', '1', '系统登录', '1', '2015-12-24 15:02:39', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/47.0.2526.80 Safari/537.36', '/admin', 'GET', 'login=', ''), ('58', '1', '系统登录', '1', '2015-12-24 17:29:24', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/47.0.2526.80 Safari/537.36', '/admin', 'GET', 'login=', ''), ('59', '1', '系统登录', '1', '2015-12-24 17:36:16', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/47.0.2526.80 Safari/537.36', '/admin', 'GET', 'login=', ''), ('60', '1', '系统登录', '1', '2015-12-24 17:43:19', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/47.0.2526.80 Safari/537.36', '/admin', 'GET', '', ''), ('61', '1', '系统登录', '1', '2015-12-24 17:48:45', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/47.0.2526.80 Safari/537.36', '/admin', 'GET', 'login=', ''), ('62', '1', '系统登录', '1', '2015-12-24 17:54:36', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/47.0.2526.80 Safari/537.36', '/admin', 'GET', 'login=', ''), ('63', '1', '系统登录', '1', '2015-12-24 18:06:39', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/47.0.2526.80 Safari/537.36', '/admin', 'GET', '', ''), ('64', '1', '系统登录', '1', '2015-12-25 14:36:16', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/47.0.2526.80 Safari/537.36', '/admin', 'GET', 'login=', ''), ('65', '1', '系统登录', '1', '2015-12-25 14:50:44', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/47.0.2526.80 Safari/537.36', '/admin', 'GET', 'login=', ''), ('66', '1', '系统登录', '1', '2015-12-25 19:50:31', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/47.0.2526.80 Safari/537.36', '/admin', 'GET', 'login=', ''), ('67', '1', '系统登录', '1', '2015-12-25 23:37:16', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/47.0.2526.80 Safari/537.36', '/admin', 'GET', 'login=', ''), ('68', '1', '系统登录', '1', '2015-12-26 10:03:58', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/47.0.2526.106 Safari/537.36', '/admin', 'GET', 'login=', ''), ('69', '1', '系统登录', '1', '2015-12-26 12:20:47', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/47.0.2526.106 Safari/537.36', '/admin', 'GET', '', ''), ('70', '1', '系统登录', '1', '2015-12-26 12:53:03', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/47.0.2526.106 Safari/537.36', '/admin', 'GET', '', ''), ('71', '1', '系统登录', '1', '2015-12-28 13:36:43', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/47.0.2526.106 Safari/537.36', '/admin', 'GET', 'login=', ''), ('72', '1', '系统登录', '1', '2015-12-28 15:06:31', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/47.0.2526.106 Safari/537.36', '/admin', 'GET', 'login=', ''), ('73', '1', '系统登录', '1', '2015-12-28 15:24:26', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/47.0.2526.106 Safari/537.36', '/admin', 'GET', '', ''), ('74', '1', '系统登录', '1', '2015-12-28 15:35:11', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/47.0.2526.106 Safari/537.36', '/admin', 'GET', '', ''), ('75', '1', '系统登录', '1', '2015-12-28 15:45:51', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/47.0.2526.106 Safari/537.36', '/admin', 'GET', '', ''), ('76', '1', '系统登录', '1', '2015-12-28 15:56:09', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/47.0.2526.106 Safari/537.36', '/admin', 'GET', '', ''), ('77', '1', '系统登录', '1', '2015-12-28 16:06:28', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/47.0.2526.106 Safari/537.36', '/admin', 'GET', '', ''), ('78', '1', '系统登录', '1', '2015-12-28 16:27:08', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/47.0.2526.106 Safari/537.36', '/admin', 'GET', '', ''), ('79', '1', '系统登录', '1', '2015-12-28 16:39:09', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/47.0.2526.106 Safari/537.36', '/admin', 'GET', '', ''), ('80', '1', '系统登录', '1', '2015-12-28 16:53:07', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/47.0.2526.106 Safari/537.36', '/admin', 'GET', '', ''), ('81', '1', '系统登录', '1', '2015-12-28 17:03:09', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/47.0.2526.106 Safari/537.36', '/admin', 'GET', '', ''), ('82', '1', '系统登录', '1', '2015-12-28 17:17:43', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/47.0.2526.106 Safari/537.36', '/admin', 'GET', '', ''), ('83', '1', '系统登录', '1', '2015-12-28 17:26:31', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/47.0.2526.106 Safari/537.36', '/admin', 'GET', 'login=', ''), ('84', '1', '系统登录', '1', '2015-12-28 17:33:25', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/47.0.2526.106 Safari/537.36', '/admin', 'GET', '', ''), ('85', '1', '系统登录', '1', '2015-12-28 17:48:20', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/47.0.2526.106 Safari/537.36', '/admin', 'GET', '', ''), ('86', '1', '系统登录', '1', '2015-12-28 17:58:23', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/47.0.2526.106 Safari/537.36', '/admin', 'GET', '', ''), ('87', '1', '系统登录', '1', '2015-12-28 18:22:24', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/47.0.2526.106 Safari/537.36', '/admin', 'GET', '', ''), ('88', '1', '系统登录', '1', '2015-12-28 18:22:48', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/47.0.2526.106 Safari/537.36', '/admin', 'GET', 'login=', ''), ('89', '1', '系统登录', '1', '2015-12-28 18:24:19', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/47.0.2526.106 Safari/537.36', '/admin', 'GET', 'login=', ''), ('90', '1', '系统登录', '1', '2015-12-28 21:00:02', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/47.0.2526.106 Safari/537.36', '/admin', 'GET', 'login=', ''), ('91', '1', '系统登录', '1', '2015-12-28 21:02:02', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/47.0.2526.106 Safari/537.36', '/admin', 'GET', '', ''), ('92', '1', '系统登录', '1', '2015-12-29 12:43:00', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/47.0.2526.106 Safari/537.36', '/admin', 'GET', 'login=', ''), ('93', '1', '系统登录', '1', '2015-12-29 14:18:42', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/47.0.2526.106 Safari/537.36', '/admin', 'GET', 'login=', ''), ('94', '1', '系统登录', '1', '2015-12-29 14:27:35', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/47.0.2526.106 Safari/537.36', '/admin', 'GET', 'login=', ''), ('95', '1', '系统登录', '1', '2015-12-29 14:40:35', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/47.0.2526.106 Safari/537.36', '/admin', 'GET', '', ''), ('96', '1', '系统登录', '1', '2015-12-29 14:40:35', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/47.0.2526.106 Safari/537.36', '/admin', 'GET', '', ''), ('97', '1', '系统登录', '1', '2015-12-29 15:12:45', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/47.0.2526.106 Safari/537.36', '/admin', 'GET', 'login=', ''), ('98', '1', '系统登录', '1', '2015-12-29 15:19:31', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/47.0.2526.106 Safari/537.36', '/admin', 'GET', 'login=', ''), ('99', '1', '系统登录', '1', '2015-12-29 15:22:27', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/47.0.2526.106 Safari/537.36', '/admin', 'GET', 'login=', ''), ('100', '1', '系统登录', '1', '2015-12-29 15:38:06', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/47.0.2526.106 Safari/537.36', '/admin', 'GET', 'login=', ''), ('101', '1', '系统登录', '1', '2015-12-29 16:30:47', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/47.0.2526.106 Safari/537.36', '/admin', 'GET', '', ''), ('102', '1', '系统登录', '1', '2015-12-29 16:35:19', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/47.0.2526.106 Safari/537.36', '/admin', 'GET', '', ''), ('103', '1', '系统登录', '1', '2015-12-29 16:47:24', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/47.0.2526.106 Safari/537.36', '/admin', 'GET', '', ''), ('104', '1', '系统登录', '1', '2015-12-29 17:11:47', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/47.0.2526.106 Safari/537.36', '/admin', 'GET', '', ''), ('105', '1', '系统登录', '1', '2015-12-29 17:41:15', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/47.0.2526.106 Safari/537.36', '/admin', 'GET', '', ''), ('106', '1', '系统登录', '1', '2015-12-29 17:41:24', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/47.0.2526.106 Safari/537.36', '/admin', 'GET', '', ''), ('107', '1', '系统登录', '1', '2015-12-29 17:56:33', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/47.0.2526.106 Safari/537.36', '/admin', 'GET', '', ''), ('108', '1', '系统登录', '1', '2015-12-29 17:59:52', '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/47.0.2526.106 Safari/537.36', '/admin', 'GET', '', '');
COMMIT;

-- ----------------------------
--  Table structure for `sys_mdict`
-- ----------------------------
DROP TABLE IF EXISTS `sys_mdict`;
CREATE TABLE `sys_mdict` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `parent_id` int(11) NOT NULL COMMENT '父级编号',
  `parent_ids` varchar(2000) NOT NULL COMMENT '所有父级编号',
  `name` varchar(100) NOT NULL COMMENT '名称',
  `sort` decimal(10,0) NOT NULL COMMENT '排序',
  `description` varchar(100) DEFAULT NULL COMMENT '描述',
  `create_by` int(11) NOT NULL COMMENT '创建者',
  `create_date` datetime NOT NULL COMMENT '创建时间',
  `update_by` int(11) NOT NULL COMMENT '更新者',
  `update_date` datetime NOT NULL COMMENT '更新时间',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注信息',
  `del_flag` char(1) NOT NULL DEFAULT '0' COMMENT '删除标记',
  PRIMARY KEY (`id`),
  KEY `sys_mdict_parent_id` (`parent_id`),
  KEY `sys_mdict_del_flag` (`del_flag`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='多级字典表';

-- ----------------------------
--  Table structure for `sys_menu`
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `parent_id` int(11) NOT NULL COMMENT '父级编号',
  `parent_ids` varchar(2000) NOT NULL COMMENT '所有父级编号',
  `name` varchar(100) NOT NULL COMMENT '名称',
  `sort` decimal(10,0) NOT NULL COMMENT '排序',
  `href` varchar(2000) DEFAULT NULL COMMENT '链接',
  `target` varchar(20) DEFAULT NULL COMMENT '目标',
  `icon` varchar(100) DEFAULT NULL COMMENT '图标',
  `is_show` char(1) NOT NULL COMMENT '是否在菜单中显示',
  `permission` varchar(200) DEFAULT NULL COMMENT '权限标识',
  `create_by` int(11) NOT NULL COMMENT '创建者',
  `create_date` datetime NOT NULL COMMENT '创建时间',
  `update_by` int(11) NOT NULL COMMENT '更新者',
  `update_date` datetime NOT NULL COMMENT '更新时间',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注信息',
  `del_flag` char(1) NOT NULL DEFAULT '0' COMMENT '删除标记',
  PRIMARY KEY (`id`),
  KEY `sys_menu_parent_id` (`parent_id`),
  KEY `sys_menu_del_flag` (`del_flag`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8 COMMENT='菜单表';

-- ----------------------------
--  Records of `sys_menu`
-- ----------------------------
BEGIN;
INSERT INTO `sys_menu` VALUES ('1', '0', '0,', '功能菜单', '0', '', '', '', '1', '', '1', '2015-12-23 09:05:00', '1', '2015-12-23 09:05:00', '', '0'), ('2', '1', '0,1,', '系统管理', '900', '', '', '', '1', '', '1', '2015-12-23 09:05:00', '1', '2015-12-23 09:05:00', '', '0'), ('3', '2', '0,1,2,', '信息统计', '980', '/admin/statistic/info', '', '', '1', '', '1', '2015-12-23 09:05:00', '1', '2015-12-23 09:05:00', '', '0'), ('4', '2', '0,1,2,', '检索统计', '10', '/admin/statistic/search', null, null, '1', null, '1', '2015-12-23 14:27:00', '1', '2015-12-23 14:27:00', null, '0'), ('5', '2', '0,1,2,', '使用日志', '20', '/admin/log/list', null, null, '1', null, '1', '2015-12-23 14:27:00', '1', '2015-12-23 14:27:00', null, '0'), ('6', '2', '0,1,2,', '字典管理', '30', '/admin/dict/list', null, null, '1', null, '1', '2015-12-23 14:27:00', '1', '2015-12-23 14:27:00', null, '0'), ('7', '1', '0,1,', '共享目录', '100', '', null, null, '1', null, '1', '2015-12-23 14:27:00', '1', '2015-12-23 14:27:00', null, '0'), ('8', '7', '0,1,7,', '机构职责信息', '10', '/admin/office/info', null, null, '1', null, '1', '2015-12-23 14:27:00', '1', '2015-12-23 14:27:00', null, '0'), ('9', '7', '0,1,7,', '部门岗位信息', '20', '/admin/job/info', null, null, '1', null, '1', '2015-12-23 14:31:00', '1', '2015-12-23 14:31:00', null, '0'), ('10', '1', '0,1,', '目录管理', '400', null, null, null, '1', null, '1', '2015-12-24 14:24:00', '1', '2015-12-24 14:24:00', null, '0'), ('11', '10', '0,1,10,', '机构目录管理', '10', '/admin/office/manage', null, null, '1', null, '1', '2015-12-24 14:24:00', '1', '2015-12-24 14:24:00', null, '0'), ('12', '10', '0,1,10,', '岗位目录管理', '20', '/admin/job/manage', null, null, '1', null, '1', '2015-12-24 14:24:00', '1', '2015-12-24 14:24:00', null, '0'), ('13', '10', '0,1,10,', '业务目录管理', '30', '/admin/business/manage', null, null, '1', null, '1', '2015-12-24 14:24:00', '1', '2015-12-24 14:24:00', null, '0'), ('14', '10', '0,1,10,', '资源目录管理', '40', '/admin/resource/manage', null, null, '1', null, '1', '2015-12-24 14:24:00', '1', '2015-12-24 14:24:00', null, '0'), ('15', '10', '0,1,10,', '主题目录管理', '50', '/admin/subject/manage', null, null, '1', null, '1', '2015-12-24 14:24:00', '1', '2015-12-24 14:24:00', null, '0'), ('16', '10', '0,1,10,', '主题目录新建', '60', '/admin/subject/manage', null, null, '1', null, '1', '2015-12-24 14:24:00', '1', '2015-12-24 14:24:00', null, '0'), ('17', '7', '0,1,7,', '业务目录信息', '30', '/admin/business/index', null, null, '1', null, '1', '2015-12-29 17:21:00', '1', '2015-12-29 17:21:00', null, '0'), ('18', '7', '0,1,7,', '资源目录信息', '40', '/admin/resource/index', null, null, '1', null, '1', '2015-12-29 17:21:00', '1', '2015-12-29 17:21:00', null, '0'), ('19', '7', '0,1,7,', '主题目录信息', '50', '/admin/subject/index', null, null, '1', null, '1', '2015-12-29 17:21:00', '1', '2015-12-29 17:21:00', null, '0'), ('20', '1', '0,1,', '部门目录', '200', null, null, null, '1', null, '1', '2015-12-29 17:21:00', '1', '2015-12-29 17:21:00', null, '0'), ('21', '20', '0,1,20,', '机构职责维护', '10', '/admin/office/maintenance', null, null, '1', null, '1', '2015-12-29 17:21:00', '1', '2015-12-29 17:21:00', null, '0'), ('22', '20', '0,1,20,', '部门岗位维护', '20', '/admin/job/maintenance', null, null, '1', null, '1', '2015-12-29 17:21:00', '1', '2015-12-29 17:21:00', null, '0'), ('23', '20', '0,1,20,', '部门岗位编辑', '30', '/admin/job/edit', null, null, '1', null, '1', '2015-12-29 17:31:00', '1', '2015-12-29 17:31:00', null, '0'), ('24', '20', '0,1,20,', '业务信息维护', '40', '/admin/business/maintenance', null, null, '1', null, '1', '2015-12-29 17:31:00', '1', '2015-12-29 17:31:00', null, '0'), ('25', '20', '0,1,20,', '业务信息编辑', '50', '/admin/business/edit', null, null, '1', null, '1', '2015-12-29 17:31:00', '1', '2015-12-29 17:31:00', null, '0'), ('26', '20', '0,1,20,', '资源信息维护', '60', '/admin/resource/maintenance', null, null, '1', null, '1', '2015-12-29 17:31:00', '1', '2015-12-29 17:31:00', null, '0'), ('27', '20', '0,1,20,', '资源信息编辑', '70', '/admin/resource/edit', null, null, '1', null, '1', '2015-12-29 17:31:00', '1', '2015-12-29 17:31:00', null, '0'), ('28', '20', '0,1,20,', '主题信息关联', '80', '/admin/subject/link', null, null, '1', null, '1', '2015-12-29 17:31:00', '1', '2015-12-29 17:31:00', null, '0'), ('29', '1', '0,1,', '注册申请', '300', null, null, null, '1', null, '1', '2015-12-29 17:31:00', '1', '2015-12-29 17:31:00', null, '0'), ('30', '29', '0,1,29,', '注册申请', '10', '/admin/register', null, null, '1', null, '1', '2015-12-29 17:31:00', '1', '2015-12-29 17:31:00', null, '0'), ('31', '1', '0,1,', '注册审批', '500', null, null, null, '1', null, '1', '2015-12-29 17:57:00', '1', '2015-12-29 17:57:00', null, '0'), ('32', '31', '0,1,31,', '注册审批', '10', '/admin/register/approve', null, null, '1', null, '1', '2015-12-29 17:57:00', '1', '2015-12-29 17:57:00', null, '0');
COMMIT;

-- ----------------------------
--  Table structure for `sys_office`
-- ----------------------------
DROP TABLE IF EXISTS `sys_office`;
CREATE TABLE `sys_office` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `parent_id` int(11) NOT NULL COMMENT '父级编号',
  `parent_ids` varchar(2000) NOT NULL COMMENT '所有父级编号',
  `name` varchar(100) NOT NULL COMMENT '名称',
  `sort` decimal(10,0) NOT NULL COMMENT '排序',
  `area_id` varchar(64) NOT NULL COMMENT '归属区域',
  `code` varchar(100) DEFAULT NULL COMMENT '区域编码',
  `type` char(1) NOT NULL COMMENT '机构类型',
  `grade` char(1) NOT NULL COMMENT '机构等级',
  `address` varchar(255) DEFAULT NULL COMMENT '联系地址',
  `zip_code` varchar(100) DEFAULT NULL COMMENT '邮政编码',
  `master` varchar(100) DEFAULT NULL COMMENT '负责人',
  `phone` varchar(200) DEFAULT NULL COMMENT '电话',
  `fax` varchar(200) DEFAULT NULL COMMENT '传真',
  `email` varchar(200) DEFAULT NULL COMMENT '邮箱',
  `USEABLE` varchar(64) DEFAULT NULL COMMENT '是否启用',
  `PRIMARY_PERSON` int(11) DEFAULT NULL COMMENT '主负责人',
  `DEPUTY_PERSON` int(11) DEFAULT NULL COMMENT '副负责人',
  `create_by` int(11) NOT NULL COMMENT '创建者',
  `create_date` datetime NOT NULL COMMENT '创建时间',
  `update_by` int(11) NOT NULL COMMENT '更新者',
  `update_date` datetime NOT NULL COMMENT '更新时间',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注信息',
  `del_flag` char(1) NOT NULL DEFAULT '0' COMMENT '删除标记',
  PRIMARY KEY (`id`),
  KEY `sys_office_parent_id` (`parent_id`),
  KEY `sys_office_del_flag` (`del_flag`),
  KEY `sys_office_type` (`type`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COMMENT='机构表';

-- ----------------------------
--  Records of `sys_office`
-- ----------------------------
BEGIN;
INSERT INTO `sys_office` VALUES ('1', '0', '0,', '市级单位', '10', '2', '100000', '1', '1', '', '', '', '', '', '', '1', null, null, '1', '1015-12-22 00:00:00', '1', '1015-12-22 00:00:00', '', '0'), ('2', '1', '0,1,', '吴中区', '10', '2', '100001', '2', '1', '', '', '', '', '', '', '1', null, null, '1', '1015-12-22 00:00:00', '1', '1015-12-22 00:00:00', '', '0'), ('3', '1', '0,1,', '综合部', '20', '2', '100002', '2', '1', '', '', '', '', '', '', '1', null, null, '1', '1015-12-22 00:00:00', '1', '1015-12-22 00:00:00', '', '0'), ('4', '1', '0,1,', '市场部', '30', '2', '100003', '2', '1', '', '', '', '', '', '', '1', null, null, '1', '1015-12-22 00:00:00', '1', '1015-12-22 00:00:00', '', '0'), ('5', '1', '0,1,', '技术部', '40', '2', '100004', '2', '1', '', '', '', '', '', '', '1', null, null, '1', '1015-12-22 00:00:00', '1', '1015-12-22 00:00:00', '', '0'), ('6', '1', '0,1,', '研发部', '50', '2', '100005', '2', '1', '', '', '', '', '', '', '1', null, null, '1', '1015-12-22 00:00:00', '1', '1015-12-22 00:00:00', '', '0'), ('7', '1', '0,1,', '济南市分公司', '20', '3', '200000', '1', '2', '', '', '', '', '', '', '1', null, null, '1', '1015-12-22 00:00:00', '1', '1015-12-22 00:00:00', '', '0'), ('8', '7', '0,1,7,', '公司领导', '10', '3', '200001', '2', '2', '', '', '', '', '', '', '1', null, null, '1', '1015-12-22 00:00:00', '1', '1015-12-22 00:00:00', '', '0'), ('9', '7', '0,1,7,', '综合部', '20', '3', '200002', '2', '2', '', '', '', '', '', '', '1', null, null, '1', '1015-12-22 00:00:00', '1', '1015-12-22 00:00:00', '', '0'), ('10', '7', '0,1,7,', '市场部', '30', '3', '200003', '2', '2', '', '', '', '', '', '', '1', null, null, '1', '1015-12-22 00:00:00', '1', '1015-12-22 00:00:00', '', '0');
COMMIT;

-- ----------------------------
--  Table structure for `sys_role`
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `office_id` int(11) DEFAULT NULL COMMENT '归属机构',
  `name` varchar(100) NOT NULL COMMENT '角色名称',
  `enname` varchar(255) DEFAULT NULL COMMENT '英文名称',
  `role_type` varchar(255) DEFAULT NULL COMMENT '角色类型',
  `data_scope` char(1) DEFAULT NULL COMMENT '数据范围',
  `is_sys` varchar(64) DEFAULT NULL COMMENT '是否系统数据',
  `useable` varchar(64) DEFAULT NULL COMMENT '是否可用',
  `create_by` int(11) NOT NULL COMMENT '创建者',
  `create_date` datetime NOT NULL COMMENT '创建时间',
  `update_by` int(11) NOT NULL COMMENT '更新者',
  `update_date` datetime NOT NULL COMMENT '更新时间',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注信息',
  `del_flag` char(1) NOT NULL DEFAULT '0' COMMENT '删除标记',
  PRIMARY KEY (`id`),
  KEY `sys_role_del_flag` (`del_flag`),
  KEY `sys_role_enname` (`enname`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='角色表';

-- ----------------------------
--  Records of `sys_role`
-- ----------------------------
BEGIN;
INSERT INTO `sys_role` VALUES ('1', '1', '系统管理员', 'dept', 'assignment', '1', null, '1', '1', '2015-12-22 21:17:00', '1', '2015-12-22 21:17:00', '', '0'), ('2', '1', '公司管理员', 'hr', 'assignment', '2', null, '1', '1', '2015-12-22 21:17:00', '1', '2015-12-22 21:17:00', '', '0'), ('3', '1', '本公司管理员', 'a', 'assignment', '3', null, '1', '1', '2015-12-22 21:17:00', '1', '2015-12-22 21:17:00', '', '0'), ('4', '1', '部门管理员', 'b', 'assignment', '4', null, '1', '1', '2015-12-22 21:17:00', '1', '2015-12-22 21:17:00', '', '0'), ('5', '1', '本部门管理员', 'c', 'assignment', '5', null, '1', '1', '2015-12-22 21:17:00', '1', '2015-12-22 21:17:00', '', '0'), ('6', '1', '普通用户', 'd', 'assignment', '8', null, '1', '1', '2015-12-22 21:17:00', '1', '2015-12-22 21:17:00', '', '0'), ('7', '7', '济南市管理员', 'e', 'assignment', '9', null, '1', '1', '2015-12-22 21:17:00', '1', '2015-12-22 21:17:00', '', '0');
COMMIT;

-- ----------------------------
--  Table structure for `sys_role_menu`
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu` (
  `role_id` int(11) NOT NULL COMMENT '角色编号',
  `menu_id` int(11) NOT NULL COMMENT '菜单编号',
  PRIMARY KEY (`role_id`,`menu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色-菜单';

-- ----------------------------
--  Records of `sys_role_menu`
-- ----------------------------
BEGIN;
INSERT INTO `sys_role_menu` VALUES ('1', '1'), ('1', '2'), ('1', '3'), ('1', '4'), ('1', '5'), ('1', '6'), ('1', '7'), ('1', '8'), ('1', '9'), ('1', '10'), ('1', '11'), ('1', '12'), ('1', '13'), ('1', '14'), ('1', '15'), ('1', '16'), ('1', '17'), ('1', '18'), ('1', '19'), ('1', '20'), ('1', '21'), ('1', '22'), ('1', '23'), ('1', '24'), ('1', '25'), ('1', '26'), ('1', '27'), ('1', '28'), ('1', '29'), ('1', '30'), ('1', '31'), ('1', '32');
COMMIT;

-- ----------------------------
--  Table structure for `sys_role_office`
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_office`;
CREATE TABLE `sys_role_office` (
  `role_id` int(11) NOT NULL COMMENT '角色编号',
  `office_id` int(11) NOT NULL COMMENT '机构编号',
  PRIMARY KEY (`role_id`,`office_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色-机构';

-- ----------------------------
--  Table structure for `sys_user`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `company_id` int(11) NOT NULL COMMENT '归属公司',
  `office_id` int(11) NOT NULL COMMENT '归属部门',
  `login_name` varchar(100) NOT NULL COMMENT '登录名',
  `password` varchar(100) NOT NULL COMMENT '密码',
  `no` varchar(100) DEFAULT NULL COMMENT '工号',
  `name` varchar(100) NOT NULL COMMENT '姓名',
  `email` varchar(200) DEFAULT NULL COMMENT '邮箱',
  `phone` varchar(200) DEFAULT NULL COMMENT '电话',
  `mobile` varchar(200) DEFAULT NULL COMMENT '手机',
  `user_type` char(1) DEFAULT NULL COMMENT '用户类型',
  `photo` varchar(1000) DEFAULT NULL COMMENT '用户头像',
  `login_ip` varchar(100) DEFAULT NULL COMMENT '最后登陆IP',
  `login_date` datetime DEFAULT NULL COMMENT '最后登陆时间',
  `login_flag` varchar(64) DEFAULT NULL COMMENT '是否可登录',
  `create_by` int(11) NOT NULL COMMENT '创建者',
  `create_date` datetime NOT NULL COMMENT '创建时间',
  `update_by` int(11) NOT NULL COMMENT '更新者',
  `update_date` datetime NOT NULL COMMENT '更新时间',
  `remarks` varchar(255) DEFAULT NULL COMMENT '备注信息',
  `del_flag` char(1) NOT NULL DEFAULT '0' COMMENT '删除标记',
  PRIMARY KEY (`id`),
  KEY `sys_user_office_id` (`office_id`),
  KEY `sys_user_login_name` (`login_name`),
  KEY `sys_user_company_id` (`company_id`),
  KEY `sys_user_update_date` (`update_date`),
  KEY `sys_user_del_flag` (`del_flag`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
--  Records of `sys_user`
-- ----------------------------
BEGIN;
INSERT INTO `sys_user` VALUES ('1', '1', '2', 'admin', '02a3f0772fcca9f415adc990734b45c6f059c7d33ee28362c4852032', '0001', '系统管理员', '28528000@qq.com', '8675', '8675', '', null, '0:0:0:0:0:0:0:1', '2015-12-29 17:59:52', '1', '1', '2015-12-21 21:12:00', '1', '2015-12-21 21:12:00', '最高管理员', '0'), ('2', '1', '2', 'sd_admin', '02a3f0772fcca9f415adc990734b45c6f059c7d33ee28362c4852032', '0002', '管理员', '', '', '', '', null, null, null, '1', '1', '2015-12-21 21:12:00', '1', '2015-12-21 21:12:00', '', '0'), ('3', '1', '3', 'sd_zhb', '02a3f0772fcca9f415adc990734b45c6f059c7d33ee28362c4852032', '0003', '综合部', '', '', '', '', null, null, null, '1', '1', '2015-12-21 21:12:00', '1', '2015-12-21 21:12:00', '', '0');
COMMIT;

-- ----------------------------
--  Table structure for `sys_user_role`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `user_id` int(11) NOT NULL COMMENT '用户编号',
  `role_id` int(11) NOT NULL COMMENT '角色编号',
  PRIMARY KEY (`user_id`,`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户-角色';

-- ----------------------------
--  Records of `sys_user_role`
-- ----------------------------
BEGIN;
INSERT INTO `sys_user_role` VALUES ('1', '1'), ('1', '2'), ('2', '1'), ('3', '2'), ('4', '3'), ('5', '4'), ('6', '5'), ('7', '2'), ('7', '7'), ('8', '2'), ('9', '1'), ('10', '2'), ('11', '3'), ('12', '4'), ('13', '5'), ('14', '6');
COMMIT;

-- ----------------------------
--  Table structure for `catalog_info`
-- ----------------------------
CREATE TABLE `catalog_info` (
  `id` int(11) NOT NULL COMMENT '目录id',
  `type` int(11) DEFAULT NULL COMMENT '目录类型：资源、主题、机构、岗位、业务',
  `type_value` varchar(100) DEFAULT NULL COMMENT '目录类型值',
  `office_id` int(11) DEFAULT NULL COMMENT '机构id',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `create_by` int(11) DEFAULT NULL COMMENT '创建人',
  `update_date` datetime DEFAULT NULL COMMENT '更新时间',
  `update_by` int(11) DEFAULT NULL COMMENT '更新人',
  `remark` varchar(200) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='目录信息表';

-- ----------------------------
--  Table structure for `office_info`
-- ----------------------------
CREATE TABLE `office_info` (
  `id` int(11) NOT NULL COMMENT '机构id',
  `name` varchar(45) NOT NULL COMMENT '机构名',
  `parent_id` varchar(45) DEFAULT NULL COMMENT '父机构id',
  `parent_name` varchar(45) DEFAULT NULL COMMENT '父机构名',
  `duty` text COMMENT '机构职责',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `create_by` int(11) DEFAULT NULL COMMENT '创建人',
  `update_date` datetime DEFAULT NULL COMMENT '更新时间',
  `update_by` int(11) DEFAULT NULL COMMENT '更新人',
  `remark` varchar(200) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='机构信息';

-- ----------------------------
--  Table structure for `resource_info`
-- ----------------------------
CREATE TABLE `resource_info` (
  `id` int(11) NOT NULL COMMENT '资源id',
  `name` varchar(145) DEFAULT NULL COMMENT '资源名称',
  `of_business` int(11) DEFAULT NULL COMMENT '所属业务',
  `type` int(11) DEFAULT NULL COMMENT '资源类型',
  `code` varchar(145) DEFAULT NULL COMMENT '资源编码',
  `describe` text COMMENT '资源描述',
  `response_party` varchar(145) DEFAULT NULL COMMENT '资源责任方',
  `response_attr` int(11) DEFAULT NULL COMMENT '责任属性',
  `response_cu` varchar(145) DEFAULT NULL COMMENT '责任方联系方式',
  `collect_way` int(11) DEFAULT NULL COMMENT '收集方式',
  `security_level` int(11) DEFAULT NULL COMMENT '资源安全级别',
  `info_field` varchar(200) DEFAULT NULL COMMENT '信息字段',
  `is_db_support` int(11) DEFAULT NULL COMMENT '是否数据库支撑',
  `remark` varchar(200) DEFAULT NULL COMMENT '备注',
  `share_region` varchar(45) DEFAULT NULL COMMENT '共享范围',
  `share_mode` varchar(45) DEFAULT NULL COMMENT '共享方式',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `create_by` int(11) DEFAULT NULL COMMENT '创建者',
  `update_date` datetime DEFAULT NULL COMMENT '更新时间',
  `update_by` int(11) DEFAULT NULL COMMENT '更新者',
  `update_cycle` varchar(45) DEFAULT NULL COMMENT '更新周期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='资源信息表';

-- ----------------------------
--  Table structure for `subject_info`
-- ----------------------------
CREATE TABLE `subject_info` (
  `id` int(11) NOT NULL COMMENT '节点ID',
  `name` varchar(100) NOT NULL COMMENT '节点名称',
  `parent_id` int(11) DEFAULT NULL COMMENT '父节点ID',
  `parent_name` varchar(100) DEFAULT NULL COMMENT '父节点名称',
  `describe` varchar(400) DEFAULT NULL COMMENT '描述',
  `share_region` varchar(200) DEFAULT NULL COMMENT '共享范围',
  `share_mode` varchar(200) DEFAULT NULL COMMENT '共享方式',
  `status` int(11) DEFAULT NULL COMMENT '状态',
  `create_date` datetime DEFAULT NULL COMMENT '创建日期',
  `create_by` int(11) DEFAULT NULL COMMENT '创建者',
  `update_date` datetime DEFAULT NULL COMMENT '更新日期',
  `update_by` int(11) DEFAULT NULL COMMENT '更新者',
  `remark` text,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='主题信息表';

-- ----------------------------
--  Table structure for `business`
-- ----------------------------
create table business
(
   id                   bigint not null comment '业务id',
   name                 varchar(128) not null comment '业务事项名称',
   name_ref             varchar(64) comment '业务事项名称填写依据',
   first_name           varchar(128) comment '一级子项名称',
   second_name          varchar(128) comment '二级子项名称',
   third_name           varchar(128) comment '三级子项名称',
   code                 varchar(128) comment '业务事项编码',
   type                 varchar(64) comment '业务事项分类',
   basis                varchar(64) comment '业务事项办理依据',
   flow                 varchar(512) comment '业务事项办理流程',
   summary              varchar(512) comment '业务事项简述',
   time_limit           varchar(64) comment '总时限',
   charge_basis         varchar(256) comment '收费依据',
   charge_office_id     bigint comment '业务事项主管单位',
   impl_office_id       bigint comment '业务事项实施单位',
   workload             varchar(64) comment '业务量/工作量',
   relate_office        varchar(64) comment '业务事项办理涉及的其他相关单位',
   need_data            varchar(512) comment '业务事项所需材料',
   produce_data         varchar(512) comment '业务事项产生材料',
   is_use               bit(1) comment '业务事项应用系统',
   remark               text comment '备注',
   share_with           varchar(64) comment '资源共享范围',
   create_by            varchar(0) not null comment '创建者',
   create_date          datetime not null default CURRENT_TIMESTAMP comment '创建时间',
   update_by            bigint comment '更新者',
   update_date          datetime comment '更新日期',
   del_flag             bit(1) not null default 0 comment '是否删除',
   primary key (id)
);

-- ----------------------------
--  Table structure for `job`
-- ----------------------------
create table job
(
   id                   bigint not null comment '岗位id',
   name                 varchar(128) not null comment '岗位名称/职位',
   duty                 varchar(512) not null comment '岗位职责',
   type                 bit(2) comment '岗位属性',
   create_by            bigint not null comment '创建者',
   create_date          datetime not null default CURRENT_TIMESTAMP comment '创建日期',
   update_by            bigint comment '更新者',
   update_date          datetime comment '更新日期',
   remark               text comment '备注',
   del_flag             bit(1) not null default 0 comment '是否删除',
   primary key (id)
);

-- ----------------------------
--  Table structure for `job_business`
-- ----------------------------
create table job_business
(
   job_id               bigint not null comment '岗位id',
   business_id          bigint not null comment '业务id',
   primary key (job_id, business_id)
);

-- ----------------------------
--  Table structure for `job_office`
-- ----------------------------
create table job_office
(
   job_id               bigint not null comment '岗位id',
   office_id            bigint not null comment '组织机构id',
   primary key (job_id, office_id)
);

SET FOREIGN_KEY_CHECKS = 1;
