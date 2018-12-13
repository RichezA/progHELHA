#include <iostream>
using namespace std;

class Adresse {
  int numero = 5;
  public: 
    Adresse(int numero) { this->numero = numero;}
};
class Personne {
  
  int age = 0;
  Adresse *maJolieAdresse = nullptr;

  public:
    Personne(int age = 10) {
      this->age = age;
      maJolieAdresse = new Adresse(10);
    }

    Personne(Personne & p) {
      this->age = p.age * 2;
      this->maJolieAdresse = new Adresse(*p.maJolieAdresse);
    }

    ~Personne(){
      cout << "Supprimée" << endl; 
      if (maJolieAdresse != nullptr) {
        delete maJolieAdresse;
        maJolieAdresse = nullptr;
      }
    }

    int getAge() {
      return this->age;
    }

    void setAge(int newAge) {
      this->age = newAge;
      newAge = 5;
    }

    int calculDiff(Personne p) {
      return p.age - this->age;
    }

};

int main(int argc, char const *argv[]) {
  Personne p1(10);
  Personne ps[3] = {{0}, {10}, {20}};
  // Personne p1 = 10;
  Personne p2(p1);
  // Personne p2 = p1;

  cout << p2.getAge() << endl;
  // cout << p1.calculDiff(p1) << endl;
  cout << p2.calculDiff(p1) << endl;

  Personne *p = new Personne(10);
  cout << (*p).calculDiff(p2) << endl;
  cout << p->calculDiff(p2) << endl;
  delete p;
  p = nullptr;


  return 0;
}