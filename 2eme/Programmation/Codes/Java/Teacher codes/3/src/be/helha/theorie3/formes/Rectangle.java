package be.helha.theorie3.formes;

import java.awt.*;

public class Rectangle extends Forme {


    private int largeur;
    private int longueur;

    public Rectangle(Point centre, int largeur, int longueur) {
        super(centre);
        this.largeur = largeur;
        this.longueur = longueur;
    }

    @Override
    public double getSurface() {
        Surfacable s = new Surfacable() {
            @Override
            public double getSurface() {
                return /*Rectangle.this.getSurface()*/ largeur * longueur;
            }
        };
        return s.getSurface();
    }

    @Override
    public double getPerimetre() {
        return 2 * largeur + 2 * longueur;
    }
}
