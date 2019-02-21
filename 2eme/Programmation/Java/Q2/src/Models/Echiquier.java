package Models;

public class Echiquier {
<<<<<<< HEAD
    public static final int echLENGTH = 10;
    Case[][] echiquier;

    public Echiquier(){
        for(int i = 0; i < echLENGTH; i++){
            for(int j = 0; j < echLENGTH;j++){
                echiquier[i][j] = new Case(i,j);
=======
    Case[][] echiquier;
    public final int length = 8;

    public Echiquier(){
        echiquier = new Case[length][length];
        for(int i = 0; i < length; i++){
            for(int j = 0; j < length; j++){
                echiquier[i][j] = new Case(i,j, null);
>>>>>>> e1b24de833333f32dc43e3f5b1eb5c4a9de65d34
            }
        }
    }

<<<<<<< HEAD
    // TODO: MOVE DANS VIEWS
    public void afficheEchiquier(){
        for(int i = 0; i < echLENGTH; i++){
            for(int j = 0; j < echLENGTH; j++){
                System.out.println(echiquier[i][j]);
            }
        }
    }

    public void initEchiquier(){
        for(int i = 0; i < echLENGTH; i++){
            echiquier[0][i] =
        }
=======
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
>>>>>>> e1b24de833333f32dc43e3f5b1eb5c4a9de65d34
    }
}
