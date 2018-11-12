

class B;

class A 
{
  int _i;

  public:
      A(int i) : _i(i) {}
      int i() const { return _i;}

      friend class B;
};

class B
{
    A a;
    int _j;

    public:
        B(A a, int j): a(a), _j(j) {}
        int brol() const {return a._i * this->_j;}
};