#pragma once
#include "rationnelHeader.hpp"
#include <iostream>

class ElementRationnel
{
  bool firstTime = true;
  public:
    Rationnel rationnel;
    class ElementRationnel *nextadr;
    ElementRationnel(Rationnel &ratio, ElementRationnel *adr = nullptr);
    ElementRationnel(ElementRationnel &elem);
    Rationnel sum(Rationnel r,ElementRationnel *adr);
    Rationnel sum();
};