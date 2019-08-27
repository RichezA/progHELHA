package be.helha.models.network;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

/**
 * This class is used to manage all the networking traffic from our main interface to the two secondary ones
 * As long as this class uses multithreading to accept a client interface, we, then, do have to extends our class from the Thread superclass
 * If you want to know more about the Thread superclass please refer to https://docs.oracle.com/javase/8/docs/api/java/lang/Thread.html
 */
public class Server extends Thread
{
    // VARIABLES
    ServerSocket serverSocket;
    ArrayList<NetworkObject> objects;
    Observer observer;

    // CONSTRUCTOR
    public Server(Observer observer){
        try{
            this.observer = observer;
            serverSocket = new ServerSocket(19132);
            objects = new ArrayList<>();
        }
        catch (IOException e){

        }
    }

    /**
     * This method needs to be implemented since we extends from the Thread superclass and the superclass itself implements Runnable
     * If you want to check more about the Runnable class, please refer at https://docs.oracle.com/javase/8/docs/api/java/lang/Runnable.html
     * In here we will add a new NetworkObject each time a new client connects onto the server and add it to our `client` list used for the broadcast of our queries over the network
     */
    @Override
    public void run()
    {
        try{
            while(true)
            {
                NetworkObject object = new NetworkObject(serverSocket.accept(), this, observer);
                Thread thread = new Thread(object);
                synchronized (this){
                    objects.add(object);
                }
                thread.setDaemon(true);
                thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method is used to broadcast an order over our networking system. As you can see it is a synchronized method
     * It does mean that it prevents the interferences between threads and memory consistency errors.
     * We need to synchronize this method as long as we access variables of different objects through threads.
     * If you want to see more about synchronized idioms, please check https://docs.oracle.com/javase/tutorial/essential/concurrency/syncmeth.html
     * @param object -> the order that we want to broadcast
     * @throws IOException
     */
    public synchronized void broadcast(Object object) throws IOException
    {
        for (NetworkObject networkObject: objects)
        {
            networkObject.write(object);
        }
    }

    public void quit(NetworkObject o)
    {
        objects.remove(o);
    }
}

