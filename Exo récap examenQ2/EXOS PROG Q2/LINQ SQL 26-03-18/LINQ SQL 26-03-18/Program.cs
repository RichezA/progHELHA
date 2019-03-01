using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LINQ_SQL_26_03_18
{
    class Program
    {
        static void Main(string[] args)
        {
            DataClasses1DataContext myContext = new DataClasses1DataContext();

            var allClients = myContext.GetAllClients();
            var clientLeuze = myContext.GetClientsByCity("Leuze");

            Console.WriteLine("Liste de tous les clients : \n");
            foreach (var client in allClients) Console.WriteLine("{0} {1}", client.nom, client.prenom);

            Console.WriteLine("\n");

            Console.WriteLine("Liste des clients venant de Leuze : \n");
            foreach (var client in clientLeuze) Console.WriteLine("{0} {1}", client.nom, client.prenom);


            Console.ReadKey(true);
        }
    }
}
