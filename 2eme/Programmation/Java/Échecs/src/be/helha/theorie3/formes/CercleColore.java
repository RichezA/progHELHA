package be.helha.theorie3.formes;

import java.awt.*;

public class CercleColore extends Cercle {

    public CercleColore(Point centre, int rayon) {
        super(centre, rayon);
    }

    @Override
    public String getHelloStr() {
        return "I'm :" + getNom();
    }
}
