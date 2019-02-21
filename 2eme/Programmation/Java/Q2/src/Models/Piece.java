package Models;

public abstract class Piece {
    int positionX, positionY;
    String nom;
<<<<<<< HEAD
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
=======
    public Piece(int positionX, int positionY){
        this.positionX = positionX;
        this.positionY = positionY;
        this.nom = "Piece";
    }

    public String getNom(){
        return nom;
>>>>>>> e1b24de833333f32dc43e3f5b1eb5c4a9de65d34
    }
}
