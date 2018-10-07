using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Threading;
using System.Globalization;

namespace Langue
{
    public partial class Form1 : Form
    {
        public double montant = 10.2;
        public DateTime date = DateTime.Parse("10/02/2010");

        public Form1()
        {
            CultureInfo culture = CultureInfo.CreateSpecificCulture("fr");
            CultureInfo.DefaultThreadCurrentCulture = culture;
            CultureInfo.DefaultThreadCurrentUICulture = culture;

            Thread.CurrentThread.CurrentUICulture = culture;
            Thread.CurrentThread.CurrentCulture = culture;

            InitializeComponent();

            this.Text = "JE JOUE AVEC LES LANGUES";

            this.textBox1.Text = montant.ToString();
            this.dateTb.Text = date.ToShortDateString();

            this.cbCulture.Items.Add(new Culture{ Langue = "en", Nom = "Anglais" });
            this.cbCulture.Items.Add(new Culture{ Langue = "fr", Nom = "Français" });
            this.cbCulture.DisplayMember = "Nom";
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            
        }

        private void btCancel_Click(object sender, EventArgs e)
        {
            Environment.Exit(0);
        }

        private void cbCulture_SelectedIndexChanged(object sender, EventArgs e)
        {
            var nom = ((Culture)this.cbCulture.SelectedItem).Langue;
            Thread.CurrentThread.CurrentCulture = CultureInfo.GetCultureInfo(nom);
            Thread.CurrentThread.CurrentUICulture = CultureInfo.GetCultureInfo(nom);
            ChangeLanguage(nom);
        }

        private void ChangeLanguage(string lang)
        {
            foreach (Control c in this.Controls)
            {
                ComponentResourceManager resources = new ComponentResourceManager();
                resources.ApplyResources(c, c.Name);
            }
        }
    }



    public class Culture
    {
        public string Langue { get; set; }
        public string Nom { get; set; }
    }
}
