package be.helha.models.network;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Observable;
import java.util.Observer;

/**
 * This class is used to define a client thread instance on our server. This class extends the Thread class because we do need to have multithreading to accept multiple instances
 * of some client that could connect to our server. If you want to know more about the Thread superclass, please refer to https://docs.oracle.com/javase/8/docs/api/java/lang/Thread.html
 */
public class NetworkObject extends Observable implements Runnable
{
    // VARIABLES
    private Socket socket;
    private final ObjectOutputStream out;
    private final ObjectInputStream in;
    private Server server;

    // CONSTRUCTOR
    public NetworkObject(Socket socket, Server server, Observer observer) throws IOException
    {
        this.server = server;
        this.addObserver(observer);
        this.socket = socket;
        this.out = new ObjectOutputStream(socket.getOutputStream());
        this.in = new ObjectInputStream(socket.getInputStream());
    }

    /**
     * As long as the NetworkObject class extends from the Thread superclass, we do need to override the run method.
     * Here it does read what is sent through the network and, here, executes the payment process.
     */
    @Override
    public void run()
    {
        try{
            while(!socket.isClosed())
            {
                Object object = this.read();
                this.setChanged();
                this.notifyObservers(object);
            }
        }
        catch (IOException | ClassNotFoundException e)
        {
            e.printStackTrace();
        }
    }

    /**
     * This method is used to read what does come in the socket
     * @return Object -> We return the object that we just read on the network bus (the object incoming)
     * @throws IOException
     * @throws ClassNotFoundException
     */
    private Object read() throws IOException, ClassNotFoundException
    {
        return in.readObject();
    }

    /**
     * This method is sued to send an object through the network system
     * @param o : Object -> the object that we desire to write on the network
     * @throws IOException
     */
    void write(Object o) throws IOException
    {
        out.reset();
        out.writeObject(o);
    }

    public void close() throws IOException
    {
        server.quit(this);
        socket.close();
    }

}
