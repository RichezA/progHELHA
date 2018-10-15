-- chap 1
/*
SELECT * FROM Produit;
SELECT * FROM Produit LIMIT 10;
SELECT * FROM Produit ORDER BY PrixUnit
SELECT * FROM Produit ORDER BY PrixUnit DESC LIMIT 3;
SELECT * FROM Client WHERE Ville = 'Paris';
SELECT * FROM Client WHERE Pays IN ('Suisse','Allemagne','Belgique'); 
SELECT * FROM Client WHERE Fax IS Null;
SELECT * FROM Client WHERE Societe LIKE '%restaurant%';
SELECT Description FROM Categorie
SELECT Pays FROM Client;
SELECT Pays,Ville FROM Client ORDER BY Pays,Ville ASC;

SELECT * FROM Produit WHERE QteParUnit LIKE '%bouteilles%' OR '%cannettes%';

SELECT Societe,Contact,Ville FROM Fournisseur WHERE Pays IS 'France' ORDER BY Ville;

SELECT UPPER(Nomprod) AS NomProducteur,Refprod AS Reference FROM Produit 
WHERE NoFour = 8 AND (PrixUnit BETWEEN 10 AND 100) ;

SELECT NoEmp FROM Commande WHERE VilleLiv IN ('Lille','Lyon','Nantes');

SELECT * FROM Produit WHERE (Nomprod LIKE '%tofu%' OR Nomprod LIKE '%choco%') AND PrixUnit < 100;
*/

-- chap 2
/*
SELECT PrixUnit,Remise,Qte,
ROUND(PrixUnit * Remise,2) AS "MontantRemise", ROUND(PrixUnit - "MontantRemise") AS "PrixAPayer" 

SELECT *,
    CASE
        WHEN Indisponible = 1 THEN "Produit indisponible"
        ELSE "Produit disponible"
        END AS dispo
FROM Produit;

SELECT *,
    CASE
        WHEN Remise = 0 THEN "aucune remise"
        WHEN Remise <= 0.05 THEN "petite remise"
        WHEN Remise <= 0.15 THEN "remise modérée"
        ELSE "remise importante"
        END AS RemiseInfo
FROM DetailCommande;

SELECT *,
    CASE 
        WHEN DateEnv >= ALivAvant THEN "en retard"
        ELSE "à temps"
        END AS InfoEnvoi
FROM Commande;

SELECT SUBSTR(CodeCli,1,3) AS "CodeClient",LOWER(Societe) AS "Societe",Contact, Adresse || ", " || CodePostal || " " || Ville || ", " || Pays AS "Adresse complète",
        REPLACE(Fonction, "marketing","mercatique") AS "Fonction",
        INSTR(Fonction,"Chef") AS "Chef"
FROM Client;

SELECT CodeCli,
    CASE STRFTIME("%w",DateCom)
            WHEN "0" THEN "DIMANCHE"
            WHEN "1" THEN "LUNDI"
            WHEN "2" THEN "MARDI"
            WHEN "3" THEN "MERCREDI"
            WHEN "4" THEN "JEUDI"
            WHEN "5" THEN "VENDREDI"
            WHEN "6" THEN "SAMEDI"
        END AS "Jours",
    CASE STRFTIME("%w",DateCom)
            WHEN "0" OR "6" THEN "week-end"
            ELSE "semaine"
        END AS "etatJour",
    JULIANDAY(ALivAvant) - JULIANDAY(DateCom) AS "Jours",
    DATE(DateCom, "+7 day", "+1 month", "+1 year") as "Call"
FROM Commande;

SELECT Nom,Prenom,DateNaissance,DateEmbauche,
    STRFTIME("%Y",DATE("now") - DATE(DateEmbauche)) AS "AgeEmbauche"
FROM Employe;

SELECT Nocom,Refprod,PrixUnit,
ROUND(Remise * 100) AS "Remise en pourcentage",
ROUND(PrixUnit * Remise,2) AS "MONTANT REMISE",
ROUND(PrixUnit - "MONTANT REMISE",2) AS "Prix avec remise"
FROM DetailCommande
WHERE Remise > 0.10;
*/

--chap 3
/*
SELECT Count(*) FROM Employe WHERE Fonction = "Représentant(e)";
SELECT COUNT(*) FROM Produit WHERE PrixUnit < 50;
SELECT COUNT(*) FROM Produit WHERE CodeCateg IS 2 AND UnitesStock > 10;
SELECT COUNT(*) FROM Produit WHERE CodeCateg IS 1 AND NoFour BETWEEN 1 AND 18;
SELECT COUNT(DISTINCT PaysLiv) FROM Commande;
SELECT COUNT(*) FROM Commande WHERE DateCom IS "1996-03-28";
SELECT ROUND(AVG(Port),2) FROM Commande WHERE CodeCli IS "QUICK";
SELECT MIN(Port),MAX(Port) FROM Commande;
SELECT NoMess, SUM(Port) FROM Commande GROUP BY NoMess;
SELECT COUNT(*), Fonction FROM Employe GROUP BY Fonction;
SELECT NoMess, AVG(Port) FROM Commande GROUP BY NoMess;
SELECT COUNT(CodeCateg),NoFour FROM Produit GROUP BY NoFour;
SELECT NoFour,CodeCateg,AVG(PrixUnit) FROM Produit GROUP BY NoFour;
SELECT NoFour,Count(*) FROM Produit GROUP BY NoFour HAVING Count(*) = 1 ;
SELECT CodeCateg,AVG(PrixUnit) FROM Produit GROUP BY CodeCateg HAVING AVG(PrixUnit) > 150;
SELECT * FROM PRODUIT GROUP BY NoFour HAVING COUNT(CodeCateg) = 1;
SELECT SUM(Qte) FROM DetailCommande GROUP BY Refprod;
SELECT CodeCli,COUNT(CodeCli) FROM Commande GROUP BY CodeCli ORDER BY COUNT(CodeCli) DESC LIMIT 5;
SELECT Nocom,PrixUnit AS "Prix unitaire sans remise",
       SUM(PrixUnit) AS "Prix total sans remise",
       ROUND(PrixUnit - (PrixUnit * Remise),2) AS "Prix unitaire avec remise",
       SUM(PrixUnit - (PrixUnit * Remise)) AS "Prix total avec remise"
FROM DetailCommande
GROUP BY Nocom;
SELECT COUNT(Refprod),AVG(PrixUnit) 
FROM Produit
GROUP BY CodeCateg
HAVING COUNT(Refprod) > 10;
SELECT NoEmp,Count(NoCom)
FROM Commande
GROUP BY NoEmp
ORDER BY Count(NoCom)
LIMIT 1;
*/

--recap 
/*
SELECT * FROM SEANCES;
SELECT * FROM sportifs GROUP BY Age;
SELECT * FROM gymnases ORDER BY Surface DESC LIMIT 5;
SELECT * FROM sportifs WHERE Age > 30;
SELECT * FROM gymnases WHERE Ville IS "STAINS";
SELECT * FROM sportifs WHERE IdSportifConseiller IS NULL;
SELECT Libelle FROM sports;
SELECT Sexe FROM sportifs GROUP By Sexe;
SELECT Duree / 60.0,* FROM seances;
SELECT Surface * 0.09290304 FROM Gymnases;
SELECT Nom,Prenom,
      CASE Sexe
        WHEN "M" THEN "M."
        WHEN "F" THEN "Mme"
        WHEN "m" THEN "M."
      END AS "TitreCourtoisie"
FROM sportifs;
SELECT NomGymnase,
      CASE
        WHEN Surface < 400 THEN "petit"
        WHEN Surface BETWEEN 400 AND 550 THEN "moyen"
        WHEN Surface > 550 THEN "grand"
      END AS "TypeGymnase"
FROM Gymnases;
SELECT LOWER(Nom) || " " || LOWER(SUBSTR(Prenom,1,1)) || "." FROM sportifs;
SELECT * FROM Gymnases WHERE Adresse LIKE '%Place%';
SELECT DATE("now");
SELECT  
        CASE STRFTIME("%w",DATE((STRFTIME("%Y", "now") - Age) || "-01-01"))
            WHEN "0" THEN "DIMANCHE"
            WHEN "1" THEN "LUNDI"
            WHEN "2" THEN "MARDI"
            WHEN "3" THEN "MERCREDI"
            WHEN "4" THEN "JEUDI"
            WHEN "5" THEN "VENDREDI"
            WHEN "6" THEN "SAMEDI"
        END AS "Jours"
FROM sportifs;
SELECT COUNT(*) FROM sportifs;
SELECT COUNT(*) FROM sportifs WHERE IdSportifConseiller > 1;
SELECT DISTINCT(Ville) FROM Gymnases;
SELECT AVG(Surface) FROM Gymnases;
SELECT AVG(Age),MIN(Age),MAX(Age) FROM sportifs;
SELECT COUNT(*),AVG(Age) FROM sportifs GROUP BY Sexe;
SELECT MIN(Surface) AS "+Petit",MAX(Surface) AS "+Grand",Ville FROM Gymnases GROUP BY Ville;
SELECT Ville,COUNT(*) FROM Gymnases GROUP BY Ville HAVING COUNT(*) > 5 
SELECT * FROM sportifs WHERE Sexe = "M" OR Sexe = "m" ORDER BY Age DESC LIMIT 5;
SELECT Ville FROM Gymnases WHERE Surface > 500 GROUP BY Ville;
SELECT UPPER(Nom) || " " || SUBSTR(Prenom,1,1) || " - " || (STRFTIME("%Y", "now") - Age) FROM sportifs;
SELECT IdSport,Count(IdSportif) FROM Jouer GROUP BY IdSport;
SELECT Count(IdSportif),
    CASE
        WHEN Age BETWEEN 20 AND 24 THEN "junior"
        WHEN Age BETWEEN 25 AND 30 THEN "senior1"
        WHEN Age BETWEEN 31 AND 45 THEN "senior2"
    END AS "repartition"
FROM sportifs GROUP BY "repartition";
SELECT *,Horaire + (Duree / 60.0) AS "Date de fin" FROM seances;
*/

--chap 4
/*
SELECT Refprod,Nomprod,Fournisseur.* FROM Produit NATURAL JOIN Fournisseur;
SELECT Client.Societe,Commande.* FROM Client NATURAL JOIN Commande WHERE Client.Societe = "Lazy K Kountry Store";
SELECT M.NomMess,COUNT(Commande.NoCom) FROM Messager AS M NATURAL JOIN Commande GROUP BY M.NomMess;
SELECT * FROM Produit INNER JOIN Fournisseur ON Produit.NoFour = Fournisseur.NoFour;
SELECT Client.Societe,Commande.* FROM Client INNER JOIN Commande 
ON Client.CodeCli = Commande.CodeCli WHERE Client.Societe = "Lazy K Kountry Store";

SELECT M.NomMess,COUNT(Commande.NoCom) FROM Messager AS M INNER JOIN Commande
ON M.NoMess = Commande.NoMess GROUP BY M.NomMess;

SELECT Count(DetailCommande.Nocom) AS "Nbre",Produit.* FROM Produit LEFT OUTER JOIN DetailCommande 
ON Produit.Refprod = DetailCommande.Refprod GROUP BY DetailCommande.Nocom;

SELECT Count(DetailCommande.Nocom) AS "Nbre",Produit.* FROM Produit LEFT OUTER JOIN DetailCommande 
ON Produit.Refprod = DetailCommande.Refprod
GROUP BY DetailCommande.Nocom
HAVING COUNT(DetailCommande.Nocom) = 0;

SELECT Count(Commande.NoCom) AS "Nbre",Employe.* FROM Employe LEFT OUTER JOIN Commande 
ON Employe.NoEmp = Commande.NoEmp
GROUP BY Employe.NoEmp
HAVING COUNT(Commande.NoCom) = 0;

sql 4-4