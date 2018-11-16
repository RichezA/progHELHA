#include "rationnelHeader.hpp"

unsigned int pgcd(unsigned int a, unsigned int b); // function proto

Rationnel::Rationnel(int num, int denom) : _num(num), _denom(denom) {}
Rationnel::Rationnel() : _num(0), _denom(1) {}
int Rationnel::num() { return _num; }
int Rationnel::denom() { return _denom; }
void Rationnel::show(std::ostream &out) const
{
    out << this->_num << "/" << this->_denom << std::endl; // take the stream and modify the stream as your convenience
}
void Rationnel::setNumDenom(int num, int denom)
{
    if (denom > 0 || denom < 0)
    {
        this->_num = num;
        this->_denom = denom;
    }
    else
    {
        std::cout << "le denominateur ne peut pas etre egal a 0" << std::endl;
        this->_num = 0;
        this->_denom = 1;
    }
}
void Rationnel::swap()
{
    int tmp = this->_num;      // num
    this->_num = this->_denom; // denom
    this->_denom = tmp;
}
Rationnel &Rationnel::simplify()
{
    int pgcd = 1;
    for (int i = 2; i <= this->_num || i <= this->_denom; i++)
    {
        if (this->_num % i == 0 && this->_denom % i == 0)
            pgcd = i;
    }
    this->_num = _num / pgcd;
    this->_denom = _denom / pgcd;
    return *this;
}