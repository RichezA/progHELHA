using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Interface
{
    class Program
    {
        static void Main(string[] args)
        {
            int[] tab = { 1, 9, 12, 5, 7, 6 };
            Array.Sort(tab);

            foreach (int value in tab) Console.WriteLine(value);
            Console.Write("\n");

            CompteBancaire cb1 = new CompteBancaire(100, "Dudziak");
            Console.WriteLine(cb1 + "\n");

            CompteBancaire[] Banque = new CompteBancaire[5];
            Banque[0] = new CompteBancaire(560, "Lefebvre");
            Banque[1] = new CompteBancaire(10560, "Lefebvre1");
            Banque[2] = new CompteBancaire(10200, "Lefebvre2");
            Banque[3] = new CompteBancaire(1500, "Lefebvre3");
            Banque[4] = new CompteBancaire(10, "Lefebvre4");

            Array.Sort(Banque);
            for (int i = 0; i < 5; i++) Console.WriteLine(Banque[i]);

            Console.ReadKey(true);
        }
    }
}
