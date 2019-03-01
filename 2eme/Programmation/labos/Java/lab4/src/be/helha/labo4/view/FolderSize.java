package be.helha.labo4.view;

import be.helha.labo4.models.File;
import be.helha.labo4.models.Node;

import java.util.Observable;
import java.util.Observer;

public class FolderSize implements Observer {

    public void showFolderSize(Node f){
        System.out.println(f.getName() + " now got a size of: " + f.getSize());
    }

    @Override
    public void update(Observable o, Object arg) {
        if(!(arg instanceof String)){
            System.out.print("- FolderSize notification: ");
            this.showFolderSize((Node)o);
        }

    }
}
