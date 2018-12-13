#include <iostream>
using namespace std;

void f(int& m){
  cout << ++m << endl;
}

int main() {
  int i=0, j=20;
  int& valeur = i;

  f(i);

  cout << "i: " << i << " valeur: " << valeur << endl;
  i = 10;
  
  cout << "i: " << i << " valeur: " << valeur << endl;
  valeur = j;
  j = 8;
  valeur += 5;
  
  cout << "i: " << i << " valeur: " << valeur << endl;
  return 0;
}
