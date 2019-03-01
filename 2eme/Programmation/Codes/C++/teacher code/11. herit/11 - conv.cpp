#include <iostream>

using namespace std;

class Point
{
	protected:
		int x, y;
	
	public:
		Point(int x = 0, int y = 0) : x(x), y(y) {}

		friend ostream& operator <<(ostream& out, const Point& p);

		virtual void dummy() {} //to make Point polymorphic so dynamic_cast is ok
};

ostream& operator<<(ostream& out, const Point& p)
{
	out << "( " << p.x << " , " << p.y << " )";
	return out;
}

class Pointcol : public Point
{
	short r, g, b;
	
	public:
		Pointcol(int x = 0, int y = 0, int r = 255, int g = 255, int b = 255) 
			: Point(x,y), r(r), g(g), b(b) {}

	friend ostream& operator <<(ostream& out, const Pointcol& p);			
};

ostream& operator<<(ostream& out, const Pointcol& p)
{
	out << "( " << p.x << " , " << p.y << " ) - color " << p.r << " " << p.g << " " << p.b;
	return out;
}

int main()
{	
	Point p (1,2);
	Pointcol pc (3,4,128,255,255);	
	cout << p << endl;
	cout << pc << endl;
	
	p = pc; //pp truncated : p is "really" a Point
	// pc = p; // ko
	// pc = static_cast<Pointcol>(p); //ko	
	cout << p << endl;
	cout << pc << endl;

	p  = Point(5,6); 
	Point& rp = p;
	
	pc = Pointcol(7,8,128,255,255); 
	Pointcol& rpc = pc;

	rp = rpc; //truncation	
	cout << "Reference" << endl;
	cout << p << endl;
	cout << pc << endl;
	cout << rp << endl;
	cout << (Pointcol&)rp << endl;
	cout << rpc << endl;

	p = Point(8,9);
	//rpc = rp; //ko
	rpc = static_cast<Pointcol&>(rp);// ok, but incoherent result
	// rpc = dynamic_cast<Pointcol&>(rp);//ok, launches bad_cast		

	cout << rp << endl;
	cout << rpc << endl;
	
	Point * ptp = new Point(1,2);
	Pointcol * ptpc = new Pointcol(3,4,128,255,255);

	ptp = ptpc; //no truncation
	cout << (*ptp) << endl;
	cout << (*ptpc) << endl;

	ptp = new Point(1,2);
	//ptpc = ptp; //ko	
	//ptpc = static_cast<Pointcol*>(ptp);//ok, but seg fault
	
	cout << (*ptp) << endl;
	cout << (*ptpc) << endl;

	ptp = new Pointcol(1,2,3,4,5);

	if(Pointcol * converted = dynamic_cast<Pointcol*>(ptp))
	{
		cout << (*ptp) << endl;
		cout << (*ptpc) << endl;
	}
	else
		cout << "You cannot convert this Point to a Pointcol" << endl;	
	
	delete ptp;
	delete ptpc;	
}


