using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace GarageListes
{
    class Program
    {
        static void Main(string[] args)
        {
            Garage garage1 = new Garage();

            #region Affichage Simple

            garage1.listeVehicules.Add(new Vehicule("Ford", "tttt"));
            garage1.listeVehicules.Add(new Vehicule("Citroen", "eeee"));
            garage1.listeVehicules.Add(new Vehicule("Volkswagen", "ffff"));

            foreach (var vehicle in garage1.listeVehicules) Console.WriteLine(vehicle.NumChassis);

            /* try { garage1.listeVehicules.RemoveAt(10); }
            catch (Exception ex) { Console.WriteLine(ex.Message); } */

            #endregion

            #region Indexeurs et Enumerateur

            Console.WriteLine(garage1[0]);
            //Console.WriteLine(garage1["eeee"].NumChassis);
            foreach (Vehicule vehicle in garage1) Console.WriteLine(vehicle.NumChassis);
            foreach (Vehicule vehicle in garage1.GetVehicleOrdered()) Console.WriteLine(vehicle.NumChassis);

            #endregion

            Console.ReadKey(true);
        }
    }
}
