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
using System.Collections.ObjectModel;

namespace essaiExam
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {

        public RestoObject restoObject;

        private Info2020Entities entity = new Info2020Entities();

        public MainWindow()
        {
            //restoObject.Restaurants = new List<getRestauFromCatId_Result>();
            //restoObject.Categories = new List<getRestauCategories_Result>();
            //restoObject.Comments = new List<getCommentsByRestoId_Result>();
            restoObject = new RestoObject();

            this.FillCategoriesList();
            this.FillRestaurantsList(Guid.Empty);

            this.DataContext = restoObject;
            InitializeComponent();
        }

        private void FillRestaurantsList(Guid guid)
        {
            restoObject.Restaurants.Clear();
           if(guid == Guid.Empty)
            {
                var response = entity.getRestauFromCatId(null).ToList();
                restoObject.Restaurants = new ObservableCollection<getRestauFromCatId_Result>(response);
            }
           else
            {
                var response = entity.getRestauFromCatId(guid).ToList();

                restoObject.Restaurants = new ObservableCollection<getRestauFromCatId_Result>(response);
            }
        }

        private void FillCategoriesList()
        {
            var response = entity.getRestauCategories().ToList();
            restoObject.Categories = new ObservableCollection<getRestauCategories_Result>(response);
            restoObject.Categories.Insert(0, restoObject.DefaultCategory);
        }

        private void FillCommentsList(Guid restoID)
        {
            var response = entity.getCommentsByRestoId(restoID).ToList();

            restoObject.Comments = new ObservableCollection<getCommentsByRestoId_Result>(response);
        }

        private void NavigationLB_SelectionChanged(object sender, SelectionChangedEventArgs e)
        {
            var selectedItem = (ListBox)sender;

            getRestauFromCatId_Result selectedRestaurant = (getRestauFromCatId_Result)selectedItem.SelectedItem;
            
            Console.WriteLine(sender);

             this.FillCommentsList(selectedRestaurant.RestoId);
        }

        private void ComboBox_SelectionChanged(object sender, SelectionChangedEventArgs e)
        {
            var selectedCategory = ((ComboBox)sender).SelectedItem;

            if(((getRestauCategories_Result)selectedCategory).CategorieId == Guid.Empty)
            {
                this.FillRestaurantsList(Guid.Empty);
            } else
            {
                this.FillRestaurantsList(((getRestauCategories_Result)selectedCategory).CategorieId);   
            }
            if(this.NavigationLB != null) this.NavigationLB.Items.Refresh();
        }
    }
    public class DefaultImageConverter : IValueConverter
    {
        public object Convert(object value, Type targetType, object parameter, CultureInfo culture)
        {
            getRestauFromCatId_Result temp = value as getRestauFromCatId_Result;

            return @"C:\Users\riche\Documents\progHELHA\3eme\Labo-Prog\WPF-XAML\essaiExam\essaiExam\Resources\etoiles" + temp.Evaluation + ".png";
        }

        public object ConvertBack(object value, Type targetType, object parameter, CultureInfo culture)
        {
            throw new NotImplementedException();
        }
    }

    public class DefaultMvpConverter : IValueConverter
    {
        public object Convert(object value, Type targetType, object parameter, CultureInfo culture)
        {
            getRestauFromCatId_Result temp = value as getRestauFromCatId_Result;

            if (temp.Evaluation > 4) return @"C:\Users\riche\Documents\progHELHA\3eme\Labo-Prog\WPF-XAML\essaiExam\essaiExam\Resources\MVP.png";
            return null;
        }

        public object ConvertBack(object value, Type targetType, object parameter, CultureInfo culture)
        {
            throw new NotImplementedException();
        }
    }
}
