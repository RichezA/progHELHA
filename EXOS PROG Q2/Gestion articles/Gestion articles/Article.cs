using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Gestion_articles
{
    class Article
    {
        #region Membres

        #endregion

        #region Propriétés

        public string nom { get; private set; }

        public int stock { get; private set; }
        public int stockMinimal { get; private set; }

        #endregion

        #region Delegates

        // Step 1 : Créer le délégué (le type correspond au type de la méthode vers laquelle il pointe et ses arguments aussi)
        // C'est un peu une sorte de carte d'identité de la méthode
        public delegate void AlertStock(Article article); //Argument article car la méthode doit recevoir un article pour le traiter

        //Step 2 : Création d'une référence du type obtenu au STEP 1
        public AlertStock Alert;

        public EventHandler Alert2;

        #endregion

        #region Constructeur

        public Article(string nom, int stock, int stockMinimal)
        {
            this.nom = nom;

            this.stock = stock;
            this.stockMinimal = stockMinimal;

            this.Alert = null; //On évite que notre référence ne pointe sur rien
            this.Alert2 = null;
        }

        #endregion

        #region Méthodes de classe

        //Surcharge de Tostring() afin d'avoir une conversion personnalisée
        public override string ToString()
        {
            return string.Format("Article {0} : {1}", this.nom, this.stock);
        }

        //On peut enlever un certain nombre d'articles
        public int DecreaseStock(int quantity)
        {
            //On vérifie si il y a assez de stock pour en retirer le montant désiré

            if (quantity <= this.stock)
            {
                this.stock -= quantity;

                if (this.stock <= this.stockMinimal && this.Alert != null) this.Alert2(this, null); //this.Alert(this); 
                //Si on arrive au stock minimal que Alert ne pointe PAS sur rien, on avertit notre délégué article que l'article
                //avec lequel on est en train de travailler (d'où le this) 

                return this.stock;
            }
            else throw new Exception("Impossible de retirer plus que le stock actuel");
        }

        //On peut ajouter une quantité d'articles en stock
        public int AddStock(int quantity)
        {
            this.stock += quantity;
            return this.stock;
        }

        #endregion
    }
}
