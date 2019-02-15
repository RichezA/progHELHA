
public class Outils {

//    public static int[] bubbleSortIntArray(int[] tableau) {
//        int i = 0;
//        boolean changed = true;                                         // boolean qui reste à true tant que le tableau n'est pas trié complétement
//        while (i < tableau.length && changed) {                         // pendant que i est plus petit que la longueur du tableau & que changed est true
//            changed = false;                                            // on passe changed à false (reste à false quand le tableau est totalement trié)
//            for (int index = 0; index < tableau.length - 1; index++) {  // boucle qui parcourt l'ensemble du tableau
//                if (tableau[index] > tableau[index + 1]) {              //  condition pour savoir si la valeur actuellement pointée est > que la précédente
//                    changed = true;
//                    int temp = tableau[index];                          // on met la valeur actuelle dans une var temporaire
//                    tableau[index] = tableau[index + 1];                // on met la valeur suivante dans l'index pointé
//                    tableau[index + 1] = temp;                             // on met la var temporaire dans la var suivante
//                }
//            }
//            i++;                                                        // on incrémente i
//        }
//        return tableau;                                                 // quand tout est trié => on retourne le tableau
//    }

    public static double[] insertionSortIntArray(double[] tableau){
        double min = 0.0;
        for(int i = 1; i < tableau.length; i++){
            min = tableau[i];
            int j = i;
            while(j > 0 && tableau[j - 1] > min){
                tableau[j] = tableau[j - 1];
                j--;
            }
            tableau[j] = min;
        }
        return tableau;
    }
}
