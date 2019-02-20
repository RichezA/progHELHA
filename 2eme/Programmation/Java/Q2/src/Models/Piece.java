package Models;

public abstract class Piece {
    int positionX, positionY;
    String nom;
    public Piece(int positionX, int positionY){
        this.positionX = positionX;
        this.positionY = positionY;
        this.nom = "Piece";
    }

    public String getNom(){
        return nom;
    }
}
