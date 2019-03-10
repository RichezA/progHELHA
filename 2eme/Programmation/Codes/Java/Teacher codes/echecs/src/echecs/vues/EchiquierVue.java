package echecs.vues;

import echecs.modeles.Couleur;
import echecs.modeles.Echiquier;
import echecs.modeles.Piece;

public class EchiquierVue {
    Echiquier echiquier;

    public static final String ANSI_WHITE = "\u001B[37m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_RESET = "\u001B[0m";

    public EchiquierVue(Echiquier echiquier) {
        this.echiquier = echiquier;
    }

    public void afficher() {
        System.out.println();
        afficherNumeroDesColonnes();
        for (int i = 0; i < echiquier.LG; i++) {
            System.out.printf("%-3c", "ABCDEFGH".charAt(i));
            for (int j = 0; j < echiquier.LG; j++) {
                Piece piece = echiquier.getPieceA(j,i);
                afficherPiece(piece);
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    private void afficherNumeroDesColonnes() {
        System.out.print("   ");
        for (int i = 0; i < echiquier.LG; i++) {
            System.out.print(i + 1 + " ");
        }
        System.out.println();
    }

    private void afficherPiece(Piece piece) {
        if (piece == null) {
            System.out.print("_");
        } else {
            if (piece.estCouleur(Couleur.BLANC))
                System.out.print(ANSI_WHITE + ANSI_RED_BACKGROUND);
            System.out.print(piece.getClass().getSimpleName().charAt(0) + ANSI_RESET);
        }
    }
}
