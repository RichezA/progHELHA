using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Threading;

namespace MultiThreading
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Travail principal en cours...");

            #region Traitement de fond

            for (int i = 0; i <= 10; i++)
            {
                Console.WriteLine("Travail de fond très long...");
                Thread.Sleep(2000);
            }
            //On simule un long traitement de 10*2 sec

            #endregion

            Console.WriteLine("Travail toujours en cours");

            Console.ReadKey(true);
        }
    }
}
