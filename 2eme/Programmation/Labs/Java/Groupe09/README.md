# Projet de laboratoire de programmation Q2 2019

## Déroulement du projet

### Planning

- [x] 29/03/19 - Réalisation des modèles + Tests unitaires des modèles + Début de la réalisation des interfaces.
- [x] 05/04/19 - Amélioration des interfaces + définition et implémentation des interactions entre les vues + Lecture fichiers.
- [x] Vacances de Pâques - Finalisation de l'interface principal sans réseau.
- [x] 26/04/19 - Dernières retouches sur l'interface principale, début de l'implémentation du réseau + début des tests unitaires.
- [x] 03/05/19 - Fin des tests unitaires, début de la documentation Javadoc + début de la réalisation de l'interface client + implémentation de la relation client-serveur entre les différents programmes.
- [x] 10/05/19 - Documentation de l'interface principale et du module commun + relation clients-serveur en cours
- [x] 17/05/19 - Fin du projet en soi, vérification des derniers détails et de la documentation

### Avancement du projet

- Articles et catégories chargé à partir de fichiers + Possibilité d'ajouter ou non une images personalisé par article.
- Ajout d'articles dans les catégories.
- Articles au poids ou à la pièce. Impossible d'entrer un poid si l'article est à la pièce.

### Mode d'emploi

Peut être à respecter l'ordre de lancement suivant: Traiteur -> Client, Terminal.
Ne sait on jamais.

Au premier lancement, l'application crée un dossier "Groupe-09-Traiteur" dans le home de l'utilisateur avec un exemple de catégorie.

Afin de créer une nouvelle catégorie, créez un fichier dans ce dossier, et y insérez les éléments suivants:

- La première ligne du document est réservée au nom de la catégorie.
- Nom du produit.
- Son prix.
- Son type (KILO/PIECE).
- Possibilité d'ajouter le chemin d'une image puis le délimiteur (&@#) sinon uniquement mettre le délimiteur (&@#).
- Un nouvel article, si nécessaire.
- Ne pas oublier le délimiteur entre chaque article (&@#).