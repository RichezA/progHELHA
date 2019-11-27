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
        EntityProceduresHelper helper = new EntityProceduresHelper();
        public ActionResult Index()
        {
            return View(this.Buildings);
        }

        [HttpPost]
        public ActionResult Index(FilterSearch fSearch)
        {


            List<GetBuildingsByLocationANDnumbersOfRoomsANDTypeOfBuilding_Result> result;
            if (fSearch.nbrChambreMin == 0 || fSearch.nbrChambreMax == 0)
            {
                result = helper.GetBuildings(fSearch.selectionLocalisation, null, null, fSearch.selectionTypeBien);
            }
            else result = helper.GetBuildings(fSearch.selectionLocalisation, fSearch.nbrChambreMin, fSearch.nbrChambreMax, fSearch.selectionTypeBien);
            this.Buildings.Buildings = result;

            return View(this.Buildings);
        }

        [HttpPost]
        public ActionResult GetBuildings()
        {
            FilterSearch fSearch;

            Stream req = Request.InputStream;
            req.Seek(0, System.IO.SeekOrigin.Begin);
            string json = new StreamReader(req).ReadToEnd();

            try
            {
                fSearch = JsonConvert.DeserializeObject<FilterSearch>(json);

                if (fSearch.nbrChambreMin == 0 || fSearch.nbrChambreMax == 0) this.Buildings.Buildings = helper.GetBuildings(fSearch.selectionLocalisation, null, null, fSearch.selectionTypeBien);
                else this.Buildings.Buildings = helper.GetBuildings(fSearch.selectionLocalisation, fSearch.nbrChambreMin, fSearch.nbrChambreMax, fSearch.selectionTypeBien);
            }
            catch (JsonException e)
            {
                return new HttpStatusCodeResult(System.Net.HttpStatusCode.ExpectationFailed);
            }
            return PartialView("_Houses", this.Buildings);
        }

        [HttpPost]
        public ActionResult GetDetails()
        {
            string json;
            Stream req = Request.InputStream;
            req.Seek(0, SeekOrigin.Begin);
            json = new StreamReader(req).ReadToEnd();
            string result = "";

            try
            {
                result = helper.GetDetails(Guid.Parse(json));
            }catch(Exception e)
            {

            }
            return Json(result);
        }
    }
}