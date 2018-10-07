using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Exo_pré_examen
{
    class TransportRoutier:Transport
    {
        private static double facteurDeCoutTransportRoutier = 4.0;
        //Avant, on était obligés d'utiliser un constructeur statique et on ne pouvait pas initialiser de cette manière le membre statique

        #region Ctor

        public TransportRoutier(double distance) : base(distance)
        {
            //Rien à mettre car on a injecté dans la classe de base dont on hérite
        }

        #endregion

        #region Méthodes

        public override double Cout()
        {
            double cout = base.Cout() * facteurDeCoutTransportRoutier;

            if (this.GetTotalVolume() > 1000.0) cout *= 1.5;

            return cout;
        }
        #endregion
    }
}
