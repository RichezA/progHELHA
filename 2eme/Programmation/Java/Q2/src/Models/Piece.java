package Models;

public abstract class Piece {
    protected  int positionX, positionY;
    String nom;
    public Piece(int positionX, int positionY){
        this.positionX = positionX;
        this.positionY = positionY;
        this.nom = "Piece";
    }

    public abstract void seDeplacer(int dx);

    public String getNom(){
        return nom;
    }
}
