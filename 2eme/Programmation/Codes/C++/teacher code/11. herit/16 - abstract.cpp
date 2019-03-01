#include <iostream>

using namespace std;

struct Vehicle
{		
	virtual int nbWheels() = 0;
};

struct Car : Vehicle
{
	int nbWheels() { return 4; }
};

struct Bike : Vehicle
{
	int nbWheels() { return 2; }
};

int main()
{
	Car c;
	Bike b;		

	cout << "Bike with " << b.nbWheels() << " wheels" << endl;
	cout << "Car with " << c.nbWheels() << " wheels" << endl;

	// Vehicle v3 = Bike(); //KO (instance)
	// Vehicle v; //KO (instance)
	// Vehicle *v3 = new Vehicule(); // KO (instance)
	
	Vehicle & rv = b; //ok
	cout << "Vehicle with " << rv.nbWheels() << " wheels" << endl;
	rv = c; //reaffacting a ref does not change the ref, but the referenced object
	cout << "Vehicle with " << rv.nbWheels() << " wheels" << endl;

	Vehicle * v = new Car();
	cout << "Vehicle with " << v -> nbWheels() << " wheels" << endl;
}
