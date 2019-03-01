#include <iostream>
#include <cmath>
using namespace std;

/*struct Point // everything is public at first
{
    Point(int x, int y)
    {
        this -> x = x;
        this -> y = y;
    }
    
    inline double getX()
    {
        return x;
    }
    
    inline double getY()
    {
        return y;
    }

    double dist(Point p)
    {
        return sqrt((x - p.x)*(x - p.x) + (y - p.y)*(y - p.y));
    }

    private: 
        double x,y;
};*/
class point // all members & methods are at first private
{
    private: // adding private fields => optional
        double x,y;
        const int z = 10;
        bool copie = false;
        double getX2(){
            return x;
        }

    public:
        //point(int w = 0, int v = 0) : x(w) , y(v), z(10) {}
        // Different types of constructors
        point(int x, int y)
        {
            this -> copie = false;
            this -> x = x;
            this -> y = y;

            cout << "Construction de " << x << " " << y << endl;
        }
        point(const point& p){ // copy constructor
            this -> copie = true;
            this -> x = p.x;
            this -> y = p.y;

            cout << "Copie de " << x << " " << y << endl;  
        }
        point(double w = 0, double v = 0) : z(10)
        {
            this -> x = w;
            this -> y = v;
        }
        ~point(){ // destructor
            cout << "Destruction de " << x << " " << y;
            if(copie){
                cout << " (copie)";
                cout << endl; 
            }
        }
        void sayHello(const point& p){
            cout << "Hello Mr Point " << p.getX() << " " << p.getY() << endl;
        }

        inline double getX() const
        {
            return x;
        }
        inline double getY() const 
        {
            return y; 
        }
        double dist(point p) const
        {
            return sqrt((x - p.x)*(x - p.x) + (y - p.y)*(y - p.y));
        }
        inline double setX(int x)
        {
            this -> x = x;
            cout << "Edit : " << x << endl;
        }
};

void f(point& p){
    p.setX(40);
    cout << "p.x = " << p.getX() << endl;
}

/*class A
{
    int i;
    const int k;
    
    private:
        A() : k(5)
        {
            cout << "init " << endl;
            // k = 5;
        }
    public:
        A(int x) : A() //, i(x) 
        {
            i = x;
        }
    void print() { cout << "A : " << i << endl;}
};*/
/*struct A
{
    int i;
    A(int i) :  i(i) {}
};
struct B
{
    A a;
    B(A a) : a(a) {}; // ok
    //B(A a) // ko
    //{
    //  this -> a = a;
    //}
};*/
int main(){
    printf("start");
    point p1(1,1); // Si pas de paramètres => pas de ()
    cout << p1.getX() << " " << p1.getY() << endl;
    point p2(2,2);
    cout << p2.getX() << " " << p2.getY() << endl;
    cout << "dist = " << p1.dist(p2) << endl;
    point p3(p1); // explicit copy
    //p3 = p2;
    p3.setX(3);
    cout << "Dans le main : " << p2.getX() << " " << p2.getY() << endl;
    cout << "dist = " << p1.dist(p2) << endl; 
   /*A a(2);
   B b(a);*/
    return 0;
}