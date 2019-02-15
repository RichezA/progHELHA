package be.helha.bataille;

import org.junit.Test;

import static org.junit.Assert.*;


public class CarteTest {

    Carte carteTest = new Carte(11, Couleur.PIQUE);
    boolean estAvantExpected = carteTest.estAvant(new Carte(9, Couleur.COEUR));
    boolean testEstAvant = false;

    @Test
    public void estAvant() {
        assertEquals(testEstAvant,estAvantExpected);
        Carte carte4 = new Carte(4, Couleur.TREFFLE);
        assertTrue(carte4.estAvant(carteTest));
        Carte carteAS = new Carte(1, Couleur.CARREAU);
        assertTrue(carteTest.estAvant(carteAS));
        assertFalse(carteAS.estAvant(carte4));
    }

    @Test
    public void testToString() {
        Carte carteTest = new Carte(13,Couleur.CARREAU);
//        carteTest.toString();
        //assertFalse("Valet", carteTest);
    }
}