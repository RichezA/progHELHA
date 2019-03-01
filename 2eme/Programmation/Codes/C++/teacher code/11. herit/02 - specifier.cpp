#include <iostream>

using namespace std;

class A
{	
	public:
		void printA() { cout << "A"; }
};

class B : public A
{
	public:
		void printB() 
		{ 
			printA(); //ok : printA is a public member of this
			cout << "B";
		}
};

////////////////////////////////////////////
class C : private A
{
	public:
		void printC() 
		{ 
			printA(); //ok : printA is a private member of this
			cout << "C";
		}
};

class D : public C
{
	public:
		void printD()
		{
			//printA(); //ko : printA is a private member of superclass
			cout << "D";
		}	
};
/////////////////////////////////////////////

class E : protected A
{
	public:
		void printE() 
		{ 
			printA(); //ok : printA is a protected member of this
			cout << "E"; 
		}
};

class F : public E
{
	public:
		void printF()
		{
			printA(); //ok : printA is a protected member of superclass
			cout << "F";
		}	
};

/////////////////////////////////////////////

int main()
{
	A a; a.printA(); cout << endl;
	B b; b.printB(); b.printA(); cout << endl; //ok : printA is a public member of B
	C c; c.printC(); cout << endl; //c.printA(); //ko : printA is a private member of C
	D d; d.printD(); cout << endl; //d.printA(); //ko : printA is a private member of D
	E e; e.printE(); cout << endl; //e.printA(); //ko : printA is a protected member of E
	F f; f.printF(); cout << endl; //f.printA(); //ko : printA is a protected member of F
}
