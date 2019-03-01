package be.helha.bataille;

import org.junit.Test;

import static org.junit.Assert.*;

public class JeuTest {
    Jeu jeuTest = new Jeu();

    @Test
    public void constructeurALeBonNombreDeCartes(){
        assertEquals(52, jeuTest.getNbCartes());
    }

    @Test
    public void constructeurABienToutesLesCouleurs(){
        assertEquals(4, jeuTest.getNbCouleurs());
    }

    @Test
    public void constructeurABienTreizeCartesParCouleur(){
        int[] expectedArray = new int[] {13,13,13,13};
        int[] testedArray = jeuTest.getNbCartesParCouleur();
        assertArrayEquals(expectedArray, testedArray);
    }

    @Test
    public void afficher(){
        assertEquals(52, jeuTest.toString().split("\n").length);
    }
}