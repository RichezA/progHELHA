using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using System.Web.Routing;

namespace anotherWebApp
{
    public class RouteConfig
    {
        public static void RegisterRoutes(RouteCollection routes)
        {
            routes.IgnoreRoute("{resource}.axd/{*pathInfo}");

            routes.MapRoute(
                name: "Default",
                url: "{controller}/{action}/{id}",
                defaults: new { controller = "Home", action = "Index", id = UrlParameter.Optional }//,
                //constraints: new { id = @"^\d{1,4}$", action = "^getinfo$" }
            );
            //routes.MapRoute(
            //    name: "Default1",
            //    url: "{controller}/{action}",
            //    defaults: new { controller = "Home", action = "Index" },
            //    constraints: new { action = @"^index$" }
            //    );
        }
    }
}
