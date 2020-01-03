using ClientListWPF.MVVM;
using Microsoft.Win32;
using Newtonsoft.Json;
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
        private Token bearerToken;

        public AuthWindow()
        {
            isAuthenticated = false;
            currentUser = new User();
            bearerToken = null;

            this.DataContext = currentUser;
            InitializeComponent();
        }

        private async Task<String> Validate(String username, String password)
        {
            // Contact the api with the credentials and check if it's ok
            using(var httpClient = new HttpClient())
            {
                var credentials = new List<KeyValuePair<String, String>>();
                credentials.Add(new KeyValuePair<String, String>("Username", username));
                credentials.Add(new KeyValuePair<String, String>("Password", password));
                credentials.Add(new KeyValuePair<String, String>("grant_type", "password"));

                var request = new HttpRequestMessage(HttpMethod.Post, @"https://localhost:44391/token") { Content = new FormUrlEncodedContent(credentials) };
                var response = await httpClient.SendAsync(request);
                if (response.IsSuccessStatusCode)
                {
                    bearerToken= await response.Content.ReadAsAsync<Token>();
                }
            }
            return bearerToken.access_token;
        }

        private async void loginBtn_Click(object sender, RoutedEventArgs e)
        {
            var response = await Validate(currentUser.Username, GetHashCode(currentUser.Password));
            if (response != null)
            {
                // OK
                isAuthenticated = true;
                mainWindow = new MainWindow(response);
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
                mainWindow = new MainWindow(bearerToken.access_token);
                mainWindow.Show();
                this.Close();
            }
        }
    }
}
