package echecs.modeles;

import echecs.modeles.exceptions.MouvementImpossibleException;
import echecs.modeles.exceptions.PositionIncorrecteException;

import java.util.List;

import static echecs.modeles.Couleur.BLANC;
import static echecs.modeles.Couleur.NOIR;

// Responsabilité : gérer toutes les cases et vérifier que les pièces se déplacent correctement

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

    public static boolean estUneBonnePosition(Position position) {
        return estUneBonnePosition(position.x, position.y);
    }

    public static boolean estUneBonnePosition(int x, int y) {
        return x >= 0 && x < LG && y >= 0 && y < LG;
    }

    private void placePions() {
        for (int i = 0; i < LG; i++) {
            cases[i][1].setPiece(new Pion(BLANC));
            cases[i][6].setPiece(new Pion(NOIR));
        }

    }

    private void placeTours() {
        cases[0][0].setPiece(new Tour(BLANC));
        cases[7][0].setPiece(new Tour(BLANC));
        cases[0][7].setPiece(new Tour(NOIR));
        cases[7][7].setPiece(new Tour(NOIR));
    }

    private Case getCase(Position p) {
        return getCase(p.x, p.y);
    }
    private Case getCase(int x, int y) {
        if(!estUneBonnePosition(x,y)) {
            throw new PositionIncorrecteException(x,y);
        }
        return cases[x][y];
    }

    public void deplace(Position from, Position to) {
        Case caseDepart = getCase(from.x,from.y);

        // checks => exception si problème
        checkCaseEstNonVide(caseDepart);
        checkMouvement(from, to);
        checkSurvol(from, to);

        // déplacement
        Piece piece = caseDepart.getPiece();
        caseDepart.retirePiece();
        getCase(to.x, to.y).setPiece(piece);

        // traitement post déplacement
        piece.postDeplacement();
    }

    private void checkMouvement(Position from, Position to) {
        if(!getPieceA(from).peutSeDeplacer(to.x - from.x, to.y - from.y)) {
            throw new MouvementImpossibleException();
        }
    }


    private void checkSurvol(Position from, Position to) {
        if(!getPieceA(from).peutSurvoler()) {
            List<Position> positions = from.getPositionsBetween(to);
            for(Position p : positions) {
                if (!getCase(p).estVide()) {
                    throw new MouvementImpossibleException();
                }
            }
        }
    }

    private void checkCaseEstNonVide(Case depart) {
        if(depart.estVide()) {
            throw new MouvementImpossibleException();
        }
    }

    public Piece getPieceA(Position position) {
        return getPieceA(position.getX(), position.getY());
    }

    public Piece getPieceA(int i, int j) {
        return getCase(i,j).getPiece();
    }
}
