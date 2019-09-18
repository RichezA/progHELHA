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

