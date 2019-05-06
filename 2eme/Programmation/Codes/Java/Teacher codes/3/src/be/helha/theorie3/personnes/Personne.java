package be.helha.theorie3.personnes;

public class Personne {
    protected Date dateNaissance;
    protected String nom;
    protected String prenom;
    protected Adresse adresse;

    class Adresse {

        protected String rue;
        protected int numero;

        public Adresse(String rue, int numero) {
            this.rue = rue;
            this.numero = numero;
        }

        String getNom() {
            return rue;
        }

        @Override
        public String toString() {
            return "Je suis l'adresse de :" + Personne.this.getNom();
        }
    }

    static class Date{

        int jour;
        int mois;
        int annee;

        public Date(int jour, int mois, int annee) {
            this.jour = jour;
            this.mois = mois;
            this.annee = annee;
        }

    }

    private static int getI() { return 10;}

    public Personne(String nom, String prenom, String rue, int numero) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = new Adresse(rue, numero);
        this.dateNaissance = new Date(5,6,12);
        System.out.println(adresse);
    }

    public String getNom() {
        return nom;
    }

    @Override
    public String toString() {
        return nom + ", " + prenom;
    }



    public static void main(String[] args) {
        Personne personne = new Personne("Pluquet", "Fred", "Avenue Rogier", 12);
        //System.out.println(personne);
    }
}
