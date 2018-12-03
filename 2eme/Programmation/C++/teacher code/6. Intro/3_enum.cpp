#include <iostream>

int main() {
  enum Color { red, green, blue };
  Color r = red;
  switch(r)
  {
      case red  : std::cout << green << "red\n";   break;
      case green: std::cout << "green\n"; break;
      case blue : std::cout << "blue\n";  break;
  }
  return 0;
}