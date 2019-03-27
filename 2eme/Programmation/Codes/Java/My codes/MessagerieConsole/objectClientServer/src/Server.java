import models.Message;
import models.Operation;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class Server {
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

        // Messagerie
//        Message phrase = (Message) oin.readObject();
//        System.out.println("[" + phrase.getDate() + "]: " + phrase.getUser().getName() + ": " + phrase.getText());
        // TODO: Calculatrice Renvoie l'opération demandée
        while(true){
            Operation calculus = (Operation) oin.readObject();
            if(calculus != null) oout.writeObject(calculus.apply());
            else throw new RuntimeException("Calculus not valid");
        }

    }
}
