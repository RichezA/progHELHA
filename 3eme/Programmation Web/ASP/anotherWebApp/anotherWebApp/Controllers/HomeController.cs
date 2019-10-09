using anotherWebApp.Models;
using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Http;
using System.Web.Mvc;

namespace anotherWebApp.Controllers
{
    public class HomeController : Controller
    {
        // GET: Home
        public ActionResult Index()
        {
            return View();
        }

        [System.Web.Mvc.HttpGet]
        public ActionResult GetInfo(string id)
        {
            int intID;
            Info2020Entities entity = new Info2020Entities();

            if (!int.TryParse(id, out intID)) throw new HttpResponseException(System.Net.HttpStatusCode.BadRequest);
            var result = entity.GetWebUserInfo(intID).ToList();
            if (result.Count != 0) return Json(result[0], JsonRequestBehavior.AllowGet);
            else return new HttpStatusCodeResult(System.Net.HttpStatusCode.NotFound);
        }

        [System.Web.Mvc.HttpPost]
        public ActionResult GetInfo2([FromBody] string result)
        {
            var json = JsonConvert.SerializeObject(result);
            return Json(json);
        }

        /*
         * Validation de l'input
         * Requête ajax pour valider l'id et envoyer le formulaire
         * Récupération de données
         */
    }
}