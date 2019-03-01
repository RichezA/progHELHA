#include <iostream>
using namespace std;

class Piece {
  protected:
    int x,y;
  public:
    Piece(int x, int y) : x(x), y(y) {}
    virtual bool peutSeDeplacer(int nx, int ny) {
      if (nx < 0 || ny < 0 || nx >= 8 || ny >= 8) {
        return false;
      }
      if (nx == x && ny == y) {
        return false;
      }
      return true;
    }
    virtual bool deplacer(int nx, int ny) {
      if (this->peutSeDeplacer(nx, ny)) {
        x = nx;
        y = ny;
        return true;
      }
      return false;
    }
    virtual string getNom() = 0;
    virtual ~Piece() {}
    int getX() {
      return x;
    }
    int getY() {
      return y;
    }
};

class Pion : public Piece {
  bool premierCoup = true;
  public:
    Pion(int x, int y) : Piece(x,y) {}
    bool peutSeDeplacer(int nx, int ny) {
      if (!Piece::peutSeDeplacer(nx, ny)) {
        return false;
      }
      if (x - nx != 0) {
        return false;
      }
      if (premierCoup && y - ny == 2) {
        return true;
      }
      if (y - ny == 1) {
        return true;
      }
      return false;
    }

    bool deplacer(int nx, int ny) {
      if (Piece::deplacer(nx, ny)) {
        premierCoup = false;
        return true;
      }
      return false;
    }
    string getNom() {
      return "Pion";
    }
};

class Tour : public Piece {
  public:
    Tour(int x, int y) : Piece(x,y) {}
    bool peutSeDeplacer(int nx, int ny) {
      if (!Piece::peutSeDeplacer(nx, ny)) {
        return false;
      }
      if (x - nx != 0 && y - ny != 0) {
        return false;
      }
      return true;
    }

    string getNom() {
      return "Tour";
    }
};

class Fou : public Piece {
  public:
    Fou(int x, int y) : Piece(x,y) {}
    string getNom() { 
      return "Fou";
    }
    bool peutSeDeplacer (int nx, int ny) {
      if(!Piece::peutSeDeplacer(nx, ny)) {
        return false;
      }
      return abs(x - nx) == abs(y - ny);
    }
};

class Cavalier : public Piece {
  public:
    Cavalier(int x, int y) : Piece(x,y) {}
    string getNom() { 
      return "Cavalier";
    }
    bool peutSeDeplacer (int nx, int ny) {
      if(!Piece::peutSeDeplacer(nx, ny)) {
        return false;
      }
      return abs(x - nx) * abs(y - ny) == 2;
    }
};

// live : devrait être dans une classe Plateau
void afficheDeplacement(Piece& p, int nx, int ny) {
  cout << "Essaie de bouger la pièce " << p.getNom();
  cout << " de (" << p.getX() << "," << p.getY() << ") ";
  cout << " de (" << nx << "," << ny << ") : ";
  bool deplacementEffectue = p.deplacer(nx, ny);
  if (deplacementEffectue) {
    cout << "OK";
  } else {
    cout << "Impossible";
  }
  cout << endl;
}
// live : idem
void affichePlateau(Piece *pieces[]) {
  cout << "  ";
  for(int colonne = 0; colonne < 8; colonne++)
  {
    cout << colonne << " ";
  }
  cout << endl;
  for(int ligne = 0; ligne < 8; ligne++)
  {
    cout << ligne << " ";
    for(int colonne = 0; colonne < 8; colonne++)
    {
      bool showPiece = false;
      for(int i = 0; i < 4; i++) {
        if(pieces[i]->getX() == colonne && pieces[i]->getY() == ligne) {
          cout << pieces[i]->getNom()[0];
          showPiece = true;
        }
      }
      if (!showPiece) {
        cout << "_";
      }
      cout << " ";
    }
    cout << endl;    
  }
}

int main(int argc, char const *argv[]) {
  Pion pion(1,6);
  Tour tour(7,7);
  Fou fou(5, 7);
  Cavalier cavalier(1, 7);
  Piece* pieces[5];
  pieces[0] = &pion;
  pieces[1] = &tour;
  pieces[2] = &fou;
  pieces[3] = &cavalier;

  affichePlateau(pieces);
  afficheDeplacement(pion, 1, 4);
  affichePlateau(pieces);
  afficheDeplacement(pion, 1, 2);
  affichePlateau(pieces);
  afficheDeplacement(pion, 1, 3);
  affichePlateau(pieces);
  afficheDeplacement(tour, 0, 3);
  affichePlateau(pieces);
  afficheDeplacement(tour, 7, 0);
  affichePlateau(pieces);
  afficheDeplacement(tour, 6, 1);
  affichePlateau(pieces);
  afficheDeplacement(tour, 0, 0);
  affichePlateau(pieces);
  afficheDeplacement(fou, 7, 5);
  affichePlateau(pieces);
  afficheDeplacement(fou, 6, 5);
  affichePlateau(pieces);
  afficheDeplacement(cavalier, 4, 6);
  affichePlateau(pieces);
  afficheDeplacement(cavalier, 3, 6);
  affichePlateau(pieces);
  
  return 0;
}