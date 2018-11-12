#include "cpp11-09exosh.h"
#include <iostream>

int Point::nbPoints = 0;
Point::Point()
{
    this->id = ++nbPoints;
    std::cout << "Point " << this->id << " cree" << std::endl;
    //incrPoints();
}
Point::~Point()
{
    std::cout << "Point " << this->id << " supprime" << std::endl;
}
