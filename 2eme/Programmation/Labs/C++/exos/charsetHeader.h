class CharSet
{
    static const int LENGTH = 256;
    unsigned char tab[LENGTH];
    static int index;
    static int next;

  public:
    CharSet();
    ~CharSet();
    CharSet(CharSet &c);
    void add(unsigned char);
    bool isElement(unsigned char) const;
    int cardinal() const;
    void init();
    bool existe();
    char prochain();
};