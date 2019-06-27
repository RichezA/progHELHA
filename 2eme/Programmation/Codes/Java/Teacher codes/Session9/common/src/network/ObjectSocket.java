package network;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ObjectSocket {
    private final ObjectOutputStream out;
    private final ObjectInputStream in;
    protected Socket socket;

    public ObjectSocket(Socket socket) throws IOException {
        this.socket = socket;
        out = new ObjectOutputStream(socket.getOutputStream());
        in = new ObjectInputStream(socket.getInputStream());
    }

    public Object read() throws IOException, ClassNotFoundException {
        return in.readObject();
    }

    public void write(Object o) throws IOException {
        out.writeObject(o);
    }

    public void close() throws IOException {
        this.socket.close();
    }

    public void reset() throws IOException {
        this.out.reset();
    }
}
