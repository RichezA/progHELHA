//Ceci est un commentaire
/*  un commentaire
sur plusieurs lignes
*/
#ifdef commentaire
sur plusieurs lignes
#endif

#include <iostream>
//using namespace std;


void f(int m)
{
    // passage par valeur int& pour référence si on passe par ref => i = 1 si par valeur => i = 0
    cout << ++m << endl;
}
int main()
{
    //cout << "Hello" << endl;
    const int n = 40; // on doit déclarer tout de suite la valeur
    bool isFound = false;
    // n = 12; // erreur de compilation
    for (int i = 0; i < n && !isFound; i++)
    {
        // différence i++ et ++i
        // i++ on utilise d'abord i puis on incrémente
        // ++i on incrémente d'abord i puis on l'utilise
        int j = 25;
        i += j;
        cout << "i vaut: " << i << endl;
        if (i > 20)
        {
            isFound = true; // on peut aussi utiliser 1 ou n'importe quel autre valeur à la place de true
        }
    }

    enum Color
    {
        red,
        green,
        blue
    };
    Color r = red;
    switch (r)
    {
    case red:
        cout << red << "red\n";
        break;
    case green:
        cout << green << "green\n";
        break;
    case blue:
        cout << blue << "blue\n";
        break;
    }

    int i = 0, j = 10;
    int &value = i;

    f(i); // renvoie 1 mais i vaut toujours 0
    cout << "i vaut : " << i << " valeur : " << value << endl;
    i = 10;

    cout << "i vaut : " << i << " valeur : " << value << endl;
    value = j;
    j += 5;

    cout << "i vaut : " << i << " valeur : " << value << endl;

    return 0;
}
