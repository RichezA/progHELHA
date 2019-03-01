using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using MonFramework;

namespace Tests_unitaires_1
{
    class Program
    {
        static void Main(string[] args)
        {
            CompteBancaire compte1 = new CompteBancaire(100.0F, "xxxx");
            var soldeRestant = compte1.Debit(10.0F);

            DisplayCompte(compte1);

            Console.ReadKey(true);
        }

        static void DisplayCompte(CompteBancaire compte)
        {
            Console.WriteLine("Compte {0} : \n\t - Montant : {1}", compte.numeroCompte, compte.solde);
        }
    }
}
