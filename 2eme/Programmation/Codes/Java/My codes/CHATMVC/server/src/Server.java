import models.Message;
import models.User;
import network.*;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;


class ThreadClient extends Thread {
    private final ObjectSocket objectSocket;
    private final Server server;
    boolean finished;

    public ThreadClient(ObjectSocket objectSocket, Server server) {
        this.objectSocket = objectSocket;
        this.server = server;
    }
    @Override
    public void run() {
        try {
            finished = false;
            while(!finished) {
                Command commande = (Command) objectSocket.read();
                System.out.println("Commande reçue");
                server.broadcast(commande, objectSocket);

                commande.dispatch(new Command.Interaction() {

                    @Override
                    public void onConnect(User user) {

                    }

                    @Override
                    public void onMessageSend(Message message) {

                    }

                    @Override
                    public void onChangePseudo(String old, String newPseudo) {

                    }

                    @Override
                    public void onByeBye(User user) {
                        server.clientQuit(objectSocket);
                        finished = true;
                    }
                });
                // façon déguelasse
//                if(commande instanceof CommandGoodBye){
//                    server.clientQuit(objectSocket);
//                    finished = true;
//                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            server.clientQuit(objectSocket);
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
                System.out.println("Nouveau client");
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

    public synchronized void broadcast(Command command, ObjectSocket objectSocket) throws IOException {
        for (ObjectSocket o : objectSockets) {
            if (!o.equals(objectSocket)) {
                o.reset();
                o.write(command);
            }
        }
    }

    public synchronized void clientQuit(ObjectSocket objectSocket) {
        objectSockets.remove(objectSocket);
    }
}
