using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Cours_Q2
{
    class Program
    {
        static void Main(string[] args)
        {
            /*L'objectif est de faire une classe voiture et une classe camion qui hériteront d'une classe véhicule car ils 
             * auront des caractéristique en commun. Cela nous évite de remettre tous les membres 2 fois... */

       
            Vehicule v1 = new Vehicule("Honda", "Civic", 1800, 2015);
            //Instanciation d'un VEHICULE (Marque, modèle, cylindrée, année de Fabrication).

            Voiture voiture1 = new Voiture("Honda", "Civic", 1800, 2015, 5);
            //Instanciation voiture : On ajoute le nombre de places demandé par la voiture (qui hérite de véhicule).

            var camion1 = new Camion("Mercedes", "NomDuModele", 3500, 2016, 2, 15000);
            //Instanciation d'un camion : On doit ajouter le nb d'essieux et la charge utile qui est nécéssaire à la création du camion. Le reste vient de
            //L'héritage de la classe Véhicule.

            Vehicule vehicule1;
            vehicule1 = new Voiture("Citroen", "C3", 1800, 2013, 5);

            Vehicule[] stockVehicules = new Vehicule[100];

            stockVehicules[0] = voiture1;
            stockVehicules[1] = camion1;

            for(int i = 0; i <=1; i++)
            {
                switch (stockVehicules[i].GetType().Name)
                {
                    case "Voiture":
                        Console.WriteLine("C'est une voiture");
                        break;
                    case "Camion":
                        Console.WriteLine("C'est un camion");
                        break;
                    default:
                        Console.WriteLine("C'est un véhicule inconnu !");
                        break;
                }
            }


            Console.ReadKey(true);
        }
    }
}
