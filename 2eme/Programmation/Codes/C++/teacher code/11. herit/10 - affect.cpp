#include <iostream>

using namespace std;

class Point
{
	protected:
		int x, y;
	
	public:
		Point(int a = 0, int b = 0) : x(a), y(b) {}		

		Point & operator =(const Point& p)
		{
			if(this != &p)
			{
				x = p.x;
				y = p.y;
				cout << "= Point" << endl;
			}
			return *this;
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

		
		Pointcol & operator =(const Pointcol& p)
		{
			if(this != &p)
			{					
				Point * p1 = this;//polymorphism mandatory for *p1=*p2
				const Point* p2 = &p;//polymorphism, const allows p2=&p
				*p1 = *p2;//affectation in Point

				r = p.r; //writing affectation in Pointcol
				g = p.g;
				b = p.b;
				cout << "= Pointcol" << endl;
			}
			return *this;
		}

		friend ostream& operator << (ostream& out, const Pointcol& p)
		{
			out << "( " << p.x << " , " << p.y << " ) - color " << p.r << " " << p.g << " " << p.b;
			return out;
		}
};

int main()
{
	Pointcol p1(1,2,25, 12, 15);
	Pointcol p2(4,5,255, 128, 5);

	cout << p1 << endl;
	cout << p2 << endl;
	cout << endl;

	p2 = p1;
	cout << p1 << endl;
	cout << p2 << endl;	

	Pointcol * pt1 = new Pointcol(1,2,25,12,15);
	Pointcol * pt2 = new Pointcol(4,5,255,128,5);

	delete pt1;

	pt1 = pt2;	
	cout << *pt1 << endl;
	cout << *pt2 << endl;

	delete pt1;
}
