using ClientListWPF.MVVM;
using Microsoft.Win32;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net.Http;
using System.Security.Cryptography;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Shapes;

namespace ClientListWPF
{
    /// <summary>
    /// Interaction logic for AuthWindow.xaml
    /// </summary>
    public partial class AuthWindow : Window
    {
        public User currentUser { get; set; }
        public Boolean isAuthenticated { get; set; }
        private MainWindow mainWindow { get; set; }
        public object NavigationService { get; private set; }

        public AuthWindow()
        {
            isAuthenticated = false;
            currentUser = new User();
            this.DataContext = currentUser;
            InitializeComponent();
        }

        private async Task<bool> Validate(String username, String password)
        {
            // Contact the api with the credentials and check if it's ok
            bool authenticationGranted = false;
            using(var httpClient = new HttpClient())
            {
                //var response = await httpClient.PostAsync(@"https://localhost:44391/api/login/", ));
                //if (response.IsSuccessStatusCode)
                //{
                //    authenticationGranted = await response.Content.ReadAsAsync<bool>();
                //}
            }
            return authenticationGranted;
        }

        private async void loginBtn_Click(object sender, RoutedEventArgs e)
        {
            var result = await Validate(currentUser.Username, GetHashCode(currentUser.Password));
            if (result)
            {
                // OK
                isAuthenticated = true;
                mainWindow = new MainWindow();
                mainWindow.Show();
                this.Close();
            }
            else
            {
                MessageBox.Show("User not found", "Log in confirmation", MessageBoxButton.OKCancel);
            }
            Application.Current.MainWindow.Close();
        }

        private String GetHashCode(string password)
        {
            SHA256 hash = SHA256.Create();
            var Hash = hash.ComputeHash(Encoding.UTF8.GetBytes(password));
            StringBuilder sbHash = new StringBuilder();
            for (int i = 0; i < Hash.Length; i++)
            {
                sbHash.Append(Hash[i].ToString("X2"));
            }
            return sbHash.ToString();
        }

        private void Window_Closed(object sender, EventArgs e)
        {
            if (!this.isAuthenticated)
            {
                Application.Current.Shutdown();
            }
            else
            {
                mainWindow = new MainWindow();
                mainWindow.Show();
                this.Close();
            }
        }
    }
}
