# Cours sur JavaFX

## Sommaire

## JavaFX, c'est quoi ?

- JavaFX permet de créer des applications graphiques en Java.

## Introduction

- On peut créer facilement un projet JavaFX avec IntelliJ puisqu'une option JavaFX est directement disponible.

- Il existe deux manières de faire des interfaces graphiques en JavaFX :

    - En le faisant à la main (nous allons faire ceci afin de découvrir JavaFX)

    - En utilisant du XML, qui est bien plus rapide que la méthode précédente

## La classe Main, la classe Application, les stages et les Scenes

- La classe Main dérive de "Application"

### La différence entre application, stage, scène et noeud

- L'application contient toutes les fenêtres

- Le stage est une "sous-fenêtre"

- Enfin, la scène est le contenu d'une "sous-fenêtre"

- On mettra donc nos élements (boutons, etc...) dans... la scène

    - Chaque élément est en fait un noeud ("Node"). Voici la hiérarchie des noeuds en JavaFX :

    ![Hierarchie Noeuds JavaFX](https://amyfowlersblog.files.wordpress.com/2011/06/javafx2-0layoutclasses.png)

    - Un noeud à la racine de la fenêtre sera redimensionné en même temps que la fenêtre, mais pas ses enfants

### La méthode launch

- La classe Application contient une méthode "launch()" qui crée un Thread pour gérer le côté graphique

### La méthode start

- La classe Application contient également une méthode "start()" que l'on redéfinira.

## Les boutons

### Création d'un bouton

- Voici comment créer un bouton :

    ```java
    Button b = new Button("Test");
    ```

### Paramétrer une action

- Pour paramétrer une action au bouton, il faut lui donner un EventHandler

- Dans la classe anonyme, il faut redéfinir la méthode "handle" qui prend un "ActionEvent" en paramètre

- Exemple :

    ```java
    b.setOnAction(new EventHandler<ActionEvent>()
    {
        @Override
        public void handle(ActionEvent e)
        {
            System.out.println("Hello");
        }
    });
    ```

- Il est possible de faire une expression lambda :

    ```java
    button.setOnAction(event -> System.out.println("Hello"));
    ```

- Voici la documentation où on peut trouver les méthodes associées aux boutons : [Doc Buttons JavaFX](https://docs.oracle.com/javafx/2/api/javafx/scene/control/Button.html)

## Les AnchorPane

### A quoi ça sert ?

- Un AnchorPane est un panneau qui permet de contenir d'autres noeuds.

- C'est un noeud qui parle en coordonnées x et y

### Exemple et utilisation de l'AnchorPane

- Imaginons que je veuille ajouter deux boutons à un AnchorPane

    ```java
    AnchorPane ap = new AnchorPane();
    Button b = new Button("Test");
    Button b2 = new Button("Test 2");
    //Je veux ajouter un bouton à l'AnchorPane
    ap.getChildren().add(b);
    ap.getChildren().add(b2);
    //Les boutons sont superposés !
    ```

- Pour placer les élements dans un AnchorPane, il faut préciser les coordonnées :

    ```java
    b2.setLayoutX(20.0);
    b2.setLayoutY(10.0);
    //On positionne les boutons en coordonnées relatives au parent. Ici, l'AnchorPane.
    ```

- On peut très bien imaginer une boucle "for" pour faire un tableau/une grille de boutons

    ```java
    Button button;

    for(int i = 0; i < 10; i++)
    {
        for(int j = 0; j < 10; j++)
        {
            button = new Button(Integer.toString(i * 10 + j));
            pane.getChildren().add(b);
            button.setPrefWidth(40);
            button.setPrefHeight(40);
            button.setLayoutX(i * 40);
            button.setLayoutY(j * 40);

            button.setOnMouseClicked(e -> {
                Button b = (Button)e.getSource();
                //On ne devrait pas faire ça si le bouton était instancié dans la même portée que la méthode anonyme
                b.setText(Integer.toString(e.getClickCount()));
            });
        }
    }
    ```

## Les formes

### Création et utilisation d'un cercle

- Exemple :

    ```java
    new Circle(200, 200, 200, Color.GREEN);
    //CentreCoordonnéeX, CentreCoordonnéeY, Rayon, Couleur
    ```

- Un cercle est un noeud comme un autre (ce n'est pas juste une simple forme) et il a également des évènements etc...

### Création et utilisation d'un rectangle

- Exemple :

    ```java
    //Oups j'ai pô noté leaule
    ```

## XML et FXML

### XML

- Il est possible, comme dit plus haut, de faire son interface graphique à partir du XML au lieu de soi-même tout faire en code Java.

- XML est un langage de balisage (comme HTML, XAML, ...)

- On peut donc écrire notre XML nous-même et le loader dans notre projet et le tour est joué.

### FXML

- Il est également possible de passer par FXML afin de "drag and drop" nos éléments et les placer comme on le souhaite.

- FXML enregistre en fait le tout en XML, et ensuite, on peut le loader dans notre projet !

- On peut donc faire du drag and drop sans devoir passer par du XML ni faire nos fenêtres en code.

### Loader XML dans notre projet

- Il existe une classe en JavaFX qui se nomme "FXMLLoader" qui est statique.

- On peut donc appeler la méthode Load de cette classe qui prend une URL en paramètre et qui renvoie un parent.

    - Un parent est renvoyé car il renvoie l'élément en haut de la hiérarchie de notre fenêtre.

- On crée donc une scène où on insèrera notre parent

- Exemple :

    ```java
    AnchorPane a = FXMLLoader.load(getClass().getResource("monfichier.fxml"));
    Scene scene = new Scene(a);
    ```

## AnchorPanes

### Système d'ancrage

- On peut ancrer des noeuds dans notre anchorpane et donc lui donner des contraintes lors du redimensionnement de la fenêtre

### Système de coordonnées

- On peut placer les noeuds selon des coordonnées relatives à notre anchorpane.

## Flowpanes

### Système de flux

- On lui donne des noeuds enfants, et le flowpane va essayer de gérer de manière à mettre les éléments les uns à la suite des autres.

- S'il n'y a plus de place, on ira à la ligne et les noeuds n'empièteront pas les uns sur les autres.

## GridPane

### Système de grille

- Fonctionne un peu comme boostrap, tout fonctionne sous forme de grille.

## HBOX et VBOX

### HBOX

- Système de colonnes seulement

### VBOX

- Système de lignes seulement.

## ScrollPane

### Ajout de scrollbars

- Permet d'ajouter des scrollbars à notre fenêtre

## Accordéon (Accordion)

### Système de "dropdown"

- On a un élément "déployable" et "refermable".

- On peut lui mettre n'importe quoi dedans.

## SplitPanes

### Séparation en "sous-fenêtres"

- On peut séparer avec un curseur deux parties de notre fenêtre.

- Il en existe des verticales ainsi que des horizontales

## ColorPicker

### Choix de couleur

- Permet de faire un choix de couleur simplement.

## TabPanes

### Différents onglets

- Permet de contenir des éléments de type "Tab".

### Tabs

- Une fois sélectionné, son contenu sera 

## BorderPanes

### Idée du borderpane

- On va diviser notre espace en différents "points cardinaux" que l'on appelera "nord", "sud", "est", "ouest" et "centre" ou alors "haut", "bas", "gauche", "droite" et "centre".

    ![Image borderpane](https://docs.oracle.com/javafx/2/api/javafx/scene/layout/doc-files/borderpane.png)

    ![Image borderpane2](https://o7planning.org/de/10629/cache/images/i/2767553.png)

- On peut donc faire des UI assez développées facilement.