create database if not exists MytestDB;
use MytestDB;
create table Files(
        Id              integer UNIQUE auto_increment,
        Name            varchar(255) not null,
        Content         LONGBLOB not null,
        ContentType varchar(255) not null,
        CONSTRAINT PRIMARY KEY (Id)
);

select *
from Files;