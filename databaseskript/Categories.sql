create database if not exists MytestDB;
use MytestDB;
create table Categories (
        Id              integer UNIQUE auto_increment,
        Name              varchar(255) not null,
        ImagePath         varchar(255) not null,
        CONSTRAINT PRIMARY KEY (Id)
);

select * from Categories;