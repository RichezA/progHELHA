using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace EssaiExam.Models
{
    public class EntityProceduresHelper
    {
        private WebEssaiExamEntities entities;

        public EntityProceduresHelper()
        {
            this.entities = new WebEssaiExamEntities();
        }

        public List<GetCategories_Result> GetCategories()
        {
            //List<GetCategories_Result> response = entities.GetCategories().ToList();
            return entities.GetCategories().ToList();
        }

        public List<GetDistinctLocalite_Result> GetLocations()
        {
            return entities.GetDistinctLocalite().ToList();
        }

        public List<GetBuildingsByLocationANDnumbersOfRoomsANDTypeOfBuilding_Result> GetBuildings(Guid locationId, Nullable<int> minRooms, Nullable<int> maxRooms, Guid buildingType)
        {
            return entities.GetBuildingsByLocationANDnumbersOfRoomsANDTypeOfBuilding(locationId, minRooms, maxRooms, buildingType).ToList();
        }

        public String GetDetails(Guid buildingID)
        {
            var result = entities.GetDescriptionFromId(buildingID).ToList();
            return result.First();
        }
    }
}