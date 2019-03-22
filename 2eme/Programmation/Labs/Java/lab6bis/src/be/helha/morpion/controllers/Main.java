package be.helha.morpion.controllers;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("models/sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();

        AnchorPane pane = new AnchorPane();
        primaryStage.setTitle("OXO !");
        primaryStage.setScene(new Scene(pane, 800, 800));
    }


    public static void main(String[] args) {
        launch(args);
    }
}
