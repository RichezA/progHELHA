#include <iostream>
using namespace std;

void afficheMessage(const char *msg = "Avertissement", bool stop = false)
{
    printf("%s\n",msg);
    if(stop) printf("STOP\n");
}
bool stop = true;
int main() {
    afficheMessage("erreur fatale", stop);
    afficheMessage("fausse manoeuvre",0);
    afficheMessage("fausse manoeuvre");
    afficheMessage();
    return 0;
}
