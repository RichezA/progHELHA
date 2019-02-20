package Models;

public class Echiquier {
    Case[][] echiquier;
    public final int length = 8;

    public Echiquier(){
        echiquier = new Case[length][length];
        for(int i = 0; i < length; i++){
            for(int j = 0; j < length; j++){
                echiquier[i][j] = new Case(i,j, null);
            }
        }
    }

    public void afficheEchiquier(){
        for(int i = 0; i < length; i++){
            for(int j = 0; j < length; j++){
                System.out.print(echiquier[i][j]);
            }
            System.out.println();
        }
    }

    public void setCase(int dx, int dy, Piece piece){
        echiquier[dx][dy].setPieceSurCase(piece);
    }
}
