import Models.Personne;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(true /*args.length < 100*/)
        {
//            String s = scanner.next();
//            System.out.println("Vous avez écrit: " + s);
            try{
                int i = scanner.nextInt();
                System.out.println("Vous avez écrit: " + i);
                if(i == -1)
                {
                    break;
                }
            }catch(InputMismatchException e){
                // sinon boucle infinie car on rentre direct dans le catch
                scanner.next();
            }
        }
        //scanner.close(); // pas obligé car auto close

        //FOREACH
        for(String s: args){
            System.out.println(s);
        }

        //TYPES
        double d = 2.5; // type de base => pas de méthodes
        Double objectD = 2.5; // type primitifs => méthodes

        double d2 = Double.parseDouble("2.67");
        System.out.println(d2);

        int i = 256;
        Integer objectI = i;

        //System.gc(); // call le garbage collector
        int tabIntegers[] = new int[10];
        int[] tabIntegers2 = new int[10];
        Personne[] personnes = new Personne[10];
        Object[] objetArray = new Object[10];
        for(int j = 0; j < personnes.length; j++){
            if(j != 5) {
                objetArray[j] = new Personne("Nom " + j, "Prenom " + j);
            }
            else objetArray[j] = 5;
        }
        for(Object p : objetArray){
            if(p instanceof Personne){
                System.out.println("Une personne: ");
            }
            System.out.println(p);
        }

        int[][] tab2D = new int[4][4];
        tab2D[2][2] = 4;
        for(int k = 0; k < tab2D.length; k++){
            for(int l = 0; l < tab2D[k].length; l++){
                System.out.print(tab2D[k][l]);
            }
            System.out.println();
        }

        ArrayList list = new ArrayList(); // object par défaut
        list.add(1);
        list.add(new Personne());

        ArrayList<Personne> listePersonnes = new ArrayList<Personne>();

        list.remove(0);
        System.out.println(list.get(0));
        for(Object o: list){
            System.out.println(o);
        }
    }
}

