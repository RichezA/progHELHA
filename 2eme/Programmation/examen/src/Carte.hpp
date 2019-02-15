#pragma once
#include <iostream>

class Carte
{
  int valeur;
  int tetesDeBoeufs;
  bool estDansLePaquet;

public:
  Carte(int valeur);                                           // Constructeur
  Carte(const Carte &c) = delete;                              // Constructeur par recopie
  int getValeur() const;                                       // Permet de savoir la valeur d'une carte
  int getTetes() const;                                        // Permet de savoir le nombre de tetes de boeufs qu'a une carte
  bool getDansLePaquet() const;                                // Permet de savoir si une carte se trouve dans le paquet ou pas
  void setValeur(int valeur);                                  // Permet de set la valeur d'une carte
  void setTetes();                                             // Permet de set le nombre de tetes sur une carte
  void setDansLePaquet(bool value);                            // Permet de set l'état d'une carte dans le paquet(si elle y est ou non)
  Carte &operator=(const Carte &c) = delete;                   // Surchage de "="
  friend std::ostream &operator<<(std::ostream &os, Carte &a); // Surcharge de "<<" permettant l'affichage d'une carte
  friend bool operator<(Carte &a, Carte &b);                   // Surcharge de l'opérateur "<" permettant de comparer une carte sur base de sa valeur
  friend int operator-(Carte &a, Carte &b);                    // Surcharge de l'opérateur "-" permettant de soustraire une carte à une autre sur base de sa valeur
};