import java.util.*;

public class Exercice1 {

    public static void main(String[] args) {

        double tableau []= new double [5];

        // vérifie que les 5 nombres sont bien passés en argument
        if (args.length == tableau.length) {                                                    // si oui =>

            for (int i = 0; i < args.length; i++) {                                             // on fait une boucle qui va jusque args.length
                tableau[i] = Double.parseDouble(args[i]);                                         // on cast les args en int et on les stocke dans le tableau
            }

        } else {                                                                                // si pas =>

            for (int i = 0; i < tableau.length; i++) {                                          // on parcourt sur toute la longueur du tableau
                boolean isDefined = false;                                                      // on met à false
                do {                                                                            // on fait ->
                    try {                                                                       // on essaie de faire -->
                        tableau[i] = UI.askDouble("Entrez un nombre sur 32 bits: ");// on demande un byte en console avec une question
                        isDefined = true;                                                       // si c'est bon le boolean passe à true
                    } catch (OutOfBoundsException e) {                                          // si erreur -->
                        System.out.println("Mauvais nombre...");                                // on print un message en console
                    }
                } while (!isDefined);                                                           // on fait -> le temps que le boolean est false (permet de boucler si mauvais input)
            }

        }

        System.out.println("Voici le tableau avant le tri: "+Arrays.toString(tableau));         // on affiche le tableau en le castant en string

        tableau = Outils.insertionSortIntArray(tableau);                                           // on applique le tri à bulle
        System.out.println("Voici votre tableau trié: "+Arrays.toString(tableau));              // on affiche le tableau trié en le castant en string
    }
}
    
