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

namespace MultiThread_WinForms
{
    public partial class Form1 : Form
    {
        public int data;

        public Form1()
        {
            InitializeComponent();
            data = 0;
        }

        private void button2_Click(object sender, EventArgs e)
        {
            for(int i = 0; i<20; i++)
            {
                this.textBox1.Text = DateTime.Now.ToLongTimeString();
                Thread.Sleep(5000);
            }
        }

        private void button1_Click(object sender, EventArgs e)
        {
            data++;
            this.textBox2.Text = data.ToString();
        }
    }
}
