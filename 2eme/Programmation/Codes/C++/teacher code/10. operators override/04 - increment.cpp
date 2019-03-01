#include <iostream>

using namespace std;

class Integer
{
	int i;
	public:
		Integer(int i = 0) : i(i) {}
		friend ostream& operator <<(ostream&, const Integer&);

		Integer& operator ++() //prefix
		{ 
			cout << "prefix" << endl; 
			i++; 
			return *this; 
		}

		Integer operator ++(int) //suffix
		{ 
			cout << "suffix" << endl; 
			Integer r = *this; 
			operator++(); 
			return r;
		}
};

ostream& operator << (ostream& out, const Integer& i)
{
	out << i.i;
	return out;
}

int main()
{
	Integer i(2);
	Integer j = i;

	cout << i++ << endl;
	cout << ++j << endl;
	return 0;
}
