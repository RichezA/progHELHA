#include <iostream>
#include <string>
#include <sstream>

using namespace std;

class vector
{
	int n;
	double * tab;
	
	public:
		vector(int nbr)
		{
			n = nbr;
			tab = new double[n];			
		}
		
		vector(const vector & v)
		{
			n = v.n;
			tab = new double[n];	
			for(int i = 0; i < n; i++)
				tab[i] = v.tab[i];		
		}
		
		~vector()
		{
			cout << "Deleting " << *this << endl;
			delete[] tab;
		}	

		vector & operator = (const vector & v)
		{
			if(this != &v)
			{
				delete[] tab;

				n = v.n;
				tab = new double[n];
				for(int i = 0; i < n; i++)
					tab[i] = v.tab[i];
			}
			return * this;
		}

		double & operator [] (int i)
		{
			return tab[i];
		}

		friend ostream& operator <<(ostream& out, const vector& v);
};

ostream& operator<<(ostream& out, const vector& v)
{
	out << "vector " << &v << " - size = " << v.n << " " << ", array-adress : " << &(v.tab) << " -> ";
	for(int i = 0; i < v.n; i++)
		out << v.tab[i] << " ";
	return out;
}

void f(vector v)
{
	cout << "Entering f" << endl;
	cout << v << endl;
	cout << "Exiting f" << endl;
}

int main()
{
	vector a (5);
	for(int i = 0; i < 5; i++)
		a[i] = i;

	f(a);
	cout << a << endl;

	vector b (4);
	for(int i = 0; i < 4; i++)
		b[i] = i + 1;

	cout << a << endl;
	cout << b << endl;

	b = a;
	cout << b << endl;
}
