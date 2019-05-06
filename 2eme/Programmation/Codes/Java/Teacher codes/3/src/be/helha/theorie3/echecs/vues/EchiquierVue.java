package be.helha.theorie3.echecs.vues;

import be.helha.theorie3.echecs.modeles.Echiquier;
import be.helha.theorie3.echecs.modeles.Piece;
import be.helha.theorie3.echecs.modeles.Pion;
import be.helha.theorie3.echecs.modeles.Tour;

import javax.sound.midi.Soundbank;

public class EchiquierVue {
    Echiquier echiquier;

    public EchiquierVue(Echiquier echiquier) {
        this.echiquier = echiquier;
    }

    public void afficher() {
        System.out.println();
        for (int i = 0; i < echiquier.LG; i++) {
            for (int j = 0; j < echiquier.LG; j++) {
                Piece piece = echiquier.getPieceA(j,i);
                if (piece == null) {
                    System.out.print("_");
                } else {
                    System.out.print(piece.getClass().getSimpleName().charAt(0));
                }
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
