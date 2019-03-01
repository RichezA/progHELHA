#include <iostream>

using namespace std;

struct A
{
	int i;	

	// A() : i(3) {
	// 	cout << "Constructeur par défault" << endl;
	// }

	A(int i) : i(i) {
		cout << "Constructeur avec paramètre" << endl;
	}

	A(const A& a) {
		i = a.i;
		cout << "Copie" << endl;
	}
};

struct B
{
	A a;
	B(A a) //ko
	{
	}	
};

int main()
{	
	A a(2);
	B b(a);
}
