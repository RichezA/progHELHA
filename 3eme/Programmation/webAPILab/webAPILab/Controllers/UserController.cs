using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;

namespace webAPILab.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class UserController : ControllerBase
    {
        [HttpGet]
        public ActionResult<IEnumerable<User>> getSampleUser()
        {
            return new[]
            {
                new User { id = 1, nom = "Richez", prenom = "Antoine" },
                new User { id = 2, nom = "Dudziak", prenom = "Thomas" }
            };
        }

    }
}