package Models;

public class MouvementImpossibleException extends RuntimeException {
    @Override
    public String toString() {
        return "Déplacement impossible";
    }
}
