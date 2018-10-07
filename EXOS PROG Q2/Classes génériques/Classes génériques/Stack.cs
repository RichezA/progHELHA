using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Classes_génériques
{
    class Stack<T> //Le <T> permet la création d'une classe générique.
    {
        private T[] tab;
        private int nbElements;

        public Stack(int nbElements)
        {
            this.nbElements = nbElements;
            tab = new T[nbElements];
        }
    }
}
