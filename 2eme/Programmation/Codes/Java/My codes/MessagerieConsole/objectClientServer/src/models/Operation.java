package models;

import java.io.Serializable;

public abstract class Operation implements Serializable {
    int fstOperand, sndOperand;

    public Operation(int fst, int snd){
        this.fstOperand = fst;
        this.sndOperand = snd;
    }

    public abstract float apply();


    public int getFstOperand() {
        return fstOperand;
    }

    public int getSndOperand() {
        return sndOperand;
    }
}
