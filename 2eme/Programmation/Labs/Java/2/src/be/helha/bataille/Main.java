package be.helha.bataille;

// TODO : 4. Ajouter 2 joueurs, leur distribuer toutes les cartes et implémenter le jeu de la bataille => tout sauf jeu
// TODO : 5. Tester le tout

// règles
/* On compare carte contre carte, le joueur qui a la carte plus élevée gagne et remporte la carte de l'autre
 */

public class Main {

    public static void main(String[] args) {
        Jeu jeu = new Jeu();
        jeu.demarrerJeu();
    }
}
