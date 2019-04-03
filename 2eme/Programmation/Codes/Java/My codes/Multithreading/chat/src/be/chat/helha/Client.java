package be.chat.helha;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args)throws IOException, ClassNotFoundException {
        Client client = new Client();
        //client.monoThreadShit();
        client.go();
    }


    private void monoThreadShit(){
        try{
            Socket socket = new Socket("localhost", 1099);
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
            int pstion = (Integer) in.readObject();
            boolean speaking = pstion == 1;
            while(true) {
                if (speaking) {
                    Scanner scanner = new Scanner(System.in);
                    System.out.println("Message?");
                    String msg = scanner.nextLine();
                    out.writeObject(new Message(msg));
                } else {
                    Message msg = (Message) in.readObject();
                    System.out.println("L'autr a dit: " + msg.getText());
                }
                speaking = !speaking;
            }
        }catch(IOException e){
            System.err.println(e.getStackTrace());
        }catch(ClassNotFoundException e){
            System.err.println(e.getStackTrace());
        }
    }
    private void go() throws IOException {
        Socket socket = new Socket("localhost", 1099);
        ObjectSocket objectSocket = new ObjectSocket(socket);
        User curUser = new User(getScannerLine("Entrez le pseudo: "));

        new Thread(() -> {
            while(true){
                try {
                    User user = (User) objectSocket.read();
                    System.out.println(user);
                }catch(IOException e) { e.printStackTrace();} catch(ClassNotFoundException e) { e.printStackTrace();}
            }
        }).start();

        while(true){
            System.out.println("Message? : ");
            String text = getScannerLine("Message?: ");
            curUser.setMsg(new Message(text));
            objectSocket.write(curUser);
        }
    }

    private String getScannerLine(String message){
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        return scanner.nextLine();
    }
}
