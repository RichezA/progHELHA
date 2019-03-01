#ifndef DEPARTEMENT_H
#define DEPARTEMENT_H

#include <string>

struct Manager;

struct Departement
{
	Manager* mgr;//not allocated here
	std::string nom;

	Departement(std::string nom, Manager* mgr = nullptr);	
};

#endif
