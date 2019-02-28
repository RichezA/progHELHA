package sample;

import javafx.application.Application;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import sun.plugin.javascript.navig.Anchor;

import javax.swing.*;
import java.net.URL;


public class Main extends Application {

    public static final int BUTTON_SIZE = 40;

    @Override
    public void start(Stage primaryStage) throws Exception{
//        AnchorPane pane = new AnchorPane();
//        Scene scene = new Scene(pane, 500, 500);
//        Button button = new Button("yeaboi");
//        pane.getChildren().add(button);
//        button.setOnAction(event -> System.out.println("Hello"));
//
//
//        Button button2 = new Button("button2222");
//        pane.getChildren().add(button2);
//        button2.setOnAction(event -> System.out.println("BUTTON2"));
//        button2.setLayoutX(50);
//        button2.setLayoutY(100);
//        Button button;
//        EventHandler<MouseEvent> onClick= event -> {
//            Button b = (Button) event.getSource();
//            b.setText(Integer.toString(event.getClickCount()));
//            b.setLayoutX(700);
//            pane.getChildren().remove(b);
//            pane.getChildren().add(b);
//        };
//        EventHandler<MouseEvent> onEnter = event -> {
//            Button b = (Button) event.getSource();
//            b.setStyle("-fx-background-color: red");
//        };
//        EventHandler<MouseEvent> onExit = event -> {
//            Button b = (Button) event.getSource();
//            b.setStyle("-fx-background-color: white");
//        };
//        Circle circle = new Circle(200, 200, 200, Color.GREEN);
//        pane.getChildren().add(circle);
//        circle.setOnMouseEntered(event -> circle.setRadius(500));
//        circle.setOnMouseExited(event -> circle.setRadius(200));
//        for(int i = 0; i < 10; i++){
//            for(int j = 0; j < 10;j++){
//                button = new Button(Integer.toString(i*10 + j), new Rectangle());
//                pane.getChildren().add(button);
//                button.setPrefWidth(BUTTON_SIZE);
//                button.setPrefHeight(BUTTON_SIZE);
//                button.setLayoutX(i * BUTTON_SIZE);
//                button.setLayoutY(j * BUTTON_SIZE);
//
//                button.setOnMouseClicked(onClick);
//                button.setOnMouseEntered(onEnter);
//                button.setOnMouseExited(onExit);
//            }
//        }

//        primaryStage.setOnCloseRequest(event -> System.out.println("FERMETURE DE LA FENÊTRE"));
//        primaryStage.setResizable(false);


        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Scene scene = new Scene(anchorPane);
        primaryStage.setScene(scene);
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
