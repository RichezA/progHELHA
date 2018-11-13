#include <iostream>
#include <fstream>
#include <cstring>

class Rationnel
{
    int _num, _denom;

  public:
    Rationnel(int num, int denom) : _num(num), _denom(denom) {}
    Rationnel(): _num(1), _denom(2) {}
    void affiche() { std::cout << this->_num << "/" << this->_denom << std::endl; }
    void setNumDenom(int num, int denom)
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
    void calculInverse()
    {
        int tmp;
        if(this->_num == 0) std::cout << "le dénominateur ne peut pas etre egal a 0" << std::endl;
        else
        {
            tmp = this->_num;
            this->_num = this->_denom;
            this->_denom = tmp;
            std::cout << "L'inverse de la fraction est: " << this->_num << "/" << this->_denom << std::endl;
        }
    }
    void egalite(Rationnel &r)
    {
        if((this->_num/this->_denom) == (r._num/r._denom))
                std::cout << "Les deux fractions sont égales" << std::endl;
        else if((this->_num/this->_denom) > (r._num/r._denom))
            std::cout << "La première fonction est plus grande que la deuxieme" << std::endl;
        else if((this->_num/this->_denom) < (r._num/r._denom))
            std::cout << "La premiere fonction est la plus petite que la deuxieme" << std::endl;
    }
    Rationnel operation(Rationnel &r1,Rationnel &r2, const char &c)
    {
        int tmp;
        switch(c)
        {
            case '+':
                r1._num *= r2._denom;
                r2._num *= r1._denom;
                r1._num += r2._num;
                r1._denom *= r2._denom;
                break;
            case '-':
                r1._num *= r2._denom;
                r2._num *= r1._denom;
                r1._num -= r2._num;
                r1._denom *= r2._denom;
                break;
            case '*':
                r1._num *= r2._num;
                r1._denom *= r2._denom;
                break;
            case '/':
                int tmp;
                tmp = r2._num;
                r2._num = r2._denom;
                r2._denom = tmp;
                r1.operation(r1, r2, '*');
                break;
            default:
                std::cout << "Opération non connue" << std::endl;
                break;
        }
        return r1;
    }
};

int main()
{
    Rationnel r1(1, 3);
    Rationnel r2;
    r1.operation(r1, r2, '/');
    r1.affiche();
    /*r1.egalite(r2);
    r1.affiche();
    r1.setNumDenom(5, 3);
    r1.egalite(r2);
    r1.affiche();
    r1.calculInverse();
    r1.setNumDenom(5, 0);
    r1.affiche();
    r2.affiche();*/
}