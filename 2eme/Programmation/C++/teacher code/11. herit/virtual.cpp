#include <iostream>

using namespace std;


class AA
{
	public:
		AA() {	cout << "+AA" << endl;	}
};

class A : public AA
{	
	public:
		int a;
		A() { cout << "Def A" << endl; }
		A(int a) : a(a) { cout << "+A" << endl; }
};

class B : public virtual A
{	
	public:
		int b;
		B(int a = 2, int b = 1) : A(a), b(b) { cout << "+B" << endl; }
};

class C : public virtual A
{	
	public:
		int c;
		C(int a = 3, int c = 2) : A(a), c(c) { cout << "+C" << endl; }
};

class D : public B, public C
{	
	public:
		int d;
		D(int a = 4, int b = 5, int c = 6, int d = 7) : A(d), B(b,c), C(c,d), d(a) { cout << "+D" << endl; }
};

int main()
{
	D d(1,2,3,4);/*
	cout << "a_D = " << d.a << endl;
	cout << "a_B = " << d.B::a << endl;
	cout << "a_C = " << d.C::a << endl;
	cout << "a_A = " << d.A::a << endl; //olé*/
}
