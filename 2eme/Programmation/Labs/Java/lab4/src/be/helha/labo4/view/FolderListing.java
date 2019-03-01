package be.helha.labo4.view;

import be.helha.labo4.models.Folder;
import be.helha.labo4.models.Node;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class FolderListing implements Observer {

    public void showFolders(Folder folder){
        for(Node f : folder.getNodes()){
            System.out.println(f.getName() + (!f.isFolder() ? ": (" + f.getSize() + ")" : ""));
            if(f.isFolder()){
                showFolders((Folder)f);
            }

        }
    }

    @Override
    public void update(Observable o, Object arg) {
        if(!(arg instanceof String)){
            System.out.println();
            showFolders((Folder)o);
        }
        else{
            System.out.println("\n- FolderListing notification: " + arg);
            showFolders((Folder)o);
        }

    }
}
