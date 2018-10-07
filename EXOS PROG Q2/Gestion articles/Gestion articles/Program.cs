using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Gestion_articles
{
    class Program
    {
        static void Main(string[] args)
        {
            Article art1 = new Article("HDD", 10, 2); //Nom + stock dmd par le ctor

            art1.Alert = new Article.AlertStock(Commande);
            art1.Alert2 = new EventHandler(Commande2);

            Console.WriteLine(art1.ToString());

            art1.AddStock(10);
            Console.WriteLine(art1.ToString());

            art1.DecreaseStock(19);
            Console.WriteLine(art1.ToString());

            Console.ReadKey(true);
        }

        private static void Commande2(object sender, EventArgs e)
        {
            Article article = (Article)sender; //Me permet de récupérer les infos de l'objet

            Console.WriteLine("Niveau de stock bas => {0} !", sender.ToString());
        }

        private static void Commande(Article article)
        {
            Console.WriteLine("Niveau de stock bas => {0} !", article.ToString());
        }
    }
}
