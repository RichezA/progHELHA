using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

using Xamarin.Forms;
using Xamarin.Forms.Xaml;

namespace NavigationThroughPages
{
    [XamlCompilation(XamlCompilationOptions.Compile)]
    public partial class Page1 : ContentView
    {
        public Page1()
        {
            InitializeComponent();
        }

        private void GoToPage2_Clicked(object sender, EventArgs e)
        {
            Navigation.PushAsync(new TabbedPage());
        }
    }
}