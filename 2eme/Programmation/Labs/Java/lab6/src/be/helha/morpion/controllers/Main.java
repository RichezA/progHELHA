package be.helha.morpion.controllers;

import be.helha.morpion.models.Game;
import be.helha.morpion.views.MainViewController;
import be.helha.morpion.views.MainViewInteraction;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

public class Main extends Application implements MainViewInteraction {

    MainViewController controller;
    Game game;
    Stage thisStage;
    @Override
    public void start(Stage primaryStage) throws Exception{
        startGame(primaryStage);
    }

    public void startGame(Stage primaryStage) throws Exception{
        thisStage = primaryStage;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../views/MainView.fxml"));
        loader.load();
        Parent root = loader.getRoot();
        this.controller = loader.getController();
        controller.setInteraction(this);
        game = new Game(controller);
        game.play();
        primaryStage.setTitle("MORPION");
        primaryStage.setScene(new Scene(root, 650, 650));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void reset(){
        try{
            startGame(thisStage);
            System.out.println("\n\n---NEW GAME---\n\n");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void resetGame(){
        if(game.getWin()) this.reset();
        else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Yo are you sure that you're ok ?", ButtonType.CANCEL, ButtonType.OK);
            alert.setHeaderText("You're about to start a new game !"); alert.setResizable(false); alert.setTitle("RESTART");
            alert.showAndWait();
            if(alert.getResult() == ButtonType.OK) this.reset();
        }
    }

    @Override
    public void cheatClicked() {
        if(!game.getWin()) game.toggleWin();
    }
}
