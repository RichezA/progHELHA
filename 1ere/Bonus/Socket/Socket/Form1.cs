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
using System.Net.Sockets;
using System.Threading;

namespace Socket
{
    public partial class Form1 : Form
    {
        public TcpListener serverListener;
        public string strIpAdress;
        public int TCPPort;

        public Thread serverThread;

        private static string stoppedText = "Server stopped";
        private static string startedText = "Server started";

        public List<ClientInfo> clientList;

        private Object myLock = new Object();

        public Form1()
        {
            InitializeComponent();

            serverListener = null;
            TCPPort = 8082;
            strIpAdress = "127.0.0.1";

            btStop.Enabled = false;
            tbStatus.Text = stoppedText;

            clientList = new List<ClientInfo>();
        }

        private void btStart_Click(object sender, EventArgs e)
        {
            btStart.Enabled = false;
            btStop.Enabled = true;

            this.serverThread = new Thread(new ThreadStart(TCPServer));
            serverThread.Start();      
        }

        private void btStop_Click(object sender, EventArgs e)
        {
            lock (myLock)
            {
                while (this.clientList.Count != 0)
                {
                    try
                    {
                        var cl = this.clientList[this.clientList.Count - 1];

                        cl.clientTCP.GetStream().Close();
                        cl.clientTCP.Close();
                        this.clientList.Remove(cl);
                    }
                    catch (Exception ex)
                    {
                    }
                };
            }

            serverListener.Stop();

            this.serverListener = null;
            this.serverThread = null;
            
            btStart.Enabled = true;
            btStop.Enabled = false;

            tbStatus.Text = stoppedText;
        }

        private void TCPServer()
        {
            IPAddress myIp = IPAddress.Parse(strIpAdress);
            serverListener = new TcpListener(myIp, TCPPort);
            serverListener.Start();

            tbStatus.Invoke(new Action(() => { tbStatus.Text = startedText; }));
            
            try
            {
                while (true)
                {
                    TcpClient myClient = serverListener.AcceptTcpClient();
                    NetworkStream stream = myClient.GetStream();

                    string msgString = "Bonjour, bienvenue sur mon serveur\r\n";
                    byte[] msg = Encoding.ASCII.GetBytes(msgString);
                    stream.Write(msg, 0, msgString.Length);

                    Thread newClientThread = new Thread(new ParameterizedThreadStart(ClientTCP));
                    ClientInfo newClient = new ClientInfo { clientTCP = myClient, clientThread = newClientThread };
                    clientList.Add(newClient);
                    newClientThread.Start(newClient);

                    //stream.Close();
                    //myClient.Close();
                }
            }
            catch (Exception ex)
            {

            }
            finally
            {

            }
        }

        public void ClientTCP(object client) //On recoit un object et pas un ClientInfo car le parameterizedThreadStart veut un "object".
        {
            ClientInfo myClient = (ClientInfo)client;
            NetworkStream stream = myClient.clientTCP.GetStream();

            Byte[] byteMsg = new Byte[256];
            string completeMsg = null;
            string strData = null;

            int count;

            try
            {
                do
                {
                    count = stream.Read(byteMsg, 0, byteMsg.Length);
                    strData = Encoding.ASCII.GetString(byteMsg, 0, count);
                    completeMsg += strData;
                    if (completeMsg.EndsWith("\r\n", StringComparison.CurrentCulture))
                    {
                        //Je réagis à la commande du client
                        string replyStr = string.Format("Code 200 (Message compris), vous avez dit : {0}\r\n", completeMsg);
                        byte[] replyByteArray = Encoding.ASCII.GetBytes(replyStr);
                        stream.Write(replyByteArray, 0, replyByteArray.Length);

                        if (completeMsg.ToLower() == "quit\r\n")
                        {
                            var quitMsg = Encoding.ASCII.GetBytes("Vous allez quitter...");
                            stream.Write(quitMsg, 0, quitMsg.Length);
                            break;
                        }

                        completeMsg = null;
                    }
                } while (count != 0);

                lock (myLock)
                {
                    stream.Close();
                    myClient.clientTCP.Close();
                    this.clientList.Remove(myClient); 
                }

            }
            catch (Exception ex)
            {

            }

        }

        private void textBox1_TextChanged(object sender, EventArgs e)
        {

        }
    }
}
