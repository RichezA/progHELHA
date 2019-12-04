using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Runtime.CompilerServices;
using System.Text;
using System.Threading.Tasks;

namespace RegistryAuthentication.Models
{
    public class User : INotifyPropertyChanged
    {
        private String _Username;
        private String _Password;

        public String Username 
        {
            get
            {
                return this._Username;
            }
            set
            {
                this._Username = value;
                NotifyPropertyChanged("Username");
            }
        }

        public String Password
        {
            get
            {
                return this._Password;
            }
            set
            {
                this._Password = value;
                NotifyPropertyChanged("Password");
            }
        }

        public event PropertyChangedEventHandler PropertyChanged;

        private void NotifyPropertyChanged([CallerMemberName] String propertyName = "")
        {
            PropertyChanged?.Invoke(this, new PropertyChangedEventArgs(propertyName));
        }
    }
}
