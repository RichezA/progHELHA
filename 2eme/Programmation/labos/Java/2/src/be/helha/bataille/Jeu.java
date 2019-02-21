package be.helha.bataille;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Jeu {
    public static final int NB_CARTES = 52;
    private Carte[] cartes = new Carte[NB_CARTES];
    private int nbCartesActuelles = 0;
    private Joueur[] joueurs;
    public final int nbJoueurs = 2;



    public Jeu() {
        this.initialise();
        this.mélanger();
        this.joueurs = new Joueur[2];
        this.initialiseJoueur();
        this.distribuerCartes();


    }

    // PRIVATE METHODS
    private void initialiseJoueur(){
        for(int i = 0; i < nbJoueurs; i++ ){
            joueurs[i] = new Joueur();
        }
        System.out.println();
    }

    private void initialise() {
        // TODO : Remplir le tableau de cartes des 52 cartes ordinaires (13 par couleur) => done
        int nbCartesParCouleur = 13;
        int index = 0;
            for (Couleur c : Couleur.values()) {
                for (int j = 1; j <= nbCartesParCouleur; j++) {
                    cartes[index] = new Carte(j, c);
                    nbCartesActuelles++;
                    index++;
                }
            }
    }

    private void mélanger() {
        Collections.shuffle(Arrays.asList(cartes));
    }

    private void distribuerCartes(){
        for(int i = 0; i < this.cartes.length; i += 2){
            joueurs[0].ajouterUneCarte(cartes[i]);
            joueurs[1].ajouterUneCarte(cartes[i + 1]);
        }
        this.afficherJoueur();
    }

    private void afficherResultat(){
        if(joueurs[0].getScore() > joueurs[1].getScore()) System.out.println("Joueur " + joueurs[0].getNom() +" a gagné! Score: " + joueurs[0].getScore() + "\nJoueur " + joueurs[1].getNom() + " a perdu! Score: " + joueurs[1].getScore());
        else if(joueurs[1].getScore() > joueurs[0].getScore()) System.out.println("Joueur " + joueurs[1].getNom() +" a gagné! Score: " + joueurs[1].getScore() + "\nJoueur " + joueurs[0].getNom() + " a perdu! Score: " + joueurs[0].getScore());
        else System.out.println("Égalité");
    }

    private void joueur1Gagne(Carte carteJ1, Carte carteJ2){
        String j1gagne = "Joueur " + joueurs[0].getNom() +" a gagné! Score: " + joueurs[0].getScore();
        String j2perd = "Joueur " + joueurs[1].getNom() + " a perdu! Score: " + joueurs[1].getScore();

        System.out.println(carteJ1.toString() + " contre " + carteJ2.toString());
        joueurs[0].ajouterUneCarte(carteJ1);
        joueurs[0].ajouterUneCarte(carteJ2);
        joueurs[0].mancheGagnee();
        System.out.println(j1gagne);
        System.out.println(j2perd);
    }

    private void joueur2Gagne(Carte carteJ1, Carte carteJ2){
        String j1perd = "Joueur " + joueurs[0].getNom() + " a perdu! Score: " + joueurs[0].getScore();
        String j2gagne = "Joueur " + joueurs[1].getNom() +" a gagné! Score: " + joueurs[1].getScore();

        System.out.println(carteJ1.toString() + " contre " + carteJ2.toString());
        joueurs[1].ajouterUneCarte(carteJ1);
        joueurs[1].ajouterUneCarte(carteJ2);
        joueurs[1].mancheGagnee();
        System.out.println(j1perd);
        System.out.println(j2gagne);
    }


    // PUBLIC METHODS

    public void afficher() {
        for (Carte carte : cartes) {
            System.out.println(carte);
        }
    }

    public void afficherJoueur(){
        for(Joueur j: joueurs) {
            System.out.println(j);
        }
    }

    public void demarrerJeu() {
        while(joueurs[0].getPaquet().size() != 0 || joueurs[1].getPaquet().size() != 0) {
            Carte cartes[] = new Carte[joueurs.length];
            for (int i = 0; i < joueurs.length; i++) {
                cartes[i] = joueurs[i].tireUneCarte();
                joueurs[i].retireCarte();
            }

            if (cartes[0].estAvant(cartes[1])) {
                joueurs[1].mancheGagnee();
            } else joueurs[0].mancheGagnee();
            System.out.println();
        }
        this.afficherResultat();
    }



    // GET
    public Carte getCarte(int index){ return this.cartes[index]; }
    public Carte[] getTableau(){ return this.cartes.clone(); }
    public int getNbCartes(){
        return this.nbCartesActuelles;
    }
    public int getNbCouleurs(){
        int couleurs = 0;
        for(int i = 0; i < cartes.length; i++){
            for(Couleur color: Couleur.values()){
                if(cartes[i].getCouleur() == color && i % 13 == 0){
                    couleurs++;
                }
            }
        }
        return couleurs;
    }
    public int[] getNbCartesParCouleur(){
        // être sur qu'il y'a bien 13 cartes par couleur
        int[] cartesAvecCouleurs = new int[4];
        for(int i = 0; i < cartes.length; i++)
        {
            switch(cartes[i].getCouleur()){
                case CARREAU:
                    cartesAvecCouleurs[0]++;
                    break;
                case COEUR:
                    cartesAvecCouleurs[1]++;
                    break;
                case PIQUE:
                    cartesAvecCouleurs[2]++;
                    break;
                case TREFFLE:
                    cartesAvecCouleurs[3]++;
                    break;
                default:
                    System.out.println("Pas d'enum correspondant");
                    break;
            }

        }
        return cartesAvecCouleurs;
    }

}
