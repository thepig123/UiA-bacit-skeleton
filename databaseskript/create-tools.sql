create database if not exists MytestDB;
use MytestDB;
create table if not EXISTS tools
(
    Item_ID       integer UNIQUE auto_increment,
    Availability  boolean,
    Tool_name     varchar(255),
    Price_firstDay varchar(255),
    Price_followingDays varchar (255),
    Tool_info     varchar(1000),
    Tool_type     varchar(255)


);

insert into tools (Tool_name,
                   Availability,
                   Tool_info,
                   Price_firstDay,
                   Price_followingDays,
                   Tool_type
                  )
values ('Leilighet på Hovden',
        True,
        'Kontakt resepsjonen hos AMV',
        'Egne regler',
        'Egne regler',
        'Større utstyr'
        );


    delete from tools where Item_ID = 29;

select * from tools;

SELECT * FROM tools
Order BY Item_ID
LIMIT 5;
