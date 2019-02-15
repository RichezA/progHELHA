#include "sqlite3.h"
#include <iostream>
#include <string>
#include <fstream>

static int callback(void *data, int argc, char **argv, char **azColName)
{
    int i;
    fprintf(stderr, "%s", (const char *)data);

    for (i = 0; i < argc; i++)
    {
        printf("%s = %s\n", azColName[i], argv[i] ? argv[i] : "NULL");
    }

    printf("\n");
    return 0;
}

int main()
{
    int idRangeePartie;
    sqlite3 *db;
    int exit = 0;
    std::string data = "\n";
    std::string selectNbGagnant = "SELECT Joueur.NomJoueur, COUNT(Joueur.aGagne) as 'Nbre de parties gagnées' FROM Joueur WHERE Joueur.aGagne = 1 GROUP BY Joueur.NomJoueur";
    std::string selectOrdreCreation = "SELECT * FROM Joueur INNER JOIN Partie ORDER BY dateCreation";
    std::string selectCarteLaPlusJouee = "SELECT * FROM CarteJoueur GROUP BY idJoueur ORDER BY Count(noCarte)";
    std::ifstream file("score.db");
    if (file) // check si le fichier existe
    {
        exit = sqlite3_open("score.db", &db);
        sqlite3_exec(db, selectOrdreCreation.c_str(), callback, (void *)data.c_str(), NULL);
        sqlite3_exec(db, selectNbGagnant.c_str(), callback, (void *)data.c_str(), NULL);
        sqlite3_exec(db, selectCarteLaPlusJouee.c_str(), callback, (void *)data.c_str(), NULL);
    }
    else
    {
        std::cout << "Pas de database existante veuillez d'abord exécuter le 6 qui prend" << std::endl;
    }
}