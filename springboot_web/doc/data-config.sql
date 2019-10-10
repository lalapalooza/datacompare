/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50722
 Source Host           : localhost:3306
 Source Schema         : data-config

 Target Server Type    : MySQL
 Target Server Version : 50722
 File Encoding         : 65001

 Date: 20/09/2019 11:11:24
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_compare_propertites
-- ----------------------------
DROP TABLE IF EXISTS `t_compare_propertites`;
CREATE TABLE `t_compare_propertites`  (
                                          `id` int(11) NOT NULL AUTO_INCREMENT,
                                          `propertites_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
                                          `propertites_cron` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
                                          `create_time` datetime(0) NULL DEFAULT NULL,
                                          `update_time` datetime(0) NULL DEFAULT NULL,
                                          PRIMARY KEY (`id`) USING BTREE,
                                          UNIQUE INDEX `propertites_key`(`propertites_name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_compare_propertites
-- ----------------------------
INSERT INTO `t_compare_propertites` VALUES (1, 'compare_propertites', '00 09 14 * * ?', '2019-07-15 11:03:30', '2019-09-05 14:08:24');

-- ----------------------------
-- Table structure for t_connection
-- ----------------------------
DROP TABLE IF EXISTS `t_connection`;
CREATE TABLE `t_connection`  (
                                 `connection_code` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
                                 `url` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
                                 `user` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
                                 `password` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
                                 `created_at` datetime(6) NULL DEFAULT NULL,
                                 `updated_at` datetime(6) NULL DEFAULT NULL,
                                 `driver` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
                                 PRIMARY KEY (`connection_code`) USING BTREE,
                                 UNIQUE INDEX `inx_connection_code`(`connection_code`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '数据库连接信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_connection
-- ----------------------------
INSERT INTO `t_connection` VALUES ('a-hbase-jim-test', 'hbase', 'root', 'root', '2019-07-15 09:38:07.313000', NULL, '');
INSERT INTO `t_connection` VALUES ('a-hive-jim-test', 'jdbc:hive2://192.168.0.111:10000', 'root', 'root', '2019-07-15 09:38:07.444000', NULL, 'org.apache.hive.jdbc.HiveDriver');
INSERT INTO `t_connection` VALUES ('a-oracle-jim-test', 'jdbc:oracle:thin:@192.168.0.38:1521/orcl', 'JIRA', 'JIRA', '2019-07-15 09:38:07.500000', NULL, 'oracle.jdbc.OracleDriver');
INSERT INTO `t_connection` VALUES ('cache', 'jdbc:Cache://192.168.0.39:1972/DHC-APP', '_SYSTEM', 'SYS', '2019-07-15 09:38:07.557000', NULL, 'com.intersys.jdbc.CacheDriver');
INSERT INTO `t_connection` VALUES ('gp', 'jdbc:pivotal:greenplum://192.168.0.113:5432;DatabaseName=testgp', 'gpadmin', 'gpadmin', '2019-07-15 09:38:07.603000', NULL, 'com.pivotal.jdbc.GreenplumDriver');
INSERT INTO `t_connection` VALUES ('gp_cdr', 'jdbc:pivotal:greenplum://192.168.0.113:5432;DatabaseName=cdr', 'gpadmin', 'gpadmin', '2019-07-15 09:38:07.648000', NULL, 'com.pivotal.jdbc.GreenplumDriver');
INSERT INTO `t_connection` VALUES ('gp_cdr_hx', 'jdbc:pivotal:greenplum://192.168.0.113:5432;DatabaseName=cdr_hx', 'gpadmin', 'gpadmin', '2019-07-15 09:38:07.700000', NULL, 'com.pivotal.jdbc.GreenplumDriver');
INSERT INTO `t_connection` VALUES ('gp_student', 'jdbc:pivotal:greenplum://192.168.0.113:5432;DatabaseName=sqluser_repl', 'gpadmin', 'gpadmin', '2019-07-15 09:38:07.755000', NULL, 'com.pivotal.jdbc.GreenplumDriver');
INSERT INTO `t_connection` VALUES ('HBASE', 'HBASE', 'root', NULL, '2019-07-15 09:38:07.814000', NULL, '');
INSERT INTO `t_connection` VALUES ('HBASE1', 'jdbc:hive2://192.168.0.111:10000', 'root', NULL, '2019-07-15 09:38:07.865000', NULL, 'org.apache.hive.jdbc.HiveDriver');
INSERT INTO `t_connection` VALUES ('hbase2', 'hbase2', 'root', 'rrrrrr', '2019-07-15 09:38:07.911000', NULL, '');
INSERT INTO `t_connection` VALUES ('hive', 'jdbc:hive2://192.168.0.111:10000', 'root', 'root', '2019-07-15 09:38:07.956000', NULL, 'org.apache.hive.jdbc.HiveDriver');
INSERT INTO `t_connection` VALUES ('hive0.111', 'jdbc:hive2://192.168.0.111:10000', 'root', 'root', '2019-07-15 09:38:08.253000', NULL, 'org.apache.hive.jdbc.HiveDriver');
INSERT INTO `t_connection` VALUES ('hive_impala', 'jdbc:impala://192.168.0.113:21050', 'impala', 'root', '2019-07-15 09:38:08.298000', NULL, 'com.cloudera.impala.jdbc41.Driver');
INSERT INTO `t_connection` VALUES ('impala', 'jdbc:impala://192.168.0.113:21050', 'impala', 'impala', '2019-07-15 09:38:08.344000', NULL, 'com.cloudera.impala.jdbc41.Driver');
INSERT INTO `t_connection` VALUES ('mysql', 'jdbc:mysql://192.168.0.111:3306', 'root', 'root', '2019-07-15 09:38:08.390000', NULL, 'com.mysql.jdbc.Driver');
INSERT INTO `t_connection` VALUES ('mysql_36', 'jdbc:mysql://192.168.0.36:3306', 'root', 'root', '2019-07-15 09:38:08.441000', NULL, 'com.mysql.jdbc.Driver');
INSERT INTO `t_connection` VALUES ('mysql_local', 'jdbc:mysql://192.168.6.92:3306', 'root', 'root', '2019-07-15 09:38:08.492000', NULL, 'com.mysql.jdbc.Driver');
INSERT INTO `t_connection` VALUES ('mysql_test', 'jdbc:mysql://192.168.3.28:3306', 'root', 'root', '2019-07-15 09:38:08.538000', NULL, 'com.mysql.jdbc.Driver');
INSERT INTO `t_connection` VALUES ('ogg_oracle', 'jdbc:oracle:thin:@//192.168.69.20:1521/orcl', 'LF_HIS', 'Passw0rd', '2019-07-15 09:38:08.584000', NULL, 'oracle.jdbc.OracleDriver');
INSERT INTO `t_connection` VALUES ('oracle_38', 'jdbc:oracle:thin:@192.168.0.38:1521:orcl', 'jira', 'jira', '2019-09-19 18:02:06.689000', NULL, 'oracle.jdbc.OracleDriver');
INSERT INTO `t_connection` VALUES ('oracle_test', 'jdbc:oracle:thin:@192.168.0.114:1521/orcl', 'jira', 'jira', '2019-07-15 09:38:08.629000', NULL, 'oracle.jdbc.OracleDriver');
INSERT INTO `t_connection` VALUES ('sqlserver_36', 'jdbc:sqlserver://192.168.0.36:1433', 'sa', 'P@ssw0rd', '2019-09-19 18:02:06.740000', NULL, 'com.microsoft.sqlserver.jdbc.SQLServerDriver');
INSERT INTO `t_connection` VALUES ('sqlserver_test', 'jdbc:sqlserver://192.168.0.115:1433', 'sa', 'zaq12wsx#', '2019-07-15 09:38:08.675000', NULL, 'com.microsoft.sqlserver.jdbc.SQLServerDriver');
INSERT INTO `t_connection` VALUES ('ssh_0.111', '192.168.0.111:22', 'root', 'zaq12wsx$', '2019-07-15 09:38:08.721000', NULL, '');

-- ----------------------------
-- Table structure for t_sys_datas
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_datas`;
CREATE TABLE `t_sys_datas`  (
                                `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
                                `file_path` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
                                PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '文件表存储表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_sys_datas
-- ----------------------------
INSERT INTO `t_sys_datas` VALUES ('595007521958133760', 'static/images_upload/b1a3ce4c7a30db570b6a9248aa89c250.jpg');

-- ----------------------------
-- Table structure for t_sys_email
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_email`;
CREATE TABLE `t_sys_email`  (
                                `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '主键',
                                `receivers_email` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '接收人电子邮件',
                                `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '邮件标题',
                                `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '内容',
                                `send_user_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '发送人id',
                                `send_user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '发送人账号',
                                `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
                                PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '电子邮件' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_sys_email
-- ----------------------------
INSERT INTO `t_sys_email` VALUES ('595001021625794560', '87766867@qq.com', 'springbootv2测试邮件', '<p>测试测测测</p>', '1', 'admin', '2019-06-30 21:21:38');
INSERT INTO `t_sys_email` VALUES ('595005420867682304', '87766867@qq.com', '带带带', '<p>顶顶顶顶顶顶顶顶顶顶顶顶顶</p>', '1', 'admin', '2019-06-30 21:39:07');
INSERT INTO `t_sys_email` VALUES ('595007558129811456', '87766867@qq.com', '呱呱呱呱呱呱', '<p><img src=\"http://localhost:8080/static/images_upload/b1a3ce4c7a30db570b6a9248aa89c250.jpg\" title=\"ssss\" alt=\"\"/></p>', '1', 'admin', '2019-06-30 21:47:37');

-- ----------------------------
-- Table structure for t_sys_file
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_file`;
CREATE TABLE `t_sys_file`  (
                               `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '主键',
                               `file_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '图片名字',
                               `create_user_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '创建人id',
                               `create_user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '创建人名字',
                               `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
                               `update_user_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '修改人',
                               `update_user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '修改人名字',
                               `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
                               PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '文件信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_sys_file
-- ----------------------------
INSERT INTO `t_sys_file` VALUES ('594974831133327360', '百度富文本上传', '1', 'admin', '2019-06-30 19:37:34', NULL, NULL, NULL);
INSERT INTO `t_sys_file` VALUES ('595007522008465408', '百度富文本上传', '1', 'admin', '2019-06-30 21:47:28', NULL, NULL, NULL);

-- ----------------------------
-- Table structure for t_sys_file_data
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_file_data`;
CREATE TABLE `t_sys_file_data`  (
                                    `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
                                    `data_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
                                    `file_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT '文件id',
                                    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '文件数据外键绑定表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_sys_file_data
-- ----------------------------
INSERT INTO `t_sys_file_data` VALUES ('595007522008465408', '595007521958133760', '595007522008465408');

-- ----------------------------
-- Table structure for t_sys_oper_log
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_oper_log`;
CREATE TABLE `t_sys_oper_log`  (
                                   `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
                                   `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '标题',
                                   `method` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '方法',
                                   `oper_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '操作人',
                                   `oper_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT 'url',
                                   `oper_param` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '参数',
                                   `error_msg` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
                                   `oper_time` date NULL DEFAULT NULL COMMENT '操作时间',
                                   PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '日志记录表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_sys_oper_log
-- ----------------------------
INSERT INTO `t_sys_oper_log` VALUES ('595006721877868544', '用户集合查询', 'com.fc.test.controller.admin.UserController.list()', 'admin', '/UserController/list', '{\"pageSize\":[\"10\"],\"pageNum\":[\"1\"]}', NULL, '2019-06-30');
INSERT INTO `t_sys_oper_log` VALUES ('595007464991096832', '用户集合查询', 'com.fc.test.controller.admin.UserController.list()', 'admin', '/UserController/list', '{\"pageSize\":[\"10\"],\"pageNum\":[\"1\"]}', NULL, '2019-06-30');
INSERT INTO `t_sys_oper_log` VALUES ('595007483563474944', '用户集合查询', 'com.fc.test.controller.admin.UserController.list()', 'admin', '/UserController/list', '{\"pageSize\":[\"10\"],\"pageNum\":[\"1\"]}', NULL, '2019-06-30');
INSERT INTO `t_sys_oper_log` VALUES ('595007490660237312', '用户集合查询', 'com.fc.test.controller.admin.UserController.list()', 'admin', '/UserController/list', '{\"pageSize\":[\"10\"],\"pageNum\":[\"1\"]}', NULL, '2019-06-30');
INSERT INTO `t_sys_oper_log` VALUES ('595040139214848000', '用户集合查询', 'com.fc.test.controller.admin.UserController.list()', 'admin', '/UserController/list', '{\"pageSize\":[\"10\"],\"pageNum\":[\"1\"]}', NULL, '2019-06-30');
INSERT INTO `t_sys_oper_log` VALUES ('595040974183333888', '用户集合查询', 'com.fc.test.controller.admin.UserController.list()', 'admin', '/UserController/list', '{\"pageSize\":[\"10\"],\"pageNum\":[\"1\"]}', NULL, '2019-07-01');
INSERT INTO `t_sys_oper_log` VALUES ('595041715522371584', '用户集合查询', 'com.fc.test.controller.admin.UserController.list()', 'admin', '/UserController/list', '{\"pageSize\":[\"10\"],\"pageNum\":[\"1\"]}', NULL, '2019-07-01');
INSERT INTO `t_sys_oper_log` VALUES ('595042140849963008', '用户集合查询', 'com.fc.test.controller.admin.UserController.list()', 'admin', '/UserController/list', '{\"pageSize\":[\"10\"],\"pageNum\":[\"1\"]}', NULL, '2019-07-01');
INSERT INTO `t_sys_oper_log` VALUES ('595042463626821632', '用户集合查询', 'com.fc.test.controller.admin.UserController.list()', 'admin', '/UserController/list', '{\"pageSize\":[\"10\"],\"pageNum\":[\"1\"]}', NULL, '2019-07-01');
INSERT INTO `t_sys_oper_log` VALUES ('595042483801423872', '用户集合查询', 'com.fc.test.controller.admin.UserController.list()', 'admin', '/UserController/list', '{\"pageSize\":[\"10\"],\"pageNum\":[\"1\"]}', NULL, '2019-07-01');
INSERT INTO `t_sys_oper_log` VALUES ('595042914216706048', '用户集合查询', 'com.fc.test.controller.admin.UserController.list()', 'admin', '/UserController/list', '{\"pageSize\":[\"10\"],\"pageNum\":[\"1\"]}', NULL, '2019-07-01');
INSERT INTO `t_sys_oper_log` VALUES ('595046005259370496', '用户集合查询', 'com.fc.test.controller.admin.UserController.list()', 'admin', '/UserController/list', '{\"pageSize\":[\"10\"],\"pageNum\":[\"1\"]}', NULL, '2019-07-01');
INSERT INTO `t_sys_oper_log` VALUES ('595054071166009344', '用户集合查询', 'com.fc.test.controller.admin.UserController.list()', 'admin', '/UserController/list', '{\"pageSize\":[\"10\"],\"pageNum\":[\"1\"]}', NULL, '2019-07-01');
INSERT INTO `t_sys_oper_log` VALUES ('595054971544666112', '用户集合查询', 'com.fc.test.controller.admin.UserController.list()', 'admin', '/UserController/list', '{\"pageSize\":[\"10\"],\"pageNum\":[\"1\"]}', NULL, '2019-07-01');
INSERT INTO `t_sys_oper_log` VALUES ('595928580907597824', '用户集合查询', 'com.fc.test.controller.admin.UserController.list()', 'admin', '/UserController/list', '{\"pageSize\":[\"10\"],\"pageNum\":[\"1\"]}', NULL, '2019-07-03');
INSERT INTO `t_sys_oper_log` VALUES ('595928655952084992', '用户集合查询', 'com.fc.test.controller.admin.UserController.list()', 'admin', '/UserController/list', '{\"username\":[\"1\"],\"pageSize\":[\"10\"],\"pageNum\":[\"1\"]}', NULL, '2019-07-03');
INSERT INTO `t_sys_oper_log` VALUES ('595928671135465472', '用户集合查询', 'com.fc.test.controller.admin.UserController.list()', 'admin', '/UserController/list', '{\"username\":[\"\"],\"pageSize\":[\"10\"],\"pageNum\":[\"1\"]}', NULL, '2019-07-03');
INSERT INTO `t_sys_oper_log` VALUES ('595928709068750848', '用户集合查询', 'com.fc.test.controller.admin.UserController.list()', 'admin', '/UserController/list', '{\"username\":[\"ad\"],\"pageSize\":[\"10\"],\"pageNum\":[\"1\"]}', NULL, '2019-07-03');
INSERT INTO `t_sys_oper_log` VALUES ('595928709605621760', '用户集合查询', 'com.fc.test.controller.admin.UserController.list()', 'admin', '/UserController/list', '{\"username\":[\"ad\"],\"pageSize\":[\"10\"],\"pageNum\":[\"1\"]}', NULL, '2019-07-03');
INSERT INTO `t_sys_oper_log` VALUES ('595928726709993472', '用户集合查询', 'com.fc.test.controller.admin.UserController.list()', 'admin', '/UserController/list', '{\"username\":[\"\"],\"pageSize\":[\"10\"],\"pageNum\":[\"1\"]}', NULL, '2019-07-03');
INSERT INTO `t_sys_oper_log` VALUES ('596047724508348416', '用户集合查询', 'com.fc.test.controller.admin.UserController.list()', 'admin', '/UserController/list', '{\"pageSize\":[\"10\"],\"pageNum\":[\"1\"]}', NULL, '2019-07-03');
INSERT INTO `t_sys_oper_log` VALUES ('596280514092990464', '用户集合查询', 'com.fc.test.controller.admin.UserController.list()', 'admin', '/UserController/list', '{\"pageSize\":[\"10\"],\"pageNum\":[\"1\"]}', NULL, '2019-07-04');
INSERT INTO `t_sys_oper_log` VALUES ('596280652286918656', '用户集合查询', 'com.fc.test.controller.admin.UserController.list()', 'admin', '/UserController/list', '{\"pageSize\":[\"10\"],\"pageNum\":[\"1\"]}', NULL, '2019-07-04');
INSERT INTO `t_sys_oper_log` VALUES ('596280798307418112', '用户集合查询', 'com.fc.test.controller.admin.UserController.list()', 'admin', '/UserController/list', '{\"pageSize\":[\"10\"],\"pageNum\":[\"1\"]}', NULL, '2019-07-04');
INSERT INTO `t_sys_oper_log` VALUES ('596282719575474176', '用户集合查询', 'com.fc.test.controller.admin.UserController.list()', 'admin', '/UserController/list', '{\"pageSize\":[\"10\"],\"pageNum\":[\"1\"]}', NULL, '2019-07-04');
INSERT INTO `t_sys_oper_log` VALUES ('597852717653688320', '用户集合查询', 'com.fc.test.controller.admin.UserController.list()', 'admin', '/UserController/list', '{\"pageSize\":[\"10\"],\"pageNum\":[\"1\"]}', NULL, '2019-07-08');
INSERT INTO `t_sys_oper_log` VALUES ('598826559536627712', '用户集合查询', 'com.fc.test.controller.admin.UserController.list()', 'admin', '/UserController/list', '{\"pageSize\":[\"10\"],\"pageNum\":[\"1\"]}', NULL, '2019-07-11');
INSERT INTO `t_sys_oper_log` VALUES ('598836357174919168', '用户集合查询', 'com.fc.test.controller.admin.UserController.list()', 'admin', '/UserController/list', '{\"pageSize\":[\"10\"],\"pageNum\":[\"1\"]}', NULL, '2019-07-11');
INSERT INTO `t_sys_oper_log` VALUES ('598836422836748288', '用户集合查询', 'com.fc.test.controller.admin.UserController.list()', 'admin', '/UserController/list', '{\"pageSize\":[\"10\"],\"pageNum\":[\"1\"]}', NULL, '2019-07-11');
INSERT INTO `t_sys_oper_log` VALUES ('605362083202072576', '用户集合查询', 'com.fc.test.controller.admin.UserController.list()', 'admin', '/compare/UserController/list', '{\"pageSize\":[\"10\"],\"pageNum\":[\"1\"]}', NULL, '2019-07-29');
INSERT INTO `t_sys_oper_log` VALUES ('605366691433545728', '用户集合查询', 'com.fc.test.controller.admin.UserController.list()', 'admin', '/compare/UserController/list', '{\"pageSize\":[\"10\"],\"pageNum\":[\"1\"]}', NULL, '2019-07-29');
INSERT INTO `t_sys_oper_log` VALUES ('605405597512237056', '用户集合查询', 'com.fc.test.controller.admin.UserController.list()', 'admin', '/compare/UserController/list', '{\"pageSize\":[\"10\"],\"pageNum\":[\"1\"]}', NULL, '2019-07-29');
INSERT INTO `t_sys_oper_log` VALUES ('605405634812182528', '用户集合查询', 'com.fc.test.controller.admin.UserController.list()', 'admin', '/compare/UserController/list', '{\"pageSize\":[\"10\"],\"pageNum\":[\"1\"]}', NULL, '2019-07-29');
INSERT INTO `t_sys_oper_log` VALUES ('605407211165843456', '用户集合查询', 'com.fc.test.controller.admin.UserController.list()', 'admin', '/compare/UserController/list', '{\"pageSize\":[\"10\"],\"pageNum\":[\"1\"]}', NULL, '2019-07-29');
INSERT INTO `t_sys_oper_log` VALUES ('605428351506579456', '用户集合查询', 'com.fc.test.controller.admin.UserController.list()', 'admin', '/compare/UserController/list', '{\"pageSize\":[\"10\"],\"pageNum\":[\"1\"]}', NULL, '2019-07-29');
INSERT INTO `t_sys_oper_log` VALUES ('605428362499850240', '用户集合查询', 'com.fc.test.controller.admin.UserController.list()', 'admin', '/compare/UserController/list', '{\"pageSize\":[\"10\"],\"pageNum\":[\"1\"]}', NULL, '2019-07-29');
INSERT INTO `t_sys_oper_log` VALUES ('605428372314521600', '用户集合查询', 'com.fc.test.controller.admin.UserController.list()', 'admin', '/compare/UserController/list', '{\"pageSize\":[\"10\"],\"pageNum\":[\"1\"]}', NULL, '2019-07-29');
INSERT INTO `t_sys_oper_log` VALUES ('605428450798338048', '用户集合查询', 'com.fc.test.controller.admin.UserController.list()', 'admin', '/compare/UserController/list', '{\"pageSize\":[\"10\"],\"pageNum\":[\"1\"]}', NULL, '2019-07-29');
INSERT INTO `t_sys_oper_log` VALUES ('605428556113117184', '用户集合查询', 'com.fc.test.controller.admin.UserController.list()', 'admin', '/compare/UserController/list', '{\"pageSize\":[\"10\"],\"pageNum\":[\"1\"]}', NULL, '2019-07-29');
INSERT INTO `t_sys_oper_log` VALUES ('606123645290414080', '用户集合查询', 'com.fc.test.controller.admin.UserController.list()', 'admin', '/compare/UserController/list', '{\"pageSize\":[\"10\"],\"pageNum\":[\"1\"],\"sortOrder\":[\"asc\"],\"searchText\":[\"\"]}', NULL, '2019-07-31');
INSERT INTO `t_sys_oper_log` VALUES ('606123926518497280', '用户集合查询', 'com.fc.test.controller.admin.UserController.list()', 'admin', '/compare/UserController/list', '{\"pageSize\":[\"10\"],\"pageNum\":[\"1\"],\"sortOrder\":[\"asc\"],\"searchText\":[\"a\"]}', NULL, '2019-07-31');
INSERT INTO `t_sys_oper_log` VALUES ('606123936702267392', '用户集合查询', 'com.fc.test.controller.admin.UserController.list()', 'admin', '/compare/UserController/list', '{\"pageSize\":[\"10\"],\"pageNum\":[\"1\"],\"sortOrder\":[\"asc\"],\"searchText\":[\"ass\"]}', NULL, '2019-07-31');
INSERT INTO `t_sys_oper_log` VALUES ('606123946147840000', '用户集合查询', 'com.fc.test.controller.admin.UserController.list()', 'admin', '/compare/UserController/list', '{\"pageSize\":[\"10\"],\"pageNum\":[\"1\"],\"sortOrder\":[\"asc\"],\"searchText\":[\"\"]}', NULL, '2019-07-31');
INSERT INTO `t_sys_oper_log` VALUES ('606124182844997632', '用户集合查询', 'com.fc.test.controller.admin.UserController.list()', 'admin', '/compare/UserController/list', '{\"pageSize\":[\"10\"],\"pageNum\":[\"1\"],\"sortOrder\":[\"asc\"],\"searchText\":[\"\"]}', NULL, '2019-07-31');
INSERT INTO `t_sys_oper_log` VALUES ('606127690092642304', '用户集合查询', 'com.fc.test.controller.admin.UserController.list()', 'admin', '/compare/UserController/list', '{\"pageSize\":[\"10\"],\"pageNum\":[\"1\"],\"sortOrder\":[\"asc\"],\"searchText\":[\"\"]}', NULL, '2019-07-31');
INSERT INTO `t_sys_oper_log` VALUES ('624303558379962368', '用户集合查询', 'com.clinbrain.datac.controller.admin.UserController.list()', 'admin', '/compare/UserController/list', '{\"pageSize\":[\"10\"],\"pageNum\":[\"1\"],\"sortName\":[\"roleSort\"],\"sortOrder\":[\"asc\"],\"searchText\":[\"\"]}', NULL, '2019-09-19');
INSERT INTO `t_sys_oper_log` VALUES ('624304288163692544', '用户集合查询', 'com.clinbrain.datac.controller.admin.UserController.list()', 'admin', '/compare/UserController/list', '{\"pageSize\":[\"10\"],\"pageNum\":[\"1\"],\"sortName\":[\"roleSort\"],\"sortOrder\":[\"asc\"],\"searchText\":[\"\"]}', NULL, '2019-09-19');

-- ----------------------------
-- Table structure for t_sys_permission_role
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_permission_role`;
CREATE TABLE `t_sys_permission_role`  (
                                          `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
                                          `role_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色id',
                                          `permission_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '权限id',
                                          PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色权限中间表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_sys_permission_role
-- ----------------------------
INSERT INTO `t_sys_permission_role` VALUES ('0a3732bf-81e7-4316-892d-5bacf28e0d3c', '488243256161730560', '587453033487532032');
INSERT INTO `t_sys_permission_role` VALUES ('10ee8fd0-2de1-45e1-a790-70f45ba1f050', '488243256161730560', '6053961014947348483');
INSERT INTO `t_sys_permission_role` VALUES ('1bef47d9-d759-49bb-842e-50b0676d8664', '488243256161730560', '6082611523417538563');
INSERT INTO `t_sys_permission_role` VALUES ('1cf3dd43-7302-4f82-8a58-51428f7d2ddf', '488243256161730560', '6082611523417538564');
INSERT INTO `t_sys_permission_role` VALUES ('1f9616ab-ee89-4a79-ba5b-52209f6f4cc7', '488243256161730560', '623932748083494912');
INSERT INTO `t_sys_permission_role` VALUES ('2380fd9e-cfb5-44d3-8783-3e917701f7b9', '488243256161730560', '22');
INSERT INTO `t_sys_permission_role` VALUES ('292a2e9d-6a8c-4e33-a77a-cf1b3fd7f8d3', '488243256161730560', '594691026430459904');
INSERT INTO `t_sys_permission_role` VALUES ('2badb7e4-b435-4a7d-89c9-4e4091102e57', '488243256161730560', '23');
INSERT INTO `t_sys_permission_role` VALUES ('2c253adb-843e-4f53-966b-89f4459c6d6b', '488243256161730560', '6');
INSERT INTO `t_sys_permission_role` VALUES ('2eada90e-c63d-4830-a6c2-ff7483ef32f3', '488243256161730560', '19');
INSERT INTO `t_sys_permission_role` VALUES ('3578f3a8-28db-4d88-abd3-933255ea163b', '488243256161730560', '21');
INSERT INTO `t_sys_permission_role` VALUES ('358cb670-fb1b-4624-9b4b-44bdb8c48beb', '488243256161730560', '496782496638173184');
INSERT INTO `t_sys_permission_role` VALUES ('374cd718-4ad8-4648-beaa-c8ecd3696034', '488243256161730560', '7');
INSERT INTO `t_sys_permission_role` VALUES ('38bdf744-c71b-4efe-9977-011f069b0b08', '488243256161730560', '18');
INSERT INTO `t_sys_permission_role` VALUES ('3c5ca30d-d557-470a-93a2-3cc299572b02', '488243256161730560', '9');
INSERT INTO `t_sys_permission_role` VALUES ('3dfb5857-12bc-4e01-92f9-1a851e43df02', '488243256161730560', '608261152341753856');
INSERT INTO `t_sys_permission_role` VALUES ('42a4bad9-bf9f-49c2-a4dd-961bf6de483d', '488243256161730560', '605396101494734848');
INSERT INTO `t_sys_permission_role` VALUES ('4426384f-3415-46f8-b729-df3d6e89a99e', '488243256161730560', '16');
INSERT INTO `t_sys_permission_role` VALUES ('45e9384a-8356-4310-8fd7-409fb137e651', '488243256161730560', '586003694080753664');
INSERT INTO `t_sys_permission_role` VALUES ('47a89359-222e-43d5-bab8-9f5cf9f0d2ae', '488243256161730560', '1');
INSERT INTO `t_sys_permission_role` VALUES ('545f1f0c-5d0e-4cdb-945d-3894579fdc98', '488243256161730560', '589559475422101504');
INSERT INTO `t_sys_permission_role` VALUES ('608d8ca9-3cb1-4e5e-ae70-3dff1b105944', '488243256161730560', '6239327480834949121');
INSERT INTO `t_sys_permission_role` VALUES ('6e9bd923-f898-457a-8d02-29f82c2dc80f', '488243256161730560', '6053961014947348482');
INSERT INTO `t_sys_permission_role` VALUES ('77330ece-eaa1-4934-86aa-957f715efc02', '488243256161730560', '14');
INSERT INTO `t_sys_permission_role` VALUES ('7deaec87-486d-4fc7-bd93-3227e5b11560', '488243256161730560', '581541547099553792');
INSERT INTO `t_sys_permission_role` VALUES ('7fe1b4ad-a800-4035-9b29-a99451341f08', '488243256161730560', '592167738407911424');
INSERT INTO `t_sys_permission_role` VALUES ('810aff6a-22af-4395-b019-161e465d00b4', '488243256161730560', '20');
INSERT INTO `t_sys_permission_role` VALUES ('873ae323-8f16-4216-a5f3-195e324580a6', '488243256161730560', '6082611523417538562');
INSERT INTO `t_sys_permission_role` VALUES ('8881b61d-9c2b-4b52-93f8-1ede49e5e7bb', '488243256161730560', '5');
INSERT INTO `t_sys_permission_role` VALUES ('8da7f02d-1279-4393-bc8e-c2f4024507d5', '488243256161730560', '8');
INSERT INTO `t_sys_permission_role` VALUES ('9642723e-a04d-4ba3-9b39-6e96f74bb99e', '488243256161730560', '6053961014947348481');
INSERT INTO `t_sys_permission_role` VALUES ('96431f59-a07b-4ffa-9da3-7776fd66c933', '488243256161730560', '575851658483859456');
INSERT INTO `t_sys_permission_role` VALUES ('96720169-cfee-4ba9-a69f-e525f82b090b', '488289006124007424', '589559748521623552');
INSERT INTO `t_sys_permission_role` VALUES ('9abe9d09-e70b-4012-9982-fbb75d77cbac', '488289006124007424', '1');
INSERT INTO `t_sys_permission_role` VALUES ('a86e59d3-3d56-4767-bbc6-da545b612e0f', '488243256161730560', '13');
INSERT INTO `t_sys_permission_role` VALUES ('ae428d3f-2450-4812-ad25-51ff35718a3d', '488243256161730560', '5946910264304599044');
INSERT INTO `t_sys_permission_role` VALUES ('b04fb1cd-e3f7-40c5-8958-8a49c8b91805', '488243256161730560', '575853607149109248');
INSERT INTO `t_sys_permission_role` VALUES ('b1c57f25-164c-48d2-b19b-c35d20bee7bf', '488243256161730560', '575852089792528384');
INSERT INTO `t_sys_permission_role` VALUES ('b2521cfd-bae1-4428-b457-d0d64e98bbd6', '488243256161730560', '589559916704825344');
INSERT INTO `t_sys_permission_role` VALUES ('b37323da-bb7c-4759-9872-5cb5bcc8ee33', '488243256161730560', '11');
INSERT INTO `t_sys_permission_role` VALUES ('b965d1b1-4001-4b91-8cf2-96d39128347a', '488289006124007424', '592067570522128384');
INSERT INTO `t_sys_permission_role` VALUES ('ba4dcd6e-522e-4fe6-b90f-ecdb473b4661', '488243256161730560', '17');
INSERT INTO `t_sys_permission_role` VALUES ('bc0125a1-17b9-417c-8a12-40af7f5f4d05', '488243256161730560', '592059865673760768');
INSERT INTO `t_sys_permission_role` VALUES ('c23aab4c-fa8a-40d6-9b8e-38c3afaf0530', '488243256161730560', '12');
INSERT INTO `t_sys_permission_role` VALUES ('c85beaca-e2b4-4a9b-817d-acf60133347f', '488243256161730560', '592067570522128384');
INSERT INTO `t_sys_permission_role` VALUES ('cbed219b-fbfc-4b58-bf48-d625a90ae20e', '488243256161730560', '5946910264304599041');
INSERT INTO `t_sys_permission_role` VALUES ('cedff25a-66d5-4eb4-a9ad-613dd6f27550', '488243256161730560', '5946910264304599043');
INSERT INTO `t_sys_permission_role` VALUES ('d03fc2d7-d346-40be-aa86-e98cfac3a090', '488243256161730560', '5946910264304599042');
INSERT INTO `t_sys_permission_role` VALUES ('d29981f5-d243-47ad-8007-d3eecc0e9802', '488289006124007424', '589559475422101504');
INSERT INTO `t_sys_permission_role` VALUES ('d42288d4-87db-457e-b60c-e0980da59e3a', '488243256161730560', '4');
INSERT INTO `t_sys_permission_role` VALUES ('d4e2ca5a-57ed-48b2-b4fe-b70eed662b8e', '488243256161730560', '6082611523417538561');
INSERT INTO `t_sys_permission_role` VALUES ('d6672ac2-f100-445b-89a1-37080bd93a0b', '488243256161730560', '589559748521623552');
INSERT INTO `t_sys_permission_role` VALUES ('ec1e696e-5819-40b8-af3d-f697cf7fcd2e', '488243256161730560', '6053961014947348484');
INSERT INTO `t_sys_permission_role` VALUES ('ec80e96c-2ea7-440f-bfc5-ca7bbd7ab78a', '488243256161730560', '15');
INSERT INTO `t_sys_permission_role` VALUES ('f61a7548-ef4d-4061-9f2b-de9615c02059', '488243256161730560', '486690002869157888');
INSERT INTO `t_sys_permission_role` VALUES ('f78734d7-8723-4c93-8f55-aeda08281c38', '488243256161730560', '583063272123531264');
INSERT INTO `t_sys_permission_role` VALUES ('fbbb5391-6206-45a9-99be-973572dd13ae', '488289006124007424', '589559916704825344');
INSERT INTO `t_sys_permission_role` VALUES ('fbe7e8cf-a43f-49f3-80c4-0ba1e85d717d', '488243256161730560', '10');

-- ----------------------------
-- Table structure for t_sys_premission
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_premission`;
CREATE TABLE `t_sys_premission`  (
                                     `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'id',
                                     `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '权限名称',
                                     `descripion` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '权限描述',
                                     `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '授权链接',
                                     `is_blank` int(255) NULL DEFAULT 0 COMMENT '是否跳转 0 不跳转 1跳转',
                                     `pid` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '父节点id',
                                     `perms` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '权限标识',
                                     `type` int(11) NULL DEFAULT NULL COMMENT '类型   0：目录   1：菜单   2：按钮',
                                     `icon` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单图标',
                                     `order_num` int(11) NULL DEFAULT NULL COMMENT '排序',
                                     PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '权限表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_sys_premission
-- ----------------------------
INSERT INTO `t_sys_premission` VALUES ('1', '首页', '首页', NULL, 0, '0', NULL, 0, 'fa fa-home', 1);
INSERT INTO `t_sys_premission` VALUES ('10', '角色集合', '角色集合', '/RoleController/list', 0, '9', 'system:role:list', 2, '', NULL);
INSERT INTO `t_sys_premission` VALUES ('11', '角色添加', '角色添加', '/RoleController/add', 0, '9', 'system:role:add', 2, 'entypo-plus-squared', NULL);
INSERT INTO `t_sys_premission` VALUES ('12', '角色删除', '角色删除', '/RoleController/remove', 0, '9', 'system:role:remove', 2, 'entypo-trash', NULL);
INSERT INTO `t_sys_premission` VALUES ('13', '角色修改', '角色修改', '/RoleController/edit', 0, '9', 'system:role:edit', 2, 'fa fa-wrench', NULL);
INSERT INTO `t_sys_premission` VALUES ('14', '权限展示', '权限展示', '/PremissionController/view', 0, '592059865673760768', 'system:premission:view', 1, 'fa fa-key', 3);
INSERT INTO `t_sys_premission` VALUES ('15', '权限集合', '权限集合', '/PremissionController/list', 0, '14', 'system:premission:list', 2, '', NULL);
INSERT INTO `t_sys_premission` VALUES ('16', '权限添加', '权限添加', '/PremissionController/add', 0, '14', 'system:premission:add', 2, 'entypo-plus-squared', NULL);
INSERT INTO `t_sys_premission` VALUES ('17', '权限删除', '权限删除', '/PremissionController/remove', 0, '14', 'system:premission:remove', 2, 'entypo-trash', NULL);
INSERT INTO `t_sys_premission` VALUES ('18', '权限修改', '权限修改', '/PremissionController/edit', 0, '14', 'system:premission:edit', 2, 'fa fa-wrench', NULL);
INSERT INTO `t_sys_premission` VALUES ('19', '文件展示', '文件展示', '/FileController/view', 0, '592059865673760768', 'system:file:view', 1, 'fa fa-file-image-o', 4);
INSERT INTO `t_sys_premission` VALUES ('20', '文件添加', '文件添加', '/FileController/add', 0, '19', 'system:file:add', 2, 'entypo-plus-squared', NULL);
INSERT INTO `t_sys_premission` VALUES ('21', '文件删除', '文件删除', '/FileController/remove', 0, '19', 'system:file:remove', 2, 'entypo-trash', NULL);
INSERT INTO `t_sys_premission` VALUES ('22', '文件修改', '文件修改', '/FileController/edit', 0, '19', 'system:file:edit', 2, 'fa fa-wrench', NULL);
INSERT INTO `t_sys_premission` VALUES ('23', '文件集合', '文件集合', '/FileController/list', 0, '19', 'system:file:list', 2, '', NULL);
INSERT INTO `t_sys_premission` VALUES ('4', '用户管理', '用户展示', '/UserController/view', 0, '592059865673760768', 'system:user:view', 1, 'icon icon-user', 1);
INSERT INTO `t_sys_premission` VALUES ('486690002869157888', '用户密码修改', '用户密码修改', '/UserController/editPwd', 0, '4', 'system:user:editPwd', 2, 'entypo-tools', 3);
INSERT INTO `t_sys_premission` VALUES ('496126970468237312', '日志展示', '日志管理', '/LogController/view', 0, '496124944220946432', 'system:log:view', 1, 'fa-bitbucket', NULL);
INSERT INTO `t_sys_premission` VALUES ('496127240363311104', '日志删除', '日志删除', '/LogController/remove', 0, '496126970468237312', 'system:log:remove', 2, 'entypo-trash', NULL);
INSERT INTO `t_sys_premission` VALUES ('496127794879660032', '日志集合', '日志集合', '/LogController/list', 0, '496126970468237312', 'system:log:list', 2, NULL, NULL);
INSERT INTO `t_sys_premission` VALUES ('496782496638173184', '后台设置', '后台设置', NULL, 0, '1', NULL, 0, 'fa fa-gear', 3);
INSERT INTO `t_sys_premission` VALUES ('5', '用户集合', '用户集合', '/UserController/list', 0, '4', 'system:user:list', 2, '', NULL);
INSERT INTO `t_sys_premission` VALUES ('575851658483859456', '代码生成', '代码生成', '#', 0, '496782496638173184', '#', 1, 'fa fa-ra', 2);
INSERT INTO `t_sys_premission` VALUES ('575852089792528384', '代码管理', '代码生成', '/generatorController/view', 0, '575851658483859456', 'system:generator:view', 1, 'fa fa-bug', 1);
INSERT INTO `t_sys_premission` VALUES ('575853607149109248', '代码集合', '代码集合', '/generatorController/list', 0, '575852089792528384', 'system:generator:list', 2, NULL, NULL);
INSERT INTO `t_sys_premission` VALUES ('581541547099553792', 'druid监控', 'druid监控', '/druid/', 0, '592059865673760768', 'user:list', 1, 'fa fa-line-chart', 6);
INSERT INTO `t_sys_premission` VALUES ('583063272123531264', 'API文档', 'API文档', '/swagger-ui.html', 1, '575851658483859456', '--', 1, 'fa fa-font', 1);
INSERT INTO `t_sys_premission` VALUES ('586003694080753664', '表单构建', '表单构建', '/ToolController/view', 0, '592059865673760768', 'system:tool:view', 1, 'fa fa-list-alt', 5);
INSERT INTO `t_sys_premission` VALUES ('587453033487532032', '后台模板', '后台模板', '/static/admin/bootstarp/index.html', 1, '575851658483859456', 'system:htmb:view', 1, 'fa fa-telegram', 4);
INSERT INTO `t_sys_premission` VALUES ('589559475422101504', '测试目录', '测试目录', NULL, 0, '1', NULL, 0, 'fa fa-bolt', 4);
INSERT INTO `t_sys_premission` VALUES ('589559748521623552', '一级菜单', '测试菜单', '#', 0, '589559475422101504', '#', 1, 'fa fa-address-book', NULL);
INSERT INTO `t_sys_premission` VALUES ('589559916704825344', '二级菜单', '二级菜单', '#', 0, '589559748521623552', '#', 1, 'fa fa-address-book', 1);
INSERT INTO `t_sys_premission` VALUES ('592059865673760768', '后台管理', '后台管理', '#', 0, '496782496638173184', '#', 1, 'fa fa-home', 1);
INSERT INTO `t_sys_premission` VALUES ('592067570522128384', '测试跳转', '测试跳转', 'http://www.baidu.com', 1, '589559748521623552', '#', 1, 'fa fa-address-book', NULL);
INSERT INTO `t_sys_premission` VALUES ('592167738407911424', '系统监控', '系统监控', '/ServiceController/view', 0, '592059865673760768', 'system:service:view', 1, 'fa fa-video-camera', 7);
INSERT INTO `t_sys_premission` VALUES ('594691026430459904', '电子邮件管理', '电子邮件展示', '/EmailController/view', 0, '592059865673760768', 'system:email:view', 1, 'fa fa-envelope', 8);
INSERT INTO `t_sys_premission` VALUES ('5946910264304599041', '电子邮件集合', '电子邮件集合', '/EmailController/list', 0, '594691026430459904', 'system:email:list', 2, '', NULL);
INSERT INTO `t_sys_premission` VALUES ('5946910264304599042', '电子邮件添加', '电子邮件添加', '/EmailController/add', 0, '594691026430459904', 'system:email:add', 2, 'entypo-plus-squared', NULL);
INSERT INTO `t_sys_premission` VALUES ('5946910264304599043', '电子邮件删除', '电子邮件删除', '/EmailController/remove', 0, '594691026430459904', 'system:email:remove', 2, 'entypo-trash', NULL);
INSERT INTO `t_sys_premission` VALUES ('5946910264304599044', '电子邮件修改', '电子邮件修改', '/EmailController/edit', 0, '594691026430459904', 'system:email:edit', 2, 'fa fa-wrench', NULL);
INSERT INTO `t_sys_premission` VALUES ('6', '用户添加', '用户添加', '/UserController/add', 0, '4', 'system:user:add', 2, 'entypo-plus-squared', NULL);
INSERT INTO `t_sys_premission` VALUES ('605396101494734848', '数据比对配置', '展示', '/TableConfigController/view', 0, '592059865673760768', 'model:tableConfig:view', 1, 'fa fa-quora', 9);
INSERT INTO `t_sys_premission` VALUES ('6053961014947348481', '集合', '集合', '/TableConfigController/list', 0, '605396101494734848', 'model:tableConfig:list', 2, '', NULL);
INSERT INTO `t_sys_premission` VALUES ('6053961014947348482', '添加', '添加', '/TableConfigController/add', 0, '605396101494734848', 'model:tableConfig:add', 2, 'entypo-plus-squared', NULL);
INSERT INTO `t_sys_premission` VALUES ('6053961014947348483', '删除', '删除', '/TableConfigController/remove', 0, '605396101494734848', 'model:tableConfig:remove', 2, 'entypo-trash', NULL);
INSERT INTO `t_sys_premission` VALUES ('6053961014947348484', '修改', '修改', '/TableConfigController/edit', 0, '605396101494734848', 'model:tableConfig:edit', 2, 'fa fa-wrench', NULL);
INSERT INTO `t_sys_premission` VALUES ('608261152341753856', '日志管理', '展示', '/TableLoggerController/view', 0, '592059865673760768', 'model:tableLogger:view', 1, 'fa fa-quora', NULL);
INSERT INTO `t_sys_premission` VALUES ('6082611523417538561', '集合', '集合', '/TableLoggerController/list', 0, '608261152341753856', 'model:tableLogger:list', 2, '', NULL);
INSERT INTO `t_sys_premission` VALUES ('6082611523417538562', '添加', '添加', '/TableLoggerController/add', 0, '608261152341753856', 'model:tableLogger:add', 2, 'entypo-plus-squared', NULL);
INSERT INTO `t_sys_premission` VALUES ('6082611523417538563', '删除', '删除', '/TableLoggerController/remove', 0, '608261152341753856', 'model:tableLogger:remove', 2, 'entypo-trash', NULL);
INSERT INTO `t_sys_premission` VALUES ('6082611523417538564', '修改', '修改', '/TableLoggerController/edit', 0, '608261152341753856', 'model:tableLogger:edit', 2, 'fa fa-wrench', NULL);
INSERT INTO `t_sys_premission` VALUES ('623932748083494912', '监控看板', '看板', '/TableStatusController/view', 0, '592059865673760768', 'model:tableStatus:view', 1, 'fa fa-quora', NULL);
INSERT INTO `t_sys_premission` VALUES ('6239327480834949121', 'VIEW集合', 'VIEW集合', '/TableStatusController/list', 0, '623932748083494912', 'model:tableStatus:list', 2, '', NULL);
INSERT INTO `t_sys_premission` VALUES ('7', '用户删除', '用户删除', '/UserController/remove', 0, '4', 'system:user:remove', 2, 'entypo-trash', NULL);
INSERT INTO `t_sys_premission` VALUES ('8', '用户修改', '用户修改', '/UserController/edit', 0, '4', 'system:user:edit', 2, 'fa fa-wrench', NULL);
INSERT INTO `t_sys_premission` VALUES ('9', '角色管理', '角色展示', '/RoleController/view', 0, '592059865673760768', 'system:role:view', 1, 'fa fa-group', 2);

-- ----------------------------
-- Table structure for t_sys_role
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_role`;
CREATE TABLE `t_sys_role`  (
                               `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'id',
                               `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色名称',
                               PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_sys_role
-- ----------------------------
INSERT INTO `t_sys_role` VALUES ('488243256161730560', '管理员');
INSERT INTO `t_sys_role` VALUES ('488289006124007424', '用户');
INSERT INTO `t_sys_role` VALUES ('488305788310257664', '能修改用户密码角色');

-- ----------------------------
-- Table structure for t_sys_role_user
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_role_user`;
CREATE TABLE `t_sys_role_user`  (
                                    `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
                                    `sys_user_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'ç”¨æˆ·id',
                                    `sys_role_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色id',
                                    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户角色中间表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_sys_role_user
-- ----------------------------
INSERT INTO `t_sys_role_user` VALUES ('594343820640911360', '488294747442511872', '488289006124007424');
INSERT INTO `t_sys_role_user` VALUES ('598836411377909760', '1', '488243256161730560');

-- ----------------------------
-- Table structure for t_sys_user
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_user`;
CREATE TABLE `t_sys_user`  (
                               `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
                               `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户账号',
                               `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户密码',
                               PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_sys_user
-- ----------------------------
INSERT INTO `t_sys_user` VALUES ('1', 'admin', '21232f297a57a5a743894a0e4a801fc3');

-- ----------------------------
-- Table structure for table_config
-- ----------------------------
DROP TABLE IF EXISTS `table_config`;
CREATE TABLE `table_config`  (
                                 `id` int(11) NOT NULL AUTO_INCREMENT,
                                 `task_name` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
                                 `source_code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '源数据源',
                                 `source_table` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
                                 `source_sql` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
                                 `target_code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '目标数据源',
                                 `target_table` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
                                 `target_sql` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
                                 `start_date` datetime(0) NULL DEFAULT NULL,
                                 `end_date` datetime(0) NULL DEFAULT NULL,
                                 `run_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '增量 / 全量 0:增量，有时间列会增加时间列条件:2:全量，1：区间',
                                 `job_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '任务类型， oralce->hive, hive->gp',
                                 `only_count` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '只统计数据量/ 比对列值 1：只要count值 2:需要比对列值',
                                 `range` int(11) NULL DEFAULT NULL COMMENT '统计的时间范围，用当前时间减去这个值的时间作为开始时间',
                                 `enable` int(1) NULL DEFAULT NULL COMMENT '是否可用',
                                 `end_check` int(1) NULL DEFAULT NULL COMMENT '结束时间的间隔',
                                 PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for table_logger
-- ----------------------------
DROP TABLE IF EXISTS `table_logger`;
CREATE TABLE `table_logger`  (
                                 `id` int(11) NOT NULL AUTO_INCREMENT,
                                 `logger_file` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
                                 `table_id` int(11) NULL DEFAULT NULL,
                                 `source_data` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
                                 `target_data` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
                                 `source_batch` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
                                 `target_batch` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
                                 `start_date` datetime(0) NULL DEFAULT NULL,
                                 `end_date` datetime(0) NULL DEFAULT NULL,
                                 `create_date` datetime(0) NULL DEFAULT NULL,
                                 `status` int(2) NULL DEFAULT NULL COMMENT '状态字段： 0  成功， -1 失败',
                                 `message` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '其他信息',
                                 PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 46 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- View structure for table_status
-- ----------------------------
DROP VIEW IF EXISTS `table_status`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `table_status` AS select `config`.`id` AS `table_id`,`config`.`task_name` AS `task_name`,`config`.`source_code` AS `source_code`,`config`.`source_table` AS `source_table`,`config`.`source_sql` AS `source_sql`,`config`.`target_code` AS `target_code`,`config`.`target_table` AS `target_table`,`config`.`target_sql` AS `target_sql`,`config`.`run_type` AS `run_type`,`config`.`job_type` AS `job_type`,`config`.`only_count` AS `only_count`,`config`.`range` AS `range`,`config`.`end_check` AS `end_check`,`config`.`enable` AS `enable`,`logger`.`id` AS `id`,`logger`.`logger_file` AS `logger_file`,`logger`.`source_data` AS `source_data`,`logger`.`target_data` AS `target_data`,`logger`.`source_batch` AS `source_batch`,`logger`.`target_batch` AS `target_batch`,`logger`.`start_date` AS `start_date`,`logger`.`end_date` AS `end_date`,`logger`.`create_date` AS `create_date`,`logger`.`status` AS `status`,`logger`.`message` AS `message` from (`table_config` `config` left join `table_logger` `logger` on(((`logger`.`table_id` = `config`.`id`) and `logger`.`id` in (select max(`table_logger`.`id`) AS `id` from `table_logger` where (`table_logger`.`create_date` > (now() + interval -(1) month)) group by `table_logger`.`table_id`)))) order by `config`.`id`;

SET FOREIGN_KEY_CHECKS = 1;
