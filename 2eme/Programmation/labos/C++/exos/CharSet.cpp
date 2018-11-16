#include "charsetHeader.h"
#include <iostream>

int CharSet::index;
int CharSet::next;
CharSet::CharSet()
{
    for (int i = 0; i < LENGTH; i++)
        tab[i] = 0;
}
CharSet::~CharSet() {}
CharSet::CharSet(CharSet &c) {}

void CharSet::add(unsigned char c)
{
    tab[c] = 1;
}
bool CharSet::isElement(unsigned char c) const
{
    return tab[c] == 1;
}
int CharSet::cardinal() const
{
    int nb = 0;
    for (int i = 0; i < LENGTH; i++)
    {
        if (tab[i] != 0)
            nb++;
    }
    return nb;
}
void CharSet::init()
{
    // goes to the index 0 of our tab;
    index = -1;
    prochain();
}
char CharSet::prochain()
{
    char c = (char)index;
    index++;
    while (index < LENGTH && tab[index] != 1)
        index++;
    // returns the next char
    return c;
}
bool CharSet::existe()
{
    // returns true while there is another element
    return index != LENGTH;
}