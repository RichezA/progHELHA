#include <iostream>
using namespace std;

void f(int& m){
  cout << ++m << endl;
}

int main() {
  int i=0, j=20;
  int& valeur = i;

  f(i); // incrémente i car passage par ref

  cout << "i: " << i << " valeur: " << valeur << endl;
  i = 10; // i = 10 valeur = 10
  
  cout << "i: " << i << " valeur: " << valeur << endl;
  valeur = j; // valeur = 20 => i = 20
  j = 8; // j =8 valeur = 20 i = 20
  valeur += 5; // valeur = 25 i = 25
  
  cout << "i: " << i << " valeur: " << valeur << endl;
  return 0;
}
