package be.helha.labo4.controllers;


import be.helha.labo4.models.File;
import be.helha.labo4.models.Folder;
import be.helha.labo4.view.FolderListing;
import be.helha.labo4.view.FolderSize;

public class Main {

    public static void main(String[] args) {

        // Folder listing initialisation
        FolderListing listing = new FolderListing();
        FolderSize sizeListing = new FolderSize();

        // folders initialisation
        Folder rootFolder = new Folder("/");
        Folder homeFolder = new Folder("home");
        Folder user1Folder = new Folder("user1");
        Folder user2Folder = new Folder("user2");

        // root observer
        rootFolder.addObserver(listing);
        
        // home folder added in root
        rootFolder.addNode(homeFolder);

        // user folders added in home
        homeFolder.addNode(user1Folder);
        homeFolder.addNode(user2Folder);


        // file creation
        File fileA = new File("a.txt", 200, sizeListing);
        File fileB = new File("b.txt", 450, sizeListing);
        File fileC = new File("c.txt", 10, sizeListing);
        File fileREADME = new File("README.md", 150, sizeListing);

        // file creation in user1
        user1Folder.addNode(fileA);
        user1Folder.addNode(fileB);

        // file creation in user2
        user2Folder.addNode(fileC);

        // file creation in home
        homeFolder.addNode(fileREADME);

        // testing everything
        fileA.setName("nouveauA");
        fileA.setSize(130);
        user2Folder.addNode(new Folder("PERSO"));
        File bankFile = new File("bank.txt", 150, sizeListing);
        user2Folder.addNode(bankFile);
        bankFile.setSize(30);
        bankFile.setSize(0);
        //System.out.println(user1Folder.getSize());
    }
}
