/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50713
Source Host           : localhost:3306
Source Database       : activiti

Target Server Type    : MYSQL
Target Server Version : 50713
File Encoding         : 65001

Date: 2018-09-14 16:24:20
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for j_depart_info
-- ----------------------------
DROP TABLE IF EXISTS `j_depart_info`;
CREATE TABLE `j_depart_info` (
  `depart_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `parent_id` bigint(20) DEFAULT NULL COMMENT '父级部门id',
  `depart_name` varchar(20) NOT NULL COMMENT '部门名称',
  PRIMARY KEY (`depart_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of j_depart_info
-- ----------------------------
INSERT INTO `j_depart_info` VALUES ('1', '0', '杭州笛佛软件');
INSERT INTO `j_depart_info` VALUES ('2', '1', '笛佛软件');
INSERT INTO `j_depart_info` VALUES ('3', '2', '总经办');
INSERT INTO `j_depart_info` VALUES ('4', '3', '开发部');
INSERT INTO `j_depart_info` VALUES ('5', '4', 'OA');
INSERT INTO `j_depart_info` VALUES ('6', '4', 'ERP');
INSERT INTO `j_depart_info` VALUES ('7', '3', '行政部');
INSERT INTO `j_depart_info` VALUES ('8', '1', '笛升科技');
INSERT INTO `j_depart_info` VALUES ('9', '8', '笛升总经办');
INSERT INTO `j_depart_info` VALUES ('10', '9', '笛升开发部');
INSERT INTO `j_depart_info` VALUES ('11', '10', 'XXX组');

-- ----------------------------
-- Table structure for j_depart_position
-- ----------------------------
DROP TABLE IF EXISTS `j_depart_position`;
CREATE TABLE `j_depart_position` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `position_id` int(11) NOT NULL COMMENT '岗位id',
  `depart_id` bigint(20) NOT NULL COMMENT '部门id',
  `depart_name` varchar(20) NOT NULL COMMENT '部门名称',
  `position_name` varchar(255) NOT NULL COMMENT '岗位名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of j_depart_position
-- ----------------------------
INSERT INTO `j_depart_position` VALUES ('1', '1', '3', '总经办', '总经理');
INSERT INTO `j_depart_position` VALUES ('2', '1', '9', '笛升总经办', '总经理');
INSERT INTO `j_depart_position` VALUES ('3', '2', '4', '开发部', '部门经理');
INSERT INTO `j_depart_position` VALUES ('4', '2', '10', '笛升开发部', '部门经理');
INSERT INTO `j_depart_position` VALUES ('5', '3', '5', 'OA', '项目经理');
INSERT INTO `j_depart_position` VALUES ('6', '3', '6', 'ERP', '项目经理');
INSERT INTO `j_depart_position` VALUES ('7', '3', '11', 'XX组', '项目经理');
INSERT INTO `j_depart_position` VALUES ('8', '4', '5', 'OA', '开发');
INSERT INTO `j_depart_position` VALUES ('9', '4', '6', 'ERP', '开发');
INSERT INTO `j_depart_position` VALUES ('10', '4', '11', 'XX组', '开发');
INSERT INTO `j_depart_position` VALUES ('11', '5', '7', '行政部', '人事');

-- ----------------------------
-- Table structure for j_flow_history
-- ----------------------------
DROP TABLE IF EXISTS `j_flow_history`;
CREATE TABLE `j_flow_history` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `business_key` bigint(255) DEFAULT NULL,
  `task_name` varchar(255) DEFAULT NULL COMMENT '处理步骤',
  `operate_time` varchar(255) DEFAULT NULL,
  `operate_department` varchar(255) DEFAULT NULL,
  `operator` varchar(255) DEFAULT NULL,
  `comment` varchar(255) DEFAULT NULL,
  `gmt_create` datetime DEFAULT CURRENT_TIMESTAMP,
  `gmt_modified` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=176 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of j_flow_history
-- ----------------------------

-- ----------------------------
-- Table structure for j_form
-- ----------------------------
DROP TABLE IF EXISTS `j_form`;
CREATE TABLE `j_form` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `flow_id` bigint(20) DEFAULT NULL,
  `apply_time` varchar(255) DEFAULT NULL,
  `start_time` varchar(255) DEFAULT NULL,
  `end_time` varchar(255) DEFAULT NULL,
  `days` float DEFAULT NULL,
  `memo` varchar(255) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户ID',
  `status` int(11) DEFAULT NULL COMMENT ' /** 1审批中 2 已经审批 3 驳回 **/',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=187 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of j_form
-- ----------------------------

-- ----------------------------
-- Table structure for j_oa_flow
-- ----------------------------
DROP TABLE IF EXISTS `j_oa_flow`;
CREATE TABLE `j_oa_flow` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID自增',
  `flow_id` bigint(20) DEFAULT NULL COMMENT '流程ID',
  `flow_name` varchar(50) DEFAULT NULL COMMENT '流程名称',
  `flow_description` varchar(255) DEFAULT NULL COMMENT '流程说明',
  `processkey` varchar(100) DEFAULT NULL COMMENT 'bpmn文件 process id',
  `gmt_create` datetime DEFAULT CURRENT_TIMESTAMP,
  `gmt_modified` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of j_oa_flow
-- ----------------------------
INSERT INTO `j_oa_flow` VALUES ('24', '439705070314055552', '程前请假流程', '', null, '2018-08-30 16:15:30', '2018-08-30 16:15:30');
INSERT INTO `j_oa_flow` VALUES ('26', '439706637809346432', '请假流程测试试试试试试', '测试请假', null, '2018-08-30 16:18:37', '2018-08-30 16:18:37');
INSERT INTO `j_oa_flow` VALUES ('28', '439750890124058496', '测试审批', '测试试试试试试试试', '439758075570790272', '2018-08-30 17:46:31', '2018-08-30 18:00:48');
INSERT INTO `j_oa_flow` VALUES ('29', '439766986805864320', '请假流程111', '黄毅测试', null, '2018-08-30 18:18:31', '2018-08-30 19:33:04');
INSERT INTO `j_oa_flow` VALUES ('30', '439785855721250688', 'wqe', 'wqeq', null, '2018-08-30 18:55:59', '2018-08-30 18:55:59');
INSERT INTO `j_oa_flow` VALUES ('31', '439804645406271360', '请假流程', '请假流程001', '1536653930361', '2018-08-30 19:33:21', '2018-09-11 16:18:50');
INSERT INTO `j_oa_flow` VALUES ('33', '440269177920528256', '演示-请假流程', '不要删除', '1536825673504', '2018-08-31 10:56:16', '2018-09-13 16:01:13');
INSERT INTO `j_oa_flow` VALUES ('34', '20180914', '程前并行网关测试', null, '1536904748952', '2018-09-14 09:10:38', '2018-09-14 13:59:08');

-- ----------------------------
-- Table structure for j_oa_flow_node
-- ----------------------------
DROP TABLE IF EXISTS `j_oa_flow_node`;
CREATE TABLE `j_oa_flow_node` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '流程节点ID自增',
  `serial_num` int(11) DEFAULT NULL COMMENT '序列号',
  `node_id` bigint(20) DEFAULT '0' COMMENT '节点ID',
  `flow_id` bigint(20) DEFAULT '0' COMMENT '流程ID',
  `node_name` varchar(255) DEFAULT NULL COMMENT '节点名称',
  `category` int(4) DEFAULT '0' COMMENT '类别(开始事件 1 用户任务 2 排它网关 3  结束事件10)',
  `is_approve` int(4) DEFAULT '1' COMMENT '是否审核本部门及下属部门 0否，1是',
  `participant` int(11) DEFAULT NULL COMMENT '参与者',
  `gmt_create` datetime DEFAULT CURRENT_TIMESTAMP,
  `gmt_modified` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=195 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of j_oa_flow_node
-- ----------------------------
INSERT INTO `j_oa_flow_node` VALUES ('112', null, '439705070322444160', '439705070314055552', '开始节点', '1', '1', null, '2018-08-30 16:15:30', '2018-08-30 19:13:04');
INSERT INTO `j_oa_flow_node` VALUES ('113', null, '439705070372775808', '439705070314055552', '结束节点', '10', '1', null, '2018-08-30 16:15:30', '2018-08-30 19:12:29');
INSERT INTO `j_oa_flow_node` VALUES ('114', null, '439705392084281216', '439705070314055552', '程前申请请假单', '2', null, '4', '2018-08-30 16:16:09', '2018-08-30 19:13:01');
INSERT INTO `j_oa_flow_node` VALUES ('117', null, '439705654437996416', '439705070314055552', '主管审批请假单', '2', null, '3', '2018-08-30 16:16:40', '2018-08-30 19:12:38');
INSERT INTO `j_oa_flow_node` VALUES ('118', null, '439705864119641984', '439705070314055552', '部门经理审批请假单', '2', null, '2', '2018-08-30 16:17:05', '2018-08-30 19:12:35');
INSERT INTO `j_oa_flow_node` VALUES ('119', null, '439706002649114497', '439705070314055552', '总经理审批请假单', '2', null, '1', '2018-08-30 16:17:21', '2018-08-30 19:12:32');
INSERT INTO `j_oa_flow_node` VALUES ('120', null, '439706097348110209', '439705070314055552', '人事备案', '2', null, '5', '2018-08-30 16:17:33', '2018-08-30 19:12:31');
INSERT INTO `j_oa_flow_node` VALUES ('121', null, '439706273039116160', '439705070314055552', '岗位识别网关', '3', '1', null, '2018-08-30 16:17:54', '2018-08-30 19:12:45');
INSERT INTO `j_oa_flow_node` VALUES ('122', null, '439706421844633472', '439705070314055552', '主管审批网关', '3', '1', null, '2018-08-30 16:18:11', '2018-08-30 19:12:37');
INSERT INTO `j_oa_flow_node` VALUES ('123', null, '439706520402388864', '439705070314055552', '部门经理审批网关', '3', '1', null, '2018-08-30 16:18:23', '2018-08-30 19:12:34');
INSERT INTO `j_oa_flow_node` VALUES ('124', '1', '439706637809346433', '439706637809346432', '开始节点', '1', '1', null, '2018-08-30 16:18:37', '2018-08-30 17:18:17');
INSERT INTO `j_oa_flow_node` VALUES ('125', '10', '439706637842900864', '439706637809346432', '结束节点', '10', '1', null, '2018-08-30 16:18:37', '2018-08-30 17:21:03');
INSERT INTO `j_oa_flow_node` VALUES ('129', '2', '439734686009368448', '439706637809346432', '填写请假单', '2', null, '4', '2018-08-30 17:14:20', '2018-08-30 17:18:35');
INSERT INTO `j_oa_flow_node` VALUES ('131', '4', '439735624702992256', '439706637809346432', '组长审批', '2', null, '3', '2018-08-30 17:16:11', '2018-08-30 17:19:31');
INSERT INTO `j_oa_flow_node` VALUES ('132', '6', '439736000906895232', '439706637809346432', '部门经理审批', '2', null, '2', '2018-08-30 17:16:56', '2018-08-30 17:20:09');
INSERT INTO `j_oa_flow_node` VALUES ('133', '8', '439736127935586176', '439706637809346432', '总经理审批', '2', null, '1', '2018-08-30 17:17:11', '2018-08-30 17:20:27');
INSERT INTO `j_oa_flow_node` VALUES ('134', '9', '439736229345468288', '439706637809346432', '人事备案', '2', null, '5', '2018-08-30 17:17:23', '2018-08-30 17:20:37');
INSERT INTO `j_oa_flow_node` VALUES ('135', '3', '439736372958437248', '439706637809346432', '填写请假单网关', '3', '1', null, '2018-08-30 17:17:41', '2018-08-30 17:18:43');
INSERT INTO `j_oa_flow_node` VALUES ('136', '5', '439736522770587520', '439706637809346432', '组长审批网关', '3', '1', null, '2018-08-30 17:17:58', '2018-08-30 17:20:00');
INSERT INTO `j_oa_flow_node` VALUES ('137', '7', '439736601791274880', '439706637809346432', '部门经理审批网关', '3', '1', null, '2018-08-30 17:18:08', '2018-08-30 17:20:18');
INSERT INTO `j_oa_flow_node` VALUES ('138', '1', '439750890132447104', '439750890124058496', '开始节点', '1', '1', null, '2018-08-30 17:46:31', '2018-08-30 17:47:17');
INSERT INTO `j_oa_flow_node` VALUES ('139', '4', '439750890207944576', '439750890124058496', '结束节点', '10', '1', null, '2018-08-30 17:46:31', '2018-08-30 17:48:14');
INSERT INTO `j_oa_flow_node` VALUES ('140', '2', '439751095150026624', '439750890124058496', '填写请假单', '2', '1', null, '2018-08-30 17:46:56', '2018-08-30 17:47:37');
INSERT INTO `j_oa_flow_node` VALUES ('141', '3', '439751172652375936', '439750890124058496', '人事备案', '2', '1', '5', '2018-08-30 17:47:05', '2018-08-30 18:04:34');
INSERT INTO `j_oa_flow_node` VALUES ('142', '1', '439766986805864321', '439766986805864320', '开始节点', '1', '1', null, '2018-08-30 18:18:31', '2018-08-30 18:23:42');
INSERT INTO `j_oa_flow_node` VALUES ('143', null, '439766986965247872', '439766986805864320', '结束节点', '10', '1', null, '2018-08-30 18:18:31', '2018-08-30 18:18:31');
INSERT INTO `j_oa_flow_node` VALUES ('144', '2', '439767725959669632', '439766986805864320', '申请请假单', '2', null, '4', '2018-08-30 18:20:00', '2018-08-30 18:30:51');
INSERT INTO `j_oa_flow_node` VALUES ('145', null, '439767862710757248', '439766986805864320', '岗位网关', '3', '1', null, '2018-08-30 18:20:16', '2018-08-30 19:11:01');
INSERT INTO `j_oa_flow_node` VALUES ('150', null, '439769244775868288', '439766986805864320', '组长审批网关', '3', '1', null, '2018-08-30 18:23:01', '2018-08-30 18:23:01');
INSERT INTO `j_oa_flow_node` VALUES ('151', null, '439769403287005056', '439766986805864320', '部门经理审批网关', '3', '1', null, '2018-08-30 18:23:19', '2018-08-30 18:23:19');
INSERT INTO `j_oa_flow_node` VALUES ('152', null, '439785855729639296', '439785855721250688', '开始节点', '1', '1', null, '2018-08-30 18:55:59', '2018-08-30 18:55:59');
INSERT INTO `j_oa_flow_node` VALUES ('153', null, '439785855805136768', '439785855721250688', '结束节点', '10', '1', null, '2018-08-30 18:55:59', '2018-08-30 18:55:59');
INSERT INTO `j_oa_flow_node` VALUES ('154', null, '439786543889115008', '439766986805864320', '组长审批', '2', null, '3', '2018-08-30 18:57:23', '2018-08-30 18:57:23');
INSERT INTO `j_oa_flow_node` VALUES ('155', null, '439787044085032832', '439766986805864320', '部门经理审批', '2', null, '2', '2018-08-30 18:58:22', '2018-08-30 18:58:22');
INSERT INTO `j_oa_flow_node` VALUES ('156', null, '439789739982317440', '439766986805864320', '总经理审批', '2', null, '1', '2018-08-30 19:03:44', '2018-08-30 19:03:44');
INSERT INTO `j_oa_flow_node` VALUES ('157', null, '439790633679447936', '439766986805864320', '人事备案', '2', null, '5', '2018-08-30 19:05:30', '2018-08-30 19:05:30');
INSERT INTO `j_oa_flow_node` VALUES ('159', '1', '439804645406271361', '439804645406271360', '开始节点', '1', '1', null, '2018-08-30 19:33:21', '2018-08-30 19:40:29');
INSERT INTO `j_oa_flow_node` VALUES ('160', '10', '439804645473380224', '439804645406271360', '结束节点', '10', '1', null, '2018-08-30 19:33:21', '2018-08-30 19:44:16');
INSERT INTO `j_oa_flow_node` VALUES ('161', '2', '439805108038002560', '439804645406271360', '填写请假单', '2', null, '4', '2018-08-30 19:34:16', '2018-08-30 19:41:43');
INSERT INTO `j_oa_flow_node` VALUES ('162', '4', '439805436804327296', '439804645406271360', '组长审批', '2', null, '3', '2018-08-30 19:34:55', '2018-08-30 19:43:03');
INSERT INTO `j_oa_flow_node` VALUES ('163', '6', '439805548490254208', '439804645406271360', '部门经理审批', '2', null, '2', '2018-08-30 19:35:08', '2018-08-30 19:43:28');
INSERT INTO `j_oa_flow_node` VALUES ('164', '8', '439805693638338433', '439804645406271360', '总经理审批', '2', null, '1', '2018-08-30 19:35:26', '2018-08-30 19:43:55');
INSERT INTO `j_oa_flow_node` VALUES ('165', '9', '439805818997696384', '439804645406271360', '人事备案', '2', null, '5', '2018-08-30 19:35:41', '2018-08-30 19:44:05');
INSERT INTO `j_oa_flow_node` VALUES ('166', '3', '439806015945435008', '439804645406271360', '填写网关', '4', '1', null, '2018-08-30 19:36:04', '2018-09-11 15:59:45');
INSERT INTO `j_oa_flow_node` VALUES ('167', '5', '439806116734560128', '439804645406271360', '请假三天网关', '3', '1', null, '2018-08-30 19:36:16', '2018-08-30 19:43:12');
INSERT INTO `j_oa_flow_node` VALUES ('168', '7', '439806191040849792', '439804645406271360', '请假十天网关', '3', '1', null, '2018-08-30 19:36:25', '2018-08-30 19:43:42');
INSERT INTO `j_oa_flow_node` VALUES ('172', '1', '440269177928916864', '440269177920528256', '开始节点', '1', '1', null, '2018-08-31 10:56:16', '2018-08-31 11:02:18');
INSERT INTO `j_oa_flow_node` VALUES ('173', '10', '440269178004414336', '440269177920528256', '结束节点', '10', '1', null, '2018-08-31 10:56:16', '2018-08-31 11:08:40');
INSERT INTO `j_oa_flow_node` VALUES ('174', '2', '440270019650232192', '440269177920528256', '填写请假单', '2', '1', null, '2018-08-31 10:57:56', '2018-08-31 11:02:29');
INSERT INTO `j_oa_flow_node` VALUES ('175', '4', '440270207773155200', '440269177920528256', '组长审批', '2', null, '3', '2018-08-31 10:58:19', '2018-08-31 11:03:02');
INSERT INTO `j_oa_flow_node` VALUES ('176', '6', '440270459968266112', '440269177920528256', '部门经理审批', '2', null, '2', '2018-08-31 10:58:49', '2018-08-31 11:07:36');
INSERT INTO `j_oa_flow_node` VALUES ('177', '8', '440270581779242880', '440269177920528256', '总经理审批', '2', null, '1', '2018-08-31 10:59:03', '2018-08-31 11:08:03');
INSERT INTO `j_oa_flow_node` VALUES ('178', '9', '440270713463611265', '440269177920528256', '人事备案', '2', null, '5', '2018-08-31 10:59:19', '2018-08-31 11:08:15');
INSERT INTO `j_oa_flow_node` VALUES ('179', '3', '440270965138628481', '440269177920528256', '填写分流', '3', '1', null, '2018-08-31 10:59:49', '2018-09-13 15:59:16');
INSERT INTO `j_oa_flow_node` VALUES ('181', '5', '440271676794576768', '440269177920528256', '组长审批分流', '4', '1', null, '2018-08-31 11:01:14', '2018-09-13 15:59:20');
INSERT INTO `j_oa_flow_node` VALUES ('182', '7', '440271783548002176', '440269177920528256', '部门审批分流', '3', '1', null, '2018-08-31 11:01:27', '2018-08-31 11:07:47');
INSERT INTO `j_oa_flow_node` VALUES ('183', '1', '1', '20180914', '开始节点', '1', '1', null, '2018-08-31 10:56:16', '2018-08-31 11:02:18');
INSERT INTO `j_oa_flow_node` VALUES ('184', '10', '2', '20180914', '结束节点', '10', '1', null, '2018-08-31 10:56:16', '2018-09-14 09:03:24');
INSERT INTO `j_oa_flow_node` VALUES ('185', '2', '3', '20180914', '申请资金', '2', null, '4', '2018-08-30 19:34:16', '2018-09-14 13:44:14');
INSERT INTO `j_oa_flow_node` VALUES ('186', '3', '4', '20180914', '排他分流', '3', '1', null, '2018-08-31 10:59:49', '2018-09-14 13:45:43');
INSERT INTO `j_oa_flow_node` VALUES ('187', '4', '5', '20180914', '组长审批', '2', null, '3', '2018-08-31 10:58:19', '2018-09-14 09:05:43');
INSERT INTO `j_oa_flow_node` VALUES ('188', '5', '6', '20180914', '部门经理审批', '2', null, '2', '2018-08-30 19:34:55', '2018-09-14 09:07:22');
INSERT INTO `j_oa_flow_node` VALUES ('189', '6', '7', '20180914', '并行分流', '4', '1', null, '2018-08-31 10:59:49', '2018-09-14 13:46:57');
INSERT INTO `j_oa_flow_node` VALUES ('190', '7', '8', '20180914', '总经理审批', '2', null, '1', '2018-08-30 19:35:26', '2018-09-14 09:08:37');
INSERT INTO `j_oa_flow_node` VALUES ('191', '8', '9', '20180914', '人事审批', '2', null, '5', '2018-08-30 19:35:26', '2018-09-14 13:47:29');
INSERT INTO `j_oa_flow_node` VALUES ('192', '5', '10', '20180914', '部门经理审批', '2', null, '2', '2018-08-30 19:34:55', '2018-09-14 13:46:36');
INSERT INTO `j_oa_flow_node` VALUES ('193', '6', '11', '20180914', '并行合流', '4', '1', null, '2018-08-31 10:59:49', '2018-09-14 13:46:57');
INSERT INTO `j_oa_flow_node` VALUES ('194', '8', '12', '20180914', '人事备案', '2', null, '5', '2018-08-30 19:35:26', '2018-09-14 13:48:52');

-- ----------------------------
-- Table structure for j_oa_node_condition
-- ----------------------------
DROP TABLE IF EXISTS `j_oa_node_condition`;
CREATE TABLE `j_oa_node_condition` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `node_id` bigint(11) DEFAULT '0' COMMENT '节点ID',
  `next_node_id` bigint(20) DEFAULT NULL COMMENT '下一节点ID',
  `form_attribute` varchar(50) DEFAULT '' COMMENT '表单字段',
  `operate_condition` varchar(50) DEFAULT NULL COMMENT '表单属性操作符 > ,<, >=, <=, =',
  `form_value` varchar(255) DEFAULT NULL COMMENT '表单属性值',
  `gmt_create` datetime DEFAULT CURRENT_TIMESTAMP,
  `gmt_modified` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=241 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of j_oa_node_condition
-- ----------------------------
INSERT INTO `j_oa_node_condition` VALUES ('164', '439736372958437248', '439735624702992256', 'positionId', '==', '4', '2018-08-30 17:36:43', '2018-08-30 17:37:46');
INSERT INTO `j_oa_node_condition` VALUES ('165', '439736372958437248', '439736000906895232', 'positionId', '==', '3', '2018-08-30 17:38:23', '2018-08-30 17:38:23');
INSERT INTO `j_oa_node_condition` VALUES ('166', '439736372958437248', '439736127935586176', 'positionId', '==', '2', '2018-08-30 17:38:53', '2018-08-30 17:38:53');
INSERT INTO `j_oa_node_condition` VALUES ('167', '439736522770587520', '439736000906895232', 'days', '>', '3', '2018-08-30 17:39:50', '2018-08-30 17:39:50');
INSERT INTO `j_oa_node_condition` VALUES ('168', '439736522770587520', '439736229345468288', 'days', '<=', '3', '2018-08-30 17:40:39', '2018-08-30 17:40:39');
INSERT INTO `j_oa_node_condition` VALUES ('169', '439706637809346433', '439734686009368448', '', null, '', '2018-08-30 17:41:37', '2018-08-30 17:41:37');
INSERT INTO `j_oa_node_condition` VALUES ('170', '439750890132447104', '439751095150026624', '', null, null, '2018-08-30 17:49:10', '2018-08-30 17:49:10');
INSERT INTO `j_oa_node_condition` VALUES ('171', '439751095150026624', '439751172652375936', '', null, null, '2018-08-30 17:50:28', '2018-08-30 17:50:28');
INSERT INTO `j_oa_node_condition` VALUES ('172', '439751172652375936', '439750890207944576', '', null, null, '2018-08-30 17:51:19', '2018-08-30 17:51:19');
INSERT INTO `j_oa_node_condition` VALUES ('173', '439734686009368448', '439736372958437248', '', '', '', '2018-08-30 18:11:49', '2018-08-30 18:11:49');
INSERT INTO `j_oa_node_condition` VALUES ('174', '439735624702992256', '439736522770587520', '', '', '', '2018-08-30 18:12:34', '2018-08-30 18:12:34');
INSERT INTO `j_oa_node_condition` VALUES ('175', '439766986805864321', '439767725959669632', '', '', '', '2018-08-30 18:31:10', '2018-08-30 18:31:10');
INSERT INTO `j_oa_node_condition` VALUES ('187', '439767725959669632', '439767862710757248', '', '', '', '2018-08-30 19:01:27', '2018-08-30 19:01:27');
INSERT INTO `j_oa_node_condition` VALUES ('191', '439804645406271361', '439805108038002560', '', '', '', '2018-08-30 19:46:02', '2018-08-30 19:46:02');
INSERT INTO `j_oa_node_condition` VALUES ('192', '439805108038002560', '439806015945435008', '', '', '', '2018-08-30 19:46:44', '2018-08-30 19:46:44');
INSERT INTO `j_oa_node_condition` VALUES ('193', '439806015945435008', '439805436804327296', '', '', '', '2018-08-30 19:47:13', '2018-09-11 15:59:26');
INSERT INTO `j_oa_node_condition` VALUES ('194', '439806015945435008', '439805548490254208', '', '', '', '2018-08-30 19:47:50', '2018-09-11 15:59:27');
INSERT INTO `j_oa_node_condition` VALUES ('195', '439806015945435008', '439805693638338433', '', '', '', '2018-08-30 19:48:16', '2018-09-11 15:59:29');
INSERT INTO `j_oa_node_condition` VALUES ('196', '439805436804327296', '439806116734560128', '', '', '', '2018-08-30 19:48:38', '2018-08-30 19:48:38');
INSERT INTO `j_oa_node_condition` VALUES ('197', '439734686009368448', '439706637809346433', 'days', '<', '11', '2018-08-30 19:53:06', '2018-08-30 19:53:06');
INSERT INTO `j_oa_node_condition` VALUES ('198', '439806116734560128', '439805548490254208', 'days', '>', '3', '2018-08-30 19:53:43', '2018-08-30 19:53:43');
INSERT INTO `j_oa_node_condition` VALUES ('199', '439806116734560128', '439805818997696384', 'days', '<=', '3', '2018-08-30 19:54:07', '2018-08-30 19:54:07');
INSERT INTO `j_oa_node_condition` VALUES ('200', '439805548490254208', '439806191040849792', '', '', '', '2018-08-30 19:54:22', '2018-08-30 19:54:22');
INSERT INTO `j_oa_node_condition` VALUES ('201', '439806191040849792', '439805693638338433', 'days', '>', '10', '2018-08-30 19:54:47', '2018-08-30 19:54:47');
INSERT INTO `j_oa_node_condition` VALUES ('202', '439806191040849792', '439805818997696384', 'days', '<=', '10', '2018-08-30 19:55:06', '2018-08-30 19:55:06');
INSERT INTO `j_oa_node_condition` VALUES ('203', '439805693638338433', '439805818997696384', '', '', '', '2018-08-30 19:55:20', '2018-08-30 19:55:20');
INSERT INTO `j_oa_node_condition` VALUES ('204', '439805818997696384', '439804645473380224', '', '', '', '2018-08-30 19:55:34', '2018-08-30 19:55:34');
INSERT INTO `j_oa_node_condition` VALUES ('205', '439736229345468288', '439706637809346433', 'positionId', '==', '2', '2018-08-30 20:19:23', '2018-08-30 20:19:23');
INSERT INTO `j_oa_node_condition` VALUES ('206', '440269177928916864', '440270019650232192', '', '', '', '2018-08-31 11:09:04', '2018-08-31 11:09:04');
INSERT INTO `j_oa_node_condition` VALUES ('207', '440270019650232192', '440270965138628481', '', '', '', '2018-08-31 11:09:24', '2018-08-31 11:09:24');
INSERT INTO `j_oa_node_condition` VALUES ('208', '440270965138628481', '440270207773155200', 'positionId', '==', '4', '2018-08-31 11:10:05', '2018-08-31 11:10:05');
INSERT INTO `j_oa_node_condition` VALUES ('209', '440270965138628481', '440270459968266112', 'positionId', '==', '3', '2018-08-31 11:10:24', '2018-08-31 11:10:24');
INSERT INTO `j_oa_node_condition` VALUES ('210', '440270965138628481', '440270581779242880', 'positionId', '==', '2', '2018-08-31 11:10:41', '2018-08-31 11:10:41');
INSERT INTO `j_oa_node_condition` VALUES ('211', '440270207773155200', '440271676794576768', '', '', '', '2018-08-31 11:12:25', '2018-08-31 11:12:25');
INSERT INTO `j_oa_node_condition` VALUES ('212', '440271676794576768', '440270459968266112', 'days', '>', '3', '2018-08-31 11:13:27', '2018-08-31 11:13:27');
INSERT INTO `j_oa_node_condition` VALUES ('213', '440271676794576768', '440270713463611265', 'days', '<=', '3', '2018-08-31 11:13:49', '2018-08-31 11:13:49');
INSERT INTO `j_oa_node_condition` VALUES ('214', '440270459968266112', '440271783548002176', '', '', '', '2018-08-31 11:14:20', '2018-08-31 11:14:20');
INSERT INTO `j_oa_node_condition` VALUES ('215', '440271783548002176', '440270581779242880', 'days', '>', '10', '2018-08-31 11:14:47', '2018-08-31 11:14:47');
INSERT INTO `j_oa_node_condition` VALUES ('216', '440271783548002176', '440270713463611265', 'days', '<=', '10', '2018-08-31 11:15:05', '2018-08-31 11:15:05');
INSERT INTO `j_oa_node_condition` VALUES ('217', '440270581779242880', '440270713463611265', '', '', '', '2018-08-31 11:15:15', '2018-08-31 11:15:15');
INSERT INTO `j_oa_node_condition` VALUES ('218', '440270713463611265', '440269178004414336', '', '', '', '2018-08-31 11:15:25', '2018-08-31 11:16:10');
INSERT INTO `j_oa_node_condition` VALUES ('228', '1', '3', '', null, null, '2018-09-14 13:50:36', '2018-09-14 13:50:36');
INSERT INTO `j_oa_node_condition` VALUES ('229', '3', '5', '', null, null, '2018-09-14 13:50:50', '2018-09-14 13:50:50');
INSERT INTO `j_oa_node_condition` VALUES ('230', '5', '4', '', null, null, '2018-09-14 13:50:56', '2018-09-14 13:50:56');
INSERT INTO `j_oa_node_condition` VALUES ('231', '4', '6', 'days', '>', '10', '2018-09-14 13:51:07', '2018-09-14 13:56:54');
INSERT INTO `j_oa_node_condition` VALUES ('232', '4', '7', 'days', '<=', '10', '2018-09-14 13:51:19', '2018-09-14 13:57:04');
INSERT INTO `j_oa_node_condition` VALUES ('233', '6', '8', '', null, null, '2018-09-14 13:51:49', '2018-09-14 13:51:49');
INSERT INTO `j_oa_node_condition` VALUES ('234', '7', '10', '', null, null, '2018-09-14 13:51:58', '2018-09-14 13:51:58');
INSERT INTO `j_oa_node_condition` VALUES ('235', '7', '9', '', null, null, '2018-09-14 13:52:18', '2018-09-14 13:52:18');
INSERT INTO `j_oa_node_condition` VALUES ('236', '10', '11', '', null, null, '2018-09-14 13:52:35', '2018-09-14 13:52:35');
INSERT INTO `j_oa_node_condition` VALUES ('237', '9', '11', '', null, null, '2018-09-14 13:52:44', '2018-09-14 13:52:44');
INSERT INTO `j_oa_node_condition` VALUES ('238', '11', '8', '', null, null, '2018-09-14 13:53:10', '2018-09-14 13:53:10');
INSERT INTO `j_oa_node_condition` VALUES ('239', '8', '12', '', null, null, '2018-09-14 13:53:25', '2018-09-14 13:53:25');
INSERT INTO `j_oa_node_condition` VALUES ('240', '12', '2', '', null, null, '2018-09-14 13:53:30', '2018-09-14 13:53:30');

-- ----------------------------
-- Table structure for j_position_info
-- ----------------------------
DROP TABLE IF EXISTS `j_position_info`;
CREATE TABLE `j_position_info` (
  `position_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '岗位id',
  `position_name` varchar(255) NOT NULL COMMENT '岗位名称',
  `postition_functional` varchar(255) DEFAULT NULL COMMENT '岗位描述',
  PRIMARY KEY (`position_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of j_position_info
-- ----------------------------
INSERT INTO `j_position_info` VALUES ('1', '总经理', null);
INSERT INTO `j_position_info` VALUES ('2', '部门经理', null);
INSERT INTO `j_position_info` VALUES ('3', '项目经理', null);
INSERT INTO `j_position_info` VALUES ('4', '开发', null);
INSERT INTO `j_position_info` VALUES ('5', '人事', null);

-- ----------------------------
-- Table structure for j_user
-- ----------------------------
DROP TABLE IF EXISTS `j_user`;
CREATE TABLE `j_user` (
  `user_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '用户id',
  `user_name` varchar(100) NOT NULL COMMENT '用户名',
  `password` varchar(100) NOT NULL COMMENT '密码',
  `email` varchar(50) DEFAULT NULL COMMENT '邮箱',
  `mobile` varchar(20) DEFAULT NULL COMMENT '手机',
  `real_name` varchar(20) DEFAULT NULL COMMENT '姓名',
  `main_depart_id` bigint(20) DEFAULT NULL COMMENT '主部门id',
  `main_depart_name` varchar(20) DEFAULT NULL COMMENT '主部门名称',
  `position_id` int(11) NOT NULL COMMENT '岗位id',
  `position_name` varchar(255) NOT NULL COMMENT '岗位名称',
  `leader_depart_id` bigint(20) DEFAULT NULL COMMENT '上级主管部门id',
  `leader_depart_name` varchar(255) DEFAULT NULL COMMENT '上级主管部门名称',
  `leader_user_id` bigint(20) DEFAULT NULL COMMENT '上级主管id',
  `leader_user_name` varchar(255) DEFAULT NULL COMMENT '上级主管姓名id',
  `leader_position_id` int(11) DEFAULT NULL COMMENT '上级主管岗位id',
  `leader_positon_name` varchar(255) DEFAULT NULL COMMENT '上级主管岗位名称',
  `gmt_create` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of j_user
-- ----------------------------
INSERT INTO `j_user` VALUES ('1', '张三', '123', null, null, null, '5', 'OA', '4', '开发 ', null, null, null, null, null, null, '2018-08-29 16:39:43', '2018-08-31 11:50:20');
INSERT INTO `j_user` VALUES ('2', '李四', '123', null, null, null, '6', 'ERP', '4', '开发', null, null, null, null, null, null, '2018-08-29 17:58:52', '2018-08-31 11:50:37');
INSERT INTO `j_user` VALUES ('3', '王五', '123', null, null, null, '5', 'OA', '3', '项目经理', null, null, null, null, null, null, '2018-08-29 17:59:35', '2018-08-31 11:50:50');
INSERT INTO `j_user` VALUES ('4', '赵六', '123', '', '', '', '6', 'ERP', '3', '项目经理', null, '', null, '', null, '', '2018-08-29 17:59:35', '2018-08-31 11:51:01');
INSERT INTO `j_user` VALUES ('5', '刘大', '123', null, null, null, '4', '开发部', '2', '部门经理', null, null, null, null, null, null, '2018-08-29 18:03:08', '2018-08-31 11:51:14');
INSERT INTO `j_user` VALUES ('6', '张总', '123', null, null, null, '7', '行政部', '5', '人事', null, null, null, null, null, null, '2018-08-29 18:04:05', '2018-08-31 11:51:26');
INSERT INTO `j_user` VALUES ('7', '刘总', '123', null, null, null, '3', '总经办', '1', '总经理', null, null, null, null, null, null, '2018-08-31 11:48:49', '2018-08-31 11:51:39');
INSERT INTO `j_user` VALUES ('8', '小周', '123', null, null, null, '11', 'XX组', '3', '项目经理', null, null, null, null, null, null, '2018-08-31 11:49:12', '2018-08-31 11:52:06');
INSERT INTO `j_user` VALUES ('9', '小王', '123', null, null, null, '11', 'XX组', '4', '开发', null, null, null, null, null, null, '2018-08-31 11:49:16', '2018-08-31 11:52:20');

-- ----------------------------
-- Table structure for j_user_flow
-- ----------------------------
DROP TABLE IF EXISTS `j_user_flow`;
CREATE TABLE `j_user_flow` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `business_key` bigint(20) DEFAULT NULL COMMENT '业务key',
  `user_id` bigint(20) DEFAULT NULL,
  `flow_id` bigint(20) DEFAULT NULL,
  `form_id` bigint(20) DEFAULT NULL,
  `next_node_id` varchar(40) DEFAULT NULL,
  `gmt_create` datetime DEFAULT CURRENT_TIMESTAMP,
  `gmt_modified` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `participant_user_id` bigint(20) DEFAULT NULL COMMENT '参与者用户ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=71 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of j_user_flow
-- ----------------------------
