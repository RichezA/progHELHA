#include <iostream>
#include "11 - point_decl.h"	

using namespace std;

int main()
{
	Point p1(1,1);
	//cout << p1.x << " " << p1.y << endl; //ko
	cout << p1.getX() << " " << p1.getY() << endl;
	Point p2(2,2);
	cout << p2.getX() << " " << p2.getY() << endl;
	cout << "dist = " << p1.dist(p2) << endl;
}
