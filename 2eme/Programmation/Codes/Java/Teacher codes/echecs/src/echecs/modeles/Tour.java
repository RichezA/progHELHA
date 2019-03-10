package echecs.modeles;

public class Tour extends Piece {

    public Tour(Couleur couleur) {
        super(couleur);
    }

    @Override
    public boolean peutSeDeplacer(int dx, int dy) {
        return dx == 0 && dy != 0 || dx != 0 && dy == 0;
    }
}
