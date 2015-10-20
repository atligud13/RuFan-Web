
drop table users

create table users (
  id int Identity (1, 1) primary key NOT NULL,
  name varchar(128),
  username varchar(32) unique,
  email varchar(128),
  password varchar(128)
)

select * from users