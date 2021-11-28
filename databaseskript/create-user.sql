create database if not exists MytestDB;
use MytestDB;
create table if not EXISTS user (
    User_ID        integer UNIQUE auto_increment,
    User_firstName varchar(255),
    User_lastName  varchar(255),
    User_Email     varchar(255) UNIQUE,
    User_password  varchar(255),
    User_PhoneNumber int,
    CONSTRAINT U_User_ID_PK PRIMARY KEY (User_ID)
);

/* spørr om hjelp angående user_admin */

insert into user (User_firstName,
                  User_lastName,
                  User_Email,
                  User_password,
                  User_PhoneNumber )
values ('Knut Einar',
        'Skår',
        'KnutEinar@example.com',
        '12345',
         97652106 );

SELECT * FROM user;


SELECT * FROM user
Order BY User_ID
LIMIT 5;


select User_firstName, Rental_ID, User_lastName from rental_system inner join user u on rental_system.User_ID = u.User_ID where u.User_ID=2;


