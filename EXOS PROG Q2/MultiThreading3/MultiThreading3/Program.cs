using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Threading;


namespace Tests_des_iles
{
    class Program
    {
        private const int time = 5000;

        static void Main(string[] args)
        {
            string test = "J'affiche test";
            Console.WriteLine(DateTime.Now.ToLongTimeString());
            
            Thread monThread4 = new Thread((chose)=>
            {
                Console.WriteLine("Début Thread");
                Thread.Sleep(time);
                Console.WriteLine(chose);
                Console.WriteLine("Fin Thread");
                
            });

            monThread4.Start(test);
            //Thread monThread = new Thread(new ThreadStart(ThreadExample)); //ThreadStart est un type delegate
            //Thread monThread2 = new Thread(new ParameterizedThreadStart(ThreadExample2));
            //Thread monThread3 = new Thread(new ThreadStart(ThreadExample),)

            Console.WriteLine(DateTime.Now.ToLongTimeString());

            Console.ReadKey(true);
        }

        static void ThreadExample2(object obj)
        {
            Thread.Sleep(time);
            Console.WriteLine("Fin du thread");
        }

        static void ThreadExample()
        { //Entrée du thread ici

            Thread.Sleep(time);
            Console.WriteLine("Fin du thread");

        } //Sortie de la méthode = sortie du thread
    }
}

