package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;

 class PlayerName{
    private String playerName;
    public PlayerName(){
        this.playerName = "X";
    }
    public String getPlayerName() {return playerName;}
    public void changePlayerName() {
        if(playerName == "X") playerName = "O";
        else playerName = "X";
    }
 }


public class Main extends Application {
    public static final double BUTTON_SIZE = 35.0;
    public static final int OFFSET_SIZE = 70;
    public Boolean isGameFinished = false;


    void startGame(Stage primaryStage){
        PlayerName currentPlayer = new PlayerName();

        // pane initialisation
        AnchorPane pane = new AnchorPane();
        primaryStage.setTitle("OXO !");
        primaryStage.setScene(new Scene(pane, 800, 800));

        // restart game button initialisation
        Button newGame = new Button();
        newGame.prefHeight(40.0); newGame.prefWidth(75.0); newGame.setLayoutX(10.0); newGame.setLayoutY(20.0); newGame.setText("Nouvelle Partie ?");
        newGame.setOnMouseClicked(event -> {
            if(!isGameFinished){
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Yo are you sure that you're ok ?", ButtonType.CANCEL, ButtonType.OK);
                alert.setHeaderText("You're about to start a new game !"); alert.setResizable(false); alert.setTitle("RESTART");
                alert.showAndWait();
                if(alert.getResult() == ButtonType.OK) restart(primaryStage);
            }
            else{
                restart(primaryStage);
            }

        });
        pane.getChildren().add(newGame);

        //cheat button to automatically win
        Button cheatButton = new Button("Press to win");
        cheatButton.setOnMouseClicked(event -> {
            isGameFinished = true;
        });
        cheatButton.setLayoutY(10.0); cheatButton.setLayoutX(500.0);
        pane.getChildren().add(cheatButton);


        // Text initialisation
        Text text = new Text();
        text.setLayoutX(150.0); text.setLayoutY(37.5); text.setText("Joueur courant: " + currentPlayer.getPlayerName());
        pane.getChildren().add(text);

        // button initialisation
        for(int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                Button button = new Button();
                button.setPrefHeight(BUTTON_SIZE);
                button.setPrefWidth(BUTTON_SIZE);
                button.setLayoutX(BUTTON_SIZE * i);
                button.setLayoutY(BUTTON_SIZE * j + OFFSET_SIZE);
                button.setOnMouseClicked(event -> {
                    Button b = (Button) event.getSource();
                    b.setText(currentPlayer.getPlayerName());
                    System.out.println("Joueur " + b.getText() + " vient de jouer");
                    b.setDisable(true);
                    currentPlayer.changePlayerName();
                    text.setText("Joueur courant: " + currentPlayer.getPlayerName());
                });
                pane.getChildren().add(button);
            }
        }
        primaryStage.show();
    }


    // if we need to clear the terminal
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    void cleanup(){}
    void restart(Stage stage){
        //cleanup();
        System.out.println("\n\n\n\nNOUVELLE PARTIE\n\n\n");
        startGame(stage);
    }


    @Override
    public void start(Stage primaryStage) throws Exception{
        startGame(primaryStage);
    }


    public static void main(String[] args) {
        launch(args);
    }
}
