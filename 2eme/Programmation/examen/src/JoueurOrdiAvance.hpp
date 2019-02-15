#pragma once
#include "Joueur.hpp"
#include <cstring>

class JoueurOrdiAvance : public Joueur
{
public:
  JoueurOrdiAvance(std::string nom) : Joueur(nom){};
  Carte *setCarteChoisie();
  void choisirRangee(Rangee *rangees[4]);
};