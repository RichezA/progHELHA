#include <iostream>

using namespace std;

class A
{	
	public:
		int a;
		A(int a = 1) : a(a) { cout << "+A" << endl; }
};

class B : public A
{	
	public:
		int b;
		B(int a = 2, int b = 1) : A(a), b(b) { cout << "++B" << endl; }
};

class C : public A
{	
	public:
		int c;
		C(int a = 3, int c = 2) : A(a), c(c) { cout << "++C" << endl; }
};

class D : public B, public C
{	
	public:
		int d;
		D(int a = 4, int b = 5, int c = 6, int d = 7) : B(a,b), C(b,c), d(d) {  cout << "+++D" << endl; }
};

int main()
{
	D d(1,2,3,4);
	//cout << "a_D = " << d.a << endl; //normal
	//cout << "a_B = " << d.B::a << endl;
	//cout << "a_C = " << d.C::a << endl;
	cout << "a_A = " << d.A::a << endl; //olé
}
