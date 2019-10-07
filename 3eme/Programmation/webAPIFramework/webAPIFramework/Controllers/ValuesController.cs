using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;
using System.Web.Http.Results;
using webAPIFramework.Models;

namespace webAPIFramework.Controllers
{
    public class ValuesController : ApiController
    {
        // GET api/values
        public IEnumerable<string> Get()
        {
            return new string[] { "value1", "value2" };
        }

        // GET api/values/5
        public JsonResult<getUserById_Result> Get(string id)
        {
            //User user = null;
            int userId;
            Info2020Entities MyEntities = new Info2020Entities();

            if (!int.TryParse(id, out userId)) throw new HttpResponseException(HttpStatusCode.BadRequest);
            var result = MyEntities.getUserById(int.Parse(id)).ToList();
            if (result.Count == 0) throw new HttpResponseException(HttpStatusCode.NotFound);

            return Json(result.First());
        }

        // POST api/values
        public void Post([FromBody]string value)
        {
        }

        // PUT api/values/5
        public void Put(int id, [FromBody]string value)
        {
        }

        // DELETE api/values/5
        public void Delete(int id)
        {
        }
    }
}
