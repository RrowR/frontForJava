drop table if exists student;
create table student (
    id int primary key auto_increment,
    name varchar(32) not null,
    sex char(1),
    age tinyint
);

drop table if exists user_role;
drop table if exists role_menu;
drop table if exists role_func;
drop table if exists menu;
drop table if exists func;
drop table if exists role;
drop table if exists user;

create table user (
    id int primary key auto_increment,
    username varchar(16) unique not null,
    password varchar(64) ,
    name varchar(16),
    avatar varchar(128),
    introduction varchar(64),
    `key` char(36)
);

create table role (
    id int primary key auto_increment,
    name varchar(16) not null
);

create table menu (
    id int primary key auto_increment,
    name varchar(16) not null,
    icon varchar(32),
    path varchar(64),
    pid int not null,
    component varchar(64)
);

create table func (
    id int primary key auto_increment,
    name varchar(16) not null
);

create table user_role (
    user_id int,
    role_id int,
    foreign key (user_id) references user(id),
    foreign key (role_id) references role(id)
);

create table role_menu (
    role_id int,
    menu_id int,
    foreign key (role_id) references role(id),
    foreign key (menu_id) references menu(id)
);

create table role_func (
    role_id int,
    func_id int,
    foreign key (role_id) references role(id),
    foreign key (func_id) references func(id)
);

