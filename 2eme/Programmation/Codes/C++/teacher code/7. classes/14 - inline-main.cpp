#include <iostream>
#include "14 - inline.h"

using namespace std;

int main()
{
	A a;
	a.f();

	B b;
	b.f();

	C c;
	c.f();

	cout << sum(2,3) << endl;
}
