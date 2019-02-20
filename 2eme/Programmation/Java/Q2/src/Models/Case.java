package Models;

public class Case {
    int positionX, positionY;
    Piece currentPiece;
    public Case(int x, int y, Piece currentPiece){
        this.positionX = x;
        this.positionY = y;
        this.currentPiece = currentPiece;
    }

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
    }
}
