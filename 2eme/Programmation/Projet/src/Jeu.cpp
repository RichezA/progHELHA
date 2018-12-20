#include "Jeu.hpp"

/* CONSTRUCTEUR */

Jeu::Jeu(int nbJoueurHumain)
{
    for (int i = 0; i < this->nbJoueurs; i++)
    {
        if (i < nbJoueurHumain && nbJoueurHumain < nbJoueurs)
        {
            std::cout << "Choisissez un pseudo: ";
            std::cin >> pseudo;
            joueurs[i] = new JoueurHumain("Joueur " + pseudo);
        }
        else
        {
            joueurs[i] = new Joueur("Joueur " + std::to_string(i + 1));
        }
    }
    for (int i = 0; i < this->nbRangees; i++)
    {
        rangees[i] = new Rangee("Rangee " + std::to_string(i + 1));
    }
    paquet = new Paquet();
}

Jeu::JoueurCarte::JoueurCarte(Joueur *j, Carte *c)
{
    this->joueur = j;
    this->carte = c;
}

/* DESTRUCTEUR */

Jeu::~Jeu()
{
    for (int i = 0; i < this->nbJoueurs; i++)
    {
        delete joueurs[i];
        joueurs[i] = nullptr;
    }
    for (int i = 0; i < this->nbRangees; i++)
    {
        delete rangees[i];
        rangees[i] = nullptr;
    }
    delete paquet;
    paquet = nullptr;
}

/* GET */

Paquet *Jeu::getPaquet() const
{
    return this->paquet;
}

/* SET */

/* OPERATEURS */

void Jeu::DemarrerJeu()
{
    this->InitialisationPlateau();
    this->Tour();
}

/* METHODES */

void Jeu::DistribuerCartes()
{
    int index = 0;
    int carte = 0;
    for (int i = 0; i < Joueur::getNbCarte(); i++)
    {
        for (int j = 0; j < nbJoueurs; j++)
        {
            joueurs[j]->setCarte(index, paquet->getCarte(carte));
            paquet->retireCarte(carte);
            carte++;
        }
        index++;
    }
    for (int i = 0; i < nbRangees; i++)
    {
        rangees[i]->setCarte(0, paquet->getCarte(carte));
        paquet->retireCarte(carte);
        carte++;
    }
}

void Jeu::InitialisationPlateau()
{
    this->DistribuerCartes();
    std::cout << std::endl
              << "JEU : \n";
    for (int i = 0; i < this->nbJoueurs; i++)
    {
        std::cout << *(this->joueurs[i]) << "\n";
    }
    std::cout << std::endl;
    for (int j = 0; j < this->nbRangees; j++)
    {
        std::cout << *(this->rangees[j]);
    }
    std::cout << "\n"
              << *(this->getPaquet());
}

void Jeu::Tour()
{
    for (int i = 0; i < nbTours && !isFini(); i++)
    {
        std::cout << "\n\nDébut du tour " << i + 1 << ":" << std::endl;
        this->ChoisirEtDeposerCarte();
        std::cout << std::endl;
        this->Traitement();
        if (i == (nbTours - 1))
        {
            i = -1;
            for (int j = 0; j < nbRangees; j++)
            {
                delete rangees[j];
                rangees[j] = nullptr;
            }
            for (int j = 0; j < this->nbRangees; j++)
            {
                rangees[j] = new Rangee("Rangee " + std::to_string(j + 1));
            }
            delete paquet;
            paquet = nullptr;
            paquet = new Paquet;
            this->InitialisationPlateau();
        }
    }
}

bool Jeu::isFini()
{
    for (int i = 0; i < nbJoueurs; i++)
    {
        if (joueurs[i]->getScore() >= 66)
        {
            std::cout << std::endl
                      << joueurs[i]->getNom() << " a perdu la partie !" << std::endl;
            return true;
        }
        else
        {
            continue;
        }
    }
}

void Jeu::ChoisirEtDeposerCarte()
{
    for (int j = 0; j < nbJoueurs; j++)
    {
        table[j] = new JoueurCarte(joueurs[j], joueurs[j]->setCarteChoisie());
        std::cout << (joueurs[j])->getNom() << std::endl;
        std::cout << *(joueurs[j]->getCarteChoisie()) << std::endl;
        //check si tout est bon dans la nested class
        // std::cout << std::endl
        //           << (*this->table[j]->joueur).getNom() << " : " << *this->table[j]->carte << std::endl;
        joueurs[j]->retireCarte(joueurs[j]->getIndexChoisi());
    }
}

void Jeu::TriCartes()
{
    JoueurCarte *carteTmp;
    //réorganiser le tableau pour qu'il soit trié du plus petit au plus grand
    for (int i = 0; i < nbJoueurs; i++)
    {
        for (int j = 0; j < nbJoueurs; j++)
        {
            if (*table[i]->carte < *table[j]->carte)
            {
                carteTmp = table[i];
                table[i] = table[j];
                table[j] = carteTmp;
                j = 0;
            }
        }
    }
    for (int i = 0; i < nbJoueurs; i++)
        std::cout << "\ntable triée: " << *table[i]->carte << " (" << (*table[i]->joueur).getNom() << ")";
    std::cout << "\n\n";
}

void Jeu::AfficherScore()
{
    std::cout << std::endl
              << "Score: " << std::endl;
    for (int i = 0; i < this->nbJoueurs; i++)
    {
        std::cout << joueurs[i]->getNom() << ": " << joueurs[i]->getScore() << std::endl;
    }
}

void Jeu::PoseFin()
{
    for (int i = 0; i < nbJoueurs; i++)
    {
        int indexRangee;
        // check if joueurs[i] est joueurHumain
        JoueurHumain *joueurHumainTmp = dynamic_cast<JoueurHumain *>(joueurs[i]); // renvoie nullptr si joueurs[i] != JoueurHumain
        //nécessaire car on doit montrer les rangées avant
        if (joueurHumainTmp)
        {
            std::cout << "joueur humain detecte" << std::endl;
            for (int j = 0; j < nbRangees; j++)
            {
                std::cout << *rangees[j];
            }
            std::cout << std::endl
                      << "Choisissez la rangée que vous souhaitez utilisé (1,...) ";
            std::cin >> indexRangee;
            indexRangee--;

            // si carte posée > carte au dernier index de la rangée
            if (*rangees[indexRangee]->getCarte(rangees[indexRangee]->getNbCarteActuel() - 1) < *table[i]->carte)
            {
                table[i]->joueur->setScore(rangees[indexRangee]->getScore());
                rangees[indexRangee]->viderRangee(table[i]->carte);
            }

            // si 6 eme carte posée
            else if (rangees[indexRangee]->getNbCarteActuel() == 5)
            {
                table[i]->joueur->setScore(rangees[indexRangee]->getScore());
                rangees[indexRangee]->viderRangee(table[i]->carte);
                std::cout << "6 qui prend pour " << table[i]->joueur->getNom() << " !" << std::endl;
            }
            else
            {
                std::cout << *table[i]->carte << std::endl;
                std::cout << *rangees[indexRangee]->getCarte(rangees[indexRangee]->getNbCarteActuel() - 1) << std::endl;
                rangees[indexRangee]->setCarte(rangees[indexRangee]->getNbCarteActuel(), table[i]->carte);
            }
        }
        else
        {
            int diff = 104;
            int rangee = -1;
            for (int j = 0; j < nbRangees; j++)
            {
                int diffe = rangees[j]->differenceCarteRangee(table[i]->carte);
                if (diffe < diff)
                {
                    diff = diffe;
                    rangee = j;
                }
            }
            if (rangee == -1)
            {

                indexRangee = table[i]->joueur->setRangee();
                table[i]->joueur->setScore(rangees[indexRangee]->getScore());
                rangees[indexRangee]->viderRangee(table[i]->carte);
            }
            else if (rangee > -1)
            {
                if (rangees[rangee]->getNbCarteActuel() == 5)
                {
                    table[i]->joueur->setScore(rangees[rangee]->getScore());
                    rangees[rangee]->viderRangee(table[i]->carte);
                    std::cout << "6 qui prend pour " << table[i]->joueur->getNom() << " !" << std::endl;
                }
                else
                {
                    rangees[rangee]->setCarte(rangees[rangee]->getNbCarteActuel(), table[i]->carte);
                }
            }
        }
    }
}

void Jeu::Traitement()
{
    this->TriCartes();
    this->PoseFin();
    for (int j = 0; j < nbRangees; j++)
    {
        std::cout << *this->rangees[j];
    }
    this->AfficherScore();
    for (int i = 0; i < nbJoueurs; i++)
    {
        delete table[i];
        table[i] = nullptr;
    }
}