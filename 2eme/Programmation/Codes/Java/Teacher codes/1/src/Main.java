import models.Personne;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        // args et for, foreach
//        for(int i = 0; i < args.length; i++ ) {
//            System.out.println(args[i]);
//        }
//        for(String s : args) {
//            System.out.println(s);
//        }

        // Scanner

//        Scanner scanner = new Scanner(System.in);
//        while(true) {
//            try {
//                System.out.println("Entrez un chiffre : ");
//                int i = scanner.nextInt();
//                System.out.println("Vous avez écrit : " + i);
//                if (i == -1) {
//                    break;
//                }
//            }catch(InputMismatchException e) {
//                scanner.next();
//            }
//        }
//        scanner.close();


        // types de base
//        byte b = 127;
//        b++;
//        System.out.println(b);
//
//        double d = 2.5;
//        Double objectD = 2.5;
//
//        double d2 = Double.parseDouble("2.67");
//        System.out.println(d2);
//
//        int i = 256;
//        Integer objectI = 256;

        // Création d'objets
//        System.out.println("Nb personnes : " + Personne.getNbPersonnes());
//        Personne personne = new Personne();
//        System.out.println(personne);
//        System.out.println("Nb personnes : " + Personne.getNbPersonnes());
////        personne.delete();
//        personne = new Personne("Hue");
//        System.out.println(personne.toString());
//        System.out.println("Nb personnes : " + Personne.getNbPersonnes());
////        personne.delete();
//        System.out.println("Nb personnes : " + Personne.getNbPersonnes());
////        System.gc();

        // tableaux

        int tabIntegers[] = new int[10];
        int[] tabIntegers2 = new int[10];
        Object[] personnes = new Object[10];
        for (int i = 0; i < personnes.length; i++) {
            if (i != 5) {
                personnes[i] = new Personne("Nom " + i, "Prenom " + i);
            } else {
                personnes[i] = "5e personne :D";
            }
        }

        for (Object p: personnes) {
            if (p instanceof Personne) {
                System.out.print("Une personne : ");
            }
            System.out.println(p);
        }

        int[][] tabs2D = new int[4][4];
        tabs2D[2][2] = 4;
        for (int i = 0; i < tabs2D.length; i++) {
            for (int j = 0; j < tabs2D[i].length; j++) {
                System.out.print(tabs2D[i][j] + " ");
            }
            System.out.println();
        }

        ArrayList<Personne> list = new ArrayList();
        list.add(new Personne());
        list.add(new Personne());

        list.remove(0);
        System.out.println(list.get(0));
        for(Personne o : list) {
            System.out.println(o);
        }

    }

}
