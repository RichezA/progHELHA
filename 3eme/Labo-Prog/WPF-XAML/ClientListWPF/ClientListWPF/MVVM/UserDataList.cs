using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.ComponentModel;
using System.Linq;
using System.Runtime.CompilerServices;
using System.Text;
using System.Threading.Tasks;

namespace ClientListWPF.MVVM
{
    public class UserDataList : INotifyPropertyChanged
    {
        private ObservableCollection<UserData> _Users;

        public ObservableCollection<UserData> Users
        {
            get
            {
                return this._Users;
            }
            set
            {
                this._Users = value;
                NotifyPropertyChanged();
            }
        }

        public event PropertyChangedEventHandler PropertyChanged;

        private void NotifyPropertyChanged([CallerMemberName] string propertyName = "")
        {
            PropertyChanged?.Invoke(this, new PropertyChangedEventArgs(propertyName));
        }
    }
}
