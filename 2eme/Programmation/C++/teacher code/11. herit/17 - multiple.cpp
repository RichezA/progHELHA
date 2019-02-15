#include <iostream>

using namespace std;

class Point
{
	int x, y;
	
	public:
		Point(int a = 0, int b = 0) : x(a), y(b) {}

		virtual void print()
		{
			cout << "(" << x << " , " << y << ")";			
		}
};

class Color
{
	short r, g, b;

	public:
		Color(int r = 0, int g = 0, int b = 0) : r(r), g(g), b(b) {}

		virtual void print()
		{
			cout << "[" << r << " , " << g << " , " << b << "]";
		}
};

class Pointcol : public Point, public Color
{	
	public:
		Pointcol(int x = 0, int y = 0, int r = 0, int g = 0, int b = 0) 
			: Point(x,y), Color(r,g,b) {}

		void print() override
		{
			cout << "{ ";
			Point::print();
			cout << " , ";
			Color::print();
			cout << " }";
		}
};

int main()
{
	Pointcol p(1,2,100,128,255);
	p.print(); cout << endl;
	p.Point::print(); cout << endl;
	p.Color::print(); cout << endl;
	

	Color & c = p;
	c.print(); cout << endl;

	Point& pp = p;
	pp.print(); cout << endl;
}
