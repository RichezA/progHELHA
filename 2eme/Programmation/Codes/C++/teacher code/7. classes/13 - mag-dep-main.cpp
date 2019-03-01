#include <iostream>
#include "13 - departement.h"
#include "13 - manager.h"

using namespace std;

int main()
{
	Departement esi("ESI");
	Manager mwi("Willemse", esi);

	esi.mgr = &mwi;
}
