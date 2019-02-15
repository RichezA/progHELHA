package Models;

public class Personne /*extends Object*/ {
    String nom; // par défaut scope package
    String prenom;
    public static int nbPersonnes = 0;

    public Personne()
    {
        //this.nom = "Pluquet";
        this("Pluquet", "Alain");
        // ^ tjrs en premier
    }
    public Personne(int nom)
    {
        this(Integer.toString(nom));
    }
    public Personne(String nom){
        //this();
        //this.nom = nom;
        this(nom, "Henri");
    }
    public Personne(String nom, String prenom){
        this.nom = nom;
        this.prenom = prenom;
        nbPersonnes++;
    }

    public void delete(){
        try {
            finalize();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    public static int getNbPersonnes(){
        return nbPersonnes;
    }

    @Override // pas obligatoire mais bien pour se souvenir
    public String toString() {
        return "Personne{nom='" + nom + ", prenom='" + prenom +  '}';
    }
    @Override
    protected void finalize() throws Throwable{
        super.finalize();
        System.out.println("Personne supprimée: " + this);
        nbPersonnes--;
    }
}
