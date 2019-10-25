package helha.tictactoe_mvc.model;

public class Cell {

    private Player value;

    Cell() {
    }

    public Player getValue() {
        return value;
    }

    void setValue(Player value) {
        this.value = value;
    }
}
