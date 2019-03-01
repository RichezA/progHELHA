package be.helha.bataille.modeles;

import java.util.Objects;

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
        return this.value < carte.value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Carte carte = (Carte) o;
        return value == carte.value &&
                couleur == carte.couleur;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, couleur);
    }


    // getters
    public int getValue(){ return this.value;}
}
