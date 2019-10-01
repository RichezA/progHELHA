using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace anotherForm.Controllers
{
    public class HomeController : Controller
    {
        // GET: Home
        [HttpGet]
        public ActionResult Index()
        {
            return View();
        }

        [HttpPost]
        public ActionResult Index(String Compteur)
        {
            int data;
            if (int.TryParse(Compteur, out data) == false) ViewData["Message"] = "La donnée fournie n'est pas un entier";
            else ViewData["Message"] = "Donnée correcte!! Bravo";
            return View();
        }
    }
}