
drop table users

create table users (
  id int Identity (1, 1) primary key NOT NULL,
  name varchar(128),
  username varchar(32) unique,
  email varchar(128),
  password varchar(128),
  favoriteteamid int,
  creditcardnumber varchar(128),
  creditcardtype varchar(32),
  creditcardexpirationyear int,
  creditcardexpirationmonth int
)

select * from users