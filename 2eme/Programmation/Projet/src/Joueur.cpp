#include "Joueur.hpp"

/* CONSTRUCTEUR */

Joueur::Joueur(std::string nom)
{
    this->setNom(nom);
}

/* DESTRUCTEUR */

Joueur::~Joueur()
{
}

/* GET */

std::string Joueur::getNom() const
{
    return this->nom;
}

Carte *Joueur::getCarte(int index) const
{
    return this->main[index];
}

Carte *Joueur::getCarteChoisie() const
{
    return this->carteChoisie;
}

int Joueur::getNbCarte()
{
    return nbCarteMax;
}

int Joueur::getIndexChoisi() const
{
    return this->index;
}

int Joueur::getScore() const
{
    return this->score;
}

/* SET */

void Joueur::setNom(std::string value)
{
    this->nom = value;
}

Carte *Joueur::setCarteChoisie()
{
    this->carteChoisie = nullptr;
    srand(time(NULL));
    index = rand() % nbCarteMax;
    for (int i = index; i < nbCarteMax; i++)
    {
        if (this->main[i] == nullptr)
        {
            continue;
        }
        else
        {
            index = i;
            this->carteChoisie = this->main[i];
            return this->carteChoisie;
        }
    }
    for (int i = index; i >= 0; i--)
    {
        if (this->main[i] == nullptr)
        {
            continue;
        }
        else
        {
            index = i;
            this->carteChoisie = this->main[i];
            return this->carteChoisie;
        }
    }
}

void Joueur::setCarte(int index, Carte *carte)
{
    this->main[index] = carte;
    nbCarteActuel++;
}

void Joueur::setScore(int nbTetes)
{
    this->score += nbTetes;
}

int Joueur::setRangee()
{
    srand(time(NULL));
    int indexRangee = rand() % (nbRangees - 1);
    return indexRangee;
}

/* MÉTHODES */

void Joueur::retireCarte(int index)
{
    this->main[index] = nullptr;
    //this->main[index]->setDansLaMain(false);
    nbCarteActuel--;
}

/* OPERATEUR */

std::ostream &operator<<(std::ostream &out, Joueur &joueur)
{
    out << joueur.getNom() << " : ";
    for (int i = 0; i < joueur.nbCarteMax; i++)
    {
        if (joueur.getCarte(i) != nullptr)
        {
            if (i == 9)
            {
                out << *(joueur.getCarte(i));
                break;
            }
            out << *(joueur.getCarte(i)) << " / ";
        }
    }
    return out;
}