using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Exo_récap_examenQ2
{
    class Program
    {
        static void Main(string[] args)
        {
            List<Marchandise> marchandises = new List<Marchandise>() { new Marchandise(1, 5.0, 5.0) };

            List<Transport> transports = new List<Transport>();
            transports.Add(new TransportRoutier(500.0, marchandises));


            Console.ReadKey(true);
        }
    }
}
