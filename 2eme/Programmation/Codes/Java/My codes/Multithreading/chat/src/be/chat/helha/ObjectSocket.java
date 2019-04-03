package be.chat.helha;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ObjectSocket {
    protected Socket socket;
    protected ObjectInputStream in;
    protected ObjectOutputStream out;
    public ObjectSocket(Socket socket)throws IOException{
        this.socket = socket;
            out = new ObjectOutputStream(socket.getOutputStream());
            in = new ObjectInputStream(socket.getInputStream());
    }

    Object read() throws ClassNotFoundException, IOException{
       return in.readObject();
    }

    void write(Object o) throws  IOException {
        out.writeObject(o);
    }

    void close(){

    }
}
