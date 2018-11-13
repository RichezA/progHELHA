#include <iostream>
#include <fstream>

class Rationnel
{
    int _num, _denom;

  public:
    Rationnel(int num, int denom) : _num(num), _denom(denom) {}
    Rationnel() : _num(1), _denom(2) {}
    void affiche() { std::cout << this->_num << "/" << this->_denom << std::endl; }
    void setNum(int num)
    {
        this->_num = num;
    }
    void setDenom(int denom)
    {
        if (denom > 0 || denom < 0)
            this->_denom = denom;
        else
        {
            std::cout << "le denominateur ne peut pas etre egal a 0" << std::endl;
            this->_num = 0;
            this->_denom = 1;
        }
    }
};

int main()
{
    Rationnel r1(1, 2);
    r1.affiche();
    r1.setNum(5);
    r1.setDenom(3);
    r1.affiche();
    r1.setDenom(0);
    r1.affiche();
    Rationnel r2();
    r2.affiche();
}