#include "declarationHeader.h"
#include <cmath>

Point::Point(double x, double y)
{
    this->x = x;
    this->y = y;
}

double Point::dist(Point p) const
{
    return sqrt((x - p.x) * (x - p.x) + (y - p.y) * (y - p.y));
}