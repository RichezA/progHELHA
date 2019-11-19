using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace EssaiExam.Models
{
    public class Building
    {
        private List<GetBuildingsByLocationANDnumbersOfRoomsANDTypeOfBuilding_Result> _Buildings;

        public List<GetBuildingsByLocationANDnumbersOfRoomsANDTypeOfBuilding_Result> Buildings
        {
            get
            {
                return this._Buildings;
            }
            set
            {
                this._Buildings = value;
            }
        }


        public Building()
        {
            Buildings = new List<GetBuildingsByLocationANDnumbersOfRoomsANDTypeOfBuilding_Result>();
        }
    }
}