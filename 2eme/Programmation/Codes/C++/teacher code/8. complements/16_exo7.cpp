#include <iostream>
#include <stdio.h>
using namespace std;

int main(int argc, char const *argv[]) {
  int t[3];
  int i,j;
  int * adt;
  for (i=0, j=0; i < 3; i++) t[i] =  j++ + i;

  for (i=0; i< 3; i++) cout << t[i] << " ";
  cout << "\n";

  for (i=0; i< 3; i++) cout << *(t + i) << " ";
  printf("\n");

  for (adt = t; adt < t + 3; adt ++) cout << *adt << " ";
  cout << "\n";

  for (adt = t + 2; adt >= t; adt --) cout << adt << " : " << *adt << " ";
  cout << "\n";


  return 0;
}