# Groupe09

## Réalisation du jeu "6 qui prend!" en C++

### Examen
    - L'étape 1 est finie, l'ordinateur avancée arrive à calculer la carte la plus grande dans sa main et le nombre de têtes d'une rangée
    - L'étape 2 n'est pas finie, les méthodes sont prêtes et sont présentes dans le code (seul l'implémentation est commentée ref. jeu.cpp:152-155),
    les fonctions ne font pas crasher le programme mais ne fonctionne pas tout le temps
    - L'étape 3 est finie, toutes les cartes sont envoyées dans la base de données
    - L'étape 4 est finie, nous pouvons voir la carte la plus jouée par chaque joueur pour toutes les parties confondues (le temps que la db n'est pas supprimée, les scores sont sauvegardés).

Afin de compiler le jeu, merci d'executer:
```
cd src/
g++ Carte.cpp Jeu.cpp Joueur.cpp joueurHumain.cpp main.cpp Paquet.cpp Rangee.cpp Database.cpp JoueurOrdiAvance.cpp -o Jeu.exe -L . -lsqlite3 --std=c++11
./Jeu.exe
```

Afin de compiler le panneau des scores, merci d'executer:
```
cd src/
g++ score2000.cpp -o Score.exe -L . -lsqlite3 --std=c++11
./Score.exe
```