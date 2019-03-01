#include <iostream>
using namespace std;

class Point
{
  protected:
    int x, y;

  public:
    Point(int a = 0, int b = 0) : x(a), y(b) {}
    virtual void print()
    {
        cout << x << " " << y << endl;
    }
    Point &operator=(const Point &p)
    {
        if (this != &p)
        {
            x = p.x;
            y = p.y;
        }
        return *this;
    }
};
class Pointcol : public Point
{
    short r, g, b;

  public:
    Pointcol(int x, int y, int r = 255, int g = 255, int b = 255)
        : Point(x, y), r(r), g(g), b(b) {}
    Pointcol &operator=(Pointcol &p)
    {
        if (this != &p)
        {
            Point *pt1 = this;
            Point *pt2 = &p;
            *pt1 = *pt2;
            r = p.r;
            g = p.g;
            b = p.b;
        }
    }
} void print()
{
    cout << x << " " << y << " color: " << r << " " << g << " " << b << endl;
}
}
;

int main()
{
    Point p(1, 1);
    Pointcol pc(8, 12, 128, 10, 10);

    p.print();
    pc.print();
    p = pc;
    p.print();

    Point *ptp = &p;
    Pointcol *ptpc = &pc;
    ptp = ptpc;
    ptp->print();
}