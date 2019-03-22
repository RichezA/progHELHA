package be.helha.morpion.views;

import be.helha.morpion.models.Box;
import be.helha.morpion.models.Game;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

import static be.helha.morpion.models.Game.*;

public class MainViewController implements Initializable {

    MainViewInteraction interaction;
    private Box[][] grid;

    public Box[][] getGrid(){
        return this.grid.clone();
    }

    public void setInteraction(MainViewInteraction interaction){
        this.interaction = interaction;
    }

    @FXML
    private Button playAgain;

    @FXML
    private AnchorPane playGrid;
    @FXML
    private AnchorPane topPane;
    @FXML
    private Label currentPlayer;

    @FXML
    private void onClickedPlayAgain(MouseEvent event) {
        // check if a Player won the game or throw an alert
        try {
            interaction.resetGame();
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }

    public void setPlayerText(String text){
        this.currentPlayer.setText(text);
    }


    private void initGrid() {
        this.grid = new Box[20][20];
        for (int x = 0; x < NB_ROWS; x++) {
            for (int y = 0; y < NB_COLUMNS; y++) {
                this.grid[x][y] = new Box((BTN_SIZE * x), (BTN_SIZE * y));
                playGrid.getChildren().add(this.grid[x][y].getBtn());
            }
        }
        //this.initCheatBtn();
    }

    private void initCheatBtn(){
        Button btn = new Button();
        btn.setOnMouseClicked(event -> {
            interaction.cheatClicked();
        });
        btn.setText("CHEAT"); btn.setLayoutX(250); btn.setLayoutY(13);
        topPane.getChildren().add(btn);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.initGrid();
    }
}
