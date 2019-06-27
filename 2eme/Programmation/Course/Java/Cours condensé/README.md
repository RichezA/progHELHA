# Cours de Java

![Icône Java](https://upload.wikimedia.org/wikipedia/en/thumb/3/30/Java_programming_language_logo.svg/1200px-Java_programming_language_logo.svg.png)

Cours de __DUDZIAK THOMAS__ sur le langage de programmation "Java".
Je mets ce cours à disposition de tout le monde.
Les suggestions sont les bienvenues.

![Icône HelHa](https://helha.be/app/themes/helha/img/logo.svg)

## Sommaire

---

1. [Intro](#Introduction)

2. [Quelques classes utiles](#Quelques-classes-utiles)
    1. [Classe Main](#Classe-Main)
    2. [Classe System](#Classe-System)
    3. [Classe Scanner](#Classe-Scanner)

3. [La méthode main](#Méthode-main)

4. [Types](#Types)
    1. [Types de base](#Types-de-base)

5. [Boucles](#Boucles)
    1. [Boucle for](#Boucle-for)
    2. [Boucle foreach](#Boucle-foreach)
    3. [Autres boucles](#Autres-boucles)

6. [Constantes](#Constantes)

7. [Méthodes](#Méthodes)
    1. [Définition d'une méthode](#Définition-d'une-méthode)
    2. [Arguments par défaut](#Arguments-par-défaut)
    3. [Redéfinition de méthodes](#Redéfinition-de-méthodes)
    4. [Surcharge de méthodes](#Surcharge-de-méthodes)

8. [Classes](#Classes)
    1. [Définition d'une classe et ses attributs](#Définition-d'une-classe-et-ses-attributs)
    2. [Constructeurs de classe](#Constructeurs-de-classe)
    3. [Chaînage de constructeurs](#Chaînage-de-constructeurs)
    4. [Redéfinition de constructeurs](#Surcharge-de-constructeurs)

9. [Objets](#Objets)
    1. [Instanciation d'un objet](#Instanciation-d'un-objet)
    2. [Le "static"](#Le-"static")

10. [Exceptions](#Exceptions)
    1. [Qu'est-ce qu'une exception ?](#Qu'est-ce-qu'une-exception-?)
    2. [Gérer les exceptions](#Gérer-les-exceptions)

11. [Garbage collector](#Garbage-collector)
    1. [GarbaQuoi ?](#GarbaQuoi-?)
    2. [Méthode "Finalize()"](#Méthode-"Finalize()")

12. [Tableaux](#Tableaux)
    1. [Tableau unidimensionnel](#Tableau-unidimensionnel)
    2. [Tableau multidimensionnel](#Tableau-multidimensionnel)
    3. [Parcourir un tableau](#Parcourir-un-tableau)

13. [Les ArrayLists](#Les-ArrayLists)
    1. [Création d'une ArrayList](#Création-d'une-ArrayList)
    2. [Modifier une liste](#Modifier-une-liste)
    3. [Parcourir une liste](#Parcourir-une-liste)

14. Héritage (à suivre...)
    1. []()
    2. []()
    3. []()

## Introduction

---

- Nom du compilateur : "javac.exe"

- Multiplateforme :

    - Compilation en ".class" et pas en ".exe"
    
        - Le ".jar" (java archive) contient tous les ".class"

    - On passe les ".class" en paramètres à "java.exe" et ce dernier pourra "parler à l'OS". Cependant, si on clique sur un ".jar", on passera tout à "java.exe"

    - En gros, si on a la bonne version de java, on pourra éxécuter nos ".class" sur n'importe quelle plateforme !

    ![Compilation](https://www.safaribooksonline.com/library/view/client-server-web-apps/9781449369323/images/clwa_0401.png)

- JRE (Java Runtime Environment) : Clients (pour l'éxécution donc)

- JDK (Java Development Kit) : Dévéloppeurs

- Orienté-objet (pas à 100% car il existe encore des types primitifs)

- Oracle est derrière Java et on peut donc trouver toute la doc. chez eux

## Quelques classes utiles

---

### Classe Main

- C'est la classe où tout commence.

### Classe System

- Attribut statique "out" :

    - Méthode println :

    ```java
    System.out.println("Mon texte");
    //Surcharges pour tous les types existantes
    ```
    - Méthode(s) print :

    ```java
    System.out.print(maVariable);
    //Il existe des surcharges pour tous les types
    ```

- Il existe également un attribut statique "in" pour les entrées. Mais on utilisera une classe pour cela (classe Scanner de la librairie "java.util.Scanner)

### Classe Scanner

- Prend un argument : un flux d'entrée (on donne le flux d'entrée de la console dans l'exemple)

    ```java
    Scanner scanner = new Scanner(System.in);

    //scanner.nextInt();
    String s = scanner.next();
    int i = scanner.nextInt();
    ```

## Méthode main

---

- Comme vu précédemment, Java est orienté-objet. __RIEN__ ne se trouve en dehors d'une classe et ainsi en va pour la méthode main

- Signature obligatoire :

    ```java
    public static void main(String[] args)
    ```
- Ne renvoie rien (void)

- Arguments de programme : Contrairement au C++, le nom du fichier que l'on vient d'éxécuter ne fait pas partie des arguments.

## Types

---

- Java est typé statiquement

- Tous les types de base sont des types primitifs (ce ne sont pas des objets). Cependant, parfois on a besoin d'en avoir un objet avec laquelle on peut faire des traitements, utiliser des méthodes (parse, ...), etc... Pour chaque type primitif, on aura donc une classe qui lui correspond.

### Types  de base 

- Voici les types primitifs disponibles en Java

    - Byte :

        ![byte](https://www.decodejava.com/byte.png)

    - Short :

        ![short](https://www.decodejava.com/short.png)

    - Int :

        ![int](https://www.decodejava.com/int.png)

    - Long :

        ![long](https://www.decodejava.com/long.png)

    - Float :

        ![float](https://www.decodejava.com/float.png)

    - Double :

        ![double](https://www.decodejava.com/double.png)

    - Char :

        ![char](https://www.decodejava.com/char.png)

    - Boolean :

        ![boolean](https://www.decodejava.com/boolean.png)

## Boucles

--- 

### Boucle for

- Syntaxe "classique" :

    ```java
    for(int i = 0; i < 10; i++)
    {
        // Code ici
    }
    ```

### Boucle foreach

- On donne le "type nom_temporaire : collection" :

    ```java
    for(String s : args)
    {
        //Code ici
    }
    ```

### Autres boucles

- On retrouve également les autres boucles classiques (while, do...while) :

    ```java
    while(condition)
    {
        //Code ici
    };

    do
    {

    }while(condition);
    ```

## Constantes

---

- On peut également définir des constantes en Java.

- Le mot-clef est "final"

- Exemple :

    ```java
    public static final int maConstante = 25;
    ```

## Méthodes

---

### Définition d'une méthode

- Afin de créer une méthode, rien de bien compliqué. On donne la visibilité/niveau de protection de la méthode, son type de retour et son nom ainsi que des éventuels arguments entre parenthèses.

- Exemple :

    ```java
    public int Calcul(int a, int b)
    {
        return a + b;
    }
    ```

### Arguments par défaut

- Il n'existe __aucune possibilité d'avoir des arguments par défaut__ en Java

- __ON NE PEUT DONC PAS FAIRE CECI :__

    ```java
    public int Calcul(int a, int b = 20) //KO !! IMPOSSIBLE
    {
        return a + b;
    }
    ```

### Redéfinition de méthodes

- On peut rédéfinir (override en Anglais) des méthodes afin de revoir leur fonctionnement

- Prenons un exemple où nous souhaitons redéfinir ToString() :

    ```java
    public class Main()
    {
        Personne p = new Personne("Dubreuil", "Bernard");
    }

    public class Personne()
    {
        private String nom;
        private String prenom;

        //Constructeur avec plusieurs arguments
        public Personne(String nom, String prenom)
        {
            this.nom = nom;
            this.prenom = prenom;
        }

        public String GetNom()
        {
            return this.nom;
        }

        public String GetPrenom()
        {
            return this.prenom;
        }

        //On indique que l'on surcharge (bonne pratique mais pas obligatoire)
        @override
        public String toString()
        {
            return String.Format("Personne : %s %s", this.nom, this.prenom);
        }
    }
    ```

- On remarque donc qu'on peut facilement rédéfinir le fonctionnement de toString(). En fait, __TOUTES LES CLASSES DERIVENT DE LA CLASSE "Object" !__ Grâce à ça, toutes nos classes auront donc un "toString()".

### Surcharge de méthodes

- On peut surcharger des méthodes (overload en Anglais). Cela consiste à créer une méthode de même nom mais de signature différentes (types et/ou nombres d'arguments différents : 

    ```java
    public int Calcul(int a, String b)
    {
        return a + Integer.parseInt(b);
    }
    //On surcharge "Calcul()" => deuxième méthode de même nom mais de signature de même nom
    public int Calcul(int a, int b)
    {
        return a + b;
    }
    ```

## Classes

---

- Rappel : En Java, rien ne se trouve en dehors d'une classe, les classes sont donc essentielles.

### Définition d'une classe et ses attributs

- Pour définir une classe, on indique la visibilité/le niveau de protection de la classe, le mot-clef "class" et enfin, le nom de cette classe :

    ```java
    public class Personne
    {

    }
    ```

- 4 visibilités disponibles :

    - public => Public = Tout le monde peut y accéder
    - private => Private = Impossible d'y accéder depuis l'extérieur
    - protected => Protected = Classes enfant
    - package (__Par défaut si on ne met pas le niveau de protection__) => Package = Même dossier

- Chaque classe dérivera de la classe "Object" et aura donc certaines "fonctionnalités" par défaut

### Constructeurs de classe

- Un constructeur nous servira à insérer des valeurs, ou encore faire certaines actions à la création d'une instance d'objet

- Voici comment créer un constructeur : 

    ```java
    class Personne
    {   
        private String Nom;
        private String Prenom;

        //Constructeur
        public Personne(String Nom, String Prenom)
        {
            this.Nom = Nom;
            this.Prenom = Prenom;
        }
    }
    ```

### Chaînage/Surcharge de constructeurs

- Le chaînage de constructeurs nous permet d'appeler un autre constructeur de la même classe. Imaginons un constructeur avec un argument et un deuxième avec 2, nous pourrions imaginer vouloir une valeur par défaut dans le deuxième argument (explication abstraite, voir exemple).

- Exemple de chaînage de constructeurs :

    ```java
    public class Personne
    {
        private String nom;
        private String prenom;

        //Constructeur par défaut sans argument
        public Personne()
        {
            //this.nom = "Dudziak";

            //Chaînage/Délégation de constructeur
            //TOUJOURS EN PREMIERE LIGNE D UN CONSTRUCTEUR !!!
            this("Dudziak");
        }

        //Constructeur avec argument
        public Personne(String nom)
        {
            //this.nom = nom;

            this(nom, "Thomas");
        }

        //Constructeur avec plusieurs arguments
        public Personne(String nom, String prenom)
        {
            this.nom = nom;
            this.prenom = prenom;
        }
    }
    ```

### Redéfinition de constructeur

- On peut rédéfinir un constructeur. Cela nous est utile pour accueillir, par exemple, deux constructeurs avec un nombre d'arguments identiques mais dont les types sont différents

- En Java, il est possible de surcharger un constructeur (on considère garder la même classe que dans le point précédent) :

    ```java
    public Personne(int nom)
    {
        this(Integer.toString(nom));
        //Certes cela n'a pas vraiment de sens dans notre cas, mais la     surcharge est bel et bien possible
    }
    ```

## Objets

---

- Les objets sont le coeur même du langage. On doit donc créer des instances d'objets.

### Instanciation d'un objet

- Pour créer une instance d'objet, il faut utiliser le mot clef "new". Voici un exemple d'instanciation :

    ```java
    Objet objet = new Objet();
    //On peut également attribuer null à un objet mais, il ne sera donc pasinstancié
    Objet obj =  null;
    ```

- Méthode "ToString()" par défaut pour chaque objet. On affichera par défaut le nom du package et le nom de la classe. On surchargera souvent cette méthode pour redéfinir son fonctionnement pour un objet que nous aurons nous même crée

### Le "static"

- Cependant, il est possible d'accéder à des membres statiques dans une classe et il n'est pas nécéssaire d'instancier un objet afin de récupérer ces membres. Cependant, ces membres seront communs à toutes les instances de cette classe :

    ```java
    public class Main
    {
        public static void main(String[] args)
        {
            double pi = Maths.Pi;
            //OK
        }
    }

    class Maths
    {
        public final static double Pi = 3.1415;
    }
    ```

- Il est également possible de créer des méthodes statiques :

    ```java
    public class Main
    {
        public static void main(String[] args)
        {
            int add = Maths.Addition(1, 2);
            //add = 3
            //OK
        }
    }

    class Maths
    {
        public static int Addition(int a, int b)
        {
            return a + b;
        }
    }
    ```

## Exceptions

---

### Qu'est-ce qu'une exception ?

- Dans certains cas, une erreur peut survenir et risque de faire planter le programme. Par exemple, on attend que l'utilisateur rentre un entier, et finalement il entre du texte, lorsque l'on essaierai de transformer ce texte en entier, nous aurons une exception.

- Pour éviter que le programme plante lorsqu'il y a une exception lancée, il faudra les gérer avec un bloc "try-catch"

### Gérer les exceptions

- Nous utiliserons "try" afin "d'essayer" un bout de code susceptible de générer une exception dans certains cas. Ce bloc "try" sera suivi d'un bloc "catch" avec le type d'exception(s) pris(es) en compte. Le programme ne plantera pas et on pourra choisir de faire quelque chose dans le cas d'une exception afin de remédier au problème.

    - __NB__ : Si on veut gérer plusieurs exceptions différentes, soit on utilise "Exception seul", mais on peut aussi avoir plusieurs blocs "catch" les uns à la suite des autres.

- Imaginons que du texte est entré au lieu d'un entier :

    ```java
    try
    {
        System.out.print("Entrez un chiffre : ");
        scanner.NextInt();
    }
    catch(InputMismatchException ex)
    {
        scanner.Next();
    }

    scanner.Close();
    ```

### Finally

- Permet d'éxécuter du code dans les deux cas, qu'il y ait une exception lancée ou pas :

    ```java
    try
    {
        throw new Exception();
    }
    catch(Exception ex)
    {
        //Code si exception
    }
    finally
    {
        //Code éxécuté dans les 2 cas (qu'il n'y ait ou pas d'exception lancée)
    }
    ```

## Garbage collector

---

### GarbaQuoi ?

- Java est un langage managé, ce qui signifie que nous ne devons pas nous occuper de la mémoire ! Le garbage collector est le nom de ce qui va s'occuper de la mémoire pour nous

- Le garbage collector s'occupe de la mémoire et va détruire ce dont on a plus besoin.

- Cependant, il est possible d'appeler soi-même le garbage collector pour qu'il fasse sa "petite ronde" :

    ```java
    System.gc(); //Appel du garbage collector

    //Très peu utilisé. Il est rare d'appeler le GC soi-même
    ```

### Méthode "Finalize()"

- Cette méthode est définie dans la classe "Object" (toutes les classes que l'on crée l'ont donc évidemment).

- Il est donc possible de la surcharger

- Asynchrone

- Cette méthode nous prévient donc quand un objet sera détruit

    ```java
    public class Personne
    {
        private String Nom;
        private String Prenom;

        private static int NombreDePersonnes;

        @override
        protected void finalize() throws Throwable
        {
            super.finalize();
            System.out.println(String.Format("Personne supprimée : %s %s", this.Nom, this.Prenom));

            NombreDePersonnes--;
        }
    }
    ```
- Egalement peu utilisé et peu recommandé car on se base sur le Garbage Collector

## Tableaux

---

- Un tableau est une collection. En fait, on va créer en mémoire un espace contigu qui contiendra une suite d'objets/variables de type primitives.

- Un tableau est un objet complexe => Requiert un new

### Tableau unidimensionnel

```java
//2 possibilités pour instancier un tableau :

int tabEntiers[] = new int[10]; //Sucre syntaxique, à la compilation on "transforme" la ligne en la deuxième possibilité ci-dessous

int[] tabEntiers2 = new int[10];
```

### Tableau multidimensionnel

```java
int[][] tableauMulti = new int[10][5];
```

### Parcourir un tableau

- Utilisons des boucles (for ou foreach sont idéales) :

    ```java
    int[][] tableauMulti = new int[10][5];
    int[] tableauUni = new int[10];

    //Avec une boucle for :
    for(int i = 0; i < tableauMulti.Length; i++)
    {
        System.out.println(tableauMulti[i][j]);
    }

    //Avec une boucle foreach :
    for(int nb : tableauUni)
    {
        System.out.println(nb);
        //Plus facile avec un foreach !
    }

## Les ArrayLists

---

- Les tableaux ayant une table fixe, les arraylists ont l'énorme avantage d'avoir une taille variable

### Création d'une ArrayList

- ArrayList est un objet :

    ```java
    ArrayList<Integer> list = new ArrayList();
    ```

- Dans l'exemple ci-dessus, on a typé l'ArrayList. Cependant, ce n'est pas obligatoire car nos listes dérivent d'Object.

    ```java
    ArrayList list = new ArrayList();
    ```

### Modifier une liste

- Ajouter un élement :

    ```java
    ArrayList<Integer> list = new ArrayList();

    list.Add(10);
    ```

- Enlever un élément : 

    ```java
    ArrayList<Integer> list = new ArrayList();
    //On remove l'élément à l'index 0
    list.Remove(0);
    ```

### Parcourir une liste

- Utilisation de boucles for et/ou foreach

- On peut également récupérer un élément avec ArrayList.get(index) :

    ```java
    ArrayList<Integer> listeEntiers = new ArrayList();
    listeEntiers.Add(1);

    System.out.println(listeEntiers.get(0));
    //Affiche "1" car le premier élément (l'élément 0 donc) vaut 1
    ```

## Héritage

### Mot-clef extends

- Utilisation avec le mot-clef "extends"

    ```java
    public class Personne
    {
        protected String Nom; //Possible d'y accéder en sous-classe mais pas dans les autres
        protected String Prenom; //Possible d'y accéder en sous-classe mais pas dans les autres
        private int Age; //On ne peut pas y accéder en sous-classe
        public 

        public Personne(String Nom, String Prenom)
        {
            this.Nom = Nom;
            this.Prenom = Prenom;
        }
    }

    public class Adulte extends Personne
    {
        private String NomEntreprise;

        public Adulte(String Nom, String Prenom, String NomEntreprise)
        {
            super(Nom, Prenom);
            this.NomEntreprise = NomEntreprise;
        }
    }

    public class Enfant extends Personne
    {
        private String NomEcole;

        public Enfant(String Nom, String Prenom, String NomEcole)
        {
            super(Nom, Prenom);
            this.NomEcole = NomEcole;
        }
    }
    ```

### Polymorphisme de méthodes

- Exemple de polymorphisme commenté : 

    ```java
    public class Forme
    {
        protected Point centre;

        public Forme(Point centre)
        {
            this.centre = centre;
        }

        public String getNom()
        {
            return "Forme";
        }

        public String getHelloStr()
        {
            return "Je suis : " + this.getNom();
        }
    }

    public class Cercle
    {
        protected double rayon;

        public Cercle(Point centre, double rayon)
        {
            super(centre);
            this.rayon = rayon;
        }

        @override
        public String getNom()
        {
            return "Cercle";
        }
    }

    //Si j'instancie Cercle c = new Cercle :
    //Si j'appelle "getHelloStr()",
    //J'aurai "Je suis : cercle" en sortie.
    ```

### Classes abstraites

- Une classe abstraite ne peut être instanciée

- On est donc obligés de créer une sous-classe qui en dérive :

    ```java
    public abstract class Forme
    {
        protected Point centre;

        public Forme(Point c)
        {
            this.centre = c;
        }
    }

    public class Cercle extends Forme
    {
        protected double rayon;

        public Cercle(Point c, double rayon)
        {
            super(c);
            this.rayon = rayon;
        }
    }

    // Dans le main :
    Cercle c = new Cercle(new Point(5, 6), 5.2); // OK
    Forme fc = new Cercle(new Point(5, 7)); // OK
    Forme f = new Forme(new Point(5, 6)); //KO => NON !!
    ```

### Méthodes abstraites

- Permet de définir la signature d'une méthode mais impossible de lui donner un corps

- Utile pour obliger la redéfinition d'une méthodes dans les classes filles

- Pour créer des méthodes abstraites, il faut se trouver dans une classe abstraite

- Méthode abstraite :

    ```java
    public abstract class Forme
    {
        public Forme()
        {
            //Ctor
        }

        public abstract double getSurface();
        public abstract double getAire();
        //On donne une signature mais pas de corps
        //On sera obligés de définir le corps de ces méthodes dans les classes filles
    }
    ```

### Méthodes "final"

- On ne pourra pas redéfinir cette méthodes dans les classes filles

    ```java
    public final void ThingyThing()
    {
        //Code ...
    }
    //IMPOSSIBLE DE REDEFINIR CETTE METHODE
    ```

### Classes "final"

- Impossible d'hériter de cette classe, c'est la "dernière de sa lignée" :

    ```java
    public final class Forme
    {

    }

    public class Cercle extends Forme //KO => NON
    {

    }
    ```

## Les interfaces

### Qu'est-ce qu'une interface ?

- Ensemble de méthodes publiques que l'on va déclarer mais pas définir (sauf avec le mot-clef "default dans les nouvelles versions de Java) ! On ne peut donc pas faire ceci :

    ```java
    public interface Perimetrable
    {
        double getPerimetre()
        {
            return 0; //KO => NON
        }

        default double thingyThing()
        {
            return 0; //OK !!!
        }
    }
    ```

- Cela nous permettra d'avoir des types supplémentaires

- On peut donc bien instancier une interface mais on ne pourra appeler que les méthodes de celle-ci

- Si une classe mère implémente une interface, les classes filles aussi. Il faudra donc également leur rédéfinir les méthodes

### Création d'une interface :

- Mot-clef "interface" :

    ```java
    public interface Perimetrable
    {
        double getPerimetre();
    }
    ```

### Implémentation d'une interface :

- Utilisation du mot-clef "implements"

    ```java
    //On reprend l'interface définie au-dessus
    public class Forme implements Perimetrable
    {
        protected Point centre;

        public Forme(Point c)
        {
            this.centre = c;
        }

        //JE SUIS OBLIGE DE CONTENIR LES METHODES AVEC UNE SIGNATURE IDENTIQUES A CELLES DE L'INTERFACE
        public double getPerimetre()
        {
            return 0;
        }
    }

    public class Rectangle extends Forme
    {
        protected double largeur;
        protected double longueur;

        public Rectangle(Point centre, double largeur, double longueur)
        {
            super(centre);
            this.largeur = largeur;
            this.longueur = longueur;
        }

        //Implémentation de l'interface "Perimetrable"
        public double getPerimetre()
        {
            return (this.largeur * this.longueur);
        }
    }
    ```

- On voit bien qu'on définit le corps des méthodes 

### Implémentation de plusieurs interfaces

- Il est possible de dériver de plusieurs interfaces dans une classe : 

    ```java
    public class Forme implements Perimetrable, Serializable
    {
        //On doit toujours et encore définir le corps des méthodes de Perimetrable
        //MAIS AUSSI DE SERIALIZABLE
    }
    ```

- Si deux interfaces dont on hérite ont deux méthodes ayant une signature identique, il faudra définir une seule fois la méthode dans notre classe et tout fonctionnera très bien et sans conflit

### Hiérarchie d'interfaces

- Il est possible de faire dériver une interface d'une autre ! :

    ```java
    public interface Perimetrable
    {
        //Code ...
    }

    public interface ComplexPerimetrable extends Perimetrable
    {
        //Code ...
    }
    ```

### Interfaces et UML

- Voici comment montrer l'implémentation d'interfaces en UML :

    ![Implémentation d'interface en UML](https://i.stack.imgur.com/ztO39.png)

## Les classes anonymes

### Qu'est-ce qu'une classe anonyme ?

- Création de classes à la volée 

- On créera une classe sans nom qui héritera d'une autre et dont on pourra redéfiner le comportement

### Définition d'une classe anonyme

- Utilisation des accolades pour définir une classe anonyme :

    ```java
    Cercle c = new Cercle(new Point(5, 6), 10.0)
    {
        @override
        public double getSurface() //Redéfinition de "getSurface()" de la classe mère
        {
            coucou(); //OK !
            return super.getSurface() - 1000;
        }

        public void coucou() //Impossible de l'appeler en dehors d'ici
        {
            System.out.println("coucou");
        }
    }; //Ne pas oublier !

    c.getSurface(); //OK !
    c.coucou(); //KO => NON
    ```

### Utilisations

- Cela s'avèrera utile lors de la création de boutons et de listeners (mais pas que)

- On peut également redéfinir une interface de cette manière :

    ```java
    Perimetrable p = new Perimetrable()
    {
        @override
        public double getPerimetre()
        {
            return 10;
        }
    }; //Rappel ";"

    double perim = p.getPerimetre(); //OK
    ```

## Classes internes

### Vous avez dit classes internes ?!

- En effet, il est possible de créer des classes à l'intérieur de... classes

- Elle s'utilise comme une classe classique, elle est juste définie dans notre classe

### A quoi ça sert ?!

- On pourra avoir un lien fort entre les deux classes !!

    ```java
    public class Personne
    {
        protected String nom;
        protected String prenom;
        protected Adresse adresse;

        public Personne(String nom, String prenom, String rue, int numero)
        {
            this.nom = nom;
            this.prenom = prenom;
            this.adresse = new Adresse(numero, rue);
        }

        public String getNom()
        {
            return this.nom;
        }

        class Adresse
        {
            protected String rue;
            protected int numero;

            public Adresse(int numero, String rue)
            {
                this.numero = numero;
                this.rue = rue;
            }

            @override
            public String toString()
            {
                return "Je suis l'adresse de : " + Personne.this.getNom();
                //On va chercher getNom() dans Personne !!!
            }
        }
    }
    ```

- L'exemple au-dessus ne fonctionnera pas si notre classe est statique, évidemment...

## Les classes génériques

### C'est quoi ?

- Classe dont le type sera remplacé dynamiquement dans le code

### Exemple

- Entre "crochets triangulaires", on mettra un nom qui remplacera le type

```java
//On va faire un exemple avec une classe de pairs clefs/valeurs
class Pair<T>
{
    T key;
    T value;

    public Pair(T key, T value)
    {
        this.key = key;
        this.value =value;
    }

    public T getKey()
    {
        return this.key;
    }

    public T getValue()
    {
        return this.value;
    }
}

class PairTwo<K, V>
{
    K key;
    V value;

    public Pair(K key, V value)
    {
        this.key = key;
        this.value =value;
    }

    public K getKey()
    {
        return this.key;
    }

    public V getValue()
    {
        return this.value;
    }
}

class Main
{
    public static void main(String[] args)
    {
        Pair<String> ps = new Pair<>("clef", "valeur");
        PairTwo<String, Integer> psi = new Pair<>("clef", 10);

        //On peut donc avoir des classes dont on ne connaît pas le type à l'avance
        //Ou alors de faire fonctionner des classes avec plusieurs types
    }
}
```

## Interfaces fonctionnelles et expressions lambda

### Qu'est-ce qu'une interface fonctionnelle ?

- C'est une interface qui comporte __UNE__ méthode non-définie

```java
@FunctionalInterface
interface Function
{
    int apply(String s);
}

class MaCollection
{
    ArrayList<String> tab = new ArrayList<>();

    public MaCollection()
    {
        tab.add("Tom");
        tab.add("Fou de la street");
    }

    public void map(Function function)
    {
        for(String s : this.tab)
        {
            System.out.println(function.apply(s));
        }
    }
}

public class Main
{
    public static void main(String[] args)
    {
        Function f = new Function()
        {
            @Override
            public int apply(String s)
            {
                return s.length;
            }
        }

        Function hasE = new Function()
        {
            @Override
            public int apply(String s)
            {
                return s.Contains("e") ? 1 : 0;
            }
        }

        MaCollection maCollection = new MaCollection();
        maCollection.map(f);
        maCollection.map(hasE);
    }
}
```

- C'est sympathique d'approcher la programmation fonctionnelle. Cependant, la syntaxe est un peu lourde. Les expressions lambda viennent simplifier la syntaxe.

### Les expressions lambda

- En reprenant l'exemple au-dessus :

```java
maCollection.map(s -> s.length());
```

- On sera sur une interface ou classe abstraite et on utilisera __UNE__ méthode non définie.

- Si plusieurs méthodes de notre interface fonctionnelle ne sont pas définies, l'expression lambda ne fonctionnera pas.

### Le tag "@FunctionalInterface"

- Si on met ce tag avant une interface que l'on veut fonctionnelle, si plusieurs méthodes ne sont pas définies, une erreur sera générée à la compilation.

- Cela pallie donc au problème vu au-dessus et il ne faut pas chercher l'erreur pendant 40 ans.

## Les socket

### Principe

- On aura des clients qui se connecteront un serveur qui fournira des données.

### Comment faire fonctionner ça ?

- On devra définir nous-même la manière de communiquer, en quelque sorte, le protocole :

    - __Par exemple__, pour initier une communication, le serveur envoie "Hello", puis un client envoie son message, le serveur répond "OK" puis le client récupère les messages et puis le serveur envoie "END".

- On doit savoir s'il faut écouter et/ou parler sur le réseau. Un client et un serveur ne doivent évidemment pas parler en même temps sinon on se retrouver avec un programme bloqué. 

### Le code ?

- "__ServerSocket__" est une classe qui permet de gérer les serveurs.

    - On aura une méthode accept qui prend un port en paramètre (celui sur lequel on travaille).

    - On aura un "in" et un "out", le in est le flux entrant et le out le flux sortant.

- "__Socket__" est la classe qui nous permet de gérer un client. Il prend également le port sur lequel on travaille en paramètre.

    - - On aura un "in" et un "out", le in est le flux entrant et le out le flux sortant.

- __TOUJOURS OUVRIR L'OUTPUT AVANT L'INPUT__

## Le multi-threading

### L'objet Thread et l'interface Runnable

- On crée un objet Thread qui prend en paramètre dans son constructeur une interface de type "Runnable".

    ```java
    Thread thread = new Thread(new Runnable(){
        @Override
        public void run()
        {
            //TODO
        }
    });
    ```

- Bien évidemment, il est possible de remplacer le tout par une expression lambda

    ```java
    Thread thread = new Thread(() -> {
        //TODO
    });
    ```

### Attendre un Thread

- Afin d'attendre un Thread, on appelle la méthode "join()" sur le thread à attendre

    ```java
    Thread thread = new Thread(() -> { 
        //What the thread does
    });

    try
    {
        thread.join();
    }
	catch (InterruptedException e)
    {
        System.out.println("Erreur d'attente du Thread");
    }

    System.out.println("Après l'attente du Thread");
    ```

### Verrou sur un objet

- Pour pallier aux problèmes d'accès concurrentiels, on doit mettre en place un système de verrou

- On utilisera donc "synchronized" afin de gérer ça

    ```java
    Thread thread = new Thread(() -> {
        synchronized(this)
        {
            for(int i = 0; i < 10000; i++)
            {
                //TODO
            }
        }
    })
    ```

- Cependant, il est possible de faire une méthode synchronisée qui permet de faire ce que l'on veut

    ```java
    synchronized private void MySuperMethod()
    {
        //TODO
    }`

    public static void main(String[] args)
    {
        Thread thr = new Thread(() -> {
            for(int i = 0; i < 100000; i++)
            {
                MySuperMethod();
            }
        });

        for(int i = 0; i < 100000; i++)
        {
            MySuperMethod();
        }

        //On gère facilement les accès concurrentiels
    }
    ```

## La gestion de fichiers

### En texte

- Pour lire : Reader

- Pour écrire : Writer

### En binaire

- Pour lire : InputStream

- Pour écrire : OutputStream

### La classe "File"

- Elle prend en paramètre une String qui montre le chemin du fichier

- Elle permet d'avoir des infos sur le fichier/dossier en cours

- Cela peut être un dossier ou un fichier du système. En clair, c'est un noeud du système

    ```java
    File f = new File("monFichier.txt");
    //Exemple(s) :
    boolean exists = f.exists(); //Est-ce que le fichier existe
    String filePath = file.getAbsolutePath(); //Chemin absolu du fichier
    String filePath2 = file.getCanonicalPath(); //Chemin canonique
    String parent = file.getParent(); //Pour avoir le chemin du fichier parent
    File parentFile = file.getParentFile(); //Pour avoir le fichier parent
    String name = file.getName(); //Nom du fichier
    boolean hidden = file.isHidden(); //Fichier caché ?
    boolean isDir = file.isDirectory(); //Est-ce que le fichier est un dossier ?
    //Si c'est un dossier :
    File[] files = file.listFiles();
    ```

### BufferedInputStream

- On utilisera cette classe associée à d'autres afin de lire dans un fichier

    ```java
    is = socket.getInputStream();
    ois = new ObjectInputStream(is);
    bois = new BufferedInputStream(ois);
    ```

- C'est un peu un système de couche, chaque classe s'occupe de quelque chose et va déléguer la tâche à la suivante

- La syntaxe est, certes, lourde mais elle nous permet de faire ce que l'on veut

    ```java
    File file = new File("monFichier.txt");

    FileInputStream fis = new FileInputStream(file); //Lecture binaire, en Bytes
    byte b = (byte)fis.read();
    
    while(b != -1)
    {
        System.out.println(b);
        b = (byte)fis.read();
    }
    //Résultat illisible pour l'humain, il faut donc ajouter une couche de traitement en ajoutant d'autres classes comme vu au-dessus
    //Cependant, pour faire du réseau, cela peut-être pratique pour éviter de consommer de la BP
    ```

    ```java
    File file = new File("monFichier.txt");

    FileInputStream fis = new FileInputStream(file); //Lecture binaire, en Bytes
    byte b = (byte)fis.read();

    while(b != -1)
    {
        System.out.println((char)b);
        b = (byte)fis.read();
    }
    //Maintenant que c'est casté en char, le numéro du caractère est transformé en caractère et c'est donc lisible
    ```

- C'est donc faisable de cette manière, cependant, c'est pas super niveau optimisation et on ne supporte pas les caractères spéciaux

- Pour pallier à ça, on utilisera un BufferedInputStream

    ```java
    BufferedInputStream bfis = new BufferedInputStream(fis); //fis vient des exemples juste au-dessus
    bfis.read(); //Bien plus optimisé
    ```

### FileOutputStream

- Cette classe permet d'écrire dans un fichier

    ```java
    FileOutputStream fos = new FileOutputStream("test.txt");

    for(int i = 0; i < 1000000; i++)
    {
        fos.write('a');
    }

    fos.close(); // /!\
    ```

### La bufferisation

- Nous avons testé d'utiliser un BufferedOutputStream et comparer son temps avec FileOutputStream

- Nous voyons l'avantage de la bufferisation :
    
    - 6900 ms pour 1 000 000 de fois 'a' avec FileOutputStream

    - 47 ms pour 1 000 000 de fois 'a' avec BufferedOutputStream

- On peut utiliser la méthode "flush()" pour vider le buffer

### Le close

- Il faut toujours fermer un flux avec la méthode "close()"

### Le try with resources

- Nous connaissons maintenant le try/catch

- Cependant, il est possible de faire un try with resources (équivalent du "using(var x = new X()) { } en C#.NET)

- En fait, on ferme tout à la fin

    ```java
    try (
        FileOutputStream fos = new FileOutputStream("superfichier.txt"),
        BufferedOutputStream bfos = new BufferedOutputStream(fos);
    )
    {
        //On fait tout ici
    }
    catch (Exception e)
    {
        e.printStackTrace();
    }
    //Tout sera fermé à la fin, très bonne pratique
    ```

- __LE TRY WITH RESOURCES EXISTE SANS CATCH__

(Par facilité on ne fera pas ça dans la suite du cours mais c'est une excellente pratique)

### Le DataOutputStream / DataInputStream

- C'est encore une nouvelle couche. Il génère les bytes qu'il faut et on ne doit plus caster

    ```java
    DataOutputStream dbfos = new DataOutputStream(bfos); //bfos vient d'au-dessus

    dbfos.writeBoolean(false);
    dbfos.writeLong(1254L);
    dbfos.writeChars("TEST"); //On peut écrire n'importe quel type

    dbfos.close();
    ```

    ```java
    DataInputStream dis = new DataInputStream(
        new BufferedInputStream(
            new FileInputStream("test.md")));

    dis.readBoolean();
    dis.readChar();
    dis.readLonfg();
    //Les autres types sont disponibles
    ```

- Pour les chaînes de caractère, ça n'est pas idéal

### Lecture de fichiers texte

- On utilisera les classes "FileReader" et "FileWriter"

    ```java
    FileReader fr = new FileReader("fichier.txt");
    BufferedReader bfr = new BufferedReader(fr);

    String s = bfr.readLine();
    while(s != null)
    {
        System.out.println(s);
        s = bfr.readLine();
    }

    // bfr.lines() renvoie un FLUX de String, on peut donc compacter
    bfr.lines().forEach(s -> System.out.println(s));
    ```
    
## Le modèle MVVM (Model-View-View-Model) en bref

- En JavaFX, nous avons vu les propriétés.

- Il est possible d'en créer nous même

- Dans une propriété on a le modèle, on bind avec ce que l'on a besoin dans la vue de manière bidirectionnelle si nécéssaire.
Ensuite, la vue sera à même d'update le modèle (model -> view, view -> model).

## La JavaDoc

- Equivalent du "summary" en C#.NET

- On peut décrire le fonctionnement de notre méthode et décrire quel argument fait quoi

    ```java
    /**
    * This is a test method
    * @param test A super test argument
    * @return returns 5 !
    */
    public void MaMethodeDeFou(int test)
    {
        return 5;
    }
    ```

## Le déploiement

- Le client installe Java Runtime Environment (JRE) et le .JAR (java archive, on y retrouve tous les .class) compilé fonctionne

### Déployer depuis IntelliJ

- Dans project structure, on retrouve les artifacts

- On crée un artifact en choisissant les modules dont on a besoin

- Dans "Build", on peut cliquer sur "build artifacts" et choisir l'artifact voulu.

- Il est également possible de faire du pré-processing ou du after-processing.