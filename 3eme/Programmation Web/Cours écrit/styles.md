## Déclaration de style:

On peut déclarer un style en argument d'une balise ("inline"):
```html
<balise style="color:red">Contenu</balise>
```


Ou alors créer une balise style dans notre zone `head`:
```html
<html>
  <head>
    <style>
    <!-- Un sélecteur de balise -->
      h1 {
        color: blue;
      }
    <!-- Une classe -->
      .NomDeClasse {
        text-align: center;
      }
    <!-- Un identifiant unique -->
      #NomD-ID {
        font-size: 8px;
      }
    </style>
  </head>
</html>
```

Ou alors directement créer un fichier css à part (on l'import via la commande:
```html
    <link rel="stylesheet" href="styles.css">
```
)
On utilise à ce moment-là la même syntaxe qu'on aurait pu utiliser dans la balise `<style>`


## Cache

La feuille de style est enregistré en cache. Soit on fixe une période de validité.

Ce qu'on peut faire c'est avoir 
`stylesheet.css?v1` et si un jour on change l'url par `stylesheet.css?v2` (vu qu'on a modifié la stylesheet), la version 1 du css sera invalidée.

## Quelques attributs

_border-radius_ : 

_text-shadow_ : Ombrage pour un texte
_box-shadow_ _-moz-box-shadow_ _-webkit-box-shadow_ : Ombrage pour une div
_font-family_ : Pour changer la police
```css
@font-face {
  font-family:"MaPolice";
  src:url('rage.ttf');
}

.MaPolice {
  font-family: MaPolice;
}
```

_opacity_ : Opacité (besoin d'une couleur de fond pour pouvoir appliquer l'attribut)