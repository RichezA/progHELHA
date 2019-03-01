package be.helha.bataille.modeles;

import be.helha.bataille.vues.UI;
import org.junit.Test;

import static org.junit.Assert.*;

public class TourTest {

    @Test
    public void testToString() {
        Tour tour = new Tour(new Carte(1, Couleur.CARREAU), new Carte(2, Couleur.TREFFLE));
        assertEquals(tour.toString(), "Tour : As de carreau vs 2 de treffle => Joueur 2 Gagnant");
        tour = new Tour(new Carte(5, Couleur.CARREAU), new Carte(2, Couleur.TREFFLE));
        assertEquals(tour.toString(), "Tour : 5 de carreau vs 2 de treffle => Joueur 1 Gagnant");
    }

    @Test
    public void joueur1Gagnant() {
        Tour tour = new Tour(new Carte(1, Couleur.CARREAU), new Carte(2, Couleur.TREFFLE));
        assertFalse(tour.joueur1Gagnant());
        tour = new Tour(new Carte(5, Couleur.CARREAU), new Carte(2, Couleur.TREFFLE));
        assertTrue(tour.joueur1Gagnant());

        tour = new Tour(new Carte(13, Couleur.COEUR), new Carte(8, Couleur.PIQUE), 0);      // test si J2 a la carte 8
        assertFalse(tour.joueur1Gagnant());
        tour = new Tour(new Carte(8, Couleur.PIQUE), new Carte(12, Couleur.TREFFLE), 1);    // test si J1 a la carte 8
        assertTrue(tour.joueur1Gagnant());
    }

    @Test
    public void joueursEgalite() {
        Tour tour = new Tour(new Carte(4, Couleur.PIQUE), new Carte(4, Couleur.CARREAU));           // test pour voir si egalité est bonne
        assertTrue(tour.joueursEgalite());
        tour = new Tour(new Carte(4, Couleur.TREFFLE), new Carte(12, Couleur.PIQUE));               // ou pas
        assertFalse(tour.joueursEgalite());
    }
}