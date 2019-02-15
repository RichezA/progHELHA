#include <iostream>

using namespace std;

struct A
{
	virtual void f(A&) { cout << "A::f(A)" << endl; }
};

struct B : A
{
	void f(A&) override { cout << "B::f(A)" << endl; }
	void f(B&) { cout << "B::f(B)" << endl; }
};

int main()
{
	A a; B b;
	A& ra = a;

	ra.f(a); 
	ra.f(b);
	
	ra = b;
	ra.f(a); 
	ra.f(b);
	cout << endl;

	// B& rb = b;
	// rb.f(a);
	// rb.f(b);

	// cout << endl;

	A& rab = b;
	rab.f(a);
	rab.f(b);

	cout << endl;
	
	A * pa = new A; B * pb = new B;

	pa->f(*pa);
	pa->f(*pb);

	cout << endl;
	
	// pb->f(*pa);
	// pb->f(*pb);

	// cout << endl;

	delete pa;	
	
	pa = pb;
	pa->f(*pa);
	pa->f(*pb);

	delete pa;
}
