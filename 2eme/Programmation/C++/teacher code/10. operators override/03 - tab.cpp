#include <iostream>

using namespace std;

class Tab {
  
  static const int LENGTH = 30;
  char tabs[LENGTH];

  public:
    char& operator [](int index){
      return tabs[LENGTH - index - 1];
      // return tabs[index];
    }

    int size() const{
      return LENGTH;
    }
};

int main(){
  Tab tab;
  tab[4] = 'c';
  for(int i = 0; i < tab.size(); i++) {
    cout << "tab [" << i << "]" << tab[i] << endl;
  }
  return 0;
}
