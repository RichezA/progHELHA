#include <string>
#include <sstream>
#include <iostream>

// permet de dire que ça va exister -> on peut donc mettre la classe après le main
/*class Point;
bool coincide(const Point &p, const Point &q);
class Circle;*/

class Point
{
    double _x, _y;

  public:
    Point(double abs = 0, double ord = 0) : _x(abs), _y(ord)
    {
    }

    std::string toString()
    {
        std::stringstream str;
        str << "( " << _x << " , " << _y << " )" << std::endl;
        return str.str();
    }
    inline void set(double x, double y)
    {
        this->_x = x;
        this->_y = y;
    }
    inline double x() const
    {
        return _x;
    }
    inline double y() const
    {
        return _y;
    }
    /*void translate(double x, double y)
    {
        this->x += x;
        this->y += y;
    }*/
    bool coincide(const Point &p)
    {
        return ((p._x == this->_x) && (p._y == this->_y));
    }
    friend bool coincide(const Point &, const Point &);
};

class Circle
{
    Point &_center;
    double _radius;

  public:
    Circle(Point &p, double rad) : _center(p), _radius(rad) {}
    inline void translate(double x, double y)
    {
        //_center.translate(x, y);
        _center.set(_center.x() + x, _center.y() + y);
    }
    std::string toString()
    {
        std::stringstream str;
        str << "Circle of center " << _center.toString() << " and of radius " << _radius.toString() << std::endl;
        return str.str();
    }
};

int main()
{
    Point a(1, 0), b(1), c;
    if (a.coincide(b))
        std::cout << "a coincide avec b" << std::endl;
    else
        std::cout << "a ne coincide pas avec b" << std::endl;
    if (b.coincide(c))
        std::cout << "a coincide avec c" << std::endl;
    else
        std::cout << "a ne coincide pas avec c" << std::endl;
    if (a.coincide(c))
        std::cout << "a coincide avec c" << std::endl;
    else
        std::cout << "a ne coincide pas avec c" << std::endl;
}

bool coincide(Point &p, Point &q)
{
    return ((p._x == q._x) && (p._y == q._y));
}
