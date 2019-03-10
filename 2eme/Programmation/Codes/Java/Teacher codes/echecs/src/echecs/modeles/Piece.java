package echecs.modeles;

// Responsabilité : gérer un pièce et ses déplacements

public abstract class Piece {

    protected Couleur couleur;

    public Piece(Couleur couleur) {
        this.couleur = couleur;
    }

    public boolean estCouleur(Couleur couleur) {
        return this.couleur == couleur;
    }

    public abstract boolean peutSeDeplacer(int dx, int dy);

    public void postDeplacement() {}

    public boolean peutSurvoler() {
        return false;
    }
}
