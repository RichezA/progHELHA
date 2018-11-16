#pragma once
#include "rationnelHeader.hpp"
#include <iostream>

class ElementRationnel
{
  public:
    Rationnel rationnel;
    class ElementRationnel *nextadr;
    ElementRationnel(Rationnel &ratio, ElementRationnel *adr = nullptr);
    ElementRationnel(ElementRationnel &elem);
    Rationnel sum(ElementRationnel *adr);
    Rationnel sum();
};