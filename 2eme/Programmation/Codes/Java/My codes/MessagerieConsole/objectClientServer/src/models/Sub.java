package models;

public class Sub extends Operation {

    public Sub(int fst, int snd) {
        super(fst, snd);
    }

    @Override
    public float apply() {
        if(sndOperand != 0) return fstOperand / sndOperand;
        else throw new RuntimeException("Cannot divide by 0");
    }
}
