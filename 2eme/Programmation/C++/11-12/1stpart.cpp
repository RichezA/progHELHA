#include <string>
#include <sstream>
#include <iostream>
#include <cmath>

// permet de dire que ça va exister -> on peut donc mettre la classe après le main
/*class Point;
bool coincide(const Point &p, const Point &q);
class Circle;*/

class Point
{
    double _x, _y;

  public:
    Point(double abs = 0, double ord = 0) : _x(abs), _y(ord) {}

    double distance(Point p)
    {
        return sqrt((_x - p._x) * (_x - p.x) + (_y - p._y) * (_y - p._y));
    }
    std::string toString()
    {
        std::stringstream str;
        str << "( " << _x << " , " << _y << " )" << std::endl;
        return str.str();
    }
    inline void set(double x, double y) {this->_x = x; this->_y = y;}
    inline double x() const {return _x;}
    inline double y() const {return _y;}
};

class Circle
{
    Point &_center;
    double _radius;

  public:
    Circle(Point &p, double rad) : _center(p), _radius(rad) {}
    inline void translate(double x, double y)
    {
        _center.set(_center.x() + x, _center.y() + y);
    }
    std::string toString()
    {
        std::stringstream str;
        str << "Circle of center " << _center.toString() << " and of radius " << _radius << std::endl;
        return str.str();
    }
};

