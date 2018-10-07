using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Interface
{
    class CompteBancaire:IComparable<CompteBancaire>
    {
        private float solde;
        private string nom;
    
        public CompteBancaire(float solde, string nom)
        {
            this.solde = solde;
            this.nom = nom;
        }

        public int CompareTo(object obj)
        {
            CompteBancaire ctmp = (CompteBancaire)obj;
            return this.solde.CompareTo(ctmp.solde);
        }

        public override string ToString()
        {
            return (this.nom + " : " + this.solde);
        }

        int IComparable<CompteBancaire>.CompareTo(CompteBancaire other)
        {
            return this.solde.CompareTo(other.solde);
        }
    }
}
