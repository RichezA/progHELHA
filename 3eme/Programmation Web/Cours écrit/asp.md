Quant on enverra une requête à notre application web, on la divisera comme il est décrit dans le fichier "App_start/RouteConfig.cs"
<img src="./resources/HomeActionID.png">

Par défaut la vue retournée est du même nom que la méthode qui l'appelle.

- Quand on crée un contrôleur, un dossier portant le nom _primaire_ (<b><i>Home</i></b>Controller) du contrôleur est ajouté dans le dossier _Views_.

## Ajout de CSS

- Quand on ajoute une feuille de style, pour optimiser la lisibilité du projet, on va ajouter un dossier nommé _"Stylesheet"_ et ajouter dedans nos feuilles de style.

## Accès à la vue
L'utilisateur n'accède pas à la page mais à une URL qui pointe vers une ressource qui correspond à un contrôleur et une action.

```cs
 routes.MapRoute(
                name: "Default",
                url: "{controller}/{action}/{id}",
                defaults: new { controller = "Home", action = "Index", id = UrlParameter.Optional }
            );
```

On peut retrouver ce code dans le dossier App_Start à l'intérieur du fichier `RouteConfig.cs`

## Les formulaires

```cs
public class Livre
{
    [HiddenInput]
    public int ID { get; set; }

    [Display (Name = "Titre")]
    [Required (ErrorMessage = "Le {0} est requis")]
    [StringLength(100)]
    public String Titre { get; set; }

    [Display (Name = "Editeur")]
    [StringLength(100)]
    public String Editeur { get; set; }

    [Display (Name = "Genre")]
    [StringLength(100)]
    public String Genre { get; set;}
}