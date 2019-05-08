package models;

import java.io.Serializable;

public class User implements Serializable {
    protected String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String pseudo) {
        this.name = pseudo;
    }
}
