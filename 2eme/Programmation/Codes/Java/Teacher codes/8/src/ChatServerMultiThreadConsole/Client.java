package ChatServerMultiThreadConsole;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {
        Client client = new Client();
        client.go();
    }

    private void go() {
        try {
            Socket socket = new Socket("localhost", 1099);
            ObjectSocket objectSocket = new ObjectSocket(socket);

            new Thread(() -> {
                while(true) {
                    try {
                        Message message = (Message) objectSocket.read();
                        System.out.println("L'autre a dit : " + message.getText());
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }).start();

            while(true) {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Quel est votre message ?");
                String text = scanner.nextLine();
                objectSocket.write(new Message(text));
            }



        } catch (IOException e) {
            System.err.println("Erreur d'entrée/sortie");
        }
    }
}
