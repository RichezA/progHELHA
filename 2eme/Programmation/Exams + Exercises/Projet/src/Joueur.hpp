#pragma once
#include "Carte.hpp"
#include <ctime>

class Joueur
{
protected:
  static const int nbCarteMax = 10;
  static const int nbRangees = 4;
  int nbCarteActuel = 0;
  int score = 0;
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
  int getIndexChoisi() const;       // Permet de get l'index choisi lorsque l'ordinateur va jouer une carte
  virtual int getScore() const;
  void setNom(std::string value);         // Permet de set le nom du joueur
  virtual Carte *setCarteChoisie();       // Permet de choisir une carte aléatoirement (pour l'instant) dans la main du joueur
  void setCarte(int index, Carte *carte); // Permet de set une carte à un certain endroit dans la main du joueur
  virtual void setScore(int nbTetes);
  virtual int setRangee();
  void retireCarte(int index);                                       // Permet de retirer une carte dans la main du joueur
  friend std::ostream &operator<<(std::ostream &os, Joueur &joueur); // Surcharge de "<<" permettant d'afficher un joueur
};