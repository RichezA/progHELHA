package be.helha.morpion.models;


import be.helha.morpion.controllers.Main;
import be.helha.morpion.views.MainViewController;

public class Game {
    public static final int BTN_SIZE = 30;
    public static final int NB_COLUMNS = 20;
    public static final int NB_ROWS = 20;
    public static final int NB_OFFSET = 75;

    private Box[][] grid;
    private boolean win;
    MainViewController controller;


    public Game(MainViewController ctrler){
        // get the grid from the view controller
        this.win = false;
        this.controller = ctrler;
        this.grid = controller.getGrid();
    }

    public void toggleWin() {
        this.win = !win;
    }

    public boolean getWin() {
        return this.win;
    }

}
