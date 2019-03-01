package test;

import be.helha.labo4.models.File;
import be.helha.labo4.models.Folder;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class FolderTest {
    private Folder rootFolder;

    @Before
    public void setUp(){
        rootFolder = new Folder("/");
        Folder userFolder = new Folder("usr");
        rootFolder.addNode(new File("user1fichier",100, null));
        rootFolder.addNode(userFolder);
        userFolder.addNode(new File("fichierperso", 2500, null));
        userFolder.addNode(new File("fichierTravail", 1300, null));
    }

    @Test
    public void getSize() {
        assertEquals(rootFolder.getSize(), 3900);
    }
}