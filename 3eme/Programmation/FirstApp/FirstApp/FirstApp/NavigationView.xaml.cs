using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

using Xamarin.Forms;
using Xamarin.Forms.Xaml;

namespace FirstApp.Droid
{
    [XamlCompilation(XamlCompilationOptions.Compile)]
    public partial class NavigationView : ContentPage
    {
        public NavigationView()
        {
            InitializeComponent();
        }

        private void GoToTabbedPage_Clicked(object sender, EventArgs e)
        {
            Navigation.PushAsync(new TabbedView());
        }
    }
}