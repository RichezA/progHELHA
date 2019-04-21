package ChatMonoThreadConsole;

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
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
            int position = (Integer) in.readObject();
            boolean speaking = position == 1;
            while(true) {
                if (speaking) {
                    Scanner scanner = new Scanner(System.in);
                    System.out.println("Quel est votre message ?");
                    String text = scanner.nextLine();
                    out.writeObject(new Message(text));
                } else {
                    Message message = (Message) in.readObject();
                    System.out.println("L'autre a dit : " + message.getText());
                }
                speaking = !speaking;
            }


        } catch (IOException e) {
            System.err.println("Erreur d'entrée/sortie");
        } catch (ClassNotFoundException e) {
            System.err.println("Erreur d'entrée/sortie");
        }
    }
}
