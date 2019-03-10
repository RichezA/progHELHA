package be.helha.theorie3.echecs.modeles;

public class Tour extends Piece {

    @Override
    public boolean peutDeplacer(int dx, int dy) {
        return dx == 0 && dy != 0 || dx != 0 && dy == 0;
    }
}
