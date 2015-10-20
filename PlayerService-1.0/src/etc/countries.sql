drop table countries

create table countries
(
  countryid int primary key NOT NULL,
  name varchar(128),
  abbreviation varchar(8),
)
