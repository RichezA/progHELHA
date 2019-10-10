using System;
using System.Collections.Generic;
using System.Net.Http;
using System.Text;
using System.Threading.Tasks;
using System.Threading;

namespace FirstApp
{
    static class WebClient
    {
        static HttpClient HttpClient = new HttpClient();
        static String apiURL = "http://192.168.137.82:45455/api/values/";


        public static async Task<List<User>> GetSampleUsers()
        {

            List<User> users = new List<User>();
            HttpResponseMessage response = await HttpClient.GetAsync(apiURL + "values");
            if (response.IsSuccessStatusCode)
            {
                users = await response.Content.ReadAsAsync<List<User>>();
            }
            return users;
        }

        public static async Task<User> getUserById(string id)
        {
            User user = null;
            //Thread thread = new Thread(async () =>
            //{
            //    Console.WriteLine("DEBUG - entered the getUserById method");
            //    HttpResponseMessage response = await HttpClient.GetAsync(apiURL + ("values/{0}", id));
            //    if (response.IsSuccessStatusCode) user = await response.Content.ReadAsAsync<User>();
            //    Console.WriteLine("{0} : {1} : {2}", user.id, user.nom, user.prenom);
            //});
            //thread.Start();
            //thread.Join();
            HttpResponseMessage response = await HttpClient.GetAsync(apiURL + id);
            if (response.IsSuccessStatusCode) user = await response.Content.ReadAsAsync<User>();
            return user;
        }
    }
}
