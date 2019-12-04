using Caching.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace Caching.Controllers
{
    public class HomeController : Controller
    {
        WebEssaiExamEntities MyEntity = new WebEssaiExamEntities();

        // GET: Home
        [OutputCache(Duration=10, VaryByCustom = "CheckVendeur", SqlDependency ="SqlCacheDependencyName:Vendeur")]
        public ActionResult Index(/*string id*/)
        {
            string path = Url.Action("Index");

            if (Request.Cookies["Id"] != null)
            {
                string id = Request.Cookies["Id"].Value;
                var result = (from vd in MyEntity.Vendeurs where vd.id.ToString() == id  select vd).FirstOrDefault();
                return View(result);
            }
            else
            {
                Response.RemoveOutputCacheItem(path);
                return View(new Vendeur());
            }
            

            //if (id != null)
            //{
            //    var result = (from vd in MyEntity.Vendeurs where vd.id.ToString() == Request.Cookies["Id"].Value select vd).FirstOrDefault();
            //    return View(result);
            //}
            //else
            //{
            //    return View(new Vendeur());
            //}
            
        }
    }
}