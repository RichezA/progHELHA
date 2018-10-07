using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Linq__12_03_18_
{
    class Program
    {
        static void Main(string[] args)
        {
            List<Client> contacts = new List<Client>();

            contacts.Add(new Client { nom = "Dudziak", id = 1, codePostal = "7900" });
            contacts.Add(new Client { nom = "Dupont", id = 2, codePostal = "7500" });
            contacts.Add(new Client { nom = "Vantrimpon", id = 3, codePostal = "7000" });
            contacts.Add(new Client { nom = "Hurluberlu", id = 4, codePostal = "7900" });
            contacts.Add(new Client { nom = "Jean-Bernard", id = 5, codePostal = "7600" });

            var result = from clt in contacts select new { nom = clt.nom, codePostal = clt.codePostal };

            var result2 = from clt in contacts where clt.codePostal == "7900" || clt.codePostal == "7000" orderby clt.nom descending select new { nom = clt.nom, codePostal = clt.codePostal };
            var list = result2.ToList();

            var result3 = from clt in contacts group clt by clt.codePostal;

            foreach(var group in result3)
            {
                Console.WriteLine(group.Key);
                foreach (var client in group) Console.WriteLine("\t" + client.nom);
            }

            Console.ReadKey(true);
            
        }
    }
}
