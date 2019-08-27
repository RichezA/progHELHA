using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Exo_pré_examen
{
    class Program
    {
        static void Main(string[] args)
        {
            Marchandise marchandise1 = new Marchandise(1, 10.20, 1.2);
            Marchandise marchandise2 = new Marchandise(2, 20.20, 3.0);

            Transport transport1 = new TransportAerien(100.0);
            //Ref d'une classe peut pointer vers n'importe quel objet d'une classe dérivée => POLYMORPHISME
            transport1.AddMerchandise(marchandise1);
            transport1.AddMerchandise(marchandise2); //On ajoute les 2 marchandises au transport

            Console.WriteLine("Coût du transport : {0}", transport1.Cout());

            Console.WriteLine("Poids total du \"Transport n° 1\" : {0} kg\n\n", transport1.GetTotalTransportMass());

            foreach (var marchandise in transport1) Console.WriteLine("Marchandise {0} : {1} kg", marchandise.Identifiant, marchandise.Poids);

            Console.ReadKey(true);
        }
    }
}
