package be.helha.morpion.models;


import be.helha.morpion.controllers.Main;
import be.helha.morpion.views.MainBoxInteraction;
import be.helha.morpion.views.MainViewController;


import java.util.Arrays;

public class Game implements MainBoxInteraction {
    public static final int BTN_SIZE = 30;
    public static final int NB_COLUMNS = 20;
    public static final int NB_ROWS = 20;
    public static final int NB_OFFSET = 75;

    private Box[][] grid;
    private boolean win;
    private boolean playerX;
    MainViewController controller;



    public Game(MainViewController ctrler){
        // get the grid from the view controller
        this.win = false;
        this.controller = ctrler;
        this.grid = controller.getGrid();
        Arrays.stream(this.grid).forEach( e -> Arrays.stream(e).forEach( f -> f.setInteraction(this)) );
        playerX = true;
        //this.init();
    }

//    public void init(){
//        for(int x = 0; x < NB_ROWS; x++){
//            for(int y = 0; y < NB_COLUMNS; y++){
//                 this.grid[x][y]
//            }
//        }
//    }

    public void play(){
        controller.setPlayerText("Current player: " + (playerX ? "X" : "O"));
    }

    public void toggleWin() {
        this.win = !win;
    }
    private void togglePlayer() { this.playerX = !this.playerX; }
    public boolean getWin() {
        return this.win;
    }

    private void endGame(){
        for(int x = 0; x < NB_ROWS; x++){
            for(int y = 0; y < NB_COLUMNS; y++){
                this.grid[x][y].setClicked(true);
            }
        }
        controller.setPlayerText("Player " + (playerX ? "X": "O") + " won the game!");
    }


    @Override
    public void clickedOnBox(int x, int y) {
        grid[x][y].setTextOnBtn(playerX ? "X" : "O");
        this.checkWin(new Position(x, y), grid[x][y].getBtn().getText());
        if(win){
               this.endGame();
        }
        else{
            this.togglePlayer();
            this.play();
        }
    }

    public void checkWin(Position pos, String btnSet){
        for(int x = -1; x < 2; x++){
            for(int y = -1; y < 2; y++){
                if(x == 0 && y == 0) continue;
                if(Math.abs(x) == 1 && Math.abs(y) == 1){
                    if(x == y) this.checkDiag(pos.x + x, pos.y + y, true, btnSet);
                    else this.checkDiag(pos.x + x, pos.y + y, false, btnSet);
                }
                if(x == 0 && Math.abs(y) == 1) this.checkColumn(pos.x + x, pos.y + y, btnSet);
                if(Math.abs(x) == 1 && y == 0) this.checkRow(pos.x + x, pos.y + y, btnSet);
                if(win) return;
            }
        }
    }


    private void checkColumn(int x, int y, String btnSet){
        int count = 0;
        for(int i = -1; i < 2; i++) if(isValidPosition(x, y + i)) if(this.getCase(x,y + i).getBtn().getText().equals(btnSet)) count++;
        if(count == 3) win = true;
    }

    private void checkRow(int x, int y, String btnSet){
        int count = 0;
        for(int i = -1; i < 2; i++) if(isValidPosition(x + i, y)) if(this.getCase(x + i, y).getBtn().getText().equals(btnSet)) count++;
        if(count == 3) win = true;
    }

    private void checkDiag(int x, int y, boolean correct, String btnSet){
        int count = 0;
        if(correct){
            for(int i = -1; i < 2; i++) if(this.isValidPosition((x + i), (y + i))) if (this.getCase(x + i, y + i).getBtn().getText().equals(btnSet)) count++;
            if (count == 3) win = true;
            return;
        }
        for(int i = -1; i < 2; i++) if(isValidPosition(x+i, y+(-i))) if(this.getCase(x+i, y + (-i)).getBtn().getText().equals(btnSet)) count++;
        if (count == 3) win = true;
        return;
    }

    public Box getCase(int x, int y){
        return this.grid[x][y];
    }

    private boolean isValidPosition(int x, int y){
        return x >= 0 && x < NB_ROWS && y >= 0 && y < NB_COLUMNS;
    }

}
