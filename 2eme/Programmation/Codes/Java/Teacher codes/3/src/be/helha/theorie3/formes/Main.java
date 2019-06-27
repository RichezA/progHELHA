package be.helha.theorie3.formes;

import java.awt.*;

public class Main {

    public static void main(String[] args) {
        // Try, catch, finally
//        try {
//            throw new Exception();
//        }catch (Exception e){
//            System.out.println("Ici");
//            if(true)
//                throw new ArrayIndexOutOfBoundsException();
//        } finally {
//            System.out.println("Là");
//
//        }
//        System.out.println("Et là");

        // Héritage, polymorphisme

//        Forme forme = new CercleColore(new Point(5,5), 10);
//        Forme forme2 = forme;
//
//        System.out.println(forme.getHelloStr());
//        System.out.println(forme.getSurface());

//        Cercle cercle = new Cercle(new Point(5,5), 10);
//        System.out.println(cercle.getPerimetre());
//        System.out.println(((Forme)cercle).getPerimetre());
//        Rectangle rectangle = new Rectangle(new Point(6,6), 5, 8);
//        affichePerimetre(cercle);
//        affichePerimetre(rectangle);

//        Cercle c = new Cercle(new Point(5,5), 10){
//            @Override
//            public double getSurface() {
//                coucou();
//                return super.getSurface() - 1000;
//            }
//            public void coucou() {
//            System.out.println("Coucou");
//            }
//        };
//        System.out.println(c.getSurface());

        Forme forme = new Forme(new Point(5, 5)) {
            @Override
            public double getSurface() {
                return 50;
            }

            @Override
            public double getPerimetre() {
                return 80;
            }
        };
        System.out.println(forme.getSurface() + " " + forme.getPerimetre());
        Perimetrable p = new Perimetrable() {
            @Override
            public double getPerimetre() {
                return 10;
            }
        };
        affichePerimetre(p);
        Rectangle r = new Rectangle(new Point(5,5), 5,5);
        r.getSurface();

    }
    static void affichePerimetre(Perimetrable p) {
        System.out.println(p.getPerimetre());
    }
}
