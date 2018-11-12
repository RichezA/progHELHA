
using namespace std;

class B;

class A
{
    class C
    {
      public:
        void m() {}
    };
    int _i;

  public:
    A(int i) : _i(i) {}
    int i() const
    {
        C c;
        c.m();
        return _i;
    }
    int bJ(B &b) const;
};