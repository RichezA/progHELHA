#include <iostream>
#include <sstream>
#include <cmath>

using namespace std;

class Fraction
{
	unsigned num, denom;
	bool positive;

	public:
		Fraction(int num = 0, int denom = 1);
		Fraction(unsigned num, unsigned denom, bool positive);

		// Fraction operator *(Fraction f) const;
		friend Fraction operator *(const Fraction& f1, const Fraction& f2);
		
		string toString()
		{
			stringstream str;
			if(! positive)
				str << "-";
			str << num << " / " << denom;
			return str.str();
		}
		friend ostream& operator << (ostream& out, const Fraction& f);
};

ostream& operator << (ostream& out, const Fraction& f)
{
	if(! f.positive)
		out << "-";
	out << f.num << " / " << f.denom;
	return out;
}

Fraction::Fraction(int num, int denom) 
	: num(abs(num)), denom(abs(denom)), positive((num >= 0 && denom >= 0) || (num <= 0 && denom <= 0))
{}

Fraction::Fraction(unsigned num, unsigned denom, bool positive) 
	: num(num), denom(denom), positive(positive)
{}

// Fraction Fraction::operator *(Fraction f) const
// {
// 	return Fraction(this->num * f.num, denom * f.denom, 
// 		(positive == f.positive));
// }


Fraction operator*(const Fraction& f1, const Fraction& f2)
{
	return Fraction(f1.num * f2.num, f1.denom * f2.denom, 
		(f1.positive == f2.positive));
}


int main()
{
	Fraction f1 (2,3,true);// 2/3
	Fraction f2 (-4,5); //- 4 / 5
	
	Fraction f3 = f1 * f2;
	cout << f3.toString() << endl << f3 << endl;

	cout << (f1 * f2 * f3).toString() << endl; //track what happens with prints
}
