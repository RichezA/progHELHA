#include <iostream>

using namespace std;

class Point {

  int x;
  int y;
  static int nbPoints;

  static void incNbPoints(){
    nbPoints ++;
  }

public:

  Point(int x = 0, int y = 0) : x(x), y(y) {
    incNbPoints();
  }

  static int getNbPoints();

};

int Point::getNbPoints(){
  return nbPoints;
}

int Point::nbPoints = 0;

int main(){
  Point p1;
  Point p2;

  cout << "Nb points : " << Point::getNbPoints() << endl;
}

