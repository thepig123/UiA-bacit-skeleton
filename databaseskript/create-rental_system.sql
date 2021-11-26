create database if not exists MytestDB;
use MytestDB;
create table if not EXISTS rental_system
(
    Rental_ID integer UNIQUE auto_increment,
    User_ID int not null,
    Item_ID int not null,
    Availability boolean,
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
                           Rental_endDate,
                           Availability)
values (1,
        29,
        'Ingen skade',
        '2021-10-15',
        '2021-10-22',
        FALSE);


UPDATE tools
SET Availability = false
Where Item_ID = 8;



SELECT * FROM rental_system;

SELECT User_ID, COUNT('Antall')
FROM rental_system
GROUP BY User_ID
ORDER BY COUNT(*) DESC
LIMIT 3;


SELECT * FROM rental_system where Rental_endDate < CURRENT_DATE;

SELECT * FROM rental_system
ORDER BY Rental_ID
LIMIT 5;


SELECT Item_ID, Rental_endDate, Rental_startDate
From rental_system
WHERE User_ID = 1
Order by Rental_startDate, Rental_endDate;