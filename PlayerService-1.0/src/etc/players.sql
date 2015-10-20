drop table players

create table players
(
  playerid int primary key NOT NULL,
  firstname varchar(40),
  lastname varchar(40),
  height int,
  weight int,
  birthdate datetime,
  countryid int,
  teamid int
)
