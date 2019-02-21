package Models;

<<<<<<< HEAD
public class Pion extends Piece{
    boolean firstMove;

    public Pion(int x, int y){
        super(x,y);
        firstMove = true;
        this.nom = "Pion";
    }
    @Override
    public void deplacer(int nbCases) {
        try{
            if(firstMove){
                this.positionY += 2;
            }
            else if(nbCases == 1){
                this.positionY++;
            }
            else{
                throw new MouvementImpossibleException();
            }
        }catch(MouvementImpossibleException r){
            System.out.println(r);
        }
    }
=======
public class Pion extends Piece {
    public Pion(int dx, int dy){
        super(dx, dy);
        this.nom = "Pion";
    }
>>>>>>> e1b24de833333f32dc43e3f5b1eb5c4a9de65d34
}
