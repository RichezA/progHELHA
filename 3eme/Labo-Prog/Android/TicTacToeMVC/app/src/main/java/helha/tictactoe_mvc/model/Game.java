package helha.tictactoe_mvc.model;

import android.util.Log;

import java.util.Observable;

import static helha.tictactoe_mvc.model.Player.O;
import static helha.tictactoe_mvc.model.Player.X;

public class Game extends Observable {

    private static String TAG = Game.class.getName();

    static final int SIZE = 3;

    private final Cell[][] cells;

    private Player winner;
    private GameState state;
    private Player currentTurn;

    public Game() {
        Log.d(TAG, "Game Constructor");
        cells = new Cell[SIZE][SIZE];
        clearCells();
        winner = null;
        currentTurn = Player.X;
        state = GameState.IN_PROGRESS;
    }

    public void mark(int row, int col) {
        Log.d(TAG, "Game mark "+row+" , "+col);
        if (isValid(row, col)) {

            cells[row][col].setValue(currentTurn);
            if (isWinningMoveByPlayer(currentTurn, row, col)) {
                state = GameState.FINISHED;
                winner = currentTurn;
            } else {
                flipCurrentTurn();
            }
        }
        notifierChangement();
    }

    public int getSize() {
        return SIZE;
    }

    public Player getCellValue(int row, int col) {
        return cells[row][col].getValue();
    }

    public void reset(){
        Log.d(TAG, "reset");
        clearCells();
        winner = null;
        currentTurn = Player.X;
        state = GameState.IN_PROGRESS;
        notifierChangement();
    }

    public Player getWinner() {
        return winner;
    }


    public void notifierChangement() {
        setChanged();
        notifyObservers(this);
    }

    private void clearCells() {
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                cells[i][j] = new Cell();
            }
        }
    }

    private boolean isValid(int row, int col) {
        if (state == GameState.FINISHED) {
            return false;
        }
        if (isOutOfBounds(row) || isOutOfBounds(col)) {
            return false;
        }
        return !isCellValueAlreadySet(row, col);
    }

    private boolean isOutOfBounds(int idx) {
        return idx < 0 || idx >= SIZE;
    }

    private boolean isCellValueAlreadySet(int row, int col) {
        return cells[row][col].getValue() != null;
    }

    private boolean isWinningMoveByPlayer(Player player, int currentRow, int currentCol) {

        return (cells[currentRow][0].getValue() == player // 3-in-the-row
                && cells[currentRow][1].getValue() == player
                && cells[currentRow][2].getValue() == player
                || cells[0][currentCol].getValue() == player // 3-in-the-column
                && cells[1][currentCol].getValue() == player
                && cells[2][currentCol].getValue() == player
                || currentRow == currentCol // 3-in-the-diagonal
                && cells[0][0].getValue() == player
                && cells[1][1].getValue() == player
                && cells[2][2].getValue() == player
                || currentRow + currentCol == 2 // 3-in-the-opposite-diagonal
                && cells[0][2].getValue() == player
                && cells[1][1].getValue() == player
                && cells[2][0].getValue() == player);
    }

    private void flipCurrentTurn() {
        currentTurn = currentTurn == X ? O : X;
    }

}
