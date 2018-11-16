#include "ElementRationnel.hpp"

Rationnel rationnel;
class ElementRationnel *nextadr;
ElementRationnel::ElementRationnel(Rationnel &ratio, ElementRationnel *adr) : rationnel(ratio), nextadr(adr) {}
ElementRationnel::ElementRationnel(ElementRationnel &elem) : rationnel(elem.rationnel), nextadr(elem.nextadr) {}
Rationnel ElementRationnel::sum(Rationnel r,ElementRationnel *adr)
{
    if(adr == nullptr) return r;
    sum(r + (*adr).rationnel, (*adr).nextadr);
}