package be.helha.theorie3.formes;

import java.awt.*;

public class Cercle extends Forme {

    protected int rayon;

    public Cercle(Point centre, int rayon) {
        super(centre);
        this.rayon = rayon;
    }

    public Cercle(Point centre, double rayon) {
        this(centre, (int)rayon);
//        super(centre);
    }

    @Override
    public double getSurface() {
        return Math.PI * rayon * rayon;
    }

    @Override
    public String getNom() {
        return super.getNom();
    }


    @Override
    public double getPerimetre() {
        return 2 * Math.PI * rayon;
    }

}
