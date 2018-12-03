#include <iostream>
#include <cstddef>

using namespace std;

class Point
{
	static int n;
	static int nd;


	public:
		int x, y;
		Point(int abs=0, int ord=0) : x(abs), y(ord)
		{
			n++;
			cout << "(+) Number of Points : " << n << endl;
		}

		~Point()
		{
			n--;
			cout << "(-) Number of Points : " << n << endl;
		}

		void * operator new(size_t size)
		{
			nd++;
			cout << "(+) Number of dynamic Points : " << nd << endl;
			
			// return malloc(size);
			return ::new char[size];
		}

		void operator delete(void * pt)
		{
			nd--;
			cout << "(-) Number of dynamic Points : " << nd << endl;
			::operator delete(pt);
		}
};

int Point::n = 0;
int Point::nd = 0;

void * operator new(size_t size)  throw(bad_alloc)
{
	cout << "NEW - size allowed : " << size << endl;
	return malloc(size);
}

void operator delete(void * pt) _NOEXCEPT
{
	cout << "DELETE" << endl;
	return free(pt);
}


int main()
{
	Point * pt1, * pt2;
	Point a(3,5);
	
	pt1 = new Point(1,3);
	cout << pt1->x << endl;
	Point b;
	pt2 = new Point(2,0);
	delete pt1;
	Point c(2);
	delete pt2;
}
