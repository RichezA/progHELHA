package Models;

public class Case {
    int positionX, positionY;
    Piece currentPiece;
<<<<<<< HEAD
    public Case(int x, int y){
=======
    public Case(int x, int y, Piece currentPiece){
>>>>>>> e1b24de833333f32dc43e3f5b1eb5c4a9de65d34
        this.positionX = x;
        this.positionY = y;
        this.currentPiece = currentPiece;
    }

<<<<<<< HEAD
    @Override
    public String toString(){
        if(currentPiece.getNom() == "Pion") return "P";
        else if(currentPiece.getNom() == "Tour") return "T";
        else return "-";
=======
    public int getPositionX(){
        return this.positionX;
    }
    public int getPositionY(){
        return this.positionY;
    }

    @Override
    public String toString(){
        if(this.currentPiece == null) return "-";
        else if(this.currentPiece.getNom() == "Tour") return "T";
        else if(this.currentPiece.getNom() == "Pion") return "P";
        return "!";
    }

    public void setPieceSurCase(Piece piece){
        this.currentPiece = piece;
>>>>>>> e1b24de833333f32dc43e3f5b1eb5c4a9de65d34
    }
}
