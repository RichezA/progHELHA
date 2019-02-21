package Models;

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
}
