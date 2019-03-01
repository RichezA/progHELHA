#include "JoueurHumain.hpp"

Carte *JoueurHumain::setCarteChoisie()
{
    int indexCarte = 0;
    this->carteChoisie = nullptr;
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
    this->carteChoisie = this->main[index - 1];
    return this->carteChoisie;
}

void JoueurHumain::choisirRangee(Rangee *rangees[4])
{
    int choix;
    for (int i = 0; i < Jeu::nbRangees; i++)
    {
        std::cout << *rangees[i] << std::endl;
    }
    std::cout << this->getNom() << ": "
              << "Veuillez choisir une rangée (1, 2, 3 ou 4): ";
    std::cin >> choix;
    this->setScore(rangees[choix - 1]->getScore());
    rangees[choix - 1]->viderRangee(this->getCarteChoisie());
}