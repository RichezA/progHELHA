using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Cours_Q2
{
    class Vehicule
    {

        private string marque;
        private string modele;
        private int cylindree;
        private int anneeFabrication;


        public Vehicule(string marque, string modele, int cylindree, int anneeFabrication)
        {
            this.marque = marque;
            this.modele = modele;
            this.cylindree = cylindree;
            this.anneeFabrication = anneeFabrication;
        }
    }
}
