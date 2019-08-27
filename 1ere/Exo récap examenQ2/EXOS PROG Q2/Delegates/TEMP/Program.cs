using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Timers;

namespace Delegate
{
    class Program
    {
        static void Main(string[] args)
        {
            Timer t1 = new Timer();
            t1.Elapsed += OnTimerElapsed;

            t1.Interval = 1000;
            t1.Enabled = true;
            t1.Start();

            Console.ReadKey(true);
            Console.ReadKey(true);

            t1.Stop();
            t1.Dispose(); //Nettoyage de la mémoire pour le timer => NE PAS EN ABUSER
        }

        private static void OnTimerElapsed(object sender, ElapsedEventArgs e)
        {
            Console.WriteLine(DateTime.Now.ToLongTimeString());
        }
    }
}
