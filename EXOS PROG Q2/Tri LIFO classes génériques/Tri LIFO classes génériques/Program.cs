using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Tri_LIFO_classes_génériques
{
    class Program
    {
        static void Main(string[] args)
        {
            Pile<int> pileEntiers = new Pile<int>(2); //10 est la taille de la pile

            try
            {
                pileEntiers.Push(10);
                pileEntiers.Push(25);
                //pileEntiers.Push(3); //Exception due à la taille de la pile.
            }
            catch(Exception ex)
            {
                Console.WriteLine(ex.Message);
            }

            //============================================================================

            try
            {
                Console.WriteLine(pileEntiers.Pop());
                Console.WriteLine(pileEntiers.Pop());
                //Console.WriteLine(pileEntiers.Pop()); //Exception
            }
            catch(Exception ex)
            {
                Console.WriteLine(ex.Message);
            }

            //============================================================================

            Console.WriteLine("Taille de la pile d'entiers : {0}", pileEntiers.Count);

            //============================================================================


            Pile<float> pileFlottants = new Pile<float>(5);
            Pile<Vehicule> pileVehicules = new Pile<Vehicule>(100);

            Console.ReadKey(true);
        }
    }
    
    class Vehicule
    {

    }
}
