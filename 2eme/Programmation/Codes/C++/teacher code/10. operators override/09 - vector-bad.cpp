#include <iostream>
#include <string>
#include <sstream>

using namespace std;

class vactor
{
	int n;
	double * tab;
	
	public:
		vactor(int nbr)
		{
			n = nbr;
			tab = new double[n];			
		}		
		
		~vactor()
		{
			cout << "Deleting " << *this << endl;
			delete[] tab;
		}	

		double & operator [] (int i)
		{
			return tab[i];
		}

		friend ostream& operator <<(ostream& out, const vactor& v);
};

ostream& operator<<(ostream& out, const vactor& v)
{
	out << "vactor " << &v << " - size = " << v.n << " " << ", array-adress : " << &(v.tab) << " -> ";
	for(int i = 0; i < v.n; i++)
		out << v.tab[i] << " ";
	return out;
}

void f(vactor v)
{
	cout << "Entering f" << endl;
	cout << v << endl;
	cout << "Exiting f" << endl;
}

int main()
{
	vactor a (5);
	for(int i = 0; i < 5; i++)
		a[i] = i;

	f(a);
	cout << a << endl;//behaviour undefined	

	vactor b (4);
	for(int i = 0; i < 4; i++)
		b[i] = i + 1;

	cout << a << endl;
	cout << b << endl;

	b = a;//behaviour undefined
	cout << b << endl;	
}
