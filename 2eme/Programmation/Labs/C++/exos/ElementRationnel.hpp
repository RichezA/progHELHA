#pragma once
#include "rationnelHeader.hpp"
#include <iostream>

class ElementRationnel
{
  ElementRationnel *nextadr;
  Rationnel rationnel;

public:
  ElementRationnel(Rationnel &ratio, ElementRationnel *adr = nullptr);
  ElementRationnel(ElementRationnel &elem);
  void setSuivant(ElementRationnel *element)
      Rationnel sum(Rationnel &r, ElementRationnel *adr);
  Rationnel sum();
};