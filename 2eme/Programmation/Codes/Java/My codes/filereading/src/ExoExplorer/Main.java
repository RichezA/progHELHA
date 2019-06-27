package ExoExplorer;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

import java.io.File;
import java.util.List;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane root = new BorderPane();
        FlowPane fileToRootPane = new FlowPane();

        File file = new File(".");
        file = new File(file.getCanonicalPath());
        File parent = file.getParentFile();

        while(parent != null){
            Button btn = new Button(parent.getName());
            btn.setOnMouseClicked(event -> {
                
            });
            fileToRootPane.getChildren().add(btn);
            parent = parent.getParentFile();

        }
        root.setTop(fileToRootPane);
        primaryStage.setScene(new Scene(root,800,600));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
