package models;

import java.io.Serializable;

public class Message implements Serializable {
    private final User user;
    protected String text;

    public Message(String text, User user) {
        this.text = text;
        this.user = user;
    }

    public String getText() {
        return text;
    }

    public User getUser() {
        return user;
    }
}
