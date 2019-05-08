package chat.controllers;

import chat.network.Client;
import chat.views.MainController;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import models.Message;
import models.User;

// TODO : Implémenter un message envoyé à tout le monde quand on change de pseudo
import java.io.IOException;

public class Main extends Application {

    private Client client;

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader(MainController.class.getResource("Main.fxml"));
        loader.load();
        Parent root = loader.getRoot();
        MainController mainController = loader.getController();

        User user = new User("Fred");
        startClient(mainController, user);
        initializeController(mainController, user);

        primaryStage.setOnCloseRequest(event -> {
            try{
                client.sendByeBye();
            }catch(IOException e){
                e.printStackTrace();
            }
        });
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    private void initializeController(MainController mainController, User user) {
        mainController.setCurrentUser(user);
        mainController.setInteraction(message -> {
            if (message.charAt(0) == '/') {
                String pseudo = message.substring(1);
                try {
                    client.sendChangePseudo(pseudo);
                    user.setName(pseudo);
                    mainController.cleanMessage();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                Message messageObject = new Message(message, user);
                try {
                    client.sendMessage(messageObject);
                    mainController.addMessage(messageObject);
                    mainController.cleanMessage();
                } catch (IOException e) {
                    // e.printStackTrace();
                }
            }
        });
    }

    private void startClient(MainController mainController, User user) throws IOException {
        client = new Client(user, new Client.Interaction() {
            @Override
            public void onNewMessage(Message message) {
                Platform.runLater(() -> mainController.addMessage(message));
            }

            @Override
            public void onNewUser(User user) {
                Platform.runLater(() -> mainController.addUser(user));
            }

            @Override
            public void onModifiedUsername(String oldPseudo, String newPseudo) { Platform.runLater(() -> mainController.addModifiedUsername(oldPseudo, newPseudo));}

        });
        client.start();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
