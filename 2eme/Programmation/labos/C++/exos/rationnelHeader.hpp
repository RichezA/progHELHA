#pragma once
#include <iostream>
#include <fstream>
#include <cstring>
class Rationnel
{
    unsigned int pgcd(unsigned int a, unsigned int b); // function proto
    int _num, _denom;

  public:
    Rationnel(int num, int denom);
    Rationnel();
    int num();
    int denom();
    void show(std::ostream &out) const;
    void setNumDenom(int num, int denom);
    void swap();
    friend Rationnel operator+(Rationnel const &a, Rationnel const &b);
    friend Rationnel operator-(Rationnel const &a, Rationnel const &b);
    friend Rationnel operator*(Rationnel const &a, Rationnel const &b);
    friend Rationnel operator/(Rationnel const &a, Rationnel &b);
    friend Rationnel operator==(Rationnel const &a, Rationnel const &b);
    Rationnel &simplify();
    friend std::ostream &operator<<(std::ostream &out, const Rationnel &r);
};