#include <iostream>

using namespace std;

class A 
{ 
	protected: 
		int i; 
  public: // try to comment this line
		A(int i = 0) : i(i) {}
};

class B : public A 
{
	public:		
		using A::i;
		using A::A; // try to comment this line
};

int main()
{
	B b(4); cout << b.i << endl;
	b.i = 3; cout << b.i << endl;
}
