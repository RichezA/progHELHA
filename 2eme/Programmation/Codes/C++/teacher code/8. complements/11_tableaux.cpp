#include <iostream>
using namespace std;

int main(int argc, char const *argv[]) {
  float tf[10];
  for(int i = 0; i <= 10; i++) {
    cout << "tf[" << i << "] = " << tf[i] << endl;
  }
  tf[0] = 1.55;
  for(int i = 0; i <= 10; i++) {
    cout << "tf[" << i << "] = " << tf[i] << endl;
  }
  
  const int NB_TC = 3;
  char tc[NB_TC][NB_TC] = {'H', 'e', 'l', 'H', 'a'};
  // tc = {'H', 'e', 'l', 'H', 'a'}; // interdit : doit être lors durant la création de la variable
  tc[2][2] = 'L';
  tc[2][1] = 'M';
  tc[2][0] = 'U';
  for(int i = 0; i < NB_TC; i++) {
    for(int j = 0; j < NB_TC; j++) {
      cout << "tc[" << i << "][" << j << "] = " << tc[i][j] << endl;
    }
  }
  cout << tc[0][20000000] << endl; // segmentation fault (ca dépend)
  return 0;
}