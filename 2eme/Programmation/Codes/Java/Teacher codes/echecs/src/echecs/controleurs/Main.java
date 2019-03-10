package echecs.controleurs;

import echecs.modeles.Echiquier;
import echecs.modeles.Jeu;
import echecs.modeles.Position;
import echecs.modeles.exceptions.MouvementImpossibleException;
import echecs.vues.EchiquierVue;
import echecs.vues.UI;

public class Main {
    public static void main(String[] args) {
        new Main().demarrer();
    }

    private final Echiquier echiquier;
    private final Jeu jeu;
    private final EchiquierVue vueEchiquier;
    private final UI vueInteraction;

    public Main() {
        echiquier = new Echiquier();
        jeu = new Jeu(echiquier);
        vueEchiquier = new EchiquierVue(echiquier);
        vueInteraction = new UI(jeu);
    }

    public void demarrer() {
        while(true) {
            afficheEchiquierEtJoueur();
            Position position = vueInteraction.demandeQuellePiece();
            try {
                checkPremierePosition(position);
                Position positionFinale = vueInteraction.demandeQuelMouvement();
                jeu.deplace(position, positionFinale);
            }catch(Exception e){
                vueInteraction.messageMauvaisePosition();
            }
        }
    }

    private void afficheEchiquierEtJoueur() {
        vueEchiquier.afficher();
        vueInteraction.afficheCouleur();
    }


    private void checkPremierePosition(Position position) {
        if (!echiquier.estUneBonnePosition(position)) {
            throw new MouvementImpossibleException();
        }
        if (echiquier.getPieceA(position) == null) {
            throw new MouvementImpossibleException();
        }
    }
}
