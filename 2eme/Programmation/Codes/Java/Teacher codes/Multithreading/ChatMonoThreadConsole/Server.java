package ChatMonoThreadConsole;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {
        Server server = new Server();
        server.go();

    }

    private void go() {
        try {
            ServerSocket ss = new ServerSocket(1099);

            Socket socket1 = ss.accept();
            Socket socket2 = ss.accept();

            ObjectOutputStream out1 = new ObjectOutputStream(socket1.getOutputStream());
            ObjectInputStream in1 = new ObjectInputStream(socket1.getInputStream());
            ObjectOutputStream out2 = new ObjectOutputStream(socket2.getOutputStream());
            ObjectInputStream in2 = new ObjectInputStream(socket2.getInputStream());

            out1.writeObject(1);
            out2.writeObject(2);

            while(true) {
                Message message = (Message) in1.readObject();
                out2.writeObject(message);

                message = (Message) in2.readObject();
                out1.writeObject(message);
            }



        } catch (IOException e) {
            System.err.println("Le serveur n'a pu démarrer");
        } catch (ClassNotFoundException e) {
            System.err.println("Erreur lors de la reception d'un message");
        }

    }
}
