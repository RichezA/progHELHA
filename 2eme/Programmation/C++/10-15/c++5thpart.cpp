#include <iostream>
using namespace std;

inline int min(int a, int b){
    return ((a < b) ? a : b);
}
int m = min(i, j); // remplacé par m = ((i < j) ? i : j); à la compilation
