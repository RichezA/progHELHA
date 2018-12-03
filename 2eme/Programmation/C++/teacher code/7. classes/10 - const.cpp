#include <iostream>
#include <cmath>

using namespace std;

class Point
{
  double x, y;

  public:
    Point(int x, int y)
    {
      this->x = x;
      this->y = y;
    }

    Point(int z){
      this->x = z;
      this->y = z;
    }


    Point(const Point& p){
      this->x = p.y;
      this->y = p.x;
    }

    double getX() const
    {
      return x;
    }

    double getY() const
    {
      return y;
    }   

    double dist(Point p) const
    {
      return sqrt(((x - p.x)*(x - p.x))+((y - p.y)*(y - p.y)));
      // return sqrt((x - p.getX())*(x - p.x)+(y - p.y)*(y - p.y));
      // return sqrt((getX() - p.getX())*(x - p.x)+(y - p.y)*(y - p.y));
    }

};

int main()
{
  Point p1(2,1);
  //cout << p1.x << " " << p1.y << endl; //ko
  cout << p1.getX() << " " << p1.getY() << endl;
  Point p2(p1);
  cout << p2.getX() << " " << p2.getY() << endl;
  cout << "dist = " << p1.dist(p2) << endl;
  printf("%f", p1.dist(p2));
}
