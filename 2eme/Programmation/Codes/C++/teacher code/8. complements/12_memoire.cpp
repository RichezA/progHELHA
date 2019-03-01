#include <iostream>
using namespace std;

int main(int argc, char const *argv[]) {
  int *adi;
  float *adf;

  int n = 15;
  adi = &n;
  cout << "adi:" << adi << " &n:" << &n << endl;
  cout << "*adi:" << *adi << " n:" << n << endl;

  int p = *adi;
  *adi = 40;
  
  cout << "*adi:" << *adi << " n:" << n << " p:" << p << endl;
  return 0;
}