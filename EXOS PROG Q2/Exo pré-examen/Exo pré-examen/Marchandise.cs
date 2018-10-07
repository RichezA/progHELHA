using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Exo_pré_examen
{
    class Marchandise
    {
        private int id;
        private double poids;
        private double volume;

        #region Propriétés

        public int Identifiant
        {
            get { return this.id; }
        }
        public double Poids
        {
            get { return this.poids; }
            set { this.poids = value; }
        }
        public double Volume
        {
            get { return this.volume; }
            set { this.volume = value; }
        }

        #endregion

        #region Ctor

        public Marchandise(int id, double poids, double volume)
        {
            this.id = id;
            this.poids = poids;
            this.volume = volume;
        }

        #endregion

        #region Surcharge

        public static explicit operator double(Marchandise marchandise)
        {
            return marchandise.Poids;
        }

        #endregion
    }
}
