using System;
using System.Collections.Generic;
using System.Text;
using Microsoft.EntityFrameworkCore;

namespace Entity_en_.NET_core
{
    public class EtudiantContext : DbContext
    {
        protected override void OnConfiguring(DbContextOptionsBuilder optionsBuilder)
        {
            optionsBuilder.UseSqlServer(@"Server=(localdb)\MSSQLLocalDB;Database=TestDatabase;Trusted_Connection=True;");
        }

        public virtual DbSet<Etudiant> Etudiants { get; set; }
    }


    public class Etudiant
    {
        public int EtudiantID { get; set; }
        public string Nom { get; set; }
        public string Prenom { get; set; }
    }
}
