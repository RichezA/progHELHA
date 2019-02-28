package be.helha.bataille.modeles;

public class Jeu {
    public static final int NB_CARTES = 52;
    public static final int NB_JOUEURS = 2;
    private int nbEgalites;
    protected Joueur[] joueurs = new Joueur[NB_JOUEURS];
    protected Paquet paquet = new Paquet(NB_CARTES);

    public Jeu() {
        nbEgalites = 0;
        initialise();
    }

    private void initialise() {
        paquet.ajouterToutesLesCartes();
        for (int i = 0; i < joueurs.length; i++) {
            joueurs[i] = new Joueur();
        }
    }

    public void distribue() {
        while (paquet.taille() > 0) {
            for (Joueur joueur : joueurs) {
                joueur.addCarte(paquet.tirerUneCarte(paquet.taille() - 1));
                paquet.retireCarte(paquet.taille() - 1);
            }
        }
    }

    public void mélanger() {
        paquet.mélanger();
        System.out.println(paquet);
    }

    public Joueur[] getJoueurs() {
        // renvoie une copie pour préserver l'encapsulation
        return joueurs.clone();
    }

    public int getNbEgalites(){ return this.nbEgalites;}

    public Tour jouerUnTour() {
        Carte cartes[] = new Carte[joueurs.length];
        for (int i = 0; i < joueurs.length; i++) {
            System.out.print("Paquet de Joueur " + (i+1) + " . Veuillez choisir une carte:");
            cartes[i] = joueurs[i].donnerCarte();
            joueurs[i].retireCarte();
        }

        if(cartes[0].getValue() == cartes[1].getValue()) {
            this.nbEgalites++;
            return new Tour(cartes[0], cartes[1], -1);
        }
        else if(cartes[0].getValue() == 8){
            joueurs[0].incScore();
            return new Tour(cartes[0], cartes[1], 1);
        }
        else if(cartes[1].getValue() == 8){
            joueurs[1].incScore();
            return new Tour(cartes[0], cartes[1], 0);
        }
        else if (cartes[0].estAvant(cartes[1])) {
            joueurs[1].incScore();
        } else {
            joueurs[0].incScore();
        }
        return new Tour(cartes[0], cartes[1], -1);
    }

    public boolean estFini() {
        return !joueurs[0].aEncoreDesCartes();
    }

    public void reinitialise() {
        paquet = new Paquet(NB_CARTES);
        initialise();
    }
}
