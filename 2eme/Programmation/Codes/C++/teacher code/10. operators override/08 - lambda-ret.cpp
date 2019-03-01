#include <iostream>

using namespace std;

struct A { int i; };

int main()
{
	A a; a.i = 1; A b; b.i = 2;
	
	auto f = [&a, b] (int i) 
		{
			int k = a.i + b.i + i;
			a.i += 3;
			//b.i += 3; //no, b is read-only

			return k;
		};

	cout << f(4) << endl;
	cout << a.i << " " << b.i << endl;
}
