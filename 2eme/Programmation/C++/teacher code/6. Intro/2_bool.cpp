#include <iostream>

int main() {
  int n = 40; 
  bool isFound = false;
  for (int i=0; i<n && !isFound;i++) {
    int j = 25;
    i += j;
    std::cout << "i vaut: " << i << std::endl;
    if (i > 20) {
      isFound = true;
    }
  }
  return 0;
}