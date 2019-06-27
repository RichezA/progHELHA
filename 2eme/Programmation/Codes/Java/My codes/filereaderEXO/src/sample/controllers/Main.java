package sample.controllers;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.models.ExplorerState;
import sample.views.MainViewController;
import sample.views.MainViewInteraction;

import java.io.File;
import java.io.IOException;

public class Main extends Application implements MainViewInteraction {

    MainViewController controller;
    ExplorerState explorerState;

    @Override
    public void start(Stage primaryStage) throws Exception{
        explorerState = new ExplorerState();
        Parent root = loadRootPanel();
        primaryStage.setTitle("Explorer");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
        this.controller.initPathBar(explorerState);
    }

    private Parent loadRootPanel() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../views/sample.fxml"));
        loader.load();
        Parent root = loader.getRoot();
        this.controller = loader.getController();
        this.controller.setInteraction(this);
        return root;
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void showSubListing(File file) {
        explorerState.setCurrentFolder(file);
        this.controller.addAFileToView(explorerState);
    }

    @Override
    public void onSelect(ExplorerState explorerState) {
        this.controller.initPathBar(explorerState);
    }
}
