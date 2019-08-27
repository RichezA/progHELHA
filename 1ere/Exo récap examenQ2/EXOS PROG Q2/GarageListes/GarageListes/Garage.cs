using System;
using System.Collections;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace GarageListes
{
    class Garage : IEnumerable<Vehicule>
    {
        #region Propriétés

        public List<Vehicule> listeVehicules { get; private set; }

        #endregion

        #region Constructeur

        public Garage()
        {
            this.listeVehicules = new List<Vehicule>();
        }

        #endregion

        #region Indexeurs

        public Vehicule this[int index]
        {
            get
            {
                if (index >= 0 && index < this.listeVehicules.Count) return this.listeVehicules[index];
                throw new Exception("Index de véhicule erroné");
            }
        }

        public Vehicule this[string numChassis]
        {
            get
            {
                foreach(var vehicle in this.listeVehicules)
                {
                    if (vehicle.NumChassis == numChassis) return vehicle;
                }

                throw new Exception("Numéro de chassis non trouvé !");
            }
        }

        #endregion

        #region Enumerateur

        public IEnumerator<Vehicule> GetEnumerator()
        {
            foreach (var vehicle in this.listeVehicules) yield return vehicle;
        }

        public IEnumerable<Vehicule> GetVehicleReverse()
        {
            for (int i = this.listeVehicules.Count - 1; i >= 0; i--) yield return this.listeVehicules[i];
        }

        public IEnumerable<Vehicule> GetVehicleOrdered()
        {
            this.listeVehicules.Sort()

            foreach (var vehicle in this.listeVehicules) yield return vehicle;
        }

        IEnumerator IEnumerable.GetEnumerator()
        {
            throw new NotImplementedException();
        }

        #endregion
    }
}
