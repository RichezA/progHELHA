#include "Database.hpp"

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

BaseDeDonnees::BaseDeDonnees()
{
    sqlite3_open("score.db", &db);
    sqlite3_exec(db, createPartie.c_str(), callback, (void *)data.c_str(), NULL);
    sqlite3_exec(db, createJoueur.c_str(), callback, (void *)data.c_str(), NULL);
    sqlite3_exec(db, createCarteJoueur.c_str(), callback, (void *)data.c_str(), NULL);
}
BaseDeDonnees::~BaseDeDonnees()
{
    sqlite3_close(db);
}

void BaseDeDonnees::CreerPartie()
{
    sqlite3_exec(db, insertPartie.c_str(), callback, (void *)data.c_str(), NULL);
    idRangee = sqlite3_last_insert_rowid(db);
}

void BaseDeDonnees::EnvoyerDonnees(std::string nom, int score, bool gagnant)
{
    std::string insertJoueur = "INSERT INTO Joueur (NomJoueur, pointsScore, aGagne, idPartie) VALUES ('" + nom + "'," + std::to_string(score) + ", " + std::to_string(gagnant) + ", " + std::to_string(idRangee) + ")";
    sqlite3_exec(db, insertJoueur.c_str(), callback, (void *)data.c_str(), NULL);
}

void BaseDeDonnees::EnvoyerCarteJouee(std::string nom, int valeur)
{
    std::string insertCarteJoueur = "INSERT INTO CarteJoueur (idJoueur, noCarte) VALUES ('" + nom + "'," + std::to_string(valeur) + ")";
    sqlite3_exec(db, insertCarteJoueur.c_str(), callback, (void *)data.c_str(), NULL);
}
