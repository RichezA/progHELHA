#include <iostream>
using namespace std;

int main(int argc, char const *argv[]) {
  cout << (true && false) << endl;
  cout << (true || false) << endl;
  cout << (false || (cout << "faux || c'est exécuté" << endl)) << endl;
  cout << (true || (cout << "true || ce n'est pas exécuté" << endl)) << endl;
  cout << !true << endl;
  int a = 12;
  int b = 0;
  cout << (a / b) << endl;
  return 0;
}