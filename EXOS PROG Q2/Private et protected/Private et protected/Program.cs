using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Private_et_protected
{
    class Program
    {
        static void Main(string[] args)
        {
            //Vehicule v1 = new Vehicule();
            Camion camion1 = new Camion();

            Console.WriteLine(camion1.GetCylindree());

            Console.ReadKey(true);
        }
    }
}
