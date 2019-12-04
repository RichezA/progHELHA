using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace ExoAuthentificationASP.Models
{
    public class Identite
    {
        [Required]
        [Display(Name = "Nom d'utilisateur")]
        public String Username { get; set; }
        [Required]
        [Display(Name = "Mot de passe")]
        [DataType(DataType.Password)]
        public String Password { get; set; }
        [Required]
        [EmailAddress]
        [Display(Name = "Email")]
        public String Email { get; set; }
        [Required]
        [System.ComponentModel.DataAnnotations.Compare("Email", ErrorMessage = "Veuillez avoir la même adresse mail")]
        [Display(Name = "Confirmez l'email")]
        [EmailAddress]
        public String ConfirmedEmail { get; set; }
        [Required]
        [Display(Name = "Ecrivez le même captcha")]
        [Remote("IsCaptchaCorrect", "Home", HttpMethod = "GET", ErrorMessage = "Captcha is invalid")]
        public String clientCaptcha { get; set; }
    }
}