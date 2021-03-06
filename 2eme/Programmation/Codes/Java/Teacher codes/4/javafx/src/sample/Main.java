package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application {

    public static final int BUTTON_WIDTH = 40;

    @Override
    public void start(Stage primaryStage) throws Exception{
        AnchorPane pane = new AnchorPane();
        Scene scene = new Scene(pane);
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {

                String label = Integer.toString(i * 10 + j);
                Button button = new Button(label);
                button.setPrefSize(BUTTON_WIDTH, BUTTON_WIDTH);
                button.setLayoutX(BUTTON_WIDTH * i);
                button.setLayoutY(BUTTON_WIDTH * j);
                button.setOnAction(event -> System.out.println(label));
                pane.getChildren().add(button);

            }
        }
        primaryStage.setScene(scene);
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
