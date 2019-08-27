using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MonFramework
{
    public class CompteBancaire
    {
        public float solde { get; private set; }
        public string numeroCompte { get; private set; }

        public CompteBancaire(float solde, string numeroCompte)
        {
            this.solde = solde;
            this.numeroCompte = numeroCompte;
        }

        #region Méthodes

        public float Debit(float montant)
        {
            if (montant < solde) this.solde -= montant;
            else throw new SoldeInsuffisantException();

            return this.solde;
        }


        #endregion
    }

    public class SoldeInsuffisantException : ApplicationException
    {
        public SoldeInsuffisantException() : base() { }
        public SoldeInsuffisantException(string message) : base(message) { }
        public SoldeInsuffisantException(string message, Exception innerException) : base(message, innerException) { }

    }
}
