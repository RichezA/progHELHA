#include <iostream>

using namespace std;

class Point
{
	protected:
		int x, y;
	
	public:
		Point(int a = 0, int b = 0) : x(a), y(b) {}

		void print()
		{
			cout << "( " << x << " , " << y << " )" << endl;
		}
};

class Pointcol : public Point
{
	short r, g, b;
	
	public:
		Pointcol(int x = 0, int y = 0, int r = 255, int g = 255, int b = 255) : Point(x,y), r(r), g(g), b(b) {}

		void print()
		{
			cout << "( " << x << " , " << y << " )" 
			     << " -- color " << r << " " << g << " " << b << endl;
		}
};

int main()
{
	Point p(3,5);
	Pointcol pc (3,5,128);
	Point * ptp = &p;
	Pointcol * ptpc = &pc;

	ptp -> print();
	ptpc -> print();
	cout << endl;

	ptp = ptpc;
	ptp -> print();
	ptpc -> print();
}
