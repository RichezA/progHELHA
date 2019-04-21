package ChatServerMultiThreadConsole;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;


class ThreadClient extends Thread {
    private final ObjectSocket objectSocket;
    private final Server server;

    public ThreadClient(ObjectSocket objectSocket, Server server) {
        this.objectSocket = objectSocket;
        this.server = server;
    }

    @Override
    public void run() {
        try {
            boolean finished = false;
            while(!finished) {
                Message message = (Message) objectSocket.read();
                if (message.getText().equals(":message:quit")) {
                    server.clientQuit(objectSocket);
                    finished = true;
                } else {
                    server.broadcast(message, objectSocket);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
public class Server {

    private ArrayList<ObjectSocket> objectSockets;

    public static void main(String[] args) {
        Server server = new Server();
        server.go();

    }

    private void go() {
        try {
            ServerSocket ss = new ServerSocket(1099);
            objectSockets = new ArrayList<>();
            while(true) {
                ObjectSocket objectSocket = new ObjectSocket(ss.accept());
                synchronized (this) {
                    objectSockets.add(objectSocket);
                }
                ThreadClient thread = new ThreadClient(objectSocket, this);
                thread.start();
            }



        } catch (IOException e) {
            System.err.println("Le serveur n'a pu démarrer");
        }

    }

    public synchronized void broadcast(Message message, ObjectSocket objectSocket) throws IOException {
        for (ObjectSocket o : objectSockets) {
            if (!o.equals(objectSocket))
                o.write(message);
        }
    }

    public synchronized void clientQuit(ObjectSocket objectSocket) {
        objectSockets.remove(objectSocket);
    }
}
