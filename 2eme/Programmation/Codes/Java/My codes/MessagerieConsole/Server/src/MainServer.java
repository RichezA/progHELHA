import com.sun.security.ntlm.Server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class MainServer {
    // TODO: Calculatrice facile
//    public static void main(String[] args) {
//        try{
//            ServerSocket serverSocket = new ServerSocket(10999);
//            while(true){
//                Socket toClientSocket = serverSocket.accept();
//                manageClient(toClientSocket);
//                toClientSocket.close();
//            }
//        }catch(IOException e){
//            System.err.println("Le serveur ne démarre pas");
//        } catch (ClassNotFoundException e) {
//            System.err.println("Problème de lecture...");
//        }

    // TODO: Dire combien de lettres apparaissent dans une phrase envoyée
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(10999);
            System.out.println("Server is running...");
            while(true) {
                Socket toClientSocket = serverSocket.accept();

                manageClient(toClientSocket);
                toClientSocket.close();
                System.out.println("Client déconnecté");
            }
        }catch(IOException e) {
            System.err.println("Le serveur n'a pas pu démarrer.");
        }catch(ClassNotFoundException e) {
            System.err.println("Problème de lecture...");
        }

    }

    private static void manageClient(Socket toClientSocket) throws IOException, ClassNotFoundException {
        ObjectOutputStream oout = new ObjectOutputStream(toClientSocket.getOutputStream());
        ObjectInputStream oin = new ObjectInputStream(toClientSocket.getInputStream());
        System.out.println("Client connecté");

        String phrase = (String) oin.readObject();
        oout.writeObject(manageString(phrase));
    }

    private static Map<Character, Integer> manageString(String phrase) {
        int length = phrase.length();

        Map<Character, Integer> charOccurences = new HashMap<Character, Integer>();

        for(int i = 0; i < length; i++){
            char charAt = phrase.charAt(i);

            if(!charOccurences.containsKey(charAt)){
                charOccurences.put(charAt, 1);
            }
            else{
                charOccurences.put(charAt, charOccurences.get(charAt) + 1);
            }
        }
        /*
        *   for(Character c : phrase.toCharArray()){
        *       int i = charOccurences.getOrDefault(c, 0);
        *       map.put(c, i + 1);
        *   }
        *   for(Character c : map.keySet()){
        *       oout.writeObject(c);
        *       oout.writeObject(map.get(c));
        *   }
        *   oout.writeObject("\0");
        */
        return charOccurences;
    }


}

//    private static void manageClient(Socket toClientSocket) throws IOException, ClassNotFoundException {
//        OutputStream out = toClientSocket.getOutputStream(); // OUTPUT TOUJOURS EN PREMIER
//        InputStream in = toClientSocket.getInputStream();
//        ObjectOutputStream oout = new ObjectOutputStream(out);
//        ObjectInputStream oin = new ObjectInputStream(in);
//        System.out.println("Client connecté");
//        // possible comme ça aussi
//        //ObjectInputStream oin = toClientSocket.getInputStream();
//
//
//        String operation = (String) oin.readObject();
//        int fstOperand = (Integer) oin.readObject();
//        int sndOperand = (Integer) oin.readObject();
//        int result = -1;
//        if (operation.equals("add")){
//            result = fstOperand + sndOperand;
//        }
//        oout.writeObject(result);
//    }

