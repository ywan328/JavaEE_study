/*
 Navicat Premium Data Transfer

 Source Server         : 47.98.158.124
 Source Server Type    : MySQL
 Source Server Version : 50732
 Source Host           : 47.98.158.124:3306
 Source Schema         : mysqlwork_primary

 Target Server Type    : MySQL
 Target Server Version : 50732
 File Encoding         : 65001

 Date: 12/05/2021 10:15:25
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for grade
-- ----------------------------
DROP TABLE IF EXISTS `grade`;
CREATE TABLE `grade` (
  `gradeid` int(11) NOT NULL AUTO_INCREMENT,
  `gradename` varchar(20) NOT NULL,
  PRIMARY KEY (`gradeid`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of grade
-- ----------------------------
BEGIN;
INSERT INTO `grade` VALUES (1, '第一阶段');
INSERT INTO `grade` VALUES (2, '第二阶段');
INSERT INTO `grade` VALUES (3, '第三阶段');
COMMIT;

-- ----------------------------
-- Table structure for score
-- ----------------------------
DROP TABLE IF EXISTS `score`;
CREATE TABLE `score` (
  `id` int(11) NOT NULL,
  `studentno` varchar(10) NOT NULL,
  `subjectid` int(11) NOT NULL,
  `score` int(11) NOT NULL,
  `examdate` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of score
-- ----------------------------
BEGIN;
INSERT INTO `score` VALUES (1, 'S2102001', 3, 76, '2009-12-13 00:00:00');
INSERT INTO `score` VALUES (2, 'S2102002', 3, 90, '2009-12-14 00:00:00');
INSERT INTO `score` VALUES (3, 'S2102003', 3, 100, '2009-12-15 00:00:00');
INSERT INTO `score` VALUES (4, 'S2102004', 3, 79, '2009-12-16 00:00:00');
INSERT INTO `score` VALUES (5, 'S2102005', 3, 80, '2009-12-17 00:00:00');
INSERT INTO `score` VALUES (6, 'S2102006', 3, 61, '2009-12-18 00:00:00');
INSERT INTO `score` VALUES (7, 'S2102007', 3, 82, '2009-12-19 00:00:00');
INSERT INTO `score` VALUES (8, 'S2102008', 3, 35, '2009-12-20 00:00:00');
INSERT INTO `score` VALUES (9, 'S2102009', 3, 64, '2009-12-21 00:00:00');
INSERT INTO `score` VALUES (10, 'S2102010', 3, 65, '2009-12-22 00:00:00');
COMMIT;

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `studentno` varchar(10) NOT NULL,
  `loginpwd` int(11) NOT NULL,
  `studentname` varchar(40) NOT NULL,
  `sex` varchar(2) NOT NULL,
  `gradeid` int(11) NOT NULL,
  `phone` varchar(20) NOT NULL DEFAULT '0',
  `address` varchar(30) NOT NULL,
  `borndate` datetime DEFAULT NULL,
  `email` varchar(28) NOT NULL,
  PRIMARY KEY (`studentno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of student
-- ----------------------------
BEGIN;
INSERT INTO `student` VALUES ('S1101001', 228996245, '金蝶', '男', 1, '717215147', '天津市河西区', '1989-11-09 00:00:00', 'okiwcydml@ryhlo.com');
INSERT INTO `student` VALUES ('S1101002', 228996246, '洛飞', '女', 1, '666762663', '天津市南开区', '1990-02-07 00:00:00', 'jnqlpkdwb@nsjpt.com');
INSERT INTO `student` VALUES ('S1101003', 228996247, '凌辉', '女', 1, '353149818', '北京市海淀区成府路', '1993-04-04 00:00:00', 'eepispykh@oitbl.com');
INSERT INTO `student` VALUES ('S1101004', 228996251, '白燕', '男', 1, '676151367', '', '1990-09-01 00:00:00', 'cxmnnrhfn@sjsam.com');
INSERT INTO `student` VALUES ('S1101005', 228996252, '夏一桐', '男', 1, '397739963', '北京市朝阳区大屯', '1989-09-12 00:00:00', 'npgiygxox@ootml.com');
INSERT INTO `student` VALUES ('S1101006', 228996253, '欧阳燕飞', '男', 1, '13512345678', '河南省南阳市', '1987-06-19 00:00:00', 'dkwkiqbrj@yrkro.com');
INSERT INTO `student` VALUES ('S1101007', 228996254, '孟祥亚', '男', 1, '13512345679', '河南省洛阳市涧西区', '1993-02-22 00:00:00', 'gekdinmky@ijisq.com');
COMMIT;

-- ----------------------------
-- Table structure for subject
-- ----------------------------
DROP TABLE IF EXISTS `subject`;
CREATE TABLE `subject` (
  `subjectid` int(11) NOT NULL AUTO_INCREMENT,
  `subjectname` varchar(50) NOT NULL DEFAULT '',
  `hour` int(11) NOT NULL DEFAULT '0',
  `gradeid` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`subjectid`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of subject
-- ----------------------------
BEGIN;
INSERT INTO `subject` VALUES (1, '使用C#语言开发数据库应用系统', 36, 1);
INSERT INTO `subject` VALUES (2, '深入.NET平台和C#编程', 76, 2);
INSERT INTO `subject` VALUES (3, '设计MySchool数据库', 42, 2);
INSERT INTO `subject` VALUES (4, '基于.NET平台的软件系统分层开发', 44, 2);
INSERT INTO `subject` VALUES (5, '面向对象程序设计', 59, 2);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
