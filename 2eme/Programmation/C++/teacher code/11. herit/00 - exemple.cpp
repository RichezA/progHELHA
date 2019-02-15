#include <iostream>
using namespace std;

class Personne {
  protected:
    string nom;
  public:
    Personne() {
      nom = "Test";
    }
    Personne(string nom) : nom(nom) {}
    string getNom() {
      return nom;
    }
    virtual string toString () {
      return nom;
    }
};

class Utilisateur : public Personne {
  protected:
    string login;
  public:
    Utilisateur(string nom, string login) : login(login) {
      this->nom = nom;
    }
    string getLogin() {
      return login;
    }
    string toString () {
      return getNom() + " (" + login + ")";
    }
};

class SuperUtilisateur : public Utilisateur {
    public:
    SuperUtilisateur(string nom, string login) : Utilisateur(nom, login) {
    }
    string toString () {
      return "Super !" + Utilisateur::toString();
    }
};

int main(int argc, char const *argv[]) {
  Personne p("Personne 1");
  Utilisateur u("Utilisateur 1", "login");
  SuperUtilisateur su("Utilisateur 2", "login");
  Personne *pt = (Personne*)&su;
  cout << pt->toString() << endl;
  su.getLogin();

  return 0;
}