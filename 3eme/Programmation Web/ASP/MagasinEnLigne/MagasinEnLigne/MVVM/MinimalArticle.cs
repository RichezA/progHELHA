using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace MagasinEnLigne.MVVM
{
    public class MinimalArticle
    {
        public System.Guid id { get; set; }
        public string nom { get; set; }
        public Nullable<int> quantite { get; set; }
        public Nullable<int> prixUnit { get; set; }
    }
}