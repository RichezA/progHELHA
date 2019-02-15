#include <iostream>

using namespace std;

class A
{
	public:
		void f(int n)
		{
			cout << "int " << n << endl;
		}

		void f(char n)
		{
			cout << "char " << n << endl;
		}
};

class B : public A
{
	public:
		void f(int n){
			A::f(n);
		}
		void f(char n){
			A::f(n);
		}
		void f(A a)
		{
			cout << "A " << endl;
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
