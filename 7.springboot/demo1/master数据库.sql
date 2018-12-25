/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50713
Source Host           : localhost:3306
Source Database       : master

Target Server Type    : MYSQL
Target Server Version : 50713
File Encoding         : 65001

Date: 2018-11-19 22:31:08
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for j_oa_user
-- ----------------------------
DROP TABLE IF EXISTS `j_oa_user`;
CREATE TABLE `j_oa_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL COMMENT '人员档案id',
  `erp_user_id` bigint(20) DEFAULT NULL COMMENT 'erp用户id',
  `user_no` varchar(20) DEFAULT NULL COMMENT '员工编号',
  `user_name` varchar(20) DEFAULT NULL COMMENT '人员姓名',
  `english_name` varchar(20) DEFAULT NULL COMMENT '花名/英文名',
  `img_url` varchar(2000) DEFAULT NULL COMMENT '用户头像地址',
  `img_key` varchar(255) DEFAULT NULL COMMENT '用户头像key',
  `id_card_type` tinyint(4) DEFAULT '0' COMMENT '证件类型 默认0 0身份证 1护照',
  `id_card_no` varchar(50) DEFAULT NULL COMMENT '证件号',
  `birthdate_type` tinyint(4) DEFAULT '0' COMMENT '出生日期类型 默认0 0阳历 1阴历',
  `birthdate` datetime DEFAULT NULL COMMENT '出生日期',
  `age` tinyint(4) DEFAULT '0' COMMENT '年龄',
  `sex` tinyint(4) DEFAULT '0' COMMENT '性别默认0  男0、女1',
  `user_code` varchar(20) DEFAULT NULL COMMENT '工号（系统账号）',
  `company_id` bigint(20) DEFAULT NULL COMMENT '所属公司ID',
  `company_name` varchar(100) DEFAULT NULL COMMENT '所属公司名称',
  `main_depart_id` bigint(20) DEFAULT NULL COMMENT '主部门ID',
  `main_depart_name` varchar(20) DEFAULT NULL COMMENT '主部门名称',
  `class_id` bigint(20) DEFAULT NULL COMMENT '班组ID',
  `class_name` varchar(100) DEFAULT NULL COMMENT '班组名称',
  `entry_date` datetime DEFAULT NULL COMMENT '入职日期',
  `entry_age` float DEFAULT '0' COMMENT '司龄',
  `probationary_period` tinyint(4) DEFAULT '0' COMMENT '试用期(月)',
  `delay_day` tinyint(4) DEFAULT '0' COMMENT '延迟转正(天)',
  `regular_date` datetime DEFAULT NULL COMMENT '转正日期',
  `leave_date` datetime DEFAULT NULL COMMENT '离职日期',
  `startwork_date` datetime DEFAULT NULL COMMENT '参加工作日期',
  `social_age` float DEFAULT '0' COMMENT '社会工龄',
  `job_category` tinyint(4) DEFAULT '0' COMMENT '任职类型 默认0 全职0、兼职1、实习2',
  `user_category` tinyint(4) DEFAULT '0' COMMENT '人员类别 默认0 正式工0、合同工1、临时工2、退休返聘3、劳务派遣4',
  `marital_status` tinyint(4) DEFAULT '0' COMMENT '婚姻情况 默认0 未婚0、已婚1、离婚2、丧偶3、不详4 ',
  `pregnant_status` tinyint(4) DEFAULT '0' COMMENT '孕育状况 默认0 未育0、已育1',
  `account_category` tinyint(4) DEFAULT '0' COMMENT '户口类别 默认0 本地城镇0、外地城镇1、本地农村2、外地农村3',
  `account_address` varchar(200) DEFAULT NULL COMMENT '户口地址',
  `nation` varchar(100) DEFAULT NULL COMMENT '民族',
  `province` varchar(100) DEFAULT NULL COMMENT '省',
  `city` varchar(100) DEFAULT NULL COMMENT '市',
  `politics_status` tinyint(4) DEFAULT '0' COMMENT '政治面貌 默认0 群众0、共青团员1、中共党员2、中共预备党员3、民主党派4',
  `join_party_date` datetime DEFAULT NULL COMMENT '入党日期',
  `hobby` varchar(200) DEFAULT NULL COMMENT '兴趣爱好',
  `phone` varchar(20) DEFAULT NULL COMMENT '手机号码',
  `QQ` varchar(20) DEFAULT NULL COMMENT 'QQ号',
  `office_phone` varchar(20) DEFAULT NULL COMMENT '办公号码',
  `house_phone` varchar(20) DEFAULT NULL COMMENT '内线电话',
  `mail` varchar(50) DEFAULT NULL COMMENT '邮箱',
  `profile_url` varchar(200) DEFAULT NULL COMMENT '个人网址',
  `address` varchar(200) DEFAULT NULL COMMENT '现居住地址',
  `home_address` varchar(200) DEFAULT NULL COMMENT '家庭地址',
  `physical_date` datetime DEFAULT NULL COMMENT '入职体检日期',
  `train_date` datetime DEFAULT NULL COMMENT '入职培训日期',
  `recruit_type` tinyint(4) DEFAULT '0' COMMENT '网络招聘0、校园招聘1、招聘会2、内推3、猎头4、其他5',
  `push_username` varchar(20) DEFAULT NULL COMMENT '内推人姓名',
  `push_relation` varchar(20) DEFAULT NULL COMMENT '与内推人关系',
  `memo` varchar(100) DEFAULT NULL COMMENT '备注',
  `is_organised` tinyint(4) DEFAULT '0' COMMENT '是否在编 0不在编 1在编',
  `user_status` tinyint(4) DEFAULT '0' COMMENT '人员状态 0在职 1不在职 2停职 3离职 4退休 5借调',
  `file_id` bigint(20) DEFAULT NULL COMMENT '附件ID',
  `is_delete` tinyint(4) DEFAULT '0' COMMENT '是否删除，0未删除，1删除',
  `gmt_create` datetime DEFAULT CURRENT_TIMESTAMP,
  `gmt_modified` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 COMMENT='人员档案基本信息';

-- ----------------------------
-- Records of j_oa_user
-- ----------------------------
INSERT INTO `j_oa_user` VALUES ('3', '1', '1', '1', 'cq', 'check', null, null, '0', '412724199511218334', '0', '2004-11-18 20:12:57', '4', '0', '20181108', '1', '笛佛软件', '411978937005776000', '采购部', '1', 'WMS', '2018-11-01 11:47:08', '0.04', '2', '3', '2018-11-14 11:06:47', '2018-11-01 11:07:49', '2018-09-01 15:44:45', '0.21', '2', '4', '0', '0', '0', '杭州市西湖区三墩镇', '汉', '浙江省', '杭州', '0', '2018-01-08 11:12:00', '抽烟', '1234', '567', '890', '123', '456', '789', '杭州市西湖区三墩镇', '杭州市西湖区三墩镇', '2018-01-08 11:18:12', '2017-01-08 11:18:51', '0', 'cq', '同学', '人员1', '0', '2', '1', '0', '2018-10-31 10:01:07', '2018-11-16 11:00:10');
INSERT INTO `j_oa_user` VALUES ('4', '2', '4', '2', 'xjy', 'xjy', null, null, '0', '127785198001015477', '0', '2018-11-02 17:13:30', '4', '0', '20181109', '2', '笛升科技', '411978937005776000', '采购部', '2', 'OA', '2018-11-08 11:05:59', null, '3', '0', null, '2018-11-02 11:07:57', '2018-02-08 11:08:37', '0.77', '2', '4', '1', '1', '1', '杭州市西湖区三墩镇', '汉', '河南省', '郑州', '0', '2018-02-08 11:12:06', '喝酒', '1235', '678', '901', '234', '567', '890', '杭州市西湖区三墩镇', '杭州市西湖区三墩镇', '2018-02-08 11:18:17', '2017-02-08 11:18:57', '1', 'cq', '朋友', '人员2', '1', '2', '2', '0', '2018-10-31 10:01:38', '2018-11-16 11:00:10');
INSERT INTO `j_oa_user` VALUES ('5', '3', '3', '3', 'xx', 'xx', null, null, '0', '528129198001015524', '0', null, '4', '0', '20181110', '1', '笛佛软件', '2', '架构部', '1', 'WMS', '2018-11-09 11:06:03', null, '4', '0', '2018-08-01 11:07:04', '2018-11-03 11:08:02', '2018-01-08 11:08:44', '0.85', '2', '4', '0', '0', '2', '杭州市西湖区三墩镇', '汉', '河北省', '合肥', '0', '2018-03-08 11:12:09', '烫头', '2345', '678', '901', '234', '567', '890', '杭州市西湖区三墩镇', '杭州市西湖区三墩镇', '2018-08-08 11:18:46', '2017-03-08 11:19:01', '2', 'dd', '亲戚', '人员3', '0', '3', '1', '0', '2018-10-31 10:02:57', '2018-11-16 11:00:10');
INSERT INTO `j_oa_user` VALUES ('6', '1001', '1001', '1001', '张三', 'ThreeZhang', null, null, '0', '528129198001015525', '0', null, '4', '0', '20181111', '1', '笛佛软件', '3', '前端部', '1', 'WMS', '2018-11-10 11:06:07', null, '1', '0', '2018-07-01 11:07:11', '2018-11-04 11:08:07', '2017-01-08 11:08:48', '1.85', '2', '4', '1', '1', '3', '杭州市西湖区三墩镇', '汉', '山东省', '济南', '0', '2018-04-08 11:12:14', '唱歌', '3456', '789', '012', '345', '678', '901', '杭州市西湖区三墩镇', '杭州市西湖区三墩镇', '2018-07-08 11:18:42', '2017-04-08 11:19:06', '3', 'ss', '同学', '人员4', '1', '2', '1', '0', '2018-10-31 16:23:59', '2018-11-16 11:00:10');
INSERT INTO `j_oa_user` VALUES ('7', '1002', '1002', '1002', '李四', 'FourLee', null, null, '0', '528129198001015526', '0', null, '4', '0', '20181112', '2', '笛升科技', '3', '前端部', '2', 'OA', '2018-11-11 11:06:13', null, '2', '0', '2018-06-01 11:07:20', '2018-11-05 11:08:10', '2017-02-08 11:08:54', '1.77', '2', '4', '1', '0', '0', '杭州市西湖区三墩镇', '汉', '陕西省', '甘肃', '0', '2018-05-08 11:12:18', '跳舞', '4567', '890', '123', '456', '789', '012', '杭州市西湖区三墩镇', '杭州市西湖区三墩镇', '2018-06-08 11:18:38', '2017-05-08 11:19:12', '4', 'x', '同学', '人员5', '0', '4', '2', '1', '2018-10-31 16:25:06', '2018-11-16 11:00:10');
INSERT INTO `j_oa_user` VALUES ('8', '1003', '1003', '1003', '王五', 'FiveWin', null, null, '0', '528129198001015527', '0', null, '4', '0', '20181113', '1', '笛佛软件', '1', '开发部', '1', 'WMS', '2018-11-12 11:06:16', null, '3', '0', '2018-05-01 11:07:28', '2018-11-06 11:08:15', '2018-03-08 11:08:59', '0.69', '2', '4', '0', '1', '1', '杭州市西湖区三墩镇', '汉', '山西省', '西安', '0', '2018-06-08 11:12:22', '打豆豆', '5678', '901', '234', '567', '890', '123', '杭州市西湖区三墩镇', '杭州市西湖区三墩镇', '2018-05-08 11:18:33', '2017-06-08 11:19:18', '5', 'ss', '同学', '人员6', '1', '4', '2', '0', '2018-10-31 16:26:04', '2018-11-16 11:00:10');
INSERT INTO `j_oa_user` VALUES ('9', '1004', '1004', '1004', '赵六', 'SixZhao', null, null, '0', '528129198001015528', '0', null, '4', '0', '20181114', '2', '笛升科技', '2', '架构部', '2', 'OA', '2018-11-13 11:06:20', null, '3', '1', null, '2018-11-07 11:08:23', '2017-04-08 11:09:07', '1.61', '2', '4', '1', '0', '2', '杭州市西湖区三墩镇', '汉', '北京市', '北京', '0', '2018-07-08 11:12:26', '睡觉', '6789', '012', '345', '678', '901', '234', '杭州市西湖区三墩镇', '杭州市西湖区三墩镇', '2018-04-08 11:18:27', '2017-07-08 11:19:23', '0', 'd', '同学', '人员7', '0', '4', '1', '0', '2018-10-31 16:27:11', '2018-11-16 11:00:10');
INSERT INTO `j_oa_user` VALUES ('10', '1005', '1005', '1005', '燕七', 'SevenYing', null, null, '0', '528129198001015529', '0', null, '4', '0', '20181115', '2', '笛升科技', '3', '前端部', '2', 'OA', '2018-11-14 11:06:24', null, '1', '2', null, '2018-11-08 11:08:28', '2017-06-08 11:09:14', '1.44', '2', '2', '0', '1', '3', '杭州市西湖区三墩镇', '汉', '上海市', '上海', '0', '2018-08-08 11:12:31', '发呆', '7890', '123', '456', '789', '012', '345', '杭州市西湖区三墩镇', '杭州市西湖区三墩镇', '2018-03-08 11:18:22', '2017-08-08 11:19:28', '0', 'df', '同学', '人员8', '1', '4', '1', '1', '2018-10-31 16:27:57', '2018-11-16 11:43:33');
INSERT INTO `j_oa_user` VALUES ('12', '42', '42', '42', 'jackyun_dev', 'jack', '', '', '0', '528129198001015530', '0', '2018-10-02 09:55:49', '4', '0', '20181115', '2', '笛升科技', '1', '开发部', '2', 'OA', '2018-11-14 11:06:24', null, '2', '3', null, '2018-11-08 11:08:28', '2017-06-08 11:09:14', '1.44', '2', '2', '0', '1', '3', '杭州市西湖区三墩镇', '汉', '上海市', '上海', '0', '2018-08-08 11:12:31', '发呆', '7890', '123', '456', '789', '012', '345', '杭州市西湖区三墩镇', '杭州市西湖区三墩镇', '2018-03-08 11:18:22', '2017-08-08 11:19:28', '0', 'df', '同学', '人员8', '1', '2', '1', '0', '2018-10-31 16:27:57', '2018-11-16 11:00:10');
INSERT INTO `j_oa_user` VALUES ('13', '222', '222', null, 'ying', 'ying', null, null, '0', null, '0', null, '1', '0', null, null, null, null, null, null, null, null, null, '0', '0', null, null, null, '0', '0', '0', '0', '0', '0', null, null, null, null, '0', null, null, null, null, null, null, null, null, null, null, null, null, '0', null, null, null, '0', '0', null, '0', '2018-11-14 16:12:37', '2018-11-16 11:00:10');

-- ----------------------------
-- Table structure for j_oa_user_change_info
-- ----------------------------
DROP TABLE IF EXISTS `j_oa_user_change_info`;
CREATE TABLE `j_oa_user_change_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL COMMENT '人员id',
  `type` tinyint(4) DEFAULT '0' COMMENT '异动类型 0入职，1转正，2离职，3停职，4复职，5调岗，6奖励，7处分，8培训',
  `date` datetime DEFAULT NULL COMMENT '发生时间',
  `file_id` bigint(20) DEFAULT NULL COMMENT '附件ID',
  `memo` varchar(200) DEFAULT NULL COMMENT '备注',
  `gmt_create` datetime DEFAULT CURRENT_TIMESTAMP,
  `gmt_modified` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8 COMMENT='人员档案人事异动';

-- ----------------------------
-- Records of j_oa_user_change_info
-- ----------------------------
INSERT INTO `j_oa_user_change_info` VALUES ('1', '1', '0', '2018-11-01 20:01:18', '1', '沸点的', '2018-11-05 20:01:30', '2018-11-07 17:14:33');
INSERT INTO `j_oa_user_change_info` VALUES ('4', '2', '0', '2018-11-06 20:01:18', '2', '沸点的', '2018-11-05 20:14:17', '2018-11-05 20:14:17');
INSERT INTO `j_oa_user_change_info` VALUES ('10', '222', '4', '2018-11-01 00:00:00', null, '人员调整', '2018-11-14 17:18:28', '2018-11-14 17:18:28');
INSERT INTO `j_oa_user_change_info` VALUES ('11', '222', '4', '2018-11-01 00:00:00', null, '人员调整', '2018-11-14 17:27:21', '2018-11-14 17:27:21');
INSERT INTO `j_oa_user_change_info` VALUES ('15', '1', '5', '2018-11-14 14:42:33', null, '任职单位:null; 任职部门:hl1024006; 职务:cq; 职位:yww; 职级:职级2; 直接上级职位:; 直接管理职位:', '2018-11-15 09:30:40', '2018-11-15 09:30:40');
INSERT INTO `j_oa_user_change_info` VALUES ('16', '2', '5', '2018-11-14 14:42:33', null, '任职单位:null; 任职部门:hl1024006; 职务:cq; 职位:yww; 职级:职级2; 直接上级职位:; 直接管理职位:', '2018-11-15 09:30:40', '2018-11-15 09:30:40');
INSERT INTO `j_oa_user_change_info` VALUES ('17', '3', '5', '2018-11-14 14:42:33', null, '任职单位:null; 任职部门:hl1024006; 职务:cq; 职位:yww; 职级:职级2; 直接上级职位:; 直接管理职位:', '2018-11-15 09:30:40', '2018-11-15 09:30:40');
INSERT INTO `j_oa_user_change_info` VALUES ('18', '1', '5', '2018-11-14 14:42:33', null, '任职单位:null, 任职部门:hl1024006, 职务:cq, 职位:yww, 职级:职级2', '2018-11-15 14:07:09', '2018-11-15 14:07:09');
INSERT INTO `j_oa_user_change_info` VALUES ('19', '2', '5', '2018-11-14 14:42:33', null, '任职单位:null, 任职部门:hl1024006, 职务:cq, 职位:yww, 职级:职级2', '2018-11-15 14:07:09', '2018-11-15 14:07:09');
INSERT INTO `j_oa_user_change_info` VALUES ('20', '3', '5', '2018-11-14 14:42:33', null, '任职单位:null, 任职部门:hl1024006, 职务:cq, 职位:yww, 职级:职级2', '2018-11-15 14:07:09', '2018-11-15 14:07:09');
INSERT INTO `j_oa_user_change_info` VALUES ('21', '4', '5', '2018-11-14 14:42:33', null, '任职单位:null, 任职部门:hl1024006, 职务:cq, 职位:yww, 职级:职级2', '2018-11-15 14:07:09', '2018-11-15 14:07:09');

-- ----------------------------
-- Table structure for j_oa_user_depart_info
-- ----------------------------
DROP TABLE IF EXISTS `j_oa_user_depart_info`;
CREATE TABLE `j_oa_user_depart_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户ID',
  `depart_id` bigint(20) DEFAULT NULL COMMENT '部门ID',
  `depart_name` varchar(100) DEFAULT NULL COMMENT '部门名称',
  `gmt_create` datetime DEFAULT CURRENT_TIMESTAMP,
  `gmt_modified` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COMMENT='人员档案部门信息';

-- ----------------------------
-- Records of j_oa_user_depart_info
-- ----------------------------
INSERT INTO `j_oa_user_depart_info` VALUES ('6', '2', '411978937005776000', '销售部', '2018-11-01 09:59:19', '2018-11-15 15:31:26');
INSERT INTO `j_oa_user_depart_info` VALUES ('7', '3', '411978937005776000', '服务部', '2018-11-02 13:33:02', '2018-11-15 15:31:29');
INSERT INTO `j_oa_user_depart_info` VALUES ('10', '1', '411978937005776000', '开发部', '2018-11-06 21:50:17', '2018-11-15 15:31:31');

-- ----------------------------
-- Table structure for j_oa_user_education_info
-- ----------------------------
DROP TABLE IF EXISTS `j_oa_user_education_info`;
CREATE TABLE `j_oa_user_education_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL COMMENT '人员id',
  `status` tinyint(4) DEFAULT '0' COMMENT '学历状态 0默认 1第一学历 2最高学历',
  `study_type` tinyint(4) DEFAULT '0' COMMENT '学习形式 0默认 1全日制 2非全日制',
  `education_level` tinyint(4) DEFAULT NULL COMMENT '学历 (后台设置枚举值或者数据字典)',
  `education_degree` tinyint(4) DEFAULT NULL COMMENT '学位 (后台设置枚举值或者数据字典)',
  `major` varchar(50) DEFAULT NULL COMMENT '专业',
  `school` varchar(50) DEFAULT NULL COMMENT '学校',
  `start_date` datetime DEFAULT NULL COMMENT '起始日期',
  `end_date` datetime DEFAULT NULL COMMENT '结束日期（毕业时间）',
  `school_reward` varchar(100) DEFAULT NULL COMMENT '在校奖励',
  `memo` varchar(100) DEFAULT NULL COMMENT '备注',
  `gmt_create` datetime DEFAULT CURRENT_TIMESTAMP,
  `gmt_modified` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 COMMENT='人员档案教育经历';

-- ----------------------------
-- Records of j_oa_user_education_info
-- ----------------------------
INSERT INTO `j_oa_user_education_info` VALUES ('11', '1', '1', '2', '1', null, '计算机', '华农', null, null, null, null, '2018-11-01 11:13:07', '2018-11-02 13:33:51');
INSERT INTO `j_oa_user_education_info` VALUES ('12', '1', '2', '1', '2', null, '数学', '华科', null, null, null, null, '2018-11-01 11:13:24', '2018-11-02 13:36:22');
INSERT INTO `j_oa_user_education_info` VALUES ('13', '3', '2', '2', '1', null, '英语', '华师', null, null, null, null, '2018-11-02 10:15:20', '2018-11-02 13:36:33');
INSERT INTO `j_oa_user_education_info` VALUES ('14', '1', '0', '2', '1', null, '机', '华农', '0000-00-00 00:00:00', '0000-00-00 00:00:00', '', '', '2018-11-01 11:13:07', '2018-11-02 13:36:30');
INSERT INTO `j_oa_user_education_info` VALUES ('15', '2', '2', '0', '1', null, '工程', '武大', '2018-11-20 13:37:02', '2018-11-28 13:37:05', null, null, '2018-11-02 13:37:05', '2018-11-02 13:37:10');

-- ----------------------------
-- Table structure for j_oa_user_family_info
-- ----------------------------
DROP TABLE IF EXISTS `j_oa_user_family_info`;
CREATE TABLE `j_oa_user_family_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL COMMENT '人员id',
  `status` tinyint(4) DEFAULT '0' COMMENT '家庭成员状态 0默认 1紧急联系人',
  `name` varchar(50) DEFAULT NULL COMMENT '成员姓名',
  `relation` tinyint(4) DEFAULT '0' COMMENT '家庭成员关系 0默认 父亲1、母亲2、姐妹3、姐弟4、兄弟5、兄妹6、儿子7、女儿8、其他9 ',
  `birth_date` datetime DEFAULT NULL COMMENT '出生日期',
  `majors` varchar(50) DEFAULT NULL COMMENT '职业',
  `phone` varchar(20) DEFAULT NULL COMMENT '电话',
  `work_unit` varchar(50) DEFAULT NULL COMMENT '工作单位',
  `son_num` tinyint(4) DEFAULT '0' COMMENT '儿子人数',
  `age` tinyint(4) DEFAULT '0',
  `daughter_num` tinyint(4) DEFAULT '0' COMMENT '女儿人数',
  `gmt_create` datetime DEFAULT CURRENT_TIMESTAMP,
  `gmt_modified` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8 COMMENT='人员档案家庭成员';

-- ----------------------------
-- Records of j_oa_user_family_info
-- ----------------------------
INSERT INTO `j_oa_user_family_info` VALUES ('1', '1', '0', 'a', '7', '2018-11-05 20:40:49', '', '', '', null, '5', '0', '2018-11-05 20:40:31', '2018-11-16 11:00:10');
INSERT INTO `j_oa_user_family_info` VALUES ('4', '2', '1', '', '8', '2018-11-06 20:40:55', '', '', '', '1', '5', '3', '2018-11-07 10:50:44', '2018-11-16 11:00:10');
INSERT INTO `j_oa_user_family_info` VALUES ('7', '2', '0', '', '8', '2018-11-07 20:40:59', '', '', '', null, '5', null, '2018-11-07 10:50:44', '2018-11-16 11:00:10');
INSERT INTO `j_oa_user_family_info` VALUES ('10', '2', '0', '', '8', '2018-11-08 20:41:04', '', '', '', null, '5', null, '2018-11-07 10:50:44', '2018-11-16 11:00:10');
INSERT INTO `j_oa_user_family_info` VALUES ('14', '2', '0', '', '7', '2018-11-09 20:41:09', '', '', '', null, '5', null, '2018-11-07 10:50:44', '2018-11-16 11:00:10');
INSERT INTO `j_oa_user_family_info` VALUES ('19', '2', '0', '', '6', '2018-11-10 20:41:14', '', '', '', null, '5', null, '2018-11-07 10:50:44', '2018-11-16 11:00:10');
INSERT INTO `j_oa_user_family_info` VALUES ('24', '3', null, '', '8', '2018-11-11 20:41:19', '', '', '', null, '5', null, null, '2018-11-16 11:00:10');

-- ----------------------------
-- Table structure for j_oa_user_labour_contract
-- ----------------------------
DROP TABLE IF EXISTS `j_oa_user_labour_contract`;
CREATE TABLE `j_oa_user_labour_contract` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL COMMENT '人员id',
  `date` datetime DEFAULT NULL COMMENT '近期合同到期时间',
  `type` varchar(50) DEFAULT '0' COMMENT '合同签订情况 （数据字典维护）',
  `gmt_create` datetime DEFAULT CURRENT_TIMESTAMP,
  `gmt_modified` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='人员档案劳动合同';

-- ----------------------------
-- Records of j_oa_user_labour_contract
-- ----------------------------
INSERT INTO `j_oa_user_labour_contract` VALUES ('4', '1', '2018-11-21 13:31:54', '1', '2018-11-06 13:32:00', '2018-11-02 13:32:05');
INSERT INTO `j_oa_user_labour_contract` VALUES ('5', '2', '2018-02-02 13:32:10', '2', '2018-11-02 13:32:06', '2018-11-02 13:32:36');
INSERT INTO `j_oa_user_labour_contract` VALUES ('6', '2', '2017-01-02 13:32:27', '3', '2018-11-02 13:32:34', '2018-11-02 13:32:39');

-- ----------------------------
-- Table structure for j_oa_user_labour_contract_info
-- ----------------------------
DROP TABLE IF EXISTS `j_oa_user_labour_contract_info`;
CREATE TABLE `j_oa_user_labour_contract_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL COMMENT '人员id',
  `contract_no` varchar(50) DEFAULT NULL COMMENT '合同编号',
  `company_id` bigint(20) DEFAULT NULL COMMENT '签约公司ID',
  `company_name` varchar(100) DEFAULT NULL COMMENT '签约公司名称',
  `contract_type` varchar(50) DEFAULT NULL COMMENT '合同类型（数据字典维护）',
  `deadline_type` tinyint(4) DEFAULT NULL COMMENT '合同期限类型 固定期限0 无固定期限1  任务期限2',
  `sign_date` datetime DEFAULT NULL COMMENT '签订日期',
  `start_date` datetime DEFAULT NULL COMMENT '生效日期',
  `end_date` datetime DEFAULT NULL COMMENT '到期日期',
  `is_include` tinyint(4) DEFAULT '0' COMMENT '是否含试用期 默认0 是1',
  `memo` varchar(100) DEFAULT NULL COMMENT '备注',
  `file_id` bigint(20) DEFAULT NULL COMMENT '附件ID',
  `gmt_create` datetime DEFAULT CURRENT_TIMESTAMP,
  `gmt_modified` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='人员档案劳动合同';

-- ----------------------------
-- Records of j_oa_user_labour_contract_info
-- ----------------------------
INSERT INTO `j_oa_user_labour_contract_info` VALUES ('3', '1', '00001', '10000', '笛佛', '任职合同', '0', '2018-11-15 16:06:31', '2018-11-06 16:06:35', '2018-11-08 16:06:38', '0', '测试', '1', '2018-11-01 16:06:51', '2018-11-07 15:39:00');
INSERT INTO `j_oa_user_labour_contract_info` VALUES ('5', '1', '00001', '10000', '笛佛', '任职合同', '0', '2018-11-15 16:06:31', '2018-11-06 16:06:35', '2018-11-08 16:06:38', '0', '测试', '1', '2018-11-01 16:06:51', '2018-11-07 15:39:00');

-- ----------------------------
-- Table structure for j_oa_user_leader_info
-- ----------------------------
DROP TABLE IF EXISTS `j_oa_user_leader_info`;
CREATE TABLE `j_oa_user_leader_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` tinyint(4) DEFAULT '0' COMMENT '0上级 1下级',
  `user_id` bigint(20) DEFAULT NULL COMMENT '人员id',
  `erp_user_id` bigint(20) DEFAULT NULL COMMENT '姓名id',
  `erp_user_name` varchar(255) DEFAULT NULL COMMENT '姓名',
  `gmt_create` datetime DEFAULT CURRENT_TIMESTAMP,
  `gmt_modified` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=84 DEFAULT CHARSET=utf8 COMMENT='人员档案上下级人员关系';

-- ----------------------------
-- Records of j_oa_user_leader_info
-- ----------------------------
INSERT INTO `j_oa_user_leader_info` VALUES ('11', '1', '1', '111', 'cheng', '2018-10-31 11:18:42', '2018-10-31 11:18:42');
INSERT INTO `j_oa_user_leader_info` VALUES ('13', '1', '1', '113', 'c', '2018-10-31 11:19:16', '2018-10-31 11:19:16');
INSERT INTO `j_oa_user_leader_info` VALUES ('18', '0', '1002', null, null, '2018-11-09 15:32:09', '2018-11-09 15:32:52');
INSERT INTO `j_oa_user_leader_info` VALUES ('72', '0', '1', '494720638706785408', '刘志威', '2018-11-14 15:21:09', '2018-11-14 15:21:09');
INSERT INTO `j_oa_user_leader_info` VALUES ('73', '0', '1', '494013370797399168', '刘永琪', '2018-11-14 15:21:09', '2018-11-14 15:21:09');
INSERT INTO `j_oa_user_leader_info` VALUES ('74', '0', '1001', '494720638706785408', '刘志威', '2018-11-14 15:21:09', '2018-11-14 15:21:09');
INSERT INTO `j_oa_user_leader_info` VALUES ('75', '0', '1001', '494013370797399168', '刘永琪', '2018-11-14 15:21:09', '2018-11-14 15:21:09');
INSERT INTO `j_oa_user_leader_info` VALUES ('76', '0', '1003', '494720638706785408', '刘志威', '2018-11-14 15:21:09', '2018-11-14 15:21:09');
INSERT INTO `j_oa_user_leader_info` VALUES ('77', '0', '1003', '494013370797399168', '刘永琪', '2018-11-14 15:21:09', '2018-11-14 15:21:09');
INSERT INTO `j_oa_user_leader_info` VALUES ('78', '0', '1004', '494720638706785408', '刘志威', '2018-11-14 15:21:09', '2018-11-14 15:21:09');
INSERT INTO `j_oa_user_leader_info` VALUES ('79', '0', '1004', '494013370797399168', '刘永琪', '2018-11-14 15:21:09', '2018-11-14 15:21:09');
INSERT INTO `j_oa_user_leader_info` VALUES ('80', '0', '2', '494720638706785408', '刘志威', '2018-11-14 15:21:09', '2018-11-14 15:21:09');
INSERT INTO `j_oa_user_leader_info` VALUES ('81', '0', '2', '494013370797399168', '刘永琪', '2018-11-14 15:21:09', '2018-11-14 15:21:09');
INSERT INTO `j_oa_user_leader_info` VALUES ('82', '0', '3', '494720638706785408', '刘志威', '2018-11-14 15:21:09', '2018-11-14 15:21:09');
INSERT INTO `j_oa_user_leader_info` VALUES ('83', '0', '3', '494013370797399168', '刘永琪', '2018-11-14 15:21:09', '2018-11-14 15:21:09');

-- ----------------------------
-- Table structure for j_oa_user_log
-- ----------------------------
DROP TABLE IF EXISTS `j_oa_user_log`;
CREATE TABLE `j_oa_user_log` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT '0' COMMENT '人员ID',
  `operator_id` bigint(20) DEFAULT NULL,
  `operator_name` varchar(20) DEFAULT NULL,
  `log_detail` varchar(128) DEFAULT NULL,
  `gmt_create` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=205 DEFAULT CHARSET=utf8 COMMENT='人员档案操作日志表';

-- ----------------------------
-- Records of j_oa_user_log
-- ----------------------------
INSERT INTO `j_oa_user_log` VALUES ('188', '1', '1', 'c1', '修改人员档案', '2018-11-06 21:51:10');
INSERT INTO `j_oa_user_log` VALUES ('191', '1', '2', 'cq', '修改任职情况', '2018-11-08 15:02:51');
INSERT INTO `j_oa_user_log` VALUES ('192', '1', null, '', '修改任职情况', '2018-11-14 15:36:09');
INSERT INTO `j_oa_user_log` VALUES ('193', '1', '42', '吉客云开发', '修改任职情况', '2018-11-14 15:38:10');
INSERT INTO `j_oa_user_log` VALUES ('194', '1', '42', '吉客云开发', '修改任职情况', '2018-11-14 15:41:17');
INSERT INTO `j_oa_user_log` VALUES ('195', '1', '42', '吉客云开发', '修改任职情况', '2018-11-14 15:42:24');
INSERT INTO `j_oa_user_log` VALUES ('196', '1', '42', '吉客云开发', '修改任职情况', '2018-11-14 15:44:21');
INSERT INTO `j_oa_user_log` VALUES ('197', '1', '42', '吉客云开发', '修改任职情况', '2018-11-14 15:44:46');
INSERT INTO `j_oa_user_log` VALUES ('198', '1', '42', '吉客云开发', '修改任职情况', '2018-11-15 09:11:06');
INSERT INTO `j_oa_user_log` VALUES ('199', '2', '42', '吉客云开发', '修改任职情况', '2018-11-15 09:11:06');
INSERT INTO `j_oa_user_log` VALUES ('200', '3', '42', '吉客云开发', '修改任职情况', '2018-11-15 09:11:06');
INSERT INTO `j_oa_user_log` VALUES ('201', '1', '42', '吉客云开发', '修改任职情况', '2018-11-15 14:07:09');
INSERT INTO `j_oa_user_log` VALUES ('202', '2', '42', '吉客云开发', '修改任职情况', '2018-11-15 14:07:09');
INSERT INTO `j_oa_user_log` VALUES ('203', '3', '42', '吉客云开发', '修改任职情况', '2018-11-15 14:07:09');
INSERT INTO `j_oa_user_log` VALUES ('204', '4', '42', '吉客云开发', '修改任职情况', '2018-11-15 14:07:09');

-- ----------------------------
-- Table structure for j_oa_user_login
-- ----------------------------
DROP TABLE IF EXISTS `j_oa_user_login`;
CREATE TABLE `j_oa_user_login` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(20) DEFAULT NULL COMMENT '登录人ID',
  `user_login_id` bigint(20) DEFAULT NULL COMMENT '登录人帐号',
  `password` varchar(10) DEFAULT '123456' COMMENT '帐号密码',
  `is_deleted` tinyint(4) DEFAULT '0' COMMENT '是否删除，0不删除，1删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of j_oa_user_login
-- ----------------------------
INSERT INTO `j_oa_user_login` VALUES ('1', '123', '123', '123456', '0');

-- ----------------------------
-- Table structure for j_oa_user_position
-- ----------------------------
DROP TABLE IF EXISTS `j_oa_user_position`;
CREATE TABLE `j_oa_user_position` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `position_id` bigint(20) DEFAULT NULL COMMENT '职位ID',
  `position_name` varchar(100) DEFAULT NULL COMMENT '职位名称',
  `people_number` int(11) DEFAULT '0' COMMENT '编制人数',
  `company_id` bigint(20) DEFAULT NULL COMMENT '所属公司ID',
  `company_name` varchar(100) DEFAULT NULL COMMENT '所属公司名称',
  `depart_id` bigint(20) DEFAULT NULL COMMENT '所属部门ID',
  `depart_name` varchar(100) DEFAULT NULL COMMENT '所属部门名称',
  `category_code` varchar(20) DEFAULT '0' COMMENT '职位分类code',
  `category_value` varchar(50) DEFAULT NULL COMMENT '职位分类value',
  `erp_position_id` bigint(20) DEFAULT NULL COMMENT '岗位ID',
  `erp_position_name` varchar(100) DEFAULT NULL COMMENT '岗位名称',
  `create_date` datetime DEFAULT NULL COMMENT '成立日期',
  `cancel_date` datetime DEFAULT NULL COMMENT '撤销日期',
  `parent_position_id` bigint(20) DEFAULT NULL COMMENT '上级职位ID',
  `parent_position_name` varchar(100) DEFAULT NULL COMMENT '上级职位名称',
  `qualification` varchar(1000) DEFAULT NULL COMMENT '任职资格',
  `is_deleted` tinyint(4) DEFAULT '0' COMMENT '是否删除 0未删除 1删除',
  `is_cancel` tinyint(4) DEFAULT '0' COMMENT '0 默认 1 撤销',
  `gmt_create` datetime DEFAULT CURRENT_TIMESTAMP,
  `gmt_modified` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=54 DEFAULT CHARSET=utf8 COMMENT='用户职位管理';

-- ----------------------------
-- Records of j_oa_user_position
-- ----------------------------
INSERT INTO `j_oa_user_position` VALUES ('30', '484635658268967040', '测试职位1', '3', '111', '测试公司1', '222', '测试部门1', 'w100', '开发类', '101', '程序员', '2018-10-27 16:15:15', '2018-11-13 11:08:02', '0', 'qwwwwwwwwwwww', '职位测试1', '0', '2', '2018-10-31 16:04:32', '2018-11-15 18:36:16');
INSERT INTO `j_oa_user_position` VALUES ('31', '484637155350282368', '子职位1', '3', '111', '测试公司1', '222', '测试部门1', 'w100', '开发类', '100', '见习程序员', '2018-10-28 16:15:20', '2018-11-14 09:51:32', '484635658268967040', '测试职位1', '子职位测试1', '0', '2', '2018-10-31 16:07:31', '2018-11-14 09:51:57');
INSERT INTO `j_oa_user_position` VALUES ('32', '484637226921885824', '子职位2', '3', '111', '测试公司1', '222', '测试部门1', 'w100', '开发类', '100', '见习程序员', '2018-10-28 16:15:23', null, '484635658268967040', '测试职位1', '子职位测试2', '0', '0', '2018-10-31 16:07:39', '2018-11-15 18:36:16');
INSERT INTO `j_oa_user_position` VALUES ('33', '484637370283196544', '上级职位1', '3', '111', '测试公司1', '222', '测试部门1', 'w101', '管理类', '102', '高级程序员', '2018-10-26 16:15:30', null, '484635658268967040', '测试职位1', '上级职位测试1', '0', '0', '2018-10-31 16:07:56', '2018-11-15 18:36:16');
INSERT INTO `j_oa_user_position` VALUES ('34', '488099220954022016', 'www', null, '317065649711596544', '笛佛', '479549136274842624', 'hl1024006', 'NotCategorized', '未分类', null, '', null, '2018-11-14 09:41:24', '484635658268967040', '测试职位1', null, '0', '2', '2018-11-05 10:46:01', '2018-11-14 09:42:15');
INSERT INTO `j_oa_user_position` VALUES ('35', '488103958730768512', 'ww', null, '317065649711596544', '笛佛', '479549136274842624', 'hl1024006', 'NotCategorized', '未分类', null, '', null, null, '100', 'ces', null, '0', '0', '2018-11-05 10:55:25', '2018-11-12 14:22:11');
INSERT INTO `j_oa_user_position` VALUES ('36', '488105009538138240', '111', null, '317065649711596544', '笛佛', '479549136274842624', 'hl1024006', 'NotCategorized', '未分类', null, '', null, null, '488803729053319296', '测试职位1', null, '0', '0', '2018-11-05 10:57:31', '2018-11-15 18:37:59');
INSERT INTO `j_oa_user_position` VALUES ('37', '488105410723315840', '122', null, '317065649711596544', '笛佛', '479549136274842624', 'hl1024006', 'NotCategorized', '未分类', null, '', null, null, '488803729053319296', '测试职位1', null, '0', '0', '2018-11-05 10:58:19', '2018-11-15 18:38:00');
INSERT INTO `j_oa_user_position` VALUES ('38', '488105841159569536', '333', null, '317065649711596544', '笛佛', '479549136274842624', 'hl1024006', 'NotCategorized', '未分类', null, '', null, null, '488803729053319296', '测试职位1', null, '0', '0', '2018-11-05 10:59:10', '2018-11-15 18:38:01');
INSERT INTO `j_oa_user_position` VALUES ('39', '488125349278515328', 'cc', null, '317065649711596544', '笛佛', '479549136274842624', 'hl1024006', 'NotCategorized', '未分类', null, '', null, null, '488803729053319296', '测试职位1', null, '0', '0', '2018-11-05 11:37:55', '2018-11-15 18:38:04');
INSERT INTO `j_oa_user_position` VALUES ('40', '488180044772671616', 'yw', null, '317065649711596544', '笛佛', '479549136274842624', 'hl1024006', 'NotCategorized', '未分类', null, '', null, null, null, null, null, '0', '0', '2018-11-05 13:26:36', '2018-11-15 18:36:16');
INSERT INTO `j_oa_user_position` VALUES ('41', '488192799483363456', 'www11', null, '317065649711596544', '笛佛', '479549136274842624', 'hl1024006', 'NotCategorized', '未分类', null, '', null, null, null, null, '资格哦', '0', '0', '2018-11-05 13:51:56', '2018-11-15 18:36:16');
INSERT INTO `j_oa_user_position` VALUES ('42', '488200160528826496', 'yww', null, '322809137728177152', '笛升', '483878562339495040', '23', 'NotCategorized', '未分类', null, '', null, null, null, null, null, '0', '0', '2018-11-05 14:06:34', '2018-11-15 18:36:16');
INSERT INTO `j_oa_user_position` VALUES ('43', '488296566136504448', 'qwwwwwwwwwwww', '111', '317065649711596544', '笛佛', '479550915599262720', '测试笛佛01', '5', '服务类', '19', '岗位66', '2018-11-06 17:17:44', null, '0', 'qwwwwwwwwwwww', 'qwww资格111', '0', '0', '2018-11-05 17:18:06', '2018-11-15 18:36:16');
INSERT INTO `j_oa_user_position` VALUES ('44', '488326232139380864', 'qwwwwwwwwwwww', '111', '317065649711596544', '笛佛', '479549136274842624', 'hl1024006', '5', '服务类', '10', '岗位1', '2018-11-06 17:17:44', null, '0', 'qwwwwwwwwwwww', 'qwww资格', '0', '0', '2018-11-05 18:17:02', '2018-11-15 18:36:16');
INSERT INTO `j_oa_user_position` VALUES ('45', '488803729053319296', 'yww', null, '317065649711596544', '笛佛', '479549136274842624', 'hl1024006', 'NotCategorized', '未分类', null, '', null, null, '484637370283196544', '上级职务', null, '0', '0', '2018-11-06 10:05:45', '2018-11-15 18:36:16');
INSERT INTO `j_oa_user_position` VALUES ('46', '488821259826364544', 'yww', null, '317065649711596544', '笛佛', '479549136274842624', 'hl1024006', 'NotCategorized', '未分类', null, '', null, null, '484635658268967040', '测试职位1', null, '0', '0', '2018-11-06 10:40:34', '2018-11-15 18:36:16');
INSERT INTO `j_oa_user_position` VALUES ('47', '488823421872636032', 'qqq', null, '317065649711596544', '笛佛', '479549136274842624', 'hl1024006', 'NotCategorized', '未分类', null, '', null, null, '484635658268967040', '测试职位1', null, '0', '0', '2018-11-06 10:44:52', '2018-11-15 18:36:16');
INSERT INTO `j_oa_user_position` VALUES ('48', '488823942972964992', 'qqqqqq', null, '317065649711596544', '笛佛', '479549136274842624', 'hl1024006', 'NotCategorized', '未分类', null, '', null, null, null, null, '32', '0', '0', '2018-11-06 10:45:54', '2018-11-15 18:36:16');
INSERT INTO `j_oa_user_position` VALUES ('49', '488842802073698432', 'ppp', null, '317065649711596544', '笛佛', '479549136274842624', 'hl1024006', '2', '管理类', '1', '部门主管', null, null, null, null, null, '0', '0', '2018-11-06 11:23:22', '2018-11-15 18:36:16');
INSERT INTO `j_oa_user_position` VALUES ('50', '489546117195497600', 'yyy', null, '317065649711596544', '笛佛', '479550915599262720', '测试笛佛01', '2', '管理类', '14', '部门主管343444', null, null, null, null, null, '0', '0', '2018-11-07 10:40:42', '2018-11-15 18:36:16');
INSERT INTO `j_oa_user_position` VALUES ('51', '489547801518932096', 'qqq', null, '317065649711596544', '笛佛', '479550915599262720', '测试笛佛01', 'NotCategorized', '未分类', '14', '部门主管343444', null, null, null, null, null, '0', '0', '2018-11-07 10:44:03', '2018-11-15 18:36:16');
INSERT INTO `j_oa_user_position` VALUES ('52', '100', '管理类-部门主管', '0', '317065649711596544', '笛佛', '479550915599262720', '测试笛佛01', '2', '管理类', '14', '部门主管343444', null, '2018-11-14 10:19:20', null, null, null, '0', '1', '2018-11-12 14:17:46', '2018-11-14 10:19:34');
INSERT INTO `j_oa_user_position` VALUES ('53', '493875112275869824', '未分类', null, '317065649711596544', '笛佛', '479550915599262720', '测试笛佛01', 'NotCategorized', '未分类', null, '', null, null, null, null, null, '0', '0', '2018-11-13 10:01:41', '2018-11-14 10:18:31');

-- ----------------------------
-- Table structure for j_oa_user_position_duty
-- ----------------------------
DROP TABLE IF EXISTS `j_oa_user_position_duty`;
CREATE TABLE `j_oa_user_position_duty` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `position_id` bigint(20) DEFAULT NULL COMMENT '职位ID',
  `number` int(11) DEFAULT NULL COMMENT '序号',
  `position_duty` varchar(100) DEFAULT NULL COMMENT '工作职责',
  `description` varchar(200) DEFAULT NULL COMMENT '工作描述',
  `gmt_create` datetime DEFAULT CURRENT_TIMESTAMP,
  `gmt_modified` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8 COMMENT='用户职位管理职位职责';

-- ----------------------------
-- Records of j_oa_user_position_duty
-- ----------------------------
INSERT INTO `j_oa_user_position_duty` VALUES ('17', '484635658268967040', '1', '通用职责', '负责本部门制度、流程的建立、完善和监督执行；', '2018-11-05 10:57:58', '2018-11-05 10:57:58');
INSERT INTO `j_oa_user_position_duty` VALUES ('18', '484635658268967040', '2', '通用职责', '编制本部门年度，并监督计划的落实；', '2018-11-05 10:57:58', '2018-11-05 10:57:58');
INSERT INTO `j_oa_user_position_duty` VALUES ('19', '488180044772671616', '1', '11', '111', '2018-11-05 13:26:48', '2018-11-05 13:26:48');
INSERT INTO `j_oa_user_position_duty` VALUES ('20', '488192799483363456', '12', '1e', '32', '2018-11-05 13:52:15', '2018-11-05 13:52:15');
INSERT INTO `j_oa_user_position_duty` VALUES ('21', '488296566136504448', '1', 'qwwww职责1', 'qwww描述1', '2018-11-05 17:18:46', '2018-11-05 17:18:46');
INSERT INTO `j_oa_user_position_duty` VALUES ('22', '488823942972964992', '1', '11', '111', '2018-11-06 10:46:18', '2018-11-06 10:46:18');
INSERT INTO `j_oa_user_position_duty` VALUES ('23', '484637155350282368', '1', '1', '1', '2018-11-06 11:16:33', '2018-11-06 11:16:33');
INSERT INTO `j_oa_user_position_duty` VALUES ('24', '488326232139380864', '11', '11', '111', '2018-11-06 15:22:37', '2018-11-06 15:22:37');

-- ----------------------------
-- Table structure for j_oa_user_position_info
-- ----------------------------
DROP TABLE IF EXISTS `j_oa_user_position_info`;
CREATE TABLE `j_oa_user_position_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL COMMENT '人员id',
  `position_id` bigint(20) DEFAULT NULL COMMENT '职位ID',
  `company_id` bigint(20) DEFAULT NULL COMMENT '任职单位ID',
  `company_name` varchar(100) DEFAULT NULL COMMENT '任职单位名称',
  `depart_id` bigint(20) DEFAULT NULL COMMENT '任职部门ID',
  `depart_name` varchar(100) DEFAULT NULL COMMENT '任职部门名称',
  `erp_position_id` bigint(20) DEFAULT NULL COMMENT '岗位ID',
  `erp_position_name` varchar(100) DEFAULT NULL COMMENT '岗位名称',
  `rank_id` bigint(20) DEFAULT NULL COMMENT '职级ID',
  `is_main` tinyint(4) DEFAULT '0' COMMENT '是否主职位 0默认 1主职位',
  `is_deleted` tinyint(4) DEFAULT '0' COMMENT '是否删除 0未删除 1删除',
  `start_date` datetime DEFAULT NULL COMMENT '起始日期',
  `end_date` datetime DEFAULT NULL COMMENT '结束日期',
  `gmt_create` datetime DEFAULT CURRENT_TIMESTAMP,
  `gmt_modified` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8 COMMENT='人员档案任职情况';

-- ----------------------------
-- Records of j_oa_user_position_info
-- ----------------------------
INSERT INTO `j_oa_user_position_info` VALUES ('17', '1', '488803729053319296', '317065649711596544', '笛佛', '479549136274842624', 'hl1024006', '1001', 'cq', '484635760643539072', '0', '0', '2018-11-16 14:42:33', '2018-11-28 14:42:36', '2018-10-31 16:20:20', '2018-11-15 11:44:32');
INSERT INTO `j_oa_user_position_info` VALUES ('18', '42', '493875112275869824', '317065649711596544', '笛佛', '479550915599262720', '测试笛佛01', '14', '测试职务', '484658846906450048', '0', '0', '2018-11-08 15:16:59', null, '2018-10-31 16:20:36', '2018-11-15 15:47:49');
INSERT INTO `j_oa_user_position_info` VALUES ('19', '1', '484637226921885824', null, null, null, null, '1003', 'wjx', '484678265780058240', '0', '0', '2018-11-01 15:17:04', null, '2018-10-31 16:20:41', '2018-11-15 15:17:17');
INSERT INTO `j_oa_user_position_info` VALUES ('20', '42', '484635658268967040', '317065649711596544', '笛佛', '479550915599262720', '测试笛佛01', null, '', null, '0', '0', '2018-11-02 15:17:08', null, '2018-10-31 16:20:50', '2018-11-15 15:17:21');
INSERT INTO `j_oa_user_position_info` VALUES ('21', '1005', '493875112275869824', '2', '笛佛', '1', '云端', null, null, null, '0', '0', '2018-11-03 15:17:11', null, '2018-10-31 16:24:24', '2018-11-15 15:17:25');
INSERT INTO `j_oa_user_position_info` VALUES ('29', '20', '493875112275869824', '317065649711596544', '笛佛', '479549136274842624', 'hl1024006', '1001', 'cq', '484635760643539072', '0', '0', '2018-11-17 14:42:33', '2018-11-28 14:42:36', '2018-11-14 16:51:42', '2018-11-15 14:05:24');
INSERT INTO `j_oa_user_position_info` VALUES ('30', '42', '488803729053319296', '317065649711596544', '笛佛', '479549136274842624', 'hl1024006', '1001', 'cq', '484635760643539072', '0', '0', '2018-11-17 14:42:33', '2018-11-28 14:42:36', '2018-11-14 16:51:42', '2018-11-15 11:46:24');

-- ----------------------------
-- Table structure for j_oa_user_position_log
-- ----------------------------
DROP TABLE IF EXISTS `j_oa_user_position_log`;
CREATE TABLE `j_oa_user_position_log` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `position_id` bigint(20) DEFAULT NULL COMMENT '职位ID',
  `user_id` bigint(20) DEFAULT NULL,
  `operator` varchar(20) DEFAULT NULL,
  `log_detail` varchar(128) DEFAULT NULL,
  `gmt_create` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=109 DEFAULT CHARSET=utf8 COMMENT='用户职级管理日志表';

-- ----------------------------
-- Records of j_oa_user_position_log
-- ----------------------------
INSERT INTO `j_oa_user_position_log` VALUES ('31', '484635658268967040', null, '', '新增职位', '2018-10-31 16:04:33');
INSERT INTO `j_oa_user_position_log` VALUES ('32', '484637155350282368', null, '', '新增职位', '2018-10-31 16:07:31');
INSERT INTO `j_oa_user_position_log` VALUES ('33', '484637226921885824', null, '', '新增职位', '2018-10-31 16:07:39');
INSERT INTO `j_oa_user_position_log` VALUES ('34', '484637370283196544', null, '', '新增职位', '2018-10-31 16:07:56');
INSERT INTO `j_oa_user_position_log` VALUES ('35', '488099220954022016', '42', '吉客云开发', '新增职位', '2018-11-05 10:46:01');
INSERT INTO `j_oa_user_position_log` VALUES ('36', '488103958730768512', '42', '吉客云开发', '新增职位', '2018-11-05 10:55:25');
INSERT INTO `j_oa_user_position_log` VALUES ('37', '488105009538138240', '42', '吉客云开发', '新增职位', '2018-11-05 10:57:31');
INSERT INTO `j_oa_user_position_log` VALUES ('38', '488105410723315840', '42', '吉客云开发', '新增职位', '2018-11-05 10:58:19');
INSERT INTO `j_oa_user_position_log` VALUES ('39', '488105841159569536', '42', '吉客云开发', '新增职位', '2018-11-05 10:59:10');
INSERT INTO `j_oa_user_position_log` VALUES ('40', '488103958730768512', '42', '吉客云开发', '删除职位', '2018-11-05 11:37:40');
INSERT INTO `j_oa_user_position_log` VALUES ('41', '488105410723315840', '42', '吉客云开发', '删除职位', '2018-11-05 11:37:40');
INSERT INTO `j_oa_user_position_log` VALUES ('42', '488105841159569536', '42', '吉客云开发', '删除职位', '2018-11-05 11:37:40');
INSERT INTO `j_oa_user_position_log` VALUES ('43', '488105009538138240', '42', '吉客云开发', '删除职位', '2018-11-05 11:37:40');
INSERT INTO `j_oa_user_position_log` VALUES ('44', '488125349278515328', '42', '吉客云开发', '新增职位', '2018-11-05 11:37:55');
INSERT INTO `j_oa_user_position_log` VALUES ('45', '488180044772671616', '42', '吉客云开发', '新增职位', '2018-11-05 13:26:36');
INSERT INTO `j_oa_user_position_log` VALUES ('46', '488180044772671616', '42', '吉客云开发', '删除职位', '2018-11-05 13:50:26');
INSERT INTO `j_oa_user_position_log` VALUES ('47', '488192799483363456', '42', '吉客云开发', '新增职位', '2018-11-05 13:51:56');
INSERT INTO `j_oa_user_position_log` VALUES ('48', '488192799483363456', '42', '吉客云开发', '修改职位', '2018-11-05 13:53:27');
INSERT INTO `j_oa_user_position_log` VALUES ('49', '488125349278515328', '42', '吉客云开发', '删除职位', '2018-11-05 14:06:20');
INSERT INTO `j_oa_user_position_log` VALUES ('50', '488192799483363456', '42', '吉客云开发', '删除职位', '2018-11-05 14:06:20');
INSERT INTO `j_oa_user_position_log` VALUES ('51', '488200160528826496', '42', '吉客云开发', '新增职位', '2018-11-05 14:06:34');
INSERT INTO `j_oa_user_position_log` VALUES ('52', '488296566136504448', '42', '吉客云开发', '新增职位', '2018-11-05 17:18:06');
INSERT INTO `j_oa_user_position_log` VALUES ('53', '488296566136504448', '42', '吉客云开发', '修改职位', '2018-11-05 17:19:02');
INSERT INTO `j_oa_user_position_log` VALUES ('54', '488326232139380864', '42', '吉客云开发', '新增职位', '2018-11-05 18:17:02');
INSERT INTO `j_oa_user_position_log` VALUES ('55', '488296566136504448', '42', '吉客云开发', '删除职位', '2018-11-06 09:37:32');
INSERT INTO `j_oa_user_position_log` VALUES ('56', '488200160528826496', '42', '吉客云开发', '删除职位', '2018-11-06 09:37:32');
INSERT INTO `j_oa_user_position_log` VALUES ('57', '488803729053319296', '42', '吉客云开发', '新增职位', '2018-11-06 10:05:45');
INSERT INTO `j_oa_user_position_log` VALUES ('58', '488803729053319296', '42', '吉客云开发', '删除职位', '2018-11-06 10:11:03');
INSERT INTO `j_oa_user_position_log` VALUES ('59', '488821259826364544', '42', '吉客云开发', '新增职位', '2018-11-06 10:40:34');
INSERT INTO `j_oa_user_position_log` VALUES ('60', '488821259826364544', '42', '吉客云开发', '删除职位', '2018-11-06 10:42:06');
INSERT INTO `j_oa_user_position_log` VALUES ('61', '488823421872636032', '42', '吉客云开发', '新增职位', '2018-11-06 10:44:52');
INSERT INTO `j_oa_user_position_log` VALUES ('62', '488823942972964992', '42', '吉客云开发', '新增职位', '2018-11-06 10:45:54');
INSERT INTO `j_oa_user_position_log` VALUES ('63', '488823942972964992', '42', '吉客云开发', '修改职位', '2018-11-06 10:46:31');
INSERT INTO `j_oa_user_position_log` VALUES ('64', '488823421872636032', '42', '吉客云开发', '删除职位', '2018-11-06 10:46:40');
INSERT INTO `j_oa_user_position_log` VALUES ('65', '488842802073698432', '42', '吉客云开发', '新增职位', '2018-11-06 11:23:22');
INSERT INTO `j_oa_user_position_log` VALUES ('66', '488842802073698432', '42', '吉客云开发', '删除职位', '2018-11-06 11:44:14');
INSERT INTO `j_oa_user_position_log` VALUES ('67', '488823942972964992', '42', '吉客云开发', '删除职位', '2018-11-06 11:44:24');
INSERT INTO `j_oa_user_position_log` VALUES ('68', '488326232139380864', '42', '吉客云开发', '修改职位', '2018-11-06 15:46:26');
INSERT INTO `j_oa_user_position_log` VALUES ('69', '488326232139380864', '42', '吉客云开发', '修改职位', '2018-11-06 16:07:18');
INSERT INTO `j_oa_user_position_log` VALUES ('70', '488326232139380864', '42', '吉客云开发', '修改职位', '2018-11-06 16:12:32');
INSERT INTO `j_oa_user_position_log` VALUES ('71', '488326232139380864', '42', '吉客云开发', '修改职位', '2018-11-06 16:15:06');
INSERT INTO `j_oa_user_position_log` VALUES ('72', '489546117195497600', '42', '吉客云开发', '新增职位', '2018-11-07 10:40:42');
INSERT INTO `j_oa_user_position_log` VALUES ('73', '489547801518932096', '42', '吉客云开发', '新增职位', '2018-11-07 10:44:03');
INSERT INTO `j_oa_user_position_log` VALUES ('74', '484637226921885824', '45', '', '删除职位', '2018-11-12 14:14:01');
INSERT INTO `j_oa_user_position_log` VALUES ('75', '484635658268967040', '45', '', '删除职位', '2018-11-12 14:14:01');
INSERT INTO `j_oa_user_position_log` VALUES ('76', '484637370283196544', '45', '', '删除职位', '2018-11-12 14:14:01');
INSERT INTO `j_oa_user_position_log` VALUES ('77', '488326232139380864', '45', '', '删除职位', '2018-11-12 14:14:01');
INSERT INTO `j_oa_user_position_log` VALUES ('78', '489547801518932096', '45', '', '删除职位', '2018-11-12 14:14:01');
INSERT INTO `j_oa_user_position_log` VALUES ('79', '489546117195497600', '45', '', '删除职位', '2018-11-12 14:14:01');
INSERT INTO `j_oa_user_position_log` VALUES ('80', '100', '45', '', '删除职位', '2018-11-12 14:19:07');
INSERT INTO `j_oa_user_position_log` VALUES ('81', '493875112275869824', '45', '', '新增职位', '2018-11-13 10:01:41');
INSERT INTO `j_oa_user_position_log` VALUES ('82', '493875112275869824', '42', '吉客云开发', '撤销职位', '2018-11-13 11:20:47');
INSERT INTO `j_oa_user_position_log` VALUES ('83', '493875112275869824', '45', '', '恢复职位', '2018-11-13 11:23:08');
INSERT INTO `j_oa_user_position_log` VALUES ('84', '493875112275869824', '45', '', '撤销职位', '2018-11-13 11:30:14');
INSERT INTO `j_oa_user_position_log` VALUES ('85', '493875112275869824', '45', '', '恢复职位', '2018-11-13 11:35:39');
INSERT INTO `j_oa_user_position_log` VALUES ('86', '484635658268967040', '42', '吉客云开发', '合并职位', '2018-11-13 13:20:25');
INSERT INTO `j_oa_user_position_log` VALUES ('87', '100', '45', '', '合并职位', '2018-11-14 09:36:37');
INSERT INTO `j_oa_user_position_log` VALUES ('88', '484637155350282368', '45', '', '合并职位', '2018-11-14 09:39:06');
INSERT INTO `j_oa_user_position_log` VALUES ('89', '488099220954022016', '45', '', '撤销职位', '2018-11-14 09:42:15');
INSERT INTO `j_oa_user_position_log` VALUES ('90', '484637155350282368', '45', '', '撤销职位', '2018-11-14 09:43:29');
INSERT INTO `j_oa_user_position_log` VALUES ('91', '484637155350282368', '45', '', '撤销职位', '2018-11-14 09:45:39');
INSERT INTO `j_oa_user_position_log` VALUES ('92', '484637155350282368', '45', '', '撤销职位', '2018-11-14 09:46:12');
INSERT INTO `j_oa_user_position_log` VALUES ('93', '484637155350282368', '45', '', '撤销职位', '2018-11-14 09:47:11');
INSERT INTO `j_oa_user_position_log` VALUES ('94', '484637155350282368', '45', '', '撤销职位', '2018-11-14 09:49:42');
INSERT INTO `j_oa_user_position_log` VALUES ('95', '484637155350282368', '45', '', '恢复职位', '2018-11-14 09:51:09');
INSERT INTO `j_oa_user_position_log` VALUES ('96', '484637155350282368', '45', '', '合并职位', '2018-11-14 09:52:03');
INSERT INTO `j_oa_user_position_log` VALUES ('97', '493875112275869824', '45', '', '合并职位', '2018-11-14 09:56:29');
INSERT INTO `j_oa_user_position_log` VALUES ('98', '100', '45', '', '合并职位', '2018-11-14 10:02:34');
INSERT INTO `j_oa_user_position_log` VALUES ('99', '100', '45', '', '恢复职位', '2018-11-14 10:04:54');
INSERT INTO `j_oa_user_position_log` VALUES ('100', '493875112275869824', '45', '', '合并职位', '2018-11-14 10:05:13');
INSERT INTO `j_oa_user_position_log` VALUES ('101', '493875112275869824', '45', '', '恢复职位', '2018-11-14 10:09:04');
INSERT INTO `j_oa_user_position_log` VALUES ('102', '100', '45', '', '合并职位', '2018-11-14 10:09:39');
INSERT INTO `j_oa_user_position_log` VALUES ('103', '493875112275869824', '45', '', '合并职位', '2018-11-14 10:13:23');
INSERT INTO `j_oa_user_position_log` VALUES ('104', '100', '45', '', '恢复职位', '2018-11-14 10:16:29');
INSERT INTO `j_oa_user_position_log` VALUES ('105', '493875112275869824', '45', '', '恢复职位', '2018-11-14 10:16:38');
INSERT INTO `j_oa_user_position_log` VALUES ('106', '493875112275869824', '45', '', '合并职位', '2018-11-14 10:16:53');
INSERT INTO `j_oa_user_position_log` VALUES ('107', '493875112275869824', '45', '', '恢复职位', '2018-11-14 10:18:31');
INSERT INTO `j_oa_user_position_log` VALUES ('108', '100', '45', '', '合并职位', '2018-11-14 10:19:34');

-- ----------------------------
-- Table structure for j_oa_user_position_operation
-- ----------------------------
DROP TABLE IF EXISTS `j_oa_user_position_operation`;
CREATE TABLE `j_oa_user_position_operation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `position_id` bigint(20) DEFAULT NULL COMMENT '职位ID',
  `merge_position_id` bigint(20) DEFAULT NULL COMMENT '合并目标职位ID',
  `merge_position_name` varchar(100) DEFAULT NULL COMMENT '合并目标职位名称',
  `merge_date` datetime DEFAULT NULL COMMENT '合并日期',
  `merge_reason` varchar(200) DEFAULT NULL COMMENT '合并备注',
  `cancel_date` datetime DEFAULT NULL COMMENT '撤销日期',
  `cancel_reason` varchar(200) DEFAULT NULL COMMENT '撤销备注',
  `recover_date` datetime DEFAULT NULL COMMENT '恢复撤销日期',
  `recover_reason` varchar(200) DEFAULT NULL COMMENT '恢复撤销备注',
  `gmt_create` datetime DEFAULT CURRENT_TIMESTAMP,
  `gmt_modified` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户职位管理操作表（合并 、撤销、恢复撤销）';

-- ----------------------------
-- Records of j_oa_user_position_operation
-- ----------------------------

-- ----------------------------
-- Table structure for j_oa_user_rank
-- ----------------------------
DROP TABLE IF EXISTS `j_oa_user_rank`;
CREATE TABLE `j_oa_user_rank` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `rank_id` bigint(20) DEFAULT NULL COMMENT '职级ID',
  `rank_name` varchar(100) DEFAULT NULL COMMENT '职级名称',
  `sequence_code` varchar(20) DEFAULT NULL COMMENT '职级序列code',
  `sequence_value` varchar(50) DEFAULT NULL COMMENT '职级序列value',
  `category_code` varchar(20) DEFAULT NULL COMMENT '职级分类code',
  `category_value` varchar(50) DEFAULT NULL COMMENT '职级分类value',
  `grade` varchar(50) DEFAULT NULL COMMENT '职级等级',
  `position_id` bigint(20) DEFAULT NULL COMMENT '职务(erp岗位)id',
  `position_name` varchar(50) DEFAULT NULL COMMENT '职务名称',
  `memo` varchar(100) DEFAULT NULL COMMENT '备注',
  `is_deleted` tinyint(4) DEFAULT '0' COMMENT '是否删除 0未删除 1删除',
  `gmt_create` datetime DEFAULT CURRENT_TIMESTAMP,
  `gmt_modified` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8 COMMENT='用户职级管理';

-- ----------------------------
-- Records of j_oa_user_rank
-- ----------------------------
INSERT INTO `j_oa_user_rank` VALUES ('13', '484635760643539072', '职级2', '1', '技术序列', 'test', '测试', '', null, '', '12333', '0', '2018-10-31 16:04:45', '2018-11-12 09:34:08');
INSERT INTO `j_oa_user_rank` VALUES ('15', '484658846906450048', '测试23', '2', '管理序列', 'test', '测试', '', null, '', '', '0', '2018-10-31 16:50:37', '2018-11-12 09:34:33');
INSERT INTO `j_oa_user_rank` VALUES ('19', '484678265780058240', 'Java中级程序员', '1', '技术序列', '4', '中级管理', 'P5', null, '', '', '0', '2018-10-31 17:29:11', '2018-11-05 09:46:22');
INSERT INTO `j_oa_user_rank` VALUES ('20', '484678445162051712', 'Java高级程序员', '2', '管理序列', '3', '高级管理', 'P6', null, '', '1234567', '0', '2018-10-31 17:29:32', '2018-11-12 09:34:25');
INSERT INTO `j_oa_user_rank` VALUES ('22', '484680880391731328', 'Java初级程序员', '1', '技术序列', '5', '基层', 'P4', null, '', '1234', '0', '2018-10-31 17:39:12', '2018-10-31 17:39:12');
INSERT INTO `j_oa_user_rank` VALUES ('24', '484669893067407488', '测试2', '1', '技术序列', 'test', '测试', '', null, '', '1111111111', '1', '2018-11-01 09:41:56', '2018-11-07 10:48:18');
INSERT INTO `j_oa_user_rank` VALUES ('25', '489538848231784576', 'hhehe', '1', '技术序列', '5', '基层', '', '21', '行政', '', '0', '2018-11-07 10:26:18', '2018-11-07 10:26:18');
INSERT INTO `j_oa_user_rank` VALUES ('26', '489549795189063808', '11111', '1', '技术序列', '2', '决策层', '', '21', '行政', '', '0', '2018-11-07 10:48:01', '2018-11-07 10:48:01');

-- ----------------------------
-- Table structure for j_oa_user_rank_log
-- ----------------------------
DROP TABLE IF EXISTS `j_oa_user_rank_log`;
CREATE TABLE `j_oa_user_rank_log` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `rank_id` bigint(20) DEFAULT NULL COMMENT '职级ID',
  `user_id` bigint(20) DEFAULT NULL,
  `operator` varchar(20) DEFAULT NULL,
  `log_detail` varchar(128) DEFAULT NULL,
  `gmt_create` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=61 DEFAULT CHARSET=utf8 COMMENT='用户职级管理日志表';

-- ----------------------------
-- Records of j_oa_user_rank_log
-- ----------------------------
INSERT INTO `j_oa_user_rank_log` VALUES ('31', '484635760643539072', '42', '吉客云开发', '新增职级', '2018-10-31 16:04:45');
INSERT INTO `j_oa_user_rank_log` VALUES ('32', '484658747467890816', '42', '吉客云开发', '新增职级', '2018-10-31 16:50:25');
INSERT INTO `j_oa_user_rank_log` VALUES ('33', '484658846906450048', '42', '吉客云开发', '新增职级', '2018-10-31 16:50:37');
INSERT INTO `j_oa_user_rank_log` VALUES ('34', '484658846906450048', '42', '吉客云开发', '删除职级', '2018-10-31 16:50:52');
INSERT INTO `j_oa_user_rank_log` VALUES ('35', '484635760643539072', '42', '吉客云开发', '修改职级', '2018-10-31 16:58:10');
INSERT INTO `j_oa_user_rank_log` VALUES ('40', '484658747467890816', '42', '吉客云开发', '修改职级', '2018-10-31 17:12:33');
INSERT INTO `j_oa_user_rank_log` VALUES ('41', '484669893067407488', '42', '吉客云开发', '修改职级', '2018-10-31 17:14:34');
INSERT INTO `j_oa_user_rank_log` VALUES ('42', '484669893067407488', '42', '吉客云开发', '修改职级', '2018-10-31 17:15:49');
INSERT INTO `j_oa_user_rank_log` VALUES ('43', '484678265780058240', '459215893833718912', '吉客云开发', '新增职级', '2018-10-31 17:29:11');
INSERT INTO `j_oa_user_rank_log` VALUES ('44', '484678445162051712', '459215893833718912', '吉客云开发', '新增职级', '2018-10-31 17:29:32');
INSERT INTO `j_oa_user_rank_log` VALUES ('45', '484680880391731328', '459215893833718912', '吉客云开发', '新增职级', '2018-10-31 17:34:23');
INSERT INTO `j_oa_user_rank_log` VALUES ('46', '484680880391731328', '42', '吉客云开发', '修改职级', '2018-10-31 17:39:12');
INSERT INTO `j_oa_user_rank_log` VALUES ('47', '484669893067407488', '459215893833718912', '吉客云开发', '修改职级', '2018-11-01 09:38:16');
INSERT INTO `j_oa_user_rank_log` VALUES ('48', '484669893067407488', '459215893833718912', '吉客云开发', '修改职级', '2018-11-01 09:41:56');
INSERT INTO `j_oa_user_rank_log` VALUES ('49', '484669893067407488', '42', '吉客云开发', '修改职级', '2018-11-01 11:05:07');
INSERT INTO `j_oa_user_rank_log` VALUES ('50', '484678445162051712', '459215893833718912', '吉客云开发', '修改职级', '2018-11-02 15:20:17');
INSERT INTO `j_oa_user_rank_log` VALUES ('51', '484678445162051712', '459215893833718912', '吉客云开发', '修改职级', '2018-11-02 15:21:54');
INSERT INTO `j_oa_user_rank_log` VALUES ('52', '484678265780058240', '459215893833718912', '吉客云开发', '修改职级', '2018-11-02 15:22:36');
INSERT INTO `j_oa_user_rank_log` VALUES ('53', '484678265780058240', '459215893833718912', '吉客云开发', '修改职级', '2018-11-05 09:46:22');
INSERT INTO `j_oa_user_rank_log` VALUES ('54', '489538848231784576', '42', '吉客云开发', '新增职级', '2018-11-07 10:26:18');
INSERT INTO `j_oa_user_rank_log` VALUES ('55', '489549795189063808', '42', '吉客云开发', '新增职级', '2018-11-07 10:48:01');
INSERT INTO `j_oa_user_rank_log` VALUES ('56', '484669893067407488', '42', '吉客云开发', '删除职级', '2018-11-07 10:48:18');
INSERT INTO `j_oa_user_rank_log` VALUES ('57', '484635760643539072', '42', '吉客云开发', '修改职级', '2018-11-12 09:34:08');
INSERT INTO `j_oa_user_rank_log` VALUES ('58', '484678445162051712', '42', '吉客云开发', '修改职级', '2018-11-12 09:34:25');
INSERT INTO `j_oa_user_rank_log` VALUES ('59', '484658846906450048', '42', '吉客云开发', '修改职级', '2018-11-12 09:34:33');
INSERT INTO `j_oa_user_rank_log` VALUES ('60', '489538848231784576', '459215893833718912', '吉客云开发', '修改职级', '2018-11-12 11:08:33');

-- ----------------------------
-- Table structure for j_oa_user_skill_info
-- ----------------------------
DROP TABLE IF EXISTS `j_oa_user_skill_info`;
CREATE TABLE `j_oa_user_skill_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL COMMENT '人员id',
  `skill_name` varchar(50) DEFAULT NULL COMMENT '职称名称',
  `get_date` datetime DEFAULT NULL COMMENT '获得日期',
  `level` varchar(50) DEFAULT NULL COMMENT '等级',
  `memo` varchar(100) DEFAULT NULL COMMENT '备注',
  `gmt_create` datetime DEFAULT CURRENT_TIMESTAMP,
  `gmt_modified` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='人员档案技能职称';

-- ----------------------------
-- Records of j_oa_user_skill_info
-- ----------------------------
INSERT INTO `j_oa_user_skill_info` VALUES ('2', '2', 'CET-4', '2018-11-08 09:36:43', '4', '流畅', '2018-11-06 09:38:37', '2018-11-06 09:38:37');
INSERT INTO `j_oa_user_skill_info` VALUES ('3', '3', 'Oracle', '2018-11-09 09:37:07', '2', '应付', '2018-11-06 09:37:19', '2018-11-06 09:37:19');
INSERT INTO `j_oa_user_skill_info` VALUES ('4', '1', '唱歌', '2018-11-06 09:36:22', '1', '可以', '2018-11-06 09:36:37', '2018-11-07 09:48:13');

-- ----------------------------
-- Table structure for j_oa_user_special
-- ----------------------------
DROP TABLE IF EXISTS `j_oa_user_special`;
CREATE TABLE `j_oa_user_special` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL COMMENT '人员ID',
  `special_id` bigint(20) DEFAULT NULL COMMENT '特长ID',
  `gmt_create` datetime DEFAULT CURRENT_TIMESTAMP,
  `gmt_modified` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='人员档案-人员和特长关系表';

-- ----------------------------
-- Records of j_oa_user_special
-- ----------------------------
INSERT INTO `j_oa_user_special` VALUES ('3', '2', '3', '2018-11-02 13:34:41', '2018-11-02 13:34:41');
INSERT INTO `j_oa_user_special` VALUES ('4', '2', '1', '2018-11-02 13:34:46', '2018-11-02 13:34:46');
INSERT INTO `j_oa_user_special` VALUES ('5', '3', '3', '2018-11-02 13:34:50', '2018-11-02 13:34:50');
INSERT INTO `j_oa_user_special` VALUES ('6', '1', '1', '2018-11-06 21:50:20', '2018-11-06 21:50:20');
INSERT INTO `j_oa_user_special` VALUES ('7', '1', '2', '2018-11-06 21:50:20', '2018-11-06 21:50:20');

-- ----------------------------
-- Table structure for j_oa_user_special_info
-- ----------------------------
DROP TABLE IF EXISTS `j_oa_user_special_info`;
CREATE TABLE `j_oa_user_special_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `special_id` bigint(20) DEFAULT NULL COMMENT '技能特长ID',
  `special_name` varchar(100) DEFAULT NULL COMMENT '技能特长名称',
  `gmt_create` datetime DEFAULT CURRENT_TIMESTAMP,
  `gmt_modified` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='人员档案基本资料-特长';

-- ----------------------------
-- Records of j_oa_user_special_info
-- ----------------------------
INSERT INTO `j_oa_user_special_info` VALUES ('1', '1', '唱歌', '2018-11-02 13:35:01', '2018-11-02 13:35:01');
INSERT INTO `j_oa_user_special_info` VALUES ('2', '2', '跳舞', '2018-11-02 13:35:08', '2018-11-02 13:35:08');
INSERT INTO `j_oa_user_special_info` VALUES ('3', '3', '魔术', '2018-11-02 13:35:14', '2018-11-02 13:35:14');

-- ----------------------------
-- Table structure for j_oa_user_train_info
-- ----------------------------
DROP TABLE IF EXISTS `j_oa_user_train_info`;
CREATE TABLE `j_oa_user_train_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL COMMENT '人员id',
  `train_institution` varchar(100) DEFAULT NULL COMMENT '培训机构',
  `train_course` varchar(100) DEFAULT NULL COMMENT '培训课程',
  `qualification_certificate` varchar(100) DEFAULT NULL COMMENT '资格证书',
  `start_date` datetime DEFAULT NULL COMMENT '起始日期',
  `end_date` datetime DEFAULT NULL COMMENT '结束日期',
  `gmt_create` datetime DEFAULT CURRENT_TIMESTAMP,
  `gmt_modified` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='人员档案培训经历';

-- ----------------------------
-- Records of j_oa_user_train_info
-- ----------------------------

-- ----------------------------
-- Table structure for j_oa_user_work_experience_info
-- ----------------------------
DROP TABLE IF EXISTS `j_oa_user_work_experience_info`;
CREATE TABLE `j_oa_user_work_experience_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL COMMENT '人员id',
  `start_date` datetime DEFAULT NULL COMMENT '起始日期',
  `end_date` datetime DEFAULT NULL COMMENT '结束日期',
  `work_unit` varchar(50) DEFAULT NULL COMMENT '工作单位',
  `work_on` varchar(50) DEFAULT NULL COMMENT '从事事业',
  `work_type` tinyint(4) DEFAULT '0' COMMENT '任职类型  全职0  兼职1 实习0',
  `position` varchar(20) DEFAULT NULL COMMENT '职务',
  `leave_reason` varchar(20) DEFAULT NULL COMMENT '离职原因',
  `salary` varchar(20) DEFAULT NULL COMMENT '薪资',
  `certifier` varchar(20) DEFAULT NULL COMMENT '证明人',
  `certifier_phone` varchar(20) DEFAULT NULL COMMENT '证明人电话',
  `work_content` varchar(200) DEFAULT NULL COMMENT '主要职责和内容',
  `gmt_create` datetime DEFAULT CURRENT_TIMESTAMP,
  `gmt_modified` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='人员档案工作经历';

-- ----------------------------
-- Records of j_oa_user_work_experience_info
-- ----------------------------
INSERT INTO `j_oa_user_work_experience_info` VALUES ('1', '1', '2017-07-07 14:34:38', '2017-12-30 14:34:50', '阿里巴巴', '电子商务', '0', '主管', '跳槽', '8K', '刘老板', '123', '抽烟喝酒烫头', '2018-11-01 14:36:33', '2018-11-01 14:46:10');
INSERT INTO `j_oa_user_work_experience_info` VALUES ('3', '1', '2017-07-07 14:34:38', '2017-12-30 14:34:50', '阿里巴巴', '电子商务', '0', '主管', '跳槽', '8K', '刘老板', '123', '抽烟喝酒烫头', '2018-11-01 14:36:33', '2018-11-01 14:46:10');
INSERT INTO `j_oa_user_work_experience_info` VALUES ('4', '1', '2017-07-07 14:34:38', '2017-12-30 14:34:50', '阿里妈妈', '电子商务', '0', '主管', '跳槽', '8K', '刘老板', '123', '抽烟喝酒烫头', '2018-11-01 14:36:33', '2018-11-01 14:46:10');
INSERT INTO `j_oa_user_work_experience_info` VALUES ('5', '1', '2017-07-07 14:34:38', '2017-12-30 14:34:50', '阿里d妈', '电子商务', '0', '主管', '跳槽', '8K', '刘老板', '123', '抽烟喝酒烫头', '2018-11-01 14:36:33', '2018-11-01 14:46:10');
INSERT INTO `j_oa_user_work_experience_info` VALUES ('6', '4', '2017-07-07 14:34:38', '2017-12-30 14:34:50', '阿里d妈', '电子商务', '0', '主管', '跳槽', '8K', '刘老板', '123', '抽烟喝酒烫头', '2018-11-01 14:36:33', '2018-11-01 14:45:45');
