#include <iostream>
using namespace std;
class Carte {

};
void f2(Carte* t[]) {
  t[0] = nullptr;
}
void f(Carte* t[]) {
  f2(t);
}
int main(int argc, char const *argv[]) {
  Carte *tab[10];
  tab[0] = new Carte();
  f(tab);
  cout << (tab[0] == nullptr) << endl;
  return 0;
}