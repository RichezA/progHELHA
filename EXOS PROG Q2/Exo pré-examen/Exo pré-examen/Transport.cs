using System;
using System.Collections;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Exo_pré_examen
{
    class Transport:IEnumerable<Marchandise>
    {
        private double distance;
        private List<Marchandise> marchandises;

        #region Ctor

        public Transport(double distance)
        {
            this.distance = distance;
            this.marchandises = new List<Marchandise>();
        }

        #endregion

        #region Méthodes

        public void AddMerchandise(Marchandise march)
        {
            foreach(var item in this.marchandises)
            {
                if (item.Identifiant == march.Identifiant) throw new Exception("Impossible d'ajouter un article existant"); 
            }

            this.marchandises.Add(march);
        }

        public double GetTotalTransportMass()
        {
            double poidsTotal = 0.0;

            foreach (var item in this.marchandises)
            {
                poidsTotal += item.Poids;
            }

            return poidsTotal;
        }

        public double GetTotalVolume()
        {
            double volumeTotal = 0.0;

            foreach(var item in this.marchandises)
            {
                volumeTotal += item.Volume;
            }

            return volumeTotal;
        }

        public virtual double Cout()
        {
            return this.GetTotalTransportMass() * this.distance;
        }

        public static bool operator == (Transport t1, Transport t2)
        {
            if (t1.Cout() == t2.Cout()) return true;
            else return false;
        }

        public static bool operator != (Transport t1, Transport t2)
        {
            if (t1.Cout() != t2.Cout()) return true;
            else return false;
        }

        #endregion

        #region Enumérateur

        public IEnumerator<Marchandise> GetEnumerator()
        {
            foreach (var marchandise in this.marchandises)
            {
                yield return marchandise;
            }
        }

        IEnumerator IEnumerable.GetEnumerator()
        {
            throw new NotImplementedException();
        }

        #endregion
    }
}
