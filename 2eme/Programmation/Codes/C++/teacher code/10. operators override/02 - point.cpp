#include <iostream>

using namespace std;

class Point
{
	double _x, _y;

	public:
		Point(double x = 0, double y = 0) : _x(x), _y(y) {}

		inline double x() const { return _x; }
		inline double y() const { return _y; }

		friend ostream& operator << (ostream& out, const Point& p);
};

ostream& operator << (ostream& out, const Point& p)
{
	out << "(" << p._x << " , " << p._y << ")";
	return out;
}

int main()
{
	Point p;
	cout << p << endl;
	p = Point(2,3);
	cout << p << endl;
}
