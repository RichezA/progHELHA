--creation
PRAGMA foreign_keys
= ON;

CREATE TABLE User
(
    userID INT NOT NULL,
    name varchar(255) DEFAULT NULL,
    surname varchar(255) DEFAULT NULL,
    PRIMARY KEY(userID)
);

CREATE TABLE Poll
(
    pollID INT NOT NULL,
    name varchar(255) DEFAULT NULL,
    description TEXT DEFAULT NULL,
    createDate DATETIME DEFAULT NULL,
    userID INT NOT NULL,
    PRIMARY KEY(pollID),
    CONSTRAINT userIDVersUser FOREIGN KEY (userID) REFERENCES User (userID)
);

CREATE TABLE Entry
(
    entryID INT NOT NULL,
    pollID INT NOT NULL,
    choiceDateT DATETIME DEFAULT NULL,
    PRIMARY KEY(entryID),
    CONSTRAINT uniquePoll UNIQUE (pollID, choiceDateT),
    CONSTRAINT pollIDVersPoll FOREIGN KEY (pollID) REFERENCES Poll(pollID)
);

CREATE TABLE Answer
(
    userID INT NOT NULL,
    entryID INT NOT NULL,
    userAnsw VARCHAR(255) DEFAULT NULL,
    CONSTRAINT userIDVersUser FOREIGN KEY (userID) REFERENCES User(userID),
    CONSTRAINT entryIDVersEntry FOREIGN KEY (entryID) REFERENCES Entry(entryID)
);

CREATE TABLE Groupe
(
    groupID INT NOT NULL,
    name varchar(255) DEFAULT NULL,
    PRIMARY KEY(groupID)
);

CREATE TABLE Groups
(
    pollID INT NOT NULL,
    groupID INT NOT NULL,
    PRIMARY KEY (groupID,pollID)
    CONSTRAINT pollIDVersPoll FOREIGN KEY
    (pollID) REFERENCES Poll
    (pollID)
  	CONSTRAINT groupIDVersGroupe FOREIGN KEY
    (groupID) REFERENCES Groupe
    (groupID)
);

    CREATE TABLE Role
    (
        groupID INT NOT NULL,
        userID INT NOT NULL,
        name varchar(255) DEFAULT NULL,
        PRIMARY KEY(groupID,userID),
        CONSTRAINT groupIDVersGroupe FOREIGN KEY (groupID) REFERENCES Groupe(groupID),
        CONSTRAINT userIDVersUser FOREIGN KEY (userID) REFERENCES User(userID)
    );
    --filling

    INSERT INTO Poll
        (pollID,name,description,createDate,userID)
    VALUES
        (1, "Date pour le barbecue", "Maim maim", "2018-11-01 10:02:00.000", 1);

    INSERT INTO Entry
        (entryID, pollID, choiceDateT)
    VALUES
        (1, 1, "2018-11-01 20:00:00.000"),
        (2, 1, "2018-11-05 18:00:00.000"),
        (3, 1, "2018-11-08 20:00:00.000");

    INSERT INTO Answer
        (userID, entryID, userAnsw)
    VALUES
        (2, 1, "Présent"),
        (2, 2, "Absent"),
        (1, 1, "Présent"),
        (1, 2, "Présent"),
        (1, 3, "Présent");
    INSERT INTO Poll
        (pollID, name, description, createDate, userID)
    VALUES
        (2, "La fête ?", "Allez les gars", "2018-11-03 22:10:00.000", 3);
    INSERT INTO Groups
        (pollID, groupID)
    VALUES
        (1, 1),
        (2, 2);
    INSERT INTO Entry
        (entryID, pollID, choiceDateT)
    VALUES
        (4, 2, "2018-11-10 21:00:00.000"),
        (5, 2, "2018-11-11 21:00:00.000"),
        (6, 2, "2018-11-12 21:00:00.000");
    INSERT INTO Answer
        (userID, entryID, userAnsw)
    VALUES
        (3, 4, "Présent"),
        (3, 5, "Présent"),
        (3, 6, "Présent"),
        (1, 5, "Absent");


    --update
    UPDATE Poll
set
	description = "Miam miam"
WHERE
	pollID = 1;

    --select
    SELECT *
    FROM Answer INNER JOIN
        (SELECT *
        FROM Entry NATURAL JOIN Poll 
        WHERE pollID = (SELECT pollID
        FROM Groups
        WHERE groupID = (SELECT groupID
        from Groupe
        WHERE name = "Profs"))) AS Guys
        ON Answer.entryID = Guys.entryID
    WHERE userAnsw = "Présent"
    GROUP BY Answer.entryID
    HAVING Count(userAnsw) >= 1;

    SELECT COUNT(guys.userID) as Nombre, *
    FROM Answer INNER JOIN
        (SELECT *
        FROM Entry NATURAL JOIN Poll 
        WHERE pollID IN (SELECT pollID
        FROM Groups
        WHERE groupID = (SELECT groupID
        from Groupe
        WHERE name = "Profs"))) AS Guys
        ON Answer.entryID = Guys.entryID
    WHERE userAnsw = "Présent"
    GROUP BY Answer.entryID
    ORDER BY Nombre DESC