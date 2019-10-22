using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace LayoutPages.Controllers
{
    public class HomeController : Controller
    {
        // GET: Home
        [OutputCache(Duration = 3600 /*, VaryByParam = "all"*/)]
        public ActionResult Index(string id)
        {
            if (id == null) id = "Not logged in";
            ViewBag.nom = id;
            return View();
        }
    }
}