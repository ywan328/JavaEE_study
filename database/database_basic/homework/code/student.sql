/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50731
 Source Host           : localhost:3306
 Source Schema         : e

 Target Server Type    : MySQL
 Target Server Version : 50731
 File Encoding         : 65001

 Date: 12/03/2021 18:06:03
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for grade
-- ----------------------------
DROP TABLE IF EXISTS `grade`;
CREATE TABLE `grade` (
  `gradeid` int(11) NOT NULL,
  `gname` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`gradeid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of grade
-- ----------------------------
BEGIN;
INSERT INTO `grade` VALUES (1, '第一阶段');
INSERT INTO `grade` VALUES (2, '第二阶段');
INSERT INTO `grade` VALUES (3, '第三阶段');
INSERT INTO `grade` VALUES (4, '就业期');
COMMIT;

-- ----------------------------
-- Table structure for score
-- ----------------------------
DROP TABLE IF EXISTS `score`;
CREATE TABLE `score` (
  `scoreid` int(11) NOT NULL,
  `stuno` varchar(20) DEFAULT NULL,
  `subjectid` int(11) DEFAULT NULL,
  `score` int(11) DEFAULT NULL,
  `examtime` date DEFAULT NULL,
  PRIMARY KEY (`scoreid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of score
-- ----------------------------
BEGIN;
INSERT INTO `score` VALUES (1, '1', 1, 100, '2021-03-12');
INSERT INTO `score` VALUES (2, '1', 2, 100, '2021-03-12');
INSERT INTO `score` VALUES (3, '1', 3, 90, '2021-03-12');
INSERT INTO `score` VALUES (4, '2', 1, 100, '2021-03-12');
INSERT INTO `score` VALUES (5, '2', 2, 79, '2021-03-18');
INSERT INTO `score` VALUES (6, '3', 1, 56, '2021-03-01');
INSERT INTO `score` VALUES (7, '4', 2, 55, '2021-03-15');
INSERT INTO `score` VALUES (8, '4', 3, 100, '2021-03-21');
INSERT INTO `score` VALUES (9, '4', 1, 99, '2021-03-04');
INSERT INTO `score` VALUES (10, '5', 1, 100, '2021-03-21');
COMMIT;

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `stuid` varchar(11) NOT NULL,
  `stuname` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `sex` varchar(20) DEFAULT NULL,
  `gid` int(11) DEFAULT NULL,
  `telphone` varchar(20) DEFAULT NULL,
  `address` varchar(20) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `email` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`stuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of student
-- ----------------------------
BEGIN;
INSERT INTO `student` VALUES ('1', '张三', 'sdaf45', '男', 2, '131333333', '山东', '1989-03-12', '423412345@qq.com');
INSERT INTO `student` VALUES ('2', '李四', 'fdg7fd3', '女', 1, '131333333', '廊坊', '1999-03-18', '456346@qq.com');
INSERT INTO `student` VALUES ('3', '王五', 'rt7er8', '男', 4, '131333333', '山西', '1995-06-16', '8474154@qq.com');
INSERT INTO `student` VALUES ('4', '赵四', 'cvbc41', '女', 3, '131333333', '内蒙古', '1997-08-22', '789456@qq.com');
INSERT INTO `student` VALUES ('5', '王六', 'ewr789wx', '男', 3, '131333333', '台湾', '2000-12-16', '97456@qq.com');
INSERT INTO `student` VALUES ('6', '钱七', 'jty465tr', '女', 1, '131333333', '深圳', '1880-03-09', '78971@qq.com');
INSERT INTO `student` VALUES ('7', '金蝶', 'y4tr84', '女', 2, '123131313', '北京', '1898-01-12', '484564@qq.com');
INSERT INTO `student` VALUES ('8', '凌凌七', 'd4fs56', '男', 1, '123131313', '山东', '1997-12-19', '4564@qq.com');
INSERT INTO `student` VALUES ('9', '凌厉', '4fd5s6', '男', 1, '123131313', '深圳', '1990-01-01', '7786@qq.com');
COMMIT;

-- ----------------------------
-- Table structure for subject
-- ----------------------------
DROP TABLE IF EXISTS `subject`;
CREATE TABLE `subject` (
  `subjectid` int(11) NOT NULL,
  `subjectname` varchar(20) DEFAULT NULL,
  `studycount` int(11) DEFAULT NULL,
  `gradeid` int(11) DEFAULT NULL,
  PRIMARY KEY (`subjectid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of subject
-- ----------------------------
BEGIN;
INSERT INTO `subject` VALUES (1, '基于.NET 平台的软件系统分层开发', 80, 1);
INSERT INTO `subject` VALUES (2, '设计 MySchool 数据库', 30, 1);
INSERT INTO `subject` VALUES (3, '面向对象程序设计', 20, 1);
INSERT INTO `subject` VALUES (4, '基于.NET 平台的软件系统分层开发', 50, 2);
INSERT INTO `subject` VALUES (5, '设计 MySchool 数据库', 70, 2);
INSERT INTO `subject` VALUES (6, '面向对象程序设计', 64, 2);
INSERT INTO `subject` VALUES (7, '基于.NET 平台的软件系统分层开发', 55, 3);
INSERT INTO `subject` VALUES (8, '设计 MySchool 数据库', 35, 3);
INSERT INTO `subject` VALUES (9, '面向对象程序设计', 75, 3);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
