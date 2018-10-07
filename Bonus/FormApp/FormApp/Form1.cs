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

namespace FormApp
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            this.Text = "YOLO";
            this.textBox1.Text = "0";
            this.textBox2.Text = "0";
        }

        private void label1_Click(object sender, EventArgs e)
        {

        }

        private void BtAddition_Click(object sender, EventArgs e)
        {
            float? nb1 = null;
            float? nb2 = null;


            try
            {
                nb1 = float.Parse(textBox1.Text);
                nb2 = float.Parse(textBox2.Text);
            }
            catch(Exception ex)
            {

            }

            string result = "Résultat = " + nb1 + " + " + nb2 + " = " + (nb1 + nb2);
            if (nb1 != null && nb2 != null)
            {
                ResultLabel.Text = result;
                MessageBox.Show(result, "L'addition du fou de la street");
            }
        }

        private void About_Click(object sender, EventArgs e)
        {
            AboutForm abtForm = new AboutForm();
            abtForm.ShowDialog();
        }

        private void Exit() { Environment.Exit(0); }

        private void Quit_Click(object sender, EventArgs e) { this.Close(); }

        private void Form1_FormClosing(object sender, FormClosingEventArgs e)
        {
            SaveWhenClose saveForm = new SaveWhenClose();
            saveForm.ShowDialog();

            if (saveForm.DialogResult == DialogResult.Cancel) e.Cancel = true;
            else if (saveForm.DialogResult == DialogResult.Yes) SaveData();
            else Exit();
        }
        
        private void SaveData()
        {

        }
    }
}
