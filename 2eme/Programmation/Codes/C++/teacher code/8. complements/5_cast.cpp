#include <iostream>
using namespace std;

int main(int argc, char const *argv[]) {
  int n = 3, p = 5;
  cout << (double) n / p << endl; // affiche ?
  cout << (double) (n / p) << endl; // affiche ?
  cout << static_cast<double> (n) / p << endl; // idem
  cout << static_cast<double> (n / p) << endl; // idem
  return 0;
}