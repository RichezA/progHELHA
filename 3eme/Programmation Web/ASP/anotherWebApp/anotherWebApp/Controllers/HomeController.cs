using anotherWebApp.Models;
using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Web;
using System.Web.Http;
using System.Web.Mvc;

namespace anotherWebApp.Controllers
{
    public class HomeController : Controller
    {
        Info2020Entities entity = new Info2020Entities();
        // GET: Home
        public ActionResult Index()
        {
            return View();
        }

        [System.Web.Mvc.HttpGet]
        public ActionResult GetInfo(string id)
        {
            int intID;

            if (!int.TryParse(id, out intID)) throw new HttpResponseException(System.Net.HttpStatusCode.BadRequest);
            var result = entity.GetWebUserInfo(intID).ToList();
            if (result.Count != 0) return Json(result[0], JsonRequestBehavior.AllowGet);
            else return new HttpStatusCodeResult(System.Net.HttpStatusCode.NotFound);
        }

        [System.Web.Mvc.HttpPost]
        public ActionResult GetInfo2()
        {
            Stream req = Request.InputStream;
            req.Seek(0, System.IO.SeekOrigin.Begin);
            string json = new StreamReader(req).ReadToEnd();

            GetWebUserInfo_Result result = new GetWebUserInfo_Result();
            
            try
            {
                result = JsonConvert.DeserializeObject<GetWebUserInfo_Result>(json);

                var res = entity.CheckClient(result.nom, result.prenom).ToList();
                if (res[0] == 0) return new HttpStatusCodeResult(System.Net.HttpStatusCode.NotFound);
                else if (res[0]  > 1) return new HttpStatusCodeResult(System.Net.HttpStatusCode.Ambiguous);
            }
            catch(Exception e)
            {
                Console.WriteLine(e.Message);
                return new HttpStatusCodeResult(System.Net.HttpStatusCode.InternalServerError);
            }
            return Json(result);
        }

        /*
         * Validation de l'input
         * Requête ajax pour valider l'id et envoyer le formulaire
         * Récupération de données
         */
    }
}