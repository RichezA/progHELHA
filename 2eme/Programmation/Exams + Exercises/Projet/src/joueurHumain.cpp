#include "JoueurHumain.hpp"

Carte *JoueurHumain::setCarteChoisie()
{
    int indexCarte = 0;
    this->carteChoisie = nullptr;
    for (int i = 0; i < nbCarteMax; i++)
    {
        if (this->getCarte(i) != nullptr)
        {
            std::cout << i << ". " << *(this->getCarte(i)) << " , ";
            //indexCarte++;
        }
    }
    std::cout << "\b\b  " << std::endl
              << "Veuillez choisir une carte (0,...): ";
    std::cin >> index;
    this->carteChoisie = this->main[index];
    return this->carteChoisie;
}

int JoueurHumain::setRangee()
{
    int indexRangee;
    std::cout << "Veuillez choisir votre rangée...";
    std::cin >> indexRangee;
    return (indexRangee - 1);
}
