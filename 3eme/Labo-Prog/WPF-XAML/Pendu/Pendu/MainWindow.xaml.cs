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

namespace Pendu
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {

        private String WordToFind = "BONJOUR";
        private int errorNbs = 0;
        private const String imageURL = @"C:\Users\riche\Documents\progHELHA\3eme\Labo-Prog\WPF-XAML\Pendu\Pendu\Images\";

        public MainWindow()
        {
            InitializeComponent();
            this.setButtonsToLetter();
        }


        private void setButtonsToLetter()
        {
            Button btn;

            for (int i = 0; i < WordToFind.Length; i++)
            {
                btn = this.setButton(i);
                this.PenduAffichageLettres.Children.Add(btn);
            }
        }

        private void clearButtonsToFindWord()
        {
            this.PenduAffichageLettres.Children.Clear();
        }

        private Button setButton(int nb)
        {
            Button btn = new Button();
            btn.Width = 50; btn.Height = 50;
            btn.Content = "-";
            btn.Name = "Button" + nb.ToString();
            btn.IsEnabled = false;
            return btn;
        }

        private void Button_Click(object sender, RoutedEventArgs e)
        {
            Char letter = char.ToUpper(this.wordWroteTB.Text.ElementAt(0));
            if (!isCorrectWord(letter))
            {
                this.errorNbs++;
                if (errorNbs < 7) this.PenduImage.Source = new BitmapImage(new Uri(String.Format(imageURL + "Pendu{0}.png", errorNbs)));
                else MessageBox.Show("Vous êtes morts!");
            }
            else
            {
                int indexLetterToShow = WordToFind.IndexOf(letter);
                Button btn;
                foreach(object o in this.PenduAffichageLettres.Children)
                {
                    if(o is Button)
                    {
                        btn = (Button)o;
                        if (btn.Name == String.Format("Button{0}", indexLetterToShow)) btn.Content = letter;
                    } 
                }
            }

            this.wordWroteTB.Clear();
        }

        private Boolean isCorrectWord(Char letter)
        {
            if(WordToFind.Contains(letter)) return true;
            return false;
        }

        private void clearPenduImage()
        {
            this.PenduImage.Source = new BitmapImage(new Uri(""));
        }

        private void Reset()
        {
            MessageBoxResult result =  MessageBox.Show("Vous avez gagné!");

            if (result == MessageBoxResult.OK)
            {
                this.errorNbs = 0;
                this.clearButtonsToFindWord();
                this.clearPenduImage();
            }
        }
    }
}
