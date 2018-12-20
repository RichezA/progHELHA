#include "Rangee.hpp"

/* CONSTRUCTEUR */

Rangee::Rangee(std::string nom) : nom(nom)
{
    for (int i = 0; i < this->nbCarte; ++i)
    {
        rangee[i] = nullptr;
    }
}

/* DESTRUCTEUR */

Rangee::~Rangee() {}

/* GET */

Carte *Rangee::getCarte(int index) const
{
    return this->rangee[index];
}

int Rangee::getNbCarteActuel() const
{
    return this->nbCartesActuel;
}

std::string Rangee::getNom() const
{
    return this->nom;
}

int Rangee::getScore() const
{
    int resultat = 0;
    for (int i = 0; i < this->nbCarte; ++i)
    {
        if (this->getCarte(i) != nullptr)
        {
            resultat += this->getCarte(i)->getTetes();
        }
    }
    return resultat;
}

/* SET */

void Rangee::setCarte(int index, Carte *carte)
{
    this->rangee[index] = carte;
    this->nbCartesActuel++;
}

/* MÉTHODES */

int Rangee::differenceCarteRangee(Carte *carte)
{
    if (*(this->rangee[nbCartesActuel - 1]) < *carte)
    {
        return (*carte - *(this->rangee[nbCartesActuel - 1]));
    }
    return 104;
}

void Rangee::viderRangee(Carte *carte)
{
    for (int i = 0; i < this->nbCarte; i++)
    {
        rangee[i] = nullptr;
    }
    this->rangee[0] = carte;
    this->nbCartesActuel = 1;
}

/* OPERATEUR */

std::ostream &operator<<(std::ostream &out, Rangee &rangee)
{
    out << rangee.getNom() << " : ";
    for (int i = 0; i < rangee.nbCarte; i++)
    {
        if (rangee.getCarte(i) != nullptr)
        {
            out << *(rangee.getCarte(i)) << " , ";
        }
    }
    out << "\b\b  " << std::endl;
    return out;
}