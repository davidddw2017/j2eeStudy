# 安装postgresql
################################################################################
yum install postgresql postgresql-server

# 使用命令initdb生成数据库
postgresql-setup initdb

# 下面需要先对服务配置文件postgresql.conf进行一些设置：
sed -i "s/#listen_addresses = 'localhost'/listen_addresses = '*'/g" /var/lib/pgsql/data/postgresql.conf
sed -i 's/#port = 5432/port = 5432/g' /var/lib/pgsql/data/postgresql.conf
sed -i 's/#password_encryption = on/password_encryption = on/g' /var/lib/pgsql/data/postgresql.conf

# 再对pg_hba.conf内容进行配置, 将上面红框内的ident改为md5,然后再在最下面加入 host all all 0.0.0.0/0 md5
cat <<'EOF' >> /var/lib/pgsql/data/pg_hba.conf
host    all             all             0.0.0.0/0               md5
EOF

# 启动服务
systemctl start postgresql 

# 修改postgres用户密码，切换到postgres用户
echo sinocom11# | passwd --stdin postgres

# 修改登录PostgreSQL密码
ALTER USER postgres WITH PASSWORD 'pass123';

# 列出当前的数据库
\l

# 重启postgresql服务，使配置文件重效
systemctl restart postgresql

# 接下来我们创建一个数据库
sudo -u postgres psql
CREATE USER cloud CREATEDB LOGIN PASSWORD 'passwd';
CREATE USER cloud WITH PASSWORD 'passwd';
CREATE DATABASE mydb;
GRANT ALL ON DATABASE mydb TO cloud;

# 尝试用postgres登录数据库
psql -U cloud -h 192.168.1.98 -p 5432 -d mydb -W

sudo -u postgres psql -U postgres -h 127.0.0.1 -p 5432 -d testdb -W

create table t_employee 
(id SERIAL primary key, 
name varchar(50) not null, 
address varchar(100) not null,
age int not null);
insert into t_employee values(DEFAULT, 'zhangsan', 'jilin', 23);
insert into t_employee values(DEFAULT, 'lisi', 'beijing', 25);
insert into t_employee values(DEFAULT, 'wangwu', 'shanghai', 24);

select * from t_employee;
