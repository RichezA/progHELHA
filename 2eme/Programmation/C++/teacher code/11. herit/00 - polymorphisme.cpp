#include <iostream>
#include <fstream>

class A
{
  public:
    virtual int foo() { return 1; }
    virtual int zork() { return this->bar(); }
    virtual int bar() { return 3; }
};
class B : public A
{
  public:
    int foo() { return A::zork(); }
};
class C : public B
{
  public:
    int zork() { return this->foo() + 5; }
    int bar() { return 7; }
};

int main()
{
    A a;
    B b;
    C *c = new C;
    std::cout << c->zork();
}