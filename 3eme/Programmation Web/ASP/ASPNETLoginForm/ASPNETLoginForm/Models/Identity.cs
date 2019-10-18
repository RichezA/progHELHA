using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace ASPNETLoginForm.Models
{
    public class Identity
    {
        [Required]
        [Display(Name = "Nom")]
        public String Username { get; set; }

        [Required]
        [Display(Name = "Email")]
        // ^(\w + [-\.]*)*(\w+)@(\w+\.)+(\w+)$
        [RegularExpression(@"^(.+@+.+\.+[a-z]+)$")]
        public String Email { get; set; }

    }
}