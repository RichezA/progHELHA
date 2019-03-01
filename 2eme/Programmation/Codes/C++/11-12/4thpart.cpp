
class A
{
    int _i;

    public:
        A() : _i(2) {}
        int i() const {return _i;}

        friend class M; // class M is now a friend of class A
};

class B : public A  // B is subclass of A
{
    int _j;

    public:
        B() : _j(3) {}
        int j() const {return _j;}
};

class M // M is a friend of A but not a friend of its subclass (B)
{
    int _k;

    public:
        M(A a): _k(a._i * 2) {}
        //M(B b): _k(b._j * 2) {}
    int k() const {return _k;}
};

class N: public M   // subclasses of M are neither friends of A & B
{
    int _a;

    public:
        N(A a): M(a) /*, _a(a._i * 4)*/{}
        N(B b): M(b) /*, _a(b._j * 4)*/{}

        int a() const {return _a;}
}