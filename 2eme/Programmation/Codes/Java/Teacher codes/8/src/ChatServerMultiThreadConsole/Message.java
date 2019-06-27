package ChatServerMultiThreadConsole;

import java.io.Serializable;

public class Message implements Serializable {

    protected String text;

    public Message(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
