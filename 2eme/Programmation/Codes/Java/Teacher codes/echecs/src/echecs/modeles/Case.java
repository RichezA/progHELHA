package echecs.modeles;

public class Case {

    Piece piece;

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public boolean estVide() {
        return this.piece == null;
    }

    public Piece getPiece() {
        return piece;
    }

    public void retirePiece() {
        piece = null;
    }
}
