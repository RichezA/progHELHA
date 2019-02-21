package Models;

import java.util.Scanner;

public class Tour extends Piece {
    String direction;

    public Tour(int x, int y){
        super(x,y);
        this.nom = "Tour";
    }
    @Override
    public void deplacer(int nbCases) {
        try{
            System.out.println("H/V");
            Scanner scanner = new Scanner(System.in);
            direction =  scanner.next();
            if(direction == "H") this.positionX += nbCases;
            else if(direction== "V") this.positionY += nbCases;
            else throw new MouvementImpossibleException();
        }catch(MouvementImpossibleException r){
            System.out.println(r);
        }

    }
}
