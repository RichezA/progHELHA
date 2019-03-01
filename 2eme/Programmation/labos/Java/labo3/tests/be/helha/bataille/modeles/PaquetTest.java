package be.helha.bataille.modeles;

import be.helha.bataille.modeles.exceptions.PlusDeCarteException;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class PaquetTest {


    public static final int NB_CARTES = 52;

    @Test
    public void mélanger() {
        Paquet paquet = new Paquet(NB_CARTES);
        paquet.ajouterToutesLesCartes();

        String avantMelange = paquet.toString();
        paquet.mélanger();
        String apresMelange = paquet.toString();
        assertNotEquals(avantMelange, apresMelange);

        // On réordonne les strings et on vérifie que toutes les cartes sont là
        String[] beforeStrings = avantMelange.split("\n");
        String[] afterStrings = apresMelange.split("\n");
        Arrays.sort(beforeStrings);
        Arrays.sort(afterStrings);
        assertEquals(String.join("",beforeStrings), String.join("", afterStrings));
    }

    @Test
    public void ajouterUneCarte() {
        Paquet paquet = new Paquet(NB_CARTES);
        paquet.ajouterUneCarte(new Carte(10, Couleur.CARREAU));
        assertEquals(paquet.taille(), 1);
        assertEquals(paquet.tirerUneCarte(), new Carte(10, Couleur.CARREAU));
    }


    @Test
    public void taille() {
    }

    @Test(expected = PlusDeCarteException.class)
    public void tirerUneCarte_AucuneCarte() {
        Paquet paquet = new Paquet(NB_CARTES); // paquet initialisé mais pas rempli => only null
        assertEquals(paquet.taille(), 0); // taille = 0
        paquet.tirerUneCarte(); // on retire une carte donc taille = -1 => /!\
    }

    @Test
    public void tirerUneCarte_ok() {
        Paquet paquet = new Paquet(NB_CARTES);
        paquet.ajouterUneCarte(new Carte(10, Couleur.CARREAU));
        assertEquals(paquet.taille(), 1);
        assertEquals(paquet.tirerUneCarte(), new Carte(10, Couleur.CARREAU));
        assertEquals(paquet.taille(), 0);
    }

    @Test
    public void tirerUneCarte_52() {
        Paquet paquet = new Paquet(NB_CARTES);
        paquet.ajouterToutesLesCartes();
        assertEquals(paquet.taille(), NB_CARTES);
        paquet.tirerUneCarte();
        assertEquals(paquet.taille(), 51);
    }

    @Test
    public void ajouterToutesLesCartes() {
        Paquet paquet = new Paquet(NB_CARTES);
        assertEquals(paquet.taille(), 0);
        paquet.ajouterToutesLesCartes();
        assertEquals(paquet.taille(), NB_CARTES);
    }

    @Test
    public void estVide() {
        Paquet paquet = new Paquet(NB_CARTES);
        assertTrue(paquet.estVide());
        paquet.ajouterToutesLesCartes();
        for(int i = 0; i < NB_CARTES; i++) {
            assertFalse(paquet.estVide());
            paquet.tirerUneCarte();
        }
        assertTrue(paquet.estVide());
    }
}