using Plugin.Media;
using Plugin.Media.Abstractions;
using Plugin.Permissions;
using Plugin.Permissions.Abstractions;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Xamarin.Forms;

namespace SendYourFaceOnline
{
    [DesignTimeVisible(false)]
    public partial class MainPage : ContentPage
    {
        public ImageSource imageToSend { get; set; }
        public MainPage()
        {
            InitializeComponent();
            this.BindingContext = this;
        }

        private async void Button_Clicked(object sender, EventArgs e)
        {

            var file = await CrossMedia.Current.TakePhotoAsync(new StoreCameraMediaOptions
            {
                DefaultCamera = CameraDevice.Front,
                Directory = "Sample",
                Name = "test.jpg"
            });

            if(file != null) imageToSend = ImageSource.FromStream(() => file.GetStream());
            img.Source = imageToSend;
        }

    }
}
