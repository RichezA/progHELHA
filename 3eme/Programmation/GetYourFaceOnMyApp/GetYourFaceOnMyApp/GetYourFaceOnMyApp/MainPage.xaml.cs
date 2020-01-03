using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Xamarin.Forms;
using GetYourFaceOnMyApp.MVVM;
using System.Collections.ObjectModel;
using System.Globalization;

namespace GetYourFaceOnMyApp
{
    // Learn more about making custom code visible in the Xamarin.Forms previewer
    // by visiting https://aka.ms/xamarinforms-previewer


    [DesignTimeVisible(false)]
    public partial class MainPage : ContentPage
    {
        public UserViewModel users { get; set; }
        public UserClientHttp httpClient;

        public MainPage()
        {
            InitializeComponent();
            httpClient = new UserClientHttp();
            users = new UserViewModel();
            this.users.Users = new ObservableCollection<User>();
        }

        protected override async void OnAppearing()
        {
            base.OnAppearing();
            if (this.users.Users.Count == 0)
            {
                GetData();
            }
            this.BindingContext = this;
        }


        private async Task<List<User>> GetUserList()
        {
            var resp = await httpClient.GetUsers();
            return resp.data;
        }

        private async void GetData()
        {
            if (this.users.Users.Count != 0)
            {
                foreach(var photoID in this.users.Users) this.httpClient.DeletePic(photoID.id.ToString());
                this.users.Users.Clear();
                this.users.Images.Clear();
                this.users.UsersData.Clear();
            }
            this.users.Users = new ObservableCollection<User>(await this.GetUserList());
            foreach (var user in users.Users)
            {
                this.users.Images.Add(await httpClient.GetLocalPicture(user.id.ToString()));
            }
            for (int i = 0; i < this.users.Users.Count; i++)
            {
                this.users.UsersData.Add(new Tuple<User, ImageSource>(this.users.Users[i], this.users.Images[i]));
            }
        }

        private void ListView_ItemTapped(object sender, ItemTappedEventArgs e)
        {
            User clickedUser = ((ListView)sender).SelectedItem as User;
        }

        private async void OnMore(object sender, EventArgs e)
        {
            try
            {
                User user = (((MenuItem)sender).CommandParameter as Tuple<User, ImageSource>).Item1;
                var detailedPage = new DetailedPage(user);
                await Navigation.PushAsync(detailedPage);
            }catch(Exception ex)
            {
                Console.WriteLine(ex.Message);
            }
        }

        private void OnDelete(object sender, EventArgs e)
        {
            try
            {
                Tuple<User, ImageSource> userData = ((MenuItem)sender).CommandParameter as Tuple<User, ImageSource>;
                this.users.UsersData.Remove(userData);

            } catch(Exception ex)
            {
                Console.WriteLine(ex.Message);
            }
        }

        private void ListView_Refreshing(object sender, EventArgs e)
        {
            GetData();
            ((ListView)sender).IsRefreshing = false;
        }

        private void SwipeGestureRecognizer_Swiped(object sender, SwipedEventArgs e)
        {
            var temp = (StackLayout)sender;
            //var bc = temp.BindingContext as Tuple<User, ImageSource>;
            //this.users.UsersData.Remove(bc);

            temp.TranslateTo(-40, 0);
        }
    }

    public class StringToUriConverter : IValueConverter
    {
        public object Convert(object value, Type targetType, object parameter, CultureInfo culture)
        {
            //ImageSource imgSrc = null;
            //async () => imgSrc = await UserClientHttp.getImageFromUri(value as String);
            //loadImg();
            //return new Func<ImageSource>(async () => await UserClientHttp.getImageFromUri(value as String));
            return null;
        }

        public object ConvertBack(object value, Type targetType, object parameter, CultureInfo culture)
        {
            throw new NotImplementedException();
        }
    }
}
