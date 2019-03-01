#include <iostream>

using namespace std;

struct A
{
	A()
	{
		cout << "+A()"<< endl;
	}

	A(int a)
	{
		cout << "+A(int)" << endl;
	}

	~A()
	{
		cout << "-A()" << endl;
	}		
};

struct B : A
{
	B()
	{
		cout << "+B()" << endl;
	}

	B(int a, int b) : A(a)
	{
		cout << "+B(int,int)" << endl;
	}
			
	~B()
	{
		cout << "-B()" << endl;
	}
};

int main()
{
	A a;
	A aa(2);
	B b;
	B bb(2,2);
}
