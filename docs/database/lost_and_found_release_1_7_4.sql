/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306_sailhe
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : lost_and_found

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2018-12-16 16:14:55
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for dst_address
-- ----------------------------
DROP TABLE IF EXISTS `dst_address`;
CREATE TABLE `dst_address` (
  `address_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `adr_reciver_name` varchar(20) DEFAULT NULL,
  `province_name` varchar(20) DEFAULT NULL,
  `city_name` varchar(20) DEFAULT NULL,
  `county_name` varchar(20) DEFAULT NULL,
  `street_name` varchar(20) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `adr_reciver_phone` varchar(13) DEFAULT NULL,
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `adr_is_default` tinyint(4) DEFAULT NULL,
  `adr_handle_time` datetime DEFAULT NULL,
  `adr_is_handle` tinyint(4) DEFAULT NULL,
  `edit_time` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`address_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dst_address
-- ----------------------------

-- ----------------------------
-- Table structure for dst_city
-- ----------------------------
DROP TABLE IF EXISTS `dst_city`;
CREATE TABLE `dst_city` (
  `city_id` int(11) NOT NULL AUTO_INCREMENT,
  `city_name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`city_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dst_city
-- ----------------------------
INSERT INTO `dst_city` VALUES ('1', '杭州');
INSERT INTO `dst_city` VALUES ('2', '宁波');
INSERT INTO `dst_city` VALUES ('3', '温州');
INSERT INTO `dst_city` VALUES ('4', '绍兴');
INSERT INTO `dst_city` VALUES ('5', '湖州');
INSERT INTO `dst_city` VALUES ('6', '嘉兴');
INSERT INTO `dst_city` VALUES ('7', '金华');
INSERT INTO `dst_city` VALUES ('8', '衢州');
INSERT INTO `dst_city` VALUES ('9', '台州');
INSERT INTO `dst_city` VALUES ('10', '丽水');
INSERT INTO `dst_city` VALUES ('11', '舟山');
INSERT INTO `dst_city` VALUES ('12', '');

-- ----------------------------
-- Table structure for dst_county
-- ----------------------------
DROP TABLE IF EXISTS `dst_county`;
CREATE TABLE `dst_county` (
  `county_id` int(11) NOT NULL AUTO_INCREMENT,
  `county_name` varchar(20) DEFAULT NULL,
  `city_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`county_id`)
) ENGINE=InnoDB AUTO_INCREMENT=91 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dst_county
-- ----------------------------
INSERT INTO `dst_county` VALUES ('1', '拱墅区', '1');
INSERT INTO `dst_county` VALUES ('2', '上城区', '1');
INSERT INTO `dst_county` VALUES ('3', '下城区', '1');
INSERT INTO `dst_county` VALUES ('4', '江干区', '1');
INSERT INTO `dst_county` VALUES ('5', '西湖区', '1');
INSERT INTO `dst_county` VALUES ('6', '滨江区', '1');
INSERT INTO `dst_county` VALUES ('7', '萧山区', '1');
INSERT INTO `dst_county` VALUES ('8', '余杭区', '1');
INSERT INTO `dst_county` VALUES ('9', '富阳区', '1');
INSERT INTO `dst_county` VALUES ('10', '临安区', '1');
INSERT INTO `dst_county` VALUES ('11', '桐庐县', '1');
INSERT INTO `dst_county` VALUES ('12', '淳安县', '1');
INSERT INTO `dst_county` VALUES ('13', '建德市', '1');
INSERT INTO `dst_county` VALUES ('14', '海曙区', '2');
INSERT INTO `dst_county` VALUES ('15', '江北区', '2');
INSERT INTO `dst_county` VALUES ('16', '北仑区', '2');
INSERT INTO `dst_county` VALUES ('17', '镇海区', '2');
INSERT INTO `dst_county` VALUES ('18', '鄞州区', '2');
INSERT INTO `dst_county` VALUES ('19', '奉化区', '2');
INSERT INTO `dst_county` VALUES ('20', '余姚市', '2');
INSERT INTO `dst_county` VALUES ('21', '慈溪市', '2');
INSERT INTO `dst_county` VALUES ('22', '象山县', '2');
INSERT INTO `dst_county` VALUES ('23', '宁海县', '2');
INSERT INTO `dst_county` VALUES ('24', '鹿城区', '3');
INSERT INTO `dst_county` VALUES ('25', '龙湾区', '3');
INSERT INTO `dst_county` VALUES ('26', '瓯海区', '3');
INSERT INTO `dst_county` VALUES ('27', '洞头区', '3');
INSERT INTO `dst_county` VALUES ('28', '瑞安市', '3');
INSERT INTO `dst_county` VALUES ('29', '乐清市', '3');
INSERT INTO `dst_county` VALUES ('30', '永嘉县', '3');
INSERT INTO `dst_county` VALUES ('31', '平阳县', '3');
INSERT INTO `dst_county` VALUES ('32', '苍南县', '3');
INSERT INTO `dst_county` VALUES ('33', '文成县', '3');
INSERT INTO `dst_county` VALUES ('34', '泰顺县', '3');
INSERT INTO `dst_county` VALUES ('35', '越城区', '4');
INSERT INTO `dst_county` VALUES ('36', '柯桥区', '4');
INSERT INTO `dst_county` VALUES ('37', '上虞区', '4');
INSERT INTO `dst_county` VALUES ('38', '新昌县', '4');
INSERT INTO `dst_county` VALUES ('39', '嵊州市', '4');
INSERT INTO `dst_county` VALUES ('40', '诸暨市', '4');
INSERT INTO `dst_county` VALUES ('41', '吴兴区', '5');
INSERT INTO `dst_county` VALUES ('42', '南浔区', '5');
INSERT INTO `dst_county` VALUES ('43', '德清县', '5');
INSERT INTO `dst_county` VALUES ('44', '长兴县', '5');
INSERT INTO `dst_county` VALUES ('45', '安吉县', '5');
INSERT INTO `dst_county` VALUES ('46', '南湖区', '6');
INSERT INTO `dst_county` VALUES ('47', '秀洲区', '6');
INSERT INTO `dst_county` VALUES ('48', '嘉善县', '6');
INSERT INTO `dst_county` VALUES ('49', '海盐县', '6');
INSERT INTO `dst_county` VALUES ('50', '海宁市', '6');
INSERT INTO `dst_county` VALUES ('51', '平湖市', '6');
INSERT INTO `dst_county` VALUES ('52', '桐乡市', '6');
INSERT INTO `dst_county` VALUES ('53', '婺城区', '7');
INSERT INTO `dst_county` VALUES ('54', '金东区', '7');
INSERT INTO `dst_county` VALUES ('55', '兰溪市', '7');
INSERT INTO `dst_county` VALUES ('56', '义乌市', '7');
INSERT INTO `dst_county` VALUES ('57', '东阳市', '7');
INSERT INTO `dst_county` VALUES ('58', '永康市', '7');
INSERT INTO `dst_county` VALUES ('59', '浦江县', '7');
INSERT INTO `dst_county` VALUES ('60', '武义县', '7');
INSERT INTO `dst_county` VALUES ('61', '磐安县', '7');
INSERT INTO `dst_county` VALUES ('62', '柯城区', '8');
INSERT INTO `dst_county` VALUES ('63', '衢江区', '8');
INSERT INTO `dst_county` VALUES ('64', '龙游县', '8');
INSERT INTO `dst_county` VALUES ('65', '江山市', '8');
INSERT INTO `dst_county` VALUES ('66', '常山县', '8');
INSERT INTO `dst_county` VALUES ('67', '开化县', '8');
INSERT INTO `dst_county` VALUES ('68', '椒江区', '9');
INSERT INTO `dst_county` VALUES ('69', '黄岩区', '9');
INSERT INTO `dst_county` VALUES ('70', '路桥区', '9');
INSERT INTO `dst_county` VALUES ('71', '临海市', '9');
INSERT INTO `dst_county` VALUES ('72', '温岭市', '9');
INSERT INTO `dst_county` VALUES ('73', '玉环市', '9');
INSERT INTO `dst_county` VALUES ('74', '天台县', '9');
INSERT INTO `dst_county` VALUES ('75', '仙居县', '9');
INSERT INTO `dst_county` VALUES ('76', '三门县', '9');
INSERT INTO `dst_county` VALUES ('77', '莲都区', '10');
INSERT INTO `dst_county` VALUES ('78', '龙泉市', '10');
INSERT INTO `dst_county` VALUES ('79', '青田县', '10');
INSERT INTO `dst_county` VALUES ('80', '云和县', '10');
INSERT INTO `dst_county` VALUES ('81', '景宁畲族自治县', '10');
INSERT INTO `dst_county` VALUES ('82', '庆元县', '10');
INSERT INTO `dst_county` VALUES ('83', '缙云县', '10');
INSERT INTO `dst_county` VALUES ('84', '遂昌县', '10');
INSERT INTO `dst_county` VALUES ('85', '松阳县', '10');
INSERT INTO `dst_county` VALUES ('86', '定海区', '11');
INSERT INTO `dst_county` VALUES ('87', '普陀区', '11');
INSERT INTO `dst_county` VALUES ('88', '岱山县', '11');
INSERT INTO `dst_county` VALUES ('89', '嵊泗县', '11');
INSERT INTO `dst_county` VALUES ('90', '', '12');

-- ----------------------------
-- Table structure for dst_street
-- ----------------------------
DROP TABLE IF EXISTS `dst_street`;
CREATE TABLE `dst_street` (
  `street_id` int(11) NOT NULL AUTO_INCREMENT,
  `street_name` varchar(20) DEFAULT NULL,
  `county_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`street_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1399 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dst_street
-- ----------------------------
INSERT INTO `dst_street` VALUES ('1', '米市巷街道', '1');
INSERT INTO `dst_street` VALUES ('2', '湖墅街道', '1');
INSERT INTO `dst_street` VALUES ('3', '小河街道', '1');
INSERT INTO `dst_street` VALUES ('4', '和睦街道', '1');
INSERT INTO `dst_street` VALUES ('5', '拱宸桥街道', '1');
INSERT INTO `dst_street` VALUES ('6', '大关街道', '1');
INSERT INTO `dst_street` VALUES ('7', '上塘街道', '1');
INSERT INTO `dst_street` VALUES ('8', '祥符街道', '1');
INSERT INTO `dst_street` VALUES ('9', '康桥街道', '1');
INSERT INTO `dst_street` VALUES ('10', '半山街道', '1');
INSERT INTO `dst_street` VALUES ('11', '清波街道', '2');
INSERT INTO `dst_street` VALUES ('12', '湖滨街道', '2');
INSERT INTO `dst_street` VALUES ('13', '小营街道', '2');
INSERT INTO `dst_street` VALUES ('14', '南星街道', '2');
INSERT INTO `dst_street` VALUES ('15', '紫阳街道', '2');
INSERT INTO `dst_street` VALUES ('16', '望江街道', '2');
INSERT INTO `dst_street` VALUES ('17', '长庆街道', '3');
INSERT INTO `dst_street` VALUES ('18', '武林街道', '3');
INSERT INTO `dst_street` VALUES ('19', '天水街道', '3');
INSERT INTO `dst_street` VALUES ('20', '潮鸣街道', '3');
INSERT INTO `dst_street` VALUES ('21', '朝晖街道', '3');
INSERT INTO `dst_street` VALUES ('22', '文晖街道', '3');
INSERT INTO `dst_street` VALUES ('23', '东新街道', '3');
INSERT INTO `dst_street` VALUES ('24', '石桥街道', '3');
INSERT INTO `dst_street` VALUES ('25', '凯旋街道', '4');
INSERT INTO `dst_street` VALUES ('26', '采荷街道', '4');
INSERT INTO `dst_street` VALUES ('27', '闸弄口街道', '4');
INSERT INTO `dst_street` VALUES ('28', '四季青街道', '4');
INSERT INTO `dst_street` VALUES ('29', '白杨街道', '4');
INSERT INTO `dst_street` VALUES ('30', '下沙街道', '4');
INSERT INTO `dst_street` VALUES ('31', '彭埠街道', '4');
INSERT INTO `dst_street` VALUES ('32', '笕桥街道', '4');
INSERT INTO `dst_street` VALUES ('33', '丁兰街道', '4');
INSERT INTO `dst_street` VALUES ('34', '九堡街道', '4');
INSERT INTO `dst_street` VALUES ('35', '北山街道', '5');
INSERT INTO `dst_street` VALUES ('36', '西溪街道', '5');
INSERT INTO `dst_street` VALUES ('37', '翠苑街道', '5');
INSERT INTO `dst_street` VALUES ('38', '古荡街道', '5');
INSERT INTO `dst_street` VALUES ('39', '西湖街道', '5');
INSERT INTO `dst_street` VALUES ('40', '留下街道', '5');
INSERT INTO `dst_street` VALUES ('41', '转塘街道', '5');
INSERT INTO `dst_street` VALUES ('42', '蒋村街道', '5');
INSERT INTO `dst_street` VALUES ('43', '灵隐街道', '5');
INSERT INTO `dst_street` VALUES ('44', '文新街道', '5');
INSERT INTO `dst_street` VALUES ('45', '三墩镇', '5');
INSERT INTO `dst_street` VALUES ('46', '双浦镇', '5');
INSERT INTO `dst_street` VALUES ('47', '西兴街道', '6');
INSERT INTO `dst_street` VALUES ('48', '长河街道', '6');
INSERT INTO `dst_street` VALUES ('49', '浦沿街道', '6');
INSERT INTO `dst_street` VALUES ('50', '城厢街道', '7');
INSERT INTO `dst_street` VALUES ('51', '北干街道', '7');
INSERT INTO `dst_street` VALUES ('52', '蜀山街道', '7');
INSERT INTO `dst_street` VALUES ('53', '新塘街道', '7');
INSERT INTO `dst_street` VALUES ('54', '靖江街道', '7');
INSERT INTO `dst_street` VALUES ('55', '南阳街道', '7');
INSERT INTO `dst_street` VALUES ('56', '义蓬街道', '7');
INSERT INTO `dst_street` VALUES ('57', '河庄街道', '7');
INSERT INTO `dst_street` VALUES ('58', '新湾街道', '7');
INSERT INTO `dst_street` VALUES ('59', '临江街道', '7');
INSERT INTO `dst_street` VALUES ('60', '前进街道', '7');
INSERT INTO `dst_street` VALUES ('61', '闻堰街道', '7');
INSERT INTO `dst_street` VALUES ('62', '宁围街道', '7');
INSERT INTO `dst_street` VALUES ('63', '新街街道', '7');
INSERT INTO `dst_street` VALUES ('64', '楼塔镇', '7');
INSERT INTO `dst_street` VALUES ('65', '河上镇', '7');
INSERT INTO `dst_street` VALUES ('66', '戴村镇', '7');
INSERT INTO `dst_street` VALUES ('67', '浦阳镇', '7');
INSERT INTO `dst_street` VALUES ('68', '进化镇', '7');
INSERT INTO `dst_street` VALUES ('69', '临浦镇', '7');
INSERT INTO `dst_street` VALUES ('70', '义桥镇', '7');
INSERT INTO `dst_street` VALUES ('71', '所前镇', '7');
INSERT INTO `dst_street` VALUES ('72', '衙前镇', '7');
INSERT INTO `dst_street` VALUES ('73', '瓜沥镇', '7');
INSERT INTO `dst_street` VALUES ('74', '益农镇', '7');
INSERT INTO `dst_street` VALUES ('75', '党湾镇', '7');
INSERT INTO `dst_street` VALUES ('76', '萧山经济技术开发区', '7');
INSERT INTO `dst_street` VALUES ('77', '萧山商业城', '7');
INSERT INTO `dst_street` VALUES ('78', '围垦区', '7');
INSERT INTO `dst_street` VALUES ('79', '红山农场', '7');
INSERT INTO `dst_street` VALUES ('80', '萧山钱江世纪城', '7');
INSERT INTO `dst_street` VALUES ('81', '临平街道', '8');
INSERT INTO `dst_street` VALUES ('82', '南苑街道', '8');
INSERT INTO `dst_street` VALUES ('83', '东湖街道', '8');
INSERT INTO `dst_street` VALUES ('84', '星桥街道', '8');
INSERT INTO `dst_street` VALUES ('85', '五常街道', '8');
INSERT INTO `dst_street` VALUES ('86', '乔司街道', '8');
INSERT INTO `dst_street` VALUES ('87', '运河街道', '8');
INSERT INTO `dst_street` VALUES ('88', '崇贤街道', '8');
INSERT INTO `dst_street` VALUES ('89', '仁和街道', '8');
INSERT INTO `dst_street` VALUES ('90', '良渚街道', '8');
INSERT INTO `dst_street` VALUES ('91', '闲林街道', '8');
INSERT INTO `dst_street` VALUES ('92', '仓前街道', '8');
INSERT INTO `dst_street` VALUES ('93', '余杭街道', '8');
INSERT INTO `dst_street` VALUES ('94', '中泰街道', '8');
INSERT INTO `dst_street` VALUES ('95', '塘栖镇', '8');
INSERT INTO `dst_street` VALUES ('96', '径山镇', '8');
INSERT INTO `dst_street` VALUES ('97', '瓶窑镇', '8');
INSERT INTO `dst_street` VALUES ('98', '鸬鸟镇', '8');
INSERT INTO `dst_street` VALUES ('99', '百丈镇', '8');
INSERT INTO `dst_street` VALUES ('100', '黄湖镇', '8');
INSERT INTO `dst_street` VALUES ('101', '富春街道', '9');
INSERT INTO `dst_street` VALUES ('102', '春江街道', '9');
INSERT INTO `dst_street` VALUES ('103', '鹿山街道', '9');
INSERT INTO `dst_street` VALUES ('104', '东洲街道', '9');
INSERT INTO `dst_street` VALUES ('105', '银湖街道', '9');
INSERT INTO `dst_street` VALUES ('106', '万市镇', '9');
INSERT INTO `dst_street` VALUES ('107', '洞桥镇', '9');
INSERT INTO `dst_street` VALUES ('108', '渌渚镇', '9');
INSERT INTO `dst_street` VALUES ('109', '永昌镇', '9');
INSERT INTO `dst_street` VALUES ('110', '里山镇', '9');
INSERT INTO `dst_street` VALUES ('111', '常绿镇', '9');
INSERT INTO `dst_street` VALUES ('112', '场口镇', '9');
INSERT INTO `dst_street` VALUES ('113', '常安镇', '9');
INSERT INTO `dst_street` VALUES ('114', '龙门镇', '9');
INSERT INTO `dst_street` VALUES ('115', '新登镇', '9');
INSERT INTO `dst_street` VALUES ('116', '胥口镇', '9');
INSERT INTO `dst_street` VALUES ('117', '大源镇', '9');
INSERT INTO `dst_street` VALUES ('118', '灵桥镇', '9');
INSERT INTO `dst_street` VALUES ('119', '新桐乡', '9');
INSERT INTO `dst_street` VALUES ('120', '上官乡', '9');
INSERT INTO `dst_street` VALUES ('121', '环山乡', '9');
INSERT INTO `dst_street` VALUES ('122', '湖源乡', '9');
INSERT INTO `dst_street` VALUES ('123', '春建乡', '9');
INSERT INTO `dst_street` VALUES ('124', '渔山乡', '9');
INSERT INTO `dst_street` VALUES ('125', '玲珑街道', '10');
INSERT INTO `dst_street` VALUES ('126', '锦南街道', '10');
INSERT INTO `dst_street` VALUES ('127', '锦城街道', '10');
INSERT INTO `dst_street` VALUES ('128', '锦北街道', '10');
INSERT INTO `dst_street` VALUES ('129', '青山湖街道', '10');
INSERT INTO `dst_street` VALUES ('130', '高虹镇', '10');
INSERT INTO `dst_street` VALUES ('131', '太湖源镇', '10');
INSERT INTO `dst_street` VALUES ('132', '於潜镇', '10');
INSERT INTO `dst_street` VALUES ('133', '太阳镇', '10');
INSERT INTO `dst_street` VALUES ('134', '潜川镇', '10');
INSERT INTO `dst_street` VALUES ('135', '昌化镇', '10');
INSERT INTO `dst_street` VALUES ('136', '河桥镇', '10');
INSERT INTO `dst_street` VALUES ('137', '湍口镇', '10');
INSERT INTO `dst_street` VALUES ('138', '清凉峰镇', '10');
INSERT INTO `dst_street` VALUES ('139', '岛石镇', '10');
INSERT INTO `dst_street` VALUES ('140', '板桥镇', '10');
INSERT INTO `dst_street` VALUES ('141', '天目山镇', '10');
INSERT INTO `dst_street` VALUES ('142', '龙岗镇', '10');
INSERT INTO `dst_street` VALUES ('143', '旧县街道', '11');
INSERT INTO `dst_street` VALUES ('144', '桐君街道', '11');
INSERT INTO `dst_street` VALUES ('145', '城南街道', '11');
INSERT INTO `dst_street` VALUES ('146', '凤川街道', '11');
INSERT INTO `dst_street` VALUES ('147', '富春江镇', '11');
INSERT INTO `dst_street` VALUES ('148', '横村镇', '11');
INSERT INTO `dst_street` VALUES ('149', '分水镇', '11');
INSERT INTO `dst_street` VALUES ('150', '瑶琳镇', '11');
INSERT INTO `dst_street` VALUES ('151', '百江镇', '11');
INSERT INTO `dst_street` VALUES ('152', '江南镇', '11');
INSERT INTO `dst_street` VALUES ('153', '莪山畲族乡', '11');
INSERT INTO `dst_street` VALUES ('154', '钟山乡', '11');
INSERT INTO `dst_street` VALUES ('155', '新合乡', '11');
INSERT INTO `dst_street` VALUES ('156', '合村乡', '11');
INSERT INTO `dst_street` VALUES ('157', '千岛湖镇', '12');
INSERT INTO `dst_street` VALUES ('158', '文昌镇', '12');
INSERT INTO `dst_street` VALUES ('159', '石林镇', '12');
INSERT INTO `dst_street` VALUES ('160', '临岐镇', '12');
INSERT INTO `dst_street` VALUES ('161', '威坪镇', '12');
INSERT INTO `dst_street` VALUES ('162', '姜家镇', '12');
INSERT INTO `dst_street` VALUES ('163', '梓桐镇', '12');
INSERT INTO `dst_street` VALUES ('164', '汾口镇', '12');
INSERT INTO `dst_street` VALUES ('165', '中洲镇', '12');
INSERT INTO `dst_street` VALUES ('166', '大墅镇', '12');
INSERT INTO `dst_street` VALUES ('167', '枫树岭镇', '12');
INSERT INTO `dst_street` VALUES ('168', '里商乡', '12');
INSERT INTO `dst_street` VALUES ('169', '金峰乡', '12');
INSERT INTO `dst_street` VALUES ('170', '富文乡', '12');
INSERT INTO `dst_street` VALUES ('171', '左口乡', '12');
INSERT INTO `dst_street` VALUES ('172', '屏门乡', '12');
INSERT INTO `dst_street` VALUES ('173', '瑶山乡', '12');
INSERT INTO `dst_street` VALUES ('174', '王阜乡', '12');
INSERT INTO `dst_street` VALUES ('175', '宋村乡', '12');
INSERT INTO `dst_street` VALUES ('176', '鸠坑乡', '12');
INSERT INTO `dst_street` VALUES ('177', '浪川乡', '12');
INSERT INTO `dst_street` VALUES ('178', '界首乡', '12');
INSERT INTO `dst_street` VALUES ('179', '安阳乡', '12');
INSERT INTO `dst_street` VALUES ('180', '新安江街道', '13');
INSERT INTO `dst_street` VALUES ('181', '洋溪街道', '13');
INSERT INTO `dst_street` VALUES ('182', '更楼街道', '13');
INSERT INTO `dst_street` VALUES ('183', '莲花镇', '13');
INSERT INTO `dst_street` VALUES ('184', '乾潭镇', '13');
INSERT INTO `dst_street` VALUES ('185', '梅城镇', '13');
INSERT INTO `dst_street` VALUES ('186', '杨村桥镇', '13');
INSERT INTO `dst_street` VALUES ('187', '下涯镇', '13');
INSERT INTO `dst_street` VALUES ('188', '大洋镇', '13');
INSERT INTO `dst_street` VALUES ('189', '三都镇', '13');
INSERT INTO `dst_street` VALUES ('190', '寿昌镇', '13');
INSERT INTO `dst_street` VALUES ('191', '航头镇', '13');
INSERT INTO `dst_street` VALUES ('192', '大慈岩镇', '13');
INSERT INTO `dst_street` VALUES ('193', '大同镇', '13');
INSERT INTO `dst_street` VALUES ('194', '李家镇', '13');
INSERT INTO `dst_street` VALUES ('195', '钦堂乡', '13');
INSERT INTO `dst_street` VALUES ('196', '南门街道', '14');
INSERT INTO `dst_street` VALUES ('197', '江厦街道', '14');
INSERT INTO `dst_street` VALUES ('198', '西门街道', '14');
INSERT INTO `dst_street` VALUES ('199', '月湖街道', '14');
INSERT INTO `dst_street` VALUES ('200', '鼓楼街道', '14');
INSERT INTO `dst_street` VALUES ('201', '白云街道', '14');
INSERT INTO `dst_street` VALUES ('202', '段塘街道', '14');
INSERT INTO `dst_street` VALUES ('203', '望春街道', '14');
INSERT INTO `dst_street` VALUES ('204', '石碶街道', '14');
INSERT INTO `dst_street` VALUES ('205', '高桥镇', '14');
INSERT INTO `dst_street` VALUES ('206', '横街镇', '14');
INSERT INTO `dst_street` VALUES ('207', '集士港镇', '14');
INSERT INTO `dst_street` VALUES ('208', '古林镇', '14');
INSERT INTO `dst_street` VALUES ('209', '洞桥镇', '14');
INSERT INTO `dst_street` VALUES ('210', '鄞江镇', '14');
INSERT INTO `dst_street` VALUES ('211', '章水镇', '14');
INSERT INTO `dst_street` VALUES ('212', '龙观乡', '14');
INSERT INTO `dst_street` VALUES ('213', '中马街道', '15');
INSERT INTO `dst_street` VALUES ('214', '白沙街道', '15');
INSERT INTO `dst_street` VALUES ('215', '孔浦街道', '15');
INSERT INTO `dst_street` VALUES ('216', '文教街道', '15');
INSERT INTO `dst_street` VALUES ('217', '甬江街道', '15');
INSERT INTO `dst_street` VALUES ('218', '庄桥街道', '15');
INSERT INTO `dst_street` VALUES ('219', '洪塘街道', '15');
INSERT INTO `dst_street` VALUES ('220', '慈城镇', '15');
INSERT INTO `dst_street` VALUES ('221', '大榭街道', '16');
INSERT INTO `dst_street` VALUES ('222', '新碶街道', '16');
INSERT INTO `dst_street` VALUES ('223', '小港街道', '16');
INSERT INTO `dst_street` VALUES ('224', '大碶街道', '16');
INSERT INTO `dst_street` VALUES ('225', '霞浦街道', '16');
INSERT INTO `dst_street` VALUES ('226', '柴桥街道', '16');
INSERT INTO `dst_street` VALUES ('227', '戚家山街道', '16');
INSERT INTO `dst_street` VALUES ('228', '春晓街道', '16');
INSERT INTO `dst_street` VALUES ('229', '梅山街道', '16');
INSERT INTO `dst_street` VALUES ('230', '郭巨街道', '16');
INSERT INTO `dst_street` VALUES ('231', '白峰街道', '16');
INSERT INTO `dst_street` VALUES ('232', '保税区', '16');
INSERT INTO `dst_street` VALUES ('233', '招宝山街道', '17');
INSERT INTO `dst_street` VALUES ('234', '蛟川街道', '17');
INSERT INTO `dst_street` VALUES ('235', '骆驼街道', '17');
INSERT INTO `dst_street` VALUES ('236', '庄市街道', '17');
INSERT INTO `dst_street` VALUES ('237', '贵驷街道', '17');
INSERT INTO `dst_street` VALUES ('238', '澥浦镇', '17');
INSERT INTO `dst_street` VALUES ('239', '九龙湖镇', '17');
INSERT INTO `dst_street` VALUES ('240', '下应街道', '18');
INSERT INTO `dst_street` VALUES ('241', '钟公庙街道', '18');
INSERT INTO `dst_street` VALUES ('242', '梅墟街道', '18');
INSERT INTO `dst_street` VALUES ('243', '中河街道', '18');
INSERT INTO `dst_street` VALUES ('244', '首南街道', '18');
INSERT INTO `dst_street` VALUES ('245', '潘火街道', '18');
INSERT INTO `dst_street` VALUES ('246', '百丈街道', '18');
INSERT INTO `dst_street` VALUES ('247', '东胜街道', '18');
INSERT INTO `dst_street` VALUES ('248', '明楼街道', '18');
INSERT INTO `dst_street` VALUES ('249', '白鹤街道', '18');
INSERT INTO `dst_street` VALUES ('250', '东柳街道', '18');
INSERT INTO `dst_street` VALUES ('251', '东郊街道', '18');
INSERT INTO `dst_street` VALUES ('252', '福明街道', '18');
INSERT INTO `dst_street` VALUES ('253', '新明街道', '18');
INSERT INTO `dst_street` VALUES ('254', '瞻岐镇', '18');
INSERT INTO `dst_street` VALUES ('255', '咸祥镇', '18');
INSERT INTO `dst_street` VALUES ('256', '塘溪镇', '18');
INSERT INTO `dst_street` VALUES ('257', '东钱湖镇', '18');
INSERT INTO `dst_street` VALUES ('258', '东吴镇', '18');
INSERT INTO `dst_street` VALUES ('259', '五乡镇', '18');
INSERT INTO `dst_street` VALUES ('260', '邱隘镇', '18');
INSERT INTO `dst_street` VALUES ('261', '云龙镇', '18');
INSERT INTO `dst_street` VALUES ('262', '横溪镇', '18');
INSERT INTO `dst_street` VALUES ('263', '姜山镇', '18');
INSERT INTO `dst_street` VALUES ('264', '锦屏街道', '19');
INSERT INTO `dst_street` VALUES ('265', '岳林街道', '19');
INSERT INTO `dst_street` VALUES ('266', '江口街道', '19');
INSERT INTO `dst_street` VALUES ('267', '西坞街道', '19');
INSERT INTO `dst_street` VALUES ('268', '萧王庙街道', '19');
INSERT INTO `dst_street` VALUES ('269', '溪口镇', '19');
INSERT INTO `dst_street` VALUES ('270', '尚田镇', '19');
INSERT INTO `dst_street` VALUES ('271', '莼湖镇', '19');
INSERT INTO `dst_street` VALUES ('272', '裘村镇', '19');
INSERT INTO `dst_street` VALUES ('273', '大堰镇', '19');
INSERT INTO `dst_street` VALUES ('274', '松岙镇', '19');
INSERT INTO `dst_street` VALUES ('275', '梨洲街道', '20');
INSERT INTO `dst_street` VALUES ('276', '凤山街道', '20');
INSERT INTO `dst_street` VALUES ('277', '兰江街道', '20');
INSERT INTO `dst_street` VALUES ('278', '阳明街道', '20');
INSERT INTO `dst_street` VALUES ('279', '低塘街道', '20');
INSERT INTO `dst_street` VALUES ('280', '朗霞街道', '20');
INSERT INTO `dst_street` VALUES ('281', '临山镇', '20');
INSERT INTO `dst_street` VALUES ('282', '黄家埠镇', '20');
INSERT INTO `dst_street` VALUES ('283', '小曹娥镇', '20');
INSERT INTO `dst_street` VALUES ('284', '泗门镇', '20');
INSERT INTO `dst_street` VALUES ('285', '马渚镇', '20');
INSERT INTO `dst_street` VALUES ('286', '牟山镇', '20');
INSERT INTO `dst_street` VALUES ('287', '丈亭镇', '20');
INSERT INTO `dst_street` VALUES ('288', '三七市镇', '20');
INSERT INTO `dst_street` VALUES ('289', '河姆渡镇', '20');
INSERT INTO `dst_street` VALUES ('290', '大隐镇', '20');
INSERT INTO `dst_street` VALUES ('291', '陆埠镇', '20');
INSERT INTO `dst_street` VALUES ('292', '梁弄镇', '20');
INSERT INTO `dst_street` VALUES ('293', '大岚镇', '20');
INSERT INTO `dst_street` VALUES ('294', '四明山镇', '20');
INSERT INTO `dst_street` VALUES ('295', '鹿亭乡', '20');
INSERT INTO `dst_street` VALUES ('296', '宗汉街道', '21');
INSERT INTO `dst_street` VALUES ('297', '坎墩街道', '21');
INSERT INTO `dst_street` VALUES ('298', '浒山街道', '21');
INSERT INTO `dst_street` VALUES ('299', '白沙路街道', '21');
INSERT INTO `dst_street` VALUES ('300', '古塘街道', '21');
INSERT INTO `dst_street` VALUES ('301', '掌起镇', '21');
INSERT INTO `dst_street` VALUES ('302', '观海卫镇', '21');
INSERT INTO `dst_street` VALUES ('303', '附海镇', '21');
INSERT INTO `dst_street` VALUES ('304', '桥头镇', '21');
INSERT INTO `dst_street` VALUES ('305', '匡堰镇', '21');
INSERT INTO `dst_street` VALUES ('306', '逍林镇', '21');
INSERT INTO `dst_street` VALUES ('307', '新浦镇', '21');
INSERT INTO `dst_street` VALUES ('308', '胜山镇', '21');
INSERT INTO `dst_street` VALUES ('309', '横河镇', '21');
INSERT INTO `dst_street` VALUES ('310', '崇寿镇', '21');
INSERT INTO `dst_street` VALUES ('311', '庵东镇', '21');
INSERT INTO `dst_street` VALUES ('312', '长河镇', '21');
INSERT INTO `dst_street` VALUES ('313', '周巷镇', '21');
INSERT INTO `dst_street` VALUES ('314', '龙山镇', '21');
INSERT INTO `dst_street` VALUES ('315', '慈溪市农垦场', '21');
INSERT INTO `dst_street` VALUES ('316', '慈溪市林场', '21');
INSERT INTO `dst_street` VALUES ('317', '慈东工业区', '21');
INSERT INTO `dst_street` VALUES ('318', '丹东街道', '22');
INSERT INTO `dst_street` VALUES ('319', '丹西街道', '22');
INSERT INTO `dst_street` VALUES ('320', '爵溪街道', '22');
INSERT INTO `dst_street` VALUES ('321', '石浦镇', '22');
INSERT INTO `dst_street` VALUES ('322', '西周镇', '22');
INSERT INTO `dst_street` VALUES ('323', '鹤浦镇', '22');
INSERT INTO `dst_street` VALUES ('324', '贤庠镇', '22');
INSERT INTO `dst_street` VALUES ('325', '墙头镇', '22');
INSERT INTO `dst_street` VALUES ('326', '泗洲头镇', '22');
INSERT INTO `dst_street` VALUES ('327', '定塘镇', '22');
INSERT INTO `dst_street` VALUES ('328', '涂茨镇', '22');
INSERT INTO `dst_street` VALUES ('329', '大徐镇', '22');
INSERT INTO `dst_street` VALUES ('330', '新桥镇', '22');
INSERT INTO `dst_street` VALUES ('331', '东陈乡', '22');
INSERT INTO `dst_street` VALUES ('332', '晓塘乡', '22');
INSERT INTO `dst_street` VALUES ('333', '黄避岙乡', '22');
INSERT INTO `dst_street` VALUES ('334', '茅洋乡', '22');
INSERT INTO `dst_street` VALUES ('335', '高塘岛乡', '22');
INSERT INTO `dst_street` VALUES ('336', '跃龙街道', '23');
INSERT INTO `dst_street` VALUES ('337', '桃源街道', '23');
INSERT INTO `dst_street` VALUES ('338', '梅林街道', '23');
INSERT INTO `dst_street` VALUES ('339', '桥头胡街道', '23');
INSERT INTO `dst_street` VALUES ('340', '长街镇', '23');
INSERT INTO `dst_street` VALUES ('341', '力洋镇', '23');
INSERT INTO `dst_street` VALUES ('342', '一市镇', '23');
INSERT INTO `dst_street` VALUES ('343', '岔路镇', '23');
INSERT INTO `dst_street` VALUES ('344', '前童镇', '23');
INSERT INTO `dst_street` VALUES ('345', '桑洲镇', '23');
INSERT INTO `dst_street` VALUES ('346', '黄坛镇', '23');
INSERT INTO `dst_street` VALUES ('347', '大佳何镇', '23');
INSERT INTO `dst_street` VALUES ('348', '强蛟镇', '23');
INSERT INTO `dst_street` VALUES ('349', '西店镇', '23');
INSERT INTO `dst_street` VALUES ('350', '深甽镇', '23');
INSERT INTO `dst_street` VALUES ('351', '胡陈乡', '23');
INSERT INTO `dst_street` VALUES ('352', '茶院乡', '23');
INSERT INTO `dst_street` VALUES ('353', '越溪乡', '23');
INSERT INTO `dst_street` VALUES ('354', '五马街道', '24');
INSERT INTO `dst_street` VALUES ('355', '七都街道', '24');
INSERT INTO `dst_street` VALUES ('356', '滨江街道', '24');
INSERT INTO `dst_street` VALUES ('357', '南汇街道', '24');
INSERT INTO `dst_street` VALUES ('358', '松台街道', '24');
INSERT INTO `dst_street` VALUES ('359', '双屿街道', '24');
INSERT INTO `dst_street` VALUES ('360', '仰义街道', '24');
INSERT INTO `dst_street` VALUES ('361', '大南街道', '24');
INSERT INTO `dst_street` VALUES ('362', '蒲鞋市街道', '24');
INSERT INTO `dst_street` VALUES ('363', '南郊街道', '24');
INSERT INTO `dst_street` VALUES ('364', '广化街道', '24');
INSERT INTO `dst_street` VALUES ('365', '丰门街道', '24');
INSERT INTO `dst_street` VALUES ('366', '藤桥镇', '24');
INSERT INTO `dst_street` VALUES ('367', '山福镇', '24');
INSERT INTO `dst_street` VALUES ('368', '永中街道', '25');
INSERT INTO `dst_street` VALUES ('369', '蒲州街道', '25');
INSERT INTO `dst_street` VALUES ('370', '海滨街道', '25');
INSERT INTO `dst_street` VALUES ('371', '永兴街道', '25');
INSERT INTO `dst_street` VALUES ('372', '状元街道', '25');
INSERT INTO `dst_street` VALUES ('373', '瑶溪街道', '25');
INSERT INTO `dst_street` VALUES ('374', '景山街道', '26');
INSERT INTO `dst_street` VALUES ('375', '梧田街道', '26');
INSERT INTO `dst_street` VALUES ('376', '南白象街道', '26');
INSERT INTO `dst_street` VALUES ('377', '茶山街道', '26');
INSERT INTO `dst_street` VALUES ('378', '娄桥街道', '26');
INSERT INTO `dst_street` VALUES ('379', '新桥街道', '26');
INSERT INTO `dst_street` VALUES ('380', '三垟街道', '26');
INSERT INTO `dst_street` VALUES ('381', '瞿溪街道', '26');
INSERT INTO `dst_street` VALUES ('382', '郭溪街道', '26');
INSERT INTO `dst_street` VALUES ('383', '潘桥街道', '26');
INSERT INTO `dst_street` VALUES ('384', '丽岙街道', '26');
INSERT INTO `dst_street` VALUES ('385', '仙岩街道', '26');
INSERT INTO `dst_street` VALUES ('386', '泽雅镇', '26');
INSERT INTO `dst_street` VALUES ('387', '北岙街道', '27');
INSERT INTO `dst_street` VALUES ('388', '灵昆街道', '27');
INSERT INTO `dst_street` VALUES ('389', '东屏街道', '27');
INSERT INTO `dst_street` VALUES ('390', '元觉街道', '27');
INSERT INTO `dst_street` VALUES ('391', '霓屿街道', '27');
INSERT INTO `dst_street` VALUES ('392', '大门镇', '27');
INSERT INTO `dst_street` VALUES ('393', '鹿西乡', '27');
INSERT INTO `dst_street` VALUES ('394', '安阳街道', '28');
INSERT INTO `dst_street` VALUES ('395', '玉海街道', '28');
INSERT INTO `dst_street` VALUES ('396', '锦湖街道', '28');
INSERT INTO `dst_street` VALUES ('397', '东山街道', '28');
INSERT INTO `dst_street` VALUES ('398', '上望街道', '28');
INSERT INTO `dst_street` VALUES ('399', '莘塍街道', '28');
INSERT INTO `dst_street` VALUES ('400', '汀田街道', '28');
INSERT INTO `dst_street` VALUES ('401', '飞云街道', '28');
INSERT INTO `dst_street` VALUES ('402', '仙降街道', '28');
INSERT INTO `dst_street` VALUES ('403', '南滨街道', '28');
INSERT INTO `dst_street` VALUES ('404', '潘岱街道', '28');
INSERT INTO `dst_street` VALUES ('405', '云周街道', '28');
INSERT INTO `dst_street` VALUES ('406', '塘下镇', '28');
INSERT INTO `dst_street` VALUES ('407', '马屿镇', '28');
INSERT INTO `dst_street` VALUES ('408', '陶山镇', '28');
INSERT INTO `dst_street` VALUES ('409', '湖岭镇', '28');
INSERT INTO `dst_street` VALUES ('410', '高楼镇', '28');
INSERT INTO `dst_street` VALUES ('411', '桐浦镇', '28');
INSERT INTO `dst_street` VALUES ('412', '林川镇', '28');
INSERT INTO `dst_street` VALUES ('413', '曹村镇', '28');
INSERT INTO `dst_street` VALUES ('414', '平阳坑镇', '28');
INSERT INTO `dst_street` VALUES ('415', '芳庄乡', '28');
INSERT INTO `dst_street` VALUES ('416', '北麂乡', '28');
INSERT INTO `dst_street` VALUES ('417', '城东街道办事处', '29');
INSERT INTO `dst_street` VALUES ('418', '乐成街道办事处', '29');
INSERT INTO `dst_street` VALUES ('419', '城南街道办事处', '29');
INSERT INTO `dst_street` VALUES ('420', '盐盆街道办事处', '29');
INSERT INTO `dst_street` VALUES ('421', '翁垟街道办事处', '29');
INSERT INTO `dst_street` VALUES ('422', '白石街道办事处', '29');
INSERT INTO `dst_street` VALUES ('423', '石帆街道办事处', '29');
INSERT INTO `dst_street` VALUES ('424', '天成街道办事处', '29');
INSERT INTO `dst_street` VALUES ('425', '大荆镇', '29');
INSERT INTO `dst_street` VALUES ('426', '仙溪镇', '29');
INSERT INTO `dst_street` VALUES ('427', '雁荡镇', '29');
INSERT INTO `dst_street` VALUES ('428', '芙蓉镇', '29');
INSERT INTO `dst_street` VALUES ('429', '清江镇', '29');
INSERT INTO `dst_street` VALUES ('430', '虹桥镇', '29');
INSERT INTO `dst_street` VALUES ('431', '淡溪镇', '29');
INSERT INTO `dst_street` VALUES ('432', '柳市镇', '29');
INSERT INTO `dst_street` VALUES ('433', '北白象镇', '29');
INSERT INTO `dst_street` VALUES ('434', '湖雾镇', '29');
INSERT INTO `dst_street` VALUES ('435', '南塘镇', '29');
INSERT INTO `dst_street` VALUES ('436', '南岳镇', '29');
INSERT INTO `dst_street` VALUES ('437', '蒲岐镇', '29');
INSERT INTO `dst_street` VALUES ('438', '磐石镇', '29');
INSERT INTO `dst_street` VALUES ('439', '智仁乡', '29');
INSERT INTO `dst_street` VALUES ('440', '龙西乡', '29');
INSERT INTO `dst_street` VALUES ('441', '岭底乡', '29');
INSERT INTO `dst_street` VALUES ('442', '东城街道', '30');
INSERT INTO `dst_street` VALUES ('443', '北城街道', '30');
INSERT INTO `dst_street` VALUES ('444', '南城街道', '30');
INSERT INTO `dst_street` VALUES ('445', '三江街道', '30');
INSERT INTO `dst_street` VALUES ('446', '黄田街道', '30');
INSERT INTO `dst_street` VALUES ('447', '乌牛街道', '30');
INSERT INTO `dst_street` VALUES ('448', '瓯北街道', '30');
INSERT INTO `dst_street` VALUES ('449', '桥头镇', '30');
INSERT INTO `dst_street` VALUES ('450', '桥下镇', '30');
INSERT INTO `dst_street` VALUES ('451', '大若岩镇', '30');
INSERT INTO `dst_street` VALUES ('452', '碧莲镇', '30');
INSERT INTO `dst_street` VALUES ('453', '巽宅镇', '30');
INSERT INTO `dst_street` VALUES ('454', '岩头镇', '30');
INSERT INTO `dst_street` VALUES ('455', '枫林镇', '30');
INSERT INTO `dst_street` VALUES ('456', '岩坦镇', '30');
INSERT INTO `dst_street` VALUES ('457', '沙头镇', '30');
INSERT INTO `dst_street` VALUES ('458', '鹤盛镇', '30');
INSERT INTO `dst_street` VALUES ('459', '金溪镇', '30');
INSERT INTO `dst_street` VALUES ('460', '云岭乡', '30');
INSERT INTO `dst_street` VALUES ('461', '茗岙乡', '30');
INSERT INTO `dst_street` VALUES ('462', '溪下乡', '30');
INSERT INTO `dst_street` VALUES ('463', '界坑乡', '30');
INSERT INTO `dst_street` VALUES ('464', '县特产场场区', '30');
INSERT INTO `dst_street` VALUES ('465', '四海山林场', '30');
INSERT INTO `dst_street` VALUES ('466', '正江山林场', '30');
INSERT INTO `dst_street` VALUES ('467', '昆阳镇', '31');
INSERT INTO `dst_street` VALUES ('468', '鳌江镇', '31');
INSERT INTO `dst_street` VALUES ('469', '水头镇', '31');
INSERT INTO `dst_street` VALUES ('470', '萧江镇', '31');
INSERT INTO `dst_street` VALUES ('471', '腾蛟镇', '31');
INSERT INTO `dst_street` VALUES ('472', '山门镇', '31');
INSERT INTO `dst_street` VALUES ('473', '顺溪镇', '31');
INSERT INTO `dst_street` VALUES ('474', '南雁镇', '31');
INSERT INTO `dst_street` VALUES ('475', '万全镇', '31');
INSERT INTO `dst_street` VALUES ('476', '海西镇', '31');
INSERT INTO `dst_street` VALUES ('477', '南麂镇', '31');
INSERT INTO `dst_street` VALUES ('478', '麻步镇', '31');
INSERT INTO `dst_street` VALUES ('479', '凤卧镇', '31');
INSERT INTO `dst_street` VALUES ('480', '怀溪镇', '31');
INSERT INTO `dst_street` VALUES ('481', '青街畲族乡', '31');
INSERT INTO `dst_street` VALUES ('482', '闹村乡', '31');
INSERT INTO `dst_street` VALUES ('483', '滨海新区', '31');
INSERT INTO `dst_street` VALUES ('484', '灵溪镇', '32');
INSERT INTO `dst_street` VALUES ('485', '龙港镇', '32');
INSERT INTO `dst_street` VALUES ('486', '宜山镇', '32');
INSERT INTO `dst_street` VALUES ('487', '钱库镇', '32');
INSERT INTO `dst_street` VALUES ('488', '金乡镇', '32');
INSERT INTO `dst_street` VALUES ('489', '藻溪镇', '32');
INSERT INTO `dst_street` VALUES ('490', '桥墩镇', '32');
INSERT INTO `dst_street` VALUES ('491', '矾山镇', '32');
INSERT INTO `dst_street` VALUES ('492', '赤溪镇', '32');
INSERT INTO `dst_street` VALUES ('493', '马站镇', '32');
INSERT INTO `dst_street` VALUES ('494', '望里镇', '32');
INSERT INTO `dst_street` VALUES ('495', '炎亭镇', '32');
INSERT INTO `dst_street` VALUES ('496', '大渔镇', '32');
INSERT INTO `dst_street` VALUES ('497', '莒溪镇', '32');
INSERT INTO `dst_street` VALUES ('498', '南宋镇', '32');
INSERT INTO `dst_street` VALUES ('499', '霞关镇', '32');
INSERT INTO `dst_street` VALUES ('500', '沿浦镇', '32');
INSERT INTO `dst_street` VALUES ('501', '凤阳畲族乡', '32');
INSERT INTO `dst_street` VALUES ('502', '岱岭畲族乡', '32');
INSERT INTO `dst_street` VALUES ('503', '大峃镇', '33');
INSERT INTO `dst_street` VALUES ('504', '百丈漈镇', '33');
INSERT INTO `dst_street` VALUES ('505', '南田镇', '33');
INSERT INTO `dst_street` VALUES ('506', '西坑畲族镇', '33');
INSERT INTO `dst_street` VALUES ('507', '黄坦镇', '33');
INSERT INTO `dst_street` VALUES ('508', '珊溪镇', '33');
INSERT INTO `dst_street` VALUES ('509', '巨屿镇', '33');
INSERT INTO `dst_street` VALUES ('510', '玉壶镇', '33');
INSERT INTO `dst_street` VALUES ('511', '峃口镇', '33');
INSERT INTO `dst_street` VALUES ('512', '周壤镇', '33');
INSERT INTO `dst_street` VALUES ('513', '铜铃山镇', '33');
INSERT INTO `dst_street` VALUES ('514', '二源镇', '33');
INSERT INTO `dst_street` VALUES ('515', '周山畲族乡', '33');
INSERT INTO `dst_street` VALUES ('516', '桂山乡', '33');
INSERT INTO `dst_street` VALUES ('517', '双桂乡', '33');
INSERT INTO `dst_street` VALUES ('518', '平和乡', '33');
INSERT INTO `dst_street` VALUES ('519', '公阳乡', '33');
INSERT INTO `dst_street` VALUES ('520', '罗阳镇', '34');
INSERT INTO `dst_street` VALUES ('521', '司前畲族镇', '34');
INSERT INTO `dst_street` VALUES ('522', '百丈镇', '34');
INSERT INTO `dst_street` VALUES ('523', '筱村镇', '34');
INSERT INTO `dst_street` VALUES ('524', '泗溪镇', '34');
INSERT INTO `dst_street` VALUES ('525', '彭溪镇', '34');
INSERT INTO `dst_street` VALUES ('526', '雅阳镇', '34');
INSERT INTO `dst_street` VALUES ('527', '仕阳镇', '34');
INSERT INTO `dst_street` VALUES ('528', '三魁镇', '34');
INSERT INTO `dst_street` VALUES ('529', '南浦溪镇', '34');
INSERT INTO `dst_street` VALUES ('530', '龟湖镇', '34');
INSERT INTO `dst_street` VALUES ('531', '西旸镇', '34');
INSERT INTO `dst_street` VALUES ('532', '竹里畲族乡', '34');
INSERT INTO `dst_street` VALUES ('533', '包垟乡', '34');
INSERT INTO `dst_street` VALUES ('534', '凤垟乡', '34');
INSERT INTO `dst_street` VALUES ('535', '东溪乡', '34');
INSERT INTO `dst_street` VALUES ('536', '柳峰乡', '34');
INSERT INTO `dst_street` VALUES ('537', '雪溪乡', '34');
INSERT INTO `dst_street` VALUES ('538', '大安乡', '34');
INSERT INTO `dst_street` VALUES ('539', '乌岩岭自然保护区', '34');
INSERT INTO `dst_street` VALUES ('540', '塔山街道', '35');
INSERT INTO `dst_street` VALUES ('541', '府山街道', '35');
INSERT INTO `dst_street` VALUES ('542', '蕺山街道', '35');
INSERT INTO `dst_street` VALUES ('543', '北海街道', '35');
INSERT INTO `dst_street` VALUES ('544', '城南街道', '35');
INSERT INTO `dst_street` VALUES ('545', '稽山街道', '35');
INSERT INTO `dst_street` VALUES ('546', '迪荡街道', '35');
INSERT INTO `dst_street` VALUES ('547', '东湖街道', '35');
INSERT INTO `dst_street` VALUES ('548', '灵芝街道', '35');
INSERT INTO `dst_street` VALUES ('549', '东浦街道', '35');
INSERT INTO `dst_street` VALUES ('550', '鉴湖街道', '35');
INSERT INTO `dst_street` VALUES ('551', '斗门街道', '35');
INSERT INTO `dst_street` VALUES ('552', '皋埠镇', '35');
INSERT INTO `dst_street` VALUES ('553', '马山镇', '35');
INSERT INTO `dst_street` VALUES ('554', '孙端镇', '35');
INSERT INTO `dst_street` VALUES ('555', '富盛镇', '35');
INSERT INTO `dst_street` VALUES ('556', '陶堰镇', '35');
INSERT INTO `dst_street` VALUES ('557', '柯桥街道', '36');
INSERT INTO `dst_street` VALUES ('558', '柯岩街道', '36');
INSERT INTO `dst_street` VALUES ('559', '华舍街道', '36');
INSERT INTO `dst_street` VALUES ('560', '湖塘街道', '36');
INSERT INTO `dst_street` VALUES ('561', '齐贤街道', '36');
INSERT INTO `dst_street` VALUES ('562', '福全街道', '36');
INSERT INTO `dst_street` VALUES ('563', '安昌街道', '36');
INSERT INTO `dst_street` VALUES ('564', '兰亭街道', '36');
INSERT INTO `dst_street` VALUES ('565', '钱清镇', '36');
INSERT INTO `dst_street` VALUES ('566', '马鞍镇', '36');
INSERT INTO `dst_street` VALUES ('567', '平水镇', '36');
INSERT INTO `dst_street` VALUES ('568', '王坛镇', '36');
INSERT INTO `dst_street` VALUES ('569', '稽东镇', '36');
INSERT INTO `dst_street` VALUES ('570', '杨汛桥镇', '36');
INSERT INTO `dst_street` VALUES ('571', '漓渚镇', '36');
INSERT INTO `dst_street` VALUES ('572', '夏履镇', '36');
INSERT INTO `dst_street` VALUES ('573', '百官街道', '37');
INSERT INTO `dst_street` VALUES ('574', '曹娥街道', '37');
INSERT INTO `dst_street` VALUES ('575', '东关街道', '37');
INSERT INTO `dst_street` VALUES ('576', '道墟街道', '37');
INSERT INTO `dst_street` VALUES ('577', '梁湖街道', '37');
INSERT INTO `dst_street` VALUES ('578', '小越街道', '37');
INSERT INTO `dst_street` VALUES ('579', '长塘镇', '37');
INSERT INTO `dst_street` VALUES ('580', '上浦镇', '37');
INSERT INTO `dst_street` VALUES ('581', '汤浦镇', '37');
INSERT INTO `dst_street` VALUES ('582', '章镇镇', '37');
INSERT INTO `dst_street` VALUES ('583', '下管镇', '37');
INSERT INTO `dst_street` VALUES ('584', '丰惠镇', '37');
INSERT INTO `dst_street` VALUES ('585', '永和镇', '37');
INSERT INTO `dst_street` VALUES ('586', '驿亭镇', '37');
INSERT INTO `dst_street` VALUES ('587', '谢塘镇', '37');
INSERT INTO `dst_street` VALUES ('588', '盖北镇', '37');
INSERT INTO `dst_street` VALUES ('589', '崧厦镇', '37');
INSERT INTO `dst_street` VALUES ('590', '沥海镇', '37');
INSERT INTO `dst_street` VALUES ('591', '岭南乡', '37');
INSERT INTO `dst_street` VALUES ('592', '陈溪乡', '37');
INSERT INTO `dst_street` VALUES ('593', '丁宅乡', '37');
INSERT INTO `dst_street` VALUES ('594', '羽林街道', '38');
INSERT INTO `dst_street` VALUES ('595', '南明街道', '38');
INSERT INTO `dst_street` VALUES ('596', '七星街道', '38');
INSERT INTO `dst_street` VALUES ('597', '澄潭镇', '38');
INSERT INTO `dst_street` VALUES ('598', '梅渚镇', '38');
INSERT INTO `dst_street` VALUES ('599', '回山镇', '38');
INSERT INTO `dst_street` VALUES ('600', '大市聚镇', '38');
INSERT INTO `dst_street` VALUES ('601', '小将镇', '38');
INSERT INTO `dst_street` VALUES ('602', '沙溪镇', '38');
INSERT INTO `dst_street` VALUES ('603', '镜岭镇', '38');
INSERT INTO `dst_street` VALUES ('604', '儒岙镇', '38');
INSERT INTO `dst_street` VALUES ('605', '城南乡', '38');
INSERT INTO `dst_street` VALUES ('606', '东茗乡', '38');
INSERT INTO `dst_street` VALUES ('607', '双彩乡', '38');
INSERT INTO `dst_street` VALUES ('608', '新林乡', '38');
INSERT INTO `dst_street` VALUES ('609', '巧英乡', '38');
INSERT INTO `dst_street` VALUES ('610', '剡湖街道', '39');
INSERT INTO `dst_street` VALUES ('611', '三江街道', '39');
INSERT INTO `dst_street` VALUES ('612', '鹿山街道', '39');
INSERT INTO `dst_street` VALUES ('613', '浦口街道', '39');
INSERT INTO `dst_street` VALUES ('614', '甘霖镇', '39');
INSERT INTO `dst_street` VALUES ('615', '长乐镇', '39');
INSERT INTO `dst_street` VALUES ('616', '崇仁镇', '39');
INSERT INTO `dst_street` VALUES ('617', '黄泽镇', '39');
INSERT INTO `dst_street` VALUES ('618', '三界镇', '39');
INSERT INTO `dst_street` VALUES ('619', '石璜镇', '39');
INSERT INTO `dst_street` VALUES ('620', '谷来镇', '39');
INSERT INTO `dst_street` VALUES ('621', '仙岩镇', '39');
INSERT INTO `dst_street` VALUES ('622', '金庭镇', '39');
INSERT INTO `dst_street` VALUES ('623', '北漳镇', '39');
INSERT INTO `dst_street` VALUES ('624', '下王镇', '39');
INSERT INTO `dst_street` VALUES ('625', '贵门乡', '39');
INSERT INTO `dst_street` VALUES ('626', '里南乡', '39');
INSERT INTO `dst_street` VALUES ('627', '竹溪乡', '39');
INSERT INTO `dst_street` VALUES ('628', '雅璜乡', '39');
INSERT INTO `dst_street` VALUES ('629', '王院乡', '39');
INSERT INTO `dst_street` VALUES ('630', '通源乡', '39');
INSERT INTO `dst_street` VALUES ('631', '嵊州经济开发区', '39');
INSERT INTO `dst_street` VALUES ('632', '暨阳街道', '40');
INSERT INTO `dst_street` VALUES ('633', '浣东街道', '40');
INSERT INTO `dst_street` VALUES ('634', '陶朱街道', '40');
INSERT INTO `dst_street` VALUES ('635', '大唐镇', '40');
INSERT INTO `dst_street` VALUES ('636', '应店街镇', '40');
INSERT INTO `dst_street` VALUES ('637', '次坞镇', '40');
INSERT INTO `dst_street` VALUES ('638', '店口镇', '40');
INSERT INTO `dst_street` VALUES ('639', '阮市镇', '40');
INSERT INTO `dst_street` VALUES ('640', '直埠镇', '40');
INSERT INTO `dst_street` VALUES ('641', '江藻镇', '40');
INSERT INTO `dst_street` VALUES ('642', '山下湖镇', '40');
INSERT INTO `dst_street` VALUES ('643', '枫桥镇', '40');
INSERT INTO `dst_street` VALUES ('644', '赵家镇', '40');
INSERT INTO `dst_street` VALUES ('645', '马剑镇', '40');
INSERT INTO `dst_street` VALUES ('646', '五泄镇', '40');
INSERT INTO `dst_street` VALUES ('647', '草塔镇', '40');
INSERT INTO `dst_street` VALUES ('648', '王家井镇', '40');
INSERT INTO `dst_street` VALUES ('649', '牌头镇', '40');
INSERT INTO `dst_street` VALUES ('650', '同山镇', '40');
INSERT INTO `dst_street` VALUES ('651', '安华镇', '40');
INSERT INTO `dst_street` VALUES ('652', '街亭镇', '40');
INSERT INTO `dst_street` VALUES ('653', '璜山镇', '40');
INSERT INTO `dst_street` VALUES ('654', '陈宅镇', '40');
INSERT INTO `dst_street` VALUES ('655', '岭北镇', '40');
INSERT INTO `dst_street` VALUES ('656', '浬浦镇', '40');
INSERT INTO `dst_street` VALUES ('657', '东白湖镇', '40');
INSERT INTO `dst_street` VALUES ('658', '东和乡', '40');
INSERT INTO `dst_street` VALUES ('659', '月河街道', '41');
INSERT INTO `dst_street` VALUES ('660', '朝阳街道', '41');
INSERT INTO `dst_street` VALUES ('661', '爱山街道', '41');
INSERT INTO `dst_street` VALUES ('662', '飞英街道', '41');
INSERT INTO `dst_street` VALUES ('663', '龙泉街道', '41');
INSERT INTO `dst_street` VALUES ('664', '凤凰街道', '41');
INSERT INTO `dst_street` VALUES ('665', '康山街道', '41');
INSERT INTO `dst_street` VALUES ('666', '仁皇山街道', '41');
INSERT INTO `dst_street` VALUES ('667', '滨湖街道', '41');
INSERT INTO `dst_street` VALUES ('668', '龙溪街道', '41');
INSERT INTO `dst_street` VALUES ('669', '杨家埠街道', '41');
INSERT INTO `dst_street` VALUES ('670', '环渚街道', '41');
INSERT INTO `dst_street` VALUES ('671', '织里镇', '41');
INSERT INTO `dst_street` VALUES ('672', '八里店镇', '41');
INSERT INTO `dst_street` VALUES ('673', '妙西镇', '41');
INSERT INTO `dst_street` VALUES ('674', '埭溪镇', '41');
INSERT INTO `dst_street` VALUES ('675', '东林镇', '41');
INSERT INTO `dst_street` VALUES ('676', '道场乡', '41');
INSERT INTO `dst_street` VALUES ('677', '南浔镇', '42');
INSERT INTO `dst_street` VALUES ('678', '双林镇', '42');
INSERT INTO `dst_street` VALUES ('679', '练市镇', '42');
INSERT INTO `dst_street` VALUES ('680', '善琏镇', '42');
INSERT INTO `dst_street` VALUES ('681', '旧馆镇', '42');
INSERT INTO `dst_street` VALUES ('682', '菱湖镇', '42');
INSERT INTO `dst_street` VALUES ('683', '和孚镇', '42');
INSERT INTO `dst_street` VALUES ('684', '千金镇', '42');
INSERT INTO `dst_street` VALUES ('685', '石淙镇', '42');
INSERT INTO `dst_street` VALUES ('686', '武康街道', '43');
INSERT INTO `dst_street` VALUES ('687', '舞阳街道', '43');
INSERT INTO `dst_street` VALUES ('688', '阜溪街道', '43');
INSERT INTO `dst_street` VALUES ('689', '下渚湖街道', '43');
INSERT INTO `dst_street` VALUES ('690', '乾元镇', '43');
INSERT INTO `dst_street` VALUES ('691', '新市镇', '43');
INSERT INTO `dst_street` VALUES ('692', '洛舍镇', '43');
INSERT INTO `dst_street` VALUES ('693', '钟管镇', '43');
INSERT INTO `dst_street` VALUES ('694', '雷甸镇', '43');
INSERT INTO `dst_street` VALUES ('695', '禹越镇', '43');
INSERT INTO `dst_street` VALUES ('696', '新安镇', '43');
INSERT INTO `dst_street` VALUES ('697', '莫干山镇', '43');
INSERT INTO `dst_street` VALUES ('698', '雉城街道', '44');
INSERT INTO `dst_street` VALUES ('699', '画溪街道', '44');
INSERT INTO `dst_street` VALUES ('700', '太湖街道', '44');
INSERT INTO `dst_street` VALUES ('701', '龙山街道', '44');
INSERT INTO `dst_street` VALUES ('702', '洪桥镇', '44');
INSERT INTO `dst_street` VALUES ('703', '李家巷镇', '44');
INSERT INTO `dst_street` VALUES ('704', '夹浦镇', '44');
INSERT INTO `dst_street` VALUES ('705', '林城镇', '44');
INSERT INTO `dst_street` VALUES ('706', '虹星桥镇', '44');
INSERT INTO `dst_street` VALUES ('707', '小浦镇', '44');
INSERT INTO `dst_street` VALUES ('708', '和平镇', '44');
INSERT INTO `dst_street` VALUES ('709', '泗安镇', '44');
INSERT INTO `dst_street` VALUES ('710', '煤山镇', '44');
INSERT INTO `dst_street` VALUES ('711', '水口乡', '44');
INSERT INTO `dst_street` VALUES ('712', '吕山乡', '44');
INSERT INTO `dst_street` VALUES ('713', '递铺街道', '45');
INSERT INTO `dst_street` VALUES ('714', '昌硕街道', '45');
INSERT INTO `dst_street` VALUES ('715', '灵峰街道', '45');
INSERT INTO `dst_street` VALUES ('716', '孝源街道', '45');
INSERT INTO `dst_street` VALUES ('717', '鄣吴镇', '45');
INSERT INTO `dst_street` VALUES ('718', '杭垓镇', '45');
INSERT INTO `dst_street` VALUES ('719', '孝丰镇', '45');
INSERT INTO `dst_street` VALUES ('720', '报福镇', '45');
INSERT INTO `dst_street` VALUES ('721', '章村镇', '45');
INSERT INTO `dst_street` VALUES ('722', '天荒坪镇', '45');
INSERT INTO `dst_street` VALUES ('723', '梅溪镇', '45');
INSERT INTO `dst_street` VALUES ('724', '天子湖镇', '45');
INSERT INTO `dst_street` VALUES ('725', '溪龙乡', '45');
INSERT INTO `dst_street` VALUES ('726', '上墅乡', '45');
INSERT INTO `dst_street` VALUES ('727', '山川乡', '45');
INSERT INTO `dst_street` VALUES ('728', '建设街道', '46');
INSERT INTO `dst_street` VALUES ('729', '解放街道', '46');
INSERT INTO `dst_street` VALUES ('730', '新嘉街道', '46');
INSERT INTO `dst_street` VALUES ('731', '南湖街道', '46');
INSERT INTO `dst_street` VALUES ('732', '新兴街道', '46');
INSERT INTO `dst_street` VALUES ('733', '城南街道', '46');
INSERT INTO `dst_street` VALUES ('734', '东栅街道', '46');
INSERT INTO `dst_street` VALUES ('735', '长水街道', '46');
INSERT INTO `dst_street` VALUES ('736', '七星街道', '46');
INSERT INTO `dst_street` VALUES ('737', '凤桥镇', '46');
INSERT INTO `dst_street` VALUES ('738', '余新镇', '46');
INSERT INTO `dst_street` VALUES ('739', '新丰镇', '46');
INSERT INTO `dst_street` VALUES ('740', '大桥镇', '46');
INSERT INTO `dst_street` VALUES ('741', '新城街道', '47');
INSERT INTO `dst_street` VALUES ('742', '嘉北街道', '47');
INSERT INTO `dst_street` VALUES ('743', '塘汇街道', '47');
INSERT INTO `dst_street` VALUES ('744', '高照街道', '47');
INSERT INTO `dst_street` VALUES ('745', '王江泾镇', '47');
INSERT INTO `dst_street` VALUES ('746', '油车港镇', '47');
INSERT INTO `dst_street` VALUES ('747', '新塍镇', '47');
INSERT INTO `dst_street` VALUES ('748', '王店镇', '47');
INSERT INTO `dst_street` VALUES ('749', '洪合镇', '47');
INSERT INTO `dst_street` VALUES ('750', '魏塘街道', '48');
INSERT INTO `dst_street` VALUES ('751', '罗星街道', '48');
INSERT INTO `dst_street` VALUES ('752', '惠民街道', '48');
INSERT INTO `dst_street` VALUES ('753', '大云镇', '48');
INSERT INTO `dst_street` VALUES ('754', '西塘镇', '48');
INSERT INTO `dst_street` VALUES ('755', '干窑镇', '48');
INSERT INTO `dst_street` VALUES ('756', '陶庄镇', '48');
INSERT INTO `dst_street` VALUES ('757', '姚庄镇', '48');
INSERT INTO `dst_street` VALUES ('758', '天凝镇', '48');
INSERT INTO `dst_street` VALUES ('759', '武原街道', '49');
INSERT INTO `dst_street` VALUES ('760', '西塘桥街道', '49');
INSERT INTO `dst_street` VALUES ('761', '元通街道', '49');
INSERT INTO `dst_street` VALUES ('762', '秦山街道', '49');
INSERT INTO `dst_street` VALUES ('763', '沈荡镇', '49');
INSERT INTO `dst_street` VALUES ('764', '百步镇', '49');
INSERT INTO `dst_street` VALUES ('765', '于城镇', '49');
INSERT INTO `dst_street` VALUES ('766', '澉浦镇', '49');
INSERT INTO `dst_street` VALUES ('767', '通元镇', '49');
INSERT INTO `dst_street` VALUES ('768', '硖石街道', '50');
INSERT INTO `dst_street` VALUES ('769', '海洲街道', '50');
INSERT INTO `dst_street` VALUES ('770', '海昌街道', '50');
INSERT INTO `dst_street` VALUES ('771', '马桥街道', '50');
INSERT INTO `dst_street` VALUES ('772', '许村镇', '50');
INSERT INTO `dst_street` VALUES ('773', '长安镇', '50');
INSERT INTO `dst_street` VALUES ('774', '周王庙镇', '50');
INSERT INTO `dst_street` VALUES ('775', '丁桥镇', '50');
INSERT INTO `dst_street` VALUES ('776', '斜桥镇', '50');
INSERT INTO `dst_street` VALUES ('777', '黄湾镇', '50');
INSERT INTO `dst_street` VALUES ('778', '盐官镇', '50');
INSERT INTO `dst_street` VALUES ('779', '袁花镇', '50');
INSERT INTO `dst_street` VALUES ('780', '当湖街道', '51');
INSERT INTO `dst_street` VALUES ('781', '钟埭街道', '51');
INSERT INTO `dst_street` VALUES ('782', '曹桥街道', '51');
INSERT INTO `dst_street` VALUES ('783', '乍浦镇', '51');
INSERT INTO `dst_street` VALUES ('784', '新埭镇', '51');
INSERT INTO `dst_street` VALUES ('785', '新仓镇', '51');
INSERT INTO `dst_street` VALUES ('786', '广陈镇', '51');
INSERT INTO `dst_street` VALUES ('787', '林埭镇', '51');
INSERT INTO `dst_street` VALUES ('788', '独山港镇', '51');
INSERT INTO `dst_street` VALUES ('789', '梧桐街道', '52');
INSERT INTO `dst_street` VALUES ('790', '凤鸣街道', '52');
INSERT INTO `dst_street` VALUES ('791', '高桥街道', '52');
INSERT INTO `dst_street` VALUES ('792', '乌镇镇', '52');
INSERT INTO `dst_street` VALUES ('793', '濮院镇', '52');
INSERT INTO `dst_street` VALUES ('794', '屠甸镇', '52');
INSERT INTO `dst_street` VALUES ('795', '石门镇', '52');
INSERT INTO `dst_street` VALUES ('796', '河山镇', '52');
INSERT INTO `dst_street` VALUES ('797', '洲泉镇', '52');
INSERT INTO `dst_street` VALUES ('798', '大麻镇', '52');
INSERT INTO `dst_street` VALUES ('799', '崇福镇', '52');
INSERT INTO `dst_street` VALUES ('800', '城东街道', '53');
INSERT INTO `dst_street` VALUES ('801', '城中街道', '53');
INSERT INTO `dst_street` VALUES ('802', '城西街道', '53');
INSERT INTO `dst_street` VALUES ('803', '城北街道', '53');
INSERT INTO `dst_street` VALUES ('804', '江南街道', '53');
INSERT INTO `dst_street` VALUES ('805', '三江街道', '53');
INSERT INTO `dst_street` VALUES ('806', '西关街道', '53');
INSERT INTO `dst_street` VALUES ('807', '秋滨街道', '53');
INSERT INTO `dst_street` VALUES ('808', '新狮街道', '53');
INSERT INTO `dst_street` VALUES ('809', '罗店镇', '53');
INSERT INTO `dst_street` VALUES ('810', '雅畈镇', '53');
INSERT INTO `dst_street` VALUES ('811', '安地镇', '53');
INSERT INTO `dst_street` VALUES ('812', '白龙桥镇', '53');
INSERT INTO `dst_street` VALUES ('813', '琅琊镇', '53');
INSERT INTO `dst_street` VALUES ('814', '蒋堂镇', '53');
INSERT INTO `dst_street` VALUES ('815', '汤溪镇', '53');
INSERT INTO `dst_street` VALUES ('816', '罗埠镇', '53');
INSERT INTO `dst_street` VALUES ('817', '洋埠镇', '53');
INSERT INTO `dst_street` VALUES ('818', '乾西乡', '53');
INSERT INTO `dst_street` VALUES ('819', '竹马乡', '53');
INSERT INTO `dst_street` VALUES ('820', '长山乡', '53');
INSERT INTO `dst_street` VALUES ('821', '箬阳乡', '53');
INSERT INTO `dst_street` VALUES ('822', '沙畈乡', '53');
INSERT INTO `dst_street` VALUES ('823', '塔石乡', '53');
INSERT INTO `dst_street` VALUES ('824', '岭上乡', '53');
INSERT INTO `dst_street` VALUES ('825', '莘畈乡', '53');
INSERT INTO `dst_street` VALUES ('826', '苏孟乡', '53');
INSERT INTO `dst_street` VALUES ('827', '多湖街道', '54');
INSERT INTO `dst_street` VALUES ('828', '东孝街道', '54');
INSERT INTO `dst_street` VALUES ('829', '孝顺镇', '54');
INSERT INTO `dst_street` VALUES ('830', '傅村镇', '54');
INSERT INTO `dst_street` VALUES ('831', '曹宅镇', '54');
INSERT INTO `dst_street` VALUES ('832', '澧浦镇', '54');
INSERT INTO `dst_street` VALUES ('833', '岭下镇', '54');
INSERT INTO `dst_street` VALUES ('834', '江东镇', '54');
INSERT INTO `dst_street` VALUES ('835', '塘雅镇', '54');
INSERT INTO `dst_street` VALUES ('836', '赤松镇', '54');
INSERT INTO `dst_street` VALUES ('837', '源东乡', '54');
INSERT INTO `dst_street` VALUES ('838', '兰江街道', '55');
INSERT INTO `dst_street` VALUES ('839', '云山街道', '55');
INSERT INTO `dst_street` VALUES ('840', '永昌街道', '55');
INSERT INTO `dst_street` VALUES ('841', '赤溪街道', '55');
INSERT INTO `dst_street` VALUES ('842', '女埠街道', '55');
INSERT INTO `dst_street` VALUES ('843', '上华街道', '55');
INSERT INTO `dst_street` VALUES ('844', '游埠镇', '55');
INSERT INTO `dst_street` VALUES ('845', '诸葛镇', '55');
INSERT INTO `dst_street` VALUES ('846', '黄店镇', '55');
INSERT INTO `dst_street` VALUES ('847', '香溪镇', '55');
INSERT INTO `dst_street` VALUES ('848', '马涧镇', '55');
INSERT INTO `dst_street` VALUES ('849', '梅江镇', '55');
INSERT INTO `dst_street` VALUES ('850', '横溪镇', '55');
INSERT INTO `dst_street` VALUES ('851', '灵洞乡', '55');
INSERT INTO `dst_street` VALUES ('852', '水亭畲族乡', '55');
INSERT INTO `dst_street` VALUES ('853', '柏社乡', '55');
INSERT INTO `dst_street` VALUES ('854', '稠城街道', '56');
INSERT INTO `dst_street` VALUES ('855', '江东街道', '56');
INSERT INTO `dst_street` VALUES ('856', '稠江街道', '56');
INSERT INTO `dst_street` VALUES ('857', '北苑街道', '56');
INSERT INTO `dst_street` VALUES ('858', '后宅街道', '56');
INSERT INTO `dst_street` VALUES ('859', '城西街道', '56');
INSERT INTO `dst_street` VALUES ('860', '廿三里街道', '56');
INSERT INTO `dst_street` VALUES ('861', '福田街道', '56');
INSERT INTO `dst_street` VALUES ('862', '佛堂镇', '56');
INSERT INTO `dst_street` VALUES ('863', '赤岸镇', '56');
INSERT INTO `dst_street` VALUES ('864', '义亭镇', '56');
INSERT INTO `dst_street` VALUES ('865', '上溪镇', '56');
INSERT INTO `dst_street` VALUES ('866', '苏溪镇', '56');
INSERT INTO `dst_street` VALUES ('867', '大陈镇', '56');
INSERT INTO `dst_street` VALUES ('868', '吴宁街道', '57');
INSERT INTO `dst_street` VALUES ('869', '南市街道', '57');
INSERT INTO `dst_street` VALUES ('870', '白云街道', '57');
INSERT INTO `dst_street` VALUES ('871', '江北街道', '57');
INSERT INTO `dst_street` VALUES ('872', '城东街道', '57');
INSERT INTO `dst_street` VALUES ('873', '六石街道', '57');
INSERT INTO `dst_street` VALUES ('874', '巍山镇', '57');
INSERT INTO `dst_street` VALUES ('875', '虎鹿镇', '57');
INSERT INTO `dst_street` VALUES ('876', '歌山镇', '57');
INSERT INTO `dst_street` VALUES ('877', '佐村镇', '57');
INSERT INTO `dst_street` VALUES ('878', '东阳江镇', '57');
INSERT INTO `dst_street` VALUES ('879', '湖溪镇', '57');
INSERT INTO `dst_street` VALUES ('880', '马宅镇', '57');
INSERT INTO `dst_street` VALUES ('881', '千祥镇', '57');
INSERT INTO `dst_street` VALUES ('882', '南马镇', '57');
INSERT INTO `dst_street` VALUES ('883', '画水镇', '57');
INSERT INTO `dst_street` VALUES ('884', '横店镇', '57');
INSERT INTO `dst_street` VALUES ('885', '三单乡', '57');
INSERT INTO `dst_street` VALUES ('886', '东城街道', '58');
INSERT INTO `dst_street` VALUES ('887', '西城街道', '58');
INSERT INTO `dst_street` VALUES ('888', '江南街道', '58');
INSERT INTO `dst_street` VALUES ('889', '石柱镇', '58');
INSERT INTO `dst_street` VALUES ('890', '前仓镇', '58');
INSERT INTO `dst_street` VALUES ('891', '舟山镇', '58');
INSERT INTO `dst_street` VALUES ('892', '古山镇', '58');
INSERT INTO `dst_street` VALUES ('893', '方岩镇', '58');
INSERT INTO `dst_street` VALUES ('894', '龙山镇', '58');
INSERT INTO `dst_street` VALUES ('895', '西溪镇', '58');
INSERT INTO `dst_street` VALUES ('896', '象珠镇', '58');
INSERT INTO `dst_street` VALUES ('897', '唐先镇', '58');
INSERT INTO `dst_street` VALUES ('898', '花街镇', '58');
INSERT INTO `dst_street` VALUES ('899', '芝英镇', '58');
INSERT INTO `dst_street` VALUES ('900', '浦南街道', '59');
INSERT INTO `dst_street` VALUES ('901', '仙华街道', '59');
INSERT INTO `dst_street` VALUES ('902', '浦阳街道', '59');
INSERT INTO `dst_street` VALUES ('903', '黄宅镇', '59');
INSERT INTO `dst_street` VALUES ('904', '白马镇', '59');
INSERT INTO `dst_street` VALUES ('905', '郑家坞镇', '59');
INSERT INTO `dst_street` VALUES ('906', '郑宅镇', '59');
INSERT INTO `dst_street` VALUES ('907', '岩头镇', '59');
INSERT INTO `dst_street` VALUES ('908', '檀溪镇', '59');
INSERT INTO `dst_street` VALUES ('909', '杭坪镇', '59');
INSERT INTO `dst_street` VALUES ('910', '大畈乡', '59');
INSERT INTO `dst_street` VALUES ('911', '中余乡', '59');
INSERT INTO `dst_street` VALUES ('912', '前吴乡', '59');
INSERT INTO `dst_street` VALUES ('913', '花桥乡', '59');
INSERT INTO `dst_street` VALUES ('914', '虞宅乡', '59');
INSERT INTO `dst_street` VALUES ('915', '白洋街道', '60');
INSERT INTO `dst_street` VALUES ('916', '壶山街道', '60');
INSERT INTO `dst_street` VALUES ('917', '熟溪街道', '60');
INSERT INTO `dst_street` VALUES ('918', '柳城畲族镇', '60');
INSERT INTO `dst_street` VALUES ('919', '履坦镇', '60');
INSERT INTO `dst_street` VALUES ('920', '桐琴镇', '60');
INSERT INTO `dst_street` VALUES ('921', '泉溪镇', '60');
INSERT INTO `dst_street` VALUES ('922', '新宅镇', '60');
INSERT INTO `dst_street` VALUES ('923', '王宅镇', '60');
INSERT INTO `dst_street` VALUES ('924', '桃溪镇', '60');
INSERT INTO `dst_street` VALUES ('925', '茭道镇', '60');
INSERT INTO `dst_street` VALUES ('926', '大田乡', '60');
INSERT INTO `dst_street` VALUES ('927', '白姆乡', '60');
INSERT INTO `dst_street` VALUES ('928', '俞源乡', '60');
INSERT INTO `dst_street` VALUES ('929', '坦洪乡', '60');
INSERT INTO `dst_street` VALUES ('930', '西联乡', '60');
INSERT INTO `dst_street` VALUES ('931', '三港乡', '60');
INSERT INTO `dst_street` VALUES ('932', '大溪口乡', '60');
INSERT INTO `dst_street` VALUES ('933', '安文镇', '61');
INSERT INTO `dst_street` VALUES ('934', '新渥镇', '61');
INSERT INTO `dst_street` VALUES ('935', '尖山镇', '61');
INSERT INTO `dst_street` VALUES ('936', '仁川镇', '61');
INSERT INTO `dst_street` VALUES ('937', '大盘镇', '61');
INSERT INTO `dst_street` VALUES ('938', '方前镇', '61');
INSERT INTO `dst_street` VALUES ('939', '玉山镇', '61');
INSERT INTO `dst_street` VALUES ('940', '尚湖镇', '61');
INSERT INTO `dst_street` VALUES ('941', '冷水镇', '61');
INSERT INTO `dst_street` VALUES ('942', '深泽乡', '61');
INSERT INTO `dst_street` VALUES ('943', '双峰乡', '61');
INSERT INTO `dst_street` VALUES ('944', '双溪乡', '61');
INSERT INTO `dst_street` VALUES ('945', '窈川乡', '61');
INSERT INTO `dst_street` VALUES ('946', '盘峰乡', '61');
INSERT INTO `dst_street` VALUES ('947', '高二乡', '61');
INSERT INTO `dst_street` VALUES ('948', '维新乡', '61');
INSERT INTO `dst_street` VALUES ('949', '胡宅乡', '61');
INSERT INTO `dst_street` VALUES ('950', '万苍乡', '61');
INSERT INTO `dst_street` VALUES ('951', '九和乡', '61');
INSERT INTO `dst_street` VALUES ('952', '新新街道', '62');
INSERT INTO `dst_street` VALUES ('953', '府山街道', '62');
INSERT INTO `dst_street` VALUES ('954', '荷花街道', '62');
INSERT INTO `dst_street` VALUES ('955', '信安街道', '62');
INSERT INTO `dst_street` VALUES ('956', '白云街道', '62');
INSERT INTO `dst_street` VALUES ('957', '双港街道', '62');
INSERT INTO `dst_street` VALUES ('958', '衢化街道', '62');
INSERT INTO `dst_street` VALUES ('959', '花园街道', '62');
INSERT INTO `dst_street` VALUES ('960', '石梁镇', '62');
INSERT INTO `dst_street` VALUES ('961', '航埠镇', '62');
INSERT INTO `dst_street` VALUES ('962', '黄家乡', '62');
INSERT INTO `dst_street` VALUES ('963', '七里乡', '62');
INSERT INTO `dst_street` VALUES ('964', '九华乡', '62');
INSERT INTO `dst_street` VALUES ('965', '沟溪乡', '62');
INSERT INTO `dst_street` VALUES ('966', '华墅乡', '62');
INSERT INTO `dst_street` VALUES ('967', '姜家山乡', '62');
INSERT INTO `dst_street` VALUES ('968', '万田乡', '62');
INSERT INTO `dst_street` VALUES ('969', '石室乡', '62');
INSERT INTO `dst_street` VALUES ('970', '樟潭街道', '63');
INSERT INTO `dst_street` VALUES ('971', '浮石街道', '63');
INSERT INTO `dst_street` VALUES ('972', '上方镇', '63');
INSERT INTO `dst_street` VALUES ('973', '峡川镇', '63');
INSERT INTO `dst_street` VALUES ('974', '莲花镇', '63');
INSERT INTO `dst_street` VALUES ('975', '全旺镇', '63');
INSERT INTO `dst_street` VALUES ('976', '大洲镇', '63');
INSERT INTO `dst_street` VALUES ('977', '后溪镇', '63');
INSERT INTO `dst_street` VALUES ('978', '廿里镇', '63');
INSERT INTO `dst_street` VALUES ('979', '湖南镇', '63');
INSERT INTO `dst_street` VALUES ('980', '高家镇', '63');
INSERT INTO `dst_street` VALUES ('981', '杜泽镇', '63');
INSERT INTO `dst_street` VALUES ('982', '灰坪乡', '63');
INSERT INTO `dst_street` VALUES ('983', '太真乡', '63');
INSERT INTO `dst_street` VALUES ('984', '双桥乡', '63');
INSERT INTO `dst_street` VALUES ('985', '周家乡', '63');
INSERT INTO `dst_street` VALUES ('986', '云溪乡', '63');
INSERT INTO `dst_street` VALUES ('987', '举村乡', '63');
INSERT INTO `dst_street` VALUES ('988', '岭洋乡', '63');
INSERT INTO `dst_street` VALUES ('989', '黄坛口乡', '63');
INSERT INTO `dst_street` VALUES ('990', '龙洲街道', '64');
INSERT INTO `dst_street` VALUES ('991', '东华街道', '64');
INSERT INTO `dst_street` VALUES ('992', '湖镇镇', '64');
INSERT INTO `dst_street` VALUES ('993', '小南海镇', '64');
INSERT INTO `dst_street` VALUES ('994', '詹家镇', '64');
INSERT INTO `dst_street` VALUES ('995', '溪口镇', '64');
INSERT INTO `dst_street` VALUES ('996', '横山镇', '64');
INSERT INTO `dst_street` VALUES ('997', '塔石镇', '64');
INSERT INTO `dst_street` VALUES ('998', '罗家乡', '64');
INSERT INTO `dst_street` VALUES ('999', '庙下乡', '64');
INSERT INTO `dst_street` VALUES ('1000', '石佛乡', '64');
INSERT INTO `dst_street` VALUES ('1001', '社阳乡', '64');
INSERT INTO `dst_street` VALUES ('1002', '大街乡', '64');
INSERT INTO `dst_street` VALUES ('1003', '沐尘畲族乡', '64');
INSERT INTO `dst_street` VALUES ('1004', '模环乡', '64');
INSERT INTO `dst_street` VALUES ('1005', '双塔街道', '65');
INSERT INTO `dst_street` VALUES ('1006', '虎山街道', '65');
INSERT INTO `dst_street` VALUES ('1007', '清湖街道', '65');
INSERT INTO `dst_street` VALUES ('1008', '四都镇', '65');
INSERT INTO `dst_street` VALUES ('1009', '坛石镇', '65');
INSERT INTO `dst_street` VALUES ('1010', '大桥镇', '65');
INSERT INTO `dst_street` VALUES ('1011', '新塘边镇', '65');
INSERT INTO `dst_street` VALUES ('1012', '廿八都镇', '65');
INSERT INTO `dst_street` VALUES ('1013', '长台镇', '65');
INSERT INTO `dst_street` VALUES ('1014', '上余镇', '65');
INSERT INTO `dst_street` VALUES ('1015', '凤林镇', '65');
INSERT INTO `dst_street` VALUES ('1016', '峡口镇', '65');
INSERT INTO `dst_street` VALUES ('1017', '石门镇', '65');
INSERT INTO `dst_street` VALUES ('1018', '贺村镇', '65');
INSERT INTO `dst_street` VALUES ('1019', '大陈乡', '65');
INSERT INTO `dst_street` VALUES ('1020', '碗窑乡', '65');
INSERT INTO `dst_street` VALUES ('1021', '保安乡', '65');
INSERT INTO `dst_street` VALUES ('1022', '塘源口乡', '65');
INSERT INTO `dst_street` VALUES ('1023', '张村乡', '65');
INSERT INTO `dst_street` VALUES ('1024', '天马街道', '66');
INSERT INTO `dst_street` VALUES ('1025', '紫港街道', '66');
INSERT INTO `dst_street` VALUES ('1026', '金川街道', '66');
INSERT INTO `dst_street` VALUES ('1027', '白石镇', '66');
INSERT INTO `dst_street` VALUES ('1028', '招贤镇', '66');
INSERT INTO `dst_street` VALUES ('1029', '青石镇', '66');
INSERT INTO `dst_street` VALUES ('1030', '球川镇', '66');
INSERT INTO `dst_street` VALUES ('1031', '辉埠镇', '66');
INSERT INTO `dst_street` VALUES ('1032', '芳村镇', '66');
INSERT INTO `dst_street` VALUES ('1033', '何家乡', '66');
INSERT INTO `dst_street` VALUES ('1034', '同弓乡', '66');
INSERT INTO `dst_street` VALUES ('1035', '大桥头乡', '66');
INSERT INTO `dst_street` VALUES ('1036', '新昌乡', '66');
INSERT INTO `dst_street` VALUES ('1037', '东案乡', '66');
INSERT INTO `dst_street` VALUES ('1038', '桐村镇', '67');
INSERT INTO `dst_street` VALUES ('1039', '杨林镇', '67');
INSERT INTO `dst_street` VALUES ('1040', '苏庄镇', '67');
INSERT INTO `dst_street` VALUES ('1041', '齐溪镇', '67');
INSERT INTO `dst_street` VALUES ('1042', '村头镇', '67');
INSERT INTO `dst_street` VALUES ('1043', '华埠镇', '67');
INSERT INTO `dst_street` VALUES ('1044', '马金镇', '67');
INSERT INTO `dst_street` VALUES ('1045', '池淮镇', '67');
INSERT INTO `dst_street` VALUES ('1046', '中村乡', '67');
INSERT INTO `dst_street` VALUES ('1047', '长虹乡', '67');
INSERT INTO `dst_street` VALUES ('1048', '何田乡', '67');
INSERT INTO `dst_street` VALUES ('1049', '林山乡', '67');
INSERT INTO `dst_street` VALUES ('1050', '音坑乡', '67');
INSERT INTO `dst_street` VALUES ('1051', '大溪边乡', '67');
INSERT INTO `dst_street` VALUES ('1052', '海门街道', '68');
INSERT INTO `dst_street` VALUES ('1053', '白云街道', '68');
INSERT INTO `dst_street` VALUES ('1054', '葭沚街道', '68');
INSERT INTO `dst_street` VALUES ('1055', '洪家街道', '68');
INSERT INTO `dst_street` VALUES ('1056', '三甲街道', '68');
INSERT INTO `dst_street` VALUES ('1057', '下陈街道', '68');
INSERT INTO `dst_street` VALUES ('1058', '前所街道', '68');
INSERT INTO `dst_street` VALUES ('1059', '章安街道', '68');
INSERT INTO `dst_street` VALUES ('1060', '大陈镇', '68');
INSERT INTO `dst_street` VALUES ('1061', '椒江农场', '68');
INSERT INTO `dst_street` VALUES ('1062', '滨海工业区', '68');
INSERT INTO `dst_street` VALUES ('1063', '月湖新城', '68');
INSERT INTO `dst_street` VALUES ('1064', '东城街道', '69');
INSERT INTO `dst_street` VALUES ('1065', '南城街道', '69');
INSERT INTO `dst_street` VALUES ('1066', '西城街道', '69');
INSERT INTO `dst_street` VALUES ('1067', '北城街道', '69');
INSERT INTO `dst_street` VALUES ('1068', '新前街道', '69');
INSERT INTO `dst_street` VALUES ('1069', '澄江街道', '69');
INSERT INTO `dst_street` VALUES ('1070', '江口街道', '69');
INSERT INTO `dst_street` VALUES ('1071', '高桥街道', '69');
INSERT INTO `dst_street` VALUES ('1072', '宁溪镇', '69');
INSERT INTO `dst_street` VALUES ('1073', '北洋镇', '69');
INSERT INTO `dst_street` VALUES ('1074', '头陀镇', '69');
INSERT INTO `dst_street` VALUES ('1075', '院桥镇', '69');
INSERT INTO `dst_street` VALUES ('1076', '沙埠镇', '69');
INSERT INTO `dst_street` VALUES ('1077', '屿头乡', '69');
INSERT INTO `dst_street` VALUES ('1078', '上郑乡', '69');
INSERT INTO `dst_street` VALUES ('1079', '富山乡', '69');
INSERT INTO `dst_street` VALUES ('1080', '茅畲乡', '69');
INSERT INTO `dst_street` VALUES ('1081', '上垟乡', '69');
INSERT INTO `dst_street` VALUES ('1082', '平田乡', '69');
INSERT INTO `dst_street` VALUES ('1083', '路南街道', '70');
INSERT INTO `dst_street` VALUES ('1084', '路桥街道', '70');
INSERT INTO `dst_street` VALUES ('1085', '路北街道', '70');
INSERT INTO `dst_street` VALUES ('1086', '螺洋街道', '70');
INSERT INTO `dst_street` VALUES ('1087', '桐屿街道', '70');
INSERT INTO `dst_street` VALUES ('1088', '峰江街道', '70');
INSERT INTO `dst_street` VALUES ('1089', '新桥镇', '70');
INSERT INTO `dst_street` VALUES ('1090', '横街镇', '70');
INSERT INTO `dst_street` VALUES ('1091', '金清镇', '70');
INSERT INTO `dst_street` VALUES ('1092', '蓬街镇', '70');
INSERT INTO `dst_street` VALUES ('1093', '滨海工业城', '70');
INSERT INTO `dst_street` VALUES ('1094', '滨海新区', '70');
INSERT INTO `dst_street` VALUES ('1095', '古城街道', '71');
INSERT INTO `dst_street` VALUES ('1096', '大洋街道', '71');
INSERT INTO `dst_street` VALUES ('1097', '江南街道', '71');
INSERT INTO `dst_street` VALUES ('1098', '大田街道', '71');
INSERT INTO `dst_street` VALUES ('1099', '邵家渡街道', '71');
INSERT INTO `dst_street` VALUES ('1100', '汛桥镇', '71');
INSERT INTO `dst_street` VALUES ('1101', '东塍镇', '71');
INSERT INTO `dst_street` VALUES ('1102', '汇溪镇', '71');
INSERT INTO `dst_street` VALUES ('1103', '小芝镇', '71');
INSERT INTO `dst_street` VALUES ('1104', '河头镇', '71');
INSERT INTO `dst_street` VALUES ('1105', '白水洋镇', '71');
INSERT INTO `dst_street` VALUES ('1106', '括苍镇', '71');
INSERT INTO `dst_street` VALUES ('1107', '永丰镇', '71');
INSERT INTO `dst_street` VALUES ('1108', '尤溪镇', '71');
INSERT INTO `dst_street` VALUES ('1109', '涌泉镇', '71');
INSERT INTO `dst_street` VALUES ('1110', '沿江镇', '71');
INSERT INTO `dst_street` VALUES ('1111', '杜桥镇', '71');
INSERT INTO `dst_street` VALUES ('1112', '上盘镇', '71');
INSERT INTO `dst_street` VALUES ('1113', '桃渚镇', '71');
INSERT INTO `dst_street` VALUES ('1114', '太平街道', '72');
INSERT INTO `dst_street` VALUES ('1115', '城东街道', '72');
INSERT INTO `dst_street` VALUES ('1116', '城西街道', '72');
INSERT INTO `dst_street` VALUES ('1117', '城北街道', '72');
INSERT INTO `dst_street` VALUES ('1118', '横峰街道', '72');
INSERT INTO `dst_street` VALUES ('1119', '泽国镇', '72');
INSERT INTO `dst_street` VALUES ('1120', '大溪镇', '72');
INSERT INTO `dst_street` VALUES ('1121', '松门镇', '72');
INSERT INTO `dst_street` VALUES ('1122', '箬横镇', '72');
INSERT INTO `dst_street` VALUES ('1123', '新河镇', '72');
INSERT INTO `dst_street` VALUES ('1124', '石塘镇', '72');
INSERT INTO `dst_street` VALUES ('1125', '滨海镇', '72');
INSERT INTO `dst_street` VALUES ('1126', '温峤镇', '72');
INSERT INTO `dst_street` VALUES ('1127', '城南镇', '72');
INSERT INTO `dst_street` VALUES ('1128', '石桥头镇', '72');
INSERT INTO `dst_street` VALUES ('1129', '坞根镇', '72');
INSERT INTO `dst_street` VALUES ('1130', '东部新区', '72');
INSERT INTO `dst_street` VALUES ('1131', '玉城街道', '73');
INSERT INTO `dst_street` VALUES ('1132', '坎门街道', '73');
INSERT INTO `dst_street` VALUES ('1133', '大麦屿街道', '73');
INSERT INTO `dst_street` VALUES ('1134', '清港镇', '73');
INSERT INTO `dst_street` VALUES ('1135', '楚门镇', '73');
INSERT INTO `dst_street` VALUES ('1136', '干江镇', '73');
INSERT INTO `dst_street` VALUES ('1137', '沙门镇', '73');
INSERT INTO `dst_street` VALUES ('1138', '芦浦镇', '73');
INSERT INTO `dst_street` VALUES ('1139', '龙溪镇', '73');
INSERT INTO `dst_street` VALUES ('1140', '鸡山乡', '73');
INSERT INTO `dst_street` VALUES ('1141', '海山乡', '73');
INSERT INTO `dst_street` VALUES ('1142', '玉环经济开发区', '73');
INSERT INTO `dst_street` VALUES ('1143', '赤城街道', '74');
INSERT INTO `dst_street` VALUES ('1144', '始丰街道', '74');
INSERT INTO `dst_street` VALUES ('1145', '福溪街道', '74');
INSERT INTO `dst_street` VALUES ('1146', '白鹤镇', '74');
INSERT INTO `dst_street` VALUES ('1147', '石梁镇', '74');
INSERT INTO `dst_street` VALUES ('1148', '街头镇', '74');
INSERT INTO `dst_street` VALUES ('1149', '平桥镇', '74');
INSERT INTO `dst_street` VALUES ('1150', '坦头镇', '74');
INSERT INTO `dst_street` VALUES ('1151', '三合镇', '74');
INSERT INTO `dst_street` VALUES ('1152', '洪畴镇', '74');
INSERT INTO `dst_street` VALUES ('1153', '三州乡', '74');
INSERT INTO `dst_street` VALUES ('1154', '龙溪乡', '74');
INSERT INTO `dst_street` VALUES ('1155', '雷峰乡', '74');
INSERT INTO `dst_street` VALUES ('1156', '南屏乡', '74');
INSERT INTO `dst_street` VALUES ('1157', '泳溪乡', '74');
INSERT INTO `dst_street` VALUES ('1158', '安洲街道', '75');
INSERT INTO `dst_street` VALUES ('1159', '南峰街道', '75');
INSERT INTO `dst_street` VALUES ('1160', '福应街道', '75');
INSERT INTO `dst_street` VALUES ('1161', '横溪镇', '75');
INSERT INTO `dst_street` VALUES ('1162', '埠头镇', '75');
INSERT INTO `dst_street` VALUES ('1163', '白塔镇', '75');
INSERT INTO `dst_street` VALUES ('1164', '田市镇', '75');
INSERT INTO `dst_street` VALUES ('1165', '官路镇', '75');
INSERT INTO `dst_street` VALUES ('1166', '下各镇', '75');
INSERT INTO `dst_street` VALUES ('1167', '朱溪镇', '75');
INSERT INTO `dst_street` VALUES ('1168', '安岭乡', '75');
INSERT INTO `dst_street` VALUES ('1169', '溪港乡', '75');
INSERT INTO `dst_street` VALUES ('1170', '湫山乡', '75');
INSERT INTO `dst_street` VALUES ('1171', '淡竹乡', '75');
INSERT INTO `dst_street` VALUES ('1172', '皤滩乡', '75');
INSERT INTO `dst_street` VALUES ('1173', '上张乡', '75');
INSERT INTO `dst_street` VALUES ('1174', '步路乡', '75');
INSERT INTO `dst_street` VALUES ('1175', '广度乡', '75');
INSERT INTO `dst_street` VALUES ('1176', '大战乡', '75');
INSERT INTO `dst_street` VALUES ('1177', '双庙乡', '75');
INSERT INTO `dst_street` VALUES ('1178', '海游街道', '76');
INSERT INTO `dst_street` VALUES ('1179', '海润街道', '76');
INSERT INTO `dst_street` VALUES ('1180', '沙柳街道', '76');
INSERT INTO `dst_street` VALUES ('1181', '珠岙镇', '76');
INSERT INTO `dst_street` VALUES ('1182', '亭旁镇', '76');
INSERT INTO `dst_street` VALUES ('1183', '健跳镇', '76');
INSERT INTO `dst_street` VALUES ('1184', '横渡镇', '76');
INSERT INTO `dst_street` VALUES ('1185', '浦坝港镇', '76');
INSERT INTO `dst_street` VALUES ('1186', '花桥镇', '76');
INSERT INTO `dst_street` VALUES ('1187', '蛇蟠乡', '76');
INSERT INTO `dst_street` VALUES ('1188', '紫金街道办事处', '77');
INSERT INTO `dst_street` VALUES ('1189', '岩泉街道办事处', '77');
INSERT INTO `dst_street` VALUES ('1190', '万象街道办事处', '77');
INSERT INTO `dst_street` VALUES ('1191', '白云街道办事处', '77');
INSERT INTO `dst_street` VALUES ('1192', '联城街道办事处', '77');
INSERT INTO `dst_street` VALUES ('1193', '南明山街道办事处', '77');
INSERT INTO `dst_street` VALUES ('1194', '碧湖镇', '77');
INSERT INTO `dst_street` VALUES ('1195', '大港头镇', '77');
INSERT INTO `dst_street` VALUES ('1196', '老竹畲族镇', '77');
INSERT INTO `dst_street` VALUES ('1197', '雅溪镇', '77');
INSERT INTO `dst_street` VALUES ('1198', '太平乡', '77');
INSERT INTO `dst_street` VALUES ('1199', '仙渡乡', '77');
INSERT INTO `dst_street` VALUES ('1200', '峰源乡', '77');
INSERT INTO `dst_street` VALUES ('1201', '丽新畲族乡', '77');
INSERT INTO `dst_street` VALUES ('1202', '黄村乡', '77');
INSERT INTO `dst_street` VALUES ('1203', '龙渊街道', '78');
INSERT INTO `dst_street` VALUES ('1204', '西街街道', '78');
INSERT INTO `dst_street` VALUES ('1205', '剑池街道', '78');
INSERT INTO `dst_street` VALUES ('1206', '石达石街道', '78');
INSERT INTO `dst_street` VALUES ('1207', '八都镇', '78');
INSERT INTO `dst_street` VALUES ('1208', '上垟镇', '78');
INSERT INTO `dst_street` VALUES ('1209', '小梅镇', '78');
INSERT INTO `dst_street` VALUES ('1210', '查田镇', '78');
INSERT INTO `dst_street` VALUES ('1211', '安仁镇', '78');
INSERT INTO `dst_street` VALUES ('1212', '锦溪镇', '78');
INSERT INTO `dst_street` VALUES ('1213', '住龙镇', '78');
INSERT INTO `dst_street` VALUES ('1214', '屏南镇', '78');
INSERT INTO `dst_street` VALUES ('1215', '兰巨乡', '78');
INSERT INTO `dst_street` VALUES ('1216', '宝溪乡', '78');
INSERT INTO `dst_street` VALUES ('1217', '竹垟畲族乡', '78');
INSERT INTO `dst_street` VALUES ('1218', '道太乡', '78');
INSERT INTO `dst_street` VALUES ('1219', '岩樟乡', '78');
INSERT INTO `dst_street` VALUES ('1220', '城北乡', '78');
INSERT INTO `dst_street` VALUES ('1221', '龙南乡', '78');
INSERT INTO `dst_street` VALUES ('1222', '鹤城街道', '79');
INSERT INTO `dst_street` VALUES ('1223', '瓯南街道', '79');
INSERT INTO `dst_street` VALUES ('1224', '油竹街道', '79');
INSERT INTO `dst_street` VALUES ('1225', '温溪镇', '79');
INSERT INTO `dst_street` VALUES ('1226', '东源镇', '79');
INSERT INTO `dst_street` VALUES ('1227', '高湖镇', '79');
INSERT INTO `dst_street` VALUES ('1228', '船寮镇', '79');
INSERT INTO `dst_street` VALUES ('1229', '海口镇', '79');
INSERT INTO `dst_street` VALUES ('1230', '腊口镇', '79');
INSERT INTO `dst_street` VALUES ('1231', '北山镇', '79');
INSERT INTO `dst_street` VALUES ('1232', '山口镇', '79');
INSERT INTO `dst_street` VALUES ('1233', '仁庄镇', '79');
INSERT INTO `dst_street` VALUES ('1234', '万山乡', '79');
INSERT INTO `dst_street` VALUES ('1235', '黄垟乡', '79');
INSERT INTO `dst_street` VALUES ('1236', '季宅乡', '79');
INSERT INTO `dst_street` VALUES ('1237', '高市乡', '79');
INSERT INTO `dst_street` VALUES ('1238', '海溪乡', '79');
INSERT INTO `dst_street` VALUES ('1239', '章村乡', '79');
INSERT INTO `dst_street` VALUES ('1240', '祯旺乡', '79');
INSERT INTO `dst_street` VALUES ('1241', '祯埠乡', '79');
INSERT INTO `dst_street` VALUES ('1242', '舒桥乡', '79');
INSERT INTO `dst_street` VALUES ('1243', '巨浦乡', '79');
INSERT INTO `dst_street` VALUES ('1244', '万阜乡', '79');
INSERT INTO `dst_street` VALUES ('1245', '方山乡', '79');
INSERT INTO `dst_street` VALUES ('1246', '汤垟乡', '79');
INSERT INTO `dst_street` VALUES ('1247', '贵岙乡', '79');
INSERT INTO `dst_street` VALUES ('1248', '小舟山乡', '79');
INSERT INTO `dst_street` VALUES ('1249', '吴坑乡', '79');
INSERT INTO `dst_street` VALUES ('1250', '仁宫乡', '79');
INSERT INTO `dst_street` VALUES ('1251', '章旦乡', '79');
INSERT INTO `dst_street` VALUES ('1252', '阜山乡', '79');
INSERT INTO `dst_street` VALUES ('1253', '石溪乡', '79');
INSERT INTO `dst_street` VALUES ('1254', '浮云街道', '80');
INSERT INTO `dst_street` VALUES ('1255', '元和街道', '80');
INSERT INTO `dst_street` VALUES ('1256', '白龙山街道', '80');
INSERT INTO `dst_street` VALUES ('1257', '凤凰山街道', '80');
INSERT INTO `dst_street` VALUES ('1258', '崇头镇', '80');
INSERT INTO `dst_street` VALUES ('1259', '石塘镇', '80');
INSERT INTO `dst_street` VALUES ('1260', '紧水滩镇', '80');
INSERT INTO `dst_street` VALUES ('1261', '雾溪畲族乡', '80');
INSERT INTO `dst_street` VALUES ('1262', '安溪畲族乡', '80');
INSERT INTO `dst_street` VALUES ('1263', '赤石乡', '80');
INSERT INTO `dst_street` VALUES ('1264', '红星街道办事处', '81');
INSERT INTO `dst_street` VALUES ('1265', '鹤溪街道办事处', '81');
INSERT INTO `dst_street` VALUES ('1266', '渤海镇', '81');
INSERT INTO `dst_street` VALUES ('1267', '东坑镇', '81');
INSERT INTO `dst_street` VALUES ('1268', '英川镇', '81');
INSERT INTO `dst_street` VALUES ('1269', '沙湾镇', '81');
INSERT INTO `dst_street` VALUES ('1270', '大均乡', '81');
INSERT INTO `dst_street` VALUES ('1271', '澄照乡', '81');
INSERT INTO `dst_street` VALUES ('1272', '梅岐乡', '81');
INSERT INTO `dst_street` VALUES ('1273', '郑坑乡', '81');
INSERT INTO `dst_street` VALUES ('1274', '大漈乡', '81');
INSERT INTO `dst_street` VALUES ('1275', '景南乡', '81');
INSERT INTO `dst_street` VALUES ('1276', '雁溪乡', '81');
INSERT INTO `dst_street` VALUES ('1277', '鸬鹚乡', '81');
INSERT INTO `dst_street` VALUES ('1278', '梧桐乡', '81');
INSERT INTO `dst_street` VALUES ('1279', '标溪乡', '81');
INSERT INTO `dst_street` VALUES ('1280', '毛垟乡', '81');
INSERT INTO `dst_street` VALUES ('1281', '秋炉乡', '81');
INSERT INTO `dst_street` VALUES ('1282', '大地乡', '81');
INSERT INTO `dst_street` VALUES ('1283', '家地乡', '81');
INSERT INTO `dst_street` VALUES ('1284', '九龙乡', '81');
INSERT INTO `dst_street` VALUES ('1285', '松源街道', '82');
INSERT INTO `dst_street` VALUES ('1286', '濛洲街道', '82');
INSERT INTO `dst_street` VALUES ('1287', '屏都街道', '82');
INSERT INTO `dst_street` VALUES ('1288', '黄田镇', '82');
INSERT INTO `dst_street` VALUES ('1289', '竹口镇', '82');
INSERT INTO `dst_street` VALUES ('1290', '荷地镇', '82');
INSERT INTO `dst_street` VALUES ('1291', '左溪镇', '82');
INSERT INTO `dst_street` VALUES ('1292', '贤良镇', '82');
INSERT INTO `dst_street` VALUES ('1293', '百山祖镇', '82');
INSERT INTO `dst_street` VALUES ('1294', '岭头乡', '82');
INSERT INTO `dst_street` VALUES ('1295', '五大堡乡', '82');
INSERT INTO `dst_street` VALUES ('1296', '淤上乡', '82');
INSERT INTO `dst_street` VALUES ('1297', '安南乡', '82');
INSERT INTO `dst_street` VALUES ('1298', '张村乡', '82');
INSERT INTO `dst_street` VALUES ('1299', '隆宫乡', '82');
INSERT INTO `dst_street` VALUES ('1300', '举水乡', '82');
INSERT INTO `dst_street` VALUES ('1301', '江根乡', '82');
INSERT INTO `dst_street` VALUES ('1302', '龙溪乡', '82');
INSERT INTO `dst_street` VALUES ('1303', '官塘乡', '82');
INSERT INTO `dst_street` VALUES ('1304', '五云街道办事处', '83');
INSERT INTO `dst_street` VALUES ('1305', '新碧街道办事处', '83');
INSERT INTO `dst_street` VALUES ('1306', '仙都街道办事处', '83');
INSERT INTO `dst_street` VALUES ('1307', '壶镇镇', '83');
INSERT INTO `dst_street` VALUES ('1308', '新建镇', '83');
INSERT INTO `dst_street` VALUES ('1309', '舒洪镇', '83');
INSERT INTO `dst_street` VALUES ('1310', '大洋镇', '83');
INSERT INTO `dst_street` VALUES ('1311', '东渡镇', '83');
INSERT INTO `dst_street` VALUES ('1312', '东方镇', '83');
INSERT INTO `dst_street` VALUES ('1313', '大源镇', '83');
INSERT INTO `dst_street` VALUES ('1314', '七里乡', '83');
INSERT INTO `dst_street` VALUES ('1315', '前路乡', '83');
INSERT INTO `dst_street` VALUES ('1316', '三溪乡', '83');
INSERT INTO `dst_street` VALUES ('1317', '溶江乡', '83');
INSERT INTO `dst_street` VALUES ('1318', '双溪口乡', '83');
INSERT INTO `dst_street` VALUES ('1319', '胡源乡', '83');
INSERT INTO `dst_street` VALUES ('1320', '方溪乡', '83');
INSERT INTO `dst_street` VALUES ('1321', '石笕乡', '83');
INSERT INTO `dst_street` VALUES ('1322', '妙高街道', '84');
INSERT INTO `dst_street` VALUES ('1323', '云峰街道', '84');
INSERT INTO `dst_street` VALUES ('1324', '新路湾镇', '84');
INSERT INTO `dst_street` VALUES ('1325', '北界镇', '84');
INSERT INTO `dst_street` VALUES ('1326', '金竹镇', '84');
INSERT INTO `dst_street` VALUES ('1327', '大柘镇', '84');
INSERT INTO `dst_street` VALUES ('1328', '石练镇', '84');
INSERT INTO `dst_street` VALUES ('1329', '王村口镇', '84');
INSERT INTO `dst_street` VALUES ('1330', '黄沙腰镇', '84');
INSERT INTO `dst_street` VALUES ('1331', '三仁畲族乡', '84');
INSERT INTO `dst_street` VALUES ('1332', '濂竹乡', '84');
INSERT INTO `dst_street` VALUES ('1333', '应村乡', '84');
INSERT INTO `dst_street` VALUES ('1334', '高坪乡', '84');
INSERT INTO `dst_street` VALUES ('1335', '湖山乡', '84');
INSERT INTO `dst_street` VALUES ('1336', '蔡源乡', '84');
INSERT INTO `dst_street` VALUES ('1337', '焦滩乡', '84');
INSERT INTO `dst_street` VALUES ('1338', '龙洋乡', '84');
INSERT INTO `dst_street` VALUES ('1339', '柘岱口乡', '84');
INSERT INTO `dst_street` VALUES ('1340', '西畈乡', '84');
INSERT INTO `dst_street` VALUES ('1341', '垵口乡', '84');
INSERT INTO `dst_street` VALUES ('1342', '西屏街道办事处', '85');
INSERT INTO `dst_street` VALUES ('1343', '水南街道办事处', '85');
INSERT INTO `dst_street` VALUES ('1344', '望松街道办事处', '85');
INSERT INTO `dst_street` VALUES ('1345', '古市镇', '85');
INSERT INTO `dst_street` VALUES ('1346', '玉岩镇', '85');
INSERT INTO `dst_street` VALUES ('1347', '象溪镇', '85');
INSERT INTO `dst_street` VALUES ('1348', '大东坝镇', '85');
INSERT INTO `dst_street` VALUES ('1349', '新兴镇', '85');
INSERT INTO `dst_street` VALUES ('1350', '叶村乡', '85');
INSERT INTO `dst_street` VALUES ('1351', '斋坛乡', '85');
INSERT INTO `dst_street` VALUES ('1352', '三都乡', '85');
INSERT INTO `dst_street` VALUES ('1353', '竹源乡', '85');
INSERT INTO `dst_street` VALUES ('1354', '四都乡', '85');
INSERT INTO `dst_street` VALUES ('1355', '赤寿乡', '85');
INSERT INTO `dst_street` VALUES ('1356', '樟溪乡', '85');
INSERT INTO `dst_street` VALUES ('1357', '枫坪乡', '85');
INSERT INTO `dst_street` VALUES ('1358', '板桥畲族乡', '85');
INSERT INTO `dst_street` VALUES ('1359', '裕溪乡', '85');
INSERT INTO `dst_street` VALUES ('1360', '安民乡', '85');
INSERT INTO `dst_street` VALUES ('1361', '昌国街道', '86');
INSERT INTO `dst_street` VALUES ('1362', '环南街道', '86');
INSERT INTO `dst_street` VALUES ('1363', '城东街道', '86');
INSERT INTO `dst_street` VALUES ('1364', '盐仓街道', '86');
INSERT INTO `dst_street` VALUES ('1365', '临城街道', '86');
INSERT INTO `dst_street` VALUES ('1366', '岑港街道', '86');
INSERT INTO `dst_street` VALUES ('1367', '马岙街道', '86');
INSERT INTO `dst_street` VALUES ('1368', '双桥街道', '86');
INSERT INTO `dst_street` VALUES ('1369', '小沙街道', '86');
INSERT INTO `dst_street` VALUES ('1370', '千岛街道', '86');
INSERT INTO `dst_street` VALUES ('1371', '金塘镇', '86');
INSERT INTO `dst_street` VALUES ('1372', '白泉镇', '86');
INSERT INTO `dst_street` VALUES ('1373', '干览镇', '86');
INSERT INTO `dst_street` VALUES ('1374', '沈家门街道', '87');
INSERT INTO `dst_street` VALUES ('1375', '东港街道', '87');
INSERT INTO `dst_street` VALUES ('1376', '朱家尖街道', '87');
INSERT INTO `dst_street` VALUES ('1377', '展茅街道', '87');
INSERT INTO `dst_street` VALUES ('1378', '六横镇', '87');
INSERT INTO `dst_street` VALUES ('1379', '虾峙镇', '87');
INSERT INTO `dst_street` VALUES ('1380', '桃花镇', '87');
INSERT INTO `dst_street` VALUES ('1381', '东极镇', '87');
INSERT INTO `dst_street` VALUES ('1382', '普陀山镇', '87');
INSERT INTO `dst_street` VALUES ('1383', '高亭镇', '88');
INSERT INTO `dst_street` VALUES ('1384', '东沙镇', '88');
INSERT INTO `dst_street` VALUES ('1385', '岱东镇', '88');
INSERT INTO `dst_street` VALUES ('1386', '岱西镇', '88');
INSERT INTO `dst_street` VALUES ('1387', '长涂镇', '88');
INSERT INTO `dst_street` VALUES ('1388', '衢山镇', '88');
INSERT INTO `dst_street` VALUES ('1389', '秀山乡', '88');
INSERT INTO `dst_street` VALUES ('1390', '菜园镇', '89');
INSERT INTO `dst_street` VALUES ('1391', '嵊山镇', '89');
INSERT INTO `dst_street` VALUES ('1392', '洋山镇', '89');
INSERT INTO `dst_street` VALUES ('1393', '五龙乡', '89');
INSERT INTO `dst_street` VALUES ('1394', '黄龙乡', '89');
INSERT INTO `dst_street` VALUES ('1395', '枸杞乡', '89');
INSERT INTO `dst_street` VALUES ('1396', '花鸟乡', '89');
INSERT INTO `dst_street` VALUES ('1397', '', '90');
INSERT INTO `dst_street` VALUES ('1398', '未知街道', '6');

-- ----------------------------
-- Table structure for laf_item
-- ----------------------------
DROP TABLE IF EXISTS `laf_item`;
CREATE TABLE `laf_item` (
  `item_id` int(11) NOT NULL AUTO_INCREMENT,
  `item_name` varchar(25) DEFAULT NULL,
  `item_desc` varchar(500) DEFAULT NULL,
  `item_pick_up_time` datetime DEFAULT NULL,
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `edit_time` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`item_id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8 COMMENT='lost and found item table';

-- ----------------------------
-- Records of laf_item
-- ----------------------------
INSERT INTO `laf_item` VALUES ('1', '褪色的校园卡', 'test', '2018-10-06 14:26:48', '2018-10-06 14:26:52', '2018-10-06 14:26:52');
INSERT INTO `laf_item` VALUES ('2', 'test2', 'test', '2018-10-06 14:26:48', '2018-10-06 14:26:52', '2018-10-06 14:26:52');
INSERT INTO `laf_item` VALUES ('3', 'test', 'test', '2018-10-09 00:00:00', '2018-10-09 22:51:33', '2018-10-09 22:29:28');
INSERT INTO `laf_item` VALUES ('4', '233', '123', '2018-10-09 00:00:00', '2018-10-09 22:51:30', '2018-10-09 22:34:13');
INSERT INTO `laf_item` VALUES ('5', 'test', 'test', '2018-10-09 00:00:00', '2018-10-09 22:51:27', '2018-10-09 22:36:54');
INSERT INTO `laf_item` VALUES ('6', 'test', 'test', '2018-10-09 00:00:00', '2018-10-09 22:51:24', '2018-10-09 22:37:52');
INSERT INTO `laf_item` VALUES ('7', 'test', 'test', '2018-10-09 00:00:00', '2018-10-09 22:51:21', '2018-10-09 22:38:36');
INSERT INTO `laf_item` VALUES ('8', '校园卡等', '此外还包涵了许多东西', '2018-10-09 00:00:00', '2018-10-09 22:50:55', '2018-10-09 22:50:55');
INSERT INTO `laf_item` VALUES ('9', '小明的校园卡', '校园卡啊', '2018-10-09 00:00:00', '2018-10-09 22:54:33', '2018-10-09 22:54:33');
INSERT INTO `laf_item` VALUES ('14', '富文本编辑器 Editor name', '富文本编辑器 Editor item desc,', '2018-12-16 00:00:00', '2018-12-16 15:03:42', '2018-12-16 15:03:42');
INSERT INTO `laf_item` VALUES ('15', '富文本编辑器 Editor name', '富文本编辑器 Editor&nbsp;item', '2018-12-16 00:00:00', '2018-12-16 15:24:26', '2018-12-16 15:24:26');
INSERT INTO `laf_item` VALUES ('16', '富文本编辑器 Editor name', '<img src=\"http://localhost:8989/lib/plugins/kindeditor/plugins/emoticons/images/2.gif\" border=\"0\" alt=\"\" /><strong>士大夫士\r\n<pre class=\"prettyprint lang-js\">console.log(\'哈哈\')</pre>\r\n</strong>', '2018-12-16 00:00:00', '2018-12-16 15:27:53', '2018-12-16 15:27:53');
INSERT INTO `laf_item` VALUES ('17', '电话', '<span>就是那个电话,&nbsp;大概长这样<img src=\"http://localhost:8989/lib/plugins/kindeditor/plugins/emoticons/images/118.gif\" border=\"0\" alt=\"\" /></span><img src=\"http://localhost:8989/lib/plugins/kindeditor/plugins/emoticons/images/115.gif\" border=\"0\" alt=\"\" /><img src=\"http://localhost:8989/lib/plugins/kindeditor/plugins/emoticons/images/118.gif\" border=\"0\" alt=\"\" />', '2018-12-16 00:00:00', '2018-12-16 16:12:28', '2018-12-16 16:12:28');

-- ----------------------------
-- Table structure for laf_message
-- ----------------------------
DROP TABLE IF EXISTS `laf_message`;
CREATE TABLE `laf_message` (
  `message_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL COMMENT 'user primary key',
  `item_id` int(11) DEFAULT NULL,
  `message_desc` varchar(500) DEFAULT NULL,
  `msg_title` varchar(500) DEFAULT NULL COMMENT 'a url list with scroll img url or single',
  `message_type` tinyint(4) DEFAULT NULL,
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `edit_time` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`message_id`),
  KEY `FK_associate_item` (`item_id`),
  KEY `FK_publisher` (`user_id`),
  CONSTRAINT `FK_associate_item` FOREIGN KEY (`item_id`) REFERENCES `laf_item` (`item_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_publisher` FOREIGN KEY (`user_id`) REFERENCES `sys_user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8 COMMENT='lost and found message table';

-- ----------------------------
-- Records of laf_message
-- ----------------------------
INSERT INTO `laf_message` VALUES ('1', '1', '1', '这个东西是谁丢的?', '捡东西', '10', '2018-10-05 23:30:11', '2018-10-06 19:04:01');
INSERT INTO `laf_message` VALUES ('2', '1', '2', '这个东西好像是我丢的', '丢东西', '20', '2018-10-06 21:39:00', '2018-10-06 21:39:00');
INSERT INTO `laf_message` VALUES ('3', '1', '3', '捡', '捡东西', '10', '2018-10-09 22:47:35', '2018-10-09 22:29:28');
INSERT INTO `laf_message` VALUES ('4', '1', '4', '捡', '捡东西', '10', '2018-10-09 22:47:39', '2018-10-09 22:34:13');
INSERT INTO `laf_message` VALUES ('5', '1', '5', '捡', '捡东西', '10', '2018-10-09 22:47:42', '2018-10-09 22:36:54');
INSERT INTO `laf_message` VALUES ('6', '1', '6', '捡', '捡东西', '10', '2018-10-09 22:47:44', '2018-10-09 22:37:52');
INSERT INTO `laf_message` VALUES ('7', '1', '7', '捡', '捡东西', '10', '2018-10-09 22:51:03', '2018-10-09 22:38:36');
INSERT INTO `laf_message` VALUES ('8', '1', '8', '我在图书馆捡了一张校园卡, 卡号是3160407066, 请问这是谁的', '捡东西', '10', '2018-10-09 22:50:55', '2018-10-09 22:50:55');
INSERT INTO `laf_message` VALUES ('9', '1', '9', '食堂捡了一张校园卡, 卡号是66666666请问这是谁的', '捡东西', '10', '2018-10-09 22:54:33', '2018-10-09 22:54:33');
INSERT INTO `laf_message` VALUES ('10', '1', '9', '这个卡是貌似我的唉', '消息', '0', '2018-10-10 14:18:55', '2018-10-10 14:18:55');
INSERT INTO `laf_message` VALUES ('11', '1', '9', '233\r\n', '消息', '0', '2018-10-10 14:51:35', '2018-10-10 14:51:35');
INSERT INTO `laf_message` VALUES ('17', '1', '14', '富文本编辑器 Editor msg des', '丢东西', '20', '2018-12-16 15:03:42', '2018-12-16 15:03:42');
INSERT INTO `laf_message` VALUES ('18', '1', '15', '富文本编辑器 Editor&nbsp;msg', '捡东西', '10', '2018-12-16 15:24:26', '2018-12-16 15:24:26');
INSERT INTO `laf_message` VALUES ('19', '1', '16', '<img src=\"http://localhost:8989/lib/plugins/kindeditor/plugins/emoticons/images/0.gif\" border=\"0\" alt=\"\" />', '捡东西', '10', '2018-12-16 15:27:53', '2018-12-16 15:27:53');
INSERT INTO `laf_message` VALUES ('20', '1', '17', '就是那个<img src=\"http://localhost:8989/lib/plugins/kindeditor/plugins/emoticons/images/11.gif\" border=\"0\" alt=\"\" />', '谁领错了', '20', '2018-12-16 16:12:28', '2018-12-16 16:12:28');

-- ----------------------------
-- Table structure for laf_return_log
-- ----------------------------
DROP TABLE IF EXISTS `laf_return_log`;
CREATE TABLE `laf_return_log` (
  `return_id` int(11) NOT NULL AUTO_INCREMENT,
  `piker_user_id` int(11) DEFAULT NULL COMMENT 'user primary key',
  `owner_user_id` int(11) DEFAULT NULL COMMENT 'user primary key',
  `item_id` int(11) DEFAULT NULL,
  `return_img_url` varchar(50) DEFAULT NULL COMMENT 'evidence img',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `edit_time` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`return_id`),
  KEY `FK_owner` (`owner_user_id`),
  KEY `FK_picker` (`piker_user_id`),
  KEY `FK_return_item` (`item_id`),
  CONSTRAINT `FK_owner` FOREIGN KEY (`owner_user_id`) REFERENCES `sys_user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_picker` FOREIGN KEY (`piker_user_id`) REFERENCES `sys_user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_return_item` FOREIGN KEY (`item_id`) REFERENCES `laf_item` (`item_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='lost and found return log table';

-- ----------------------------
-- Records of laf_return_log
-- ----------------------------

-- ----------------------------
-- Table structure for op_log
-- ----------------------------
DROP TABLE IF EXISTS `op_log`;
CREATE TABLE `op_log` (
  `op_log_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '操作日志主键',
  `op_name` varchar(255) DEFAULT NULL COMMENT '操作名称',
  PRIMARY KEY (`op_log_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of op_log
-- ----------------------------
INSERT INTO `op_log` VALUES ('1', 'insert');
INSERT INTO `op_log` VALUES ('2', 'insert');
INSERT INTO `op_log` VALUES ('3', 'insert');
INSERT INTO `op_log` VALUES ('4', 'insert');
INSERT INTO `op_log` VALUES ('5', 'insert');
INSERT INTO `op_log` VALUES ('6', 'insert');
INSERT INTO `op_log` VALUES ('7', 'insert');
INSERT INTO `op_log` VALUES ('8', 'insert');
INSERT INTO `op_log` VALUES ('9', 'insert');
INSERT INTO `op_log` VALUES ('10', 'insert');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'user primary key',
  `user_username` varchar(50) DEFAULT NULL COMMENT 'unique',
  `user_password` varchar(50) DEFAULT NULL,
  `user_realname` varchar(50) DEFAULT NULL,
  `user_nickname` varchar(50) DEFAULT NULL,
  `user_avatar_url` varchar(128) DEFAULT NULL,
  `user_email_address` varchar(50) DEFAULT NULL COMMENT 'For registration',
  `user_contact_way` varchar(50) DEFAULT NULL COMMENT 'Some other contact methods, such as phone, QQ',
  `user_sex` varchar(4) DEFAULT NULL,
  `user_birthday` date DEFAULT NULL,
  `user_role` tinyint(4) DEFAULT NULL COMMENT 'Decision authority, Related to permissions',
  `user_token` varchar(255) DEFAULT NULL,
  `user_sign_in_ip` varchar(20) DEFAULT NULL,
  `user_sign_in_time` datetime DEFAULT NULL,
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `edit_time` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='user table';

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', 'admin', '123456', '真名0', '昵称', 'https://avatar-static.segmentfault.com/267/666/2676661219-59894cbb54922_big64', '1@email.com', '18723888888', 'none', '2018-10-04', '10', 'eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE1Mzg4ODE1NjksInVzZXJuYW1lIjoiYWRtaW4ifQ.T9jbcyILFHfsq4Tfeau0442rIIbeY6TMSJX8UyUii-Aadmin', null, null, '2018-10-04 19:34:40', '2018-10-04 19:34:40');
INSERT INTO `sys_user` VALUES ('2', 'admin12', '123456', null, null, null, '12312@email.com', null, null, '2018-10-05', null, null, null, null, '2018-10-11 11:22:58', '2018-10-11 11:22:58');
DROP TRIGGER IF EXISTS `after_insert`;
DELIMITER ;;
CREATE TRIGGER `after_insert` AFTER INSERT ON `laf_message` FOR EACH ROW begin
	  insert into op_log(op_name)
		values( 'insert');
end
;;
DELIMITER ;
