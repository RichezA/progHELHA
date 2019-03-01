#include "Jeu.hpp"

/* CONSTRUCTEUR */

Jeu::Jeu(int nbJoueurHumain, int iaAvance)
{
    int j = 0;
    for (int i = 0; i < this->nbJoueurs; i++)
    {
        if (i < nbJoueurHumain)
        {
            std::cout << "Choisissez un pseudo: ";
            std::cin >> pseudo;
            joueurs[i] = new JoueurHumain("Joueur " + pseudo);
        }
        else
        {
            if (j < iaAvance)
            {
                joueurs[i] = new JoueurOrdiAvance("Joueur " + std::to_string(i + 1));
            }
            else
            {
                joueurs[i] = new Joueur("Joueur " + std::to_string(i + 1));
            }
            j++;
        }
    }
    for (int i = 0; i < this->nbRangees; i++)
    {
        rangees[i] = new Rangee("Rangee " + std::to_string(i + 1));
    }
    paquet = new Paquet();
    db = new BaseDeDonnees();
    db->CreerPartie();
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
    delete db;
    db = nullptr;
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
    for (int i = 0; i < nbJoueurs; i++)
    {
        db->EnvoyerDonnees(joueurs[i]->getNom(), joueurs[i]->getScore(), joueurs[i]->getGagne());
    }
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
        // else if (carte13Jouee == true)
        // {
        //     this->CarteSpeciale();
        // }
    }
    Joueur *gagnant = nullptr;
    for (int i = 0; i < nbJoueurs; ++i)
    {
        if (gagnant == nullptr || joueurs[i]->getScore() < gagnant->getScore())
        {
            gagnant = joueurs[i];
        }
    }
    gagnant->setGagne(true);
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
        std::cout << std::endl
                  << (*this->table[j]->joueur).getNom() << " : " << *this->table[j]->carte << std::endl;
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
    {
        if (table[i]->carte->getValeur() == 13)
        {
            carte13Jouee = true;
            aJoue13 = table[i]->joueur;
        }
    }
    for (int i = 0; i < nbJoueurs; i++)
        std::cout << "\nOrdre du tour: " << *table[i]->carte << " (" << (*table[i]->joueur).getNom() << ")";
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

void Jeu::PoserCarte()
{
    for (int i = 0; i < nbJoueurs; i++)
    {
        std::cout << "\nLe " << joueurs[i]->getNom() << " va jouer la carte " << *joueurs[i]->getCarteChoisie() << std::endl;
        db->EnvoyerCarteJouee(joueurs[i]->getNom(), joueurs[i]->getCarteChoisie()->getValeur());
        joueurs[i]->deposeCarte(this->rangees);
        for (int j = 0; j < this->nbRangees; j++)
        {
            std::cout << *this->rangees[j] << std::endl;
        }
    }
}

void Jeu::Traitement()
{
    this->TriCartes();
    this->PoserCarte();
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

void Jeu::CarteSpeciale()
{
    Carte *carteAEchangerChoisie;
    int indexCarteChoisie = 0;
    Carte *carteAEchangerAleatoire;
    int indexJoueur = 0;
    if (this->aJoue13->getNbCarteActuel() >= 1)
    {
        carteAEchangerChoisie = aJoue13->choisirCarte();
        indexCarteChoisie = aJoue13->getIndexChoisi();
        indexJoueur = this->choisirJoueurAleatoire();
        carteAEchangerAleatoire = this->joueurs[indexJoueur]->choisirCarteAleatoire();
        aJoue13->setCarte(indexCarteChoisie, carteAEchangerAleatoire);
        this->joueurs[indexJoueur]->setCarte(this->joueurs[indexJoueur]->getIndexChoisi(), carteAEchangerChoisie);
    }
}

int Jeu::choisirJoueurAleatoire()
{
    srand(time(NULL));
    int index = rand() % nbJoueurs;
}