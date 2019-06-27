package ChatServerMultiThreadConsole;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {

    public static void main(String[] args) {
        Server server = new Server();
        server.go();

    }

    private void go() {
        try {
            ServerSocket ss = new ServerSocket(1099);
            ArrayList<ObjectSocket> objectSockets = new ArrayList<>();
            while(true) {
                ObjectSocket objectSocket = new ObjectSocket(ss.accept());
                objectSockets.add(objectSocket);
                new Thread(() -> {
                    try {
                        while(true) {
                            Message message = (Message) objectSocket.read();
                            for (ObjectSocket o : objectSockets) {
                                if (!o.equals(objectSocket))
                                    o.write(message);
                            }
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                }).start();
            }



        } catch (IOException e) {
            System.err.println("Le serveur n'a pu démarrer");
        }

    }
}
