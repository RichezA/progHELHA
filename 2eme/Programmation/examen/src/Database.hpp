#pragma once
#include <fstream>
#include <string>
#include <iostream>
#include "sqlite3.h"
#include <iostream>

class BaseDeDonnees
{
  // Toutes les requêtes pouvant être utilisées par notre gestion de base de donnés
  std::string createPartie = "CREATE TABLE Partie(idPartie INTEGER PRIMARY KEY AUTOINCREMENT,dateCreation TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP)";
  std::string createJoueur = "CREATE TABLE Joueur(idJoueur INTEGER PRIMARY KEY,NomJoueur VARCHAR(30),pointsScore INTEGER NOT NULL,aGagne BOOLEAN,idPartie INTEGER,FOREIGN KEY (idPartie) REFERENCES Partie(idPartie))";
  std::string createCarteJoueur = "CREATE TABLE CarteJoueur (idJoueur VARCHAR(30), noCarte INTEGER)";
  std::string insertPartie = "INSERT INTO Partie (dateCreation) VALUES (CURRENT_TIMESTAMP)";
  std::string data = "\n";
  sqlite3 *db;
  std::string filename = "score.db";
  int idRangee;

public:
  BaseDeDonnees();                                               // Constructeur et check si la base de donnée existe, si pas on en crée une
  ~BaseDeDonnees();                                              // Destructeur
  void CreerPartie();                                            // Permet d'envoyer une requête afin de créer une nouvelle entrée partie
  void EnvoyerDonnees(std::string nom, int score, bool gagnant); // Permet d'envoyer les différentes entrées importantes à notre base de donnée en fin de partie
  void EnvoyerCarteJouee(std::string nom, int valeur);
};