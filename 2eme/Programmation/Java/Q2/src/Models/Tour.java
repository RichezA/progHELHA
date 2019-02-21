package Models;

import java.util.Scanner;

public class Tour extends Piece{
    public Tour(int dx, int dy){
        super(dx, dy);
        this.nom = "Tour";
    }

    @Override
    public void seDeplacer(int dx) {

        this.positionX += dx;

    }

    @Override
    public String getNom(){
        return this.nom;
    }
}
