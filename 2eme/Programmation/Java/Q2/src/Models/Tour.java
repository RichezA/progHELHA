package Models;

<<<<<<< HEAD
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

=======
public class Tour extends Piece{
    public Tour(int dx, int dy){
        super(dx, dy);
        this.nom = "Tour";
    }

    @Override
    public String getNom(){
        return this.nom;
>>>>>>> e1b24de833333f32dc43e3f5b1eb5c4a9de65d34
    }
}
