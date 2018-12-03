#include <iostream>
#include <cmath>

using namespace std;

class Point
{
	private:
		double x, y;
		double getX2(){
			return this->x;
		}
	public:
		Point(int x=2, int y=4)
		{
			this->x = x;
			this->y = y;
		}

		double getX()
		{
			return getX2();
		}
		void setX(int x) {
			this->x = x;
		}

		double getY()
		{
			return y;
		}		

		double dist(Point p)
		{
			return sqrt((x - p.x)*(x - p.x)+(y - p.y)*(y - p.y));
		} 	
};
void f(Point& p) {
	p.setX(40);
	cout << "p.x = " << p.getX() << endl;
}
int main()
{
	Point p1(1,1);
	//cout << p1.x << " " << p1.y << endl; //ko
	cout << p1.getX() << " " << p1.getY() << endl;
	Point p2(2,2);
	cout << p2.getX() << " " << p2.getY() << endl;
	cout << "dist = " << p1.dist(p2) << endl;
	f(p1);
	cout << "p1.x = " << p1.getX() << endl;
}
