package Models;


public class Pion extends Piece {
    boolean firstMove;

    public Pion(int dx, int dy){
        super(dx, dy);
        this.nom = "Pion";
        this.firstMove = true;
    }

    @Override
    public void seDeplacer(int dx) {
        if(firstMove){
            this.positionX += 2;
            firstMove = false;
        }
        else{
            try{
                if(dx == 1) this.positionX++;
                else throw new DeplacementImpossibleException();
            }catch(DeplacementImpossibleException di){
                System.out.println(di);
            }
        }
    }
}
