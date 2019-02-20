package Models;

public class Tour extends Piece{
    public Tour(int dx, int dy){
        super(dx, dy);
        this.nom = "Tour";
    }

    @Override
    public String getNom(){
        return this.nom;
    }
}
