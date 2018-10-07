using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Entity_Framework_Code_First
{
    class Program
    {
        static void Main(string[] args)
        {
            var db = new Database();

            db.Articles.Add(new Article
            {
                Nom = "Test",
                Prenom = "testprenom",
                IdArticle = 1
            });

            db.SaveChanges();
            Console.ReadKey(true);
        }
    }
}
