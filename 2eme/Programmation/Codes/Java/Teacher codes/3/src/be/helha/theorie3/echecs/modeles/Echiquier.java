package be.helha.theorie3.echecs.modeles;

import be.helha.theorie3.echecs.modeles.exceptions.MouvementImpossibleException;
import be.helha.theorie3.echecs.modeles.exceptions.PositionIncorrecteException;

public class Echiquier {

    public static final int LG = 8;
    Case cases[][];

    public Echiquier() {
        cases = new Case[LG][LG];
        for(int i = 0; i < LG; i++) {
            for(int j = 0; j < LG; j++) {
                cases[i][j] = new Case();
            }
        }
        placeTours();
        placePions();
    }

    public static boolean estUneBonnePosition(int x, int y) {
        return x >= 0 && x < LG && y >= 0 && y < LG;
    }

    private void placePions() {
        for (int i = 0; i < LG; i++) {
            cases[i][1].setPiece(new Pion());
        }

    }

    private void placeTours() {
        cases[0][0].setPiece(new Tour());
        cases[7][0].setPiece(new Tour());
    }

    private Case getCase(int x, int y) {
        if(!estUneBonnePosition(x,y)) {
            throw new PositionIncorrecteException(x,y);
        }
        return cases[x][y];
    }

    public void deplace(int fromX, int fromY, int toX, int toY) {
        Case depart = getCase(fromX,fromY);
        if(depart.estVide()) {
            throw new MouvementImpossibleException();
        }
        Piece piece = depart.getPiece();
        if(!piece.peutDeplacer(toX - fromX, toY - fromY)) {
            throw new MouvementImpossibleException();
        }
        depart.retirePiece();
        getCase(toX, toY).setPiece(piece);
        piece.postDeplacement();
    }

    public Piece getPieceA(int i, int j) {
        return getCase(i,j).getPiece();
    }
}
