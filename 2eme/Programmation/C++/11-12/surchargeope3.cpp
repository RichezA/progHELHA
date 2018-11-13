#include <iostream>
#include <fstream>
#include <sstream>

class Integer
{
    int i;
    public:
        Integer(int i = 0): i(i) {}
        friend ostream& operator << (ostream &, const Integer &);

        Integer & operator ++ () { std::cout << "prefix" << std::endl; i++; return *this; } // prefix
        Integer operator ++(int)
        {
            std::cout << "suffix" << std::endl;
            Integer r = *this;
            operator++();
            return r;
        }
};
int main()
{
    Integer i(2); Integer j = i;
    std::cout << i++ << std::endl;
    std::cout << ++j << std::endl;
}