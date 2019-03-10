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


        primaryStage.setTitle("Hello World"); // on set le titre de la fenêtre
        AnchorPane pane = new AnchorPane();
        Scene scene = new Scene(pane);

//        Button button = new Button("Button 111111111111");
//        pane.getChildren().add(button);
//        button.setOnAction(event -> System.out.println("Button 1")); // quand on appuie dessus on print Button 1 dans la console
//
//        Button button2 = new Button("Button 2");
//        pane.getChildren().add(button2);
//        button2.setOnAction(event -> System.out.println("Button 2"));
//        button2.setLayoutX(100);      // On change la position du bouton en X
//        button2.setLayoutY(100);      // On change la position du bouton en Y
        Button button;
        EventHandler<MouseEvent> onClick = event -> {               // Quand on appuie sur le bouton
            Button b = (Button) event.getSource();                  // On prend la source de l'event (le bouton sur lequel on a appuyé) et on le cast en bouton
            b.setText(Integer.toString(event.getClickCount()));     // On set le texte du bouton en récupérant le nombre de click ayant été faits durant l'événement
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
        EventHandler<MouseEvent> onEnter = event -> {  // quand on met la souris sur le bouton on passe son background color en rouge
            Button b = (Button) event.getSource();
            b.setStyle("-fx-background-color: red");
        };
        EventHandler<MouseEvent> onExit = event -> { // quand on sort la souris du focus du bouton on passe son background color en blanc
            Button b = (Button) event.getSource();
            b.setStyle("-fx-background-color: white");
        };
        Circle circle = new Circle(300, 300, 200, Color.GREEN); // On crée un cercle vert
        pane.getChildren().add(circle);                         // On l'ajoute au pane
        circle.setOnMouseEntered(event -> circle.setFill(Color.RED));   // quand on passe sa souris sur le cercle, il devient rouge
        circle.setOnMouseExited(event -> circle.setFill(Color.GREEN));  // quand elle sort, le cercle redevient vert
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
