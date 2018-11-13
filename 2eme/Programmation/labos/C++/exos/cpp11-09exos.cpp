#include <iostream>
#include <cstring>
#include "charsetHeader.h"
//#include "cpp11-09exosh.h"

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

/*class Point
{
    static int nbrPoints;
    int id;
    public:
        Point()
        {
            this-> id = ++nbrPoints;
            std::cout << "Point " << id << " créé" << std::endl;
        }
        ~Point()
        {
            std::cout << "Point " << this->id << " supprimé" << std::endl;
        }
};
int Point::nbrPoints = 0;*/

 int main()
 {
//     // exo1
//     /*Chose x;
//     std::cout << "Bonjour\n";*/

//     // exo2
//     Point *tab = new Point[4];
//     delete[] tab;
//     tab = nullptr;

//     Point *tt[] = {
//         new Point(),
//         new Point(),
//         new Point(),
//         new Point()};
//     for (int i = 0; i < 4; i++)
//     {
//         delete tt[i];
//         tt[i] = nullptr;
//     }

    // exo3
    CharSet char1;
    char1.addElement();
    char1.showElement();   
    char1.showSpace();
    return 0;
 }

