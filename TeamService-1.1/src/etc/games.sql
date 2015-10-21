drop table games
create table games
(
  gameid int primary key NOT NULL,
  hometeamid int NOT NULL,
  awayteamid int NOT NULL,
  venueid int NOT NULL,
  startdate datetime
)
