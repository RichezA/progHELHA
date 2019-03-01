#include <iostream>

using namespace std;

class A
{
	public:
		virtual void f(int n)
		{
			cout << "int " << n << endl;
		}

		virtual void f(char n)
		{
			cout << "char " << n << endl;
		}
};

class B : public A
{
	public:
		void f(float x)
		{
			cout << "float " << x << endl;
		}
};

int main()
{
	int n = 1;
	char c = 'a';
	A a;
	B b;
	
	a.f(n);
	a.f(c);
	b.f(n);
	b.f(c);
}
