#include "charsetHeader.h"
#include <iostream>
#include <cstring>
//#include "rationnelHeader.hpp"
#include "ElementRationnel.hpp"
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

/*int main()
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
/*CharSet char1;
    char word[81];
    std::cout << "Enter a word: " << std::endl;
    std::cin >> word;
    for (int i = 0; i < std::strlen(word); ++i)
    {
        char1.add(word[i]);
    }
    std::cout << "There's " << char1.cardinal() << " different characters in it" << std::endl;
    if (char1.isElement('e'))
        std::cout << "There's an e in the word" << std::endl;
    else
    {
        std::cout << "There's no e in the word" << std::endl;
    }
    char1.init();
    while (char1.existe())
    {
        char c = char1.prochain();
        std::cout << c << " ";
    }
    return 0;
}*/

Rationnel operator+(Rationnel const &a, Rationnel const &b)
{
    Rationnel r(((a._num * b._denom) + (b._num * a._denom)), (a._denom * b._denom));
    return r.simplify();
}
Rationnel operator-(Rationnel const &a, Rationnel const &b)
{
    Rationnel r(((a._num * b._denom) - (b._num * a._denom)), (a._denom * b._denom));
    return r.simplify();
}
Rationnel operator*(Rationnel const &a, Rationnel const &b)
{
    Rationnel r(a._num * b._num, a._denom * b._denom);
    return r.simplify();
}
Rationnel operator/(Rationnel const &a, Rationnel &b)
{
    b.swap();
    Rationnel r(a._num * b._num, a._denom * b._denom);
    return r.simplify();
}
Rationnel operator==(Rationnel const &a, Rationnel const &b)
{
    const Rationnel &a = a.simplify();
    const Rationnel &b = b.simplify();
    return a.num = b.num && a.denom = b.denom;
}
unsigned int pgcd(unsigned int a, unsigned int b)
{
    return b ? pgcd(b, a % b) : a;
}
std::ostream &operator<<(std::ostream &out, const Rationnel &rat)
{
    rat.show(out); // call the function with the output stream in argument
    return out;    // returns the stream
}
/*int main()
{
    Rationnel r1(4, 12);
    Rationnel r2(2, 32);
    Rationnel r3;
    r3 = r1;
    r3 = r1 + r2;
    r3.affiche();
    r3 = r1 - r2;
    r3.affiche();
    r3 = r1 * r2;
    r3.affiche();
    r3 = r1 / r2;
    r3.affiche();
}*/

int main()
{
    Rationnel r1(9, 4);
    Rationnel r2(8, 10);
    Rationnel r3(2, 5);
    Rationnel r4(1, 3);
    ElementRationnel element4(r1, nullptr);
    ElementRationnel element3(r2, &element4);
    ElementRationnel element2(r3, &element3);
    ElementRationnel element1(r4, &element2);
    std::cout << element1.sum(r3, &element3) << std::endl;
    std::cout << element2.sum() << std::endl;
    return 0;
}