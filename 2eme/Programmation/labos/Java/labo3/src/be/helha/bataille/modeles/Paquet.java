package be.helha.bataille.modeles;

import be.helha.bataille.modeles.exceptions.PlusDeCarteException;
import com.sun.deploy.util.ArrayUtil;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class Paquet {
    private ArrayList<Carte> cartes;
    private int nbCartes = 0;

    public Paquet(int nb) {
        cartes = new ArrayList<Carte>();
    }

    public void ajouterUneCarte(Carte carte) {
        cartes.add(carte);
        nbCartes++;
    }

    public void mélanger() {
        Collections.shuffle(cartes);
    }

    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < nbCartes; i++) {
            s += i + ". " + cartes.get(i).toString() + " | ";
        }
        System.out.println();
        return s;
    }

    public int taille() {
        return nbCartes;
    }


    public Carte tirerUneCarte(int index) {
        // on donne un index on return MAIS on doit doit aussi la retirer après
        if(this.nbCartes != 0){
            return cartes.get(index);
        }
        else throw new PlusDeCarteException();
    }

    public void retireCarte(int index){
       cartes.remove(index);
       nbCartes--;
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
