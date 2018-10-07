using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Threading;

namespace _09_03_18__Task_
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine(DateTime.Now.ToLongTimeString());
            string nom = "toto";
            string message = "Bonjour !";


            Task.Factory.StartNew(() =>
            {
                Console.WriteLine("Executing the task at " + DateTime.Now.ToLongTimeString());
                Console.WriteLine(nom);
                Thread.Sleep(15000);
                Console.WriteLine("Task Finished at " + DateTime.Now.ToLongTimeString());
            });

            //Task.Factory.StartNew(new Action(Politesse));

            //Task.Factory.StartNew(delegate
            //{
            //    Thread.Sleep(5000);
            //    Politesse(); //Méthode attend 5s et dit bjr
            //});

            
            var task1 = Task.Run(() =>
            {
                Thread.Sleep(5000);
                Politesse(message);
            });

            var task2 = Task.Run(() =>
            {
                Console.WriteLine("Je continue le boulot de task1");
            });

            //Console.WriteLine(DateTime.Now.ToLongTimeString());
            Task.WaitAll(task1);

            Console.WriteLine("La tache {0} est terminée", task1.ToString());
            Console.ReadKey(true);



            //while(true)
            //{
            //    Console.WriteLine(DateTime.Now.ToLongTimeString());
            //    Thread.Sleep(1000);
            //}

            
        }

        static void Politesse(string message)
        {
            Thread.Sleep(5000);
            Console.WriteLine(message);
        }
    }
}
