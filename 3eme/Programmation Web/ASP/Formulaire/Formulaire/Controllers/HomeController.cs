using Formulaire.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace Formulaire.Controllers
{
    public class HomeController : Controller
    {
        // GET: Home
        public ActionResult Index()
        {
            return View();
        }

        [HttpPost]
        public ActionResult Login(AuthInfo info)
        {
            Info2020Entities2 myModel = new Info2020Entities2();
            var resultat = myModel.LoginVerify(info.userID, info.passwd).ToList();
            if (resultat[0].Value == 0)
            {
                info.passwd = string.Empty;
                return View(info);
            }
            else
            {
                return View("index");
            }
        }

        [HttpGet]
        public ActionResult Login()
        {
            AuthInfo authinfo = new AuthInfo();
            authinfo.userID = string.Empty;
            return View(authinfo);
        }
    }
}