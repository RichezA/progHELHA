using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace GarageListes
{
    class Vehicule
    {
        #region Membres

        private string marque;
        private string numChassis;

        #endregion

        #region Propriétés

        public string NumChassis
        {
            get { return this.numChassis; }
        }

        #endregion

        #region Constructeur

        public Vehicule(string marque, string numChassis)
        {
            this.marque = marque;
            this.numChassis = numChassis;
        }

        #endregion

        #region Méthodes

        public int CompareTo(Vehicule other)
        {
            return this.numChassis.CompareTo(other.numChassis);
        }

        #endregion
    }
}
