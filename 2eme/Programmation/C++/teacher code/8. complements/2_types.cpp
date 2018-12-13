#include <iostream>
using namespace std;

int main(int argc, char const *argv[])
{
  cout << "Taille d'un char : " << sizeof(char) << endl;
  cout << "Taille d'un int : " << sizeof(int) << endl;
  cout << "Taille d'un short int : " << sizeof(short int) << endl;
  cout << "Taille d'un long int : " << sizeof(long int) << endl;
  cout << "Taille d'un long long int : " << sizeof(long long int) << endl;
  cout << "Taille d'un float : " << sizeof(float) << endl;
  cout << "Taille d'un double : " << sizeof(double) << endl;

  int i = 2147483650;
  cout << "i:" << i << endl;
  int xi = 0xF;
  cout << "xi:" << xi << endl;
  int oi = 0112; // attention : octal !
  cout << "oi:" << oi << endl;
  int bi = 0b011001;
  cout << "bi:" << bi << endl;
  long li = 2147483647L;
  cout << "li:" << li << endl;
  cout << "li + 1:" << li + 1 << endl;
  long bad_li = 2147483647 + 7;
  cout << "bad_li:" << bad_li << endl;
  int grand = 2147483647;
  int petit = 1;
  long very_bad_li = grand + petit;
  cout << "very_bad_li:" << very_bad_li << endl;  
  return 0;
}
