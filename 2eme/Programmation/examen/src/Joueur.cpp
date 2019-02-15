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

int Joueur::getNbCarteActuel() const
{
    return nbCarteActuel;
}

int Joueur::getIndexChoisi() const
{
    return this->index;
}

int Joueur::getScore() const
{
    return this->score;
}

bool Joueur::getGagne() const
{
    return this->aGagne;
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

void Joueur::setGagne(bool valeur)
{
    this->aGagne = valeur;
}

/* MÉTHODES */

void Joueur::retireCarte(int index)
{
    Carte *carteTmp;
    for (int i = index; i < nbCarteMax; ++i)
    {
        if (i == nbCarteMax - 1)
        {
            main[i] = nullptr;
            break;
        }
        main[i] = main[i + 1];
    }
    nbCarteActuel--;
}

void Joueur::deposeCarte(Rangee *rangees[4])
{
    int diff = 104;
    int rangee = -1;
    for (int j = 0; j < Jeu::nbRangees; j++)
    {
        int diffe = rangees[j]->differenceCarteRangee(this->getCarteChoisie());
        if (diffe < diff)
        {
            diff = diffe;
            rangee = j;
        }
    }
    if (rangee == -1)
    {
        this->choisirRangee(rangees);
    }
    else if (rangee > -1)
    {
        if (rangees[rangee]->getNbCarteActuel() == 5)
        {
            this->setScore(rangees[rangee]->getScore());
            rangees[rangee]->viderRangee(this->getCarteChoisie());
            std::cout << "6 qui prend pour " << this->getNom() << " !" << std::endl;
        }
        else
        {
            rangees[rangee]->setCarte(rangees[rangee]->getNbCarteActuel(), this->getCarteChoisie());
        }
    }
}

Carte *Joueur::choisirCarte()
{
    for (int i = 0; i < nbCarteMax; i++)
    {
        if (this->getCarte(i) != nullptr)
        {
            std::cout << i + 1 << ". " << *(this->getCarte(i)) << " , ";
            //indexCarte++;
        }
    }
    std::cout << "\b\b  " << std::endl
              << this->getNom() << ": "
              << "Veuillez choisir une carte (1,...): ";
    std::cin >> index;
    return this->main[index - 1];
}

Carte *Joueur::choisirCarteAleatoire()
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

void Joueur::choisirRangee(Rangee *rangees[4])
{
    srand(time(NULL));
    int indexRangee = rand() % (Jeu::nbRangees - 1);
    this->setScore(rangees[indexRangee]->getScore());
    rangees[indexRangee]->viderRangee(this->getCarteChoisie());
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