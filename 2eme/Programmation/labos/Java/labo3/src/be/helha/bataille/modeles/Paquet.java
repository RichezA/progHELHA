package be.helha.bataille.modeles;

import be.helha.bataille.modeles.exceptions.PlusDeCarteException;

import java.util.Arrays;
import java.util.Collections;

class Paquet {
    private Carte[] cartes;
    private int nbCartes = 0;

    public Paquet(int nb) {
        cartes = new Carte[nb];
    }

    public void ajouterUneCarte(Carte carte) {
        cartes[nbCartes] = carte;
        nbCartes++;
    }

    public void mélanger() {
        Collections.shuffle(Arrays.asList(cartes));
    }

    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < nbCartes; i++) {
            s += cartes[i].toString() + '\n';
        }
        return s;
    }

    public int taille() {
        return nbCartes;
    }

    public Carte tirerUneCarte() {
        if(this.nbCartes != 0)
            return cartes[--nbCartes];
        else throw new PlusDeCarteException();


    }

    public void ajouterToutesLesCartes() {
        for (Couleur couleur : Couleur.values()) {
            for (int i = 0; i < 13; i++) {
                this.ajouterUneCarte(new Carte(i + 1, couleur));
            }
        }
    }

    public boolean estVide() {
        return nbCartes == 0;
    }
}
