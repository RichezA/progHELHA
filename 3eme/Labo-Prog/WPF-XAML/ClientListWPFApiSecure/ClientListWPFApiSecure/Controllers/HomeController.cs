using ClientListWPFApiSecure.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Http;
using System.Web.Http.Results;
using System.Web.Mvc;

namespace ClientListWPFApiSecure.Controllers
{
    public class UsersController : ApiController
    {
        // GET: Users
        public JsonResult<List<User>> Get()
        {
            Info2020bisEntities entity = new Info2020bisEntities();
            var Users = (from user in entity.Users select user).ToList();
            return Json(Users);
        }
    }
}