package be.helha.bataille.modeles;

public class Joueur {
    private Paquet paquet = new Paquet(Jeu.NB_CARTES);
    private int score = 0;


    public void addCarte(Carte carte) {
        paquet.ajouterUneCarte(carte);
    }

    public Carte donnerCarte() {
        return paquet.tirerUneCarte();
    }

    public void incScore() {
        score++;
    }

    public boolean aEncoreDesCartes() {
        return !paquet.estVide();
    }

    public int getScore() {
        return score;
    }
}
