#include <iostream>

using namespace std;

struct A
{
	void f() //inline
	{
		cout << "Brol::f" << endl;
	}
};

struct B
{
	inline void f();//inline
};

void B::f()
{
	cout << "Foo::f" << endl;//defined in same file
}

inline double sum(double a, double b)//inline
{
	return a + b;
}

struct C
{
	 void f();//not inline
};

//try to add 'inline' keyword on C::f
