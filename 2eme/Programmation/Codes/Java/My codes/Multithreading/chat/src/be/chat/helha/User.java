package be.chat.helha;

import java.io.Serializable;

public class User implements Serializable {
    protected String username;
    protected Message msg;

    public User(String username){
        this.username = username;
    }

    public String getUsername(){
        return this.username;
    }

    public Message getMsg() {
        return this.msg;
    }

    public void setMsg(Message msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return this.username + " a dit: " + this.msg;
    }
}
