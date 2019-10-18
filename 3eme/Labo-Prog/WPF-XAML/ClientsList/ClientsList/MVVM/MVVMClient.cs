using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ClientsList.MVVM
{
    class MVVMClient : INotifyPropertyChanged
    {
        private GetXAMLClientByInfo_Result _CurrentClient;

        public GetXAMLClientByInfo_Result CurrentClient
        {
            get
            {
                return this._CurrentClient;
            }
            set
            {
                this._CurrentClient = value;
                OnPropertyRaised("CurrentClient");
            }
        }

        public MVVMClient()
        {
            CurrentClient = new GetXAMLClientByInfo_Result();
        }

        

        public event PropertyChangedEventHandler PropertyChanged;
        private void OnPropertyRaised(string PropertyName)
        {
            if (PropertyChanged != null)
            {
                PropertyChanged(this, new PropertyChangedEventArgs(PropertyName));
            }
        }
    }
}
