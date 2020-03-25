import java.io.*;
import java.nio.Buffer;

public class Main {
    public static void main(String[] args) throws IOException {
        File file = new File("test2.md");
        //tryingOutMethods(file);
        //getPathFromProjectToRoot(file);
        //listingSubDirectories(file);

        if(file.delete()) System.out.println("File deleted");
        //browseFile(file);
        //writingFiles(new File("test2.md"));
        //readingFiles(new File("test2.md"));

        try (
                FileOutputStream fos2 = new FileOutputStream(file);
                BufferedOutputStream bfos2 = new BufferedOutputStream(fos2);
                DataOutputStream dbfos2 = new DataOutputStream(bfos2)
                ){
            dbfos2.writeBoolean(false);
            dbfos2.writeLong(100L);
            dbfos2.writeChars("TEST");
        } catch(Exception e){
            e.printStackTrace();
        }

        try(
                DataInputStream dis = new DataInputStream(
                                            new BufferedInputStream(
                                                new FileInputStream(file)))
                ){
            System.out.println(dis.readBoolean());
            System.out.println(dis.readLong());
            for (int i = 0; i < 4; i++) {
                System.out.print(dis.readChar());
            }
        }

        try(
            FileReader fr = new FileReader(file);
            BufferedReader bfr = new BufferedReader(fr)
            ) {
            bfr.lines().forEach(s -> System.out.println(s));
        //    String s = bfr.readLine();
        //    while(s != null){
        //        System.out.println(s);
        //        s = bfr.readLine();
        //    }
        }
    }

    public static void tryingOutMethods(File file) throws IOException {
        System.out.println("=============Methods=============");
        System.out.println(file.getAbsolutePath());
        System.out.println(file.getCanonicalPath());
        System.out.println("Exists ? " + file.exists());
    }

    public static void getPathFromProjectToRoot(File file) throws IOException{
        System.out.println("=============Path to root folder=============");
        // Get the path from the project to the root folder
        file = new File(file.getCanonicalPath());
        File parent = file.getParentFile();
        while(parent != null){
            System.out.println(parent.getName());
            parent = parent.getParentFile();
        }
    }

    public static void listingSubDirectories(File file){
        System.out.println("=============Listing (sub)directories=============");
        if(file.isDirectory()){
            for( File f: file.listFiles()){
                System.out.println(f.getName());

            }
        }
    }

    public static void browseFile(File file){
        browseFile(file, 0);

    }

    public static void browseFile(File file, int level){
        if(file.isDirectory()){
            for(File f: file.listFiles()){
                for(int i = 0; i < level; i++){
                    System.out.println("\t");
                }
                System.out.println(f.isHidden() ? "h " : " ");
                System.out.println(f.getName());
                browseFile(f);
            }
        }
    }

    public static void readingFiles(File file) throws IOException{
        FileInputStream fis = new FileInputStream(file);
        byte b = (byte) fis.read();
        while (b != -1){
            System.out.println((char)b); // translate ASCII to characters
            b = (byte) fis.read();
        }
        System.out.println("USING BUFFER");
        BufferedInputStream bfis = new BufferedInputStream(fis);
        b = (byte) bfis.read();
        while (b != -1){
            System.out.println((char)b); // translate ASCII to characters
            b = (byte) bfis.read();
        }
    }

    public static void writingFiles(File file) throws IOException {
        long start = System.currentTimeMillis();
        FileOutputStream fos = new FileOutputStream(file);
        for (int i = 0; i < 1000000; i++) {
            fos.write('a');
        }
        long end = System.currentTimeMillis();
        System.out.println("Le temps pour écrire: " + (end - start) + "ms ");
        start = System.currentTimeMillis();
        BufferedOutputStream bfos = new BufferedOutputStream(fos);
        for (int i = 0; i < 1000000; i++) {
            bfos.write('a');
        }
        end = System.currentTimeMillis();
        fos.close();
        System.out.println("Le temps pour écrire avec le buffer: " + (end - start) + "ms ");
    }
}
