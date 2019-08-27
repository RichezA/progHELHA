using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Exo_récap_examenQ2
{
    class TransportAerien:Transport
    {
        private static readonly int coefficientAerien;
        private static readonly double grosVolume;

        #region Ctor

        static TransportAerien()
        {
            coefficientAerien = 10;
            grosVolume = 5000.0;
        }

        public TransportAerien(double distance, List<Marchandise> marchandises) : base(distance, marchandises)
        {
            //VOID
        }

        #endregion

        #region Transport cost

        public override double CoutTotal()
        {
            double cout = base.CoutTotal();
            //Cout de base, maintenant, on procède au calcul spécifique à l'aérien :
            cout *= coefficientAerien;
            if (VolumeTotal() > grosVolume) cout *= coefficientGrosVolume;
            //grosVolume est un membre statique que l'on peut changer facilement sans devoir toucher à la méthode
            //coefficientGrosVolume se trouve en "protected" dans la classe mère car on en a aussi besoin dans le transport routier

            return cout;
        }

        #endregion
    }
}
