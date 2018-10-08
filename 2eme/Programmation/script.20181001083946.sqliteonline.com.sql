--SELECT * FROM Etudiant WHERE nom LIKE 'C%' OR (nom LIKE '%l%' AND prenom LIKE '%d%');
--SELECT *,COUNT(*) FROM Inscription GROUP BY annee;
--SELECT *,COUNT(*) FROM Inscription GROUP BY annee HAVING COUNT(*) > 1;
--SELECT * FROM Inscription,Etudiant WHERE Inscription.matricule = Etudiant.matricule AND Inscription.statut = 'REUSSITE' ORDER By annee, Etudiant.nom;
SELECT Count(*),Etudiant.nom,Inscription.statut FROM Inscription, Etudiant WHERE Inscription.matricule = Etudiant.matricule AND Inscription.statut = 'ECHEC' GROUP BY nom;