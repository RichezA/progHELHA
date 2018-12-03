#include <stdio.h>
#include <stdlib.h>
#include <iostream>

using namespace std;
const bool STOP = true;

void afficheMessage(const char *msg="Avertissement", bool stop = false);

int main(){
  afficheMessage("erreur fatale",STOP);
  afficheMessage("erreur fatale",true);
  afficheMessage("fausse manoeuvre",0) ;
  afficheMessage("fausse manoeuvre");
  afficheMessage();
  return 0;
}
void afficheMessage(const char *msg, bool stop) {
  printf("%s\n",msg);
  if (stop)
    printf("STOP\n");
}
