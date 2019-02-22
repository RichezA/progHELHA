package be.helha.bataille.modeles;

import java.util.Scanner;

public class Joueur {
    private Paquet paquet = new Paquet(Jeu.NB_CARTES);
    private int score = 0;
    private int index = 0;


    public void addCarte(Carte carte) {
        paquet.ajouterUneCarte(carte);
    }

    public Carte donnerCarte() {
        Scanner scan = new Scanner(System.in);
        this.showPaquet();
        index = scan.nextInt();
        return paquet.tirerUneCarte(index);
    }

    public void retireCarte(){ this.paquet.retireCarte(index);}

    public void showPaquet(){
        System.out.println(this.paquet);
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
