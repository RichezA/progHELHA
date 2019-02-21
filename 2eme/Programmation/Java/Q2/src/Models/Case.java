package Models;

public class Case {
    int positionX, positionY;
    Piece currentPiece;
    public Case(int x, int y){
        this.positionX = x;
        this.positionY = y;
        this.currentPiece = currentPiece;
    }

    @Override
    public String toString(){
        if(currentPiece.getNom() == "Pion") return "P";
        else if(currentPiece.getNom() == "Tour") return "T";
        else return "-";
    }
}
