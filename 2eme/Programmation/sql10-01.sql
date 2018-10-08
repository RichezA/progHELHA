--Clé primaire d'une table peut être issue d'un ou plusieurs attributs

--Sql :

SELECT * FROM Etudiant; -- get toutes les infos sur tous les étudiants 
SELECT nom FROM Etudiant; -- get le nom de tous les étudiants
SELECT nom, prenom FROM Etudiant; -- get nom puis prénom de tous les étudiants
SELECT MAX(nom) FROM Etudiant; -- che ck tous les noms et return le nom le plus grand (plus grand possible == z)
SELECT * FROM Etudiant WHERE matricule = 1;-- fonctionne aussi avec < et >
SELECT * FROM Etudiant WHERE matricule = 1 AND matricule < 4;
SELECT * FROM Etudiant WHERE matricule = 1 OR (matricule > 1 OR matricule < 4);
SELECT * FROM Etudiant WHERE matricule BETWEEN 2 AND 3;
SELECT * FROM Etudiant WHERE dateNaissance BETWEEN '2000-01-01' AND '2002-01-01';

SELECT * FROM Etudiant WHERE NOT (matricule = 1);
SELECT * FROM Etudiant WHERE matricule <> 1;
SELECT * FROM Etudiant WHERE matricule != 1;
SELECT * FROM Etudiant WHERE prenom LIKE 'A%'; -- fonctionne aussi avec %e%
SELECT * FROM Etudiant WHERE dateNaissance IS NULL;
SELECT * FROM Etudiant WHERE dateNaissance IS NOT NULL;
SELECT * FROM Etudiant WHERE matricule IN (1,3,4);
SELECT * FROM Etudiant WHERE prenom IN ('Alfred');
SELECT * FROM Etudiant WHERE prenom NOT IN ('Alfred', 'Fred');

SELECT prenom, COUNT(*) FROM Etudiant GROUP BY prenom;
SELECT nom, COUNT(*) FROM Etudiant GROUP BY nom;

SELECT prenom, COUNT(*) FROM Etudiant GROUP BY prenom HAVING COUNT(*) > 1; -- Selectionne les prenoms où le sous-groupe > 1 (Si il y'a deux Antoine dans la même classe)

SELECT * FROM Etudiant ORDER BY prenom;
SELECT * FROM Etudiant ORDER BY prenom DESC;
SELECT * FROM Etudiant ORDER BY prenom DESC, nom ASC; -- ASC par défaut => pas d'obligation de le mettre
SELECT * FROM Etudiant ORDER BY dateNaissance DESC;

-- Jointures
--Relations entre au moins deux tables
SELECT * FROM Etudiant as E1, Etudiant as E2 WHERE E1.matricule != E2.matricule;
SELECT * FROM Inscription, Etudiant WHERE Inscription.matricule = Etudiant.matricule AND annee > 2019;
SELECT * FROM Inscription JOIN Etudiant ON Inscription.matricule = Etudiant.matricule;
SELECT * FROM Inscription LEFT  JOIN Etudiant ON Inscription.matricule = Etudiant.matricule; -- Si un élève n'a pas d'inscription pour l'année => affiche null
SELECT * FROM Inscription RIGHT JOIN Etudiant ON Inscription.matricule = Etudiant.matricule IS NULL;
--Produit cartésien :

-- Exercices 
--SELECT * FROM Etudiant WHERE nom LIKE 'C%' OR (nom LIKE '%l%' AND prenom LIKE '%d%');
--SELECT *,COUNT(*) FROM Inscription GROUP BY annee;
--SELECT *,COUNT(*) FROM Inscription GROUP BY annee HAVING COUNT(*) > 1;
--SELECT * FROM Inscription,Etudiant WHERE Inscription.matricule = Etudiant.matricule AND Inscription.statut = 'REUSSITE' ORDER By annee, Etudiant.nom;
SELECT Count(statut),nom,prenom,statut FROM Inscription as I, Etudiant as E WHERE I.matricule = E.matricule AND I.statut = 'ECHEC' GROUP BY nom;



