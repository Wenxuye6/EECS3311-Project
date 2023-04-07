/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80023
 Source Host           : localhost:3306
 Source Schema         : gym

 Target Server Type    : MySQL
 Target Server Version : 80023
 File Encoding         : 65001

 Date: 06/04/2023 20:06:28
*/
CREATE DATABASE `gym`;
use gym;
SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_admin
-- ----------------------------
DROP TABLE IF EXISTS `t_admin`;
CREATE TABLE `t_admin`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_admin
-- ----------------------------
INSERT INTO `t_admin` VALUES (1, 'admin', '123456');

-- ----------------------------
-- Table structure for t_course
-- ----------------------------
DROP TABLE IF EXISTS `t_course`;
CREATE TABLE `t_course`  (
  `courseId` int(0) NOT NULL AUTO_INCREMENT,
  `courseName` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `price` double(10, 2) NULL DEFAULT NULL,
  `benefit` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`courseId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_course
-- ----------------------------
INSERT INTO `t_course` VALUES (1, 'gym', 22.00, 'happy');
INSERT INTO `t_course` VALUES (2, 'strength', 999.00, 'boost your power');
INSERT INTO `t_course` VALUES (3, 'size', 888.00, 'bigger and bigger');
INSERT INTO `t_course` VALUES (4, 'endurance', 777.00, 'last longer');

-- ----------------------------
-- Table structure for t_equipment
-- ----------------------------
DROP TABLE IF EXISTS `t_equipment`;
CREATE TABLE `t_equipment`  (
  `equipmentId` int(0) NOT NULL AUTO_INCREMENT,
  `equipmentName` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `currentNum` int(0) NULL DEFAULT NULL,
  `damagedNum` int(0) NULL DEFAULT NULL,
  `marketPrice` double(10, 2) NULL DEFAULT NULL,
  `value` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`equipmentId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_equipment
-- ----------------------------
INSERT INTO `t_equipment` VALUES (1, 'Treadmill', 10, 3, 1200.00, 'A treadmill is a device generally for walking or running or climbing while staying in the same place.');
INSERT INTO `t_equipment` VALUES (2, 'Dumbbell', 50, 6, 33.00, 'The dumbbell is a piece of equipment used in weight training. It can be used individually or in pairs, with one in each hand.');

-- ----------------------------
-- Table structure for t_member
-- ----------------------------
DROP TABLE IF EXISTS `t_member`;
CREATE TABLE `t_member`  (
  `memberId` int(0) NOT NULL AUTO_INCREMENT,
  `account` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `realName` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `gender` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `height` double(10, 2) NULL DEFAULT NULL,
  `weight` double(10, 2) NULL DEFAULT NULL,
  `BMI` double(10, 2) NULL DEFAULT NULL,
  `Fund` double(10, 2) NULL DEFAULT NULL,
  `identity` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`memberId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_member
-- ----------------------------
INSERT INTO `t_member` VALUES (1, 'steve', '123', 'steve rogers', 'male', 1.80, 60.00, 18.52, 2000.00, 'coach');
INSERT INTO `t_member` VALUES (2, 'thor', '123', 'strongest avenger', 'male', 1.80, 60.00, 18.52, 3000.00, 'coach');
INSERT INTO `t_member` VALUES (3, 'tony', '123', 'tony stank', 'male', 1.80, 60.00, 18.52, 4000.00, 'coach');
INSERT INTO `t_member` VALUES (4, 'member', '123', 'test member', 'male', 1.80, 60.00, 18.52, 5000.00, 'membership');
INSERT INTO `t_member` VALUES (5, 'smith', '123', 'smith', 'female', 1.60, 45.00, 17.58, 3400.00, 'membership');
INSERT INTO `t_member` VALUES (6, 'test1', '123', 'test1', 'male', 1.80, 60.00, 18.52, 5000.00, 'janitorial');
INSERT INTO `t_member` VALUES (7, 'test2', '123', 'test2', 'male', 1.80, 50.00, 15.43, 5000.00, 'front desk');

-- ----------------------------
-- Table structure for t_schedule
-- ----------------------------
DROP TABLE IF EXISTS `t_schedule`;
CREATE TABLE `t_schedule`  (
  `scheduleId` int(0) NOT NULL AUTO_INCREMENT,
  `memberName` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `courseName` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `coachName` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`scheduleId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_schedule
-- ----------------------------
INSERT INTO `t_schedule` VALUES (1, 'smith', 'gym', 'thor');
INSERT INTO `t_schedule` VALUES (2, 'member', 'endurance', 'tony');
INSERT INTO `t_schedule` VALUES (3, 'member', 'strength', 'steve');

-- ----------------------------
-- Table structure for t_work
-- ----------------------------
DROP TABLE IF EXISTS `t_work`;
CREATE TABLE `t_work`  (
  `workId` int(0) NOT NULL AUTO_INCREMENT,
  `memberName` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `work` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `identity` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`workId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_work
-- ----------------------------
INSERT INTO `t_work` VALUES (1, 'thor', 'gym', 'coach');
INSERT INTO `t_work` VALUES (2, 'tony', 'endurance', 'coach');
INSERT INTO `t_work` VALUES (3, 'steve', 'strength', 'coach');
INSERT INTO `t_work` VALUES (4, 'test1', 'work1', 'janitorial');
INSERT INTO `t_work` VALUES (5, 'test2', 'work2', 'front desk');

SET FOREIGN_KEY_CHECKS = 1;
