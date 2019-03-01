using Microsoft.VisualStudio.TestTools.UnitTesting;
using MonFramework;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MonFramework.Tests
{
    [TestClass()]
    public class CompteBancaireTests
    {
        [TestMethod()]
        public void CompteBancaireTest()
        {
            //Assert.Fail();
        }

        [TestMethod()]
        public void DebitTest()
        {
            //Arrange :
            float soldeInit = 100.0F;
            float montantADebiter = 20.0F;
            float soldeRestant = 80.0F;

            var compte = new CompteBancaire(soldeInit, "xxxx");

            //Act :
            float resultat = compte.Debit(montantADebiter);

            //Assert :
            Assert.AreEqual(soldeRestant, resultat);
        }

        [TestMethod()]
        [ExpectedException(typeof(SoldeInsuffisantException))]
        public void DebitSoldeInsuffisant()
        {
            //Arrange :
            float soldeInit = 100.0F;
            float montantADebiter = 110.0F;

            var compte = new CompteBancaire(soldeInit, "xxxx");

            //Act :
            float resultat = compte.Debit(montantADebiter);
        }

        [TestMethod()]
        [Timeout(2000)]
        public void BoucleSansFin()
        {
            while (true) { }
            Assert.AreEqual(10, 10);
        }
    }
}