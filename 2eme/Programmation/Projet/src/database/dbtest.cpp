// SELECT Joueur.idJoueur, COUNT(Joueur.aGagne) as 'Nbre de parties gagnées' FROM Joueur WHERE Joueur.aGagne = 1 GROUP BY Joueur.idJoueur // = nbre de parties gagnées
// SELECT * FROM Joueur INNER JOIN Partie WHERE Joueur.idPartie = Partie.idPartie ORDER BY dateCreation  // = score par ordre de date de création
#include "sqlite3.h"
#include <iostream>
#include <cstring>

using namespace std; 
  
static int callback(void* data, int argc, char** argv, char** azColName) 
{ 
    int i; 
    fprintf(stderr, "%s: ", (const char*)data); 
  
    for (i = 0; i < argc; i++) { 
        printf("%s = %s\n", azColName[i], argv[i] ? argv[i] : "NULL"); 
    } 
  
    printf("\n"); 
    return 0; 
} 

int main()
{
    sqlite3 *db;
    sqlite3_stmt *stmt;
    int exit = 0;
    string data = "CALLBACK FUNCTION";
    string sql = "SELECT Joueur.idJoueur, COUNT(Joueur.aGagne) as 'Nbre de parties gagnées' FROM Joueur WHERE Joueur.aGagne = 1 GROUP BY Joueur.idJoueur";
    exit = sqlite3_open("score.db", &db);
    if(exit)
    {
        cout << "Error while opening the databse " << sqlite3_errmsg(db) << endl;
        return (-1);
    }
    else
    {
        cout << "Connection done succesfully " << endl;
        int rc = sqlite3_exec(db, sql.c_str(), callback, (void*)data.c_str(), NULL);
        if(rc != SQLITE_OK)
        {
            cerr << "Error select" << endl;
        }
        else
        {
            cout << "Succesfully done !" << endl;
        }



    	sqlite3_close(db);
        return 0;
    }
}