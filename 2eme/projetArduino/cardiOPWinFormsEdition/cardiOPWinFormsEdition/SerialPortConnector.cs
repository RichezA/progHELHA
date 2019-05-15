using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace cardiOPWinFormsEdition
{
    class SerialPortConnector
    {
        private string portName;
        private int baudRate;

        public SerialPortConnector(String portName, int baudRate = 115200)
        {
            this.portName = portName;
            this.baudRate = baudRate;
        }
    }
}
