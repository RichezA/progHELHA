using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Exo_récap_examenQ2
{
    class Marchandise
    {
        private int id;
        private double poids;
        private double volume;

        public int Id
        {
            get { return id; }
        }

        public double Poids
        {
            get { return poids; }
            set { poids = value; }
        }

        public double Volume
        {
            get { return volume; }
            set { volume = value; }
        }

        #region Ctor

        public Marchandise(int id, double poids, double volume)
        {
            this.id = id;
            this.poids = poids;
            this.volume = volume;
        }

        #endregion

        #region Operators

        public static explicit operator double(Marchandise m)
        {
            return m.poids;
        }

        #endregion
    }
}
