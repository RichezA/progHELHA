package models;

import java.io.Serializable;

public class User implements Serializable {
        String name;
        public User(String name) {
            this.name = name;
        }

    public String getName() {
        return name;
    }
}
