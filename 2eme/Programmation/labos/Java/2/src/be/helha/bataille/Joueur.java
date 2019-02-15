package be.helha.bataille;

import java.util.ArrayList;
import java.util.Scanner;

public class Joueur {
    private String nom;
    private ArrayList<Carte> paquet;
    private int score;

    public Joueur(){
        this.nom = setNom();
        this.score = 0;
        this.paquet = new ArrayList<Carte>();
    }
    // GET

    public int getScore(){
        return this.score;
    }
    public String getNom(){
        return this.nom;
    }
    public ArrayList<Carte> getPaquet(){
        ArrayList<Carte> paquetCopy = new ArrayList<Carte>();
        paquetCopy.addAll(this.paquet);
        return paquetCopy;
    }


    //SET
    private String setNom(){
        System.out.print("Veuillez entrer le nom du joueur: ");
        Scanner scan = new Scanner(System.in);
        return scan.nextLine();
    }

    public void tireUneCarte(int index){
        this.paquet.remove(index);
    }
    public void ajouterUneCarte(Carte c){
        this.paquet.add(c);
    }
    public void mancheGagnee(){
        this.score++;
    }

    @Override
    public String toString(){
        return "Paquet du Joueur " + this.nom + ":\n" + this.getPaquet();
    }
}
