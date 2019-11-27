using EssaiExam.Models;
using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace EssaiExam.Controllers
{
    public class HomeController : Controller
    {

        // GET: Home
        Building Buildings = new Building();
        public ActionResult Index()
        {
            return View(this.Buildings);
        }

        [HttpPost]
        public ActionResult Index(FilterSearch fSearch)
        {
      
            EntityProceduresHelper helper = new EntityProceduresHelper();
            List<GetBuildingsByLocationANDnumbersOfRoomsANDTypeOfBuilding_Result> result;
            if(fSearch.nbrChambreMin == 0 || fSearch.nbrChambreMax == 0)
            {
                result = helper.GetBuildings(fSearch.selectionLocalisation, null, null, fSearch.selectionTypeBien);
            }
            else result = helper.GetBuildings(fSearch.selectionLocalisation, fSearch.nbrChambreMin, fSearch.nbrChambreMax, fSearch.selectionTypeBien);
            this.Buildings.Buildings = result;
            
            return View(this.Buildings);
        }
    }
}