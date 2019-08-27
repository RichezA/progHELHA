using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Tri_LIFO_classes_génériques
{
    class Pile<T> //Classe générique, on peut l'adapter à n'importe quel type
    {
        #region Membres

        private T[] tab; //Déclaration d'un tableau générique
        private int taillePile;
        private int indiceActuel;

        #endregion
        

        #region Propriétés

        public int Count
        {
            get { return this.indiceActuel; }
        }

        #endregion


        #region Constructeur

        public Pile(int taillePile)
        {
            this.taillePile = taillePile;
            this.indiceActuel = 0;
            this.tab = new T[taillePile];
        }

        #endregion 
        //On lui donne juste la taille de la pile

        #region Méthodes de gestion de la pile

        public void Push(T element)
        {
            if (this.indiceActuel < this.taillePile) //S'il reste de la place dans la pile
            {
                this.tab[this.indiceActuel] = element;
                this.indiceActuel++;
            }
            else throw new Exception("Pile pleine"); 
        }

        public T Pop()
        {
            T elementARetourner;

            if (this.indiceActuel > 0)
            {
                elementARetourner = this.tab[indiceActuel - 1];
                this.indiceActuel--;
                return elementARetourner;
            }
            else throw new Exception("La pile est vide, il est impossible de retirer quelque chose !");
        }

        public void ClearStack() //Pour vider la pile
        {
            this.indiceActuel = 0;
            //Comme on se base sur l'indice pour push et pop du tableau, on met l'indice à 0 
        }

        #endregion
    }
}
