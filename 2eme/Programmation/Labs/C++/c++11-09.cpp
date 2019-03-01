#include <iostream>
#include <algorithm>
#include "declarationHeader.h"

//pointeur
/*int main()
{
    int age(10);
    int *ptr = &age;
    // & = adresse mémoire de la variable
    // *pointeur = valeur de la valeur pointée
    // variable = valeur de la variable
    std::cout << "Adresse de age: " << &age << " déréférencement de ptr: " << *ptr << " valeur de ptr : " << ptr << " valeur de age: " << age << " adresse de ptr: " << &ptr << std::endl;
}*/

/*int main()
{
    int i = 5;           // variable créé à l'adresse 0xA avec la valeur 5
    int *adi = &i;       // pointeur créé avec comme valeur l'adresse de i = on met par exemple 0xA dans adi
    int *adi2 = new int; // pointeur créé sans valeur mais avec espace mémoire alloué = espace mémoire dans le heap
    *adi2 = *adi;        // on copie la valeur de la valeur pointée dans l'autre pointeur = ici on met 5 dans adi2
    delete adi2;         // on delete le pointeur
    adi2 = nullptr;      // on met le pointeur à null
}*/

/*int main()
{
    int t[10]; // crée un tableau avec 10 adresses mémoires contigues, égal à int * t;
    t[0] = 5;  // égal à *t
    t[2] = 8;  // égal à *(t + 2);
    cout << t; // affiche l'adresse mémoire du début du tableau

    int t2[3][4];
    cout << t2;     // égal à &t2[0][0] ou t2[0]
    cout << t2 + 2; // égal à &t2[2][0] ou t2[2]
}*/

/*int main()
{
    t = new int[10]; // crée un tableau dynamique de 10
    delete[] t; // on supprime t
}*/

/*int main()
{
    //int t[] = {12, 1, 8, 2, 7, 3, 4, 6, 5, 21};
    int t[10];
    for (int i = 0; i < 10; i++)
    {
        std::cout << "entrez le " << i + 1 << "e nombre : ";
        std::cin >> t[i];
        std::cout << "\n";
        while (std::cin.fail())
        {
            std::cin.clear();
            std::cin.ignore(1000000, '\n');
            std::cout << "Réentrez le " << i + 1 << "e nombre: ";
            std::cin >> t[i];
        }
    }

    int min = t[0];
    int max = t[0];
    for (int i = 1; i < 10; i++)
    {
        if (min > t[i])
            min = t[i];
        if (max < t[i])
            max = t[i];
    }
    std::cout << "max: " << max << " min: " << min;
    //std::cout << "maximum: " << *std::max_element(t, t + 10) << std::endl;
    //std::cout << "minimum: " << *std::min_element(t, t + 10);

    return 0;
}*/

/*int main()
{
    // int tab[10];
    // int *adr = tab;
    // for (; adr < tab + 10; adr++)
    // {
    //     std::cout << "Introduisez le nombre suivant: ";
    //     std::cin >> *adr;
    // }
    // int min = *tab;
    // int max = *tab;
    // for (int i = 1; i < 10; i++)
    // {
    //     if (min > *(tab + i))
    //         min = *(tab + i);
    //     if (min < *(tab + i))
    //         max = *(tab + i);
    // }
    // std::cout << "min: " << min << " max: " << max << std::endl;

    int t[] = {124, 145, 887, 287, 71, 453, 5494, 496, 25, 2121};
    int *min = t;
    int *max = t;
    for (int *adt = t + 1; adt < t + 10; adt++)
    {
        if (*(min) > *(adt))
            min = adt;
        if (*(max) < *(adt))
            max = adt;
    }
    std::cout << "min: " << *min << " max: " << *max;
    return 0;
}*/

/*int main()
{
    int t[4] = {10, 20, 30, 40};
    int *ad[4];
    int i;
    for (i = 0; i < 4; i++)
        ad[i] = t + i;
    for (i = 0; i < 4; i++)
        std::cout << *ad[i] << " ";
    std::cout << "\n";
    std::cout << *(ad[1] + 1) << " " << *ad[1] + 1 << "\n";
}*/

//classes

/*class Adresse
{
    int numero = 5;

  public:
    Adresse(int numero) { this->numero = numero; }
};
class Personne
{
    int age = 0;
    Adresse *maJolieAdresse = nullptr;
    Adresse &maJolieAdresse2;
    const int taille;

  public:
    Personne(int age = 50, Adresse r) : taille(175), maJolieAdresse2(r)
    {
        this->age = age;
        maJolieAdresse = new Adresse(10);
    }
    Personne(Personne &p)
    {
        this->age = p.age;
        this->maJolieAdresse = p.(*maJolieAdresse);
        this->taille = p.taille;
    }
    ~Personne()
    {
        cout << "Supprimé" << endl;
        if (maJolieAdresse != nullptr)
        {
            delete maJolieAdresse;
            maJolieAdresse = nullptr;
        }
    }
}*/

int main()
{
    Point p1(1, 1);
    std::cout << p1.getX() << std::endl;
    Point p2(2, 2);
    std::cout << p2.getX() << std::endl;
}
