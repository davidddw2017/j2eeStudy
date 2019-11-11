# 安装oracle
################################################################################

# 创建tnsnames.ora
cat << EOF >> /u01/app/oracle/product/19.3.0/dbhome_1/network/admin/tnsnames.ora
#cdb
ccdb =
  (DESCRIPTION =
    (ADDRESS_LIST =
      (ADDRESS = (PROTOCOL = TCP)(HOST = localhost)(PORT = 1521))
    )
    (CONNECT_DATA =
      (SERVICE = DEDICATED)
      (SERVICE_NAME = ccdb)
    )
  )
#pdb
ccdbpdb =
  (DESCRIPTION =
    (ADDRESS_LIST =
      (ADDRESS = (PROTOCOL = TCP)(HOST = localhost)(PORT = 1521))
    )
    (CONNECT_DATA =
      (SERVICE = DEDICATED)
      (SERVICE_NAME = CCDBPDB1)
    )
  )
EOF

# 查询cdb状态
col name for a30;
select con_id, name, open_mode from v$pdbs;

# 创建本地账户
alter session set container = CCDBPDB1;
select file_name from dba_data_files;

# 创建临时表空间
create temporary tablespace test_temp
    tempfile '/u01/app/oracle/oradata/CCDB/CCDBPDB1/test_temp.dbf'
    size 64m
    autoextend on next 64m maxsize unlimited;

# 创建表空间
create tablespace test_data
    logging
    datafile '/u01/app/oracle/oradata/CCDB/CCDBPDB1/test_data.dbf'
    size 64m
    autoextend on next 64m maxsize unlimited
    extent management local
    uniform size 128k
    segment space management auto;

# 创建用户并指定表空间
create user cloud
    identified by passwd
    default tablespace test_data
    temporary tablespace test_temp;

# 给用户授予权限
grant connect,resource,
    create session,
    create table,
    create view to cloud;
ALTER USER cloud QUOTA UNLIMITED ON test_data;

# 创建数据表
conn cloud/passwd@ccdbpdb

create sequence t_user_id_seq increment by 1 start with 1 maxvalue 9999999999 cycle;
create table t_employee 
(id number(11) primary key, 
name varchar2(50) not null, 
address varchar2(100) not null,
age number(11) not null);

create or replace trigger t_user_trigger 
before insert on t_employee
for each row
when(new.id is null)
begin
  select t_user_id_seq.nextval into:NEW.ID from dual;
end;
/

insert into t_employee values(NULL,'zhangsan', 'jilin', 23);
insert into t_employee values(NULL,'lisi', 'beijing', 25);
insert into t_employee values(NULL,'wangwu', 'shanghai', 24);
commit;

################################################################################
# 创建临时表空间
create temporary tablespace test_temp
    tempfile '/u01/app/oracle/oradata/JLZM/test_temp.dbf'
    size 64m
    autoextend on next 64m maxsize unlimited;

# 创建表空间
create tablespace test_data
    logging
    datafile '/u01/app/oracle/oradata/JLZM/test_data.dbf'
    size 64m
    autoextend on next 64m maxsize unlimited
    extent management local
    uniform size 128k
    segment space management auto;

# 创建用户并指定表空间
create user cloud
    identified by passwd
    default tablespace test_data
    temporary tablespace test_temp;

# 给用户授予权限
grant connect,resource,
    create session,
    create table,
    create view to cloud;
ALTER USER cloud QUOTA UNLIMITED ON test_data;



