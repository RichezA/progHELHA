#pragma once

class Point
{
	double x, y;

	public:
		Point(double x = 0, double y = 0);
		inline double getX() const;
		inline double getY() const;
		double dist(Point p) const;
};

double Point::getX() const
{
	return x;
}

double Point::getY() const
{
	return y;
}
