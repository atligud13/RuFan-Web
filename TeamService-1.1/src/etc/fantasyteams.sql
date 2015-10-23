drop table fantasyteams;
create table fantasyteams
(
  id int primary key NOT NULL IDENTITY ,
  userid int NOT NULL,
  tournamentid int,
  gkid int,
  d1id int,
  d2id int,
  d3id int,
  d4id int,
  m1id int,
  m2id int,
  m3id int,
  m4id int,
  f1id int,
  f2id int
);
