drop table positions

create table positions
(
  positionid int primary key NOT NULL,
  name varchar(128),
  abbreviation varchar(8)
)

INSERT INTO positions (positionid, name, abbreviation)
VALUES (1, 'Goalkeeper', 'GK');
INSERT INTO positions (positionid, name, abbreviation)
VALUES (2, 'Forward', 'F');
INSERT INTO positions (positionid, name, abbreviation)
VALUES (3, 'Midfielder', 'M');
INSERT INTO positions (positionid, name, abbreviation)
VALUES (4, 'Defender', 'D');