DROP TABLE Personne;
DROP TABLE Groupe;
DROP TABLE RoleDansGroupe;
DROP TABLE Sondage;
DROP TABLE SondageParGroupe;
DROP TABLE Entree;
DROP TABLE Reponse;

PRAGMA foreign_keys = ON;

CREATE TABLE Personne
(
    id INTEGER PRIMARY KEY,
    nom VARCHAR(30) NOT NULL,
    prenom VARCHAR(30) NOT NULL
);

CREATE TABLE Groupe
(
    id INTEGER PRIMARY KEY,
    nom VARCHAR(30) NOT NULL
);

CREATE TABLE RoleDansGroupe
(
    idPersonne INTEGER NOT NULL REFERENCES Personne(id),
    idGroupe INTEGER NOT NULL REFERENCES Groupe(id),
    role VARCHAR(30) NOT NULL CHECK (role IN ('Administrateur', 'Utilisateur')),
    PRIMARY KEY (idPersonne, idGroupe)
);

CREATE TABLE Sondage
(
    id INTEGER PRIMARY KEY,
    dateCreation TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    nom VARCHAR(20) NOT NULL,
    description TEXT,
    idCreateur INTEGER NOT NULL REFERENCES Personne(id)
);

CREATE TABLE SondageParGroupe
(
    idSondage INTEGER NOT NULL REFERENCES Sondage(id),
    idGroupe INTEGER NOT NULL REFERENCES Groupe(id),
    PRIMARY KEY (idSondage, idGroupe)
);

CREATE TABLE Entree
(
    id INTEGER PRIMARY KEY,
    dateHeure TIMESTAMP NOT NULL,
    idSondage INTEGER NOT NULL REFERENCES Sondage(id)
);

CREATE TABLE Reponse
(
    idPersonne INTEGER NOT NULL REFERENCES Personne(id),
    idEntree INTEGER NOT NULL REFERENCES Entree(id),
    date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    reponse VARCHAR(20) NOT NULL CHECK (reponse IN ('Présent', 'Absent', 'Peut-être', 'Sans réponse')),
    PRIMARY KEY (idPersonne, idEntree)
);


INSERT INTO Personne
    (nom, prenom)
VALUES
    ('Pluquet', 'Frédéric');
INSERT INTO Groupe
    (nom)
VALUES
    ('Profs'),
    ('Anciens étudiants');
INSERT INTO RoleDansGroupe
VALUES
    (1, 1, 'Administrateur'),
    (1, 2, 'Utilisateur');

INSERT INTO Personne
    (nom, prenom)
VALUES
    ('Detaille', 'Alain');
INSERT INTO RoleDansGroupe
VALUES
    (2, 1, 'Utilisateur');

INSERT INTO Personne
    (nom, prenom)
VALUES
    ('Grochard', 'Hervé');
INSERT INTO RoleDansGroupe
VALUES
    (3, 2, 'Administrateur');

-- H.4
INSERT INTO Sondage
    (dateCreation, nom, description, idCreateur)
VALUES
    ('2018-11-01 10:02', "Date pour le barbecue", "Maim Maim", 1);
INSERT INTO SondageParGroupe
VALUES
    (1, 1);
INSERT INTO Entree
    (dateHeure, idSondage)
VALUES
    ('2018-11-01 20:00', 1),
    ('2018-11-05 18:00', 1),
    ('2018-11-08 20:00', 1);

-- H.5
UPDATE Sondage SET description = "Miam Miam" WHERE id = 1;

-- H.6
INSERT INTO Reponse
VALUES
    (2, 1, '2018-11-01 11:18', 'Présent');

-- H.7
INSERT INTO Reponse
VALUES
    (2, 2, '2018-11-01 11:18', 'Absent');

-- H.8
INSERT INTO Reponse
SELECT 1, Entree.id, '2018-11-01 11:26', 'Présent'
FROM Entree
WHERE idSondage = 1;

-- H.9
INSERT INTO Sondage
    (dateCreation, nom, description, idCreateur)
VALUES
    ('2018-11-3 22:10', "La fête ?", "Allez les gars", 3);
INSERT INTO SondageParGroupe
VALUES
    (2, 2);
INSERT INTO Entree
    (dateHeure, idSondage)
VALUES
    ('2018-11-10 21:00', 2),
    ('2018-11-11 21:00', 2),
    ('2018-11-12 21:00', 2);

-- H.10
INSERT INTO Reponse
SELECT 3, Entree.id, '2018-11-03 22:11', 'Présent'
FROM Entree
WHERE idSondage = 2;

-- H.11
INSERT INTO Reponse
VALUES
    (1, 5, '2018-11-05 22:11', 'Absent');

SELECT COUNT(Answer.entryID) Nombres, *
FROM Answer INNER JOIN (SELECT *
    FROM Entry NATURAL JOIN Poll 
    WHERE pollID IN (SELECT pollID
    FROM Groups
    WHERE groupID = (SELECT groupID
    FROM Groupe
    WHERE name = 'Profs')
                                                            )
                                            )
                                            AS TEST
    ON Answer.entryID = TEST.entryID
WHERE userAnsw = 'Présent'
GROUP BY Answer.entryID
ORDER BY COUNT(Answer.entryID) DESC

SELECT *
FROM Entree E
    INNER JOIN Sondage ON Sondage.id = E.idSondage
    INNER JOIN SondageParGroupe ON Sondage.ID = SondageParGroupe.idSondage
WHERE SondageParGroupe.idGroupe = 1
    AND EXISTS (
            SELECT *
    FROM Reponse R
    WHERE R.idEntree = E.id AND R.reponse = 'Présent'
        );

SELECT Sondage.*, TT.idEntree, TT.NB as NB
FROM Sondage
    INNER JOIN
    (SELECT TopEntries.idSondage, TopEntries.idEntree, MAX(TopEntries.NB) AS NB
    FROM (
    SELECT Reponse.idEntree as idEntree, Entree.idSondage AS idSondage, COUNT(*) as NB
        FROM Reponse
            INNER JOIN Entree ON idEntree = Entree.id
        WHERE reponse = 'Présent'
        GROUP BY Reponse.idEntree
) AS TopEntries
    GROUP BY TopEntries.idSondage) AS TT ON TT.idSondage = Sondage.id;