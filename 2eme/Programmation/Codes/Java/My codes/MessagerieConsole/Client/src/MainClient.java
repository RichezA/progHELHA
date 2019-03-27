import com.sun.org.apache.bcel.internal.generic.ARRAYLENGTH;

import java.io.*;
import java.net.Socket;
import java.util.*;

public class MainClient {
    // Calculatrice facile
//    public static void main(String[] args) {
//        try {
//            Socket toServerSocket = new Socket("localhost", 10999);
//
//            OutputStream out = toServerSocket.getOutputStream(); // OUTPUT TOUJOURS EN PREMIER
//            InputStream in = toServerSocket.getInputStream();
//            ObjectOutputStream oout = new ObjectOutputStream(out);
//            ObjectInputStream oin = new ObjectInputStream(in);
//
//            oout.writeObject("add");
//            oout.writeObject(getInt());
//            oout.writeObject(getInt());
//            int result = (Integer) oin.readObject();
//            System.out.println("Le résultat est: " + result);
//        } catch (IOException e) {
//            System.err.println("Client ne peut pas se connecter");
//        } catch (ClassNotFoundException e){
//            System.err.println("Problème de lecture....");
//        }

    // TODO: Envoyer un message au serveur et le recevoir
    public static void main(String[] args) {
        try {
            Socket toServerSocket =  new Socket("localhost", 10999);
            ObjectOutputStream oout = new ObjectOutputStream(toServerSocket.getOutputStream());
            ObjectInputStream oin = new ObjectInputStream(toServerSocket.getInputStream());

            oout.writeObject(getString());
            Map<Character, Integer> result = (HashMap<Character, Integer>) oin.readObject();
            manageResult(result);
        } catch(IOException e) {
            System.err.println("Le client ne peut pas se connecter au serveur...");
        } catch(ClassNotFoundException e){
            System.err.println("Classe non trouvé");
        }
    }

    private static void manageResult(Map<Character, Integer> map) {
        for(Map.Entry k: map.entrySet()){
            System.out.println("Occurences of the character \"" + k.getKey() + "\": " + k.getValue());
        }
    }

    private static String getString() {
        System.out.print("Quel est votre phrase: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

//    private static int getInt() {
//        System.out.println("Quelle est votre opérande?");
//        Scanner scanner = new Scanner(System.in);
//        return scanner.nextInt();
//    }
}
