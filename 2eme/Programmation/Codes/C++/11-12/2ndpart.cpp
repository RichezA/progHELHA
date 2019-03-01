#include <iostream>

class A;

class B
{
    public:
        void fB(A &a);
};

class A
{
    int _i;

  public:
    friend void fA(A &a);   // friend of A, not a member function !
    friend void B::fB(A &a); // can now be used in the class B cuz it's now a friend of A
    int bJ(B &b) const;
};

void fA(A &a)
{
    a._i = 22;
    std::cout << a._i << std::endl;
}
void B::fB(A& a)    // this function should be defined after definition of class A
{
    a._i = 22;
    std::cout << a._i << std::endl;
}

int main()
{
    A a;
    fA(a); // calling friend function of the class A

    B b;
    b.fB(a); // calling B class emmber function fB, B::fB is a friend of the class A
}