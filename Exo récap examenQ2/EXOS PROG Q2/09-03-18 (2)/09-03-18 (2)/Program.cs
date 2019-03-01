using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Net; //On inclut la library necéssaire
using System.Web.Script.Serialization;

namespace _09_03_18__2_
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine(DateTime.Now.ToLongTimeString());
            var data = GetUsersInfo();
            data.Wait();
            Console.WriteLine(DateTime.Now.ToLongTimeString());

            Console.ReadKey(true);
        }

        static async Task<List<UserItem>> GetUsersInfo()
        {
            var client = new WebClient();
            var myUrl = new Uri("https://jsonplaceholder.typicode.com/posts");
            var result = await client.DownloadStringTaskAsync(myUrl);
            var serializer = new JavaScriptSerializer();
            var data = serializer.Deserialize<List<UserItem>>(result);

            return data;
        }
    }
}
