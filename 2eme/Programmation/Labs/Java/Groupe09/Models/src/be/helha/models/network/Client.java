package be.helha.models.network;

import be.helha.models.Order;
import javafx.application.Platform;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Observable;
import java.util.Observer;

/**
 * This class is used to define a client that connects to our server
 * It does extend Observable, meaning that every instance of this class will be observable by one or more observers, if you want to know more about this concept
 * please refer to https://docs.oracle.com/javase/8/docs/api/index.html?java/util/Observable.html
 * It also implements Runnable meaning that any instance of this class is intended to be executed by a thread, if you want to know more about this interface please check
 * https://docs.oracle.com/javase/7/docs/api/java/lang/Runnable.html
 */
public class Client extends Observable implements Runnable
{
    // ATTRIBUTES
    Socket socket;
    ObjectOutputStream out;
    ObjectInputStream in;

    // CONSTRUCTOR

    /**
     * In this constructor the interaction is our observer that will be notified when we chose the right moment to
     * @param interaction : our Observer
     */
    public Client(Observer interaction){
        //this.interaction = interaction;
        this.addObserver(interaction);
        try{
            socket = new Socket("localhost", 19132);
        }
        catch (IOException e){

        }
    }

    /**
     * Because this class implements the interface Runnable, we have to override the `run()` method
     * The client will just listen to the server and will notify server when we read a new object
     */
    @Override
    public void run()
    {
        try
        {
            out = new ObjectOutputStream(socket.getOutputStream());
            in = new ObjectInputStream(socket.getInputStream());
            while (!socket.isClosed())
            {
                Object object = in.readObject();
                this.setChanged();
                this.notifyObservers(object);
            }
        } catch (IOException | ClassNotFoundException e)
        {
            System.err.println("Error in the client thread: " + e.getMessage());
        }
    }

    /**
     * We use this method for sending a `bye message` when we disconnect
     * @param arg : the object that we want to send through the network
     */
    public void sendToServer(String arg)
    {
        try{
            out.writeObject(arg);
        }
        catch (IOException e)
        {
            System.err.println("Error during the object writing process: " + e.getMessage());
        }
    }

}


