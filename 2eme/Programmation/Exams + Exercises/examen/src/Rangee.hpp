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
  Rangee(std::string nom);                                           // Constructeur
  ~Rangee();                                                         // Destructeur
  Carte *getCarte(int index) const;                                  // Permet de get la carte à un certain endroit de la rangée
  int getNbCarteActuel() const;                                      // Permet de récupérer le nombre de carte actuel que possède une rangée
  std::string getNom() const;                                        // Permet de get le nom d'une rangée
  int getScore() const;                                              // Permet de récupérer le score de la rangée
  void setCarte(int index, Carte *carte);                            // Permet de set la première carte d'une rangée
  int differenceCarteRangee(Carte *carte);                           // Permet de calculer la différence entre la carte que le joueur veut joueur et la derrnière carte d'une rangée
  void viderRangee(Carte *carte);                                    // Permet de vider une rangée et de pouvoir modifier la première carte de celle-ci
  friend std::ostream &operator<<(std::ostream &os, Rangee &rangee); // Surcharge de "<<" afin de permettre l'affichage d'une rangée
};