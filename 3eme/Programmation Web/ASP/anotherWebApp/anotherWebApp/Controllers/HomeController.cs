using anotherWebApp.Models;
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

        public JsonResult GetInfo(string id)
        {
            int intID;
            Info2020Entities entity = new Info2020Entities();

            if (!int.TryParse(id, out intID)) throw new HttpResponseException(System.Net.HttpStatusCode.BadRequest);
            var result = entity.GetWebUserInfo(intID).ToList();
            if (result.Count == 0) throw new HttpResponseException(System.Net.HttpStatusCode.NotFound);

            return Json(result, JsonRequestBehavior.AllowGet);
        }


        /*
         * Validation de l'input
         * Requête ajax pour valider l'id et envoyer le formulaire
         * Récupération de données
         */
    }
}