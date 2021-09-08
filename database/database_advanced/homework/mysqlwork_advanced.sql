/*
 Navicat Premium Data Transfer

 Source Server         : 47.98.158.124
 Source Server Type    : MySQL
 Source Server Version : 50732
 Source Host           : 47.98.158.124:3306
 Source Schema         : mysqlwork_advanced

 Target Server Type    : MySQL
 Target Server Version : 50732
 File Encoding         : 65001

 Date: 12/05/2021 10:40:29
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for department
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department` (
  `depid` varchar(4) DEFAULT NULL,
  `depname` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of department
-- ----------------------------
BEGIN;
INSERT INTO `department` VALUES ('111', '生产部');
INSERT INTO `department` VALUES ('222', '销售部');
INSERT INTO `department` VALUES ('333', '人事部');
COMMIT;

-- ----------------------------
-- Table structure for emoloyee
-- ----------------------------
DROP TABLE IF EXISTS `emoloyee`;
CREATE TABLE `emoloyee` (
  `empid` varchar(5) DEFAULT NULL,
  `name` varchar(10) DEFAULT NULL,
  `sex` char(3) DEFAULT NULL,
  `title` varchar(20) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `depid` varchar(4) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of emoloyee
-- ----------------------------
BEGIN;
INSERT INTO `emoloyee` VALUES ('1001', '张三', '男', '高级工程师', '1975-01-01', '111');
INSERT INTO `emoloyee` VALUES ('1002', '李四', '女', '助工', '1985-01-01', '111');
INSERT INTO `emoloyee` VALUES ('1003', '王五', '男', '工程师', '1978-11-11', '222');
INSERT INTO `emoloyee` VALUES ('1004', '赵六', '男', '工程师', '1979-01-01', '222');
COMMIT;

-- ----------------------------
-- Table structure for salary
-- ----------------------------
DROP TABLE IF EXISTS `salary`;
CREATE TABLE `salary` (
  `empid` varchar(5) DEFAULT NULL,
  `basesalary` int(11) DEFAULT NULL,
  `titlesalary` int(11) DEFAULT NULL,
  `deduction` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of salary
-- ----------------------------
BEGIN;
INSERT INTO `salary` VALUES ('1001', 2200, 1100, 200);
INSERT INTO `salary` VALUES ('1002', 1200, 200, 100);
INSERT INTO `salary` VALUES ('1003', 1900, 700, 200);
INSERT INTO `salary` VALUES ('1004', 1950, 700, 150);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
