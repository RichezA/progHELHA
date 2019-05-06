package ChatServerMultiThreadConsole;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    private boolean finished;

    public static void main(String[] args) {
        Client client = new Client();
        client.go();
    }

    private void go() {
        try {
            Socket socket = new Socket("localhost", 1099);
            ObjectSocket objectSocket = new ObjectSocket(socket);

            finished = false;
            new Thread(() -> {
                while(!finished) {
                    try {
                        Message message = (Message) objectSocket.read();
                        System.out.println(message.getAuthor() + " a dit : " + message.getText());
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }).start();

            String pseudo = getScannerLine("Quel est votre pseudo ?");
            while(!finished) {
                String text = getScannerLine("Quel est votre message ?");
                if (text.equals("bye")) {
                    objectSocket.write(new Message(pseudo, ":message:quit"));
                    objectSocket.close();
                    finished = true;
                }else {
                    objectSocket.write(new Message(pseudo, text));
                }
            }



        } catch (IOException e) {
            System.err.println("Erreur d'entrée/sortie");
        }
    }

    private String getScannerLine(String message) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        return scanner.nextLine();
    }
}
