import models.*;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.time.Instant;
import java.util.Date;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try {
            Socket toServerSocket =  new Socket("10.11.1.229", 10999);
            ObjectOutputStream oout = new ObjectOutputStream(toServerSocket.getOutputStream());
            ObjectInputStream oin = new ObjectInputStream(toServerSocket.getInputStream());
                // Messagerie
            //oout.writeObject(getString());
            //TODO: Envoyer une opération et recevoir la réponse
            while(true){
                oout.writeObject(getCalculus());
                System.out.println("Result: " + oin.readObject());
            }
        } catch(IOException e) {
            e.printStackTrace();
            System.err.println("Le client ne peut pas se connecter au serveur...");
        } catch(ClassNotFoundException e){
            System.err.println("Type not known");
        }
    }

    private static Operation getCalculus() {
            System.out.print("Enter your calculus: ");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            String[] tab = input.split(" ");
            switch ((String)tab[1]){
                case "+":
                    return new Add(Integer.parseInt(tab[0]), Integer.parseInt(tab[2]));
                case "*":
                    return new Pow(Integer.parseInt(tab[0]), Integer.parseInt(tab[2]));
                case "/":
                    return new Sub(Integer.parseInt(tab[0]), Integer.parseInt(tab[2]));
                default:
                    System.err.println("Operator not implemented yet");
                    break;
            }
            return null;
    }


    private static Message getString() {
        System.out.print("Quel est votre phrase: ");
        Scanner scanner = new Scanner(System.in);
        return new Message(scanner.nextLine(), new User("Fred"), Date.from(Instant.now()));
    }
}
