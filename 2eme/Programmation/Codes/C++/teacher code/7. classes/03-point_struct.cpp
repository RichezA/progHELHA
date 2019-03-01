#include <iostream>
#include <cmath>

using namespace std;

struct Point
{			
	Point(int x, int y)
	{
		this->x = x;
		this->y = y;
	}

	double getX()
	{
		return x;
	}

	double getY()
	{
		return y;
	}		

	double dist(Point p)
	{
		return sqrt((x - p.x)*(x - p.x)+(y - p.y)*(y - p.y));
	} 	

	private:
		double x, y;
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
