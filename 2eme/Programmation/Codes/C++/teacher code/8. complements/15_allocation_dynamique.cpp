#include <iostream>
using namespace std;

int main(int argc, char const *argv[]) {
  int *adi = new int;
  *adi = 5;
  cout << "*adi = " << *adi << endl;
  delete adi;
  adi = nullptr;

  int * adti = new int[10];
  *(adti+2) = 5;
  cout << "*adti+2 = " << *(adti+2) << endl;
  delete[] adti;
  adti = nullptr;

  int * adtii[10];
  adtii[0] = new int[10];
  *(adtii[0]+3) = 5;
  cout << "*adtii+3 = " << *(*adtii+3) << endl;
  return 0;
}