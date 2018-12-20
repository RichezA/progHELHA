#pragma once
#include "Carte.hpp"
#include <ctime>

class Paquet
{

public:
  static const int nombreCartes = 104;
  Paquet();                                                          // Constructeur
  ~Paquet();                                                         // Destructeur
  Carte *getCarte(int index) const;                                  // Permet de get une carte à un certain endroit dans le paquet
  void retireCarte(int index);                                       // Permet de retirer une carte à un certain endroit dans le paquet
  void Melanger();                                                   // Permet de mélanger le paquet
  friend std::ostream &operator<<(std::ostream &os, Paquet &paquet); // Surcharge de "<<" permettant d'afficher notre paquet
private:
  Carte *paquetDeCarte[nombreCartes];
};