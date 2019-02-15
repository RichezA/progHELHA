#include <iostream>

using namespace std;

class Point
{
	protected:
		int x, y;
	
	public:
		Point(int a = 0, int b = 0) : x(a), y(b) {}

		Point(const Point& p) : x(p.x), y(p.y) 
		{
			cout << "+r Point" << endl;
		}

		friend ostream& operator << (ostream& out, const Point& p)
		{
			out << "( " << p.x << " , " << p.y << " )";
			return out;
		}
};

class Pointcol : public Point
{
	short r, g, b;
	
	public:
		Pointcol(int x = 0, int y = 0, int r = 0, int g = 0, int b = 0) : Point(x,y), r(r), g(g), b(b) {}		

		Pointcol(const Pointcol &p) : Point(p), r(p.r), g(p.g), b(p.g)
		{
			cout << "+r Pointcol" << endl;
		}	

		friend ostream& operator << (ostream& out, const Pointcol& p)
		{
			out << "( " << p.x << " , " << p.y << " ) - color " << p.r << " " << p.g << " " << p.b;
			return out;
		}
};

void f(Pointcol p)
{
	cout << p << endl;
}

int main()
{
	Pointcol a(1,2,255,128,128);
	f(a);
}
