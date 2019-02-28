package be.helha.theorie3.formes;

import java.awt.*;

// abstract = pas d'instanciation
public abstract class Forme  implements Perimetrable, Surfacable {

    protected Point centre;

    public Forme(Point centre) {
        this.centre = centre;
    }

    public String getNom() {
        return "Forme";
    }

    public String getHelloStr() {
        return "Je suis : " + this.getNom();
    }
}
