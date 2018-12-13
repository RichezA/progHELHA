#include <iostream>
using namespace std;

int main(int argc, char const *argv[]) {
  int *adi;
  int t[5];
  for(int i = 0; i < 5; i++) t[i] = (i + 1) * 10;

  adi = t;
  cout << "*adi = " << *adi << " (" << adi << ")" << endl;
  adi++;
  cout << "*adi = " << *adi << " (" << adi << ")" << endl;
  adi += 3;
  cout << "*adi = " << *adi << " (" << adi << ")" << endl;
  adi -= 4;
  cout << "*adi = " << *adi << " (" << adi << ")" << endl;

  return 0;
}