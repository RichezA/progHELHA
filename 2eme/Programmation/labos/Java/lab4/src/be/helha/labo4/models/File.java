package be.helha.labo4.models;

import java.util.ArrayList;
import java.util.Observer;

public class File extends Node {

    protected int size = 0; // file size in kb

    public File(String name, int size, Observer ob) {
        super(name);
        this.size = size;
        this.addObserver(ob);
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void setSize(int size) {
        this.size = size;
        this.setChanged();
        ArrayList<Object> objToSend = new ArrayList<>();
        objToSend.add(this.getName());
        objToSend.add(size);
        this.notifyObservers(objToSend);
    }
}
