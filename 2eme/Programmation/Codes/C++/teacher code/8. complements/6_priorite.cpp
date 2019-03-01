#include <iostream>
using namespace std;

int main(int argc, char const *argv[]) {
  int a = 5, b = 6;
  cout << (true || a > b ? false : true || true) << endl;
  return 0;
}