#pragma once
#include "Joueur.hpp"
#include <cstring>

class JoueurHumain : public Joueur
{
public:
  JoueurHumain(std::string nom) : Joueur(nom) {}
  Carte *setCarteChoisie();
  int setRangee();
};