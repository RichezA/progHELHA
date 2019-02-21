package Models;

public abstract class Piece {
    int positionX, positionY;
    String nom;
    public Piece(int x, int y){
        this.positionX = x;
        this.positionY = y;
        this.nom = "Piece";
    }
    public void deplacer(int nbCases){
        throw new MouvementImpossibleException();
    }
    public String getNom(){
        return this.nom;
    }
}
