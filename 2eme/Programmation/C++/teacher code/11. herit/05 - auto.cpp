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
			cout << "( " << x << " , " << y << " )" <<endl;
		}
};

class Pointcol : public Point
{
	short r, g, b;
	
	public:
		Pointcol(int x = 0, int y = 0, int r = 255, int g = 255, int b = 255) : Point(x,y), r(r), g(g), b(g) {}

		void print()
		{
			cout << "( " << x << " , " << y << " ) - color : "
			     << r << " , " << g << " , " << b << endl;
		}

		void print2()
		{
			cout << "Print 2" << endl;
		}
};
class A {

};
int main()
{
	Point p(3,5);	
	Pointcol pc (8,6,255,128,128);	

	p.print();
	pc.print();

	p = pc; 
	p.print();

	Point * ptp = &p;
	Pointcol * ptpc = &pc;
	ptp = ptpc;
	ptp -> print();
	((Pointcol *)ptp) -> print2();	
}






