#include <iostream>

using namespace std;

class A
{
	public:
		void f(int n)
		{
			cout << "A::int " << n << endl;
		}

		void f(char n)
		{
			cout << "char " << n << endl;
		}
};

class B : public A
{
	public:
		void f(int n)
		{
			cout << "B::int " << n << endl;
		}
};

int main()
{
	int n = 1;
	char c = 'a';
	B b;
	
	b.f(n);
	b.f(c);
}
