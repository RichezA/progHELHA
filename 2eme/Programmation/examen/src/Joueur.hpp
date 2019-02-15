#pragma once
#include "Carte.hpp"
#include "Rangee.hpp"
#include <ctime>
class Jeu;
class Joueur
{
protected:
  static const int nbCarteMax = 10;
  int nbCarteActuel = 0;
  int score = 0;
  bool aGagne = false;
  std::string nom;
  Carte *main[nbCarteMax];
  Carte *carteChoisie;
  int index;

public:
  Joueur(std::string nom);          // Constructeur
  ~Joueur();                        // Destructeur
  std::string getNom() const;       // Permet de get le nom du joueur
  Carte *getCarte(int index) const; // Permet de get une carte à un certain endroit dans la main du joueur
  Carte *getCarteChoisie() const;   // Permet de get la carte choisie par un joueur lors d'un tour
  static int getNbCarte();          // Permet de get le nombre de cartes d'un joueur
  int getNbCarteActuel() const;
  int getIndexChoisi() const;             // Permet de get l'index choisi lorsque l'ordinateur va jouer une carte
  int getScore() const;                   // Permet de récupérer le score d'un joueur à un moment donné (en têtes de boeufs)
  bool getGagne() const;                  // Permet de savoir qui a gagné la partie
  void setNom(std::string value);         // Permet de set le nom du joueur
  virtual Carte *setCarteChoisie();       // Permet de choisir une carte aléatoirement (pour l'instant) dans la main du joueur
  void setCarte(int index, Carte *carte); // Permet de set une carte à un certain endroit dans la main du joueur
  void setScore(int nbTetes);             // Permet de modifier le score d'un joueur
  void setGagne(bool valeur);             // Permet de modifier le fait qu'un joueur ait gagné/ ou pas
  void deposeCarte(Rangee *rangees[4]);   // Permet de déposer une carte dans une rangée
  Carte *choisirCarte();                  // gère le cas où on a la carte 13 dans sa main
  Carte *choisirCarteAleatoire();
  virtual void choisirRangee(Rangee *rangees[4]);                    // Permet de choisir une carte automatiquement
  void retireCarte(int index);                                       // Permet de retirer une carte dans la main du joueur
  friend std::ostream &operator<<(std::ostream &os, Joueur &joueur); // Surcharge de "<<" permettant d'afficher un joueur
};

#include "Jeu.hpp"