package be.helha.labo4.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class Folder extends Node implements Observer {

    protected ArrayList<Node> nodes = new ArrayList<>();

    public Folder(String name) {
        super(name);
    }

    public void addNode(Node node) {
        nodes.add(node);
        node.addObserver(this);
        this.setChanged();
        this.notifyObservers( node.getClass().getSimpleName() + " " + node.getName() + " added to the " + this.getClass().getSimpleName() + " " + this.getName());
    }

    @Override
    public int getSize() {
        int taille = 0;
        for(Node n: nodes){
                taille += n.getSize();
        }
        return taille;
    }

    @Override
    public void setSize(int size) {
        this.notifyObservers();
    }


    public boolean isFolder() {
        return true;
    }

    public ArrayList<Node> getNodes() {
        return (ArrayList<Node>) nodes.clone();
    }

    @Override
    public void update(Observable o, Object arg) {
        this.setChanged();
        this.notifyObservers(arg);
    }
}
