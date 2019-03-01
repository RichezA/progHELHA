#pragma once
#include "Paquet.hpp"
#include "Joueur.hpp"
#include "JoueurHumain.hpp"
#include "Rangee.hpp"

class Jeu
{

public:
  static const int nbJoueurs = 4;
  static const int nbRangees = 4;
  static const int nbCartesParJoueur = 10;
  static const int nbTours = 10;
  Jeu(int nbJoueurHumain);      // Constructeur
  ~Jeu();                       // Destructeur
  Paquet *getPaquet() const;    // Permet de get le paquet de l'objet Jeu courant
  void DistribuerCartes();      // Permet de distribuer les cartes aux joueurs
  void InitialisationPlateau(); // Permet d'initialiser le plateau de jeu (distribue et affiche les cartes)
  void Tour();                  // Permet de mener à bien un tour de jeu (demande au joueur de poser une carte sur la table)
  bool isFini();                // Permet de voir si un joueur a déjà atteint un score de 66
  void ChoisirEtDeposerCarte(); // Permet de choisir et de déposer une carte
  void TriCartes();             // Permet de trier notre table(tableau de cartes où nous allons entreposer les cartes choisies par les joueurs pour un jouer un tour)
  void AfficherScore();         // Affiche le score des joueurs
  void PoseFin();               // Permet de poser une carte à la fin d'une rangée
  void Traitement();            // Permet de traiter les cartes pour un tour
  void DemarrerJeu();           // Démarre la partie
  class JoueurCarte
  {
  public:
    Joueur *joueur;
    Carte *carte;
    JoueurCarte(Joueur *j, Carte *c);
  };

private:
  std::string pseudo;
  Joueur *joueurs[nbJoueurs];
  Rangee *rangees[nbRangees];
  Paquet *paquet;
  JoueurCarte *table[nbJoueurs];
};