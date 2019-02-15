package Models;

public class SecondMain{
    public static void main(String[] args) {
        Personne personne; // pas créé car pas de new
        personne = new Personne();
        personne.nom = ""; // on peut car scope package
        System.out.println(personne); // si pas d'override Models.Personne@IDJVM
    }
}