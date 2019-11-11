# 安装SQL server
################################################################################
yum install mssql-server

# 破解 2G内存限制
cd /opt/mssql/bin/
mv sqlservr sqlservr.old
python
>>>oldfile = open("sqlservr.old", "rb").read()
>>>newfile = oldfile.replace("\xff\x93\x35\x77", "\x00\x80\x84\x1e")
>>>open("sqlservr", "wb").write(newfile)
>>>exit()

chmod +x /opt/mssql/bin/sqlservr

# 运行 mssql-conf setup 命令并按提示设置 SA 密码
/opt/mssql/bin/mssql-conf setup

# 查看运行状态
systemctl status mssql-server

# 安装Sqlserver命令行工具
yum install mssql-tools

# 将 /opt/mssql-tools/bin/ 添加到 PATH 环境变量
echo 'export PATH="$PATH:/opt/mssql-tools/bin"' >> ~/.bashrc
source ~/.bashrc

# 查看sqlcmd指令是否可用
sqlcmd -S localhost -U SA

# 创建表
create database mydb
go
use mydb
go
create table t_employee 
(id int primary key identity(1,1), 
	name varchar(50) not null, 
	address varchar(100) not null,
	age int not null)
go
insert into t_employee values('zhangsan', 'jilin', 23);
insert into t_employee values('lisi', 'beijing', 25);
insert into t_employee values('wangwu', 'shanghai', 24);
go
select * from t_employee
go

