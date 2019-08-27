using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Entity_Framework;

namespace Entity_Framework
{
    class Program
    {
        static void Main(string[] args)
        {
            var db = new TestDatabaseEntities();
            db.Clients2.Add(new Clients2
            {
                nom = "Taratétakarataké",
                prenom = "Jeanette-Grenadine",
                ville = "Anvers",
                idClient = new Guid()
            });
            //db.SaveChanges();

            var clients = from client in db.Clients2 select new { Nom = client.nom, Prenom = client.prenom };

            foreach(var clt in clients)
            {
                Console.WriteLine("{0} {1}", clt.Nom, clt.Prenom);
            }

            Console.ReadKey(true);
            Console.ReadKey();
        }
    }
}
