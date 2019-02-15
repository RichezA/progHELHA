package be.helha.bataille;

public class Carte {
    private int value;
    private Couleur couleur;

    public Carte(int value, Couleur couleur) {
        this.value = value;
        this.couleur = couleur;
    }


    @Override
    public String toString() {
        String name;
        switch (value) {
            case 1:
                name = "As";
                break;
            case 11:
                name = "Valet";
                break;
            case 12:
                name = "Dame";
                break;
            case 13:
                name = "Roi";
                break;
            default:
                name = String.valueOf(value);
        }

        return name + " de " + couleur.name().toLowerCase();
    }

    public boolean estAvant(Carte carte) {
        // si notre carte est plus petite => si on perd
        if(carte.getValue() == 1){
            return true;
        }
        else if (this.getValue() == 1){
            return false;
        }
        else{
            return this.value < carte.value;
        }

    }
    public Couleur getCouleur(){ return this.couleur;}
    public int getValue(){return this.value;}
}
