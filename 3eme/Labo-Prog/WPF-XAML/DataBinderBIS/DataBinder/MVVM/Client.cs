using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Runtime.CompilerServices;
using System.Text;
using System.Threading.Tasks;

namespace DataBinder.MVVM
{
    public class Client : INotifyPropertyChanged
    {
        private String _Nom;
        private String _Prenom;
        private String _Localite;

        public String Nom
        {
            get { return this._Nom; }
            set 
            { 
                this._Nom = value;
                this.OnPropertyRaised("Nom");
            }
        }
        public String Prenom
        {
            get { return this._Prenom; }
            set 
            { 
                this._Prenom = value; 
                this.OnPropertyRaised("Prenom");
            }
        }
        public String Localite
        {
            get { return this._Localite; }
            set 
            { 
                this._Localite = value; 
                this.OnPropertyRaised("Localite");
            }
        }

        public event PropertyChangedEventHandler PropertyChanged;

        private void NotifyPropertyChanged([CallerMemberName] String propertyName = "")
        {
            PropertyChanged?.Invoke(this, new PropertyChangedEventArgs(propertyName));
        }

        private void OnPropertyRaised(string PropertyName)
        {
            if(PropertyChanged != null)
            {
                PropertyChanged(this, new PropertyChangedEventArgs(PropertyName));
            }
        }
    }
}
