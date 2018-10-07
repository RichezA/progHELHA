using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Threading;

namespace MultiThreading2
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Traitement principal");

            Thread myThread = new Thread(new ThreadStart(MonTraitement));
            myThread.Start(); //Démarrage du thread

            Console.WriteLine("Poursuite du traitement principal");

            Console.ReadKey(true);
        }

        private static void MonTraitement()
        {
            Console.WriteLine("Début du travail de fond");

            for (int i = 0; i < 9999; i++)
            {
                Console.WriteLine(DateTime.Now.ToLongTimeString());
                Thread.Sleep(1000);
            }

            Console.WriteLine("Travail de fond terminé");
        }
    }
}
