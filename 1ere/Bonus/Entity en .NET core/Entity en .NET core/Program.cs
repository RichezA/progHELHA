using System;
using Microsoft.EntityFrameworkCore;
using static System.Console;

namespace Entity_en_.NET_core
{
    class Program
    {
        static void Main(string[] args)
        {
            var db = new EtudiantContext();
            var etudiant = new Etudiant { Nom = "Dudziak", Prenom = "Thomas" };

            db.Etudiants.Add(etudiant);
            db.SaveChanges();


            ReadKey(true);
        }
    }
}
