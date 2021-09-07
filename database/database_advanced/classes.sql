/*
Navicat MySQL Data Transfer

Source Server         : mysql8
Source Server Version : 80022
Source Host           : localhost:3306
Source Database       : yhp2

Target Server Type    : MYSQL
Target Server Version : 80022
File Encoding         : 65001

Date: 2020-11-03 10:33:30
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `classes`
-- ----------------------------
DROP TABLE IF EXISTS `classes`;
CREATE TABLE `classes` (
  `classid` int NOT NULL AUTO_INCREMENT,
  `classname` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`classid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of classes
-- ----------------------------
INSERT INTO `classes` VALUES ('1', '语文');
INSERT INTO `classes` VALUES ('2', '数学');
INSERT INTO `classes` VALUES ('3', '英语');
INSERT INTO `classes` VALUES ('4', '化学');

-- ----------------------------
-- Table structure for `dept`
-- ----------------------------
DROP TABLE IF EXISTS `dept`;
CREATE TABLE `dept` (
  `deptno` int NOT NULL AUTO_INCREMENT,
  `dname` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`deptno`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of dept
-- ----------------------------
INSERT INTO `dept` VALUES ('1', '销售部');
INSERT INTO `dept` VALUES ('2', '运营部');

-- ----------------------------
-- Table structure for `dept1`
-- ----------------------------
DROP TABLE IF EXISTS `dept1`;
CREATE TABLE `dept1` (
  `deptno` int NOT NULL,
  `dname` varchar(14) COLLATE utf8_bin DEFAULT NULL,
  `loc` varchar(13) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`deptno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of dept1
-- ----------------------------
INSERT INTO `dept1` VALUES ('10', '服务中心部', '北京');
INSERT INTO `dept1` VALUES ('20', '研发部', '北京');
INSERT INTO `dept1` VALUES ('40', '主管部', '北京');
INSERT INTO `dept1` VALUES ('50', 'AA', '杭州');
INSERT INTO `dept1` VALUES ('60', 'bb', '北京');
INSERT INTO `dept1` VALUES ('70', 'bb1', '北京4');
INSERT INTO `dept1` VALUES ('80', 'bb2', '北京3');

-- ----------------------------
-- Table structure for `emp`
-- ----------------------------
DROP TABLE IF EXISTS `emp`;
CREATE TABLE `emp` (
  `empno` int NOT NULL AUTO_INCREMENT,
  `ename` varchar(10) COLLATE utf8_bin DEFAULT NULL,
  `deptid` int DEFAULT NULL,
  PRIMARY KEY (`empno`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of emp
-- ----------------------------
INSERT INTO `emp` VALUES ('1', '张三', '1');
INSERT INTO `emp` VALUES ('2', 'ISI', '2');
INSERT INTO `emp` VALUES ('3', '王五', '1');
INSERT INTO `emp` VALUES ('4', '赵六', '2');

-- ----------------------------
-- Table structure for `emp1`
-- ----------------------------
DROP TABLE IF EXISTS `emp1`;
CREATE TABLE `emp1` (
  `empno` int DEFAULT NULL,
  `ename` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `job` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `mgr` int DEFAULT NULL,
  `hiredate` date DEFAULT NULL,
  `sal` double DEFAULT NULL,
  `comm` double DEFAULT NULL,
  `deptno` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of emp1
-- ----------------------------
INSERT INTO `emp1` VALUES ('1001', '张三', '服务员', '1006', '2019-01-01', '1000', '2010', '10');
INSERT INTO `emp1` VALUES ('1002', '李四', '程序员', '1006', '2019-02-01', '1100', '2000', '20');
INSERT INTO `emp1` VALUES ('1003', '王五', '程序员', '1006', '2019-03-01', '1020', '2011', '20');
INSERT INTO `emp1` VALUES ('1006', '谢娜', '主管', '1006', '2019-06-01', '1011', '2004', '40');

-- ----------------------------
-- Table structure for `grade`
-- ----------------------------
DROP TABLE IF EXISTS `grade`;
CREATE TABLE `grade` (
  `gradeid` int NOT NULL AUTO_INCREMENT,
  `gradename` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`gradeid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of grade
-- ----------------------------

-- ----------------------------
-- Table structure for `grade2`
-- ----------------------------
DROP TABLE IF EXISTS `grade2`;
CREATE TABLE `grade2` (
  `gid` int NOT NULL AUTO_INCREMENT,
  `gname` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`gid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of grade2
-- ----------------------------
INSERT INTO `grade2` VALUES ('1', '一年级');
INSERT INTO `grade2` VALUES ('2', '二年级');
INSERT INTO `grade2` VALUES ('3', '三年级');

-- ----------------------------
-- Table structure for `husband`
-- ----------------------------
DROP TABLE IF EXISTS `husband`;
CREATE TABLE `husband` (
  `husid` int NOT NULL AUTO_INCREMENT,
  `husname` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`husid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of husband
-- ----------------------------
INSERT INTO `husband` VALUES ('1', '邓超');
INSERT INTO `husband` VALUES ('2', 'bb');

-- ----------------------------
-- Table structure for `middle`
-- ----------------------------
DROP TABLE IF EXISTS `middle`;
CREATE TABLE `middle` (
  `mid` int NOT NULL AUTO_INCREMENT,
  `stuid` int DEFAULT NULL,
  `classid` int DEFAULT NULL,
  PRIMARY KEY (`mid`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of middle
-- ----------------------------
INSERT INTO `middle` VALUES ('1', '1', '1');
INSERT INTO `middle` VALUES ('2', '1', '2');
INSERT INTO `middle` VALUES ('3', '1', '3');
INSERT INTO `middle` VALUES ('4', '2', '1');
INSERT INTO `middle` VALUES ('5', '2', '2');
INSERT INTO `middle` VALUES ('6', '2', '3');
INSERT INTO `middle` VALUES ('7', '2', '4');
INSERT INTO `middle` VALUES ('8', '3', '4');

-- ----------------------------
-- Table structure for `scores`
-- ----------------------------
DROP TABLE IF EXISTS `scores`;
CREATE TABLE `scores` (
  `sid` int DEFAULT NULL,
  `stuid` int DEFAULT NULL,
  `subject` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `score` double DEFAULT NULL,
  KEY `abc` (`stuid`),
  CONSTRAINT `abc` FOREIGN KEY (`stuid`) REFERENCES `student` (`stuno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of scores
-- ----------------------------
INSERT INTO `scores` VALUES ('1', '1', 'java', '11');
INSERT INTO `scores` VALUES ('2', '3', 'c', '22');
INSERT INTO `scores` VALUES ('3', '2', 'html', '33');
INSERT INTO `scores` VALUES ('4', '1', 'c++', '44');

-- ----------------------------
-- Table structure for `student`
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `stuname` varchar(5) COLLATE utf8_bin DEFAULT NULL,
  `sex` char(1) COLLATE utf8_bin DEFAULT NULL,
  `age` int DEFAULT NULL,
  `stuno` int NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`stuno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('张三', '女', '19', '1');
INSERT INTO `student` VALUES ('lisi', '男', '11', '2');
INSERT INTO `student` VALUES ('王五', '女', '22', '3');
INSERT INTO `student` VALUES ('刘能', '女', '33', '4');

-- ----------------------------
-- Table structure for `student1`
-- ----------------------------
DROP TABLE IF EXISTS `student1`;
CREATE TABLE `student1` (
  `Id` int NOT NULL,
  `Name` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `Name` (`Name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of student1
-- ----------------------------
INSERT INTO `student1` VALUES ('4', null);
INSERT INTO `student1` VALUES ('1', 'aa');
INSERT INTO `student1` VALUES ('2', 'bb');
INSERT INTO `student1` VALUES ('3', 'cc');

-- ----------------------------
-- Table structure for `student2`
-- ----------------------------
DROP TABLE IF EXISTS `student2`;
CREATE TABLE `student2` (
  `Id` int NOT NULL AUTO_INCREMENT,
  `Name` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of student2
-- ----------------------------
INSERT INTO `student2` VALUES ('1', 'abc');
INSERT INTO `student2` VALUES ('2', 'abc1');

-- ----------------------------
-- Table structure for `student3`
-- ----------------------------
DROP TABLE IF EXISTS `student3`;
CREATE TABLE `student3` (
  `Id` int NOT NULL AUTO_INCREMENT,
  `Name` varchar(50) COLLATE utf8_bin NOT NULL,
  `Sex` varchar(10) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of student3
-- ----------------------------
INSERT INTO `student3` VALUES ('1', 'aa', '男');

-- ----------------------------
-- Table structure for `student4`
-- ----------------------------
DROP TABLE IF EXISTS `student4`;
CREATE TABLE `student4` (
  `Id` int NOT NULL,
  `Name` varchar(50) COLLATE utf8_bin NOT NULL,
  `Sex` varchar(10) COLLATE utf8_bin DEFAULT '男',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of student4
-- ----------------------------
INSERT INTO `student4` VALUES ('1', 'aa', '男');
INSERT INTO `student4` VALUES ('2', 'aa', '女');

-- ----------------------------
-- Table structure for `users`
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `userid` int NOT NULL,
  `uname` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('1', 'qq');
INSERT INTO `users` VALUES ('2', 'qq');
INSERT INTO `users` VALUES ('3', 'qq');

-- ----------------------------
-- Table structure for `users2`
-- ----------------------------
DROP TABLE IF EXISTS `users2`;
CREATE TABLE `users2` (
  `userid` int NOT NULL AUTO_INCREMENT,
  `username` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `age` int DEFAULT '18',
  `gradeid` int DEFAULT NULL,
  PRIMARY KEY (`userid`),
  UNIQUE KEY `abc_unique` (`username`),
  KEY `fk_gradeid` (`gradeid`),
  CONSTRAINT `fk_gradeid` FOREIGN KEY (`gradeid`) REFERENCES `grade2` (`gid`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of users2
-- ----------------------------
INSERT INTO `users2` VALUES ('1', 'aa', '18', '3');
INSERT INTO `users2` VALUES ('2', 'bb', '18', '2');
INSERT INTO `users2` VALUES ('3', 'cc', '18', '2');
INSERT INTO `users2` VALUES ('4', 'dd', '18', '2');

-- ----------------------------
-- Table structure for `wife`
-- ----------------------------
DROP TABLE IF EXISTS `wife`;
CREATE TABLE `wife` (
  `wifeid` int NOT NULL AUTO_INCREMENT,
  `wifename` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`wifeid`),
  CONSTRAINT `fk_wifeid` FOREIGN KEY (`wifeid`) REFERENCES `husband` (`husid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of wife
-- ----------------------------
INSERT INTO `wife` VALUES ('1', '孙俪');
INSERT INTO `wife` VALUES ('2', 'ff');
