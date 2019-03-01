package be.helha.bataille.modeles;

public class Tour {
    private Carte carteJoueur1;
    private Carte carteJoueur2;
    private int joueur1carte8; // 1 = j1 | 0 = j2 | -1 = nt

    public Tour(Carte carteJoueur1, Carte carteJoueur2, int j1carte8) {
        this.carteJoueur1 = carteJoueur1;
        this.carteJoueur2 = carteJoueur2;
        this.joueur1carte8 = j1carte8;
    }
    public Tour(Carte carteJoueur1, Carte carteJoueur2){
        this.carteJoueur1 = carteJoueur1;
        this.carteJoueur2 = carteJoueur2;
        this.joueur1carte8 = -1;
    }

    @Override
    public String toString() {
        return "Tour : " + getCarteJoueur1() +
                " vs " + getCarteJoueur2() + " => " + ( joueursEgalite() ? " Il y'a égalité" : joueur1Gagnant() ? "Joueur 1 Gagnant" : "Joueur 2 Gagnant");
    }

    // getters
    public Carte getCarteJoueur1(){ return this.carteJoueur1;}
    public Carte getCarteJoueur2(){ return this.carteJoueur2;}

    public boolean joueur1Gagnant() {
        switch(joueur1carte8){
            case 0:
                return false;
            case 1:
                return true;
            default:
                return !carteJoueur1.estAvant(carteJoueur2);
        }

    }
    public boolean joueursEgalite() {return carteJoueur1.getValue() == carteJoueur2.getValue();}
}
