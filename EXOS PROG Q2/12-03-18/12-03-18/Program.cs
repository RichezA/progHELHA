using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Net;

namespace _12_03_18
{
    class Program
    {
        static void Main(string[] args)
        {
            GetJson();
            Console.WriteLine("En attente des données...");
            Console.ReadKey(true);
        }

        static void GetJson()
        {
            using (var client = new WebClient())
            {
                Uri WebApiUri = new Uri("https://jsonplaceholder.typicode.com/posts");
                client.DownloadStringAsync(WebApiUri);
                client.DownloadStringCompleted += onDownloadCompleted;
            }
        }

        private static void onDownloadCompleted(object sender, DownloadStringCompletedEventArgs e)
        {
            var data = e.Result;
            Console.WriteLine("\nDonnées récupérées : \n\n");
            //printData(data);
        }

        private static void printData(string data)
        {
            Console.WriteLine(data);
        }
    }
}
