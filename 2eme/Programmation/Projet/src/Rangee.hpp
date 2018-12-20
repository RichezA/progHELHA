#pragma once
#include "Carte.hpp"
#include <iostream>

class Rangee
{
  Carte *rangee[5];
  std::string nom;
  int nbCartesActuel = 0;

public:
  static const int nbCarte = 5;
  Rangee(std::string nom);          // Constructeur
  ~Rangee();                        // Destructeur
  Carte *getCarte(int index) const; // Permet de get la carte à un certain endroit de la rangée
  int getNbCarteActuel() const;
  std::string getNom() const;             // Permet de get le nom d'une rangée
  int getScore() const;
  void setCarte(int index, Carte *carte); // Permet de set la première carte d'une rangée
  int differenceCarteRangee(Carte *carte);
  void viderRangee(Carte *carte);
  friend std::ostream &operator<<(std::ostream &os, Rangee &rangee); // Surcharge de "<<" afin de permettre l'affichage d'une rangée
};