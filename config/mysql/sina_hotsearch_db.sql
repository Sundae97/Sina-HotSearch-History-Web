/*
 Navicat Premium Data Transfer

 Source Server         : aliyun
 Source Server Type    : MySQL
 Source Server Version : 50728
 Source Host           : 47.100.183.36:3306
 Source Schema         : sina_hotsearch_db

 Target Server Type    : MySQL
 Target Server Version : 50728
 File Encoding         : 65001

 Date: 22/02/2020 17:19:28
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for hotsearch_blog_detail
-- ----------------------------
DROP TABLE IF EXISTS `hotsearch_blog_detail`;
CREATE TABLE `hotsearch_blog_detail`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `hotsearch_item_id` bigint(20) NOT NULL,
  `user_id` bigint(20) NOT NULL,
  `screen_name` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `mblog_id` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `text` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `pic_urls_str` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `reposts_count` int(11) NOT NULL DEFAULT 0,
  `comments_count` int(11) NOT NULL DEFAULT 0,
  `attitudes_count` int(11) NOT NULL DEFAULT 0,
  `created_time` timestamp(0) NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_hotsearch_blog_detail_hotsearch_list_detail_1`(`hotsearch_item_id`) USING BTREE,
  CONSTRAINT `fk_hotsearch_blog_detail_hotsearch_list_detail_1` FOREIGN KEY (`hotsearch_item_id`) REFERENCES `hotsearch_list_detail` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 920 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for hotsearch_list
-- ----------------------------
DROP TABLE IF EXISTS `hotsearch_list`;
CREATE TABLE `hotsearch_list`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `time` timestamp(0) NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 622 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for hotsearch_list_detail
-- ----------------------------
DROP TABLE IF EXISTS `hotsearch_list_detail`;
CREATE TABLE `hotsearch_list_detail`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `desc` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
  `desc_extr` bigint(20) NULL DEFAULT NULL COMMENT '热搜热度值',
  `icon` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `scheme` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `detail_url` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 600 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for hotsearch_rank
-- ----------------------------
DROP TABLE IF EXISTS `hotsearch_rank`;
CREATE TABLE `hotsearch_rank`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `hotsearch_id` bigint(20) NOT NULL,
  `hotsearch_detail_id` bigint(20) NOT NULL,
  `rank` int(11) NOT NULL COMMENT '排名',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `index_hotsearch_id`(`hotsearch_id`) USING BTREE,
  INDEX `index_hotsearch_detail_id`(`hotsearch_detail_id`) USING BTREE,
  CONSTRAINT `fk_hotsearch_rank_hotsearch_list_1` FOREIGN KEY (`hotsearch_id`) REFERENCES `hotsearch_list` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_hotsearch_rank_hotsearch_list_detail_1` FOREIGN KEY (`hotsearch_detail_id`) REFERENCES `hotsearch_list_detail` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 30056 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
