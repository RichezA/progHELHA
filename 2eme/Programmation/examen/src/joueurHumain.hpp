#pragma once
#include "Joueur.hpp"
#include <cstring>

class JoueurHumain : public Joueur
{
public:
  JoueurHumain(std::string nom) : Joueur(nom){};
  Carte *setCarteChoisie();               // Permet au joueur de choisir une carte manuellement
  void choisirRangee(Rangee *rangees[4]); // Permet au joueur de choisir une rangée manuellement quand il lui est demandé
};