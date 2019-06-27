package chat.network;

import models.Message;
import models.User;
import network.*;

import java.io.IOException;
import java.net.Socket;

public class Client {
    private final User user;
    private ObjectSocket objectSocket;

    public void sendMessage(Message message) throws IOException {
        objectSocket.write(new CommandMessageSend(message));
}

    public void sendChangePseudo(String pseudo) throws IOException {
        objectSocket.write(new CommandChangePseudo(user.getName(), pseudo));
    }

    public void sendByeBye() throws IOException {
        objectSocket.write(new CommandByeBye(user));
        objectSocket.close();
    }

    public interface Interaction {
        void onNewMessage(Message message);
        void onNewUser(User user);
        void onChangePseudo(String oldPseudo, String newPseudo);
        void onByeBye(User user);
    }
    protected Interaction interaction;

    public Client(User user, Interaction interaction) {
        this.user = user;
        this.interaction = interaction;
    }

    public void start() throws IOException {
        Socket socket = new Socket("localhost", 1099);
        objectSocket = new ObjectSocket(socket);
        objectSocket.write(new CommandConnect(user));
        boolean finished = false;
        Thread thread = new Thread(() -> {
            while(!finished) {
                try {
                    Command command = (Command) objectSocket.read();

                    command.dispatch(new Command.Interaction() {
                        @Override
                        public void onConnect(User user) {
                            interaction.onNewUser(user);
                        }

                        @Override
                        public void onMessageSend(Message message) {
                            System.out.println(message.getUser() + " a dit : " + message.getText());
                            interaction.onNewMessage(message);
                        }

                        @Override
                        public void onChangePseudo(String old, String newPseudo) {
                            System.out.println("Changement de pseudo : " + old + " > " + newPseudo);
                            interaction.onChangePseudo(old, newPseudo);
                        }

                        @Override
                        public void onByeBye(User user) {
                            System.out.println("Le user " + user.getName() + " a quitté le chat");
                            interaction.onByeBye(user);
                        }
                    });
                } catch (IOException e) {
//                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
//                    e.printStackTrace();
                }
            }
        });
        thread.setDaemon(true);
        thread.start();
    }
}
