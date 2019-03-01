#include <iostream>
#include <cmath>

using namespace std;

int main(int argc, char const *argv[]) {
  int x;
  do {
    cout << "donnez un nombre positif : ";
    cin >> x;
    if (x < 0) cout << "svp positif \n";
    if (x <= 0) continue;
    cout << "sa racine carrée est : " << sqrt(x) << "\n";
  }while(x != 0);
  return 0;
}