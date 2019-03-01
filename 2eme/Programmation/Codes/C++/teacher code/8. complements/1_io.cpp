#include <iostream>
using namespace std;

int main(int argc, char const *argv[])
{
  int i = 0;
  do {
    cout << "Entrez un nombre entre 1 et 10 : ";
    cin >> i;
    if (cin.fail()) {
      i = 0;
      cin.clear(); cin.ignore(INT_MAX,'\n'); 
    }
  } while(i <= 0 || i > 10);
  cout << "Le nombre entré : " << i << endl;
  return 0;
}
