using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LINQ_to_SQL__19_03_18_
{
    class Program
    {
        static void Main(string[] args)
        {
            DataClasses1DataContext myContext = new DataClasses1DataContext();

            var result = from client in myContext.Clients2 select client;

            foreach (Clients2 client in result) Console.WriteLine(client.prenom + " " + client.nom);

            result.ToList().ForEach(client => client.ville = "San Francisco");

            //--------------------------------------------------------------------------------------------

            Console.WriteLine("Client sélectionné");
            var single = result.Single(client => client.idClient == new Guid("faa5cb76-2ce2-4eba-abb4-5379f4c1eb0e"));
            single.nom = "Dudziak";
            Console.WriteLine(single.nom + " " + single.prenom);

            //---------------------------------------------------------------------------------------------

            var clt = new Clients2();

            clt.idClient = Guid.NewGuid();
            clt.nom = "Libre";
            clt.prenom = "Yves";
            clt.ville = "Leuze";
            myContext.Clients2.InsertOnSubmit(clt);

            //---------------------------------------------------------------------------------------------

            myContext.SubmitChanges();

            Console.ReadKey(true);

        }
    }
}
