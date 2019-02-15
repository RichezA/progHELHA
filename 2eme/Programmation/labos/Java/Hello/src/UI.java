import java.util.Scanner;

public class UI {

    public static String ask(String question) {
        System.out.println(question);                // print une question qui est passé en argument
        Scanner scan = new Scanner(System.in);      // On utilise un scanner pour lire une entrée
        String result = scan.nextLine();            // on lit la prochaine ligne rentré en console

        return result;                              // on retourne la réponse
    }

    public static double askDouble(String question) {
        double value;                                   // déclaration de la valeur que l'on veut avoir
        try {
            value = Double.parseDouble(ask(question));  // on appelle la question ask avec une question et on parse le retour en double et on stocke
        } catch (Exception e) {                         // si on rencontre une exception de n'importe quel type
            throw new OutOfBoundsException();           // on throw une OutOfBoundsException
        }
        return value;                                   // on retourne la valeur
    }

    public static int askInt(String question) {
        int value;                                      // déclaration de valeur
        try {
            value = Integer.parseInt(ask(question));    // on pose une question (demandée en paramètre) et on parse son résultat en int qu'on stocke
        } catch (Exception e) {                         // si on rencontre une exception quelconque
            throw new OutOfBoundsException();           // on throw une OutOfBoundsException
        }
        return value;                                   // on retourne la valeur
    }

    public static Byte askByte(String question) {
        Byte monByte = (byte) askIntBetween(question, 0, 127);  // on appelle la méthode et on passe en paramètre le chiffre min et max
                                                                            // qu'on parsera en byte et qu'on stockera
        return monByte;                                                     // on retourne la valeur
    }

    public static int askIntBetween(String question, int min, int max) {
        int monInt = askInt(question);                              // on call la méthode askInt avec la question passée en paramètre qu'on stocke
        if (monInt <= max && monInt >= min) {                       // condition pour savoir si le int est plus petit ou plus grand que les limites
            return monInt;                                          // passées en paramètres, si c'est bon -> on retourne la valeur
        } else {
            throw new OutOfBoundsException();                       // si pas on throw une OutOfBoundsException
        }
    }
}
