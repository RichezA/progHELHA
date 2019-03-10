package echecs.modeles;

import java.util.ArrayList;
import java.util.List;

// Responsabilité : gérer une position et de trouver les positions entre elle et une autre

public class Position {
    protected int x;
    protected int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public List<Position> getPositionsBetween(Position position) {
        ArrayList<Position> positions = new ArrayList<>();
        if(x == position.x) {
            for(int i=Math.min(y,position.y) + 1; i < Math.max(y,position.y); i++) {
                positions.add(new Position(x, i));
            }
        }else if(y == position.y) {
            for(int i=Math.min(x,position.x) + 1; i < Math.max(x,position.x); i++) {
                positions.add(new Position(i, y));
            }
        } else if (Math.abs(x - position.x) == Math.abs(y - position.y)) {

            int minY = Math.min(y,position.y);
            for(int i=Math.min(x,position.x) + 1; i < Math.max(x,position.x); i++) {
                positions.add(new Position(i, ++minY));
            }
        }
        return positions;
    }
}
