using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Net;
using System.Threading;
using System.Web.Script;
using System.Web.Script.Serialization;

namespace _12_03_18_WForms
{
    public partial class Form1 : Form //Héritage d'une form avec des propriétés de base
    {
        private Thread threadJSON;

        public Form1()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            threadJSON = new Thread(new ThreadStart(GetJson));
            threadJSON.Start();
            this.button1.Enabled = false;
        }

        private void GetJson()
        {
            using (var client = new WebClient())
            {
                Uri WebApiUri = new Uri("https://jsonplaceholder.typicode.com/posts");
                var json = client.DownloadString(WebApiUri);
                var serializer = new JavaScriptSerializer();
                var datacsharp = serializer.Deserialize<List<UserItem>>(json);

                this.textBox1.Invoke((Action)(() =>
                {
                    this.textBox1.Text = datacsharp.Count.ToString();
                }));
            }
        }

        private void button2_Click(object sender, EventArgs e)
        {
            this.textBox1.Text = null;
            this.button1.Enabled = true;
        }
    }
}
