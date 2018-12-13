#include <iostream>
using namespace std;

class Point
{
	int x, y;
	
	public:
		Point(int abs = 0, int ord = 0)  : x(abs), y(ord) {}
		bool coincide(const Point& p) {
			return ((p.x == this->x) && (p.y == this->y));
		}
		friend bool coincide(const Point &, const Point &);
};

int main()
{
	Point a(1,0), b(1), c;
	if(a.coincide(b))
		cout << "a coincide avec b" << endl;
	else
		cout << "a et b sont différents" << endl;

	if(coincide(a,b))
		cout << "a coincide avec b" << endl;
	else
		cout << "a et b sont différents" << endl;
		
	if(coincide(a,c))
		cout << "a coincide avec c" << endl;
	else
		cout << "a et c sont différents" << endl;
}

bool coincide(const Point &p, const Point &q)
{
	return ((p.x == q.x) && (p.y == q.y));
}
