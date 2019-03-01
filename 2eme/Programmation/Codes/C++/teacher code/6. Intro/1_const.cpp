// #include <stdio.h>
#include <iostream>
using namespace std;

int main() {
  const int n = 40; 
  int k = 5;
  int l = k++;
  cout << l << " " << k;
  // n = 12; // erreur à la compilation
  for (int i=0;i<n;i++) {  
    int j = 25;
    i += j;
    cout << "i vaut: " << i << endl;
  }
  return 0;
}
