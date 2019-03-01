using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Cours_Q2
{
    class Camion:Vehicule //La classe camion hérite de la classe véhicule.
    {
        private int nbEssieux;
        private int chargeUtile;

        public Camion(string marque, string modele, int cylindree, int anneeFabrication, int nbEssieux, int chargeUtile) : base(marque, modele, cylindree, anneeFabrication)
        {
            this.nbEssieux = nbEssieux;
            this.chargeUtile = chargeUtile;
        }

    }
}
