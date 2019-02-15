#include <iostream>

using namespace std;

struct A
{
	A() { cout << "+A" << endl; }
	A(const A& a) { cout << "rA" << endl; }
	virtual ~A() { cout << "-A" << endl; }
};

struct B
{
	B() { cout << "+B" << endl; }
	B(const B& a) { cout << "rB" << endl; }
	virtual ~B() { cout << "-B" << endl; }
};

struct C : public B, public A
{
	C() { cout << "+C" << endl; }
	C(const C& a) { cout << "rC" << endl; }
	virtual ~C() { cout << "-C" << endl; }
};

void f(A a)
{
}

int main()
{
	C c;
	cout << endl;
	f(c);
	cout << endl;
	C * cc = new C();
	cout << endl;
	delete cc;
	cout << endl;
}
