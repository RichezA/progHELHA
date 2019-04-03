package be.chat.helha;

import java.io.IOException;
import java.util.ArrayList;

public class ThreadClient extends Thread{
    private final ObjectSocket objectSocket;
    private final Server server;
    ArrayList<ObjectSocket> objectSockets;



    public ThreadClient(ObjectSocket objectSocket, Server server) {
        this.objectSocket = objectSocket;
        this.server = server;
    }

    @Override
    public void run() {
        try {
            while(true) {
                User user = (User) objectSocket.read();
                if(user.getMsg().getText().equals(":message:quit")) {
                    server.clientQuit(objectSocket);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
