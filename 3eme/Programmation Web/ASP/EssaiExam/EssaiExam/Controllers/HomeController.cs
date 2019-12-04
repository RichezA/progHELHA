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
            HttpCookie httpCookie = Request.Cookies["data-filtering-cookie"];

            if (httpCookie != null)
            {
                string typeBien = httpCookie.Values["type-bien"].ToString();
                string localisation = httpCookie.Values["localisation"].ToString();
                string chmin = httpCookie.Values["chmin"].ToString();
                string chmax = httpCookie.Values["chmax"].ToString();

                if (!string.IsNullOrEmpty(typeBien) &&
                    !string.IsNullOrEmpty(localisation) &&
                    !string.IsNullOrEmpty(chmin) &&
                    !string.IsNullOrEmpty(chmax)
                    )
                {
                    return this.Index(new FilterSearch { selectionTypeBien = new Guid(typeBien), selectionLocalisation = new Guid(localisation), nbrChambreMin = int.Parse(chmin), nbrChambreMax = int.Parse(chmax) });
                }
            }
            this.setUpCatAndLocBoxes();
            return View(this.Buildings);
        }

        [HttpPost]
        public ActionResult Index(FilterSearch fSearch)
        {
            List<GetBuildingsByLocationANDnumbersOfRoomsANDTypeOfBuilding_Result> result;
            HttpCookie httpCookie;
            httpCookie = new HttpCookie("data-filtering-cookie");
            httpCookie.Values.Add("type-bien", fSearch.selectionTypeBien.ToString());
            httpCookie.Values.Add("localisation", fSearch.selectionLocalisation.ToString());
            httpCookie.Values.Add("chmin", fSearch.nbrChambreMin.ToString());
            httpCookie.Values.Add("chmax", fSearch.nbrChambreMax.ToString());
            httpCookie.Expires = DateTime.Now.AddHours(12);

            this.setUpCatAndLocBoxes();

            if (fSearch.nbrChambreMin == 0 || fSearch.nbrChambreMax == 0)
            {
                result = helper.GetBuildings(fSearch.selectionLocalisation, null, null, fSearch.selectionTypeBien);
            }
            else result = helper.GetBuildings(fSearch.selectionLocalisation, fSearch.nbrChambreMin, fSearch.nbrChambreMax, fSearch.selectionTypeBien);
            this.Buildings.Buildings = result;
            Response.Cookies.Add(httpCookie);

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
            }
            catch (Exception e)
            {

            }
            return Json(result);
        }

        private void setUpCatAndLocBoxes()
        {
            Buildings.CategoriesList = GetCategories();
            Buildings.LocationsList = GetLocalite();
        }

        private List<GetCategories_Result> GetCategories()
        {
            List<GetCategories_Result> catlist;
            if (HttpContext.Application["CatList"] != null)
            {
                catlist = HttpContext.Application["CatList"] as List<GetCategories_Result>;
            }
            else
            {
                catlist = helper.GetCategories();
                HttpContext.Application["CatList"] = catlist;
            }

            return catlist;
        }

        private List<GetDistinctLocalite_Result> GetLocalite()
        {
            List<GetDistinctLocalite_Result> loclist;
            if (HttpContext.Application["LocList"] != null)
            {
                loclist = HttpContext.Application["LocList"] as List<GetDistinctLocalite_Result>;
            }
            else
            {
                loclist = helper.GetLocations();
                HttpContext.Application["LocList"] = loclist;
            }

            return loclist;
        }
    }
}