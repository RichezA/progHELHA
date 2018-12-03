#ifndef MANAGER_H
#define MANAGER_H

#include <string>
#include "13 - departement.h"

struct Manager
{
	Departement& dpt;
	std::string nom;
	
	Manager(std::string nom, Departement& dpt);
};

#endif
