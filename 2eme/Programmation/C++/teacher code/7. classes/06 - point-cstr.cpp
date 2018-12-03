#include <iostream>
#include <cmath>

using namespace std;

class Point
{
	double x, y;
	bool copie;

	public:
		Point(int x = 1, int y = 1)
		{
			this->copie = false;
			this->x = x;
			this->y = y;
		
			cout << "Construction de " << x << " " << y << endl;
		}

		Point(const Point& p)
		{
			this->copie = true;
			this-> x = p.x;
			this-> y = p.y;
		
			cout << "Copie de " << x << " " << y << endl;
		}	

		~Point()
		{
			cout << "Destruction de " << x << " " << y;
			if(copie)
				cout << " (copie)";
			cout << endl;
		}

		double getX() const
		{
			return x;
		}

		double getY() const
		{
			return y;
		}

		double dist(Point p) const
		{
			return sqrt((x - p.x)*(x - p.x)+(y - p.y)*(y - p.y));
		}

		void setX(int x){
			this->x = x;
		}
};

void sayHello(const Point& p)//fct indep
{
	cout << "Hello Mr point " << p.getX() << " " << p.getY() << endl;
}

int main()
{
	Point p1;
	Point p2(2,2);
	cout << "Dans le main : " << p1.getX() << " " << p1.getY() << endl;
	sayHello(p1);
	cout << "Dans le main : " << p2.getX() << " " << p2.getY() << endl;
	cout << "dist = " << p1.dist(p2) << endl;
	
	Point p3(p1);//explicit copy
//	p3 = p2; // implicit copy
	p3.setX(3);
	cout << "Dans le main : " << p2.getX() << " " << p2.getY() << endl;

	//try to remove default params and call default cstr
}
