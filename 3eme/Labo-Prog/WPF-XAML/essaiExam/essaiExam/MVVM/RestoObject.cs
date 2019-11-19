using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.ComponentModel;
using System.Linq;
using System.Runtime.CompilerServices;
using System.Text;
using System.Threading.Tasks;

namespace essaiExam.MVVM
{
    public class RestoObject : INotifyPropertyChanged
    {
        private ObservableCollection<getRestauFromCatId_Result> _Restaurants;
        private ObservableCollection<getRestauCategories_Result> _Categories;
        private ObservableCollection<getCommentsByRestoId_Result> _Comments;

        public getRestauCategories_Result DefaultCategory = new getRestauCategories_Result { CategorieId = Guid.Empty, Nom = "Toutes" };
        
        public ObservableCollection<getRestauFromCatId_Result> Restaurants
        {
            get
            {
                return this._Restaurants;
            }
            set
            {
                this._Restaurants = value;
                NotifyPropertyChanged("Restaurants");
            }
        }

        public ObservableCollection<getRestauCategories_Result> Categories
        {
            get
            {
                return this._Categories;
            }
            set
            {
                this._Categories = value;
                NotifyPropertyChanged("Categories");
            }
        }

        public ObservableCollection<getCommentsByRestoId_Result> Comments
        {
            get
            {
                return this._Comments;
            }
            set
            {
                this._Comments = value;
                NotifyPropertyChanged("Comments");
            }
        }

        public RestoObject()
        {
            this._Restaurants = new ObservableCollection<getRestauFromCatId_Result>();
            this._Categories = new ObservableCollection<getRestauCategories_Result>();
            this._Comments = new ObservableCollection<getCommentsByRestoId_Result>();
        }

        public event PropertyChangedEventHandler PropertyChanged;

        private void NotifyPropertyChanged([CallerMemberName] String propertyName = "")
        {
            PropertyChanged?.Invoke(this, new PropertyChangedEventArgs(propertyName));
        }
    }
}
