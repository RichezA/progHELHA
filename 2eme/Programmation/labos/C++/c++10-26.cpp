#include<iostream>
#include<cmath>
using namespace std;

/*int main(int argc, char const *argv[]){
   
    char c = '\x01';
    short int p = 10;

    cout << p + 3 << endl << c + 1 << endl << p + c << endl;

    return 0;
}*/

/*int main(int argc, char const *argv[]){
   
    char c = '\x05';
    int n = 5;
    long p = 1000;
    float x = 1.25;
    double z = 5.5;

    cout << n + c + p << endl << 2 * x + c << endl << (char) n + c << endl 
    << (float) z + n / 2 << endl;


    return 0;
}*/

int main(int argc, char const *argv[]){
   
   int n = 0;
   do
   {
       cout << "Donnez un nombre positif: ";
       cin >> n;
       if(n == 0) break;
       if(n < 0 ) {
           cout << "Svp positif" << endl;
           continue;
       }
       cout << "Sa racine carrée est: " << sqrt(n) << endl;

   }while(1);
    

    return 0;
}