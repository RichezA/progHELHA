#include <iostream>

using namespace std;

struct Coordonnees{

  int x;
  int y;

public:

  int getX(){
    return this->x;
  }

  int getY(){
    return y;
  }

  void setX(int x){
    this->x = x;
  }

  void setY(int y){
    this->y = y;
  }

};

// typedef struct Coordonnees Coordonnees; // inutile en C++

int main(){
  Coordonnees p;
  cout << p.getX() << " " << p.getY() << endl;
  p.x = 10; // Interdit ! x est privé
  p.setX(10);
  p.setY(20);
  cout << "(" <<  p.getX() << "," << p.getY() << ")" << endl;
  return 0;
}
