#include <iostream>
using namespace std;

void afficheMessage(const char *msg = "Avertissement", bool stop = false); // prototype de afficheMessage
bool stop = true;
int main()
{

    afficheMessage("erreur fatale", stop);
    afficheMessage("fausse manoeuvre", 0);
    afficheMessage("fausse manoeuvre");
    afficheMessage();
    return 0;
}
void afficheMessage(const char *msg, bool stop)
{
    printf("%s\n", msg);
    if (stop)
        printf("STOP\n");
}
