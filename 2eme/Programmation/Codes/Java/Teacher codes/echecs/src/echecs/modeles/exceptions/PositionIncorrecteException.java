package echecs.modeles.exceptions;

public class PositionIncorrecteException extends RuntimeException{

    int x, y;

    public PositionIncorrecteException(int x, int y) {
        this.x=x;
        this.y=y;
    }
}
