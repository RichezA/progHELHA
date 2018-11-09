#include <iostream>
#include "cpp11-09exosh.h"

/*class Chose
{
  public:
    Chose()
    {
        std::cout << "Création d'un objet Chose" << std::endl;
    }
    ~Chose()
    {
        std::cout << "Suppression d'un object Chose" << std::endl;
    }
};*/

int main()
{
    // exo1
    /*Chose x;
    std::cout << "Bonjour\n";*/

    // exo2
    Point *tab = new Point[4];
    delete[] tab;
    tab = nullptr;

    Point *tt[] = {
        new Point(),
        new Point(),
        new Point(),
        new Point()};
    for (int i = 0; i < 4; i++)
    {
        delete tt[i];
        tt[i] = nullptr;
    }
    return 0;
}