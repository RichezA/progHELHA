package be.helha.theorie3.formes;

public interface Perimetrable {

    default double getPerimetre() {
        return 0;
    };
}


interface ComplexPerimetrable extends Perimetrable {

}