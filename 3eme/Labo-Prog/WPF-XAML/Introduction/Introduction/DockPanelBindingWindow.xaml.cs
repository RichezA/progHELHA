using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Timers;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Shapes;

namespace Introduction
{
    /// <summary>
    /// Interaction logic for MainWindo.xaml
    /// </summary>
    public partial class MenuStatusBar : Window
    {
        public Timer RefreshHour;
        public MenuStatusBar()
        {
            InitializeComponent();

            this.heure.Text = DateTime.Now.ToString("HH:mm:ss");
            RefreshHour = new Timer(1000);
            RefreshHour.Elapsed += RefreshHour_Elapsed;
            RefreshHour.Enabled = true;
            RefreshHour.Start();
        }

        void RefreshHour_Elapsed(object sender, ElapsedEventArgs e)
        {
            // BeginInvoke exécute le délégué de façon asynchrone
            this.Dispatcher.BeginInvoke(new Action(() => this.heure.Text = DateTime.Now.ToString("HH:mm:ss")));
            // Action vs Func => Action ne retourne rien
        }
    }
}
