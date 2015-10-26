drop table tournaments;
create table tournaments
(
  id int primary key NOT NULL IDENTITY ,
  name varchar(80),
  active bit,
  startdate datetime,
  enddate datetime,
  entryfee int,
  maxentries int,
  leaguename varchar(80),
  prize int,
  winnerselected bit
);