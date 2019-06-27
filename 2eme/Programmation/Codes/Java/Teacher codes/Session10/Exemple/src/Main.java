import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
//        File file = new File(".");
//        System.out.println(file.getAbsolutePath());
//        System.out.println(file.getCanonicalPath());
//        file = new File(file.getCanonicalPath());
//        File parent = file.getParentFile();
//        System.out.println("Exists ? " + file.exists());
//        while(parent != null) {
//            System.out.println(parent.getName());
//            parent = parent.getParentFile();
//        }
//        browseFile(file);
        File file  = new File("./test.md");
        FileInputStream fis = new FileInputStream(file);
//        byte b = (byte) fis.read();
//        while(b != -1) {
//            System.out.print((char)b);
//            b = (byte) fis.read();
//        }
        BufferedInputStream bfis = new BufferedInputStream(fis);
//        byte b = (byte) bfis.read();
//        while(b != -1) {
//            System.out.print((char)b);
//            b = (byte) bfis.read();
//        }



//        FileOutputStream fos = new FileOutputStream("test2.md");
//        BufferedOutputStream bfos = new BufferedOutputStream(fos);
//        long start = System.currentTimeMillis();
//        for (int i = 0; i < 1000000; i++) {
//            bfos.write('a');
//        }
//        bfos.close();
//        fos.close();
//        long end = System.currentTimeMillis();
//        System.out.println("Le temps pour écrire  : " + (end - start) + "ms");

//        try (
//                FileOutputStream fos2 = new FileOutputStream("test3.md");
//                BufferedOutputStream bfos2 = new BufferedOutputStream(fos2);
//                DataOutputStream dbfos2 = new DataOutputStream(bfos2)
//                ) {
//            dbfos2.writeBoolean(false);
//            dbfos2.writeLong(1000L);
//            dbfos2.writeChars("TEST");
//        } catch (Exception e) {
//
//        }
//
//        try (DataInputStream dis =
//                     new DataInputStream(
//                        new BufferedInputStream(
//                            new FileInputStream("test3.md")))) {
//            System.out.println(dis.readBoolean());
//            System.out.println(dis.readLong());
//            System.out.println(dis.readChar());
//            System.out.println(dis.readChar());
//            System.out.println(dis.readChar());
//            System.out.println(dis.readChar());
//        }

        try (FileReader fr = new FileReader("test2.md");
        BufferedReader bfr = new BufferedReader(fr)) {
            bfr.lines().forEach(s -> System.out.println(s));
//            String s = bfr.readLine();
//            while(s != null) {
//                System.out.println(s);
//                s = bfr.readLine();
//            }
        }
        ObservableList<Object> list = FXCollections.observableArrayList();
        list.addListener(new InvalidationListener() {
            @Override
            public void invalidated(Observable observable) {
                System.out.println(list.size());
            }
        });
        list.add(1);
    }

    /**
     * Display the hierarchy starting at file
     * @param file Root of hierarchy to display
     * @return 5
     */
    private static int browseFile(File file) {
        browseFile(file, 0);
        return 5;
    }

    private static void browseFile(File file, int level) {
        if (file.isDirectory()) {
            for (File f : file.listFiles()) {
                for (int i = 0; i < level; i++) {
                    System.out.print("\t");
                }
                System.out.print(f.isHidden() ? "h " : "  ");
                System.out.println(f.getName());
                browseFile(f, level + 1);
            }
        }
    }
}
