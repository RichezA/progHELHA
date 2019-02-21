package Models;

import java.util.Scanner;

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
        System.out.println();
    }

    public void setCase(Piece piece){
        if(piece instanceof Tour){
            System.out.println("H/V?");
            char choix = askDerive();
            if(choix == 'H' || choix == 'h') {
                echiquier[piece.positionX][piece.positionY].setPieceSurCase(null);
                piece.seDeplacer(askX());
                echiquier[piece.positionX][piece.positionY].setPieceSurCase(piece);
            }
            else{
                echiquier[piece.positionX][piece.positionY].setPieceSurCase(null);
                afficheEchiquier();
                piece.positionY += askY();
                echiquier[piece.positionX][piece.positionY].setPieceSurCase(piece);
            }
        }
        else{
            int dx = askX();
            echiquier[piece.positionX][piece.positionY].setPieceSurCase(null);
            piece.seDeplacer(dx);
            echiquier[piece.positionX][piece.positionY].setPieceSurCase(piece);
        }



    }
    private char askDerive(){
        Scanner scan = new Scanner(System.in);
        char choice = scan.next().charAt(0);
        if(choice == 'H' || choice == 'V' || choice == 'h' || choice == 'v') return choice;
        else {
            throw new RuntimeException("Pas possible");
        }
    }
    private int askX(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Deplacement x ?");
        return scan.nextInt();
    }
    private int askY(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Déplacement y ?");
        return scan.nextInt();
    }


    public void initCase(int dx, int dy, Piece piece){
        echiquier[dx][dy].setPieceSurCase(piece);
    }
}
