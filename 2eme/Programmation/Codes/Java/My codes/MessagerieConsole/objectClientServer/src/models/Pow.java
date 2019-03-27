package models;

public class Pow extends Operation{

    public Pow(int fst, int snd) {
        super(fst, snd);
    }

    @Override
    public float apply() {
        return fstOperand  * sndOperand;
    }
}
