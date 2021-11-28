create database if not exists MytestDB;
use MytestDB;
create table if not EXISTS rental_system
(
    Rental_ID integer UNIQUE auto_increment,
    User_ID int not null,
    Item_ID int not null,
    Damage_report varchar(255),
    Rental_startDate  date not null,
    Rental_endDate  date not null,
    CONSTRAINT U_Rental_ID_PK PRIMARY KEY (Rental_ID),
    CONSTRAINT U_User_ID_FK FOREIGN KEY (User_ID) REFERENCES user(User_ID),
    CONSTRAINT U_Item_ID_FK FOREIGN KEY (Item_ID) REFERENCES tools(Item_ID)
    );

insert into rental_system (User_ID,
                           Item_ID,
                           Damage_report,
                           Rental_startDate,
                           Rental_endDate)
values (1,
        29,
        'Ingen skade',
        '2021-10-15',
        '2021-10-22');


drop table rental_system;
