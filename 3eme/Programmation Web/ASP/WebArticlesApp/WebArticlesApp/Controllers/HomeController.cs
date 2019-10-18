using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using WebArticlesApp.Models;

namespace WebArticlesApp.Controllers
{
    public class HomeController : Controller
    {
        Info2020Entities entities = new Info2020Entities();

        // GET: Home
        public ActionResult Index()
        {
            var result = entities.GetProducts().ToList();
            return View(result);
        }

        public ActionResult GetDetails(string id)
        {
            Guid resultID;

            if (!Guid.TryParse(id, out resultID)) return new HttpStatusCodeResult(System.Net.HttpStatusCode.BadRequest);

            try
            {
                var result = entities.GetProductById(resultID).ToList();
                return Json(result);
            } 
            catch(Exception e)
            {
                Console.WriteLine(e.Message);
            }

            return new HttpStatusCodeResult(System.Net.HttpStatusCode.NotFound);
        }
    }
}