using Microsoft.Owin.Security.OAuth;
using Microsoft.Win32;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Security.Claims;
using System.Threading.Tasks;
using System.Web;
using System.Web.Http.Cors;

namespace ClientListWPFApiSecure.Models
{
    [EnableCors(origins: "*", headers: "*", methods: "*")]
    public class ApplicationAuthProvider : OAuthAuthorizationServerProvider
    {
        public override async Task ValidateClientAuthentication(OAuthValidateClientAuthenticationContext context)
        {
            context.Validated();
        }
        public override async Task GrantResourceOwnerCredentials(OAuthGrantResourceOwnerCredentialsContext context)
        {
            bool Valid = ValidateCredentials(context);
            if (Valid)
            {
                var identity = new ClaimsIdentity(context.Options.AuthenticationType);
                identity.AddClaim(new Claim("Username", context.UserName));
                identity.AddClaim(new Claim("Password", context.Password));
                context.Validated(identity);
            }
            else
            {
                context.SetError("invalid_grant", "The user name or password is      incorrect.");
                return;
            }
        }

        private bool ValidateCredentials(OAuthGrantResourceOwnerCredentialsContext context)
        {
            RegistryKey SoftKey = Registry.CurrentUser.OpenSubKey("Software", true);
            RegistryKey InfoKey = SoftKey.CreateSubKey("Info2020");
            RegistryKey UserKey = InfoKey.OpenSubKey(context.UserName);

            if (UserKey != null)
            {
                return UserKey.GetValue("Password", string.Empty).ToString() == context.Password;
            }
            return false;
        }
    }
}