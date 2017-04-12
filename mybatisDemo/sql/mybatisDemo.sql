drop database if exists mybatisDemo;
create database if not exists mybatisDemo;

use mybatisDemo;
drop table if exists user;
create table if not exists user(uid int primary key,uname varchar(20),age tinyint);

insert into user value (1,'wjh',25);

drop table if exists teacher;
create table if not exists teacher(id int primary key auto_increment,tid varchar(20),tname varchar(20));
insert into teacher value(1,'3(6)班','wjh');

drop table if exists classes;
-- cid 班级 cname班级学生姓名
create table if not exists classes(id int primary key auto_increment,cid varchar(20),cname varchar(20));
insert into classes value(1,'3(6)班','魏金海');