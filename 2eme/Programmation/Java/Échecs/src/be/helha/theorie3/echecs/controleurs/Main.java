package be.helha.theorie3.echecs.controleurs;

import be.helha.theorie3.echecs.modeles.Echiquier;
import be.helha.theorie3.echecs.vues.EchiquierVue;

public class Main {
    public static void main(String[] args) {
        Echiquier echiquier = new Echiquier();
        EchiquierVue vue = new EchiquierVue(echiquier);
        vue.afficher();
        echiquier.deplace(0,0,0,5);
        vue.afficher();
        echiquier.deplace(1,1,1,3);
        vue.afficher();
    }
}
