# 安装mariadb
################################################################################
yum install mariadb-server

systemctl start mariadb

mysql
create database mydb default character set utf8 collate utf8_bin;
grant all on mydb.* to 'cloud'@'%' identified by 'passwd' with grant option;
flush privileges;
use mydb
create table t_employee 
(id int primary key auto_increment, 
name varchar(50) not null, 
address varchar(100) not null,
age int not null,
department int not null,
salary int,
tel varchar(20) not null,
CONSTRAINT `t_emp_ibfk_1` FOREIGN KEY (`department`) REFERENCES `t_department` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT);
insert into t_employee values(NULL, 'zhangsan', 'jilin', 23, 1, 4000, '13888883345');
insert into t_employee values(NULL, 'lisi', 'beijing', 25, 2, 2000, '13888883343');
insert into t_employee values(NULL, 'wangwu', 'shanghai', 24, 3, 3000, '13888883348');

CREATE TABLE `t_department`  (
`id` int(11) primary key AUTO_INCREMENT,
`name` varchar(100) NOT NULL,
`description` varchar(200) DEFAULT NULL);
INSERT INTO `t_department` VALUES (1, '第一开发部', 'dept01');
INSERT INTO `t_department` VALUES (2, '第二开发部', 'dept02');
INSERT INTO `t_department` VALUES (3, '第三开发部', 'dept03');
INSERT INTO `t_department` VALUES (4, '系统部', 'dept04');
INSERT INTO `t_department` VALUES (5, '管理部', 'dept05');

CREATE TABLE `t_person`  (
  `id` int(11) PRIMARY KEY AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `image` varchar(50) NOT NULL,
  `thumb_image` varchar(50) NOT NULL);
INSERT INTO `t_person` VALUES (1, '宋江', 'static/lucky/thumb/001.jpg', 'static/lucky/thumb/001.jpg');
INSERT INTO `t_person` VALUES (2, '卢俊义', 'static/lucky/thumb/002.jpg', 'static/lucky/thumb/002.jpg');
INSERT INTO `t_person` VALUES (3, '吴用', 'static/lucky/thumb/003.jpg', 'static/lucky/thumb/003.jpg');
INSERT INTO `t_person` VALUES (4, '公孙胜', 'static/lucky/thumb/004.jpg', 'static/lucky/thumb/004.jpg');
INSERT INTO `t_person` VALUES (5, '关胜', 'static/lucky/thumb/005.jpg', 'static/lucky/thumb/005.jpg');
INSERT INTO `t_person` VALUES (6, '林冲', 'static/lucky/thumb/006.jpg', 'static/lucky/thumb/006.jpg');
INSERT INTO `t_person` VALUES (7, '秦明', 'static/lucky/thumb/007.jpg', 'static/lucky/thumb/007.jpg');
INSERT INTO `t_person` VALUES (8, '呼延灼', 'static/lucky/thumb/008.jpg', 'static/lucky/thumb/008.jpg');
INSERT INTO `t_person` VALUES (9, '花荣', 'static/lucky/thumb/009.jpg', 'static/lucky/thumb/009.jpg');
INSERT INTO `t_person` VALUES (10, '柴进', 'static/lucky/thumb/010.jpg', 'static/lucky/thumb/010.jpg');
INSERT INTO `t_person` VALUES (11, '李应', 'static/lucky/thumb/011.jpg', 'static/lucky/thumb/011.jpg');
INSERT INTO `t_person` VALUES (12, '朱仝', 'static/lucky/thumb/012.jpg', 'static/lucky/thumb/012.jpg');
INSERT INTO `t_person` VALUES (13, '鲁智深', 'static/lucky/thumb/013.jpg', 'static/lucky/thumb/013.jpg');
INSERT INTO `t_person` VALUES (14, '武松', 'static/lucky/thumb/014.jpg', 'static/lucky/thumb/014.jpg');
INSERT INTO `t_person` VALUES (15, '董平', 'static/lucky/thumb/015.jpg', 'static/lucky/thumb/015.jpg');
INSERT INTO `t_person` VALUES (16, '张清', 'static/lucky/thumb/016.jpg', 'static/lucky/thumb/016.jpg');
INSERT INTO `t_person` VALUES (17, '杨志', 'static/lucky/thumb/017.jpg', 'static/lucky/thumb/017.jpg');
INSERT INTO `t_person` VALUES (18, '徐宁', 'static/lucky/thumb/018.jpg', 'static/lucky/thumb/018.jpg');
INSERT INTO `t_person` VALUES (19, '索超', 'static/lucky/thumb/019.jpg', 'static/lucky/thumb/019.jpg');
INSERT INTO `t_person` VALUES (20, '戴宗', 'static/lucky/thumb/020.jpg', 'static/lucky/thumb/020.jpg');
INSERT INTO `t_person` VALUES (21, '刘唐', 'static/lucky/thumb/021.jpg', 'static/lucky/thumb/021.jpg');
INSERT INTO `t_person` VALUES (22, '李逵', 'static/lucky/thumb/022.jpg', 'static/lucky/thumb/022.jpg');
INSERT INTO `t_person` VALUES (23, '史进', 'static/lucky/thumb/023.jpg', 'static/lucky/thumb/023.jpg');
INSERT INTO `t_person` VALUES (24, '穆弘', 'static/lucky/thumb/024.jpg', 'static/lucky/thumb/024.jpg');
INSERT INTO `t_person` VALUES (25, '雷横', 'static/lucky/thumb/025.jpg', 'static/lucky/thumb/025.jpg');
INSERT INTO `t_person` VALUES (26, '李俊', 'static/lucky/thumb/026.jpg', 'static/lucky/thumb/026.jpg');
INSERT INTO `t_person` VALUES (27, '阮小二', 'static/lucky/thumb/027.jpg', 'static/lucky/thumb/027.jpg');
INSERT INTO `t_person` VALUES (28, '张横', 'static/lucky/thumb/028.jpg', 'static/lucky/thumb/028.jpg');
INSERT INTO `t_person` VALUES (29, '阮小五', 'static/lucky/thumb/029.jpg', 'static/lucky/thumb/029.jpg');
INSERT INTO `t_person` VALUES (30, '张顺', 'static/lucky/thumb/030.jpg', 'static/lucky/thumb/030.jpg');
INSERT INTO `t_person` VALUES (31, '阮小七', 'static/lucky/thumb/031.jpg', 'static/lucky/thumb/031.jpg');
INSERT INTO `t_person` VALUES (32, '杨雄', 'static/lucky/thumb/032.jpg', 'static/lucky/thumb/032.jpg');
INSERT INTO `t_person` VALUES (33, '石秀', 'static/lucky/thumb/033.jpg', 'static/lucky/thumb/033.jpg');
INSERT INTO `t_person` VALUES (34, '解珍', 'static/lucky/thumb/034.jpg', 'static/lucky/thumb/034.jpg');
INSERT INTO `t_person` VALUES (35, '解宝', 'static/lucky/thumb/035.jpg', 'static/lucky/thumb/035.jpg');
INSERT INTO `t_person` VALUES (36, '燕青', 'static/lucky/thumb/036.jpg', 'static/lucky/thumb/036.jpg');
INSERT INTO `t_person` VALUES (37, '朱武', 'static/lucky/thumb/037.jpg', 'static/lucky/thumb/037.jpg');
INSERT INTO `t_person` VALUES (38, '黄信', 'static/lucky/thumb/038.jpg', 'static/lucky/thumb/038.jpg');
INSERT INTO `t_person` VALUES (39, '孙立', 'static/lucky/thumb/039.jpg', 'static/lucky/thumb/039.jpg');
INSERT INTO `t_person` VALUES (40, '宣赞', 'static/lucky/thumb/040.jpg', 'static/lucky/thumb/040.jpg');
INSERT INTO `t_person` VALUES (41, '郝思文', 'static/lucky/thumb/041.jpg', 'static/lucky/thumb/041.jpg');
INSERT INTO `t_person` VALUES (42, '韩滔', 'static/lucky/thumb/042.jpg', 'static/lucky/thumb/042.jpg');
INSERT INTO `t_person` VALUES (43, '彭玘', 'static/lucky/thumb/043.jpg', 'static/lucky/thumb/043.jpg');
INSERT INTO `t_person` VALUES (44, '单廷珪', 'static/lucky/thumb/044.jpg', 'static/lucky/thumb/044.jpg');
INSERT INTO `t_person` VALUES (45, '魏定国', 'static/lucky/thumb/045.jpg', 'static/lucky/thumb/045.jpg');
INSERT INTO `t_person` VALUES (46, '萧让', 'static/lucky/thumb/046.jpg', 'static/lucky/thumb/046.jpg');
INSERT INTO `t_person` VALUES (47, '裴宣', 'static/lucky/thumb/047.jpg', 'static/lucky/thumb/047.jpg');
INSERT INTO `t_person` VALUES (48, '欧鹏', 'static/lucky/thumb/048.jpg', 'static/lucky/thumb/048.jpg');
INSERT INTO `t_person` VALUES (49, '邓飞', 'static/lucky/thumb/049.jpg', 'static/lucky/thumb/049.jpg');
INSERT INTO `t_person` VALUES (50, '燕顺', 'static/lucky/thumb/050.jpg', 'static/lucky/thumb/050.jpg');
INSERT INTO `t_person` VALUES (51, '杨林', 'static/lucky/thumb/051.jpg', 'static/lucky/thumb/051.jpg');
INSERT INTO `t_person` VALUES (52, '凌振', 'static/lucky/thumb/052.jpg', 'static/lucky/thumb/052.jpg');
INSERT INTO `t_person` VALUES (53, '蒋敬', 'static/lucky/thumb/053.jpg', 'static/lucky/thumb/053.jpg');
INSERT INTO `t_person` VALUES (54, '吕方', 'static/lucky/thumb/054.jpg', 'static/lucky/thumb/054.jpg');
INSERT INTO `t_person` VALUES (55, '郭盛', 'static/lucky/thumb/055.jpg', 'static/lucky/thumb/055.jpg');
INSERT INTO `t_person` VALUES (56, '安道全', 'static/lucky/thumb/056.jpg', 'static/lucky/thumb/056.jpg');
INSERT INTO `t_person` VALUES (57, '皇甫端', 'static/lucky/thumb/057.jpg', 'static/lucky/thumb/057.jpg');
INSERT INTO `t_person` VALUES (58, '王英', 'static/lucky/thumb/058.jpg', 'static/lucky/thumb/058.jpg');
INSERT INTO `t_person` VALUES (59, '扈三娘', 'static/lucky/thumb/059.jpg', 'static/lucky/thumb/059.jpg');
INSERT INTO `t_person` VALUES (60, '鲍旭', 'static/lucky/thumb/060.jpg', 'static/lucky/thumb/060.jpg');
INSERT INTO `t_person` VALUES (61, '樊瑞', 'static/lucky/thumb/061.jpg', 'static/lucky/thumb/061.jpg');
INSERT INTO `t_person` VALUES (62, '孔明', 'static/lucky/thumb/062.jpg', 'static/lucky/thumb/062.jpg');
INSERT INTO `t_person` VALUES (63, '孔亮', 'static/lucky/thumb/063.jpg', 'static/lucky/thumb/063.jpg');
INSERT INTO `t_person` VALUES (64, '项充', 'static/lucky/thumb/064.jpg', 'static/lucky/thumb/064.jpg');
INSERT INTO `t_person` VALUES (65, '李衮', 'static/lucky/thumb/065.jpg', 'static/lucky/thumb/065.jpg');
INSERT INTO `t_person` VALUES (66, '金大坚', 'static/lucky/thumb/066.jpg', 'static/lucky/thumb/066.jpg');
INSERT INTO `t_person` VALUES (67, '马麟', 'static/lucky/thumb/067.jpg', 'static/lucky/thumb/067.jpg');
INSERT INTO `t_person` VALUES (68, '童威', 'static/lucky/thumb/068.jpg', 'static/lucky/thumb/068.jpg');
INSERT INTO `t_person` VALUES (69, '童猛', 'static/lucky/thumb/069.jpg', 'static/lucky/thumb/069.jpg');
INSERT INTO `t_person` VALUES (70, '孟康', 'static/lucky/thumb/070.jpg', 'static/lucky/thumb/070.jpg');
INSERT INTO `t_person` VALUES (71, '侯健', 'static/lucky/thumb/071.jpg', 'static/lucky/thumb/071.jpg');
INSERT INTO `t_person` VALUES (72, '陈达', 'static/lucky/thumb/072.jpg', 'static/lucky/thumb/072.jpg');
INSERT INTO `t_person` VALUES (73, '杨春', 'static/lucky/thumb/073.jpg', 'static/lucky/thumb/073.jpg');
INSERT INTO `t_person` VALUES (74, '郑天寿', 'static/lucky/thumb/074.jpg', 'static/lucky/thumb/074.jpg');
INSERT INTO `t_person` VALUES (75, '陶宗旺', 'static/lucky/thumb/075.jpg', 'static/lucky/thumb/075.jpg');
INSERT INTO `t_person` VALUES (76, '宋清', 'static/lucky/thumb/076.jpg', 'static/lucky/thumb/076.jpg');
INSERT INTO `t_person` VALUES (77, '乐和', 'static/lucky/thumb/077.jpg', 'static/lucky/thumb/077.jpg');
INSERT INTO `t_person` VALUES (78, '龚旺', 'static/lucky/thumb/078.jpg', 'static/lucky/thumb/078.jpg');
INSERT INTO `t_person` VALUES (79, '丁得孙', 'static/lucky/thumb/079.jpg', 'static/lucky/thumb/079.jpg');
INSERT INTO `t_person` VALUES (80, '穆春', 'static/lucky/thumb/080.jpg', 'static/lucky/thumb/080.jpg');
INSERT INTO `t_person` VALUES (81, '曹正', 'static/lucky/thumb/081.jpg', 'static/lucky/thumb/081.jpg');
INSERT INTO `t_person` VALUES (82, '宋万', 'static/lucky/thumb/082.jpg', 'static/lucky/thumb/082.jpg');
INSERT INTO `t_person` VALUES (83, '杜迁', 'static/lucky/thumb/083.jpg', 'static/lucky/thumb/083.jpg');
INSERT INTO `t_person` VALUES (84, '薛永', 'static/lucky/thumb/084.jpg', 'static/lucky/thumb/084.jpg');
INSERT INTO `t_person` VALUES (85, '施恩', 'static/lucky/thumb/085.jpg', 'static/lucky/thumb/085.jpg');
INSERT INTO `t_person` VALUES (86, '李忠', 'static/lucky/thumb/086.jpg', 'static/lucky/thumb/086.jpg');
INSERT INTO `t_person` VALUES (87, '周通', 'static/lucky/thumb/087.jpg', 'static/lucky/thumb/087.jpg');
INSERT INTO `t_person` VALUES (88, '汤隆', 'static/lucky/thumb/088.jpg', 'static/lucky/thumb/088.jpg');
INSERT INTO `t_person` VALUES (89, '杜兴', 'static/lucky/thumb/089.jpg', 'static/lucky/thumb/089.jpg');
INSERT INTO `t_person` VALUES (90, '邹渊', 'static/lucky/thumb/090.jpg', 'static/lucky/thumb/090.jpg');
INSERT INTO `t_person` VALUES (91, '邹润', 'static/lucky/thumb/091.jpg', 'static/lucky/thumb/091.jpg');
INSERT INTO `t_person` VALUES (92, '朱贵', 'static/lucky/thumb/092.jpg', 'static/lucky/thumb/092.jpg');
INSERT INTO `t_person` VALUES (93, '朱富', 'static/lucky/thumb/093.jpg', 'static/lucky/thumb/093.jpg');
INSERT INTO `t_person` VALUES (94, '蔡福', 'static/lucky/thumb/094.jpg', 'static/lucky/thumb/094.jpg');
INSERT INTO `t_person` VALUES (95, '蔡庆', 'static/lucky/thumb/095.jpg', 'static/lucky/thumb/095.jpg');
INSERT INTO `t_person` VALUES (96, '李立', 'static/lucky/thumb/096.jpg', 'static/lucky/thumb/096.jpg');
INSERT INTO `t_person` VALUES (97, '李云', 'static/lucky/thumb/097.jpg', 'static/lucky/thumb/097.jpg');
INSERT INTO `t_person` VALUES (98, '焦挺', 'static/lucky/thumb/098.jpg', 'static/lucky/thumb/098.jpg');
INSERT INTO `t_person` VALUES (99, '石勇', 'static/lucky/thumb/099.jpg', 'static/lucky/thumb/099.jpg');
INSERT INTO `t_person` VALUES (100, '孙新', 'static/lucky/thumb/100.jpg', 'static/lucky/thumb/100.jpg');
INSERT INTO `t_person` VALUES (101, '顾大嫂', 'static/lucky/thumb/101.jpg', 'static/lucky/thumb/101.jpg');
INSERT INTO `t_person` VALUES (102, '张青', 'static/lucky/thumb/102.jpg', 'static/lucky/thumb/102.jpg');
INSERT INTO `t_person` VALUES (103, '孙二娘', 'static/lucky/thumb/103.jpg', 'static/lucky/thumb/103.jpg');
INSERT INTO `t_person` VALUES (104, '王定六', 'static/lucky/thumb/104.jpg', 'static/lucky/thumb/104.jpg');
INSERT INTO `t_person` VALUES (105, '郁保四', 'static/lucky/thumb/105.jpg', 'static/lucky/thumb/105.jpg');
INSERT INTO `t_person` VALUES (106, '白胜', 'static/lucky/thumb/106.jpg', 'static/lucky/thumb/106.jpg');
INSERT INTO `t_person` VALUES (107, '时迁', 'static/lucky/thumb/107.jpg', 'static/lucky/thumb/107.jpg');
INSERT INTO `t_person` VALUES (108, '段景住', 'static/lucky/thumb/108.jpg', 'static/lucky/thumb/108.jpg');


# 安装 MySQL 8.0
################################################################################
yum install mysql-server

# 启动配置
systemctl start mysqld 

# 为MySQL根用户生成一个临时密码
grep 'temporary password' /var/log/mysqld.log

# 初始化
mysql_secure_installation

# 必须先创建用户
create user cloud@'%' identified by 'Sinocom11#';
ALTER USER 'cloud'@'%' IDENTIFIED WITH mysql_native_password BY 'Sinocom11#';

# 创建数据库
create database mydb default character set utf8 collate utf8_bin;

# 再进行赋值：
grant all privileges on mydb.* to cloud@'%' with grant option;

# 刷新一下
flush privileges;

use mydb
create table t_employee 
(id int primary key auto_increment, 
name varchar(50) not null, 
address varchar(100) not null,
age int not null);
insert into t_employee values(NULL, 'zhangsan', 'jilin', 23);
insert into t_employee values(NULL, 'lisi', 'beijing', 25);
insert into t_employee values(NULL, 'wangwu', 'shanghai', 24);
