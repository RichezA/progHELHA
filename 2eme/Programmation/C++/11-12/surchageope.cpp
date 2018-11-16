#include <iostream>
#include <cmath>

using namespace std;

class Fraction
{
    unsigned num, denom;
    bool positive;

  public:
    Fraction(int num = 0, int denom = 0);
    Fraction(unsigned num, unsigned denom, bool positive);

    Fraction operator*(Fraction f) const; //member
                                          //friend Fraction operator *(Fraction f1, Fraction f2); //indep
};

Fraction::Fraction(int num, int denom) : num(abs(num)), denom(abs(denom)),
                                         positive((num >= 0 && denom > 0) || (num <= 0 && denom < 0)) {}

Fraction::Fraction(unsigned num, unsigned denom, bool positive) : num(num), denom(denom), positive(positive) {}

Fraction Fraction::operator*(Fraction f) const
{
    return Fraction(num * f.num, denom * f.denom, // overflow unsafe gcd &lcm
                    (positive == f.positive));
}
class Point
{
    double _x, _y;

  public:
    Point(double x = 0, double y = 0) : _x(x), _y(y) {}
    inline double x() const { return _x; }
    inline double y() const { return _y; }

    friend ostream &operator<<(ostream &out, const Point &p);
};

ostream &operator<<(ostream &out, const Point &p)
{
    out << "(" << p._x << " , " << p._y << ")";
    return out;
}
int main()
{
    Point p(2, 4);
    int b, c;
    //int a = add(b, c);
    //int a = b.add(c);
    //int a = b + c;
    std::cout << p << std::endl;
}