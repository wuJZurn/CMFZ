/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50528
Source Host           : 127.0.0.1:3306
Source Database       : cmfz

Target Server Type    : MYSQL
Target Server Version : 50528
File Encoding         : 65001

Date: 2018-07-12 15:37:57
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for album
-- ----------------------------
DROP TABLE IF EXISTS `album`;
CREATE TABLE `album` (
  `album_id` varchar(50) NOT NULL,
  `album_name` varchar(50) DEFAULT NULL,
  `album_author` varchar(50) DEFAULT NULL,
  `album_cv` varchar(50) DEFAULT NULL,
  `album_count` int(11) DEFAULT NULL,
  `album_score` double DEFAULT NULL,
  `album_src` varchar(20) DEFAULT NULL,
  `publish_date` datetime DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`album_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of album
-- ----------------------------

-- ----------------------------
-- Table structure for article
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article` (
  `article_id` varchar(50) NOT NULL,
  `article_name` varchar(50) NOT NULL,
  `master_id` int(11) DEFAULT NULL,
  `introduction` text,
  `article_date` datetime DEFAULT NULL,
  `article_status` varchar(20) DEFAULT NULL,
  `article_author` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`article_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of article
-- ----------------------------
INSERT INTO `article` VALUES ('09b021b324014a20ab3b1505dfa87d28', 'terte', '2', '<p>423424</p>', '2018-07-09 22:02:47', 'off', null);
INSERT INTO `article` VALUES ('0ab669c2e9a0433db09b6cbd30161c83', 'fdsf', '3', '<p>fdsfg</p>', '2018-07-11 19:07:33', 'on', null);
INSERT INTO `article` VALUES ('0befe0352b6f4f77853f99c87e99cf32', 'rrr', '1', '<p>啦啦啦</p>', '2018-07-09 08:20:15', 'on', 'fff');
INSERT INTO `article` VALUES ('0c56a774b6ea445ebd7169649429ee15', 'test1', '1', '<h2>标题一</h2><p><img src=\"/admin/upload/article/5eb20a51-dae5-494c-ba55-621ff21c4ce0.jpg\" style=\"max-width:100%;\"></p><p><span style=\"font-style: italic; text-decoration-line: underline;\">测试</span></p>', '2018-07-08 22:33:43', 'on', 'wu');
INSERT INTO `article` VALUES ('1417f20ccf51464f89dedc3d75cb3fbb', 'gdfgdfg', '2', '<p>hgfhfh</p>', '2018-07-10 09:45:26', 'on', null);
INSERT INTO `article` VALUES ('1e57afe16be0408e88d85fb89900ecaf', 'test2222', '1', '<p>fsdfsdf</p>', '2018-07-09 10:01:22', 'on', '28');
INSERT INTO `article` VALUES ('218b931934684d85923f13ab71a61ed0', 'fsdf', '2', '<p>gsdgdsfgsdfg</p>', '2018-07-09 10:39:45', 'on', null);
INSERT INTO `article` VALUES ('3b031c330dfa40e088a6060bca33a77f', 'fdsf', '2', '<p>543534</p>', '2018-07-09 22:02:02', 'on', null);
INSERT INTO `article` VALUES ('75e03fe5a74140558d0a33d93742bb90', '', '3', '<p>ff</p>', '2018-07-10 09:11:16', 'on', null);
INSERT INTO `article` VALUES ('87f714e98b1946708a2f3deacd9f34e2', 'fsdf', '3', '<p>gdgdfg</p>', '2018-07-10 09:38:13', 'on', null);
INSERT INTO `article` VALUES ('a627ceba133948bd861bf8985e0b7deb', 'zhehsi', '3', '<p><img src=\"/admin/upload/article/cb7a6da1-5373-47f9-ada7-dc04afddc2d8.jpg\" style=\"max-width:100%;\"></p>', '2018-07-10 11:27:19', 'on', null);
INSERT INTO `article` VALUES ('d007f1a77c454caa9372a203e7b14971', '文章', '1', '<p>这是一篇文章！</p><p><br></p>', '2018-07-08 22:43:49', 'off', 'wu');
INSERT INTO `article` VALUES ('eeb30496bb1f4c59924ad787a26c0872', 'bbb', '28', '<p>fsdf</p>', '2018-07-10 09:10:08', 'on', null);
INSERT INTO `article` VALUES ('f8c6b95ac5754270a4129e1aaf31a128', 'fsdf', '2', '<p>fsdfg</p>', '2018-07-12 09:54:40', 'on', null);

-- ----------------------------
-- Table structure for audio
-- ----------------------------
DROP TABLE IF EXISTS `audio`;
CREATE TABLE `audio` (
  `audio_id` varchar(50) NOT NULL,
  `audio_name` varchar(50) DEFAULT NULL,
  `audio_singer` varchar(40) DEFAULT NULL,
  `audio_add` varchar(255) DEFAULT NULL,
  `album_id` varchar(50) DEFAULT NULL,
  `audio_count` int(11) DEFAULT NULL,
  PRIMARY KEY (`audio_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of audio
-- ----------------------------

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `category_id` varchar(50) NOT NULL,
  `category_name` varchar(50) DEFAULT NULL,
  `user_id` varchar(50) DEFAULT NULL,
  `catrgory_status` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`category_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of category
-- ----------------------------

-- ----------------------------
-- Table structure for counter
-- ----------------------------
DROP TABLE IF EXISTS `counter`;
CREATE TABLE `counter` (
  `counter_id` varchar(50) NOT NULL,
  `counter_name` varchar(50) DEFAULT NULL,
  `count` int(11) DEFAULT NULL,
  `category_id` varchar(50) DEFAULT NULL,
  `category_time` datetime DEFAULT NULL,
  `user_id` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`counter_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of counter
-- ----------------------------

-- ----------------------------
-- Table structure for logger
-- ----------------------------
DROP TABLE IF EXISTS `logger`;
CREATE TABLE `logger` (
  `log_id` varchar(50) NOT NULL,
  `log_user` varchar(50) NOT NULL,
  `log_time` datetime DEFAULT NULL,
  `log_resource` varchar(50) DEFAULT NULL,
  `log_action` varchar(20) DEFAULT NULL,
  `log_message` text,
  `log_result` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`log_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of logger
-- ----------------------------
INSERT INTO `logger` VALUES ('30520b422d1d433b85546177c8e164aa', 'admin', '2018-07-11 19:07:33', 'Article', 'add', 'Article{articleId=\'0ab669c2e9a0433db09b6cbd30161c83\', masterId=3, articleName=\'fdsf\', introduction=\'<p>fdsfg</p>\', articleDate=Wed Jul 11 19:07:33 CST 2018, articleStatus=\'on\', articleAuthor=\'null\', errno=0, data=null};', 'success');
INSERT INTO `logger` VALUES ('305959703a354475a1d63be560bb4169', 'admin', '2018-07-10 09:38:14', 'Article', 'add', 'Article{articleId=\\\'87f714e98b1946708a2f3deacd9f34e2\\\', masterId=3, articleName=\\\'fsdf\\\', introduction=\\\'<p>gdgdfg</p>\\\', articleDate=Tue Jul 10 09:38:13 CST 2018, articleStatus=\\\'on\\\', articleAuthor=\\\'null\\\', errno=0, data=null}', 'success');
INSERT INTO `logger` VALUES ('3181e0943b39478cb391c6eb80ffff69', 'aaa', '2018-07-09 21:40:23', 'Article', 'add', 'Article{articleId=\\\'2765213b61314d20829151f172f53e7a\\\', masterId=0, articleName=\\\'null\\\', introduction=\\\'null\\\', articleDate=Mon Jul 09 21:40:23 CST 2018, articleStatus=\\\'off\\\', articleAuthor=\\\'null\\\', errno=0, data=null}', 'success');
INSERT INTO `logger` VALUES ('341bd5e31ba147a199968611209eda86', 'wu', '2018-07-11 18:30:14', 'Manager', 'add', 'Manager{mgrId=null, mgrName=\'null\', mgrPwd=\'null\', salt=\'null\', mgrStatus=\'null\'};', 'success');
INSERT INTO `logger` VALUES ('3e07033dab234c6cb7e560da55701a2b', 'admin', '2018-07-09 22:02:47', 'Article', 'add', 'Article{articleId=\\\'09b021b324014a20ab3b1505dfa87d28\\\', masterId=2, articleName=\\\'terte\\\', introduction=\\\'<p>423424</p>\\\', articleDate=Mon Jul 09 22:02:47 CST 2018, articleStatus=\\\'off\\\', articleAuthor=\\\'null\\\', errno=0, data=null}', 'success');
INSERT INTO `logger` VALUES ('774b4d82a3cc4f5bbe5da1159e3e6089', 'aaa', '2018-07-09 21:23:50', 'Manager', 'add', 'Manager{mgrId=335324, mgrName=\'lalal\', mgrPwd=\'1e155988d6e8876919fabc9ebcefe546\', salt=\'f3Ag34\', mgrStatus=\'1\'}', 'success');
INSERT INTO `logger` VALUES ('ab86990409324119bb7e873efe2c4a1c', 'admin', '2018-07-10 09:45:26', 'Article', 'add', 'Article{articleId=\'1417f20ccf51464f89dedc3d75cb3fbb\', masterId=2, articleName=\'gdfgdfg\', introduction=\'<p>hgfhfh</p>\', articleDate=Tue Jul 10 09:45:26 CST 2018, articleStatus=\'on\', articleAuthor=\'null\', errno=0, data=null};', 'success');
INSERT INTO `logger` VALUES ('ac855755eab645f2bb632b7faa2a2da4', 'admin', '2018-07-10 09:30:38', 'Article', 'add', 'Article{articleId=\\\'1843b849e9f74aa38727b2aae33c8df4\\\', masterId=2, articleName=\\\'null\\\', introduction=\\\'<p>fsdf</p>\\\', articleDate=Tue Jul 10 09:30:38 CST 2018, articleStatus=\\\'on\\\', articleAuthor=\\\'null\\\', errno=0, data=null}', 'false');
INSERT INTO `logger` VALUES ('ba707cc1676b45dba676d4c9266f5597', 'aaa', '2018-07-09 20:55:47', 'Manager', 'add', 'Manager{mgrId=332, \'dd\'}', 'success');
INSERT INTO `logger` VALUES ('c1fb47db65574805a21197656245e001', 'admin', '2018-07-10 09:10:09', 'Article', 'add', 'Article{articleId=\\\'eeb30496bb1f4c59924ad787a26c0872\\\', masterId=28, articleName=\\\'bbb\\\', introduction=\\\'<p>fsdf</p>\\\', articleDate=Tue Jul 10 09:10:08 CST 2018, articleStatus=\\\'on\\\', articleAuthor=\\\'null\\\', errno=0, data=null}', 'success');
INSERT INTO `logger` VALUES ('dbbc5bb0c81448c6ad8c7ac6083a8242', 'aaa', '2018-07-09 21:37:58', 'Manager', 'add', 'Manager{mgrId=3654444, mgrName=\\\'lalal\\\', mgrPwd=\\\'5799d98b1fb7c385cd49d526d2c87433\\\', salt=\\\'4ccca2\\\', mgrStatus=\\\'1\\\'}', 'success');
INSERT INTO `logger` VALUES ('e9967370b73a4a108ebe7bb883bf9eb6', 'aaa', '2018-07-09 21:20:42', 'Manager', 'add', 'Manager{mgrId=3354434mgrName=\'lalal\', mgrPwd=\'77d5f181dd1b70f3f849e433324b3722\'mgrStatus=\'1\'}', 'success');
INSERT INTO `logger` VALUES ('e9967370b73drwea108ebe7bb883bf9eb6', 'aaa', '2018-07-09 21:17:54', 'Manager', 'add', 'Manager{mgrId=332, \'dd\'}', 'success');
INSERT INTO `logger` VALUES ('ea6f53350ebc49569a102e40a8bc5f72', 'admin', '2018-07-10 09:11:16', 'Article', 'add', 'Article{articleId=\\\'75e03fe5a74140558d0a33d93742bb90\\\', masterId=3, articleName=\\\'\\\', introduction=\\\'<p>ff</p>\\\', articleDate=Tue Jul 10 09:11:16 CST 2018, articleStatus=\\\'on\\\', articleAuthor=\\\'null\\\', errno=0, data=null}', 'success');
INSERT INTO `logger` VALUES ('fd473c67e441407d907bd80e4d1a81b6', 'admin', '2018-07-12 09:54:40', 'Article', 'add', 'Article{articleId=\'f8c6b95ac5754270a4129e1aaf31a128\', masterId=2, articleName=\'fsdf\', introduction=\'<p>fsdfg</p>\', articleDate=Thu Jul 12 09:54:40 CST 2018, articleStatus=\'on\', articleAuthor=\'null\', errno=0, data=null};', 'success');

-- ----------------------------
-- Table structure for manager
-- ----------------------------
DROP TABLE IF EXISTS `manager`;
CREATE TABLE `manager` (
  `mgr_id` int(50) NOT NULL AUTO_INCREMENT,
  `mgr_name` varchar(50) DEFAULT NULL,
  `mgr_pwd` varchar(50) DEFAULT NULL,
  `salt` varchar(50) DEFAULT NULL,
  `mgr_status` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`mgr_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of manager
-- ----------------------------
INSERT INTO `manager` VALUES ('1', 'root', '123', '222', '1');
INSERT INTO `manager` VALUES ('2', '吴', '123456', '3333', '2');
INSERT INTO `manager` VALUES ('3', 'admin', 'f48edd4c8cdc37e2c5dad0297ab75e3f', 'xyz', '1');
INSERT INTO `manager` VALUES ('4', 'wu', 'f48edd4c8cdc37e2c5dad0297ab75e3f', 'xyz', '1');

-- ----------------------------
-- Table structure for master
-- ----------------------------
DROP TABLE IF EXISTS `master`;
CREATE TABLE `master` (
  `master_id` int(50) NOT NULL AUTO_INCREMENT,
  `master_name` varchar(32) DEFAULT NULL,
  `master_photo` varchar(255) DEFAULT NULL,
  `master_summary` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`master_id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of master
-- ----------------------------
INSERT INTO `master` VALUES ('1', '仁波切1', '', 'bbbb');
INSERT INTO `master` VALUES ('2', '仁波切2', '', 'bbbb');
INSERT INTO `master` VALUES ('3', '仁波切3', '', 'bbbb');
INSERT INTO `master` VALUES ('28', '仁波切4', null, 'bbbb');
INSERT INTO `master` VALUES ('29', '仁波切5', null, '11');
INSERT INTO `master` VALUES ('30', '仁波切6', null, 'bbbb');
INSERT INTO `master` VALUES ('32', '仁波切7', '/MyPic.jpg', 'ss');

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu` (
  `menu_id` int(11) NOT NULL AUTO_INCREMENT,
  `menu_name` varchar(50) DEFAULT NULL,
  `menu_code` varchar(50) DEFAULT NULL,
  `menu_icon` varchar(255) DEFAULT NULL,
  `menu_url` varchar(255) DEFAULT NULL,
  `menu_parent_id` int(11) DEFAULT NULL,
  `menu_level` int(11) DEFAULT NULL,
  PRIMARY KEY (`menu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES ('1', '持名法州之用户', 'user', 'icon-user_home', '', '0', '1');
INSERT INTO `menu` VALUES ('2', '持名法州之专辑', 'album', 'icon-dvd', null, '0', '1');
INSERT INTO `menu` VALUES ('3', '持名法州之轮播图', 'picture', 'icon-pictures', '', '0', '1');
INSERT INTO `menu` VALUES ('4', '持名法州之文章', 'article', 'icon-page_white_text', null, '0', '1');
INSERT INTO `menu` VALUES ('5', '持名法州之日志管理', null, 'icon-text_list_bullets', null, '0', '1');
INSERT INTO `menu` VALUES ('6', '持名法州之统计分析', null, 'icon-chart_pie', null, '0', '1');
INSERT INTO `menu` VALUES ('7', '持名法州之上师', 'master', 'icon-user_red', null, '0', '1');
INSERT INTO `menu` VALUES ('8', '持名法州之功课', 'project', 'icon-bullet_edit', null, '0', '1');
INSERT INTO `menu` VALUES ('9', '用户管理', null, 'icon-user_alert', null, '1', '2');
INSERT INTO `menu` VALUES ('10', '用户管理1', null, 'icon-dvd_add', null, '1', '2');
INSERT INTO `menu` VALUES ('11', '用户管理2', null, 'icon-pictures_thumbs', null, '1', '2');
INSERT INTO `menu` VALUES ('14', '查看轮播图', 'picture', 'icon-pictures', 'main/picture.jsp', '3', '2');
INSERT INTO `menu` VALUES ('15', '查看上师', 'master', 'icon-user_red', 'main/master.jsp', '7', '2');
INSERT INTO `menu` VALUES ('16', '文章列表', 'article', 'icon-note', 'main/article.jsp', '4', '2');
INSERT INTO `menu` VALUES ('17', '创建文章', null, 'icon-note_add', 'main/addArticle.jsp', '4', '2');
INSERT INTO `menu` VALUES ('18', '统计分析', null, 'icon-chart_pie', 'main/echartsPic.jsp', '6', '2');
INSERT INTO `menu` VALUES ('19', '用户分布图', null, 'icon-chart_pie', 'main/echarts.jsp', '6', '2');
INSERT INTO `menu` VALUES ('20', '查看日志', null, 'icon-pictures', 'main/logger.jsp', '5', '2');

-- ----------------------------
-- Table structure for picture
-- ----------------------------
DROP TABLE IF EXISTS `picture`;
CREATE TABLE `picture` (
  `picture_id` varchar(50) NOT NULL,
  `picture_path` varchar(255) DEFAULT NULL,
  `picture_date` datetime DEFAULT NULL,
  `picture_description` varchar(255) DEFAULT NULL,
  `picture_status` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`picture_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of picture
-- ----------------------------
INSERT INTO `picture` VALUES ('81824e8c03b24128a9be1d4dd31320b1', '/1.jpg', '2018-07-06 08:39:44', '轮播图4', '展示中');
INSERT INTO `picture` VALUES ('97f5920fb7c34c99bc6b76b409dcbba6', '/15040910321846.jpg', '2018-07-06 11:06:20', 'vv', '未展示');
INSERT INTO `picture` VALUES ('b60141705e2a4c3e9a3f0c3b6fa2c0ea', '/15040910326361.jpg', '2018-07-06 11:03:27', 'ooo', '未展示');
INSERT INTO `picture` VALUES ('be585041a5054870ae4ffe34a9f42ce4', '/MyPic.jpg', '2018-07-06 08:39:12', '轮播图1', '未展示');
INSERT INTO `picture` VALUES ('cc89dce348c64044892ba3009c6116f0', '/111.jpg', '2018-07-06 08:58:06', 'aaa211', '未展示');
INSERT INTO `picture` VALUES ('dd1d3fbb38f74816b86c284d3d191a36', '/6.jpg', '2018-07-06 08:41:25', '轮播图5', '展示中');
INSERT INTO `picture` VALUES ('df23cedc763e4b3f97a6549d26a28921', '/1.jpg', '2018-07-06 08:28:42', '轮播图2', '展示中');
INSERT INTO `picture` VALUES ('ed00232abd534ee6b3c19690824e5681', '/7.jpg', '2018-07-06 08:41:41', '轮播图6', '展示中');
INSERT INTO `picture` VALUES ('f06c2388fb384e3ab2f7bbd7d5b22ab8', '/3.jpg', '2018-07-06 08:40:17', '轮播图3', '展示中');

-- ----------------------------
-- Table structure for sys_manager_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_manager_role`;
CREATE TABLE `sys_manager_role` (
  `role_id` int(11) DEFAULT NULL,
  `mgr_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_manager_role
-- ----------------------------
INSERT INTO `sys_manager_role` VALUES ('1', '3');
INSERT INTO `sys_manager_role` VALUES ('2', '3');
INSERT INTO `sys_manager_role` VALUES ('3', '3');
INSERT INTO `sys_manager_role` VALUES ('3', '4');

-- ----------------------------
-- Table structure for sys_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_permission`;
CREATE TABLE `sys_permission` (
  `permission_id` int(11) NOT NULL,
  `resource_name` varchar(255) DEFAULT NULL,
  `resource_tag` varchar(255) DEFAULT NULL,
  `resource_url` varchar(255) DEFAULT NULL,
  `permission_tag` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`permission_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_permission
-- ----------------------------
INSERT INTO `sys_permission` VALUES ('1', '用户新增', 'user-add', '/user/add', 'user:add');
INSERT INTO `sys_permission` VALUES ('2', '用户展示', 'user-query', '/user/query', 'user:query');
INSERT INTO `sys_permission` VALUES ('3', '用户修改', 'user-modify', '/user/modify', 'user:modify');
INSERT INTO `sys_permission` VALUES ('4', '用户删除', 'user-remove', '/user/remove', 'user:remove');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `role_id` int(11) NOT NULL,
  `role_name` varchar(255) DEFAULT NULL,
  `role_tag` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', '超级管理员', 'root');
INSERT INTO `sys_role` VALUES ('2', '普通管理员', 'admin');
INSERT INTO `sys_role` VALUES ('3', '系统用户', 'user');

-- ----------------------------
-- Table structure for sys_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_permission`;
CREATE TABLE `sys_role_permission` (
  `role_id` int(11) DEFAULT NULL,
  `permission_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role_permission
-- ----------------------------
INSERT INTO `sys_role_permission` VALUES ('1', '1');
INSERT INTO `sys_role_permission` VALUES ('1', '3');
INSERT INTO `sys_role_permission` VALUES ('1', '4');
INSERT INTO `sys_role_permission` VALUES ('2', '1');
INSERT INTO `sys_role_permission` VALUES ('3', '2');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` varchar(50) NOT NULL,
  `user_name` varchar(40) DEFAULT NULL,
  `user_buddhish_name` varchar(40) DEFAULT NULL,
  `user_password` varchar(50) DEFAULT NULL,
  `user_sex` varchar(5) DEFAULT NULL,
  `user_head_pic` varchar(255) DEFAULT NULL,
  `user_address` varchar(100) DEFAULT NULL,
  `user_phone` varchar(11) DEFAULT NULL,
  `user_signature` varchar(100) DEFAULT NULL,
  `user_status` varchar(10) DEFAULT NULL,
  `master_id` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
