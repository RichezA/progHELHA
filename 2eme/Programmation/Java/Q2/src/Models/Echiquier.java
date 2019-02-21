package Models;

public class Echiquier {
    public static final int echLENGTH = 10;
    Case[][] echiquier;

    public Echiquier(){
        for(int i = 0; i < echLENGTH; i++){
            for(int j = 0; j < echLENGTH;j++){
                echiquier[i][j] = new Case(i,j);
            }
        }
    }

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
    }
}
