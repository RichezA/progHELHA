#include <iostream>

using namespace std;

class B;

class A
{
	int _i;
	
	public:
		A(int i) : _i(i) {}
		int i() const { 
			C c;
			c.m();
			return _i; }
		int bJ(B& b) const;

		friend class B;
};

class B
{
	A a;
	int _j;
	
	public:
		B(A a, int j) : a(a), _j(j) {}

		int brol() const { return a._i * _j; }	
		friend class A;
};

int A::bJ(B& b) const{
	 return b._j;
}

int main()
{
	A a(4);
	B b(a, 3);
	cout << b.brol() << endl;
}
