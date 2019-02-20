package Models;

public class Main {
    public static void main(String[] args){
        Echiquier ech = new Echiquier();
        ech.afficheEchiquier();
        ech.setCase(0,1, new Tour(0,1));
    }
}
