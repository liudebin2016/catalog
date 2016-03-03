/*
Navicat Oracle Data Transfer
Oracle Client Version : 11.2.0.1.0

Source Server         : oracle-catalog
Source Server Version : 110200
Source Host           : localhost:1521
Source Schema         : ORACLE

Target Server Type    : ORACLE
Target Server Version : 110200
File Encoding         : 65001

Date: 2016-01-25 17:59:35
*/


-- ----------------------------
-- Table structure for BUSINESS
-- ----------------------------
DROP TABLE "ORACLE"."BUSINESS";
CREATE TABLE "ORACLE"."BUSINESS" (
"ID" NUMBER(10) NOT NULL ,
"NAME" NVARCHAR2(255) NOT NULL ,
"NAME_REF" NVARCHAR2(255) NULL ,
"FIRST_NAME" NVARCHAR2(255) NULL ,
"SECOND_NAME" NVARCHAR2(255) NULL ,
"THIRD_NAME" NVARCHAR2(255) NULL ,
"CODE" NVARCHAR2(255) NULL ,
"TYPE" NVARCHAR2(255) NULL ,
"BASIS" NVARCHAR2(255) NULL ,
"FLOW" NVARCHAR2(255) NULL ,
"SUMMARY" NVARCHAR2(255) NULL ,
"TIME_LIMIT" NVARCHAR2(255) NULL ,
"CHARGE_BASIS" NVARCHAR2(255) NULL ,
"CHARGE_OFFICE_ID" NUMBER(10) NULL ,
"IMPL_OFFICE_ID" NUMBER(10) NULL ,
"WORKLOAD" NVARCHAR2(255) NULL ,
"RELATE_OFFICE" NVARCHAR2(255) NULL ,
"NEED_DATA" NVARCHAR2(255) NULL ,
"PRODUCE_DATA" NVARCHAR2(255) NULL ,
"IS_USE" NVARCHAR2(255) NULL ,
"REMARKS" NVARCHAR2(255) NULL ,
"SHARE_WITH" NVARCHAR2(255) NULL ,
"CREATE_BY" NUMBER(10) NULL ,
"CREATE_DATE" TIMESTAMP(4)  NULL ,
"UPDATE_BY" NUMBER(10) NULL ,
"UPDATE_DATE" TIMESTAMP(4)  NULL ,
"DEL_FLAG" NVARCHAR2(255) NOT NULL ,
"STATUS" NVARCHAR2(255) NULL ,
"SUBJECT_ID" NUMBER(10) NULL 
);

-- ----------------------------
-- Records of BUSINESS
-- ----------------------------
INSERT INTO "ORACLE"."BUSINESS" VALUES ('3', 'bbb4', '2', 'bbb', 'bb', 'bb', 'bbb', '4-2', '0', 'bbb', 'bbb', 'bbb', 'bbbb', '5', '3', '0', '0', null, null, '0', null, '2', '1', TO_TIMESTAMP(' 2016-01-10 14:50:15:0000', 'YYYY-MM-DD HH24:MI:SS:FF4'), '1', TO_TIMESTAMP(' 2016-01-10 14:50:15:0000', 'YYYY-MM-DD HH24:MI:SS:FF4'), '0', '2', '7');
INSERT INTO "ORACLE"."BUSINESS" VALUES ('5', 'ddd', '4', 'ddd', 'ddd', 'ddd', 'ddd', '2-3', '0', 'ddd', 'ddd', 'ddd', 'dddd', '3', '4', '0', '0', null, null, '0', null, '4', '1', TO_TIMESTAMP(' 2016-01-10 14:52:04:0000', 'YYYY-MM-DD HH24:MI:SS:FF4'), '1', TO_TIMESTAMP(' 2016-01-10 14:52:04:0000', 'YYYY-MM-DD HH24:MI:SS:FF4'), '0', '2', '9');

-- ----------------------------
-- Table structure for BUSINESS_RESOURCE
-- ----------------------------
DROP TABLE "ORACLE"."BUSINESS_RESOURCE";
CREATE TABLE "ORACLE"."BUSINESS_RESOURCE" (
"BUSINESS_ID" NUMBER(10) NULL ,
"RESOURCE_ID" NUMBER(10) NULL 
);

-- ----------------------------
-- Records of BUSINESS_RESOURCE
-- ----------------------------

-- ----------------------------
-- Table structure for CATALOG_INFO
-- ----------------------------
DROP TABLE "ORACLE"."CATALOG_INFO";
CREATE TABLE "ORACLE"."CATALOG_INFO" (
"ID" NUMBER(10) NOT NULL ,
"TYPE" NUMBER(10) NULL ,
"TYPE_VALUE" NVARCHAR2(255) NULL ,
"OFFICE_ID" NUMBER(10) NULL ,
"CREATE_DATE" TIMESTAMP(4)  NULL ,
"CREATE_BY" NUMBER(10) NULL ,
"UPDATE_DATE" TIMESTAMP(4)  NULL ,
"UPDATE_BY" NUMBER(10) NULL ,
"REMARKS" NVARCHAR2(255) NULL ,
"DEL_FLAG" NVARCHAR2(255) NULL 
);

-- ----------------------------
-- Records of CATALOG_INFO
-- ----------------------------

-- ----------------------------
-- Table structure for JOB
-- ----------------------------
DROP TABLE "ORACLE"."JOB";
CREATE TABLE "ORACLE"."JOB" (
"ID" NUMBER(10) NOT NULL ,
"NAME" NVARCHAR2(255) NOT NULL ,
"DUTY" NVARCHAR2(255) NOT NULL ,
"TYPE" NVARCHAR2(255) NULL ,
"CREATE_BY" NUMBER(10) NOT NULL ,
"CREATE_DATE" TIMESTAMP(4)  NOT NULL ,
"UPDATE_BY" NUMBER(10) NULL ,
"UPDATE_DATE" TIMESTAMP(4)  NULL ,
"REMARKS" NVARCHAR2(255) NULL ,
"DEL_FLAG" NVARCHAR2(255) NOT NULL ,
"STATUS" NVARCHAR2(255) NULL ,
"OFFICE_ID" NUMBER(10) NULL 
);

-- ----------------------------
-- Records of JOB
-- ----------------------------

-- ----------------------------
-- Table structure for JOB_BUSINESS
-- ----------------------------
DROP TABLE "ORACLE"."JOB_BUSINESS";
CREATE TABLE "ORACLE"."JOB_BUSINESS" (
"JOB_ID" NUMBER(20) NOT NULL ,
"BUSINESS_ID" NUMBER(20) NOT NULL 
);

-- ----------------------------
-- Records of JOB_BUSINESS
-- ----------------------------

-- ----------------------------
-- Table structure for OFFICE_INFO
-- ----------------------------
DROP TABLE "ORACLE"."OFFICE_INFO";
CREATE TABLE "ORACLE"."OFFICE_INFO" (
"ID" NUMBER(10) NOT NULL ,
"NAME" NVARCHAR2(255) NOT NULL ,
"PARENT_ID" NVARCHAR2(255) NULL ,
"PARENT_NAME" NVARCHAR2(255) NULL ,
"DUTY" NVARCHAR2(255) NULL ,
"CREATE_DATE" TIMESTAMP(4)  NULL ,
"CREATE_BY" NUMBER(10) NULL ,
"UPDATE_DATE" TIMESTAMP(4)  NULL ,
"UPDATE_BY" NUMBER(10) NULL ,
"REMARK" NVARCHAR2(255) NULL 
);

-- ----------------------------
-- Records of OFFICE_INFO
-- ----------------------------

-- ----------------------------
-- Table structure for REGISTER
-- ----------------------------
DROP TABLE "ORACLE"."REGISTER";
CREATE TABLE "ORACLE"."REGISTER" (
"ID" NUMBER(10) NOT NULL ,
"OFFICE_ID" NUMBER(20) NOT NULL ,
"APPLY_TYPE" VARCHAR2(255 BYTE) NULL ,
"APPLY_ID" NUMBER(9) NULL ,
"APPLY_NAME" NVARCHAR2(255) NULL ,
"APPLY_BY" NUMBER(20) NULL ,
"APPLY_DATE" TIMESTAMP(4)  NULL ,
"APPROVE_BY" NUMBER(20) NULL ,
"APPROVE_DATE" TIMESTAMP(4)  NULL ,
"APPLY_FLAG" NVARCHAR2(255) NOT NULL ,
"APPROVE_FLAG" NVARCHAR2(255) NOT NULL ,
"DEL_FLAG" NVARCHAR2(255) NOT NULL
);

-- ----------------------------
-- Records of REGISTER
-- ----------------------------

-- ----------------------------
-- Table structure for RESOURCE_INFO
-- ----------------------------
DROP TABLE "ORACLE"."RESOURCE_INFO";
CREATE TABLE "ORACLE"."RESOURCE_INFO" (
"ID" NUMBER(10) NOT NULL ,
"NAME" NVARCHAR2(255) NULL ,
"OF_BUSINESS" NVARCHAR2(255) NULL ,
"TYPE" NUMBER(10) NULL ,
"CODE" NVARCHAR2(255) NULL ,
"DESCR" NVARCHAR2(255) NULL ,
"RESPONSE_PARTY" NVARCHAR2(255) NULL ,
"RESPONSE_ATTR" NUMBER(10) NULL ,
"RESPONSE_CU" NVARCHAR2(255) NULL ,
"COLLECT_WAY" NUMBER(10) NULL ,
"SECURITY_LEVEL" NUMBER(10) NULL ,
"INFO_FIELD" NVARCHAR2(255) NULL ,
"IS_DB_SUPPORT" NUMBER(10) NULL ,
"REMARKS" NVARCHAR2(255) NULL ,
"SHARE_REGION" NVARCHAR2(255) NULL ,
"SHARE_MODE" NVARCHAR2(255) NULL ,
"CREATE_DATE" TIMESTAMP(4)  NULL ,
"CREATE_BY" NUMBER(10) NULL ,
"UPDATE_DATE" TIMESTAMP(4)  NULL ,
"UPDATE_BY" NUMBER(10) NULL ,
"UPDATE_CYCLE" NVARCHAR2(255) NULL ,
"DEL_FLAG" NVARCHAR2(255) NULL ,
"STATUS" NVARCHAR2(255) NULL ,
"SUBJECT_ID" NUMBER(10) NULL 
);


--表序列
create sequence resource_info_seq
minvalue 1
maxvalue 999999999999999999999999999
start with 1
increment by 1
cache 20;
-- ----------------------------
-- Triggers structure for table RESOURCE_INFO
-- ----------------------------
CREATE OR REPLACE TRIGGER "ORACLE"."RESOURCE_INFO_TRI" BEFORE INSERT ON "ORACLE"."RESOURCE_INFO" REFERENCING OLD AS "OLD" NEW AS "NEW" FOR EACH ROW ENABLE
BEGIN
   SELECT resource_info_seq.NEXTVAL INTO :NEW.ID FROM DUAL;
END;

-- ----------------------------
-- Records of RESOURCE_INFO
-- ----------------------------

-- ----------------------------
-- Table structure for RPT_SEARCH
-- ----------------------------
DROP TABLE "ORACLE"."RPT_SEARCH";
CREATE TABLE "ORACLE"."RPT_SEARCH" (
"ID" NUMBER(10) NOT NULL ,
"KEYWORD" NVARCHAR2(255) NOT NULL ,
"SRHTIME" TIMESTAMP(4)  NULL ,
"SRHTYPE" NUMBER(10) NULL ,
"OFFICEID" NUMBER(10),
"REMARKS" NVARCHAR2(255) NULL 
);

-- ----------------------------
-- Records of RPT_SEARCH
-- ----------------------------
INSERT INTO "ORACLE"."RPT_SEARCH" VALUES ('1', 'asd', TO_TIMESTAMP(' 2016-01-24 10:40:41:3350', 'YYYY-MM-DD HH24:MI:SS:FF4'), '1', null);
INSERT INTO "ORACLE"."RPT_SEARCH" VALUES ('2', 'asd', TO_TIMESTAMP(' 2016-01-24 10:43:14:0480', 'YYYY-MM-DD HH24:MI:SS:FF4'), '2', null);
INSERT INTO "ORACLE"."RPT_SEARCH" VALUES ('61', 'test', TO_TIMESTAMP(' 2016-01-25 15:28:06:0980', 'YYYY-MM-DD HH24:MI:SS:FF4'), '5', null);
INSERT INTO "ORACLE"."RPT_SEARCH" VALUES ('62', 'test', TO_TIMESTAMP(' 2016-01-25 15:28:17:0550', 'YYYY-MM-DD HH24:MI:SS:FF4'), '1', null);

-- ----------------------------
-- Table structure for SUBJECT_INFO
-- ----------------------------
DROP TABLE "ORACLE"."SUBJECT_INFO";
CREATE TABLE "ORACLE"."SUBJECT_INFO" (
"ID" NUMBER(10) NOT NULL ,
"NAME" NVARCHAR2(255) NOT NULL ,
"PARENT_ID" NUMBER(10) NULL ,
"PARENT_NAME" NVARCHAR2(255) NULL ,
"DESCR" NVARCHAR2(255) NULL ,
"SHARE_REGION" NVARCHAR2(255) NULL ,
"SHARE_MODE" NVARCHAR2(255) NULL ,
"STATUS" NUMBER(10) NULL ,
"CREATE_DATE" TIMESTAMP(4)  NULL ,
"CREATE_BY" NUMBER(10) NULL ,
"UPDATE_DATE" TIMESTAMP(4)  NULL ,
"UPDATE_BY" NUMBER(10) NULL ,
"REMARKS" NVARCHAR2(255) NULL ,
"DEL_FLAG" NVARCHAR2(255) NULL 
);

-- ----------------------------
-- Records of SUBJECT_INFO
-- ----------------------------
INSERT INTO "ORACLE"."SUBJECT_INFO" VALUES ('34', '主题1', null, null, '主题1', '主题1', '主题1', '4', TO_TIMESTAMP(' 2016-01-24 17:54:30:5560', 'YYYY-MM-DD HH24:MI:SS:FF4'), '1', null, null, null, '0');
INSERT INTO "ORACLE"."SUBJECT_INFO" VALUES ('35', '主题11', '34', null, '主题11', '主题11', '主题11', '1', TO_TIMESTAMP(' 2016-01-24 17:55:18:7980', 'YYYY-MM-DD HH24:MI:SS:FF4'), '1', null, null, null, '0');

-- ----------------------------
-- Table structure for SYS_AREA
-- ----------------------------
DROP TABLE "ORACLE"."SYS_AREA";
CREATE TABLE "ORACLE"."SYS_AREA" (
"ID" NUMBER(9) NOT NULL ,
"PARENT_ID" NUMBER(9) NOT NULL ,
"PARENT_IDS" NVARCHAR2(255) NOT NULL ,
"NAME" NVARCHAR2(255) NOT NULL ,
"SORT" NUMBER(9) NULL ,
"CODE" NVARCHAR2(255) NULL ,
"TYPE" NVARCHAR2(255) NULL ,
"CREATE_BY" NUMBER(9) NULL ,
"CREATE_DATE" TIMESTAMP(4)  NULL ,
"UPDATE_BY" NUMBER(9) NULL ,
"UPDATE_DATE" TIMESTAMP(4)  NULL ,
"REMARKS" NVARCHAR2(255) NULL ,
"DEL_FLAG" NVARCHAR2(255) NULL 
);

-- ----------------------------
-- Records of SYS_AREA
-- ----------------------------
INSERT INTO "ORACLE"."SYS_AREA" VALUES ('3', '2', '0,1,2,', '济南市', '30', '110101', '3', '1', TO_TIMESTAMP(' 2015-12-22 21:15:00:0000', 'YYYY-MM-DD HH24:MI:SS:FF4'), '1', TO_TIMESTAMP(' 2015-12-22 21:15:00:0000', 'YYYY-MM-DD HH24:MI:SS:FF4'), null, '0');
INSERT INTO "ORACLE"."SYS_AREA" VALUES ('4', '3', '0,1,2,3,', '历城区', '40', '110102', '4', '1', TO_TIMESTAMP(' 2015-12-22 21:15:00:0000', 'YYYY-MM-DD HH24:MI:SS:FF4'), '1', TO_TIMESTAMP(' 2015-12-22 21:15:00:0000', 'YYYY-MM-DD HH24:MI:SS:FF4'), null, '0');
INSERT INTO "ORACLE"."SYS_AREA" VALUES ('5', '3', '0,1,2,3,', '历下区', '50', '110104', '4', '1', TO_TIMESTAMP(' 2015-12-22 21:15:00:0000', 'YYYY-MM-DD HH24:MI:SS:FF4'), '1', TO_TIMESTAMP(' 2015-12-22 21:15:00:0000', 'YYYY-MM-DD HH24:MI:SS:FF4'), null, '0');
INSERT INTO "ORACLE"."SYS_AREA" VALUES ('6', '3', '0,1,2,3,', '高新区', '60', '110105', '4', '1', TO_TIMESTAMP(' 2015-12-22 21:15:00:0000', 'YYYY-MM-DD HH24:MI:SS:FF4'), '1', TO_TIMESTAMP(' 2015-12-22 21:15:00:0000', 'YYYY-MM-DD HH24:MI:SS:FF4'), null, '0');
INSERT INTO "ORACLE"."SYS_AREA" VALUES ('1', '0', '0,', '中国', '10', '100000', '1', '1', TO_TIMESTAMP(' 2015-12-22 21:15:00:0000', 'YYYY-MM-DD HH24:MI:SS:FF4'), '1', TO_TIMESTAMP(' 2015-12-22 21:15:00:0000', 'YYYY-MM-DD HH24:MI:SS:FF4'), null, '0');
INSERT INTO "ORACLE"."SYS_AREA" VALUES ('2', '1', '0,1,', '山东省', '20', '110000', '2', '1', TO_TIMESTAMP(' 2015-12-22 21:15:00:0000', 'YYYY-MM-DD HH24:MI:SS:FF4'), '1', TO_TIMESTAMP(' 2015-12-22 21:15:00:0000', 'YYYY-MM-DD HH24:MI:SS:FF4'), null, '0');

-- ----------------------------
-- Table structure for SYS_DICT
-- ----------------------------
DROP TABLE "ORACLE"."SYS_DICT";
CREATE TABLE "ORACLE"."SYS_DICT" (
"ID" NUMBER(10) NOT NULL ,
"VALUE" NVARCHAR2(255) NOT NULL ,
"LABEL" NVARCHAR2(255) NOT NULL ,
"TYPE" NVARCHAR2(255) NULL ,
"DESCRIPTION" NVARCHAR2(255) NULL ,
"SORT" NUMBER(19,5) NULL ,
"PARENT_ID" NUMBER(10) NULL ,
"CREATE_BY" NUMBER(10) NULL ,
"CREATE_DATE" TIMESTAMP(4)  NULL ,
"UPDATE_BY" NUMBER(10) NULL ,
"UPDATE_DATE" TIMESTAMP(4)  NULL ,
"REMARKS" NVARCHAR2(255) NULL ,
"DEL_FLAG" NVARCHAR2(255) NULL 
);

-- ----------------------------
-- Records of SYS_DICT
-- ----------------------------
INSERT INTO "ORACLE"."SYS_DICT" VALUES ('11', 'sadf', '345', null, 'vxzvzc', null, null, '1', TO_TIMESTAMP(' 2016-01-24 15:57:15:4590', 'YYYY-MM-DD HH24:MI:SS:FF4'), '1', TO_TIMESTAMP(' 2016-01-24 15:57:15:4590', 'YYYY-MM-DD HH24:MI:SS:FF4'), null, '0');
INSERT INTO "ORACLE"."SYS_DICT" VALUES ('14', 'dfsg', '345', null, 'fhd', null, null, '1', TO_TIMESTAMP(' 2016-01-24 16:41:25:9280', 'YYYY-MM-DD HH24:MI:SS:FF4'), '1', TO_TIMESTAMP(' 2016-01-24 16:41:25:9280', 'YYYY-MM-DD HH24:MI:SS:FF4'), null, '0');
INSERT INTO "ORACLE"."SYS_DICT" VALUES ('15', 'hgjfh', 'ggf', null, 'fghf', null, null, '1', TO_TIMESTAMP(' 2016-01-24 16:41:39:1310', 'YYYY-MM-DD HH24:MI:SS:FF4'), '1', TO_TIMESTAMP(' 2016-01-24 16:41:39:1310', 'YYYY-MM-DD HH24:MI:SS:FF4'), null, '0');
INSERT INTO "ORACLE"."SYS_DICT" VALUES ('16', 'gfhf', 'vvcn', null, 'n v', null, null, '1', TO_TIMESTAMP(' 2016-01-24 16:41:45:1290', 'YYYY-MM-DD HH24:MI:SS:FF4'), '1', TO_TIMESTAMP(' 2016-01-24 16:41:45:1290', 'YYYY-MM-DD HH24:MI:SS:FF4'), null, '0');
INSERT INTO "ORACLE"."SYS_DICT" VALUES ('17', 'vmb', 'bfdbfg', null, 'bnv vm', null, null, '1', TO_TIMESTAMP(' 2016-01-24 16:41:51:8920', 'YYYY-MM-DD HH24:MI:SS:FF4'), '1', TO_TIMESTAMP(' 2016-01-24 16:41:51:8920', 'YYYY-MM-DD HH24:MI:SS:FF4'), null, '0');
INSERT INTO "ORACLE"."SYS_DICT" VALUES ('18', 'gmg', '67jg', null, 'bm', null, null, '1', TO_TIMESTAMP(' 2016-01-24 16:41:58:8440', 'YYYY-MM-DD HH24:MI:SS:FF4'), '1', TO_TIMESTAMP(' 2016-01-24 16:41:58:8440', 'YYYY-MM-DD HH24:MI:SS:FF4'), null, '0');
INSERT INTO "ORACLE"."SYS_DICT" VALUES ('19', 'ghfj', '6ujj', null, 'bvnb', null, null, '1', TO_TIMESTAMP(' 2016-01-24 16:42:05:1560', 'YYYY-MM-DD HH24:MI:SS:FF4'), '1', TO_TIMESTAMP(' 2016-01-24 16:42:05:1560', 'YYYY-MM-DD HH24:MI:SS:FF4'), null, '0');
INSERT INTO "ORACLE"."SYS_DICT" VALUES ('20', '111', '111', null, '111', null, null, '1', TO_TIMESTAMP(' 2016-01-24 16:42:38:2590', 'YYYY-MM-DD HH24:MI:SS:FF4'), '1', TO_TIMESTAMP(' 2016-01-24 16:42:38:2590', 'YYYY-MM-DD HH24:MI:SS:FF4'), null, '0');
INSERT INTO "ORACLE"."SYS_DICT" VALUES ('21', '2222', '2222', null, '2222', null, null, '1', TO_TIMESTAMP(' 2016-01-24 16:42:43:7270', 'YYYY-MM-DD HH24:MI:SS:FF4'), '1', TO_TIMESTAMP(' 2016-01-24 16:42:43:7270', 'YYYY-MM-DD HH24:MI:SS:FF4'), null, '0');
INSERT INTO "ORACLE"."SYS_DICT" VALUES ('22', '333', '333', null, '3333', null, null, '1', TO_TIMESTAMP(' 2016-01-24 16:42:49:1940', 'YYYY-MM-DD HH24:MI:SS:FF4'), '1', TO_TIMESTAMP(' 2016-01-24 16:42:49:1940', 'YYYY-MM-DD HH24:MI:SS:FF4'), null, '0');
INSERT INTO "ORACLE"."SYS_DICT" VALUES ('23', '444', '444', null, '444', null, null, '1', TO_TIMESTAMP(' 2016-01-24 16:42:54:6730', 'YYYY-MM-DD HH24:MI:SS:FF4'), '1', TO_TIMESTAMP(' 2016-01-24 16:42:54:6730', 'YYYY-MM-DD HH24:MI:SS:FF4'), null, '0');
INSERT INTO "ORACLE"."SYS_DICT" VALUES ('24', '555', '555', null, '555', null, null, '1', TO_TIMESTAMP(' 2016-01-24 16:43:00:3240', 'YYYY-MM-DD HH24:MI:SS:FF4'), '1', TO_TIMESTAMP(' 2016-01-24 16:43:00:3240', 'YYYY-MM-DD HH24:MI:SS:FF4'), null, '0');
INSERT INTO "ORACLE"."SYS_DICT" VALUES ('25', '666', '666', null, '666', null, null, '1', TO_TIMESTAMP(' 2016-01-24 16:43:06:1100', 'YYYY-MM-DD HH24:MI:SS:FF4'), '1', TO_TIMESTAMP(' 2016-01-24 16:43:06:1100', 'YYYY-MM-DD HH24:MI:SS:FF4'), null, '0');
INSERT INTO "ORACLE"."SYS_DICT" VALUES ('26', '777', '777', null, '777', null, null, '1', TO_TIMESTAMP(' 2016-01-24 16:43:13:4410', 'YYYY-MM-DD HH24:MI:SS:FF4'), '1', TO_TIMESTAMP(' 2016-01-24 16:43:13:4410', 'YYYY-MM-DD HH24:MI:SS:FF4'), null, '0');
INSERT INTO "ORACLE"."SYS_DICT" VALUES ('27', '888', '888', null, '888', null, null, '1', TO_TIMESTAMP(' 2016-01-24 16:43:18:7270', 'YYYY-MM-DD HH24:MI:SS:FF4'), '1', TO_TIMESTAMP(' 2016-01-24 16:43:18:7270', 'YYYY-MM-DD HH24:MI:SS:FF4'), null, '0');
INSERT INTO "ORACLE"."SYS_DICT" VALUES ('28', '988', '999', null, '999', null, null, '1', TO_TIMESTAMP(' 2016-01-24 16:43:24:6940', 'YYYY-MM-DD HH24:MI:SS:FF4'), '1', TO_TIMESTAMP(' 2016-01-24 16:43:24:6940', 'YYYY-MM-DD HH24:MI:SS:FF4'), null, '0');
INSERT INTO "ORACLE"."SYS_DICT" VALUES ('29', '222', '22', null, '222', null, '28', '1', TO_TIMESTAMP(' 2016-01-24 16:48:46:4070', 'YYYY-MM-DD HH24:MI:SS:FF4'), '1', TO_TIMESTAMP(' 2016-01-24 16:48:46:4070', 'YYYY-MM-DD HH24:MI:SS:FF4'), null, '0');

-- ----------------------------
-- Table structure for SYS_LOG
-- ----------------------------
DROP TABLE "ORACLE"."SYS_LOG";
CREATE TABLE "ORACLE"."SYS_LOG" (
"ID" NUMBER(10) NOT NULL ,
"TYPE" NVARCHAR2(255) NULL ,
"TITLE" NVARCHAR2(255) NULL ,
"CREATE_BY" NUMBER(10) NULL ,
"CREATE_DATE" TIMESTAMP(4)  NULL ,
"REMOTE_ADDR" NVARCHAR2(255) NULL ,
"USER_AGENT" NVARCHAR2(255) NULL ,
"REQUEST_URI" NVARCHAR2(255) NULL ,
"METHOD" NVARCHAR2(255) NULL ,
"PARAMS" NVARCHAR2(255) NULL ,
"EXCEPTION" NVARCHAR2(255) NULL 
);

-- ----------------------------
-- Records of SYS_LOG
-- ----------------------------
INSERT INTO "ORACLE"."SYS_LOG" VALUES ('3', '1', '系统登录', '1', TO_TIMESTAMP(' 2016-01-24 12:54:55:0640', 'YYYY-MM-DD HH24:MI:SS:FF4'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64; rv:43.0) Gecko/20100101 Firefox/43.0', '/admin;JSESSIONID=a9e263dc46724d2bba228c9f23535d9b', 'GET', null, null);
INSERT INTO "ORACLE"."SYS_LOG" VALUES ('4', '1', '系统登录', '1', TO_TIMESTAMP(' 2016-01-24 13:07:00:6630', 'YYYY-MM-DD HH24:MI:SS:FF4'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64; rv:43.0) Gecko/20100101 Firefox/43.0', '/admin', 'GET', null, null);
INSERT INTO "ORACLE"."SYS_LOG" VALUES ('5', '1', '系统登录', '1', TO_TIMESTAMP(' 2016-01-24 15:02:59:5140', 'YYYY-MM-DD HH24:MI:SS:FF4'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64; rv:43.0) Gecko/20100101 Firefox/43.0', '/admin;JSESSIONID=e8f67b02c0314286a41ddb2df5d9065e', 'GET', null, null);
INSERT INTO "ORACLE"."SYS_LOG" VALUES ('6', '1', '系统登录', '1', TO_TIMESTAMP(' 2016-01-24 15:06:07:8980', 'YYYY-MM-DD HH24:MI:SS:FF4'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64; rv:43.0) Gecko/20100101 Firefox/43.0', '/admin', 'GET', null, null);
INSERT INTO "ORACLE"."SYS_LOG" VALUES ('7', '1', '系统登录', '1', TO_TIMESTAMP(' 2016-01-24 15:12:06:0990', 'YYYY-MM-DD HH24:MI:SS:FF4'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64; rv:43.0) Gecko/20100101 Firefox/43.0', '/admin;JSESSIONID=6997462309c543d7be1243d2971e73c7', 'GET', null, null);
INSERT INTO "ORACLE"."SYS_LOG" VALUES ('8', '1', '系统登录', '1', TO_TIMESTAMP(' 2016-01-24 15:31:55:5160', 'YYYY-MM-DD HH24:MI:SS:FF4'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64; rv:43.0) Gecko/20100101 Firefox/43.0', '/admin', 'GET', null, null);
INSERT INTO "ORACLE"."SYS_LOG" VALUES ('9', '1', '系统登录', '1', TO_TIMESTAMP(' 2016-01-24 15:48:07:4860', 'YYYY-MM-DD HH24:MI:SS:FF4'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64; rv:43.0) Gecko/20100101 Firefox/43.0', '/admin', 'GET', null, null);
INSERT INTO "ORACLE"."SYS_LOG" VALUES ('10', '1', '系统登录', '1', TO_TIMESTAMP(' 2016-01-24 15:53:00:4000', 'YYYY-MM-DD HH24:MI:SS:FF4'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64; rv:43.0) Gecko/20100101 Firefox/43.0', '/admin', 'GET', null, null);
INSERT INTO "ORACLE"."SYS_LOG" VALUES ('12', '1', '系统登录', '1', TO_TIMESTAMP(' 2016-01-24 16:11:55:3170', 'YYYY-MM-DD HH24:MI:SS:FF4'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64; rv:43.0) Gecko/20100101 Firefox/43.0', '/admin;JSESSIONID=3a2f026b306140fbae0c81fb5f7e74c8', 'GET', null, null);
INSERT INTO "ORACLE"."SYS_LOG" VALUES ('13', '1', '系统登录', '1', TO_TIMESTAMP(' 2016-01-24 16:39:16:9260', 'YYYY-MM-DD HH24:MI:SS:FF4'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64; rv:43.0) Gecko/20100101 Firefox/43.0', '/admin', 'GET', null, null);
INSERT INTO "ORACLE"."SYS_LOG" VALUES ('30', '1', '系统登录', '1', TO_TIMESTAMP(' 2016-01-24 16:55:27:3950', 'YYYY-MM-DD HH24:MI:SS:FF4'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64; rv:43.0) Gecko/20100101 Firefox/43.0', '/admin', 'GET', null, null);
INSERT INTO "ORACLE"."SYS_LOG" VALUES ('31', '1', '系统登录', '1', TO_TIMESTAMP(' 2016-01-24 17:11:52:3060', 'YYYY-MM-DD HH24:MI:SS:FF4'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64; rv:43.0) Gecko/20100101 Firefox/43.0', '/admin', 'GET', null, null);
INSERT INTO "ORACLE"."SYS_LOG" VALUES ('32', '1', '系统登录', '1', TO_TIMESTAMP(' 2016-01-24 17:34:43:8060', 'YYYY-MM-DD HH24:MI:SS:FF4'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64; rv:43.0) Gecko/20100101 Firefox/43.0', '/admin', 'GET', null, null);
INSERT INTO "ORACLE"."SYS_LOG" VALUES ('33', '1', '系统登录', '1', TO_TIMESTAMP(' 2016-01-24 17:48:43:9480', 'YYYY-MM-DD HH24:MI:SS:FF4'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; WOW64; rv:43.0) Gecko/20100101 Firefox/43.0', '/admin', 'GET', null, null);
INSERT INTO "ORACLE"."SYS_LOG" VALUES ('36', '1', '系统登录', '1', TO_TIMESTAMP(' 2016-01-24 20:26:10:3230', 'YYYY-MM-DD HH24:MI:SS:FF4'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64; rv:43.0) Gecko/20100101 Firefox/43.0', '/admin', 'GET', null, null);
INSERT INTO "ORACLE"."SYS_LOG" VALUES ('37', '1', '系统登录', '1', TO_TIMESTAMP(' 2016-01-24 20:54:21:0420', 'YYYY-MM-DD HH24:MI:SS:FF4'), '127.0.0.1', 'Mozilla/5.0 (Windows NT 10.0; WOW64; rv:43.0) Gecko/20100101 Firefox/43.0', '/admin', 'GET', null, null);
INSERT INTO "ORACLE"."SYS_LOG" VALUES ('38', '1', '系统登录', '1', TO_TIMESTAMP(' 2016-01-24 21:05:17:3780', 'YYYY-MM-DD HH24:MI:SS:FF4'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64; rv:43.0) Gecko/20100101 Firefox/43.0', '/admin', 'GET', null, null);
INSERT INTO "ORACLE"."SYS_LOG" VALUES ('39', '1', '系统登录', '1', TO_TIMESTAMP(' 2016-01-24 21:17:36:4950', 'YYYY-MM-DD HH24:MI:SS:FF4'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64; rv:43.0) Gecko/20100101 Firefox/43.0', '/admin', 'GET', null, null);
INSERT INTO "ORACLE"."SYS_LOG" VALUES ('40', '1', '系统登录', '1', TO_TIMESTAMP(' 2016-01-24 21:43:24:9260', 'YYYY-MM-DD HH24:MI:SS:FF4'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64; rv:43.0) Gecko/20100101 Firefox/43.0', '/admin', 'GET', null, null);
INSERT INTO "ORACLE"."SYS_LOG" VALUES ('41', '1', '系统登录', '1', TO_TIMESTAMP(' 2016-01-24 21:57:43:5380', 'YYYY-MM-DD HH24:MI:SS:FF4'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64; rv:43.0) Gecko/20100101 Firefox/43.0', '/admin', 'GET', null, null);
INSERT INTO "ORACLE"."SYS_LOG" VALUES ('42', '1', '系统登录', '2', TO_TIMESTAMP(' 2016-01-24 21:59:49:2860', 'YYYY-MM-DD HH24:MI:SS:FF4'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64; rv:43.0) Gecko/20100101 Firefox/43.0', '/admin;JSESSIONID=e8ef04373bab4b2b9b2d323e26ba4c1b', 'GET', null, null);
INSERT INTO "ORACLE"."SYS_LOG" VALUES ('43', '1', '系统登录', '2', TO_TIMESTAMP(' 2016-01-24 22:03:44:5180', 'YYYY-MM-DD HH24:MI:SS:FF4'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64; rv:43.0) Gecko/20100101 Firefox/43.0', '/admin', 'GET', null, null);
INSERT INTO "ORACLE"."SYS_LOG" VALUES ('44', '1', '系统登录', '2', TO_TIMESTAMP(' 2016-01-24 22:10:23:2940', 'YYYY-MM-DD HH24:MI:SS:FF4'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64; rv:43.0) Gecko/20100101 Firefox/43.0', '/admin', 'GET', null, null);
INSERT INTO "ORACLE"."SYS_LOG" VALUES ('45', '1', '系统登录', '1', TO_TIMESTAMP(' 2016-01-25 14:18:33:3530', 'YYYY-MM-DD HH24:MI:SS:FF4'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/47.0.2526.111 Safari/537.36', '/admin', 'GET', null, null);
INSERT INTO "ORACLE"."SYS_LOG" VALUES ('46', '1', '系统登录', '1', TO_TIMESTAMP(' 2016-01-25 14:24:59:5220', 'YYYY-MM-DD HH24:MI:SS:FF4'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/47.0.2526.111 Safari/537.36', '/admin', 'GET', null, null);
INSERT INTO "ORACLE"."SYS_LOG" VALUES ('50', '1', '系统登录', '1', TO_TIMESTAMP(' 2016-01-25 14:33:21:8750', 'YYYY-MM-DD HH24:MI:SS:FF4'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/47.0.2526.111 Safari/537.36', '/admin', 'GET', null, null);
INSERT INTO "ORACLE"."SYS_LOG" VALUES ('53', '1', '系统登录', '1', TO_TIMESTAMP(' 2016-01-25 14:41:49:9110', 'YYYY-MM-DD HH24:MI:SS:FF4'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/47.0.2526.111 Safari/537.36', '/admin', 'GET', null, null);
INSERT INTO "ORACLE"."SYS_LOG" VALUES ('63', '1', '系统登录', '2', TO_TIMESTAMP(' 2016-01-25 15:28:30:8970', 'YYYY-MM-DD HH24:MI:SS:FF4'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/47.0.2526.106 Safari/537.36', '/admin', 'GET', null, null);
INSERT INTO "ORACLE"."SYS_LOG" VALUES ('64', '1', '系统登录', '2', TO_TIMESTAMP(' 2016-01-25 15:32:04:4560', 'YYYY-MM-DD HH24:MI:SS:FF4'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/47.0.2526.106 Safari/537.36', '/admin', 'GET', null, null);
INSERT INTO "ORACLE"."SYS_LOG" VALUES ('65', '1', '系统登录', '2', TO_TIMESTAMP(' 2016-01-25 15:34:29:7030', 'YYYY-MM-DD HH24:MI:SS:FF4'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/47.0.2526.106 Safari/537.36', '/admin', 'GET', null, null);
INSERT INTO "ORACLE"."SYS_LOG" VALUES ('66', '1', '系统登录', '2', TO_TIMESTAMP(' 2016-01-25 15:53:30:6750', 'YYYY-MM-DD HH24:MI:SS:FF4'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/47.0.2526.106 Safari/537.36', '/admin', 'GET', null, null);
INSERT INTO "ORACLE"."SYS_LOG" VALUES ('67', '1', '系统登录', '2', TO_TIMESTAMP(' 2016-01-25 17:44:58:6380', 'YYYY-MM-DD HH24:MI:SS:FF4'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/47.0.2526.106 Safari/537.36', '/admin', 'GET', null, null);
INSERT INTO "ORACLE"."SYS_LOG" VALUES ('68', '1', '系统登录', '1', TO_TIMESTAMP(' 2016-01-25 17:45:15:3620', 'YYYY-MM-DD HH24:MI:SS:FF4'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/47.0.2526.106 Safari/537.36', '/admin', 'GET', null, null);
INSERT INTO "ORACLE"."SYS_LOG" VALUES ('69', '1', '系统登录', '1', TO_TIMESTAMP(' 2016-01-25 17:59:14:0020', 'YYYY-MM-DD HH24:MI:SS:FF4'), '0:0:0:0:0:0:0:1', 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/47.0.2526.106 Safari/537.36', '/admin', 'GET', null, null);

-- ----------------------------
-- Table structure for SYS_MDICT
-- ----------------------------
DROP TABLE "ORACLE"."SYS_MDICT";
CREATE TABLE "ORACLE"."SYS_MDICT" (
"ID" NUMBER(10) NOT NULL ,
"PARENT_ID" NUMBER(10) NOT NULL ,
"PARENT_IDS" NVARCHAR2(255) NOT NULL ,
"NAME" NVARCHAR2(255) NOT NULL ,
"SORT" NUMBER(19,5) NOT NULL ,
"DESCRIPTION" NVARCHAR2(255) NULL ,
"CREATE_BY" NUMBER(10) NOT NULL ,
"CREATE_DATE" TIMESTAMP(4)  NOT NULL ,
"UPDATE_BY" NUMBER(10) NOT NULL ,
"UPDATE_DATE" TIMESTAMP(4)  NOT NULL ,
"REMARKS" NVARCHAR2(255) NULL ,
"DEL_FLAG" NVARCHAR2(255) NOT NULL 
);

-- ----------------------------
-- Records of SYS_MDICT
-- ----------------------------

-- ----------------------------
-- Table structure for SYS_MENU
-- ----------------------------
DROP TABLE "ORACLE"."SYS_MENU";
CREATE TABLE "ORACLE"."SYS_MENU" (
"ID" NUMBER(10) NOT NULL ,
"PARENT_ID" NUMBER(10) NOT NULL ,
"PARENT_IDS" NVARCHAR2(255) NOT NULL ,
"NAME" NVARCHAR2(255) NOT NULL ,
"SORT" NUMBER(19,5) NOT NULL ,
"HREF" NVARCHAR2(255) NULL ,
"TARGET" NVARCHAR2(255) NULL ,
"ICON" NVARCHAR2(255) NULL ,
"IS_SHOW" NVARCHAR2(255) NOT NULL ,
"PERMISSION" NVARCHAR2(255) NULL ,
"CREATE_BY" NUMBER(10) NOT NULL ,
"CREATE_DATE" TIMESTAMP(4)  NOT NULL ,
"UPDATE_BY" NUMBER(10) NOT NULL ,
"UPDATE_DATE" TIMESTAMP(4)  NOT NULL ,
"REMARKS" NVARCHAR2(255) NULL ,
"DEL_FLAG" NVARCHAR2(255) NOT NULL 
);

-- ----------------------------
-- Records of SYS_MENU
-- ----------------------------
INSERT INTO "ORACLE"."SYS_MENU" VALUES ('1', '0', '0,', '功能菜单', '0', null, null, null, '1', null, '1', TO_TIMESTAMP(' 2015-12-23 09:05:00:0000', 'YYYY-MM-DD HH24:MI:SS:FF4'), '1', TO_TIMESTAMP(' 2015-12-23 09:05:00:0000', 'YYYY-MM-DD HH24:MI:SS:FF4'), null, '0');
INSERT INTO "ORACLE"."SYS_MENU" VALUES ('2', '1', '0,1,', '系统管理', '900', null, null, null, '1', null, '1', TO_TIMESTAMP(' 2015-12-23 09:05:00:0000', 'YYYY-MM-DD HH24:MI:SS:FF4'), '1', TO_TIMESTAMP(' 2015-12-23 09:05:00:0000', 'YYYY-MM-DD HH24:MI:SS:FF4'), null, '0');
INSERT INTO "ORACLE"."SYS_MENU" VALUES ('3', '2', '0,1,2,', '信息统计', '980', '/admin/statistic/info', null, null, '1', null, '1', TO_TIMESTAMP(' 2015-12-23 09:05:00:0000', 'YYYY-MM-DD HH24:MI:SS:FF4'), '1', TO_TIMESTAMP(' 2015-12-23 09:05:00:0000', 'YYYY-MM-DD HH24:MI:SS:FF4'), null, '0');
INSERT INTO "ORACLE"."SYS_MENU" VALUES ('4', '2', '0,1,2,', '检索统计', '10', '/admin/statistic/search', null, null, '1', null, '1', TO_TIMESTAMP(' 2015-12-23 14:27:00:0000', 'YYYY-MM-DD HH24:MI:SS:FF4'), '1', TO_TIMESTAMP(' 2015-12-23 14:27:00:0000', 'YYYY-MM-DD HH24:MI:SS:FF4'), null, '0');
INSERT INTO "ORACLE"."SYS_MENU" VALUES ('5', '2', '0,1,2,', '使用日志', '20', '/admin/log/list', null, null, '1', null, '1', TO_TIMESTAMP(' 2015-12-23 14:27:00:0000', 'YYYY-MM-DD HH24:MI:SS:FF4'), '1', TO_TIMESTAMP(' 2015-12-23 14:27:00:0000', 'YYYY-MM-DD HH24:MI:SS:FF4'), null, '0');
INSERT INTO "ORACLE"."SYS_MENU" VALUES ('6', '2', '0,1,2,', '字典管理', '30', '/admin/dict/list', null, null, '1', null, '1', TO_TIMESTAMP(' 2015-12-23 14:27:00:0000', 'YYYY-MM-DD HH24:MI:SS:FF4'), '1', TO_TIMESTAMP(' 2015-12-23 14:27:00:0000', 'YYYY-MM-DD HH24:MI:SS:FF4'), null, '0');
INSERT INTO "ORACLE"."SYS_MENU" VALUES ('7', '1', '0,1,', '共享目录', '100', null, null, null, '1', null, '1', TO_TIMESTAMP(' 2015-12-23 14:27:00:0000', 'YYYY-MM-DD HH24:MI:SS:FF4'), '1', TO_TIMESTAMP(' 2015-12-23 14:27:00:0000', 'YYYY-MM-DD HH24:MI:SS:FF4'), null, '0');
INSERT INTO "ORACLE"."SYS_MENU" VALUES ('8', '7', '0,1,7,', '机构职责信息', '10', '/admin/office/info', null, null, '1', null, '1', TO_TIMESTAMP(' 2015-12-23 14:27:00:0000', 'YYYY-MM-DD HH24:MI:SS:FF4'), '1', TO_TIMESTAMP(' 2015-12-23 14:27:00:0000', 'YYYY-MM-DD HH24:MI:SS:FF4'), null, '0');
INSERT INTO "ORACLE"."SYS_MENU" VALUES ('9', '7', '0,1,7,', '部门岗位信息', '20', '/admin/job/info', null, null, '1', null, '1', TO_TIMESTAMP(' 2015-12-23 14:31:00:0000', 'YYYY-MM-DD HH24:MI:SS:FF4'), '1', TO_TIMESTAMP(' 2015-12-23 14:31:00:0000', 'YYYY-MM-DD HH24:MI:SS:FF4'), null, '0');
INSERT INTO "ORACLE"."SYS_MENU" VALUES ('10', '1', '0,1,', '目录管理', '400', null, null, null, '1', null, '1', TO_TIMESTAMP(' 2015-12-24 14:24:00:0000', 'YYYY-MM-DD HH24:MI:SS:FF4'), '1', TO_TIMESTAMP(' 2015-12-24 14:24:00:0000', 'YYYY-MM-DD HH24:MI:SS:FF4'), null, '0');
INSERT INTO "ORACLE"."SYS_MENU" VALUES ('11', '10', '0,1,10,', '机构目录管理', '10', '/admin/office/manage', null, null, '1', null, '1', TO_TIMESTAMP(' 2015-12-24 14:24:00:0000', 'YYYY-MM-DD HH24:MI:SS:FF4'), '1', TO_TIMESTAMP(' 2015-12-24 14:24:00:0000', 'YYYY-MM-DD HH24:MI:SS:FF4'), null, '0');
INSERT INTO "ORACLE"."SYS_MENU" VALUES ('12', '10', '0,1,10,', '岗位目录管理', '20', '/admin/job/manage', null, null, '1', null, '1', TO_TIMESTAMP(' 2015-12-24 14:24:00:0000', 'YYYY-MM-DD HH24:MI:SS:FF4'), '1', TO_TIMESTAMP(' 2015-12-24 14:24:00:0000', 'YYYY-MM-DD HH24:MI:SS:FF4'), null, '0');
INSERT INTO "ORACLE"."SYS_MENU" VALUES ('13', '10', '0,1,10,', '业务目录管理', '30', '/admin/business/manage', null, null, '1', null, '1', TO_TIMESTAMP(' 2015-12-24 14:24:00:0000', 'YYYY-MM-DD HH24:MI:SS:FF4'), '1', TO_TIMESTAMP(' 2015-12-24 14:24:00:0000', 'YYYY-MM-DD HH24:MI:SS:FF4'), null, '0');
INSERT INTO "ORACLE"."SYS_MENU" VALUES ('14', '10', '0,1,10,', '资源目录管理', '40', '/admin/resource/manage', null, null, '1', null, '1', TO_TIMESTAMP(' 2015-12-24 14:24:00:0000', 'YYYY-MM-DD HH24:MI:SS:FF4'), '1', TO_TIMESTAMP(' 2015-12-24 14:24:00:0000', 'YYYY-MM-DD HH24:MI:SS:FF4'), null, '0');
INSERT INTO "ORACLE"."SYS_MENU" VALUES ('15', '10', '0,1,10,', '主题目录管理', '50', '/admin/subject/manage', null, null, '1', null, '1', TO_TIMESTAMP(' 2015-12-24 14:24:00:0000', 'YYYY-MM-DD HH24:MI:SS:FF4'), '1', TO_TIMESTAMP(' 2015-12-24 14:24:00:0000', 'YYYY-MM-DD HH24:MI:SS:FF4'), null, '0');
INSERT INTO "ORACLE"."SYS_MENU" VALUES ('17', '7', '0,1,7,', '业务目录信息', '30', '/admin/business/index', null, null, '1', null, '1', TO_TIMESTAMP(' 2015-12-29 17:21:00:0000', 'YYYY-MM-DD HH24:MI:SS:FF4'), '1', TO_TIMESTAMP(' 2015-12-29 17:21:00:0000', 'YYYY-MM-DD HH24:MI:SS:FF4'), null, '0');
INSERT INTO "ORACLE"."SYS_MENU" VALUES ('18', '7', '0,1,7,', '资源目录信息', '40', '/admin/resource/index', null, null, '1', null, '1', TO_TIMESTAMP(' 2015-12-29 17:21:00:0000', 'YYYY-MM-DD HH24:MI:SS:FF4'), '1', TO_TIMESTAMP(' 2015-12-29 17:21:00:0000', 'YYYY-MM-DD HH24:MI:SS:FF4'), null, '0');
INSERT INTO "ORACLE"."SYS_MENU" VALUES ('19', '7', '0,1,7,', '主题目录信息', '50', '/admin/subject/index', null, null, '1', null, '1', TO_TIMESTAMP(' 2015-12-29 17:21:00:0000', 'YYYY-MM-DD HH24:MI:SS:FF4'), '1', TO_TIMESTAMP(' 2015-12-29 17:21:00:0000', 'YYYY-MM-DD HH24:MI:SS:FF4'), null, '0');
INSERT INTO "ORACLE"."SYS_MENU" VALUES ('20', '1', '0,1,', '部门目录', '200', null, null, null, '1', null, '1', TO_TIMESTAMP(' 2015-12-29 17:21:00:0000', 'YYYY-MM-DD HH24:MI:SS:FF4'), '1', TO_TIMESTAMP(' 2015-12-29 17:21:00:0000', 'YYYY-MM-DD HH24:MI:SS:FF4'), null, '0');
INSERT INTO "ORACLE"."SYS_MENU" VALUES ('21', '20', '0,1,20,', '机构职责维护', '10', '/admin/office/maintenance', null, null, '1', null, '1', TO_TIMESTAMP(' 2015-12-29 17:21:00:0000', 'YYYY-MM-DD HH24:MI:SS:FF4'), '1', TO_TIMESTAMP(' 2015-12-29 17:21:00:0000', 'YYYY-MM-DD HH24:MI:SS:FF4'), null, '0');
INSERT INTO "ORACLE"."SYS_MENU" VALUES ('22', '20', '0,1,20,', '部门岗位维护', '20', '/admin/job/maintenance', null, null, '1', null, '1', TO_TIMESTAMP(' 2015-12-29 17:21:00:0000', 'YYYY-MM-DD HH24:MI:SS:FF4'), '1', TO_TIMESTAMP(' 2015-12-29 17:21:00:0000', 'YYYY-MM-DD HH24:MI:SS:FF4'), null, '0');
INSERT INTO "ORACLE"."SYS_MENU" VALUES ('24', '20', '0,1,20,', '业务信息维护', '40', '/admin/business/maintenance', null, null, '1', null, '1', TO_TIMESTAMP(' 2015-12-29 17:31:00:0000', 'YYYY-MM-DD HH24:MI:SS:FF4'), '1', TO_TIMESTAMP(' 2015-12-29 17:31:00:0000', 'YYYY-MM-DD HH24:MI:SS:FF4'), null, '0');
INSERT INTO "ORACLE"."SYS_MENU" VALUES ('26', '20', '0,1,20,', '资源信息维护', '60', '/admin/resource/maintenance', null, null, '1', null, '1', TO_TIMESTAMP(' 2015-12-29 17:31:00:0000', 'YYYY-MM-DD HH24:MI:SS:FF4'), '1', TO_TIMESTAMP(' 2015-12-29 17:31:00:0000', 'YYYY-MM-DD HH24:MI:SS:FF4'), null, '0');
INSERT INTO "ORACLE"."SYS_MENU" VALUES ('28', '20', '0,1,20,', '主题信息关联', '80', '/admin/subject/link', null, null, '1', null, '1', TO_TIMESTAMP(' 2015-12-29 17:31:00:0000', 'YYYY-MM-DD HH24:MI:SS:FF4'), '1', TO_TIMESTAMP(' 2015-12-29 17:31:00:0000', 'YYYY-MM-DD HH24:MI:SS:FF4'), null, '0');
INSERT INTO "ORACLE"."SYS_MENU" VALUES ('29', '1', '0,1,', '注册申请', '300', null, null, null, '1', null, '1', TO_TIMESTAMP(' 2015-12-29 17:31:00:0000', 'YYYY-MM-DD HH24:MI:SS:FF4'), '1', TO_TIMESTAMP(' 2015-12-29 17:31:00:0000', 'YYYY-MM-DD HH24:MI:SS:FF4'), null, '0');
INSERT INTO "ORACLE"."SYS_MENU" VALUES ('30', '29', '0,1,29,', '注册申请', '10', '/admin/register/applyIndex', null, null, '1', null, '1', TO_TIMESTAMP(' 2015-12-29 17:31:00:0000', 'YYYY-MM-DD HH24:MI:SS:FF4'), '1', TO_TIMESTAMP(' 2015-12-29 17:31:00:0000', 'YYYY-MM-DD HH24:MI:SS:FF4'), null, '0');
INSERT INTO "ORACLE"."SYS_MENU" VALUES ('31', '1', '0,1,', '注册审批', '500', null, null, null, '1', null, '1', TO_TIMESTAMP(' 2015-12-29 17:57:00:0000', 'YYYY-MM-DD HH24:MI:SS:FF4'), '1', TO_TIMESTAMP(' 2015-12-29 17:57:00:0000', 'YYYY-MM-DD HH24:MI:SS:FF4'), null, '0');
INSERT INTO "ORACLE"."SYS_MENU" VALUES ('32', '31', '0,1,31,', '注册审批', '10', '/admin/register/approveIndex', null, null, '1', null, '1', TO_TIMESTAMP(' 2015-12-29 17:57:00:0000', 'YYYY-MM-DD HH24:MI:SS:FF4'), '1', TO_TIMESTAMP(' 2015-12-29 17:57:00:0000', 'YYYY-MM-DD HH24:MI:SS:FF4'), null, '0');

-- ----------------------------
-- Table structure for SYS_OFFICE
-- ----------------------------
DROP TABLE "ORACLE"."SYS_OFFICE";
CREATE TABLE "ORACLE"."SYS_OFFICE" (
"ID" NUMBER(9) NOT NULL ,
"PARENT_ID" NUMBER(9) NOT NULL ,
"PARENT_IDS" NVARCHAR2(255) NULL ,
"NAME" NVARCHAR2(255) NOT NULL ,
"SORT" NUMBER(9) NULL ,
"AREA_ID" NVARCHAR2(255) NULL ,
"CODE" NVARCHAR2(255) NULL ,
"TYPE" NVARCHAR2(255) NULL ,
"GRADE" NVARCHAR2(255) NULL ,
"ADDRESS" NVARCHAR2(255) NULL ,
"ZIP_CODE" NVARCHAR2(255) NULL ,
"MASTER" NVARCHAR2(255) NULL ,
"PHONE" NVARCHAR2(255) NULL ,
"FAX" NVARCHAR2(255) NULL ,
"EMAIL" NVARCHAR2(255) NULL ,
"USEABLE" NVARCHAR2(255) NULL ,
"PRIMARY_PERSON" NUMBER(9) NULL ,
"DEPUTY_PERSON" NUMBER(9) NULL ,
"CREATE_BY" NUMBER(9) NULL ,
"CREATE_DATE" TIMESTAMP(4)  NULL ,
"UPDATE_BY" NUMBER(9) NULL ,
"UPDATE_DATE" TIMESTAMP(4)  NULL ,
"REMARKS" NVARCHAR2(255) NULL ,
"DEL_FLAG" NVARCHAR2(255) NULL ,
"DUTY" NVARCHAR2(255) NULL ,
"STATUS" NVARCHAR2(255) NULL 
);

-- ----------------------------
-- Records of SYS_OFFICE
-- ----------------------------
INSERT INTO "ORACLE"."SYS_OFFICE" VALUES ('3', '1', '0,1,', '综合部', '20', '2', '100002', '2', '1', null, null, null, null, null, null, '1', null, null, '1', TO_TIMESTAMP(' 1015-12-22 00:00:00:0000', 'YYYY-MM-DD HH24:MI:SS:FF4'), '1', TO_TIMESTAMP(' 1015-12-22 00:00:00:0000', 'YYYY-MM-DD HH24:MI:SS:FF4'), null, '0', null, '0');
INSERT INTO "ORACLE"."SYS_OFFICE" VALUES ('4', '1', '0,1,', '市场部', '30', '2', '100003', '2', '1', null, null, null, null, null, null, '1', null, null, '1', TO_TIMESTAMP(' 1015-12-22 00:00:00:0000', 'YYYY-MM-DD HH24:MI:SS:FF4'), '1', TO_TIMESTAMP(' 1015-12-22 00:00:00:0000', 'YYYY-MM-DD HH24:MI:SS:FF4'), null, '0', null, '0');
INSERT INTO "ORACLE"."SYS_OFFICE" VALUES ('5', '1', '0,1,', '技术部', '40', '2', '100004', '2', '1', null, null, null, null, null, null, '1', null, null, '1', TO_TIMESTAMP(' 1015-12-22 00:00:00:0000', 'YYYY-MM-DD HH24:MI:SS:FF4'), '1', TO_TIMESTAMP(' 1015-12-22 00:00:00:0000', 'YYYY-MM-DD HH24:MI:SS:FF4'), null, '0', null, '0');
INSERT INTO "ORACLE"."SYS_OFFICE" VALUES ('6', '1', '0,1,', '研发部', '50', '2', '100005', '2', '1', null, null, null, null, null, null, '1', null, null, '1', TO_TIMESTAMP(' 1015-12-22 00:00:00:0000', 'YYYY-MM-DD HH24:MI:SS:FF4'), '1', TO_TIMESTAMP(' 1015-12-22 00:00:00:0000', 'YYYY-MM-DD HH24:MI:SS:FF4'), null, '0', null, '0');
INSERT INTO "ORACLE"."SYS_OFFICE" VALUES ('7', '1', '0,1,', '济南市分公司', '20', '3', '200000', '1', '2', null, null, null, null, null, null, '1', null, null, '1', TO_TIMESTAMP(' 1015-12-22 00:00:00:0000', 'YYYY-MM-DD HH24:MI:SS:FF4'), '1', TO_TIMESTAMP(' 1015-12-22 00:00:00:0000', 'YYYY-MM-DD HH24:MI:SS:FF4'), null, '0', null, '0');
INSERT INTO "ORACLE"."SYS_OFFICE" VALUES ('8', '7', '0,1,7,', '公司领导', '10', '3', '200001', '2', '2', null, null, null, null, null, null, '1', null, null, '1', TO_TIMESTAMP(' 1015-12-22 00:00:00:0000', 'YYYY-MM-DD HH24:MI:SS:FF4'), '1', TO_TIMESTAMP(' 1015-12-22 00:00:00:0000', 'YYYY-MM-DD HH24:MI:SS:FF4'), null, '0', null, '0');
INSERT INTO "ORACLE"."SYS_OFFICE" VALUES ('9', '7', '0,1,7,', '综合部', '20', '3', '200002', '2', '2', null, null, null, null, null, null, '1', null, null, '1', TO_TIMESTAMP(' 1015-12-22 00:00:00:0000', 'YYYY-MM-DD HH24:MI:SS:FF4'), '1', TO_TIMESTAMP(' 1015-12-22 00:00:00:0000', 'YYYY-MM-DD HH24:MI:SS:FF4'), null, '0', null, '0');
INSERT INTO "ORACLE"."SYS_OFFICE" VALUES ('10', '7', '0,1,7,', '市场部', '30', '3', '200003', '2', '2', null, null, null, null, null, null, '1', null, null, '1', TO_TIMESTAMP(' 1015-12-22 00:00:00:0000', 'YYYY-MM-DD HH24:MI:SS:FF4'), '1', TO_TIMESTAMP(' 1015-12-22 00:00:00:0000', 'YYYY-MM-DD HH24:MI:SS:FF4'), null, '0', '<p>asdfasdfasdf<br/></p>', '0');
INSERT INTO "ORACLE"."SYS_OFFICE" VALUES ('11', '2', null, 'test', null, null, null, '2', null, null, null, null, null, null, null, null, null, null, '1', TO_TIMESTAMP(' 2016-01-21 09:29:32:0000', 'YYYY-MM-DD HH24:MI:SS:FF4'), null, null, null, '0', null, '0');
INSERT INTO "ORACLE"."SYS_OFFICE" VALUES ('1', '0', '0,', '市级单位', '10', '2', '100000', '1', '1', null, null, null, null, null, null, '1', null, null, '1', TO_TIMESTAMP(' 1015-12-22 00:00:00:0000', 'YYYY-MM-DD HH24:MI:SS:FF4'), '1', TO_TIMESTAMP(' 1015-12-22 00:00:00:0000', 'YYYY-MM-DD HH24:MI:SS:FF4'), null, '0', null, '0');
INSERT INTO "ORACLE"."SYS_OFFICE" VALUES ('2', '1', '0,1,', '吴中区', '10', '2', '100001', '2', '1', null, null, null, null, null, null, '1', null, null, '1', TO_TIMESTAMP(' 1015-12-22 00:00:00:0000', 'YYYY-MM-DD HH24:MI:SS:FF4'), '1', TO_TIMESTAMP(' 1015-12-22 00:00:00:0000', 'YYYY-MM-DD HH24:MI:SS:FF4'), null, '0', '<p>sa杜上睛234646df丰不求上进<br/></p>', '1');

-- ----------------------------
-- Table structure for SYS_ROLE
-- ----------------------------
DROP TABLE "ORACLE"."SYS_ROLE";
CREATE TABLE "ORACLE"."SYS_ROLE" (
"ID" NUMBER(10) NOT NULL ,
"OFFICE_ID" NUMBER(10) NULL ,
"NAME" NVARCHAR2(255) NOT NULL ,
"ENNAME" NVARCHAR2(255) NULL ,
"ROLE_TYPE" NVARCHAR2(255) NULL ,
"DATA_SCOPE" NVARCHAR2(255) NULL ,
"IS_SYS" NVARCHAR2(255) NULL ,
"USEABLE" NVARCHAR2(255) NULL ,
"CREATE_BY" NUMBER(10) NOT NULL ,
"CREATE_DATE" TIMESTAMP(4)  NOT NULL ,
"UPDATE_BY" NUMBER(10) NOT NULL ,
"UPDATE_DATE" TIMESTAMP(4)  NOT NULL ,
"REMARKS" NVARCHAR2(255) NULL ,
"DEL_FLAG" NVARCHAR2(255) NOT NULL 
);

-- ----------------------------
-- Records of SYS_ROLE
-- ----------------------------
INSERT INTO "ORACLE"."SYS_ROLE" VALUES ('1', '1', '系统管理员', 'dept', 'assignment', '1', null, '1', '1', TO_TIMESTAMP(' 2015-12-22 21:17:00:0000', 'YYYY-MM-DD HH24:MI:SS:FF4'), '1', TO_TIMESTAMP(' 2015-12-22 21:17:00:0000', 'YYYY-MM-DD HH24:MI:SS:FF4'), null, '0');
INSERT INTO "ORACLE"."SYS_ROLE" VALUES ('4', '1', '部门管理员', 'b', 'assignment', '4', null, '1', '1', TO_TIMESTAMP(' 2015-12-22 21:17:00:0000', 'YYYY-MM-DD HH24:MI:SS:FF4'), '1', TO_TIMESTAMP(' 2015-12-22 21:17:00:0000', 'YYYY-MM-DD HH24:MI:SS:FF4'), null, '0');

-- ----------------------------
-- Table structure for SYS_ROLE_MENU
-- ----------------------------
DROP TABLE "ORACLE"."SYS_ROLE_MENU";
CREATE TABLE "ORACLE"."SYS_ROLE_MENU" (
"ROLE_ID" NUMBER(10) NOT NULL ,
"MENU_ID" NUMBER(10) NOT NULL 
);

-- ----------------------------
-- Records of SYS_ROLE_MENU
-- ----------------------------
INSERT INTO "ORACLE"."SYS_ROLE_MENU" VALUES ('1', '1');
INSERT INTO "ORACLE"."SYS_ROLE_MENU" VALUES ('1', '2');
INSERT INTO "ORACLE"."SYS_ROLE_MENU" VALUES ('1', '3');
INSERT INTO "ORACLE"."SYS_ROLE_MENU" VALUES ('1', '4');
INSERT INTO "ORACLE"."SYS_ROLE_MENU" VALUES ('1', '5');
INSERT INTO "ORACLE"."SYS_ROLE_MENU" VALUES ('1', '6');
INSERT INTO "ORACLE"."SYS_ROLE_MENU" VALUES ('1', '7');
INSERT INTO "ORACLE"."SYS_ROLE_MENU" VALUES ('1', '8');
INSERT INTO "ORACLE"."SYS_ROLE_MENU" VALUES ('1', '9');
INSERT INTO "ORACLE"."SYS_ROLE_MENU" VALUES ('1', '10');
INSERT INTO "ORACLE"."SYS_ROLE_MENU" VALUES ('1', '11');
INSERT INTO "ORACLE"."SYS_ROLE_MENU" VALUES ('1', '12');
INSERT INTO "ORACLE"."SYS_ROLE_MENU" VALUES ('1', '13');
INSERT INTO "ORACLE"."SYS_ROLE_MENU" VALUES ('1', '14');
INSERT INTO "ORACLE"."SYS_ROLE_MENU" VALUES ('1', '15');
INSERT INTO "ORACLE"."SYS_ROLE_MENU" VALUES ('1', '17');
INSERT INTO "ORACLE"."SYS_ROLE_MENU" VALUES ('1', '18');
INSERT INTO "ORACLE"."SYS_ROLE_MENU" VALUES ('1', '19');
INSERT INTO "ORACLE"."SYS_ROLE_MENU" VALUES ('1', '31');
INSERT INTO "ORACLE"."SYS_ROLE_MENU" VALUES ('1', '32');
INSERT INTO "ORACLE"."SYS_ROLE_MENU" VALUES ('4', '1');
INSERT INTO "ORACLE"."SYS_ROLE_MENU" VALUES ('4', '7');
INSERT INTO "ORACLE"."SYS_ROLE_MENU" VALUES ('4', '8');
INSERT INTO "ORACLE"."SYS_ROLE_MENU" VALUES ('4', '9');
INSERT INTO "ORACLE"."SYS_ROLE_MENU" VALUES ('4', '17');
INSERT INTO "ORACLE"."SYS_ROLE_MENU" VALUES ('4', '18');
INSERT INTO "ORACLE"."SYS_ROLE_MENU" VALUES ('4', '19');
INSERT INTO "ORACLE"."SYS_ROLE_MENU" VALUES ('4', '20');
INSERT INTO "ORACLE"."SYS_ROLE_MENU" VALUES ('4', '21');
INSERT INTO "ORACLE"."SYS_ROLE_MENU" VALUES ('4', '22');
INSERT INTO "ORACLE"."SYS_ROLE_MENU" VALUES ('4', '24');
INSERT INTO "ORACLE"."SYS_ROLE_MENU" VALUES ('4', '26');
INSERT INTO "ORACLE"."SYS_ROLE_MENU" VALUES ('4', '28');
INSERT INTO "ORACLE"."SYS_ROLE_MENU" VALUES ('4', '29');
INSERT INTO "ORACLE"."SYS_ROLE_MENU" VALUES ('4', '30');

-- ----------------------------
-- Table structure for SYS_ROLE_OFFICE
-- ----------------------------
DROP TABLE "ORACLE"."SYS_ROLE_OFFICE";
CREATE TABLE "ORACLE"."SYS_ROLE_OFFICE" (
"ROLE_ID" NUMBER(10) NOT NULL ,
"OFFICE_ID" NUMBER(10) NOT NULL 
);

-- ----------------------------
-- Records of SYS_ROLE_OFFICE
-- ----------------------------

-- ----------------------------
-- Table structure for SYS_USER
-- ----------------------------
DROP TABLE "ORACLE"."SYS_USER";
CREATE TABLE "ORACLE"."SYS_USER" (
"ID" NUMBER(9) NOT NULL ,
"COMPANY_ID" NUMBER(9) NOT NULL ,
"OFFICE_ID" NUMBER(9) NOT NULL ,
"LOGIN_NAME" NVARCHAR2(255) NOT NULL ,
"PASSWORD" NVARCHAR2(255) NOT NULL ,
"NO" NVARCHAR2(255) NULL ,
"NAME" NVARCHAR2(255) NOT NULL ,
"EMAIL" NVARCHAR2(255) NULL ,
"PHONE" NVARCHAR2(255) NULL ,
"MOBILE" NVARCHAR2(255) NULL ,
"USER_TYPE" NVARCHAR2(255) NULL ,
"PHOTO" NVARCHAR2(255) NULL ,
"LOGIN_IP" NVARCHAR2(255) NULL ,
"LOGIN_DATE" TIMESTAMP(4)  NULL ,
"LOGIN_FLAG" NVARCHAR2(255) NULL ,
"CREATE_BY" NUMBER(9) NOT NULL ,
"CREATE_DATE" TIMESTAMP(4)  NOT NULL ,
"UPDATE_BY" NUMBER(9) NOT NULL ,
"UPDATE_DATE" TIMESTAMP(4)  NOT NULL ,
"REMARKS" NVARCHAR2(255) NULL ,
"DEL_FLAG" NVARCHAR2(255) NOT NULL 
);

--表序列
create sequence catalog_seq
minvalue 1
maxvalue 999999999999999999999999999
start with 1
increment by 1
cache 20;

--sys_user表序列
create sequence sys_user_seq
minvalue 1
maxvalue 999999999999999999999999999
start with 1
increment by 1
cache 20;

-- ----------------------------
-- Records of SYS_USER
-- ----------------------------
INSERT INTO "ORACLE"."SYS_USER" VALUES ('1', '1', '2', 'admin', '02a3f0772fcca9f415adc990734b45c6f059c7d33ee28362c4852032', '0001', '系统管理员', '28528000@qq.com', '8675', '8675', null, null, '0:0:0:0:0:0:0:1', TO_TIMESTAMP(' 2016-01-25 17:59:13:9250', 'YYYY-MM-DD HH24:MI:SS:FF4'), '1', '1', TO_TIMESTAMP(' 2015-12-21 21:12:00:0000', 'YYYY-MM-DD HH24:MI:SS:FF4'), '1', TO_TIMESTAMP(' 2015-12-21 21:12:00:0000', 'YYYY-MM-DD HH24:MI:SS:FF4'), '最高管理员', '0');
INSERT INTO "ORACLE"."SYS_USER" VALUES ('2', '1', '2', 'sd_admin', '02a3f0772fcca9f415adc990734b45c6f059c7d33ee28362c4852032', '0002', '部门管理员', null, null, null, null, null, '0:0:0:0:0:0:0:1', TO_TIMESTAMP(' 2016-01-25 17:44:58:5790', 'YYYY-MM-DD HH24:MI:SS:FF4'), '1', '1', TO_TIMESTAMP(' 2015-12-21 21:12:00:0000', 'YYYY-MM-DD HH24:MI:SS:FF4'), '1', TO_TIMESTAMP(' 2015-12-21 21:12:00:0000', 'YYYY-MM-DD HH24:MI:SS:FF4'), null, '0');

-- ----------------------------
-- Table structure for SYS_USER_ROLE
-- ----------------------------
DROP TABLE "ORACLE"."SYS_USER_ROLE";
CREATE TABLE "ORACLE"."SYS_USER_ROLE" (
"USER_ID" NUMBER(10) NOT NULL ,
"ROLE_ID" NUMBER(10) NOT NULL 
);

-- ----------------------------
-- Records of SYS_USER_ROLE
-- ----------------------------
INSERT INTO "ORACLE"."SYS_USER_ROLE" VALUES ('1', '1');
INSERT INTO "ORACLE"."SYS_USER_ROLE" VALUES ('2', '4');

-- ----------------------------
-- Indexes structure for table BUSINESS
-- ----------------------------

-- ----------------------------
-- Triggers structure for table BUSINESS
-- ----------------------------
CREATE OR REPLACE TRIGGER "ORACLE"."BUSINESS_TRI" BEFORE INSERT ON "ORACLE"."BUSINESS" REFERENCING OLD AS "OLD" NEW AS "NEW" FOR EACH ROW ENABLE
BEGIN
   SELECT catalog_seq.NEXTVAL INTO :NEW.ID FROM DUAL;
END;
-- ----------------------------
-- Checks structure for table BUSINESS
-- ----------------------------
ALTER TABLE "ORACLE"."BUSINESS" ADD CHECK ("ID" IS NOT NULL);
ALTER TABLE "ORACLE"."BUSINESS" ADD CHECK ("NAME" IS NOT NULL);
ALTER TABLE "ORACLE"."BUSINESS" ADD CHECK ("DEL_FLAG" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table BUSINESS
-- ----------------------------
ALTER TABLE "ORACLE"."BUSINESS" ADD PRIMARY KEY ("ID");

-- ----------------------------
-- Indexes structure for table CATALOG_INFO
-- ----------------------------
CREATE OR REPLACE TRIGGER "ORACLE"."CATALOG_INFO_TRI" 
BEFORE 
	INSERT ON "ORACLE"."CATALOG_INFO" REFERENCING OLD AS "OLD" NEW AS "NEW" FOR EACH ROW ENABLE
BEGIN
   SELECT catalog_seq.NEXTVAL INTO :NEW.ID FROM DUAL;
END;
-- ----------------------------
-- Checks structure for table CATALOG_INFO
-- ----------------------------
ALTER TABLE "ORACLE"."CATALOG_INFO" ADD CHECK ("ID" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table CATALOG_INFO
-- ----------------------------
ALTER TABLE "ORACLE"."CATALOG_INFO" ADD PRIMARY KEY ("ID");

-- ----------------------------
-- Indexes structure for table JOB
-- ----------------------------

-- ----------------------------
-- Triggers structure for table JOB
-- ----------------------------
CREATE OR REPLACE TRIGGER "ORACLE"."JOB_TRI" BEFORE INSERT ON "ORACLE"."JOB" REFERENCING OLD AS "OLD" NEW AS "NEW" FOR EACH ROW ENABLE
BEGIN
   SELECT catalog_seq.NEXTVAL INTO :NEW.ID FROM DUAL;
END;
-- ----------------------------
-- Checks structure for table JOB
-- ----------------------------
ALTER TABLE "ORACLE"."JOB" ADD CHECK ("ID" IS NOT NULL);
ALTER TABLE "ORACLE"."JOB" ADD CHECK ("NAME" IS NOT NULL);
ALTER TABLE "ORACLE"."JOB" ADD CHECK ("DUTY" IS NOT NULL);
ALTER TABLE "ORACLE"."JOB" ADD CHECK ("CREATE_BY" IS NOT NULL);
ALTER TABLE "ORACLE"."JOB" ADD CHECK ("CREATE_DATE" IS NOT NULL);
ALTER TABLE "ORACLE"."JOB" ADD CHECK ("DEL_FLAG" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table JOB
-- ----------------------------
ALTER TABLE "ORACLE"."JOB" ADD PRIMARY KEY ("ID");

-- ----------------------------
-- Checks structure for table JOB_BUSINESS
-- ----------------------------
ALTER TABLE "ORACLE"."JOB_BUSINESS" ADD CHECK ("JOB_ID" IS NOT NULL);
ALTER TABLE "ORACLE"."JOB_BUSINESS" ADD CHECK ("BUSINESS_ID" IS NOT NULL);

-- ----------------------------
-- Indexes structure for table OFFICE_INFO
-- ----------------------------

-- ----------------------------
-- Checks structure for table OFFICE_INFO
-- ----------------------------
ALTER TABLE "ORACLE"."OFFICE_INFO" ADD CHECK ("ID" IS NOT NULL);
ALTER TABLE "ORACLE"."OFFICE_INFO" ADD CHECK ("NAME" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table OFFICE_INFO
-- ----------------------------
ALTER TABLE "ORACLE"."OFFICE_INFO" ADD PRIMARY KEY ("ID");

-- ----------------------------
-- Indexes structure for table REGISTER
-- ----------------------------

-- ----------------------------
-- Triggers structure for table REGISTER
-- ----------------------------
CREATE OR REPLACE TRIGGER "ORACLE"."REGISTER_TRI" BEFORE INSERT ON "ORACLE"."REGISTER" REFERENCING OLD AS "OLD" NEW AS "NEW" FOR EACH ROW ENABLE
BEGIN
   SELECT catalog_seq.NEXTVAL INTO :NEW.ID FROM DUAL;
END;
-- ----------------------------
-- Checks structure for table REGISTER
-- ----------------------------
ALTER TABLE "ORACLE"."REGISTER" ADD CHECK ("ID" IS NOT NULL);
ALTER TABLE "ORACLE"."REGISTER" ADD CHECK ("OFFICE_ID" IS NOT NULL);
ALTER TABLE "ORACLE"."REGISTER" ADD CHECK ("APPLY_TYPE" IS NOT NULL);
ALTER TABLE "ORACLE"."REGISTER" ADD CHECK ("APPLY_FLAG" IS NOT NULL);
ALTER TABLE "ORACLE"."REGISTER" ADD CHECK ("APPROVE_FLAG" IS NOT NULL);
ALTER TABLE "ORACLE"."REGISTER" ADD CHECK ("DEL_FLAG" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table REGISTER
-- ----------------------------
ALTER TABLE "ORACLE"."REGISTER" ADD PRIMARY KEY ("ID");

-- ----------------------------
-- Indexes structure for table RESOURCE_INFO
-- ----------------------------

-- ----------------------------
-- Checks structure for table RESOURCE_INFO
-- ----------------------------
ALTER TABLE "ORACLE"."RESOURCE_INFO" ADD CHECK ("ID" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table RESOURCE_INFO
-- ----------------------------
ALTER TABLE "ORACLE"."RESOURCE_INFO" ADD PRIMARY KEY ("ID");

-- ----------------------------
-- Indexes structure for table RPT_SEARCH
-- ----------------------------

-- ----------------------------
-- Triggers structure for table RPT_SEARCH
-- ----------------------------
CREATE OR REPLACE TRIGGER "ORACLE"." RPT_SEARCH_TRI" BEFORE INSERT ON "ORACLE"."RPT_SEARCH" REFERENCING OLD AS "OLD" NEW AS "NEW" FOR EACH ROW ENABLE
BEGIN
   SELECT catalog_seq.NEXTVAL INTO :NEW.ID FROM DUAL;
END;

-- ----------------------------
-- Checks structure for table RPT_SEARCH
-- ----------------------------
ALTER TABLE "ORACLE"."RPT_SEARCH" ADD CHECK ("ID" IS NOT NULL);
ALTER TABLE "ORACLE"."RPT_SEARCH" ADD CHECK ("KEYWORD" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table RPT_SEARCH
-- ----------------------------
ALTER TABLE "ORACLE"."RPT_SEARCH" ADD PRIMARY KEY ("ID");

-- ----------------------------
-- Indexes structure for table SUBJECT_INFO
-- ----------------------------

-- ----------------------------
-- Triggers structure for table SUBJECT_INFO
-- ----------------------------
CREATE OR REPLACE TRIGGER "ORACLE"."SUBJECT_INFO_TRI" BEFORE INSERT ON "ORACLE"."SUBJECT_INFO" REFERENCING OLD AS "OLD" NEW AS "NEW" FOR EACH ROW ENABLE
BEGIN
   SELECT catalog_seq.NEXTVAL INTO :NEW.ID FROM DUAL;
END;
-- ----------------------------
-- Checks structure for table SUBJECT_INFO
-- ----------------------------
ALTER TABLE "ORACLE"."SUBJECT_INFO" ADD CHECK ("ID" IS NOT NULL);
ALTER TABLE "ORACLE"."SUBJECT_INFO" ADD CHECK ("NAME" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table SUBJECT_INFO
-- ----------------------------
ALTER TABLE "ORACLE"."SUBJECT_INFO" ADD PRIMARY KEY ("ID");

-- ----------------------------
-- Indexes structure for table SYS_AREA
-- ----------------------------

-- ----------------------------
-- Checks structure for table SYS_AREA
-- ----------------------------
ALTER TABLE "ORACLE"."SYS_AREA" ADD CHECK ("ID" IS NOT NULL);
ALTER TABLE "ORACLE"."SYS_AREA" ADD CHECK ("PARENT_ID" IS NOT NULL);
ALTER TABLE "ORACLE"."SYS_AREA" ADD CHECK ("PARENT_IDS" IS NOT NULL);
ALTER TABLE "ORACLE"."SYS_AREA" ADD CHECK ("NAME" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table SYS_AREA
-- ----------------------------
ALTER TABLE "ORACLE"."SYS_AREA" ADD PRIMARY KEY ("ID");

-- ----------------------------
-- Indexes structure for table SYS_DICT
-- ----------------------------

-- ----------------------------
-- Triggers structure for table SYS_DICT
-- ----------------------------
CREATE OR REPLACE TRIGGER "ORACLE"."sys_dict_TRI" BEFORE INSERT ON "ORACLE"."SYS_DICT" REFERENCING OLD AS "OLD" NEW AS "NEW" FOR EACH ROW ENABLE
BEGIN
   SELECT catalog_seq.NEXTVAL INTO :NEW.ID FROM DUAL;
END;

-- ----------------------------
-- Checks structure for table SYS_DICT
-- ----------------------------
ALTER TABLE "ORACLE"."SYS_DICT" ADD CHECK ("ID" IS NOT NULL);
ALTER TABLE "ORACLE"."SYS_DICT" ADD CHECK ("VALUE" IS NOT NULL);
ALTER TABLE "ORACLE"."SYS_DICT" ADD CHECK ("LABEL" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table SYS_DICT
-- ----------------------------
ALTER TABLE "ORACLE"."SYS_DICT" ADD PRIMARY KEY ("ID");

-- ----------------------------
-- Indexes structure for table SYS_LOG
-- ----------------------------

-- ----------------------------
-- Triggers structure for table SYS_LOG
-- ----------------------------
CREATE OR REPLACE TRIGGER "ORACLE"." SYS_LOG_TRI" BEFORE INSERT ON "ORACLE"."SYS_LOG" REFERENCING OLD AS "OLD" NEW AS "NEW" FOR EACH ROW ENABLE
BEGIN
   SELECT catalog_seq.NEXTVAL INTO :NEW.ID FROM DUAL;
END;

-- ----------------------------
-- Triggers structure for table SYS_LOG
-- ----------------------------
CREATE OR REPLACE TRIGGER "ORACLE"."SYS_USER_TRI" BEFORE INSERT ON "ORACLE"."SYS_USER" REFERENCING OLD AS "OLD" NEW AS "NEW" FOR EACH ROW ENABLE
BEGIN
   SELECT sys_user_seq.NEXTVAL INTO :NEW.ID FROM DUAL;
END;


-- ----------------------------
-- Checks structure for table SYS_LOG
-- ----------------------------
ALTER TABLE "ORACLE"."SYS_LOG" ADD CHECK ("ID" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table SYS_LOG
-- ----------------------------
ALTER TABLE "ORACLE"."SYS_LOG" ADD PRIMARY KEY ("ID");

-- ----------------------------
-- Indexes structure for table SYS_MDICT
-- ----------------------------

-- ----------------------------
-- Checks structure for table SYS_MDICT
-- ----------------------------
ALTER TABLE "ORACLE"."SYS_MDICT" ADD CHECK ("ID" IS NOT NULL);
ALTER TABLE "ORACLE"."SYS_MDICT" ADD CHECK ("PARENT_ID" IS NOT NULL);
ALTER TABLE "ORACLE"."SYS_MDICT" ADD CHECK ("PARENT_IDS" IS NOT NULL);
ALTER TABLE "ORACLE"."SYS_MDICT" ADD CHECK ("NAME" IS NOT NULL);
ALTER TABLE "ORACLE"."SYS_MDICT" ADD CHECK ("SORT" IS NOT NULL);
ALTER TABLE "ORACLE"."SYS_MDICT" ADD CHECK ("CREATE_BY" IS NOT NULL);
ALTER TABLE "ORACLE"."SYS_MDICT" ADD CHECK ("CREATE_DATE" IS NOT NULL);
ALTER TABLE "ORACLE"."SYS_MDICT" ADD CHECK ("UPDATE_BY" IS NOT NULL);
ALTER TABLE "ORACLE"."SYS_MDICT" ADD CHECK ("UPDATE_DATE" IS NOT NULL);
ALTER TABLE "ORACLE"."SYS_MDICT" ADD CHECK ("DEL_FLAG" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table SYS_MDICT
-- ----------------------------
ALTER TABLE "ORACLE"."SYS_MDICT" ADD PRIMARY KEY ("ID");

-- ----------------------------
-- Indexes structure for table SYS_MENU
-- ----------------------------

-- ----------------------------
-- Checks structure for table SYS_MENU
-- ----------------------------
ALTER TABLE "ORACLE"."SYS_MENU" ADD CHECK ("ID" IS NOT NULL);
ALTER TABLE "ORACLE"."SYS_MENU" ADD CHECK ("PARENT_ID" IS NOT NULL);
ALTER TABLE "ORACLE"."SYS_MENU" ADD CHECK ("PARENT_IDS" IS NOT NULL);
ALTER TABLE "ORACLE"."SYS_MENU" ADD CHECK ("NAME" IS NOT NULL);
ALTER TABLE "ORACLE"."SYS_MENU" ADD CHECK ("SORT" IS NOT NULL);
ALTER TABLE "ORACLE"."SYS_MENU" ADD CHECK ("IS_SHOW" IS NOT NULL);
ALTER TABLE "ORACLE"."SYS_MENU" ADD CHECK ("CREATE_BY" IS NOT NULL);
ALTER TABLE "ORACLE"."SYS_MENU" ADD CHECK ("CREATE_DATE" IS NOT NULL);
ALTER TABLE "ORACLE"."SYS_MENU" ADD CHECK ("UPDATE_BY" IS NOT NULL);
ALTER TABLE "ORACLE"."SYS_MENU" ADD CHECK ("UPDATE_DATE" IS NOT NULL);
ALTER TABLE "ORACLE"."SYS_MENU" ADD CHECK ("DEL_FLAG" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table SYS_MENU
-- ----------------------------
ALTER TABLE "ORACLE"."SYS_MENU" ADD PRIMARY KEY ("ID");

-- ----------------------------
-- Indexes structure for table SYS_OFFICE
-- ----------------------------

-- ----------------------------
-- Checks structure for table SYS_OFFICE
-- ----------------------------
ALTER TABLE "ORACLE"."SYS_OFFICE" ADD CHECK ("ID" IS NOT NULL);
ALTER TABLE "ORACLE"."SYS_OFFICE" ADD CHECK ("PARENT_ID" IS NOT NULL);
ALTER TABLE "ORACLE"."SYS_OFFICE" ADD CHECK ("NAME" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table SYS_OFFICE
-- ----------------------------
ALTER TABLE "ORACLE"."SYS_OFFICE" ADD PRIMARY KEY ("ID");

-- ----------------------------
-- Indexes structure for table SYS_ROLE
-- ----------------------------

-- ----------------------------
-- Checks structure for table SYS_ROLE
-- ----------------------------
ALTER TABLE "ORACLE"."SYS_ROLE" ADD CHECK ("ID" IS NOT NULL);
ALTER TABLE "ORACLE"."SYS_ROLE" ADD CHECK ("NAME" IS NOT NULL);
ALTER TABLE "ORACLE"."SYS_ROLE" ADD CHECK ("CREATE_BY" IS NOT NULL);
ALTER TABLE "ORACLE"."SYS_ROLE" ADD CHECK ("CREATE_DATE" IS NOT NULL);
ALTER TABLE "ORACLE"."SYS_ROLE" ADD CHECK ("UPDATE_BY" IS NOT NULL);
ALTER TABLE "ORACLE"."SYS_ROLE" ADD CHECK ("UPDATE_DATE" IS NOT NULL);
ALTER TABLE "ORACLE"."SYS_ROLE" ADD CHECK ("DEL_FLAG" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table SYS_ROLE
-- ----------------------------
ALTER TABLE "ORACLE"."SYS_ROLE" ADD PRIMARY KEY ("ID");

-- ----------------------------
-- Checks structure for table SYS_ROLE_MENU
-- ----------------------------
ALTER TABLE "ORACLE"."SYS_ROLE_MENU" ADD CHECK ("ROLE_ID" IS NOT NULL);
ALTER TABLE "ORACLE"."SYS_ROLE_MENU" ADD CHECK ("MENU_ID" IS NOT NULL);

-- ----------------------------
-- Checks structure for table SYS_ROLE_OFFICE
-- ----------------------------
ALTER TABLE "ORACLE"."SYS_ROLE_OFFICE" ADD CHECK ("ROLE_ID" IS NOT NULL);
ALTER TABLE "ORACLE"."SYS_ROLE_OFFICE" ADD CHECK ("OFFICE_ID" IS NOT NULL);

-- ----------------------------
-- Indexes structure for table SYS_USER
-- ----------------------------

-- ----------------------------
-- Checks structure for table SYS_USER
-- ----------------------------
ALTER TABLE "ORACLE"."SYS_USER" ADD CHECK ("ID" IS NOT NULL);
ALTER TABLE "ORACLE"."SYS_USER" ADD CHECK ("COMPANY_ID" IS NOT NULL);
ALTER TABLE "ORACLE"."SYS_USER" ADD CHECK ("OFFICE_ID" IS NOT NULL);
ALTER TABLE "ORACLE"."SYS_USER" ADD CHECK ("LOGIN_NAME" IS NOT NULL);
ALTER TABLE "ORACLE"."SYS_USER" ADD CHECK ("PASSWORD" IS NOT NULL);
ALTER TABLE "ORACLE"."SYS_USER" ADD CHECK ("NAME" IS NOT NULL);
ALTER TABLE "ORACLE"."SYS_USER" ADD CHECK ("CREATE_BY" IS NOT NULL);
ALTER TABLE "ORACLE"."SYS_USER" ADD CHECK ("CREATE_DATE" IS NOT NULL);
ALTER TABLE "ORACLE"."SYS_USER" ADD CHECK ("UPDATE_BY" IS NOT NULL);
ALTER TABLE "ORACLE"."SYS_USER" ADD CHECK ("UPDATE_DATE" IS NOT NULL);
ALTER TABLE "ORACLE"."SYS_USER" ADD CHECK ("DEL_FLAG" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table SYS_USER
-- ----------------------------
ALTER TABLE "ORACLE"."SYS_USER" ADD PRIMARY KEY ("ID");

-- ----------------------------
-- Checks structure for table SYS_USER_ROLE
-- ----------------------------
ALTER TABLE "ORACLE"."SYS_USER_ROLE" ADD CHECK ("USER_ID" IS NOT NULL);
ALTER TABLE "ORACLE"."SYS_USER_ROLE" ADD CHECK ("ROLE_ID" IS NOT NULL);


--创建机构统计的视图
CREATE  OR  REPLACE  VIEW  office_stic_vw 
(id,demain,officeName,duty,status) 
AS 
select 
  d.id,e.demain,d.name as officeName ,d.duty,d.status
from 
  SYS_OFFICE d ,(select c.id, c.firstDomain || '/' || c.secondDomain as demain from (select 
        o.id,o.parent_id,o.name as secondDomain,s.name as firstDomain
    from 
      SYS_OFFICE o,(select t.name, t.id from SYS_OFFICE t where t.parent_id = 0 and t.del_flag=0) s
    where 
        o.parent_id = s.id
    ) c
  ) e
where e.id=d.parent_id
union
select h.id,h.demain,h.firstOffice||'/'||h.secondOffice as officeName,h.duty,h.status from (
 select f.id,f.name as secondOffice,f.parent_id,g.firstOffice,g.demain,f.duty,f.status from  SYS_OFFICE f,
  (select d.id,d.name as firstOffice,d.parent_id,e.demain from SYS_OFFICE d ,
  (select c.id, c.firstDomain || '/' || c.secondDomain as demain
  from (select o.id,o.parent_id,o.name as secondDomain,s.name as firstDomain
   from SYS_OFFICE o,(select t.name, t.id from SYS_OFFICE t where t.parent_id = 0 and t.del_flag=0) s
   where o.parent_id = s.id
  ) c
  ) e
  where e.id=d.parent_id)g
  where g.id=f.parent_id
 )h;
 
 --创建信息统计图表的集成视图
 CREATE  OR  REPLACE  VIEW  integration_stic_vw 
(stime,sCount,type) 
AS 

select t.stime,t.sCount,t.type from (
SELECT 
    to_char(o.create_date,'yyyy-mm') AS stime,count(o.id) as sCount ,'1' as type
FROM 
  sys_office  o
GROUP BY 
  to_char(o.create_date,'yyyy-mm') 
union
SELECT 
    to_char(j.create_date,'yyyy-mm') AS stime,count(j.id) as sCount ,'2' as type
FROM 
  job  j
GROUP BY 
  to_char(j.create_date,'yyyy-mm')   
union
SELECT 
    to_char(b.create_date,'yyyy-mm') AS stime,count(b.id) as sCount ,'3' as type
FROM 
  business  b
GROUP BY 
  to_char(b.create_date,'yyyy-mm') 
union
SELECT 
    to_char(r.create_date,'yyyy-mm') AS stime,count(r.id) as sCount ,'4' as type
FROM 
  resource_info  r
GROUP BY 
  to_char(r.create_date,'yyyy-mm') 
union
SELECT 
    to_char(s.create_date,'yyyy-mm') AS stime,count(s.id) as sCount ,'5' as type
FROM 
  subject_info  s
GROUP BY 
  to_char(s.create_date,'yyyy-mm') 
) t order by t.type,stime