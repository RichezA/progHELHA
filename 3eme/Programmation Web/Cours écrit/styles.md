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
