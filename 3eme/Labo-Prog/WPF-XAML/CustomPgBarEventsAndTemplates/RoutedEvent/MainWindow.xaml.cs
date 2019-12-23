using System;
using System.Collections.Generic;
using System.Linq;
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

namespace RoutedEventPgb
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        public String Nom { get; set; }
        public MainWindow()
        {
            Nom = "Antoine";
            InitializeComponent();
            this.Pgb.Alert += Pgb_Alert;
            this.DataContext = this;
        }

        private void Pgb_Alert(object sender, RoutedEventArgs e)
        {
            MessageBox.Show("Alert");
        }

        // Autre façon de faire
        private void Pgb_Alert_1(object sender, RoutedEventArgs e)
        {
            MessageBox.Show("ALERT DIRECTLY FROM COMPONENT");
        }
    }
}
