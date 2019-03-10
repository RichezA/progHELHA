package echecs.modeles;

import echecs.modeles.exceptions.MouvementImpossibleException;

// Responsabilité : gérer les tours du jeu (blanc, noir, ...)

public class Jeu {
    private final Echiquier echiquier;
    private Couleur couleurCourante;

    public Jeu(Echiquier echiquier) {
        this.echiquier = echiquier;
        this.couleurCourante = Couleur.BLANC;
    }

    public void deplace(Position from, Position to) {
        if(!echiquier.getPieceA(from).estCouleur(couleurCourante)) {
            throw new MouvementImpossibleException();
        }
        echiquier.deplace(from, to);
        toggleCouleur();
    }

    private void toggleCouleur() {
        if(couleurCourante == Couleur.BLANC)
            couleurCourante = Couleur.NOIR;
        else
            couleurCourante = Couleur.BLANC;
    }

    public boolean estCouleurCourante(Couleur couleur) {
        return couleurCourante == couleur;
    }

}
