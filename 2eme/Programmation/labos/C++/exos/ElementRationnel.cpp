#include "ElementRationnel.hpp"

Rationnel rationnel;
class ElementRationnel *nextadr;
ElementRationnel::ElementRationnel(Rationnel &ratio, ElementRationnel *adr) : rationnel(ratio), nextadr(adr) {}
ElementRationnel::ElementRationnel(ElementRationnel &elem) : rationnel(elem.rationnel), nextadr(elem.nextadr) {}
Rationnel ElementRationnel::sum(ElementRationnel *adr)
{
}
Rationnel ElementRationnel::sum()
{
    Rationnel tmp;
    ElementRationnel r(rationnel, nextadr);
    while (nextadr != nullptr)
    {
        //r = r + rationnel;
        tmp = tmp + r.rationnel;
        r = *nextadr;
    }
    return tmp;
}
