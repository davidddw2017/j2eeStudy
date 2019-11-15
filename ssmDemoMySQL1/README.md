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
