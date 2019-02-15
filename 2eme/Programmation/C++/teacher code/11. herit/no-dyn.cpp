#include <iostream>

using namespace std;

class A
{
	public:
		virtual int a()
		{
			return 42;
		}
};

class B : public A
{
	int b;
	public:
		B(int b) : b(b) {}
		
		int a()
		{
			return b;
		}
};

int main()
{
	A a;
	cout << a.a() << endl;
	//cout << sizeof(a) << endl;

	B b(3);
	cout << b.a() << endl;
	//cout << sizeof(b) << endl;

	a = b;
	cout << a.a() << endl;
	//cout << sizeof(a) << endl;
}
