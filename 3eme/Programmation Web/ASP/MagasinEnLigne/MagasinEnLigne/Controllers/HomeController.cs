using MagasinEnLigne.MVVM;
using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace MagasinEnLigne.Controllers
{
    public class HomeController : Controller
    {
        public MVVM.MVVM Articles { get; set; }
        private WebEssaiExamEntities entity = new WebEssaiExamEntities();
        // GET: Home
        public ActionResult Index()
        {
            Articles = new MVVM.MVVM();
            //Articles.Articles = entity.GetArticles().ToList();
            Articles.Articles = (from articles in entity.Articles select articles).ToList();
            return View(Articles);
        }

        public ActionResult GetImage(string articleID)
        {
            Guid idArticle;

            if (Guid.TryParse(articleID, out idArticle))
            {
                var imgSrc = (from article in entity.Articles where article.id == idArticle select article.photo).ToList().First();
                return File(imgSrc, "image/png");
            }
            return null;
        }

        public ActionResult GetCookieInfo()
        {
            if(Request.Cookies["articles-cache"] != null)
            {
                string infos = Request.Cookies["articles-cache"].Value;
                var result= JsonConvert.SerializeObject(infos);
            }
            return null;
        }
    }
}