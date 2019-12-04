using System;
using System.Collections.Generic;
using System.Configuration;
using System.Data.SqlClient;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using System.Web.Routing;

namespace Caching
{
    public class MvcApplication : System.Web.HttpApplication
    {
        protected void Application_Start()
        {
            AreaRegistration.RegisterAllAreas();
            RouteConfig.RegisterRoutes(RouteTable.Routes);
            //SqlDependency.Start(ConfigurationManager.ConnectionStrings["DefaultConnection"].ConnectionString);
        }

        public override string GetVaryByCustomString(HttpContext context, string custom)
        {
            if (custom == "CheckVendeur")
            {
                if (context.Request.Cookies["Id"] != null)
                {
                    return context.Request.Cookies["Id"].Value;
                }
                else
                {
                    return base.GetVaryByCustomString(context, custom);
                }
            }
            return base.GetVaryByCustomString(context, custom);
        }
    }
}
