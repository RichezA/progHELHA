## Balise seule:

<balise> ou <balise />

## Conteneurs:

<balise>
  Contenu
</balise>

## Attributs

<balise attribut="valeur">

## Règles

* Les noms de balises de préférence en minuscule
* Toujours fermer les conteneurs par une balise de fermeture

## Block ou Inline

 - Block: Occupe la largeur du conteneur parent et comprend un saut de ligne avant et après.
 - Inline: Taille s'adapte au contenu.

```html
<div class="bloc-vs-inline">
  Ceci est un exemple de <span>bloc</span> simple.
  Ceci est un autre exemple de <div>bloc</div> simple.
</div>
```

 Les retours à la ligne, les caractères blancs multiples sont remplacés par un simple caractère blanc.

 ## Balises de mise en forme.

On essaie de les éviter car on peut faire cela en CSS

 - `<b></b>` pour le gras
 - `<i></i>` pour l'italique
 - `<del></del>` pour barrer le texte
 - `<sub></sub>` pour mettre le texte en bas.

- `&lt` pour le caractère `<`
- `&gt` pour le caractère `>`
- `&quot` pour le caractère `"`
- `&amp` pour le caractère `&`
- `&nbsp` pour un espace blanc
- `&euro` pour le symbole `€`

## Taille et position

- Position absolue / zindex:

Pouvoir placer un élément où l'on veut, c'est aussi devoir gérer les superpositions avec la propriété z-index.

Si l'on a une page où on a une superposition, on modifie la valeur z-index où un div (fenêtre flottante) a une propriété z-index plus forte que la page web, lorsque l'on va la fermer, on va, en fait, attribuer une valeur de z-index plus faible que celle de notre page principale.

- Position fixe

Identique à la position excepté que l'élément se positionne par rapport à la fenêtre du navigateur et pas par rapport au conteneur.

- Rognage, débordement, barres de défilement

```css
#limite {
  width: 150px;
  height: 80px;
  ...
}
```

Si l'on met l'attribut `overflow` à `hidden` => tout ce qui dépasse du div sera supprimé.

Si l'on met l'attribut à `scroll` => on met des barres de défilement.

L'attribut width est associé au contenu, pas au padding, ni au border, ni au margin.

# Taille et position type block

La position dépend du fait d'avoir un bloc inline ou en bloc.
Il est possible de pouvoir changer ce positionnement par défaut au moyen des CSS. On ne peut pas modifier la largeur d'un type `inline` car le but d'un type `inline` est de prendre le moins de place possible.

```html
<div class="content">
  <div class="child">Un</div>
  <div class="child">Deux</div>
  <div class="child">Trois</div>
  <div class="child">Quatre</div>
</div>
```

```css
  .child {
    // Dis que la classe `child` se comporte comme un type `inline`
    border: 1px solid black;
    display: inline;
  }
  .childBlock {
    border: 1px solid black;
    width: 200px;
  }
  .childInlineBlock {
    border: 1px solid black;
    display: inline-block;
    width: 80px;
  }
```

De cette façon, si l'on met un type block avec la classe `child`, il se comportera comme un type inline.

Pour modifier la largeur d'un type inline, on peut régler l'attribut `display` à `inline-block`, de cette façon, on garde la mise en page d'un type inline. 

- Positionnement de type float

L'attribut float permet d'enlever les enfants du flux et de les placer sur la gauche ou la droite du conteneur parent.

Le bloc div ne s'adapte pas en hauteur au contenu et les blocs enfants sont collés sans l'espace que l'on retrouve par défaut dans l'exemple précédent.


- Positionnement position absolute

```css
.myClass {
  position: absolute;
  right: 0px;
  top: 20px;
}
```

## Les formulaires

`<form></form>`

Les attributs du formulaire:
- name: précise le nom donné au formulaire
- action: précise à qui doit être transmis le formulaire
  - action="http://www.test.tld/gestion.aspx/"
  - action="mailto:test@test.tld"

action = le script qui sera exécuté