#include <iostream>
using namespace std;

int main(int argc, char* argv[],char* envp[]){
  
  cout << "Le programme " << argv[0] << " a " << argc << " arguments" << endl;
  
  for (int i=0;i<argc;i++)
    cout << argv[i] << endl;

  cout << "Variables d'environnement:\n" << endl;
  
  for(int i=0;envp[i];i++)
    cout << envp[i] << endl;
  
  return 0;
}
