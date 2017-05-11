drop table if exists t_class;
drop table if exists t_user;

create table t_class (id int primary key auto_increment,user_no int,class_name varchar(20));

create table t_user (id int primary key auto_increment,class_id int,user_no int,user_name varchar(20),user_age INT);