#include "JoueurOrdiAvance.hpp"

Carte *JoueurOrdiAvance::setCarteChoisie()
{
    // choisit la carte avec la plus grande valeur
    Carte *tempo = new Carte(0);
    for (int i = 0; i < nbCarteMax; i++)
    {
        if (this->main[i] == nullptr)
        {
            continue;
        }
        else
        {
            if (*tempo < *this->main[i])
            {
                tempo = this->main[i];
                this->index = i;
            }
        }
    }
    // J'utilise ici une carte temporaire car j'avais un segmentation fault quand je faisais le traitement avec carteChoisie
    carteChoisie = tempo;
    return this->carteChoisie;
}
void JoueurOrdiAvance::choisirRangee(Rangee *rangees[4])
{
    // choisit la rangee avec le moins de tetes de boeufs quand on doit mettre la 6eme
    int indexRangee = 0;
    for (int i = 1; i < Jeu::nbRangees; i++)
    {
        if (rangees[i]->getScore() > rangees[i - 1]->getScore())
        {
            indexRangee = i;
        }
    }
    this->setScore(rangees[indexRangee]->getScore());
    rangees[indexRangee]->viderRangee(this->getCarteChoisie());
}