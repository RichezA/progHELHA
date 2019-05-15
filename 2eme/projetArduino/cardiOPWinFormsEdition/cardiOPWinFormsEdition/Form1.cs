using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.IO.Ports;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Threading;

namespace cardiOPWinFormsEdition
{
    public partial class Form1 : Form
    {
        SerialPort serialPort;
        public Form1()
        {
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {
        }

        private void ConnectBtn_Click(object sender, EventArgs e)
        {
            for (int i = 0; i < 100; i++) beatsPerMinuteTB.Text = i.ToString();
            beatsPerMinuteTB.Text = "Initializing...\n";
            String sPort = checkIfTBGoodFormat();
            try
            {
                serialPort = new SerialPort(sPort, 115200);
                serialPort.DataReceived += onDataReceived;
                serialPort.Open();
            }
            catch (Exception exception)
            {
                Console.WriteLine(exception.Message);
            }
            
        }

        private void onDataReceived(object sender, SerialDataReceivedEventArgs e)
        {
            SerialData data = (SerialData) sender;
        }

        private String checkIfTBGoodFormat()
        {
            String bpm = comPortTB.Text;
            if (bpm.Contains("COM")) return bpm;
            throw new Exception();
        }

        private void Form1_FormClosing(object sender, FormClosingEventArgs e)
        {
            serialPort.Close();
        }
    }
}
