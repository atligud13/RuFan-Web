drop table tournamentresults;
create table tournamentresults
(
  id int primary key NOT NULL IDENTITY ,
  fantasyteamid int NOT NULL,
  score int NOT NULL
);