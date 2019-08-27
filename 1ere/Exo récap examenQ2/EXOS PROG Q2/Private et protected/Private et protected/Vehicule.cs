using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Private_et_protected
{
    abstract class Vehicule
    {
        public string marque;
        private int cylindree;
        protected int annee;

        public int GetCylindree()
        {
            return 1000;
        }

        public abstract int GetAnnee()
        {

        }
    }
}
