package ChatServerMultiThreadConsole;

import java.io.Serializable;

public class Message implements Serializable {

    protected String text;
    protected String author;

    public Message(String author, String text) {
        this.text = text;
        this.author = author;
    }

    public String getText() {
        return text;
    }

    public String getAuthor() {
        return author;
    }
}
