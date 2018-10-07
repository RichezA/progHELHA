using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Cours_Q2
{
    class Voiture:Vehicule //La classe "voiture" hérite de la classe "véhicule".
    {
        private int nbPlaces;

        public Voiture(string marque, string modele, int cylindree, int anneeFabrication, int nbPlaces):base(marque, modele, cylindree, anneeFabrication)
        {
            this.nbPlaces = nbPlaces;
        }
        
    }
}
