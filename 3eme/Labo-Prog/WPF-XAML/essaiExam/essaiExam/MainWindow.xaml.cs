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
using essaiExam.MVVM;
using System.Globalization;

namespace essaiExam
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        public List<getRestaurants_Result> Restaurants { get; set; }

        public Info2020Entities entity = new Info2020Entities();

        public MainWindow()
        {
            this.Restaurants = new List<getRestaurants_Result>();
            this.FillRestaurantsList();

            InitializeComponent();
        }

        private void FillRestaurantsList()
        {
            var response = entity.getRestaurants().ToList();
            if(response.Count != 0)
            {
                foreach(var elem in response)
                {
                    this.Restaurants.Add(new getRestaurants_Result { NomResto = elem.NomResto, RestoId = elem.RestoId, Adresse = elem.Adresse, Evaluation = elem.Evaluation, NomCat = elem.NomCat, Photo = elem.Photo, Telephone = elem.Telephone});
                }
            }
        }

        private void NavigationLB_SelectionChanged(object sender, SelectionChangedEventArgs e)
        {

        }
    }
    public class DefaultImageConverter : IValueConverter
    {
        public object Convert(object value, Type targetType, object parameter, CultureInfo culture)
        {
            getRestaurants_Result temp = value as getRestaurants_Result;

            return @"C:\Users\riche\Documents\progHELHA\3eme\Labo-Prog\WPF-XAML\essaiExam\essaiExam\Resources\etoiles" + temp.Evaluation + ".png";
        }

        public object ConvertBack(object value, Type targetType, object parameter, CultureInfo culture)
        {
            throw new NotImplementedException();
        }
    }
}
