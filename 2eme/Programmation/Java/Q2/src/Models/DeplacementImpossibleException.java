package Models;

public class DeplacementImpossibleException extends RuntimeException {

    @Override
    public String toString(){
        return "Déplacement impossible";
    }
}
