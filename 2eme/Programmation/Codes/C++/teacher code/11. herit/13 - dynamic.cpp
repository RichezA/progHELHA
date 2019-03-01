#include <iostream>

using namespace std;

class Point
{
	protected:
		int x, y;
	
	public:
		Point(int a = 0, int b = 0) : x(a), y(b) {}

		virtual void print()
		{
			cout << "( " << x << " , " << y << " )" << endl;
		}
};

class Pointcol : public Point
{
	protected:
		short r, g, b;
	
	public:
		Pointcol(int x = 0, int y = 0, int r = 255, int g = 255, int b = 255) : Point(x,y), r(r), g(g), b(b) {}

		void print()
		{
			cout << "( " << x << " , " << y << " )" 
			     << " -- color " << r << " " << g << " " << b << endl;
		}

		bool isRed(){
			return this->r == 255;
		}

};

class PointcolBrillant : public Pointcol {
	bool estBrillant;
	
	public:
		PointcolBrillant(int x = 0, int y = 0, int r = 255, int g = 255, int b = 255, bool brille = false) : Pointcol(x,y,r,g,b), estBrillant(brille) {}

		void print()
		{
			cout << "( " << x << " , " << y << " )" 
			     << " -- color " << r << " " << g << " " << b 
			     << " -- est Brillant " << estBrillant << endl;
		}

};

int main()
{
	Point p(3,5);
	Pointcol pc (3,5,128);
	PointcolBrillant pcb;

	Point * ptp = &p;
	Pointcol * ptpc = &pc;

//	ptpc = ptp;

	cout << ptpc->isRed();
	
	ptp -> print();
	ptpc -> print();
	cout << endl;

	ptp = ptpc;
	ptp -> print();
	ptpc -> print();

}
