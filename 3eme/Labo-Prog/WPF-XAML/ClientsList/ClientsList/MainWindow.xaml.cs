using ClientsList.MVVM;
using System;
using System.Collections.Generic;
using System.Globalization;
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

namespace ClientsList
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        public Client CurrentClient { get; set; }
        public List<Client> ClientsList { get; set; }

        public Info2020Entities entity = new Info2020Entities();
        public MainWindow()
        {
            this.DataContext = this; // Pas bien car on mélange les data, vues, etc
            CurrentClient = new Client { Nom = " ", Prenom = " ", Localite = " " };
            ClientsList = new List<Client>();

            
            var response = entity.GetNameXAMLClients().ToList();
            if( response.Count != 0)
            {
                for (int i = 0; i < response.Count; i++)
                {
                    ClientsList.Add(new Client { Nom = response[i].Nom, Prenom = response[i].Prenom, ClientId = response[i].clientID, Image = response[i].Image });
                }
            }
            InitializeComponent();
            
        }
        
        private void Button_Click(object sender, RoutedEventArgs e)
        {
            // Liaisons = polydirectionnelles, si l'on modifie le prenom, la propriété 'Prenom' de notre client changera elle aussi
            CurrentClient.Nom = "Dupond";
        }

        private void navigationLB_SelectionChanged(object sender, SelectionChangedEventArgs e)
        {
            int Index = this.navigationLB.SelectedIndex;
            Client ItemData;
            if(Index != -1)
            {
                ItemData = (Client) this.navigationLB.Items[Index];
                this.retrieveClientInfo(ItemData.ClientId);
            }
        }

        private void retrieveClientInfo(Guid ClientID)
        {
            var response = entity.GetXAMLClientByInfo(ClientID).ToList();
            if(response.Count == 1)
            {
                CurrentClient.Nom = response[0].Nom;
                CurrentClient.Prenom = response[0].Prenom;
                CurrentClient.Localite = response[0].Localite;
            }
            else
            {
                Console.WriteLine("Error");
            }
        }
    }
    public class DefaultImageConverter : IValueConverter
    {
        public object Convert(object value, Type targetType, object parameter, CultureInfo culture)
        {
            if (value != null) return value;
            else return @"C:\Users\riche\Pictures\téléchargement.png";
        }

        public object ConvertBack(object value, Type targetType, object parameter, CultureInfo culture)
        {
            throw new NotImplementedException();
        }
    }

    public class PropertyDataTemplateSelector : DataTemplateSelector
    {
        public DataTemplate DefaultnDataTemplate { get; set; }
        public DataTemplate LocalnDataTemplate { get; set; }

        public override DataTemplate SelectTemplate(object item, DependencyObject container)
        {
            Client itemData = (Client)item;

            if (itemData.Image != null) return DefaultnDataTemplate;
            return LocalnDataTemplate;
        }
    }
}
