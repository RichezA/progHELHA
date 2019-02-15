#include "Carte.hpp"

/* CONSTRUCTEUR */

Carte::Carte(int val)
{
    this->setValeur(val);
}

/* GET */

int Carte::getValeur() const
{
    return this->valeur;
}

int Carte::getTetes() const
{
    return this->tetesDeBoeufs;
}

bool Carte::getDansLePaquet() const
{
    return this->estDansLePaquet;
}

/* SET */

void Carte::setValeur(int val)
{
    this->valeur = val;
    this->setTetes();
}

void Carte::setTetes()
{
    if (this->valeur == 55)
        this->tetesDeBoeufs = 7;
    else if (this->valeur % 11 == 0)
        this->tetesDeBoeufs = 5;
    else if (this->valeur % 10 == 0)
        this->tetesDeBoeufs = 3;
    else if (this->valeur % 5 == 0)
        this->tetesDeBoeufs = 2;
    else
        this->tetesDeBoeufs = 1;
}

void Carte::setDansLePaquet(bool value)
{
    this->estDansLePaquet = value;
}

/* OPERATEUR */

std::ostream &
operator<<(std::ostream &out, Carte &a)
{
    out << a.getValeur() << " - " << a.getTetes() << "४";
    return out;
}

bool operator<(Carte &a, Carte &b)
{
    return a.getValeur() < b.getValeur();
}

int operator-(Carte &a, Carte &b)
{
    return a.getValeur() - b.getValeur();
}