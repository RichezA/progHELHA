package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class Main extends Application {

    public static final int BUTTON_SIZE = 40;

    @Override
    public void start(Stage primaryStage) throws Exception{


        primaryStage.setTitle("Hello World");
        AnchorPane pane = new AnchorPane();
        Scene scene = new Scene(pane);

//        Button button = new Button("Button 111111111111");
//        pane.getChildren().add(button);
//        button.setOnAction(event -> System.out.println("Button 1"));
//
//        Button button2 = new Button("Button 2");
//        pane.getChildren().add(button2);
//        button2.setOnAction(event -> System.out.println("Button 2"));
//        button2.setLayoutX(100);
//        button2.setLayoutY(100);
        Button button;
        EventHandler<MouseEvent> onClick = event -> {
            Button b = (Button) event.getSource();
            b.setText(Integer.toString(event.getClickCount()));
//            b.setLayoutX(700);
//            pane.getChildren().remove(b);
//            pane.getChildren().add(b);
            AnchorPane anchorPane = null;
            try {
                Stage stage = new Stage();
                anchorPane = FXMLLoader.load(getClass().getResource("sample.fxml"));
                Scene newScene = new Scene(anchorPane);
                stage.setScene(newScene);
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        };
        EventHandler<MouseEvent> onEnter = event -> {
            Button b = (Button) event.getSource();
            b.setStyle("-fx-background-color: red");
        };
        EventHandler<MouseEvent> onExit = event -> {
            Button b = (Button) event.getSource();
            b.setStyle("-fx-background-color: white");
        };
        Circle circle = new Circle(300, 300, 200, Color.GREEN);
        pane.getChildren().add(circle);
        circle.setOnMouseEntered(event -> circle.setFill(Color.RED));
        circle.setOnMouseExited(event -> circle.setFill(Color.GREEN));
        for(int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                button = new Button(Integer.toString(i*10 + j), new Rectangle(3,8, Color.RED));
                pane.getChildren().add(button);
                button.setPrefWidth(BUTTON_SIZE);
                button.setPrefHeight(BUTTON_SIZE);
                button.setLayoutX(i * BUTTON_SIZE);
                button.setLayoutY(j * BUTTON_SIZE);
                button.setOnMouseClicked(onClick);
                button.setOnMouseEntered(onEnter);
                button.setOnMouseExited(onExit);
            }
        }
        primaryStage.setScene(scene);

        primaryStage.setOnCloseRequest(event -> System.out.println("Ferme..."));
        primaryStage.setResizable(false);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
