#include "Paquet.hpp"

/* CONSTUCTEUR */

Paquet::Paquet()
{
    for (int i = 0; i < nombreCartes; i++)
    {
        paquetDeCarte[i] = new Carte(i + 1);
        paquetDeCarte[i]->setDansLePaquet(true);
    }
    this->Melanger();
}

/* DESTRUCTEUR */

Paquet::~Paquet()
{
    for (int i = 0; i < nombreCartes; i++)
    {
        delete paquetDeCarte[i];
        paquetDeCarte[i] = nullptr;
    }
}

/* GET */

Carte *Paquet::getCarte(int index) const
{
    return this->paquetDeCarte[index];
}

/*
*   Méthode permettant de mélanger
*   le paquet de cartes
*/

void Paquet::Melanger()
{
    srand(time(NULL));
    for (int i = 0; i < nombreCartes; i++)
    {
        int r = rand() % nombreCartes;
        Carte *temp = paquetDeCarte[i];
        paquetDeCarte[i] = paquetDeCarte[r];
        paquetDeCarte[r] = temp;
    }
}

void Paquet::retireCarte(int index)
{
    paquetDeCarte[index]->setDansLePaquet(false);
}

std::ostream &operator<<(std::ostream &out, Paquet &paquet)
{
    out << "Paquet :\n";
    for (int i = 0; i < paquet.nombreCartes; i++)
    {
        if ((paquet.getCarte(i))->getDansLePaquet())
        {
            if (i == 103)
            {
                out << *(paquet.getCarte(i));
                break;
            }

            out << *(paquet.getCarte(i)) << " / ";
        }
    }
}
