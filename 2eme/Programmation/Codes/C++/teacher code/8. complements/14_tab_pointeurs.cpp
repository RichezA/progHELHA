#include <iostream>
using namespace std;

void afficheTab1(int t[10]) {
  cout << "1 : " << t << endl;
}

void afficheTab2(int t[]) {
  cout << "2 : " << t << endl;
}
void afficheTab3(int *t) {
  cout << "3 : " << t << endl;
}

int main(int argc, char const *argv[]) {
  int t[5] = {1,2,3,4,5};
  cout << "t[4]=" << *(t+3) << endl;
  afficheTab1(t);
  afficheTab2(t);
  afficheTab3(t);
  return 0;
}