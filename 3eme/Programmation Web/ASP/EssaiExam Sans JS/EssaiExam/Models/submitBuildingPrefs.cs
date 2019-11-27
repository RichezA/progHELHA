using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace EssaiExam.Models
{
    public class SubmitBuildingPrefs
    {
        public Guid locationId { get; set; }
        public int minRoom { get; set; }
        public int maxRooms { get; set; }
        public Guid buildingType { get; set; }
    }
}