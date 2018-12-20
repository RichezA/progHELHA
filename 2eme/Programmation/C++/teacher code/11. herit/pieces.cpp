#include <iostream>
#define _USE_MATH_DEFINES
#include <cmath>

using namespace std;

class Forme {

  public:
    virtual double getPerimetre() = 0;
    virtual double getSurface() = 0;
};

class Carre : public Forme {
  int cote;

  public:
    Carre(int cote) : cote(cote) {}

    double getPerimetre() {
      return 4 * cote;
    }
    double getSurface () {
      return cote * cote;
    }
};
class Rectangle : public Forme {
  int base;
  int hauteur;

  public:
    Rectangle(int base, int hauteur) : base(base), hauteur(hauteur) {}

    double getPerimetre() {
      return 2 * (base + hauteur);
    }
    double getSurface () {
      return base * hauteur;
    }
};
class Cercle : public Forme {
  
  int rayon;

  public:
    Cercle(int rayon): rayon(rayon) {}

    double getPerimetre() {
      return 2 * M_PI * rayon;
    }
    double getSurface () {
      return M_PI * (rayon * rayon);
    }
};

int main(int argc, char const *argv[]) {
  Cercle cercle(3);
  Carre carre(4);
  Rectangle rectangle(3,4);

  Forme* formes[3];
  formes[0] = &cercle;
  formes[1] = &carre;
  formes[2] = &rectangle;

  for(int i = 0; i<3; i++) {
    cout << "p :" << formes[i]->getPerimetre() << endl;
    cout << "s :" << formes[i]->getSurface() << endl;
  }
  cout << "cercle p :" << cercle.getPerimetre() << endl;
  cout << "cercle s :" << cercle.getSurface() << endl;
  cout << "carre p :" << carre.getPerimetre() << endl;
  cout << "carre s :" << carre.getSurface() << endl;
  cout << "rectangle p :" << rectangle.getPerimetre() << endl;
  cout << "rectangle s :" << rectangle.getSurface() << endl;
  return 0;
}