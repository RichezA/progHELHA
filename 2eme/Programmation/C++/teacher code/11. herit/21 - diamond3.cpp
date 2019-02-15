#include <iostream>

using namespace std;

struct A
{
	int i;
	A(int i = 0) : i(i) 
	{
		cout << "+A " << i << endl;
	}
};

struct B1 : virtual A
{
	B1(int j) : A(j)
	{
		cout << "+B1 " << i << endl;
	}
};

struct B2 : virtual A
{
	B2(int j) : A(j)
	{
		cout << "+B2 " << i << endl;
	}
};

struct C : B1, B2
{
	C(int j1 = 0, int j2 = 0) : A((j1 + j2) / 2)
	{
		cout << "+C" << endl;
	}
};

int main()
{
	C c (1, 7);
	cout << endl;

	cout << c.i << endl;
	cout << c.B1::i << endl;
	cout << c.B2::i << endl;
}
