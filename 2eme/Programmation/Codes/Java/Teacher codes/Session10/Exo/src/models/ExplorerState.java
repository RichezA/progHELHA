/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author fpluquet
 */
public class ExplorerState {
    
    SimpleObjectProperty<File> currentFolder = new SimpleObjectProperty<>();
    final ObservableList<File> subfiles = FXCollections.observableArrayList();

    public ExplorerState() throws IOException {
        this.currentFolder.addListener(event -> this.updateSubfiles());
        this.currentFolder.set(new File("").getCanonicalFile());
    }

    public void setCurrentFolder(File currentFolder) {
        this.currentFolder.set(currentFolder);
    }

    public SimpleObjectProperty<File> getCurrentFolder() {
        return this.currentFolder;
    }

    public ObservableList<File> getSubfiles() {
        return FXCollections.unmodifiableObservableList(subfiles);
    }
    
    public ArrayList<File> getParentsAndCurrentFolder() {
        ArrayList<File> parentsAndSelf = new ArrayList<>();
        File parent = this.currentFolder.get();
        while (parent != null) {
            parentsAndSelf.add(0, parent);
            parent = parent.getParentFile();
        }
        return parentsAndSelf;
    }

    private void updateSubfiles() {
//        try {
//            this.currentFolder.set(this.currentFolder.get().getCanonicalFile());
//        } catch (IOException ex) {
//        }

        subfiles.clear();
        if (currentFolder.get().getParent() != null) {
            subfiles.add(new File(currentFolder.get().getAbsolutePath() + File.separator + "..").getAbsoluteFile());
        }
        File[] files = currentFolder.get().listFiles();
        Arrays.sort(files, Comparator.comparing(File::getName));
        for (File node : files) {
            if (node.isDirectory() && !node.isHidden()) {
                subfiles.add(node);
            }
        }
        for (File node : files) {
            if (!node.isDirectory() && !node.isHidden()) {
                subfiles.add(node);
            }
        }
    }
    
    
    
    
    
}
