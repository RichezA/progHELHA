using customErrors.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace customErrors.Controllers
{
    public class HomeController : Controller
    {
        // GET: Home
        public ActionResult Index()
        {
            Info2020Entities entity = new Info2020Entities();

            var result = (from user in entity.Users select user).ToList<User>();
            return View();
        }
    }
}