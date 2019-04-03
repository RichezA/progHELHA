package be.chat.helha;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {

    ArrayList<ObjectSocket> objectSockets;

    public static void main(String[] args) throws IOException{
        Server server = new Server();
        //server.monoThreadShit();
        server.go();

    }

    // Test sans multithread
    private void monoThreadShit() {
        try {
            ServerSocket ss = new ServerSocket(1099);
            Socket socket = ss.accept();
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
            // ne fonctionne pas car on a seulement 1 user (1 accept) => Solution : rajouter un autre socket
            Socket socket2 = ss.accept();
            ObjectOutputStream out2 = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream in2 = new ObjectInputStream(socket.getInputStream());


            out.writeObject(1);
            out.writeObject(2);
            // NUL car on doit attendre que l'autre parle pour pouvoir parler
            while(true){
            Message msg= (Message) in.readObject();
            out2.writeObject(msg);

            Message msg2 = (Message) in.readObject();
            out.writeObject(msg2);
            }

        }catch(IOException e){
            System.err.println("Erreur lors du démarrage du serveur");
        }catch(ClassNotFoundException e){
            System.err.println("Erreur lors de la réception du message");
        }
    }
    private void go() throws IOException{
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
    }

    private void broadcast(User user, ObjectSocket objectSocket) throws IOException{
        for(ObjectSocket o: objectSockets){
            if(!o.equals(objectSocket)) o.write(user);
        }
    }
    public void clientQuit(ObjectSocket objectSocket){
        this.objectSockets.remove(objectSocket);
    }
}
