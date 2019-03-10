package models;

public class Personne /* extends Object */ {

    private String nom;
    private String prenom;
    private static int nbPersonnes = 0;
    private static final int MAX_NB_PERSONNES = 1;

    public Personne() {
        // this.nom = "Pluquet";
        this("Pluquet");
    }
    public Personne(int nom) {
        this(Integer.toString(nom));
    }

    public Personne(String nom) {
        this(nom, "Henri");
    }

    public Personne(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
        nbPersonnes++;
        if (nbPersonnes > MAX_NB_PERSONNES) {
            System.err.println("Trop de gens !!!");
        }
    }

    public static int getNbPersonnes() {
        return nbPersonnes;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    @Override
    public String toString() {
        return "Personne{nom='"
                + nom + "', prenom='" + prenom + "'}";
    }

    public void delete(){
        try {
            finalize();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("Personne supprimée : " + this);
        nbPersonnes--;
    }
}
