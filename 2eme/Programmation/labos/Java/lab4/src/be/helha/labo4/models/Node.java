package be.helha.labo4.models;

import java.util.Observable;

public abstract class Node extends Observable {
// Observable addObserver = saying that that object is being watched by FolderListing (which is our observer here)
    protected String name;

    public Node(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        this.setChanged();
        this.notifyObservers("name of a " + this.getClass().getSimpleName() + " changed to " + this.getName());
    }

    public abstract int getSize();

    public abstract void setSize(int size);

    public boolean isFolder() {
        return false;
    }
}
