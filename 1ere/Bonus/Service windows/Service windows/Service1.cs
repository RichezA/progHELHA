using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Diagnostics;
using System.Linq;
using System.ServiceProcess;
using System.Text;
using System.Threading.Tasks;
using System.Threading;

namespace Service_windows
{
    public partial class Service1 : ServiceBase
    {
        Thread myThread;
        private static bool sortieDuThread = false;

        public Service1()
        {
            InitializeComponent();
        }

        private void Traitement()
        {
            while (!sortieDuThread)
            {

            }
        }

        protected override void OnStart(string[] args)
        {
            myThread = new Thread(new ThreadStart(Traitement));
            myThread.Priority = ThreadPriority.Lowest;
            myThread.Start();
        }

        protected override void OnStop()
        {
            sortieDuThread = true;
        }
    }
}
