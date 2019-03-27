package models;

public class Add extends Operation {

    public Add(int fst, int snd) {
        super(fst, snd);
    }

    @Override
    public float apply() {
        return  fstOperand + sndOperand;
    }
}
