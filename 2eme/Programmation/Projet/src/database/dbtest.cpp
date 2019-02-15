// SELECT Joueur.idJoueur, COUNT(Joueur.aGagne) as 'Nbre de parties gagnées' FROM Joueur WHERE Joueur.aGagne = 1 GROUP BY Joueur.idJoueur // = nbre de parties gagnées
// SELECT * FROM Joueur INNER JOIN Partie WHERE Joueur.idPartie = Partie.idPartie ORDER BY dateCreation  // = score par ordre de date de création
#include "sqlite3.h"
#include <iostream>
#include <cstring>
#include <string>
#include <fstream>

using namespace std;

static int callback(void *data, int argc, char **argv, char **azColName)
{
    int i;
    fprintf(stderr, "%s: ", (const char *)data);

    for (i = 0; i < argc; i++)
    {
        printf("%s = %s\n", azColName[i], argv[i] ? argv[i] : "NULL");
    }

    printf("\n");
    return 0;
}
class Database
{
    sqlite3 *db;
    int idRangeePartie = 0;
    string createPartie = "CREATE TABLE Partie(idPartie INTEGER PRIMARY KEY AUTOINCREMENT,dateCreation TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP)";
    string createJoueur = "CREATE TABLE Joueur(idJoueur INTEGER PRIMARY KEY,NomJoueur VARCHAR(30),pointsScore INTEGER NOT NULL,aGagne BOOLEAN,idPartie INTEGER,FOREIGN KEY (idPartie) REFERENCES Partie(idPartie))";
    string insertPartie = "INSERT INTO Partie (dateCreation) VALUES (CURRENT_TIMESTAMP)";
    string data = "\n";
    std::string insertJoueur = "INSERT INTO Joueur (NomJoueur, pointsScore, aGagne, idPartie) VALUES ('Joueur 1', 10, 0, 45),('Joueur 2', 45, 0,45),('Joueur 3', 0, 1,45),('Joueur 4', 68, 0, 45)";

  public:
    Database()
    {
        ifstream file("score.db");
        if (!file)
        {
            ofstream outfile("score.db");
            outfile.close();
            sqlite3_open("score.db", &db);
            sqlite3_exec(db, createPartie.c_str(), callback, (void *)data.c_str(), NULL);
            sqlite3_exec(db, createJoueur.c_str(), callback, (void *)data.c_str(), NULL);
        }
        else
        {
            sqlite3_open("score.db", &db);
        }
    }
    void creerPartie()
    {
        sqlite3_exec(db, insertPartie.c_str(), callback, (void *)data.c_str(), NULL);
        idRangeePartie = sqlite3_last_insert_rowid(db);
    }

    void envoyerData(string nom, int score, bool gagnant)
    {
        insertJoueur = "INSERT INTO Joueur (NomJoueur, pointsScore, aGagne, idPartie) VALUES ('" + nom + "'," + std::to_string(score) + ", " + std::to_string(gagnant) + ", " + std::to_string(idRangeePartie) + ")";
        //insertJoueur = "INSERT INTO Joueur (NomJoueur, pointsScore, aGagne, idPartie) VALUES (%s, %d , %d , %d)", nom, std::to_string(score), std::to_string(gagnant), std::to_string(idRangeePartie);

        this->insertData();
    }
    void insertData()
    {
        std::cout << insertJoueur << std::endl;
        int rc = sqlite3_exec(db, insertJoueur.c_str(), callback, (void *)data.c_str(), NULL);
        if (rc != SQLITE_OK)
        {
            cerr << "error " << sqlite3_errmsg(db) << std::endl;
        }
        else
        {
            cout << "ok" << std::endl;
        }
        //sqlite3_exec(db, "SELECT * FROM Joueur", callback, (void *)data.c_str(), NULL);
    }
};

int main()
{

    Database db;
    db.creerPartie();
    db.envoyerData("Joueur 1", 64, 0);
    db.envoyerData("Joueur 2", 42, 0);
    db.envoyerData("Joueur 3", 34, 1);
    db.envoyerData("Joueur 4", 55, 0);
    //#pragma region variables
    //     char buffer[128];
    //     int tmp = 0;
    //     int idRangeePartie = 32;
    //     sqlite3 *db;
    //     sqlite3_stmt *stmt;
    //     string insertPartie = "INSERT INTO Partie (dateCreation) VALUES (CURRENT_TIMESTAMP)";
    //     string createPartie = "CREATE TABLE Partie(idPartie INTEGER PRIMARY KEY AUTOINCREMENT,dateCreation TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP)";
    //     string createJoueur = "CREATE TABLE Joueur(idJoueur INTEGER PRIMARY KEY,NomJoueur VARCHAR(30),pointsScore INTEGER NOT NULL,aGagne BOOLEAN,idPartie INTEGER,FOREIGN KEY (idPartie) REFERENCES Partie(idPartie))";
    //     int exit = 0;
    //     string data = "\n";
    // #pragma endregion

    //     ifstream file("score.db");
    //     if (file)
    //     {
    //         //cout << "database exists" << endl;
    //         exit = sqlite3_open("score.db", &db);
    // #pragma region insertTable
    //         sqlite3_exec(db, insertPartie.c_str(), callback, (void *)data.c_str(), NULL);
    //         idRangeePartie = sqlite3_last_insert_rowid(db);
    //         string insertJoueur = "INSERT INTO Joueur (NomJoueur, pointsScore, aGagne, idPartie) VALUES ('Joueur 1', 10, 0, " + to_string(idRangeePartie) + "),('Joueur 2', 45, 0, " + to_string(idRangeePartie) + "),('Joueur 3', 0, 1," + to_string(idRangeePartie) + "),('Joueur 4', 68, 0, " + to_string(idRangeePartie) + ") ";
    //         std::cout << insertJoueur << std::endl;
    //         sqlite3_exec(db, insertJoueur.c_str(), callback, (void *)data.c_str(), NULL);
    // #pragma endregion
    //         // #pragma region SELECT
    //         //         sqlite3_exec(db, sql1.c_str(), callback, (void *)data.c_str(), NULL);
    //         //         sqlite3_exec(db, sql2.c_str(), callback, (void *)data.c_str(), NULL);
    //         // #pragma endregion
    //         sqlite3_close(db);
    //         return 0;
    //     }
    //     else
    //     {
    //         ofstream outfile("score.db");
    //         outfile.close();
    //         exit = sqlite3_open("score.db", &db);
    // #pragma region createTable
    //         sqlite3_exec(db, createPartie.c_str(), callback, (void *)data.c_str(), NULL);
    //         sqlite3_exec(db, createJoueur.c_str(), callback, (void *)data.c_str(), NULL);
    // #pragma endregion
    //         sqlite3_close(db);
    //         return 0;
    //     }
    //     if (exit)
    //     {
    //         cout << "Error while opening the databse " << sqlite3_errmsg(db) << endl;
    //         return (-1);
    //     }
    //     else
    //     {
    //         // sqlite3_exec(db, "DROP TABLE Partie", callback, (void *)data.c_str(), NULL);
    //         // sqlite3_exec(db, "DROP TABLE Joueur", callback, (void *)data.c_str(), NULL);
    //         return 0;
    //     }
}
