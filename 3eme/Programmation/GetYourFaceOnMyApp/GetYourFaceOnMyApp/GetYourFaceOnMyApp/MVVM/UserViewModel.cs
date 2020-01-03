using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.ComponentModel;
using System.Runtime.CompilerServices;
using System.Text;
using System.Threading.Tasks;
using Xamarin.Forms;

namespace GetYourFaceOnMyApp.MVVM
{
    public class UserViewModel : INotifyPropertyChanged
    {
        public event PropertyChangedEventHandler PropertyChanged;

        private ObservableCollection<User> _Users;
        private ObservableCollection<ImageSource> _Images;
        private ObservableCollection<Tuple<User, ImageSource>> _UsersData;

        public ObservableCollection<User> Users
        {
            get
            {
                return this._Users;
            }
            set
            {
                this._Users = value;
                OnPropertyChanged("Users");
            }
        }

        public ObservableCollection<ImageSource> Images
        {
            get
            {
                return this._Images;
            }
            set
            {
                this._Images = value;
                OnPropertyChanged("Images");
            }
        }

        public ObservableCollection<Tuple<User, ImageSource>> UsersData 
        {
            get
            {
                return this._UsersData;
            }
            set
            {
                this._UsersData = value;
                OnPropertyChanged("UsersData");
            }
        }

        public UserViewModel()
        {
            this.Images = new ObservableCollection<ImageSource>();
            this.UsersData = new ObservableCollection<Tuple<User, ImageSource>>();
        }

        protected virtual void OnPropertyChanged([CallerMemberName] string propertyName = null)
        {
            PropertyChanged?.Invoke(this, new PropertyChangedEventArgs(propertyName));
        }
    }
}
