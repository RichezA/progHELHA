package echecs.vues;

import echecs.modeles.Couleur;
import echecs.modeles.Jeu;
import echecs.modeles.Position;

import java.util.Scanner;

public class UI {

    private final Jeu jeu;

    public UI(Jeu jeu) {
        this.jeu = jeu;
    }

    Position getPosition(){
      Scanner scanner = new Scanner(System.in);
      System.out.print("LigneColonne (ex. B1) ? ");
      String entree = scanner.next();
      int y = "ABCDEFGH".indexOf(entree.charAt(0));
      int x = Integer.parseInt(entree.charAt(1)+"");
      return new Position(x - 1, y);
    }

    public Position demandeQuellePiece() {
        System.out.println("-------------------------------------------");
        System.out.println("Quelle position voulez-vous jouer ?");
        System.out.println("-------------------------------------------");
        return getPosition();
    }

    public void messageMauvaisePosition() {
        System.out.println("-------------------------------------------");
        System.out.println("Mouvement impossible...");
        System.out.println("-------------------------------------------");
    }

    public Position demandeQuelMouvement() {
        System.out.println("-------------------------------------------");
        System.out.println("Vers quelle position voulez-vous déplacer ?");
        System.out.println("-------------------------------------------");
        return getPosition();
    }

    public void afficheCouleur() {
        System.out.println("-------------------------------------------");
        System.out.print("C'est aux ");
        if(jeu.estCouleurCourante(Couleur.BLANC)) {
            System.out.print("blancs");
        }else{
            System.out.print("noirs");
        }
        System.out.println(" de jouer...");
        System.out.println("-------------------------------------------");
    }
}
