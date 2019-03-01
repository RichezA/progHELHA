#include <iostream>
using namespace std;

class DoubleElement {
  double valeur;
  DoubleElement * suivant;
public:
  DoubleElement(double valeur, DoubleElement* suivant = nullptr) : valeur(valeur), suivant(suivant) {}
  double somme();
  double getValeur() {
    return valeur;
  }
  DoubleElement* inserer(double);
  DoubleElement& operator++();
  DoubleElement operator++(int);
};

double DoubleElement::somme() {
  double somme = valeur * valeur;
  if (suivant == nullptr) {
    return somme;
  }
  return somme + suivant->somme();
}

DoubleElement* DoubleElement::inserer(double nouvelleValeur) {
  if (valeur < nouvelleValeur) {
    if (suivant == nullptr || suivant->valeur > nouvelleValeur) {
      DoubleElement*tmp = suivant;
      suivant = new DoubleElement(nouvelleValeur, tmp);
      return nullptr;
    } else {
      suivant->inserer(nouvelleValeur);
      return nullptr;
    }
  } else {
    return new DoubleElement(nouvelleValeur, this);
  }
}

DoubleElement& DoubleElement::operator++() {
  valeur++;
  return *this;
}
DoubleElement DoubleElement::operator++(int) {
  DoubleElement copie(*this);
  valeur++;
  return copie;
}


int main(int argc, char const *argv[]) {
  DoubleElement* tete = new DoubleElement(5.5);
  cout << tete->somme() << endl;
  tete->inserer(10);
  cout << tete->somme() << endl;
  tete = tete->inserer(2);
  cout << tete->somme() << endl;
  DoubleElement& teteObj = *tete;
  cout << (teteObj++).getValeur() << endl;
  cout << (++teteObj).getValeur() << endl;
  cout << tete->somme() << endl;
  return 0;
}