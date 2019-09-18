
## Ressources

Afin d'avoir une globalisation sur son application, il est préférable de réunir les constantes comme, par exemple: "Bonjour", dans le dossier values.

## Manifest

Dossier où le se trouve les différents manifest de l'application. 

```xml
<application
    android:label="@string/app_name"

>
</application>
```

On peut aussi trouver des : `android:xxx="@+xxx/xxx"`
Le caractère '@' permet de faire une référence à un fichier, allié au '+' veut dire qu'il doit être créé.

## Widget

Comme en JavaFX, nous ne pouvons pas accéder à des variables à l'intérieur d'un autre contexte, il est donc possible de séparer la définition et l'instanciation du widget en bougeant la définition en dehors de notre méthode `onCreate()`.

## Créer une nouvelle activité

Afin de créer une nouvelle activité, on a besoin d'une vue (celle sur laquelle on souhaite passer)

```java
public void openAnotherView(View view){
    Intent intent = new Intent(this, view.class);
    openNewActivity(intent);
    // this.finish();
}
```
On peut rajouter la méthode `finish()` afin de fermer l'instance de la vue au moment T.

L'argument `view` correspond au widget sur lequel on a appelé la méthode.

## Bundle

Quand on effectue une rotation sur notre application mobile, en réalité, l'application est tuée et relancée, on peut sauvegarder l'état avec le paramètre `savedInstanceState` de notre méthode `onCreate()` dans notre activité.