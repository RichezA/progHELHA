package be.helha.theorie3.formes;

import java.awt.*;

public class Cercle extends Forme {

    protected int rayon;

    public Cercle(Point centre, int rayon) {
        super(centre);          // tjrs en premier
        this.rayon = rayon;
    }

    public Cercle(Point centre, double rayon) {
        this(centre, (int)rayon);   // délégation de ctor
//        super(centre);
    }

    @Override
    public double getSurface() {
        return Math.PI * rayon * rayon;
    } // implémentation de la méthode d'interface Surfacable

    @Override
    public String getNom() {
        return super.getNom();
    }


    @Override
    public double getPerimetre() {
        return 2 * Math.PI * rayon;
    } // implémentation de la méthode d'interface Perimetrable

}
