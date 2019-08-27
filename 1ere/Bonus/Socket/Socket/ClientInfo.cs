using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Net;
using System.Net.Sockets;
using System.Threading;

namespace Socket
{
    public class ClientInfo
    {
        public TcpClient clientTCP { get; set; }
        public Thread clientThread{ get; set; }
       
    }
}
