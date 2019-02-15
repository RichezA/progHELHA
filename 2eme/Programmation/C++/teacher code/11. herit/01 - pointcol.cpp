#include <iostream>

using namespace std;

class Point
{
	int x, y;
	
	public:
		Point(int x = 0, int y = 0) : x(x), y(y) {}
		
		void setLocation(int x, int y)
		{
			this -> x = x;
			this -> y = y;
		}

		friend ostream& operator <<(ostream& out, const Point& p);
};

ostream& operator <<(ostream& out, const Point& p) {
	out << "( " << p.x << " , " << p.y << " )";
	return out;
}	

class Pointcol : public Point
{
	short r, g, b;
	
	public:
		Pointcol(int x, int y, short r, short g, short b) : Point(x,y), r(r), g(g), b(b) {}
};

int main()
{
	Pointcol p(1,2,80,0,0);
	cout << p << endl;

	p.setLocation(3,4);
	cout << p << endl;
}
