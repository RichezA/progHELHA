#include <iostream>

using namespace std;

class M;

class A
{
	int _i;
	
	public:
		A() : _i(2) {}
		int i() const { return _i; }

		friend class M; //class M is a friend of A
};

class B : public A
{
	int _j;
	
	public:
		B() : _j(3) {}
		int j() const { return _j; }
};

//M is a friend of A and not a friend of its children
class M
{
	int _k;

	public:
		M(A a) : _k(a._i * 2) {}
		//M(B b) : _k(b._j * 3) {}

		int k() const { return _k; }
};

//children of M are neither friends of A or B
class N : public M
{
	int _l;

	public:
		N(A a) : M(a)/*, _l(a._i * 4)*/ {}
		N(B b) : M(b)/*, _l(b._j * 5)*/ {}

		int l() const { return _l; }
};

int main()
{
	A a;
	B b;
	M ma(a);
	M mb(b);
}
