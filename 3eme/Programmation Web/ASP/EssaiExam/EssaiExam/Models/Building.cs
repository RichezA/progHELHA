using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace EssaiExam.Models
{
    public class Building
    {
        private List<GetBuildingsByLocationANDnumbersOfRoomsANDTypeOfBuilding_Result> _Buildings;
        private List<GetCategories_Result> _CategoriesList;
        private List<GetDistinctLocalite_Result> _LocationsList;

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

        public List<GetCategories_Result> CategoriesList
        {
            get
            {
                return this._CategoriesList;
            }
            set
            {
                this._CategoriesList = value;
            }
        }
        public List<GetDistinctLocalite_Result> LocationsList
        {
            get
            {
                return this._LocationsList;
            }
            set
            {
                this._LocationsList = value;
            }
        }


        public Building()
        {
            Buildings = new List<GetBuildingsByLocationANDnumbersOfRoomsANDTypeOfBuilding_Result>();
        }
    }
}