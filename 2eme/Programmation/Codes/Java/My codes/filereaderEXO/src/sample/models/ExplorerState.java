package sample.models;

import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sun.java2d.pipe.SpanShapeRenderer;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class ExplorerState {
    // Property -> objet dans la property -> get | set -> dès qu'on get ou set on prévient les listeners
    SimpleObjectProperty<File> currentFolder = new SimpleObjectProperty<File>();
    final ObservableList<File> subfiles = FXCollections.observableArrayList();

    public ExplorerState() throws IOException {
        this.currentFolder.addListener(event -> this.updateSubFiles());
        this.currentFolder.set(new File("").getCanonicalFile());
    }

    public void setCurrentFolder(File currentFolder){
        this.currentFolder.set(currentFolder);
    }

    public SimpleObjectProperty<File> getCurrentFolder() { return this.currentFolder; }
    public ObservableList<File> getSubfiles() { return FXCollections.unmodifiableObservableList(this.subfiles); }

    public ArrayList<File> getParentsAndCurrentFolder(){
        ArrayList<File> parentsAndSelf = new ArrayList<>();
        File parent = this.currentFolder.get();
        while(parent != null){
            parentsAndSelf.add(0, parent);
            parent = parent.getParentFile();
        }
        return parentsAndSelf;
    }

    private void updateSubFiles(){
//        try{
//            this.currentFolder.set(this.currentFolder.get().getCanonicalFile());
//        } catch (IOException e){
//            e.printStackTrace();
//        }

        subfiles.clear();
        if(currentFolder.get().getParent() != null){
            subfiles.add(new File(this.currentFolder.get().getAbsolutePath() + File.separator));
        }
        File[] files = currentFolder.get().listFiles();
        Arrays.sort(files, Comparator.comparing(File::getName)); // Le "::" est une référence de méthode, on peut remplacer par file -> file.getName();
        for (File node: files){
            if(node.isDirectory() && !node.isHidden()){
                subfiles.add(node);
            }
        }
        for(File node: files){
            if(!node.isDirectory() && !node.isHidden()){
                subfiles.add(node);
            }
        }
    }
}
