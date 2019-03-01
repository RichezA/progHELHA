package be.helha.theorie3.echecs.modeles;

public abstract class Piece {

    public abstract boolean peutDeplacer(int dx, int dy);

    public void postDeplacement() {}
}
