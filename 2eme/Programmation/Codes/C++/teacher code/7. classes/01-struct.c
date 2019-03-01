#include <stdio.h>

struct Coordonnees{

  int x;
  int y;

  // int getX(){
  //   return x;
  // }

  // int getY(){
  //   return y;
  // }

};

typedef struct Coordonnees Coordonnees;

int main(){
  Coordonnees p;
  p.x = 10;
  p.y = 20;
  printf("(%d,%d)\n", p.x, p.y);
  return 0;
}
