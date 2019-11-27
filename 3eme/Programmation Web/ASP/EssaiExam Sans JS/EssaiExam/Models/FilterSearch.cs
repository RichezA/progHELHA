using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace EssaiExam.Models
{
    public class FilterSearch
    {
        public Guid selectionTypeBien { get; set; }
        public Guid selectionLocalisation { get; set; }
        public int nbrChambreMin { get; set; }
        public int nbrChambreMax { get; set; }
    }
}