using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

using Xamarin.Forms;
using Xamarin.Forms.Xaml;

namespace GetYourFaceOnMyApp
{
    [XamlCompilation(XamlCompilationOptions.Compile)]
    public partial class DetailedPage : ContentPage
    {
        public User chosenUser { get; set; }
        public DetailedPage(User user)
        {
            InitializeComponent();
            this.chosenUser = user;
            this.BindingContext = chosenUser;
        }
    }
}