#include <iostream>
using namespace std;

int main(int argc, char const *argv[]) {

  // formalisme tableau
  // int tab[10] = {1,2,3,12,1,2,5,6,9,10};
  // for (int i = 0; i < 10; i++) {
  //   cout << "Entrez le " << i + 1 << "e nombre : ";
  //   cin >> tab[i];
  //   while(cin.fail()) {
  //     cin.clear();
  //     cin.ignore(1000000, '\n');
  //     cout << "Ré-entrez le " << i + 1 << "e nombre : ";
  //     cin >> tab[i];
  //   }
  // }

  // int min = tab[0];
  // int max = tab[0];
  // for(int i = 1; i < 10; i++) {
  //   if (min > tab[i]) min = tab[i];
  //   if (max < tab[i]) max = tab[i];
  // }

  // cout << "Min : " << min << " - Max : " << max << endl;


  // formalisme pointeur
  {
    int tab[10] = {1,2,3,12,1,2,5,6,9,10};
    int * adr = tab;
    for (;adr < tab + 10; adr++) {
      cout << "Entrez le nombre suivant : ";
      cin >> *adr;
    }

    // int min = *tab;
    // int max = *tab;
    // for(int i = 1; i < 10; i++) {
    //   if (min > *(tab + i)) min = *(tab + i);
    //   if (max < *(tab + i)) max = *(tab + i);
    // }
    // cout << "Min : " << min << " - Max : " << max << endl;
    int *adrMin = tab;
    int *adrMax = tab;
    for(int *adrI = tab+1; adrI < tab + 10; adrI++) {
      if (*adrMin > *adrI) adrMin = adrI;
      if (*adrMax < *adrI) adrMax = adrI;
    }

    cout << "Min : " << *adrMin << " - Max : " << *adrMax << endl;
  }


  return 0;
}