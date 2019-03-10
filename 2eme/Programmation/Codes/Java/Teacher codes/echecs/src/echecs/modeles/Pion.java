package echecs.modeles;

public class Pion extends Piece {

    protected boolean premierDeplacement = true;
    protected int sens = 1;

    public Pion(Couleur couleur) {
        super(couleur);
        if(couleur == Couleur.NOIR) {
            sens = -1;
        }
    }

    @Override
    public boolean peutSeDeplacer(int dx, int dy) {
        if (dx != 0)
            return false;
        if (dy == 2 * sens && !premierDeplacement)
            return false;
        return dy == 2 * sens || dy == 1 * sens;
    }

    @Override
    public void postDeplacement() {
        premierDeplacement = false;
    }
}
