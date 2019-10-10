using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Xamarin.Forms;

namespace FirstApp
{
    // Learn more about making custom code visible in the Xamarin.Forms previewer
    // by visiting https://aka.ms/xamarinforms-previewer
    [DesignTimeVisible(false)]
    public partial class MainPage : ContentPage
    {
        User user;
        public MainPage()
        {
            InitializeComponent();
        }

        private async void Button_Clicked(object sender, EventArgs e)
        {
            //this.myLabel.Text = "Valider";
            //Console.WriteLine(this.myLabel.Text);
            String id = this.userIDToSend.Text;
            Console.WriteLine("DEBUG - just clicked the button");


            user = await GetUser(id);
            if (user != null)
            {
                this.userName.Text = user.prenom;
                this.surName.Text = user.nom;
            }
        }

        private async Task<User> GetUser(String id)
        {
            Console.WriteLine("DEBUG - entered the getuser method");
            return await WebClient.getUserById(id);
        }
    }
}
