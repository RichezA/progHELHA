#include <iostream>
#include "Jeu.hpp"
using namespace std;

int main(int argc, char *argv[])
{
    Jeu *jeu = new Jeu(atoi(argv[1]));
    jeu->DemarrerJeu();
    delete jeu;
    jeu = nullptr;
}