using ClientListWPFApiSecure.Models;
using Microsoft.Win32;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;
using System.Web.Http.Results;

namespace ClientListWPFApiSecure.Controllers
{
    [Authorize]
    public class LoginController : ApiController
    {
        // GET api/<controller>
        public IEnumerable<string> Get()
        {
            return new string[] { "value1", "value2" };
        }

        // GET api/<controller>/5
        public string Get(int id)
        {
            return "value";
        }

        // POST api/<controller>
        [Authorize]
        public JsonResult<Boolean> Post([FromBody]UserCredentials user)
        {
            RegistryKey SoftKey = Registry.CurrentUser.OpenSubKey("Software", true);
            RegistryKey InfoKey = SoftKey.CreateSubKey("Info2020");
            RegistryKey UserKey = InfoKey.OpenSubKey(user.Username);

            if (UserKey != null)
            {
                return Json(UserKey.GetValue("Password", string.Empty).ToString() == user.Password);
            }
            return Json(false);
        }

        // PUT api/<controller>/5
        public void Put(int id, [FromBody]string value)
        {
        }

        // DELETE api/<controller>/5
        public void Delete(int id)
        {
        }
    }
}