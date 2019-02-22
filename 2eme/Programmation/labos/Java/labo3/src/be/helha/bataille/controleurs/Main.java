package be.helha.bataille.controleurs;

import be.helha.bataille.modeles.Jeu;
import be.helha.bataille.vues.UI;



/**
 * Contrôleur principal
 */
public class Main {

    public static void main(String[] args) {
        // Création du modèle de jeu
        Jeu jeu = new Jeu();

        // Création de la vue
        UI ui = new UI(jeu);

        ActionEnum action;
        do {
            jeu.mélanger();
            jeu.distribue();
            while (!jeu.estFini()) {
                ui.afficheTour(jeu.jouerUnTour());
            }
            ui.afficheFin();
            jeu.reinitialise();
            action = ui.quelleAction();
        } while (action != ActionEnum.QUITTER);

    }
}
