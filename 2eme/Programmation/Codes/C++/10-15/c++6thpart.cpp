#include <iostream>
using namespace std;

int x = 10;

int main(void){
    cout << x << endl;
    char x = 'b';
    cout << x << endl;
    cout << ::x << endl;
    {
        cout << "sous-bloc" << endl;
        double x = 2.15;
        cout << x << endl;
        cout << ::x << endl;
    }
    return 0;
}
