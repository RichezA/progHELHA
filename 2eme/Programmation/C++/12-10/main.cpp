#include <iostream>
#define _USE_MATH_DEFINES
#include <math.h>
#include <vector>
#include <typeinfo>

// Héritage permet la réutilisation de code
#pragma region Formes
class Forme
{
  public:
    virtual double getPerimetre() = 0;
    virtual double getSurface() = 0;
};
class Carre : public Forme
{
    int cote;

  public:
    Carre(int cote) : cote(cote) {}
    double getPerimetre()
    {
        return 4 * cote;
    }
    double getSurface()
    {
        return cote * cote;
    }
};
class Rectangle : public Forme
{
    int longueur, largeur;

  public:
    Rectangle(int longueur, int largeur) : longueur(longueur), largeur(largeur) {}
    double getPerimetre()
    {
        return (longueur + largeur) * 2;
    }
    double getSurface()
    {
        return longueur * largeur;
    }
};
class Cercle : public Forme
{
    double rayon;

  public:
    Cercle(double rayon) : rayon(rayon) {}
    double getPerimetre()
    {
        return 2 * M_PI * rayon;
    }
    double getSurface()
    {
        return M_PI * (rayon * rayon);
    }
};

// int main(int argc, char *argv[])
// {
//     Cercle cercle(3);
//     Cercle cercle2(4);
//     Carre carre = 3;
//     Rectangle rectangle(3, 4);
//     Cercle *cerle3;
//     Forme *formes[3];
//     formes[0] = &cercle;
//     formes[1] = &cercle2;
//     formes[2] = &rectangle;

//     // for (int i = 0; i < 3; i++)
//     // {
//     //     std::cout << "p: " << formes[i]->getPerimetre() << std::endl;
//     //     std::cout << "s: " << formes[i]->getSurface() << std::endl;
//     // }

//     for (int i = 0; i < 3; i++)
//     {
//         if (dynamic_cast<cerle3 *>(formes[i]) != nullptr)
//         {
//             std::cout << "Cercle" << std::endl;
//         }
//     }
//     for (int i = 0; i < std::atoi(argv[1]); i++)
//     {
//         std::cout << "works ?" << std::endl;
//     }
// }

int main()
{
    Forme *formes[3];
    // Joueur      JoueurHumain
    Cercle cercle(3);
    Cercle cercle2(4);
    Carre carre(2);
    formes[0] = &cercle;
    formes[1] = &cercle2;
    formes[2] = &carre;
    // JoueurHumain
    for (int i = 0; i < 3; i++)
    {
        Cercle *x = dynamic_cast<Cercle *>(formes[i]);

        // voir si x existe
        if (x)
        {
            std::cout << "Cercle" << std::endl;
        }
    }
}
#pragma endregion
#pragma region Echecs

// class Pieces
// {
//   protected:
//     int positionX = 0, positionY = 0;

//   public:
//     Pieces(int positionX, int positionY) : positionX(positionX), positionY(positionY) {}
//     virtual void seDeplacer(int nBCases)
//     {
//         int newX = this->positionX + nBCases, newY = this->positionY + nBCases;
//         if (newX <= 8 && newX >= 0 && newY <= 8 && newY >= 0)
//         {
//             this->movePositions(nBCases);
//         }
//         else
//         {
//             std::cout << "Impossible" << std::endl;
//         }
//     }
//     virtual void getPosition()
//     {
//         std::cout << "X: " << this->positionX << " Y: " << this->positionY << std::endl;
//     }
//     virtual void movePositions(int nBCases) = 0;
// };
// class Tour : public Pieces
// {
//     char direction;

//   public:
//     Tour(int positionX1, int position1Y) : Pieces(positionX1, position1Y)
//     {
//         this->positionX = positionX1;
//         this->positionY = position1Y;
//     }
//     void seDeplacer(int nBCases)
//     {
//         this->movePositions(nBCases);
//     }
//     void movePositions(int nBCases)
//     {
//         std::cout << "H/V: ";
//         std::cin >> direction;
//         if (direction == 'H' || direction == 'h')
//         {
//             // tab[this->positionX + nBCases][this->positionY]
//             this->positionX += nBCases;
//         }
//         //tab[this->positionX][this->positionY  + nBCases]
//         else if (direction == 'V' || direction == 'v')
//         {
//             this->positionY += nBCases;
//         }
//     }
// };
// class Fou : public Pieces
// {

//   public:
//     Fou(int positionX1, int positionY1) : Pieces(positionX1, positionY1)
//     {
//         this->positionX = positionX1;
//         this->positionY = positionY1;
//     }
//     void movePositions(int nBCases)
//     {
//         this->positionX += nBCases;
//         this->positionY += nBCases;
//     }
// };
// class Pion : public Pieces
// {

//     bool firstMove;

//   public:
//     Pion(int positionX1, int positionY1) : Pieces(positionX1, positionY1)
//     {
//         this->positionX = positionX1;
//         this->positionY = positionY1;
//         firstMove = true;
//     }
//     void movePositions(int nBCases)
//     {

//         if (firstMove)
//         {
//             // ici tab[this->positionX][this->positionY + 2]
//             this->positionY += 2;
//             firstMove = false;
//         }
//         else
//         {
//             this->positionY += 1;
//         }
//         // tab[this->positionX][this->positionY + 1]
//     }
// };
// class Cavalier : public Pieces
// {

//   public:
//     Cavalier(int positionX1, int positionY1) : Pieces(positionX1, positionY1)
//     {
//         this->positionX = positionX1;
//         this->positionY = positionY1;
//     }
//     void movePositions(int nBCases)
//     {
//         this->positionY += 2;
//         this->positionX += 1;
//     }
// };

// int main(int argc, char **argv)
// {
//     Cavalier cavalier(2, 0);
//     Pion pion(2, 1);
//     Fou fou(6, 0);
//     Tour tour(8, 0);

//     // cavalier.getPosition();
//     // cavalier.seDeplacer(0);
//     // cavalier.getPosition();
//     // cavalier.seDeplacer(0);
//     // cavalier.getPosition();

//     // pion.getPosition();
//     // pion.seDeplacer(0);
//     // pion.getPosition();
//     // pion.seDeplacer(0);
//     // pion.getPosition();

//     // fou.getPosition();
//     // fou.seDeplacer(2);
//     // fou.getPosition();
//     // fou.seDeplacer(4);
//     // fou.getPosition();

//     // tour.getPosition();
//     // tour.seDeplacer(5);
//     // tour.getPosition();
//     // tour.seDeplacer(-5);
//     // tour.getPosition();
// }

#pragma endregion