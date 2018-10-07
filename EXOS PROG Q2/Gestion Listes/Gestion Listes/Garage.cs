using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Gestion_Listes
{
    class Garage
    {
        private List<Vehicle> listVehicles;

        public Garage()
        {
            this.listVehicles = new List<Vehicle>();
        }

        #region Manipuler Liste

        public void AddVehicle(Vehicle vehicle)
        {
            this.listVehicles.Add(vehicle);
        }

        public void RemoveAVehicle(int index)
        {
            this.listVehicles.RemoveAt(index);
        }

        public void RemoveAllVehicles()
        {
            this.listVehicles.RemoveAll()
        }

        #endregion

    }
}
