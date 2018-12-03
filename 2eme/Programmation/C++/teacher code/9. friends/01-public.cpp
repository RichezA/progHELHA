#include <iostream>
#include <cmath>
#include <string>
#include <sstream>

using namespace std;

class Point
{	
	public :
		double x,y;

		Point(double abs=0, double ord=0) : x(abs), y(ord) {}

		double distance(Point p)
		{
			return sqrt((x - p.x) * (x - p.x) 
				+ (y - p.y) * (y - p.y));
		}

		string toString()
		{
			stringstream str;
			str << "( " << x << " , " << y << " )";		
			return str.str();
		}
};

class Circle
{
	Point& center;
	double radius;

	public :
		Circle(Point& p, double rad) : center(p), radius(rad) {}

		inline void translate(double x, double y)
		{
			center.x += x;
			center.y += y;
		}

		string toString()
		{			
			stringstream str;
			str << "Circle of center " << center.toString() << " and of radius " << radius;
			return str.str();
		}
};

int main()
{
	Point p (1,1);
	Circle c (p, 2);

	cout << p.toString() << endl;
	cout << c.toString() << endl;

	c.translate(1,-1);

	cout << p.toString() << endl;
	cout << c.toString() << endl;	
}
