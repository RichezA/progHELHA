using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Runtime.CompilerServices;
using System.Text;
using System.Threading.Tasks;

namespace ClientListWPF.MVVM
{
    public class UserData : INotifyPropertyChanged
    {
        private Guid _UserID;
        private String _FirstName;
        private String _LastName;

        public Guid UserId 
        {
            get
            {
                return this._UserID;
            }
            set
            {
                this._UserID = value;
                NotifyPropertyChanged();
            }
        }
        public String FirstName 
        {
            get
            {
                return this._FirstName;
            }
            set
            {
                this._FirstName = value;
                NotifyPropertyChanged();
            }
        }
        public String LastName
        {
            get
            {
                return this._LastName;
            }
            set
            {
                this._LastName = value;
                NotifyPropertyChanged();
            }
        }

        public event PropertyChangedEventHandler PropertyChanged;

        public void NotifyPropertyChanged([CallerMemberName] String propertyName = "")
        {
            PropertyChanged?.Invoke(this, new PropertyChangedEventArgs(propertyName));
        }
    }
}
