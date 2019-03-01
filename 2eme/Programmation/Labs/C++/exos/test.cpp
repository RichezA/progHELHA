#include <iostream>
#include <fstream>

class Carte
{
    int _value;
    int _beefHead;
    public:
    Carte() {}
    int value() { return _value;}
    int beefHead() { return _beefHead;}
    friend class PaquetDeCarte;
};

class PaquetDeCarte
{
    Carte carte[104];
    public:
    PaquetDeCarte() 
    {
        for(int i = 0; i < 104; i++)
        {
            carte[i]._value = i + 1;
            carte[i]._beefHead = 1;
            if(carte[i]._value % 11 == 0) carte[i]._beefHead = 5;
            if(carte[i]._value % 10 == 0) carte[i]._beefHead = 3;
            if(carte[i]._value % 5 == 0) carte[i]._beefHead = 2;
            if(carte[i]._value == 55) carte[i]._beefHead = 7;
        }
    }
    void show(std::ostream &out) const
    {
        for(int i = 0; i < 104; i++)
        {
            out << "N#" << carte[i]._value << " beefHead: " << carte[i]._beefHead << std::endl;
        }
    }
};
std::ostream &operator<<(std::ostream &out, const PaquetDeCarte &paquet)
{
    paquet.show(out);
    return out;
}


int main()
{
    PaquetDeCarte paquet;
    std::cout << paquet << std::endl;
}