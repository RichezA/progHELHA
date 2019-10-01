using exoNameIs.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace exoNameIs.Controllers
{
    public class HomeController : Controller
    {
        // GET: Home
        [HttpGet]
        public ActionResult Index()
        {
            Identity idt = new Identity(); 
            return View(idt);
        }

        // ValidateInput set à false permet à notre application de ne pas vérifier le contenu des objets envoyés
        [HttpPost, ValidateInput(false)]
        public ActionResult Index(Identity identity)
        {
            return View(identity);
        }
    }
}