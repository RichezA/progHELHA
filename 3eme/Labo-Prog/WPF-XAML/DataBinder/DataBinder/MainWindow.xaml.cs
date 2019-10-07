using DataBinder.MVVM;
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

namespace DataBinder
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        public Client client { get; set; }
        
        public MainWindow()
        {
            //this.DataContext = this; // Pas bien car on mélange les data, vues, etc
            client = new Client { Nom = "Richez", Prenom = "Antoine", Localite = "Tournai" };
            InitializeComponent();
        }

        private void Button_Click(object sender, RoutedEventArgs e)
        {
            // Liaisons = polydirectionnelles, si l'on modifie le prenom, la propriété 'Prenom' de notre client changera elle aussi
            client.Nom = "Dupond";
        }
    }
}
