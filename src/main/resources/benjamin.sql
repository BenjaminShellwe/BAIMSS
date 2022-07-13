/*
 Navicat Premium Data Transfer

 Source Server         : TPT
 Source Server Type    : MySQL
 Source Server Version : 80028
 Source Host           : shellwe.top:3306
 Source Schema         : benjamin

 Target Server Type    : MySQL
 Target Server Version : 80028
 File Encoding         : 65001

 Date: 13/07/2022 23:00:41
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for entity_account
-- ----------------------------
DROP TABLE IF EXISTS `entity_account`;
CREATE TABLE `entity_account`  (
  `id` int NOT NULL,
  `owner` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `ownerid` int NULL DEFAULT NULL,
  `rmb` int NULL DEFAULT NULL,
  `hkd` int NULL DEFAULT NULL,
  `gbp` int NULL DEFAULT NULL,
  `chf` int NULL DEFAULT NULL,
  `usd` int NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `balance`(`owner` ASC, `ownerid` ASC) USING BTREE,
  INDEX `ownerid`(`ownerid` ASC) USING BTREE,
  CONSTRAINT `balance` FOREIGN KEY (`owner`, `ownerid`) REFERENCES `entity_user` (`euname`, `id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of entity_account
-- ----------------------------
INSERT INTO `entity_account` VALUES (202211, 'Zou Jialun', 2022010, 44487, 82735, 24713, 94224, 98262);
INSERT INTO `entity_account` VALUES (202212, 'Dai Yunxi', 2022013, 24777, 61881, 13904, 10031, 37110);
INSERT INTO `entity_account` VALUES (202213, 'Shen Xiuying', 2022004, 95462, 11728, 49641, 93305, 78333);
INSERT INTO `entity_account` VALUES (202214, 'Zou Jialun', 2022010, 34545, 30502, 85600, 31599, 8320);
INSERT INTO `entity_account` VALUES (202215, 'Yao Ziyi', 2022005, 97196, 72751, 94762, 72033, 72558);
INSERT INTO `entity_account` VALUES (202216, 'Duan Zhiyuan', 2022007, 84877, 16132, 41461, 52308, 43050);
INSERT INTO `entity_account` VALUES (202217, 'Yao Ziyi', 2022005, 71853, 54885, 64303, 46168, 69679);
INSERT INTO `entity_account` VALUES (202218, 'Zou Jialun', 2022010, 94848, 14952, 32080, 29849, 34290);
INSERT INTO `entity_account` VALUES (202219, 'Xiao Ziyi', 2022003, 83165, 86513, 15703, 68250, 25505);
INSERT INTO `entity_account` VALUES (202220, 'Yao Ziyi', 2022005, 42757, 11860, 78153, 31649, 41095);
INSERT INTO `entity_account` VALUES (202221, 'He Xiuying', 2022009, 68439, 45643, 52042, 86126, 68249);
INSERT INTO `entity_account` VALUES (202222, 'Dai Yunxi', 2022013, 43075, 30916, 91655, 79901, 17758);
INSERT INTO `entity_account` VALUES (202223, 'Peng Lan', 2022001, 11463, 73782, 37895, 52189, 46809);
INSERT INTO `entity_account` VALUES (202224, 'Dai Yunxi', 2022013, 10233, 72440, 71809, 19574, 45125);
INSERT INTO `entity_account` VALUES (202225, 'Jiang Rui', 2022002, 22090, 56700, 30675, 73106, 84400);

-- ----------------------------
-- Table structure for entity_trade
-- ----------------------------
DROP TABLE IF EXISTS `entity_trade`;
CREATE TABLE `entity_trade`  (
  `id` int NOT NULL,
  `uid` varchar(38) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `date` date NULL DEFAULT NULL,
  `currency` varchar(5) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `amount` int NULL DEFAULT NULL,
  `owner` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `ownerid` int NULL DEFAULT NULL,
  `action` varchar(5) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `iban` varchar(21) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `desc` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `tradeForUser`(`owner` ASC, `ownerid` ASC, `iban` ASC) USING BTREE,
  CONSTRAINT `tradeForUser` FOREIGN KEY (`owner`, `ownerid`, `iban`) REFERENCES `entity_user` (`euname`, `id`, `iban`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of entity_trade
-- ----------------------------
INSERT INTO `entity_trade` VALUES (2122001, 'J9zxD0R0-0oH2-Fpk7-7Nzp-yQivkZOo7qGlN', '2021-10-04', 'chf', 54514, 'Duan Zhennan', 2022014, 'BUY', 'EtG3lqiyB3UxuS0d9G', NULL);
INSERT INTO `entity_trade` VALUES (2122002, '2G0drjZm-QSOQ-F2nK-vhVi-XIJJExLtGwvtS', '2012-09-25', 'rmb', 44042, 'Liao Jiehong', 2022008, 'BUY', 'qEF0KzGWEagsLEUEDR', NULL);
INSERT INTO `entity_trade` VALUES (2122003, '5jgGvnuW-vtkV-shgT-u2jw-EXlpmztyFyntI', '2016-04-05', 'hkd', 36616, 'Peng Lan', 2022001, 'BUY', 'VBOjZ19ZJpi6amdKBH', NULL);
INSERT INTO `entity_trade` VALUES (2122004, 'FfYh6iXm-AHZs-QXKq-im3R-M3dAZXXOWxyuK', '2022-06-02', 'rmb', 23461, 'Jiang Rui', 2022002, 'BUY', 'Q5vIbAdI9Yqzg56uGv', NULL);
INSERT INTO `entity_trade` VALUES (2122005, '0JaNi4Di-7vVA-tZwP-wO3g-ZkqAeqqHy7ebl', '2015-06-27', 'hkd', 3287, 'Zhang Xiaoming', 2022015, 'BUY', 'TidLsUdSckUBahBH8W', NULL);
INSERT INTO `entity_trade` VALUES (2122006, '4blyHety-zSVq-Io3P-xNXu-vxmRpx53NSF7d', '2020-10-16', 'gbp', 36185, 'Zou Jialun', 2022010, 'BUY', 'SIgf4synfQice3oCPU', NULL);
INSERT INTO `entity_trade` VALUES (2122007, 'muL1YcSO-b0vF-CHv4-KeaM-2t28OYccNiZVJ', '2021-07-26', 'chf', 29765, 'Shen Xiuying', 2022004, 'BUY', 'jzdngdWVHlmKRApix3', NULL);
INSERT INTO `entity_trade` VALUES (2122008, 'q20u2UJk-OKaS-qJ89-9vfJ-etvGKHtW9vH8y', '2022-02-04', 'rmb', 43066, 'Shen Xiuying', 2022004, 'BUY', 'jzdngdWVHlmKRApix3', NULL);
INSERT INTO `entity_trade` VALUES (2122009, 'OkQK9A50-3KU5-A1Om-hYxN-jzczG1nesISq8', '2015-03-09', 'hkd', 75622, 'Zhang Xiaoming', 2022015, 'BUY', 'TidLsUdSckUBahBH8W', NULL);
INSERT INTO `entity_trade` VALUES (2122010, 'GOTkdCXn-bPpo-p88Y-EAqU-JFnT7o4bIZLiX', '2016-06-11', 'gbp', 92761, 'Cai Lu', 2022006, 'BUY', 'P2RSnDn3DTpT6ZhQN6', NULL);
INSERT INTO `entity_trade` VALUES (2122011, 'MBAPukBC-3gVt-2wfX-Ftya-0FtQmE4DVwhjd', '2018-02-20', 'chf', 40684, 'Duan Zhiyuan', 2022007, 'BUY', 'ikEsYYHuUznKaS1i6C', NULL);
INSERT INTO `entity_trade` VALUES (2122012, 'R2HfF5ku-jS8S-pmoV-jgHM-nqtAKw6g7Fc43', '2014-03-07', 'rmb', 90588, 'Duan Zhiyuan', 2022007, 'BUY', 'ikEsYYHuUznKaS1i6C', NULL);
INSERT INTO `entity_trade` VALUES (2122013, 'eyZN7jqJ-7EVY-XTIR-m7YM-0AEqraHndVa8H', '2018-05-21', 'hkd', 14422, 'Shen Xiuying', 2022004, 'BUY', 'jzdngdWVHlmKRApix3', NULL);
INSERT INTO `entity_trade` VALUES (2122014, 'H0O8FQ1y-vf2J-Zm5v-UCGq-xnLSRWhOYdEP8', '2012-07-17', 'gbp', 23252, 'Cao Xiaoming', 2022011, 'BUY', 'PkE4znjl4dAt1DzaN4', NULL);
INSERT INTO `entity_trade` VALUES (2122015, 'wwv0qKqm-NUSV-g9Oi-4mMN-LuzHLc0sp8Ick', '2015-11-14', 'chf', 46350, 'Yao Ziyi', 2022005, 'BUY', 'vXWC3elNFvnVjkJVwa', NULL);

-- ----------------------------
-- Table structure for entity_user
-- ----------------------------
DROP TABLE IF EXISTS `entity_user`;
CREATE TABLE `entity_user`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `eutype` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `euname` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `eudesc` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `iban` varchar(21) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `euname`(`euname` ASC) USING BTREE,
  INDEX `euname_2`(`euname` ASC, `id` ASC) USING BTREE,
  INDEX `euname_3`(`euname` ASC, `id` ASC, `iban` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2022016 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of entity_user
-- ----------------------------
INSERT INTO `entity_user` VALUES (2022001, 'No password for test', 'Peng Lan', 'fake data', 'VBOjZ19ZJpi6amdKBH');
INSERT INTO `entity_user` VALUES (2022002, 'No password for test', 'Jiang Rui', 'fake data', 'Q5vIbAdI9Yqzg56uGv');
INSERT INTO `entity_user` VALUES (2022003, 'No password for test', 'Xiao Ziyi', 'fake data', 'Mu9y0BLb1ECkdNQ9Le');
INSERT INTO `entity_user` VALUES (2022004, 'No password for test', 'Shen Xiuying', 'fake data', 'jzdngdWVHlmKRApix3');
INSERT INTO `entity_user` VALUES (2022005, 'No password for test', 'Yao Ziyi', 'fake data', 'vXWC3elNFvnVjkJVwa');
INSERT INTO `entity_user` VALUES (2022006, 'No password for test', 'Cai Lu', 'fake data', 'P2RSnDn3DTpT6ZhQN6');
INSERT INTO `entity_user` VALUES (2022007, 'No password for test', 'Duan Zhiyuan', 'fake data', 'ikEsYYHuUznKaS1i6C');
INSERT INTO `entity_user` VALUES (2022008, 'No password for test', 'Liao Jiehong', 'fake data', 'qEF0KzGWEagsLEUEDR');
INSERT INTO `entity_user` VALUES (2022009, 'No password for test', 'He Xiuying', 'fake data', '9Xxh9FjnzY7LrJlhWK');
INSERT INTO `entity_user` VALUES (2022010, 'No password for test', 'Zou Jialun', 'fake data', 'SIgf4synfQice3oCPU');
INSERT INTO `entity_user` VALUES (2022011, 'No password for test', 'Cao Xiaoming', 'fake data', 'PkE4znjl4dAt1DzaN4');
INSERT INTO `entity_user` VALUES (2022012, 'No password for test', 'Fan Zhiyuan', 'fake data', 'ztFmtyOGKckkBxqQ0g');
INSERT INTO `entity_user` VALUES (2022013, 'No password for test', 'Dai Yunxi', 'fake data', 'crwFYAUFqrbdyobncr');
INSERT INTO `entity_user` VALUES (2022014, 'No password for test', 'Duan Zhennan', 'fake data', 'EtG3lqiyB3UxuS0d9G');
INSERT INTO `entity_user` VALUES (2022015, 'No password for test', 'Zhang Xiaoming', 'fake data', 'TidLsUdSckUBahBH8W');

-- ----------------------------
-- Table structure for role_uni
-- ----------------------------
DROP TABLE IF EXISTS `role_uni`;
CREATE TABLE `role_uni`  (
  `id` int NOT NULL,
  `runame` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `rutype` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `rudesc` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of role_uni
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;
