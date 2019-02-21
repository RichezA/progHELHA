package Models;

public class Main {
    public static void main(String[] args){
        Echiquier ech = new Echiquier();
        Pion pi = new Pion(1,2);
        Tour t = new Tour(0, 1);
        ech.initCase(1,2, pi);
        ech.initCase(0,1,t);
        ech.afficheEchiquier();
        ech.setCase(pi);
        ech.afficheEchiquier();
        ech.setCase(t);
        ech.afficheEchiquier();

    }
}
