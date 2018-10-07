using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SQL__16_03_18_
{
    static class DatabaseSearch
    {
        static DataClasses1DataContext dataContext = new DataClasses1DataContext();

        #region Méthodes de recherche

        public static void ById()
        {
            int id = 0;
            Console.Write("\nID ? : ");
            id = int.Parse(Console.ReadLine());

            Console.WriteLine();
            var searchResult = from client in dataContext.Clients where client.idClient == id orderby client.nom + client.prenom select client;

            foreach (var client in searchResult) DisplayClient(client);
        }

        public static void ByFirstName()
        {
            Console.Write("\nFirst name ? : ");
            string name = Console.ReadLine().ToLower();

            Console.WriteLine();
            var searchResult = from client in dataContext.Clients where client.prenom.ToLower().Contains(name) orderby client.nom + client.prenom select client;

            foreach (var client in searchResult) DisplayClient(client);
        }

        public static void ByLastName()
        {
            Console.Write("\nName ? : ");
            string name = Console.ReadLine().ToLower();

            Console.WriteLine();
            var searchResult = from client in dataContext.Clients where client.nom.ToLower().Contains(name) orderby client.nom + client.prenom select client;

            foreach (var client in searchResult) DisplayClient(client);
        }

        public static void ByCity()
        {
            Console.Write("\nCity ? : ");
            string city = Console.ReadLine().ToLower();

            Console.WriteLine();
            var searchResult = from client in dataContext.Clients where client.ville.ToLower().Contains(city) orderby client.nom + client.prenom select client;

            foreach (var client in searchResult) DisplayClient(client);
        }

        public static void ByPhoneNumber()
        {
            Console.Write("\nPhone Number ? : ");
            string phoneNumber = Console.ReadLine().ToLower();

            Console.WriteLine();
            var searchResult = from client in dataContext.Clients where client.telephone.ToLower().Contains(phoneNumber) orderby client.nom + client.prenom select client;

            foreach (var client in searchResult) DisplayClient(client);
        }

        #endregion

        private static void DisplayClient(Clients client)
        {
            Console.WriteLine("{0} {1}", client.nom, client.prenom);
        }
    }
}
