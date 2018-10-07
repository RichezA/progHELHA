using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Threading;

namespace _05_03_18__1_
{
    class Program
    {
        static bool hasToContinue = true;

        static int counter = 0;

        static object myLock = new object(); //Obligation de travailler sur un objet pour que le mécanisme fonctionne.

        static ManualResetEvent manualResetEvent = new ManualResetEvent(false);

        static void Main(string[] args)
        {
            //hasToContinue = true;

            //Thread monThread = new Thread(new ThreadStart(Traitement));
            //monThread.Start();
            ////Comment arrêter de manière correcte le thread ?
            //Console.ReadKey(true);
            //hasToContinue = false; //Quand on aura pressé une touche => hasToContinue = false => Arrêt du thread.

            //================================================

            Thread monThread1 = new Thread(new ThreadStart(Traitement));
            Thread monThread2 = new Thread(new ThreadStart(Traitement2));

            monThread1.Start();
            monThread2.Start();


            Console.WriteLine("On attend le Traitement 2....");
            //Console.ReadKey(true); on peut le remplacer (pour attendre fin du traitement) par :
            manualResetEvent.WaitOne();
            Console.WriteLine("Fin de l'attente du Traitement 2.");

            //Console.WriteLine("Contenu du compteur : {0}", counter);

            Console.ReadKey(true);
            Console.ReadKey(true);

        }

        static void Traitement()
        {
            int i = 0;

            lock (myLock)
            {
                Console.WriteLine("Début du Thread 1");

                for (i = 0; i < 100 && hasToContinue; i++) //On utilise le booléen pour vérifier s'il faut arrêter ou non
                {
                    Thread.Sleep(20);
                    counter++;
                }
            }

            Console.WriteLine("Fin du Thread 1");
            //Console.WriteLine("Valeur de i : {0}", i);
        }

        static void Traitement2()
        {
            int i = 0;

            try
            {
                lock (myLock)
                {
                    Console.WriteLine("Début du Thread 2");

                    for (i = 0; i < 100; i++)
                    {
                        Thread.Sleep(15);
                        counter++;
                    }
                }
            }
            catch (Exception ex) { Console.WriteLine(ex.Message); }
            finally
            {
                Console.WriteLine("Fin du Thread 2");
                manualResetEvent.Set(); //Il s'active => il n'était pas activé au début.
            }

            //Console.WriteLine("Valeur de i = {0}", i);
        }
    }
}
