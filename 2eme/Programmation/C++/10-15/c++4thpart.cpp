#include <iostream>
using namespace std;

double exemple(double x, double w){
    printf("config a: %f %f \n",x,w);
    return x;
}
int exemple(int x, int w){
    printf("config b: %f %f \n",x,w);
    return x;
}
int main(){
    int b = 200;, v;
    double a=100.5, w;
    //try sans cast
    v = exemple((double)b, a);
    w = exemple(b, (int)a);
    w = exemple(b, b);
    return 0;
}
