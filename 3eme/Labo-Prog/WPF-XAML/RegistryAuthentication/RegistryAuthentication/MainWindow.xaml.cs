using Microsoft.Win32;
using RegistryAuthentication.Models;
using System;
using System.Collections.Generic;
using System.Linq;
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
using System.Windows.Navigation;
using System.Windows.Shapes;

namespace RegistryAuthentication
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        public User currentUser { get; set; }
        public bool isAuthenticated { get; set; }

        public MainWindow()
        {
            currentUser = new User();
            this.isAuthenticated = false;
            InitializeComponent();
        }

        private bool Validate(String username, String password)
        {
            RegistryKey SoftKey = Registry.CurrentUser.OpenSubKey("Software", true);
            RegistryKey InfoKey = SoftKey.CreateSubKey("Info2020");
            RegistryKey UserKey = InfoKey.OpenSubKey(username);

            if(UserKey != null)
            {
                return (UserKey.GetValue("Password", string.Empty).ToString() == password);
            }
            return false;
        }

        private void btnValidate_Click(object sender, RoutedEventArgs e)
        {
            var result = Validate(currentUser.Username, GetHashCode(currentUser.Password));
            if (result)
            {
                // OK
                MessageBox.Show("Logged In", "Log in confirmation", MessageBoxButton.OKCancel);
            }
            else
            {
                MessageBox.Show("User not found", "Log in confirmation", MessageBoxButton.OKCancel);
            }
        }

        private String GetHashCode(string password)
        {
            SHA256 hash = SHA256.Create();
            var Hash = hash.ComputeHash(Encoding.UTF8.GetBytes(password));
            StringBuilder sbHash = new StringBuilder();
            for(int i = 0; i < Hash.Length; i++)
            {
                sbHash.Append(Hash[i].ToString("X2"));
            }
            return sbHash.ToString();
        }

        private void btnSignup_Click(object sender, RoutedEventArgs e)
        {
            // Check for already used username
            RegistryKey SoftKey = Registry.CurrentUser.OpenSubKey("Software", true);
            RegistryKey InfoKey = SoftKey.CreateSubKey("Info2020");
            RegistryKey UserKey = InfoKey.CreateSubKey(currentUser.Username);
            if (!UserKey.GetValue("Password").Equals(String.Empty))
            {
                MessageBox.Show("There is already someone with this username registered", "Sign up confirmation", MessageBoxButton.OKCancel);
            }
            else
            {
                String passwd = GetHashCode(currentUser.Password);
                UserKey.SetValue("Password", passwd);
            }
        }

        private void Window_Closed(object sender, EventArgs e)
        {
            if(this.isAuthenticated == false)
            {
                Application.Current.Shutdown();
            }
            else
            {

            }
        }
    }
}
