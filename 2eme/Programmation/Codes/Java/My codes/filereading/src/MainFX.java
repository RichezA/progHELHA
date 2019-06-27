import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class MainFX extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException{

        Label label = new Label("HELHa");
        VBox root = new VBox();
        root.getChildren().add(label);

        TextField tf = new TextField();
        root.getChildren().add(tf);
        TextField tf2 = new TextField();
        root.getChildren().add(tf2);

//        tf.textProperty().addListener(((observable, oldValue, newValue) -> label.setText(newValue)));
//        label.textProperty().bindBidirectional(tf.textProperty());
//        label.textProperty().bind(primaryStage.heightProperty().asString());

        label.textProperty().bind(tf.textProperty());
        tf.textProperty().bindBidirectional(tf2.textProperty());

        SimpleStringProperty name = new SimpleStringProperty("Fred");
        name.bindBidirectional(tf2.textProperty());
        name.bindBidirectional(tf.textProperty());
        label.textProperty().bind(name);

        primaryStage.titleProperty().bind(label.textProperty());
        primaryStage.setScene(new Scene(root, 300, 300));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
