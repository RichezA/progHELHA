using System;
using System.Collections;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Exo_récap_examenQ2
{
    abstract class Transport:IEnumerable<Marchandise>
    {
        protected static readonly double coefficientGrosVolume = 1.5;

        private double distance;
        private List<Marchandise> marchandises;

        #region Ctor

        public Transport(double distance, List<Marchandise> marchandises)
        {
            this.distance = distance;
            this.marchandises = marchandises;
        }

        #endregion

        #region Operators

        public static bool operator ==(Transport t1,Transport t2)
        {
            return t1.CoutTotal() == t2.CoutTotal();
        }

        public static bool operator != (Transport t1, Transport t2)
        {
            return t1.CoutTotal() != t2.CoutTotal();
        }

        #endregion

        #region Indexer

        public Marchandise this[int index]
        {
            get
            {
                if (index < 0 || index > this.marchandises.Count - 1) throw new IdentNotFoundException();

                return marchandises[index];
            }
        }

        #endregion

        #region Add

        public void AddMarchandise(Marchandise m)
        {
            if (this.marchandises.Exists(x => x.Id == m.Id)) throw new Exception("La marchandise se trouve déjà dans le transport !");
            else this.marchandises.Add(m);
        }

        #endregion

        #region Total weight & volume

        public double PoidsTotal()
        {
            double poidsTot = 0.0;

            foreach (var march in this.marchandises) poidsTot += march.Poids;
            return poidsTot;
        }

        public double VolumeTotal()
        {
            double volumeTot = 0.0;

            foreach (var march in this.marchandises) volumeTot += march.Volume;
            return volumeTot;
        }

        #endregion

        #region Enumerator

        public IEnumerator<Marchandise> GetEnumerator()
        {
            foreach (var march in this.marchandises) yield return march;
        }

        #endregion

        #region Total cost

        public virtual double CoutTotal()
        {
            return distance * PoidsTotal();
        }

        IEnumerator IEnumerable.GetEnumerator()
        {
            throw new NotImplementedException();
        }

        #endregion
    }

    public class IdentNotFoundException:ApplicationException
    {
        public IdentNotFoundException() : base("Index non trouvé") { }
    }
}
