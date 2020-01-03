using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Runtime.CompilerServices;
using System.Web;

namespace MagasinEnLigne.MVVM
{
    public class MVVM : INotifyPropertyChanged
    {
        private List<Article> _Articles;

        public List<Article> Articles
        {
            get
            {
                return this._Articles;
            }

            set
            {
                this._Articles = value;
                OnPropertyChanged();
            }
        }

        public event PropertyChangedEventHandler PropertyChanged;
        private void OnPropertyChanged([CallerMemberName]string propertyName = "")
        {
            PropertyChanged?.Invoke(this, new PropertyChangedEventArgs(propertyName));
        }

        public MVVM()
        {
            this._Articles = new List<Article>();
        }
    }
}