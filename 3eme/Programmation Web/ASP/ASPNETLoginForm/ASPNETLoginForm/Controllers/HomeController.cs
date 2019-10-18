using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using ASPNETLoginForm.Models;

namespace ASPNETLoginForm.Controllers
{
    public class HomeController : Controller
    {
        // GET: Home
        public ActionResult Index()
        {
            return View();
        }

        [HttpGet]
        public ActionResult Enregistrement()
        {
            Identity identity = new Identity();
            return View(identity);
        }

        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Enregistrement(Identity identity)
        {
            if (ModelState.IsValid) return RedirectToAction("Index");
            return View(identity);
        }
    }
}