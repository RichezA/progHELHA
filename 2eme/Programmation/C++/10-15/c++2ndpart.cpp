#include <iostream>
using namespace std;



int main(int argc, char* argv[], char* envp[])
{
    // argv = variable mise après l'éxecutable
    cout << "Le programme " << argv[0] << " a " << argc << " arguments" << endl;

    for(int i = 0; i < argc; i++)
    {
        cout << argv[i] << endl;
    }

    cout << "Variable d'environnement:\n" << endl;

    for(int i = 0; envp[i]; i++) // similaire à un i < envp.Length en c#    
        cout << envp[i] << endl;

    return 0;
}
