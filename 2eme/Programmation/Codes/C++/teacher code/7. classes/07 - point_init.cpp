#include <iostream>
#include <cmath>

using namespace std;

class Point
{
	double x, y;
	const int z;

	public:
		Point(int w = 0, int v = 0, int u = 0) : z(u) {
			x = w;
			y = v;
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
			return sqrt((x - p.x)*(x - p.x)+(y - p.y)*(y - p.y));
		} 	
};

int main()
{
	Point p1(1,1);
	//cout << p1.x << " " << p1.y << endl; //ko
	cout << p1.getX() << " " << p1.getY() << endl;
	Point p2(2,2);
	cout << p2.getX() << " " << p2.getY() << endl;
	cout << "dist = " << p1.dist(p2) << endl;
}
