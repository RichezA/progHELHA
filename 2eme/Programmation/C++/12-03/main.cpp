#include <iostream>
#include <fstream>

#pragma region Heritage
// class Chef
// {
//   public:
//     ~Chef() {}
//     virtual void MakeChicken()
//     {
//         std::cout << "a" << std::endl;
//     }
// };

// class ItalienChef : public Chef
// {
//   public:
//     void MakeChicken()
//     {
//         std::cout << "Mah la pizza with chicken ! " << std::endl;
//     }
// };

// int main()
// {

//     Chef chef;
//     chef.MakeChicken();

//     ItalienChef chef2;
//     chef2.MakeChicken();

//     Chef *chef3 = &chef;
//     chef3->MakeChicken();

//     Chef *chef4 = (Chef *)&chef2;
//     chef4->MakeChicken();
// }
#pragma endregion

#pragma region Polymorphisme
/*class A
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
}*/
#pragma endregion

#pragma region Overload &Overide
class ABC
{
  protected:
    double i = 3.25;

  public:
    //overloading
    int a(int n)
    {
        return (int)i;
    }
    virtual double a(double n)
    {
        return i + n;
    }
};
class DEF : ABC
{
  public:
    //overiding
    double a(int n)
    {
        return i + n;
    }
};
int main()
{
    ABC a;
    DEF b;
    std::cout << a.a(2) << std::endl;
    std::cout << a.a(2.3) << std::endl;
    std::cout << b.a(5) << std::endl;
}
#pragma endregion