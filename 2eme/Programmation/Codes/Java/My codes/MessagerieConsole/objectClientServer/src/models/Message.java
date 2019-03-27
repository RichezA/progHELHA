package models;

import java.io.Serializable;
import java.util.Date;

public class Message implements Serializable {
    String text;
    User user;
    Date date;

    public Message(String text, User user, Date date){
        this.text = text;
        this.user = user;
        this.date = date;
    }

    public String getText() {
        return text;
    }

    public User getUser() {
        return user;
    }

    public Date getDate() {
        return date;
    }
}
