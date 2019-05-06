package be.helha.theorie3.echecs.modeles;

public class Pion extends Piece {

    protected boolean premierDeplacement = true;

    @Override
    public boolean peutDeplacer(int dx, int dy) {
        if (dx != 0)
            return false;
        if (dy == 2 && !premierDeplacement)
            return false;
        return dy == 2 || dy == 1;
    }

    @Override
    public void postDeplacement() {
        premierDeplacement = false;
    }
}
