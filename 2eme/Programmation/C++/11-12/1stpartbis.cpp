#include <iostream>

class Point
{
    int x, y;

    public:
        Point(int abs = 0, int ord = 0): x(abs), y(ord) {}
        friend bool coincide(const Point &, const Point &);
};

int main()
{
    Point a(1,0), b(1), c;
    if(coincide(a,b))
        std::cout << "a coincide avec b" << std::endl;
    else 
        std::cout << "a ne coincide pas avec b" << std::endl;
    if(coincide(a,c))
        std::cout << "a coincide avec c" << std::endl;
    else
        std::cout << "a ne coincide pas avec c" << std::endl;
}

bool coincide(const Point &p, const Point &q) { return ((p.x == q.x) && (p.y == q.y));}