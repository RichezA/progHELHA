#include <iostream>
using namespace std;


class Nombre {
  int valeur = 0;
public: 
  Nombre(int i): valeur(i) {}
  Nombre operator+(const Nombre& n) {
    return Nombre(valeur + n.valeur);
  }

  Nombre operator+(int i){
    return Nombre(valeur + i * 5);
  }

  friend Nombre operator+(const Nombre& n1, const Nombre& n2);
  friend Nombre operator+(int i, const Nombre& n);
  friend ostream & operator << (ostream& out, const Nombre &n);
};
ostream & operator << (ostream& out, const Nombre &n) {
  out << n.valeur;
  return out;
}
Nombre operator+(int i, const Nombre& n) {
  return Nombre(n.valeur + i);
  // return n + i;
}
int main(int argc, char const *argv[]) {
  Nombre n1(1), n2(2);
  cout << (n1 + n2) + 10<< endl;
  cout << 10 + n1 << endl;
  return 0;
}