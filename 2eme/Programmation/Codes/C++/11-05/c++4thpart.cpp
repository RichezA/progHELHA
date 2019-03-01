#include <iostream>

int main()
{
    int n = 5; // crée automatiquement une place en mémoire pour un entier
               //lors de l'ouverture du bloc qui le contient

    int *adn = new int; // crée dynamiquement une place
                        // pour un entier

    *adn = 5;      // utilisation
    delete adn;    // libération de la place allouée
    adn = nullptr; // bonne pratique

    char ch[20] = "Bonjour";
    //char ch[20] = {'B','o','n','j','o','u','r','\0'}; // équivalent
    // que veut donc dire char * agrv[] => tableau de pointeurs vers des tableaux de char (string)
}