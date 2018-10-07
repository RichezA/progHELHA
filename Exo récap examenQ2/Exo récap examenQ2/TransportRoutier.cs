using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Exo_récap_examenQ2
{
    class TransportRoutier:Transport
    {
        private static readonly int coefficientRoutier = 4;
        private static readonly double grosVolume = 10000.0;

        #region Ctor

        public TransportRoutier(double distance, List<Marchandise> marchandises) : base(distance, marchandises)
        {
            //VOID
        }

        #endregion

        #region Cost

        public override double CoutTotal()
        {
            double cout = base.CoutTotal();
            //On a le cout de base, maintenant, il faut calculer le coût spécifique au transport routier :
            cout *= coefficientRoutier;
            if (VolumeTotal() > grosVolume) cout *= coefficientGrosVolume;
            //grosVolume est un membre statique de la classe accessible en lecture seule au cas ou il faudrait le changer un jour
            //Le coefficient se trouve dans la classe mère en "protected" car on en a également besoin pour l'autre type de transport

            return cout;
        }

        #endregion
    }
}
