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
  Rationnel(const Rationnel &r);
  int num();
  int denom();
  void show(std::ostream &out) const;
  void setNumDenom(int num, int denom);
  void swap();
  friend Rationnel operator+(const Rationnel &a, const Rationnel &b);
  friend Rationnel operator-(const Rationnel &a, const Rationnel &b);
  friend Rationnel operator*(const Rationnel &a, const Rationnel &b);
  friend Rationnel operator/(const Rationnel &a, const Rationnel &b);
  friend Rationnel operator==(const Rationnel &a, const Rationnel &b);
  Rationnel &simplify() const;
  friend std::ostream &operator<<(std::ostream &out, const Rationnel &r);
};