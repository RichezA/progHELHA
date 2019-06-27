/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.File;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import models.ExplorerState;
import views.ExplorerController;

/**
 *
 * @author fpluquet
 */
public class Main extends Application {
    
    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader loader = ExplorerController.getLoader();
        loader.load();
        Parent root = loader.getRoot();
        ExplorerController controller = loader.getController();
        ExplorerState explorerState = new ExplorerState();
        controller.setState(explorerState);
        controller.setInteraction(new ExplorerController.Interaction() {
            @Override
            public void onSelect(File file) {
                if (file != null && file.isDirectory()) {
                    explorerState.setCurrentFolder(file);
                }
            }
        });
        
        Scene scene = new Scene(root, 800, 600);
        
        primaryStage.setTitle("Explorer");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
