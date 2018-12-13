#include <iostream>
using namespace std;

int main(int argc, char const *argv[]) {
  int i,n;

  for(i=0, n=0 ; i < 5; i++) n++;
  cout << "A : i  = " << i << " n = " << n << "\n";

  for(i=0, n=0 ; i < 5; i++, n++) {}
  cout << "B : i  = " << i << " n = " << n << "\n";

  for(i=0, n=50 ; n > 10; i++, n -= i) {}
  cout << "C : i  = " << i << " n = " << n << "\n";

  for(i=0, n=0 ; i < 3; i++, n += i, cout << "D : i  = " << i << " n = " << n << "\n") {}
  cout << "E : i  = " << i << " n = " << n << "\n";

  return 0;
}