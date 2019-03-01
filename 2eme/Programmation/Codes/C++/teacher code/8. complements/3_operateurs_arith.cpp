#include <iostream>
using namespace std;

int main(int argc, char const *argv[]) {
  cout << 'a' + 'b' << endl;
  cout << (char)('a' + 5) << endl;
  cout << 5.1 + 5 << endl;
  cout << 5.1 + false + 2 * true << endl;
  cout << 2147483647 + 1 << endl; // -2147483648...
  cout << 2147483648 + 1 << endl; // 2147483649... :)
  cout << 4294967295u + 1 << endl; // 0
  cout << 2147483647L + 1 << endl;
  cout << 1 + 2147483647L << endl;

  return 0;
}